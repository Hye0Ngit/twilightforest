// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.block.Block;
import net.minecraft.network.PacketBuffer;
import javax.annotation.Nonnull;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Iterator;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.LivingEntity;
import java.util.List;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.shapes.ISelectionContext;
import twilightforest.TFSounds;
import net.minecraft.entity.MoverType;
import net.minecraft.block.material.Material;
import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.network.datasync.DataParameter;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;

public class SlideBlockEntity extends Entity implements IEntityAdditionalSpawnData
{
    private static final int WARMUP_TIME = 20;
    private static final DataParameter<Direction> MOVE_DIRECTION;
    private BlockState myState;
    private int slideTime;
    
    public SlideBlockEntity(final EntityType<? extends SlideBlockEntity> type, final World world) {
        super((EntityType)type, world);
        this.field_70156_m = true;
        this.field_70144_Y = 1.0f;
    }
    
    public SlideBlockEntity(final EntityType<? extends SlideBlockEntity> type, final World world, final double x, final double y, final double z, final BlockState state) {
        super((EntityType)type, world);
        this.myState = state;
        this.field_70156_m = true;
        this.field_70144_Y = 1.0f;
        this.func_70107_b(x, y, z);
        this.func_213317_d(new Vector3d(0.0, 0.0, 0.0));
        this.field_70169_q = x;
        this.field_70167_r = y;
        this.field_70166_s = z;
        this.determineMoveDirection();
    }
    
    private void determineMoveDirection() {
        final BlockPos pos = new BlockPos((Vector3i)this.func_233580_cy_());
        Direction[] toCheck = null;
        switch ((Direction.Axis)this.myState.func_177229_b((Property)RotatedPillarBlock.field_176298_M)) {
            case X: {
                toCheck = new Direction[] { Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH };
                break;
            }
            case Z: {
                toCheck = new Direction[] { Direction.DOWN, Direction.UP, Direction.WEST, Direction.EAST };
                break;
            }
            default: {
                toCheck = new Direction[] { Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH };
                break;
            }
        }
        for (final Direction e : toCheck) {
            if (this.field_70170_p.func_175623_d(pos.func_177972_a(e)) && !this.field_70170_p.func_175623_d(pos.func_177972_a(e.func_176734_d()))) {
                this.field_70180_af.func_187227_b((DataParameter)SlideBlockEntity.MOVE_DIRECTION, (Object)e);
                return;
            }
        }
        for (final Direction e : toCheck) {
            if (this.field_70170_p.func_175623_d(pos.func_177972_a(e))) {
                this.field_70180_af.func_187227_b((DataParameter)SlideBlockEntity.MOVE_DIRECTION, (Object)e);
                return;
            }
        }
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)SlideBlockEntity.MOVE_DIRECTION, (Object)Direction.DOWN);
    }
    
    public boolean func_226271_bk_() {
        return false;
    }
    
    public boolean func_70067_L() {
        return this.func_70089_S();
    }
    
    public void func_70071_h_() {
        if (this.myState == null || this.myState.func_185904_a() == Material.field_151579_a) {
            this.func_70106_y();
        }
        else {
            this.field_70169_q = this.func_226277_ct_();
            this.field_70167_r = this.func_226278_cu_();
            this.field_70166_s = this.func_226281_cx_();
            ++this.slideTime;
            if (this.slideTime > 20) {
                final double moveAcceleration = 0.04;
                final Direction moveDirection = (Direction)this.field_70180_af.func_187225_a((DataParameter)SlideBlockEntity.MOVE_DIRECTION);
                this.func_213317_d(this.func_213322_ci().func_72441_c(moveDirection.func_82601_c() * 0.04, moveDirection.func_96559_d() * 0.04, moveDirection.func_82599_e() * 0.04));
                this.func_213315_a(MoverType.SELF, new Vector3d(this.func_213322_ci().func_82615_a(), this.func_213322_ci().func_82617_b(), this.func_213322_ci().func_82616_c()));
            }
            this.func_213322_ci().func_216372_d(0.98, 0.98, 0.98);
            if (!this.field_70170_p.field_72995_K) {
                if (this.slideTime % 5 == 0) {
                    this.func_184185_a(TFSounds.SLIDER, 1.0f, 0.9f + this.field_70146_Z.nextFloat() * 0.4f);
                }
                final BlockPos pos = new BlockPos((Vector3i)this.func_233580_cy_());
                if (this.slideTime == 1) {
                    if (this.field_70170_p.func_180495_p(pos) != this.myState) {
                        this.func_70106_y();
                        return;
                    }
                    this.field_70170_p.func_217377_a(pos, false);
                }
                if (this.slideTime == 60) {
                    this.func_213317_d(new Vector3d(0.0, 0.0, 0.0));
                    this.field_70180_af.func_187227_b((DataParameter)SlideBlockEntity.MOVE_DIRECTION, (Object)((Direction)this.field_70180_af.func_187225_a((DataParameter)SlideBlockEntity.MOVE_DIRECTION)).func_176734_d());
                }
                if (this.field_70124_G || this.field_70123_F) {
                    this.func_213317_d(this.func_213322_ci().func_216372_d(0.699999988079071, 0.699999988079071, 0.699999988079071));
                    this.func_70106_y();
                    if (this.field_70170_p.func_226663_a_(this.myState, pos, ISelectionContext.func_216377_a())) {
                        this.field_70170_p.func_175656_a(pos, this.myState);
                    }
                    else {
                        this.func_70099_a(new ItemStack((IItemProvider)this.myState.func_177230_c()), 0.0f);
                    }
                }
                else if ((this.slideTime > 100 && (pos.func_177956_o() < 1 || pos.func_177956_o() > 256)) || this.slideTime > 600) {
                    this.func_70099_a(new ItemStack((IItemProvider)this.myState.func_177230_c()), 0.0f);
                    this.func_70106_y();
                }
                this.damageKnockbackEntities(this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ()));
            }
        }
    }
    
    private void damageKnockbackEntities(final List<Entity> entities) {
        for (final Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                entity.func_70097_a(TFDamageSources.SLIDER, 5.0f);
                final double kx = (this.func_226277_ct_() - entity.func_226277_ct_()) * 2.0;
                final double kz = (this.func_226281_cx_() - entity.func_226281_cx_()) * 2.0;
                ((LivingEntity)entity).func_233627_a_(2.0f, kx, kz);
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }
    
    protected void func_70037_a(@Nonnull final CompoundNBT compound) {
        this.slideTime = compound.func_74762_e("Time");
        this.field_70180_af.func_187227_b((DataParameter)SlideBlockEntity.MOVE_DIRECTION, (Object)Direction.func_82600_a((int)compound.func_74771_c("Direction")));
    }
    
    protected void func_213281_b(@Nonnull final CompoundNBT compound) {
        compound.func_74768_a("Time", this.slideTime);
        compound.func_74774_a("Direction", (byte)((Direction)this.field_70180_af.func_187225_a((DataParameter)SlideBlockEntity.MOVE_DIRECTION)).func_176745_a());
    }
    
    public void writeSpawnData(final PacketBuffer buffer) {
        buffer.writeInt(Block.func_196246_j(this.myState));
    }
    
    public void readSpawnData(final PacketBuffer additionalData) {
        this.myState = Block.func_196257_b(additionalData.readInt());
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_96092_aw() {
        return false;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    public BlockState getBlockState() {
        return this.myState;
    }
    
    static {
        MOVE_DIRECTION = EntityDataManager.func_187226_a((Class)SlideBlockEntity.class, DataSerializers.field_187202_l);
    }
}
