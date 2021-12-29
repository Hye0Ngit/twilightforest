// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.entity.PartEntity;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.ThrowSpikeBlockGoal;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.AvoidAnyEntityGoal;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import java.util.UUID;
import net.minecraft.entity.monster.MonsterEntity;

public class BlockChainGoblinEntity extends MonsterEntity
{
    private static final UUID MODIFIER_UUID;
    private static final AttributeModifier MODIFIER;
    private static final float CHAIN_SPEED = 16.0f;
    private static final DataParameter<Byte> DATA_CHAINLENGTH;
    private static final DataParameter<Byte> DATA_CHAINPOS;
    private static final DataParameter<Boolean> IS_THROWING;
    private int recoilCounter;
    private float chainAngle;
    private float chainMoveLength;
    public final SpikeBlockEntity block;
    public final ChainEntity chain1;
    public final ChainEntity chain2;
    public final ChainEntity chain3;
    private MultipartGenericsAreDumb[] partsArray;
    
    public BlockChainGoblinEntity(final EntityType<? extends BlockChainGoblinEntity> type, final World world) {
        super((EntityType)type, world);
        this.block = new SpikeBlockEntity((Entity)this);
        this.chain1 = new ChainEntity((Entity)this);
        this.chain2 = new ChainEntity((Entity)this);
        this.chain3 = new ChainEntity((Entity)this);
        this.partsArray = new MultipartGenericsAreDumb[] { this.block, this.chain1, this.chain2, this.chain3 };
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new AvoidAnyEntityGoal<Object>((CreatureEntity)this, TNTEntity.class, 2.0f, 1.0, 2.0));
        this.field_70714_bg.func_75776_a(4, (Goal)new ThrowSpikeBlockGoal(this, this.block));
        this.field_70714_bg.func_75776_a(5, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)BlockChainGoblinEntity.DATA_CHAINLENGTH, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)BlockChainGoblinEntity.DATA_CHAINPOS, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)BlockChainGoblinEntity.IS_THROWING, (Object)false);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 20.0).func_233815_a_(Attributes.field_233821_d_, 0.28).func_233815_a_(Attributes.field_233823_f_, 8.0).func_233815_a_(Attributes.field_233826_i_, 11.0);
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.78f;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.BLOCKCHAIN_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.BLOCKCHAIN_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.BLOCKCHAIN_DEATH;
    }
    
    public double getChainYOffset() {
        return 1.5 - this.getChainLength() / 4.0;
    }
    
    public Vector3d getChainPosition() {
        return this.getChainPosition(this.getChainAngle(), this.getChainLength());
    }
    
    public Vector3d getChainPosition(final float angle, final float distance) {
        final double dx = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dz = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vector3d(this.func_226277_ct_() + dx, this.func_226278_cu_() + this.getChainYOffset(), this.func_226281_cx_() + dz);
    }
    
    public boolean isSwingingChain() {
        return this.field_82175_bq || (this.func_70638_az() != null && this.recoilCounter == 0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        this.func_184609_a(Hand.MAIN_HAND);
        entity.func_70097_a(TFDamageSources.SPIKED((Entity)this.block, (LivingEntity)this), (float)this.func_233637_b_(Attributes.field_233823_f_));
        return false;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.block.func_70071_h_();
        this.chain1.func_70071_h_();
        this.chain2.func_70071_h_();
        this.chain3.func_70071_h_();
        if (this.recoilCounter > 0) {
            --this.recoilCounter;
        }
        this.chainAngle += 16.0f;
        this.chainAngle %= 360.0f;
        if (!this.field_70170_p.field_72995_K) {
            this.field_70180_af.func_187227_b((DataParameter)BlockChainGoblinEntity.DATA_CHAINLENGTH, (Object)(byte)Math.floor(this.getChainLength() * 127.0f));
            this.field_70180_af.func_187227_b((DataParameter)BlockChainGoblinEntity.DATA_CHAINPOS, (Object)(byte)Math.floor(this.getChainAngle() / 360.0f * 255.0f));
        }
        else if (Math.abs(this.chainAngle - this.getChainAngle()) > 32.0f) {
            this.chainAngle = this.getChainAngle();
        }
        if (this.chainMoveLength > 0.0f) {
            final Vector3d blockPos = this.getThrowPos();
            final double sx2 = this.func_226277_ct_();
            final double sy2 = this.func_226278_cu_() + this.func_213302_cg() - 0.1;
            final double sz2 = this.func_226281_cx_();
            final double ox2 = sx2 - blockPos.field_72450_a;
            final double oy2 = sy2 - blockPos.field_72448_b - 0.25;
            final double oz2 = sz2 - blockPos.field_72449_c;
            if (this.chainMoveLength >= 6.0f || !this.func_70089_S()) {
                this.setThrowing(false);
            }
            this.chain1.func_70107_b(sx2 - ox2 * 0.25, sy2 - oy2 * 0.25, sz2 - oz2 * 0.25);
            this.chain2.func_70107_b(sx2 - ox2 * 0.5, sy2 - oy2 * 0.5, sz2 - oz2 * 0.5);
            this.chain3.func_70107_b(sx2 - ox2 * 0.85, sy2 - oy2 * 0.85, sz2 - oz2 * 0.85);
            this.block.func_70107_b(sx2 - ox2, sy2 - oy2, sz2 - oz2);
        }
        else {
            final Vector3d blockPos = this.getChainPosition();
            this.block.func_70107_b(blockPos.field_72450_a, blockPos.field_72448_b, blockPos.field_72449_c);
            this.block.field_70177_z = this.getChainAngle();
            final double sx3 = this.func_226277_ct_();
            final double sy3 = this.func_226278_cu_() + this.func_213302_cg() - 0.1;
            final double sz3 = this.func_226281_cx_();
            final double ox3 = sx3 - blockPos.field_72450_a;
            final double oy3 = sy3 - blockPos.field_72448_b - this.block.func_213302_cg() / 3.0;
            final double oz3 = sz3 - blockPos.field_72449_c;
            this.chain1.func_70107_b(sx3 - ox3 * 0.4, sy3 - oy3 * 0.4, sz3 - oz3 * 0.4);
            this.chain2.func_70107_b(sx3 - ox3 * 0.5, sy3 - oy3 * 0.5, sz3 - oz3 * 0.5);
            this.chain3.func_70107_b(sx3 - ox3 * 0.6, sy3 - oy3 * 0.6, sz3 - oz3 * 0.6);
        }
        if (!this.field_70170_p.field_72995_K && (this.isThrowing() || this.isSwingingChain())) {
            this.applyBlockCollisions((Entity)this.block);
        }
        this.chainMove();
    }
    
    private Vector3d getThrowPos() {
        final Vector3d vec3d = this.func_70676_i(1.0f);
        return new Vector3d(this.func_226277_ct_() + vec3d.field_72450_a * this.chainMoveLength, this.func_226278_cu_() + this.func_70047_e(), this.func_226281_cx_() + vec3d.field_72449_c * this.chainMoveLength);
    }
    
    private void chainMove() {
        if (this.isThrowing()) {
            this.chainMoveLength = MathHelper.func_76131_a(this.chainMoveLength + 0.5f, 0.0f, 6.0f);
        }
        else {
            this.chainMoveLength = MathHelper.func_76131_a(this.chainMoveLength - 1.5f, 0.0f, 6.0f);
        }
    }
    
    public float getChainMoveLength() {
        return this.chainMoveLength;
    }
    
    protected void applyBlockCollisions(final Entity collider) {
        final List<Entity> list = this.field_70170_p.func_72839_b(collider, collider.func_174813_aQ().func_72314_b(0.20000000298023224, 0.0, 0.20000000298023224));
        for (final Entity entity : list) {
            if (entity.func_70104_M()) {
                this.applyBlockCollision(collider, entity);
            }
        }
        if (this.isThrowing() && collider.func_70094_T()) {
            this.setThrowing(false);
            collider.func_184185_a(TFSounds.BLOCKCHAIN_COLLIDE, 0.65f, 0.75f);
        }
    }
    
    protected void applyBlockCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.func_70108_f(collider);
            if (collided instanceof LivingEntity && super.func_70652_k(collided)) {
                collided.func_70024_g(0.0, 0.4, 0.0);
                this.func_184185_a(TFSounds.BLOCKCHAIN_HIT, 1.0f, 1.0f);
                this.recoilCounter = 40;
                if (this.isThrowing()) {
                    this.setThrowing(false);
                }
            }
        }
    }
    
    public boolean isThrowing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)BlockChainGoblinEntity.IS_THROWING);
    }
    
    public void setThrowing(final boolean isThrowing) {
        this.field_70180_af.func_187227_b((DataParameter)BlockChainGoblinEntity.IS_THROWING, (Object)isThrowing);
    }
    
    private float getChainAngle() {
        if (!this.field_70170_p.field_72995_K) {
            return this.chainAngle;
        }
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)BlockChainGoblinEntity.DATA_CHAINPOS) & 0xFF) / 255.0f * 360.0f;
    }
    
    private float getChainLength() {
        if (this.field_70170_p.field_72995_K) {
            return ((byte)this.field_70180_af.func_187225_a((DataParameter)BlockChainGoblinEntity.DATA_CHAINLENGTH) & 0xFF) / 127.0f;
        }
        if (this.isSwingingChain()) {
            return 0.9f;
        }
        return 0.3f;
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    public MultipartGenericsAreDumb[] getParts() {
        return this.partsArray;
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
        MODIFIER = new AttributeModifier(BlockChainGoblinEntity.MODIFIER_UUID, "speedPenalty", -0.25, AttributeModifier.Operation.ADDITION);
        DATA_CHAINLENGTH = EntityDataManager.func_187226_a((Class)BlockChainGoblinEntity.class, DataSerializers.field_187191_a);
        DATA_CHAINPOS = EntityDataManager.func_187226_a((Class)BlockChainGoblinEntity.class, DataSerializers.field_187191_a);
        IS_THROWING = EntityDataManager.func_187226_a((Class)BlockChainGoblinEntity.class, DataSerializers.field_187198_h);
    }
    
    abstract static class MultipartGenericsAreDumb extends TFPartEntity<Entity>
    {
        public MultipartGenericsAreDumb(final Entity parent) {
            super(parent);
        }
    }
}
