// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import twilightforest.entity.ai.EntityAITFTempt;
import twilightforest.entity.ai.EntityAITFBirdFly;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;

public class EntityTFTinyBird extends EntityTFBird
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Byte> DATA_BIRDTYPE;
    private static final DataParameter<Byte> DATA_BIRDFLAGS;
    private BlockPos spawnPosition;
    private int currentFlightTime;
    
    public EntityTFTinyBird(final World world) {
        super(world);
        this.func_70105_a(0.3f, 0.3f);
        this.setBirdType(this.field_70146_Z.nextInt(4));
        this.setIsBirdLanded(true);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFBirdFly(this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFTempt((EntityCreature)this, 1.0, true, EntityTFTinyBird.SEEDS));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFTinyBird.DATA_BIRDTYPE, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFTinyBird.DATA_BIRDFLAGS, (Object)0);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000001192092895);
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74768_a("BirdType", this.getBirdType());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setBirdType(compound.func_74762_e("BirdType"));
    }
    
    public int getBirdType() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFTinyBird.DATA_BIRDTYPE);
    }
    
    public void setBirdType(final int type) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFTinyBird.DATA_BIRDTYPE, (Object)(byte)type);
    }
    
    @Override
    public ResourceLocation func_184647_J() {
        return EntityTFTinyBird.LOOT_TABLE;
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
    
    public float func_70047_e() {
        return this.field_70131_O * 0.7f;
    }
    
    public float func_70603_bj() {
        return 0.3f;
    }
    
    protected boolean func_70692_ba() {
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
        return this.field_70170_p.func_175724_o(pos) - 0.5f;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.isBirdLanded()) {
            this.field_70181_x *= 0.6000000238418579;
        }
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.isBirdLanded()) {
            this.currentFlightTime = 0;
            if (this.isSpooked() || this.func_70090_H() || this.field_70170_p.func_72953_d(this.func_174813_aQ()) || (this.field_70146_Z.nextInt(200) == 0 && !this.isLandableBlock(new BlockPos(this.field_70165_t, this.field_70163_u - 1.0, this.field_70161_v)))) {
                this.setIsBirdLanded(false);
                this.field_70170_p.func_175718_b(1025, new BlockPos((Entity)this), 0);
                this.field_70181_x = 0.4;
            }
        }
        else {
            ++this.currentFlightTime;
            if (this.spawnPosition != null && (!this.field_70170_p.func_175623_d(this.spawnPosition) || this.spawnPosition.func_177956_o() < 1)) {
                this.spawnPosition = null;
            }
            if (this.func_70090_H() || this.field_70170_p.func_72953_d(this.func_174813_aQ())) {
                this.currentFlightTime = 0;
                this.field_70181_x = 0.10000000149011612;
            }
            if (this.spawnPosition == null || this.field_70146_Z.nextInt(30) == 0 || this.spawnPosition.func_177954_c((double)(int)this.field_70165_t, (double)(int)this.field_70163_u, (double)(int)this.field_70161_v) < 4.0) {
                final int yTarget = (this.currentFlightTime < 100) ? 2 : 4;
                this.spawnPosition = new BlockPos((int)this.field_70165_t + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - yTarget, (int)this.field_70161_v + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
            }
            final double d0 = this.spawnPosition.func_177958_n() + 0.5 - this.field_70165_t;
            final double d2 = this.spawnPosition.func_177956_o() + 0.1 - this.field_70163_u;
            final double d3 = this.spawnPosition.func_177952_p() + 0.5 - this.field_70161_v;
            this.field_70159_w += (Math.signum(d0) * 0.5 - this.field_70159_w) * 0.10000000149011612;
            this.field_70181_x += (Math.signum(d2) * 0.699999988079071 - this.field_70181_x) * 0.10000000149011612;
            this.field_70179_y += (Math.signum(d3) * 0.5 - this.field_70179_y) * 0.10000000149011612;
            final float f = (float)(MathHelper.func_181159_b(this.field_70179_y, this.field_70159_w) * 57.29577951308232) - 90.0f;
            final float f2 = MathHelper.func_76142_g(f - this.field_70177_z);
            this.field_191988_bg = 0.5f;
            this.field_70177_z += f2;
            if (this.field_70146_Z.nextInt(100) == 0 && this.isLandableBlock(new BlockPos(this.field_70165_t, this.field_70163_u - 1.0, this.field_70161_v))) {
                this.setIsBirdLanded(true);
                this.field_70181_x = 0.0;
            }
        }
    }
    
    public boolean isSpooked() {
        if (this.field_70737_aN > 0) {
            return true;
        }
        final EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 4.0);
        return closestPlayer != null && !EntityTFTinyBird.SEEDS.apply(closestPlayer.func_184614_ca()) && !EntityTFTinyBird.SEEDS.apply(closestPlayer.func_184592_cb());
    }
    
    public boolean isLandableBlock(final BlockPos pos) {
        final IBlockState state = this.field_70170_p.func_180495_p(pos);
        final Block block = state.func_177230_c();
        return !block.isAir(state, (IBlockAccess)this.field_70170_p, pos) && (block.isLeaves(state, (IBlockAccess)this.field_70170_p, pos) || state.isSideSolid((IBlockAccess)this.field_70170_p, pos, EnumFacing.UP));
    }
    
    @Override
    public boolean isBirdLanded() {
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFTinyBird.DATA_BIRDFLAGS) & 0x1) != 0x0;
    }
    
    public void setIsBirdLanded(final boolean landed) {
        final byte flags = (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFTinyBird.DATA_BIRDFLAGS);
        this.field_70180_af.func_187227_b((DataParameter)EntityTFTinyBird.DATA_BIRDFLAGS, (Object)(byte)(landed ? (flags | 0x1) : (flags & 0xFFFFFFFE)));
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity entity) {
    }
    
    protected void func_85033_bc() {
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/tiny_bird");
        DATA_BIRDTYPE = EntityDataManager.func_187226_a((Class)EntityTFTinyBird.class, DataSerializers.field_187191_a);
        DATA_BIRDFLAGS = EntityDataManager.func_187226_a((Class)EntityTFTinyBird.class, DataSerializers.field_187191_a);
    }
}
