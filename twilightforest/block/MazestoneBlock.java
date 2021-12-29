// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.item.MazebreakerPickItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class MazestoneBlock extends Block
{
    public MazestoneBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public void m_5707_(final Level world, final BlockPos pos, final BlockState state, final Player player) {
        super.m_5707_(world, pos, state, player);
        final ItemStack stack = player.m_21120_(InteractionHand.MAIN_HAND);
        if (!world.f_46443_ && !stack.m_41619_() && stack.m_41720_().m_41465_() && !(stack.m_41720_() instanceof MazebreakerPickItem)) {
            stack.m_41622_(16, (LivingEntity)player, user -> user.m_21190_(InteractionHand.MAIN_HAND));
        }
    }
}
