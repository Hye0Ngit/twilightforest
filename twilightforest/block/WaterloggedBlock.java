// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.sounds.SoundEvent;
import java.util.Optional;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.BucketPickup;

public interface WaterloggedBlock extends BucketPickup, LiquidBlockContainer
{
    boolean isStateWaterlogged(final BlockState p0);
    
    BlockState setWaterlog(final BlockState p0, final boolean p1);
    
    default boolean m_6044_(final BlockGetter level, final BlockPos pos, final BlockState state, final Fluid fluid) {
        return !this.isStateWaterlogged(state) && fluid == Fluids.f_76193_;
    }
    
    default boolean m_7361_(final LevelAccessor level, final BlockPos pos, final BlockState state, final FluidState fluidState) {
        if (!this.isStateWaterlogged(state) && fluidState.m_76152_() == Fluids.f_76193_) {
            if (!level.m_5776_()) {
                level.m_7731_(pos, this.setWaterlog(state, true), 3);
                level.m_6217_().m_5945_(pos, (Object)fluidState.m_76152_(), fluidState.m_76152_().m_6718_((LevelReader)level));
            }
            return true;
        }
        return false;
    }
    
    default ItemStack m_142598_(final LevelAccessor level, final BlockPos pos, final BlockState state) {
        if (this.isStateWaterlogged(state)) {
            level.m_7731_(pos, this.setWaterlog(state, false), 3);
            if (!state.m_60710_((LevelReader)level, pos)) {
                level.m_46961_(pos, true);
            }
            return new ItemStack((ItemLike)Items.f_42447_);
        }
        return ItemStack.f_41583_;
    }
    
    default Optional<SoundEvent> m_142298_() {
        return Fluids.f_76193_.m_142520_();
    }
}
