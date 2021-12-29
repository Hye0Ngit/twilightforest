// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.IBlockReader;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Pose;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import twilightforest.entity.ai.TinyBirdFlyGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.datasync.DataParameter;

public class TinyBirdEntity extends BirdEntity
{
    private static final DataParameter<Byte> DATA_BIRDTYPE;
    private static final DataParameter<Byte> DATA_BIRDFLAGS;
    private BlockPos spawnPosition;
    private int currentFlightTime;
    
    public TinyBirdEntity(final EntityType<? extends TinyBirdEntity> type, final World world) {
        super(type, world);
        this.setBirdType(this.field_70146_Z.nextInt(4));
        this.setIsBirdLanded(true);
        this.func_70873_a(0);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 1.5));
        this.field_70714_bg.func_75776_a(2, (Goal)new TinyBirdFlyGoal(this));
        this.field_70714_bg.func_75776_a(3, (Goal)new TemptGoal((CreatureEntity)this, 1.0, true, TinyBirdEntity.SEEDS));
        this.field_70714_bg.func_75776_a(4, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(5, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)TinyBirdEntity.DATA_BIRDTYPE, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)TinyBirdEntity.DATA_BIRDFLAGS, (Object)0);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 1.0).func_233815_a_(Attributes.field_233821_d_, 0.20000001192092895);
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74768_a("BirdType", this.getBirdType());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setBirdType(compound.func_74762_e("BirdType"));
    }
    
    public int getBirdType() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)TinyBirdEntity.DATA_BIRDTYPE);
    }
    
    public void setBirdType(final int type) {
        this.field_70180_af.func_187227_b((DataParameter)TinyBirdEntity.DATA_BIRDTYPE, (Object)(byte)type);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.TINYBIRD_CHIRP;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.TINYBIRD_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.TINYBIRD_HURT;
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.7f;
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public float func_180484_a(final BlockPos pos) {
        final Material underMaterial = this.field_70170_p.func_180495_p(pos.func_177977_b()).func_185904_a();
        if (underMaterial == Material.field_151584_j) {
            return 200.0f;
        }
        if (underMaterial == Material.field_151575_d) {
            return 15.0f;
        }
        if (underMaterial == Material.field_151577_b) {
            return 9.0f;
        }
        return this.field_70170_p.func_201696_r(pos) - 0.5f;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.isBirdLanded()) {
            this.func_213317_d(this.func_213322_ci().func_216372_d(1.0, 0.6000000238418579, 1.0));
        }
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.isBirdLanded()) {
            this.currentFlightTime = 0;
            if (this.isSpooked() || this.func_70090_H() || this.field_70170_p.func_72953_d(this.func_174813_aQ()) || (this.field_70146_Z.nextInt(200) == 0 && !this.isLandableBlock(new BlockPos(this.func_226277_ct_(), this.func_226278_cu_() - 1.0, this.func_226281_cx_())))) {
                this.setIsBirdLanded(false);
                this.field_70170_p.func_217379_c(1025, new BlockPos((Vector3i)this.func_233580_cy_()), 0);
                this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.4000000059604645, this.func_213322_ci().func_82616_c());
            }
        }
        else {
            ++this.currentFlightTime;
            if (this.spawnPosition != null && (!this.field_70170_p.func_175623_d(this.spawnPosition) || this.spawnPosition.func_177956_o() < 1)) {
                this.spawnPosition = null;
            }
            if (this.func_70090_H() || this.field_70170_p.func_72953_d(this.func_174813_aQ())) {
                this.currentFlightTime = 0;
                this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.10000000149011612, this.func_213322_ci().func_82616_c());
            }
            if (this.spawnPosition == null || this.field_70146_Z.nextInt(30) == 0 || this.spawnPosition.func_177951_i(new Vector3i((int)this.func_226277_ct_(), (int)this.func_226278_cu_(), (int)this.func_226281_cx_())) < 4.0) {
                final int yTarget = (this.currentFlightTime < 100) ? 2 : 4;
                this.spawnPosition = new BlockPos((int)this.func_226277_ct_() + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.func_226278_cu_() + this.field_70146_Z.nextInt(6) - yTarget, (int)this.func_226281_cx_() + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
            }
            final double d0 = this.spawnPosition.func_177958_n() + 0.5 - this.func_226277_ct_();
            final double d2 = this.spawnPosition.func_177956_o() + 0.1 - this.func_226278_cu_();
            final double d3 = this.spawnPosition.func_177952_p() + 0.5 - this.func_226281_cx_();
            this.func_213322_ci().func_178787_e(new Vector3d((Math.signum(d0) * 0.5 - this.func_213322_ci().func_82615_a()) * 0.10000000149011612, (Math.signum(d2) * 0.699999988079071 - this.func_213322_ci().func_82617_b()) * 0.10000000149011612, (Math.signum(d3) * 0.5 - this.func_213322_ci().func_82616_c()) * 0.10000000149011612));
            final float f = (float)(MathHelper.func_181159_b(this.func_213322_ci().func_82616_c(), this.func_213322_ci().func_82615_a()) * 57.29577951308232) - 90.0f;
            final float f2 = MathHelper.func_76142_g(f - this.field_70177_z);
            this.field_191988_bg = 0.5f;
            this.field_70177_z += f2;
            if (this.field_70146_Z.nextInt(100) == 0 && this.isLandableBlock(new BlockPos(this.func_226277_ct_(), this.func_226278_cu_() - 1.0, this.func_226281_cx_()))) {
                this.setIsBirdLanded(true);
                this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.0, this.func_213322_ci().func_82616_c());
            }
        }
    }
    
    public boolean isSpooked() {
        if (this.field_70737_aN > 0) {
            return true;
        }
        final PlayerEntity closestPlayer = this.field_70170_p.func_217362_a((Entity)this, 4.0);
        return closestPlayer != null && !TinyBirdEntity.SEEDS.test(closestPlayer.func_184614_ca()) && !TinyBirdEntity.SEEDS.test(closestPlayer.func_184592_cb());
    }
    
    public boolean isLandableBlock(final BlockPos pos) {
        final BlockState state = this.field_70170_p.func_180495_p(pos);
        final Block block = state.func_177230_c();
        return !block.isAir(state, (IBlockReader)this.field_70170_p, pos) && (block.func_203417_a((ITag)BlockTags.field_206952_E) || state.func_224755_d((IBlockReader)this.field_70170_p, pos, Direction.UP));
    }
    
    @Override
    public boolean isBirdLanded() {
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)TinyBirdEntity.DATA_BIRDFLAGS) & 0x1) != 0x0;
    }
    
    public void setIsBirdLanded(final boolean landed) {
        final byte flags = (byte)this.field_70180_af.func_187225_a((DataParameter)TinyBirdEntity.DATA_BIRDFLAGS);
        this.field_70180_af.func_187227_b((DataParameter)TinyBirdEntity.DATA_BIRDFLAGS, (Object)(byte)(landed ? (flags | 0x1) : (flags & 0xFFFFFFFE)));
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity entity) {
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    protected void func_85033_bc() {
    }
    
    public boolean func_70631_g_() {
        return false;
    }
    
    static {
        DATA_BIRDTYPE = EntityDataManager.func_187226_a((Class)TinyBirdEntity.class, DataSerializers.field_187191_a);
        DATA_BIRDFLAGS = EntityDataManager.func_187226_a((Class)TinyBirdEntity.class, DataSerializers.field_187191_a);
    }
}
