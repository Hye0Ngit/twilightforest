// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.EntityLivingBase;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import twilightforest.entity.ai.EntityAIThrowSpikeBlock;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import java.util.UUID;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFBlockGoblin extends EntityMob implements IEntityMultiPart
{
    private static final UUID MODIFIER_UUID;
    private static final AttributeModifier MODIFIER;
    public static final ResourceLocation LOOT_TABLE;
    private static final float CHAIN_SPEED = 16.0f;
    private static final DataParameter<Byte> DATA_CHAINLENGTH;
    private static final DataParameter<Byte> DATA_CHAINPOS;
    private static final DataParameter<Boolean> IS_THROWING;
    private int recoilCounter;
    private float chainAngle;
    private float chainMoveLength;
    public final EntityTFSpikeBlock block;
    public final EntityTFGoblinChain chain1;
    public final EntityTFGoblinChain chain2;
    public final EntityTFGoblinChain chain3;
    private final Entity[] partsArray;
    
    public EntityTFBlockGoblin(final World world) {
        super(world);
        this.block = new EntityTFSpikeBlock(this);
        this.chain1 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain2 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain3 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.partsArray = new Entity[] { this.block, (Entity)this.chain1, (Entity)this.chain2, (Entity)this.chain3 };
        this.func_70105_a(0.9f, 1.4f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityTNTPrimed.class, 2.0f, 0.800000011920929, 1.5));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIThrowSpikeBlock(this, this.block));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFBlockGoblin.DATA_CHAINLENGTH, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFBlockGoblin.DATA_CHAINPOS, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFBlockGoblin.IS_THROWING, (Object)false);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0);
        this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(11.0);
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.78f;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.REDCAP_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.REDCAP_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.REDCAP_AMBIENT;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFBlockGoblin.LOOT_TABLE;
    }
    
    public double getChainYOffset() {
        return 1.5 - this.getChainLength() / 4.0;
    }
    
    public Vec3d getChainPosition() {
        return this.getChainPosition(this.getChainAngle(), this.getChainLength());
    }
    
    public Vec3d getChainPosition(final float angle, final float distance) {
        final double dx = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dz = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vec3d(this.field_70165_t + dx, this.field_70163_u + this.getChainYOffset(), this.field_70161_v + dz);
    }
    
    public boolean isSwingingChain() {
        return this.field_82175_bq || (this.func_70638_az() != null && this.recoilCounter == 0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        this.func_184609_a(EnumHand.MAIN_HAND);
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
            this.field_70180_af.func_187227_b((DataParameter)EntityTFBlockGoblin.DATA_CHAINLENGTH, (Object)(byte)Math.floor(this.getChainLength() * 127.0f));
            this.field_70180_af.func_187227_b((DataParameter)EntityTFBlockGoblin.DATA_CHAINPOS, (Object)(byte)Math.floor(this.getChainAngle() / 360.0f * 255.0f));
        }
        else if (Math.abs(this.chainAngle - this.getChainAngle()) > 32.0f) {
            this.chainAngle = this.getChainAngle();
        }
        if (this.chainMoveLength > 0.0f) {
            final Vec3d blockPos = this.getThrowPos();
            final double sx2 = this.field_70165_t;
            final double sy2 = this.field_70163_u + this.field_70131_O - 0.1;
            final double sz2 = this.field_70161_v;
            final double ox2 = sx2 - blockPos.field_72450_a;
            final double oy2 = sy2 - blockPos.field_72448_b - 0.25;
            final double oz2 = sz2 - blockPos.field_72449_c;
            if (this.chainMoveLength >= 6.0f || !this.func_70089_S()) {
                this.setThrowing(false);
            }
            this.chain1.func_70107_b(sx2 - ox2 * 0.25, sy2 - oy2 * 0.25, sz2 - oz2 * 0.25);
            this.chain2.func_70107_b(sx2 - ox2 * 0.5, sy2 - oy2 * 0.5, sz2 - oz2 * 0.5);
            this.chain3.func_70107_b(sx2 - ox2 * 0.85, sy2 - oy2 * 0.85, sz2 - oz2 * 0.85);
            this.block.func_70107_b(sx2 - ox2 * 1.0, sy2 - oy2 * 1.0, sz2 - oz2 * 1.0);
        }
        else {
            final Vec3d blockPos = this.getChainPosition();
            this.block.func_70107_b(blockPos.field_72450_a, blockPos.field_72448_b, blockPos.field_72449_c);
            this.block.field_70177_z = this.getChainAngle();
            final double sx3 = this.field_70165_t;
            final double sy3 = this.field_70163_u + this.field_70131_O - 0.1;
            final double sz3 = this.field_70161_v;
            final double ox3 = sx3 - blockPos.field_72450_a;
            final double oy3 = sy3 - blockPos.field_72448_b - this.block.field_70131_O / 3.0;
            final double oz3 = sz3 - blockPos.field_72449_c;
            this.chain1.func_70107_b(sx3 - ox3 * 0.4, sy3 - oy3 * 0.4, sz3 - oz3 * 0.4);
            this.chain2.func_70107_b(sx3 - ox3 * 0.5, sy3 - oy3 * 0.5, sz3 - oz3 * 0.5);
            this.chain3.func_70107_b(sx3 - ox3 * 0.6, sy3 - oy3 * 0.6, sz3 - oz3 * 0.6);
        }
        if (!this.field_70170_p.field_72995_K && (this.isThrowing() || this.isSwingingChain())) {
            this.applyBlockCollisions(this.block);
        }
        this.chainMove();
    }
    
    private Vec3d getThrowPos() {
        final Vec3d vec3d = this.func_70676_i(1.0f);
        return new Vec3d(this.field_70165_t + vec3d.field_72450_a * this.chainMoveLength, this.field_70163_u + this.func_70047_e(), this.field_70161_v + vec3d.field_72449_c * this.chainMoveLength);
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
    }
    
    protected void applyBlockCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.func_70108_f(collider);
            if (collided instanceof EntityLivingBase && super.func_70652_k(collided)) {
                collided.field_70181_x += 0.4;
                this.func_184185_a(SoundEvents.field_187596_cD, 1.0f, 1.0f);
                this.recoilCounter = 40;
                if (this.isThrowing()) {
                    this.setThrowing(false);
                }
            }
        }
    }
    
    public boolean isThrowing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFBlockGoblin.IS_THROWING);
    }
    
    public void setThrowing(final boolean isThrowing) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFBlockGoblin.IS_THROWING, (Object)isThrowing);
    }
    
    private float getChainAngle() {
        if (!this.field_70170_p.field_72995_K) {
            return this.chainAngle;
        }
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFBlockGoblin.DATA_CHAINPOS) & 0xFF) / 255.0f * 360.0f;
    }
    
    private float getChainLength() {
        if (this.field_70170_p.field_72995_K) {
            return ((byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFBlockGoblin.DATA_CHAINLENGTH) & 0xFF) / 127.0f;
        }
        if (this.isSwingingChain()) {
            return 0.9f;
        }
        return 0.3f;
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final MultiPartEntityPart part, final DamageSource source, final float damage) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.partsArray;
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
        MODIFIER = new AttributeModifier(EntityTFBlockGoblin.MODIFIER_UUID, "speedPenalty", -0.25, 0).func_111168_a(false);
        LOOT_TABLE = TwilightForestMod.prefix("entities/block_goblin");
        DATA_CHAINLENGTH = EntityDataManager.func_187226_a((Class)EntityTFBlockGoblin.class, DataSerializers.field_187191_a);
        DATA_CHAINPOS = EntityDataManager.func_187226_a((Class)EntityTFBlockGoblin.class, DataSerializers.field_187191_a);
        IS_THROWING = EntityDataManager.func_187226_a((Class)EntityTFBlockGoblin.class, DataSerializers.field_187198_h);
    }
}
