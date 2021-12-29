// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class HardenedDarkLeavesBlock extends Block
{
    protected HardenedDarkLeavesBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 0;
    }
    
    public ItemStack getPickBlock(final BlockState state, final HitResult target, final BlockGetter world, final BlockPos pos, final Player player) {
        return new ItemStack((ItemLike)TFBlocks.DARK_LEAVES.get());
    }
}
