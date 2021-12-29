// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.AbstractLightableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;

public class IgniteLightableDispenseBehavior extends OptionalDispenseItemBehavior
{
    protected ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
        final ServerLevel level = source.m_7727_();
        if (!level.m_5776_()) {
            final BlockPos blockpos = source.m_7961_().m_142300_((Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_));
            this.m_123573_(tryLightBlock(level, blockpos));
            if (this.m_123570_() && stack.m_41629_(1, level.m_5822_(), (ServerPlayer)null)) {
                stack.m_41764_(0);
            }
        }
        return stack;
    }
    
    private static boolean tryLightBlock(final ServerLevel level, final BlockPos pos) {
        final BlockState blockstate = level.m_8055_(pos);
        if (blockstate.m_60734_() instanceof AbstractLightableBlock) {
            final AbstractLightableBlock.Lighting lightValue = (AbstractLightableBlock.Lighting)blockstate.m_61143_((Property)AbstractLightableBlock.LIGHTING);
            if (lightValue == AbstractLightableBlock.Lighting.NONE) {
                level.m_46597_(pos, (BlockState)blockstate.m_61124_((Property)AbstractLightableBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.NORMAL));
                return true;
            }
        }
        return false;
    }
}
