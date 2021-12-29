// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.entity.PartEntity;
import twilightforest.entity.TFPart;
import net.minecraft.network.protocol.game.ClientboundAddMobPacket;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.ThrowSpikeBlockGoal;
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.AvoidAnyEntityGoal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.Chain;
import twilightforest.entity.SpikeBlock;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import java.util.UUID;
import net.minecraft.world.entity.monster.Monster;

public class BlockChainGoblin extends Monster
{
    private static final UUID MODIFIER_UUID;
    private static final AttributeModifier MODIFIER;
    private static final float CHAIN_SPEED = 16.0f;
    private static final EntityDataAccessor<Byte> DATA_CHAINLENGTH;
    private static final EntityDataAccessor<Byte> DATA_CHAINPOS;
    private static final EntityDataAccessor<Boolean> IS_THROWING;
    private int recoilCounter;
    private float chainAngle;
    private float chainMoveLength;
    public final SpikeBlock block;
    public final Chain chain1;
    public final Chain chain2;
    public final Chain chain3;
    private MultipartGenericsAreDumb[] partsArray;
    
    public BlockChainGoblin(final EntityType<? extends BlockChainGoblin> type, final Level world) {
        super((EntityType)type, world);
        this.block = new SpikeBlock((Entity)this);
        this.chain1 = new Chain((Entity)this);
        this.chain2 = new Chain((Entity)this);
        this.chain3 = new Chain((Entity)this);
        this.partsArray = new MultipartGenericsAreDumb[] { this.block, this.chain1, this.chain2, this.chain3 };
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new AvoidAnyEntityGoal<Object>((PathfinderMob)this, PrimedTnt.class, 2.0f, 1.0, 2.0));
        this.f_21345_.m_25352_(4, (Goal)new ThrowSpikeBlockGoal(this, this.block));
        this.f_21345_.m_25352_(5, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)BlockChainGoblin.DATA_CHAINLENGTH, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)BlockChainGoblin.DATA_CHAINPOS, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)BlockChainGoblin.IS_THROWING, (Object)false);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, 0.28).m_22268_(Attributes.f_22281_, 8.0).m_22268_(Attributes.f_22284_, 11.0);
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.78f;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.BLOCKCHAIN_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.BLOCKCHAIN_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.BLOCKCHAIN_DEATH;
    }
    
    public double getChainYOffset() {
        return 1.5 - this.getChainLength() / 4.0;
    }
    
    public Vec3 getChainPosition() {
        return this.getChainPosition(this.getChainAngle(), this.getChainLength());
    }
    
    public Vec3 getChainPosition(final float angle, final float distance) {
        final double dx = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dz = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vec3(this.m_20185_() + dx, this.m_20186_() + this.getChainYOffset(), this.m_20189_() + dz);
    }
    
    public boolean isSwingingChain() {
        return this.f_20911_ || (this.m_5448_() != null && this.recoilCounter == 0);
    }
    
    public boolean m_7327_(final Entity entity) {
        this.m_6674_(InteractionHand.MAIN_HAND);
        entity.m_6469_(TFDamageSources.spiked((Entity)this.block, (LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_));
        return false;
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.block.m_8119_();
        this.chain1.m_8119_();
        this.chain2.m_8119_();
        this.chain3.m_8119_();
        if (this.recoilCounter > 0) {
            --this.recoilCounter;
        }
        this.chainAngle += 16.0f;
        this.chainAngle %= 360.0f;
        if (!this.f_19853_.f_46443_) {
            this.f_19804_.m_135381_((EntityDataAccessor)BlockChainGoblin.DATA_CHAINLENGTH, (Object)(byte)Math.floor(this.getChainLength() * 127.0f));
            this.f_19804_.m_135381_((EntityDataAccessor)BlockChainGoblin.DATA_CHAINPOS, (Object)(byte)Math.floor(this.getChainAngle() / 360.0f * 255.0f));
        }
        else if (Math.abs(this.chainAngle - this.getChainAngle()) > 32.0f) {
            this.chainAngle = this.getChainAngle();
        }
        if (this.chainMoveLength > 0.0f) {
            final Vec3 blockPos = this.getThrowPos();
            final double sx2 = this.m_20185_();
            final double sy2 = this.m_20186_() + this.m_20206_() - 0.1;
            final double sz2 = this.m_20189_();
            final double ox2 = sx2 - blockPos.f_82479_;
            final double oy2 = sy2 - blockPos.f_82480_ - 0.25;
            final double oz2 = sz2 - blockPos.f_82481_;
            if (this.chainMoveLength >= 6.0f || !this.m_6084_()) {
                this.setThrowing(false);
            }
            this.chain1.m_6034_(sx2 - ox2 * 0.25, sy2 - oy2 * 0.25, sz2 - oz2 * 0.25);
            this.chain2.m_6034_(sx2 - ox2 * 0.5, sy2 - oy2 * 0.5, sz2 - oz2 * 0.5);
            this.chain3.m_6034_(sx2 - ox2 * 0.85, sy2 - oy2 * 0.85, sz2 - oz2 * 0.85);
            this.block.m_6034_(sx2 - ox2, sy2 - oy2, sz2 - oz2);
        }
        else {
            final Vec3 blockPos = this.getChainPosition();
            this.block.m_6034_(blockPos.f_82479_, blockPos.f_82480_, blockPos.f_82481_);
            this.block.m_146922_(this.getChainAngle());
            final double sx3 = this.m_20185_();
            final double sy3 = this.m_20186_() + this.m_20206_() - 0.1;
            final double sz3 = this.m_20189_();
            final double ox3 = sx3 - blockPos.f_82479_;
            final double oy3 = sy3 - blockPos.f_82480_ - this.block.m_20206_() / 3.0;
            final double oz3 = sz3 - blockPos.f_82481_;
            this.chain1.m_6034_(sx3 - ox3 * 0.4, sy3 - oy3 * 0.4, sz3 - oz3 * 0.4);
            this.chain2.m_6034_(sx3 - ox3 * 0.5, sy3 - oy3 * 0.5, sz3 - oz3 * 0.5);
            this.chain3.m_6034_(sx3 - ox3 * 0.6, sy3 - oy3 * 0.6, sz3 - oz3 * 0.6);
        }
        if (!this.f_19853_.f_46443_ && (this.isThrowing() || this.isSwingingChain())) {
            this.applyBlockCollisions((Entity)this.block);
        }
        this.chainMove();
    }
    
    private Vec3 getThrowPos() {
        final Vec3 vec3d = this.m_20252_(1.0f);
        return new Vec3(this.m_20185_() + vec3d.f_82479_ * this.chainMoveLength, this.m_20186_() + this.m_20192_(), this.m_20189_() + vec3d.f_82481_ * this.chainMoveLength);
    }
    
    private void chainMove() {
        if (this.isThrowing()) {
            this.chainMoveLength = Mth.m_14036_(this.chainMoveLength + 0.5f, 0.0f, 6.0f);
        }
        else {
            this.chainMoveLength = Mth.m_14036_(this.chainMoveLength - 1.5f, 0.0f, 6.0f);
        }
    }
    
    public float getChainMoveLength() {
        return this.chainMoveLength;
    }
    
    protected void applyBlockCollisions(final Entity collider) {
        final List<Entity> list = this.f_19853_.m_45933_(collider, collider.m_142469_().m_82377_(0.20000000298023224, 0.0, 0.20000000298023224));
        for (final Entity entity : list) {
            if (entity.m_6094_()) {
                this.applyBlockCollision(collider, entity);
            }
        }
        if (this.isThrowing() && collider.m_5830_()) {
            this.setThrowing(false);
            collider.m_5496_(TFSounds.BLOCKCHAIN_COLLIDE, 0.65f, 0.75f);
        }
    }
    
    protected void applyBlockCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.m_7334_(collider);
            if (collided instanceof LivingEntity && super.m_7327_(collided)) {
                collided.m_5997_(0.0, 0.4, 0.0);
                this.m_5496_(TFSounds.BLOCKCHAIN_HIT, 1.0f, 1.0f);
                this.recoilCounter = 40;
                if (this.isThrowing()) {
                    this.setThrowing(false);
                }
            }
        }
    }
    
    public boolean isThrowing() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)BlockChainGoblin.IS_THROWING);
    }
    
    public void setThrowing(final boolean isThrowing) {
        this.f_19804_.m_135381_((EntityDataAccessor)BlockChainGoblin.IS_THROWING, (Object)isThrowing);
    }
    
    private float getChainAngle() {
        if (!this.f_19853_.f_46443_) {
            return this.chainAngle;
        }
        return ((byte)this.f_19804_.m_135370_((EntityDataAccessor)BlockChainGoblin.DATA_CHAINPOS) & 0xFF) / 255.0f * 360.0f;
    }
    
    private float getChainLength() {
        if (this.f_19853_.f_46443_) {
            return ((byte)this.f_19804_.m_135370_((EntityDataAccessor)BlockChainGoblin.DATA_CHAINLENGTH) & 0xFF) / 127.0f;
        }
        if (this.isSwingingChain()) {
            return 0.9f;
        }
        return 0.3f;
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    public void m_142223_(final ClientboundAddMobPacket p_147206_) {
        super.m_142223_(p_147206_);
        TFPart.assignPartIDs((Entity)this);
    }
    
    public MultipartGenericsAreDumb[] getParts() {
        return this.partsArray;
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
        MODIFIER = new AttributeModifier(BlockChainGoblin.MODIFIER_UUID, "speedPenalty", -0.25, AttributeModifier.Operation.ADDITION);
        DATA_CHAINLENGTH = SynchedEntityData.m_135353_((Class)BlockChainGoblin.class, EntityDataSerializers.f_135027_);
        DATA_CHAINPOS = SynchedEntityData.m_135353_((Class)BlockChainGoblin.class, EntityDataSerializers.f_135027_);
        IS_THROWING = SynchedEntityData.m_135353_((Class)BlockChainGoblin.class, EntityDataSerializers.f_135035_);
    }
    
    public abstract static class MultipartGenericsAreDumb extends TFPart<Entity>
    {
        public MultipartGenericsAreDumb(final Entity parent) {
            super(parent);
        }
    }
}
