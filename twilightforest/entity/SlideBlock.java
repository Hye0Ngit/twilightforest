// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.level.block.Block;
import net.minecraft.network.FriendlyByteBuf;
import javax.annotation.Nonnull;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Iterator;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.LivingEntity;
import java.util.List;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.shapes.CollisionContext;
import twilightforest.TFSounds;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraftforge.fmllegacy.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.world.entity.Entity;

public class SlideBlock extends Entity implements IEntityAdditionalSpawnData
{
    private static final int WARMUP_TIME = 20;
    private static final EntityDataAccessor<Direction> MOVE_DIRECTION;
    private BlockState myState;
    private int slideTime;
    
    public SlideBlock(final EntityType<? extends SlideBlock> type, final Level world) {
        super((EntityType)type, world);
        this.f_19850_ = true;
        this.f_146794_ = 1.0f;
    }
    
    public SlideBlock(final EntityType<? extends SlideBlock> type, final Level world, final double x, final double y, final double z, final BlockState state) {
        super((EntityType)type, world);
        this.myState = state;
        this.f_19850_ = true;
        this.f_146794_ = 1.0f;
        this.m_6034_(x, y, z);
        this.m_20256_(new Vec3(0.0, 0.0, 0.0));
        this.f_19854_ = x;
        this.f_19855_ = y;
        this.f_19856_ = z;
        this.determineMoveDirection();
    }
    
    private void determineMoveDirection() {
        final BlockPos pos = new BlockPos((Vec3i)this.m_142538_());
        Direction[] array = switch ((Direction.Axis)this.myState.m_61143_((Property)RotatedPillarBlock.f_55923_)) {
            case X -> new Direction[] { Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH };
            case Z -> new Direction[] { Direction.DOWN, Direction.UP, Direction.WEST, Direction.EAST };
            case Y -> new Direction[] { Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH };
            default -> throw new IncompatibleClassChangeError();
        };
        final Direction[] array2;
        final Direction[] toCheck = array2 = array;
        for (final Direction e : array2) {
            if (this.f_19853_.m_46859_(pos.m_142300_(e)) && !this.f_19853_.m_46859_(pos.m_142300_(e.m_122424_()))) {
                this.f_19804_.m_135381_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION, (Object)e);
                return;
            }
        }
        for (final Direction e : toCheck) {
            if (this.f_19853_.m_46859_(pos.m_142300_(e))) {
                this.f_19804_.m_135381_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION, (Object)e);
                return;
            }
        }
    }
    
    protected void m_8097_() {
        this.f_19804_.m_135372_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION, (Object)Direction.DOWN);
    }
    
    public boolean m_20161_() {
        return false;
    }
    
    public boolean m_6087_() {
        return this.m_6084_();
    }
    
    public void m_8119_() {
        if (this.myState == null || this.myState.m_60767_() == Material.f_76296_) {
            this.m_146870_();
        }
        else {
            this.f_19854_ = this.m_20185_();
            this.f_19855_ = this.m_20186_();
            this.f_19856_ = this.m_20189_();
            ++this.slideTime;
            if (this.slideTime > 20) {
                final double moveAcceleration = 0.04;
                final Direction moveDirection = (Direction)this.f_19804_.m_135370_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION);
                this.m_20256_(this.m_20184_().m_82520_(moveDirection.m_122429_() * 0.04, moveDirection.m_122430_() * 0.04, moveDirection.m_122431_() * 0.04));
                this.m_6478_(MoverType.SELF, new Vec3(this.m_20184_().m_7096_(), this.m_20184_().m_7098_(), this.m_20184_().m_7094_()));
            }
            this.m_20184_().m_82542_(0.98, 0.98, 0.98);
            if (!this.f_19853_.f_46443_) {
                if (this.slideTime % 5 == 0) {
                    this.m_5496_(TFSounds.SLIDER, 1.0f, 0.9f + this.f_19796_.nextFloat() * 0.4f);
                }
                final BlockPos pos = new BlockPos((Vec3i)this.m_142538_());
                if (this.slideTime == 1) {
                    if (this.f_19853_.m_8055_(pos) != this.myState) {
                        this.m_146870_();
                        return;
                    }
                    this.f_19853_.m_7471_(pos, false);
                }
                if (this.slideTime == 60) {
                    this.m_20256_(new Vec3(0.0, 0.0, 0.0));
                    this.f_19804_.m_135381_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION, (Object)((Direction)this.f_19804_.m_135370_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION)).m_122424_());
                }
                if (this.f_19863_ || this.f_19862_) {
                    this.m_20256_(this.m_20184_().m_82542_(0.699999988079071, 0.699999988079071, 0.699999988079071));
                    this.m_146870_();
                    if (this.f_19853_.m_45752_(this.myState, pos, CollisionContext.m_82749_())) {
                        this.f_19853_.m_46597_(pos, this.myState);
                    }
                    else {
                        this.m_5552_(new ItemStack((ItemLike)this.myState.m_60734_()), 0.0f);
                    }
                }
                else if ((this.slideTime > 100 && (pos.m_123342_() < 1 || pos.m_123342_() > 256)) || this.slideTime > 600) {
                    this.m_5552_(new ItemStack((ItemLike)this.myState.m_60734_()), 0.0f);
                    this.m_146870_();
                }
                this.damageKnockbackEntities(this.f_19853_.m_45933_((Entity)this, this.m_142469_()));
            }
        }
    }
    
    private void damageKnockbackEntities(final List<Entity> entities) {
        for (final Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                entity.m_6469_(TFDamageSources.SLIDER, 5.0f);
                final double kx = (this.m_20185_() - entity.m_20185_()) * 2.0;
                final double kz = (this.m_20189_() - entity.m_20189_()) * 2.0;
                ((LivingEntity)entity).m_147240_(2.0, kx, kz);
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean m_6051_() {
        return false;
    }
    
    protected void m_7378_(@Nonnull final CompoundTag compound) {
        this.slideTime = compound.m_128451_("Time");
        this.f_19804_.m_135381_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION, (Object)Direction.m_122376_((int)compound.m_128445_("Direction")));
    }
    
    protected void m_7380_(@Nonnull final CompoundTag compound) {
        compound.m_128405_("Time", this.slideTime);
        compound.m_128344_("Direction", (byte)((Direction)this.f_19804_.m_135370_((EntityDataAccessor)SlideBlock.MOVE_DIRECTION)).m_122411_());
    }
    
    public void writeSpawnData(final FriendlyByteBuf buffer) {
        buffer.writeInt(Block.m_49956_(this.myState));
    }
    
    public void readSpawnData(final FriendlyByteBuf additionalData) {
        this.myState = Block.m_49803_(additionalData.readInt());
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    public boolean m_6063_() {
        return false;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    public BlockState getBlockState() {
        return this.myState;
    }
    
    static {
        MOVE_DIRECTION = SynchedEntityData.m_135353_((Class)SlideBlock.class, EntityDataSerializers.f_135040_);
    }
}
