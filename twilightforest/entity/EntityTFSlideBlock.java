// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import javax.annotation.Nonnull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import java.util.List;
import net.minecraft.item.ItemStack;
import twilightforest.TFSounds;
import net.minecraft.entity.MoverType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.datasync.DataParameter;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;

public class EntityTFSlideBlock extends Entity implements IEntityAdditionalSpawnData
{
    private static final int WARMUP_TIME = 20;
    private static final DataParameter<EnumFacing> MOVE_DIRECTION;
    private IBlockState myState;
    private int slideTime;
    
    public EntityTFSlideBlock(final World world) {
        super(world);
        this.field_70156_m = true;
        this.field_70144_Y = 1.0f;
        this.func_70105_a(0.98f, 0.98f);
    }
    
    public EntityTFSlideBlock(final World world, final double x, final double y, final double z, final IBlockState state) {
        super(world);
        this.myState = state;
        this.field_70156_m = true;
        this.field_70144_Y = 1.0f;
        this.func_70105_a(0.98f, 0.98f);
        this.func_70107_b(x, y, z);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = x;
        this.field_70167_r = y;
        this.field_70166_s = z;
        this.determineMoveDirection();
    }
    
    private void determineMoveDirection() {
        final BlockPos pos = new BlockPos((Entity)this);
        EnumFacing[] toCheck = null;
        switch ((EnumFacing.Axis)this.myState.func_177229_b((IProperty)BlockRotatedPillar.field_176298_M)) {
            case X: {
                toCheck = new EnumFacing[] { EnumFacing.DOWN, EnumFacing.UP, EnumFacing.NORTH, EnumFacing.SOUTH };
                break;
            }
            case Z: {
                toCheck = new EnumFacing[] { EnumFacing.DOWN, EnumFacing.UP, EnumFacing.WEST, EnumFacing.EAST };
                break;
            }
            default: {
                toCheck = new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.NORTH, EnumFacing.SOUTH };
                break;
            }
        }
        for (final EnumFacing e : toCheck) {
            if (this.field_70170_p.func_175623_d(pos.func_177972_a(e)) && !this.field_70170_p.func_175623_d(pos.func_177972_a(e.func_176734_d()))) {
                this.field_70180_af.func_187227_b((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION, (Object)e);
                return;
            }
        }
        for (final EnumFacing e : toCheck) {
            if (this.field_70170_p.func_175623_d(pos.func_177972_a(e))) {
                this.field_70180_af.func_187227_b((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION, (Object)e);
                return;
            }
        }
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION, (Object)EnumFacing.DOWN);
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    public void func_70071_h_() {
        if (this.myState == null || this.myState.func_185904_a() == Material.field_151579_a) {
            this.func_70106_y();
        }
        else {
            this.field_70169_q = this.field_70165_t;
            this.field_70167_r = this.field_70163_u;
            this.field_70166_s = this.field_70161_v;
            ++this.slideTime;
            if (this.slideTime > 20) {
                final double moveAcceleration = 0.04;
                final EnumFacing moveDirection = (EnumFacing)this.field_70180_af.func_187225_a((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION);
                this.field_70159_w += moveDirection.func_82601_c() * 0.04;
                this.field_70181_x += moveDirection.func_96559_d() * 0.04;
                this.field_70179_y += moveDirection.func_82599_e() * 0.04;
                this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
            this.field_70159_w *= 0.98;
            this.field_70181_x *= 0.98;
            this.field_70179_y *= 0.98;
            if (!this.field_70170_p.field_72995_K) {
                if (this.slideTime % 5 == 0) {
                    this.func_184185_a(TFSounds.SLIDER, 1.0f, 0.9f + this.field_70146_Z.nextFloat() * 0.4f);
                }
                final BlockPos pos = new BlockPos((Entity)this);
                if (this.slideTime == 1) {
                    if (this.field_70170_p.func_180495_p(pos) != this.myState) {
                        this.func_70106_y();
                        return;
                    }
                    this.field_70170_p.func_175698_g(pos);
                }
                if (this.slideTime == 60) {
                    this.field_70159_w = 0.0;
                    this.field_70181_x = 0.0;
                    this.field_70179_y = 0.0;
                    this.field_70180_af.func_187227_b((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION, (Object)((EnumFacing)this.field_70180_af.func_187225_a((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION)).func_176734_d());
                }
                if (this.field_70132_H) {
                    this.field_70159_w *= 0.699999988079071;
                    this.field_70179_y *= 0.699999988079071;
                    this.field_70181_x *= 0.699999988079071;
                    this.func_70106_y();
                    if (this.field_70170_p.func_190527_a(this.myState.func_177230_c(), pos, true, EnumFacing.UP, (Entity)null)) {
                        this.field_70170_p.func_175656_a(pos, this.myState);
                    }
                    else {
                        this.func_70099_a(new ItemStack(this.myState.func_177230_c(), 1, this.myState.func_177230_c().func_180651_a(this.myState)), 0.0f);
                    }
                }
                else if ((this.slideTime > 100 && (pos.func_177956_o() < 1 || pos.func_177956_o() > 256)) || this.slideTime > 600) {
                    this.func_70099_a(new ItemStack(this.myState.func_177230_c(), 1, this.myState.func_177230_c().func_180651_a(this.myState)), 0.0f);
                    this.func_70106_y();
                }
                this.damageKnockbackEntities(this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ()));
            }
        }
    }
    
    private void damageKnockbackEntities(final List<Entity> entities) {
        for (final Entity entity : entities) {
            if (entity instanceof EntityLivingBase) {
                entity.func_70097_a(DamageSource.field_76377_j, 5.0f);
                final double kx = (this.field_70165_t - entity.field_70165_t) * 2.0;
                final double kz = (this.field_70161_v - entity.field_70161_v) * 2.0;
                ((EntityLivingBase)entity).func_70653_a((Entity)this, 2.0f, kx, kz);
            }
        }
    }
    
    public AxisAlignedBB func_70114_g(final Entity entity) {
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }
    
    protected void func_70037_a(@Nonnull final NBTTagCompound compound) {
        final Block b = (Block)Block.field_149771_c.func_82594_a((Object)new ResourceLocation(compound.func_74779_i("TileID")));
        final int meta = compound.func_74771_c("Meta");
        this.myState = b.func_176203_a(meta);
        this.slideTime = compound.func_74762_e("Time");
        this.field_70180_af.func_187227_b((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION, (Object)EnumFacing.func_82600_a((int)compound.func_74771_c("Direction")));
    }
    
    protected void func_70014_b(@Nonnull final NBTTagCompound compound) {
        compound.func_74778_a("TileID", this.myState.func_177230_c().getRegistryName().toString());
        compound.func_74774_a("Meta", (byte)this.myState.func_177230_c().func_176201_c(this.myState));
        compound.func_74768_a("Time", this.slideTime);
        compound.func_74774_a("Direction", (byte)((EnumFacing)this.field_70180_af.func_187225_a((DataParameter)EntityTFSlideBlock.MOVE_DIRECTION)).func_176745_a());
    }
    
    public void writeSpawnData(final ByteBuf buffer) {
        buffer.writeInt(Block.func_176210_f(this.myState));
    }
    
    public void readSpawnData(final ByteBuf additionalData) {
        this.myState = Block.func_176220_d(additionalData.readInt());
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_96092_aw() {
        return false;
    }
    
    public IBlockState getBlockState() {
        return this.myState;
    }
    
    static {
        MOVE_DIRECTION = EntityDataManager.func_187226_a((Class)EntityTFSlideBlock.class, DataSerializers.field_187202_l);
    }
}
