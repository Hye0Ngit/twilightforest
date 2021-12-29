// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class GiantBlock extends Block
{
    private boolean isSelfDestructing;
    
    public GiantBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext ctx) {
        for (final BlockPos dPos : getVolume(ctx.m_8083_())) {
            if (!ctx.m_43725_().m_8055_(dPos).m_60629_(ctx)) {
                return null;
            }
        }
        return this.m_49966_();
    }
    
    public void m_6402_(final Level world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        if (!world.f_46443_) {
            for (final BlockPos dPos : getVolume(pos)) {
                world.m_46597_(dPos, this.m_49966_());
            }
        }
    }
    
    @Deprecated
    public void m_6810_(final BlockState state, final Level world, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        super.m_6810_(state, world, pos, newState, isMoving);
        if (!this.isSelfDestructing && !this.isVolumeFilled(world, pos)) {
            this.setGiantBlockToAir(world, pos);
        }
    }
    
    private void setGiantBlockToAir(final Level world, final BlockPos pos) {
        this.isSelfDestructing = true;
        for (final BlockPos iterPos : getVolume(pos)) {
            if (!pos.equals((Object)iterPos) && world.m_8055_(iterPos).m_60734_() == this) {
                world.m_46961_(iterPos, false);
            }
        }
        this.isSelfDestructing = false;
    }
    
    private boolean isVolumeFilled(final Level world, final BlockPos pos) {
        for (final BlockPos dPos : getVolume(pos)) {
            if (world.m_8055_(dPos).m_60734_() != this) {
                return false;
            }
        }
        return true;
    }
    
    @Deprecated
    public PushReaction m_5537_(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    public static Iterable<BlockPos> getVolume(final BlockPos pos) {
        return BlockPos.m_121976_(pos.m_123341_() & 0xFFFFFFFC, pos.m_123342_() & 0xFFFFFFFC, pos.m_123343_() & 0xFFFFFFFC, pos.m_123341_() | 0x3, pos.m_123342_() | 0x3, pos.m_123343_() | 0x3);
    }
}
