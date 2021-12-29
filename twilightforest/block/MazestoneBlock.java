// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import twilightforest.item.MazebreakerPickItem;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class MazestoneBlock extends Block
{
    public MazestoneBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public void func_176208_a(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        super.func_176208_a(world, pos, state, player);
        final ItemStack stack = player.func_184586_b(Hand.MAIN_HAND);
        if (!world.field_72995_K && !stack.func_190926_b() && stack.func_77973_b().func_77645_m() && !(stack.func_77973_b() instanceof MazebreakerPickItem)) {
            stack.func_222118_a(16, (LivingEntity)player, user -> user.func_213334_d(Hand.MAIN_HAND));
        }
    }
}
