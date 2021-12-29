// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.BlockTFPlant;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import twilightforest.enums.PlantVariant;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class ItemBlockTFPlant extends ItemBlockTFMeta
{
    public ItemBlockTFPlant(final Block block) {
        super(block);
    }
    
    public boolean func_179222_a(final World world, BlockPos pos, EnumFacing side, final EntityPlayer player, final ItemStack stack) {
        final int meta = stack.func_77952_i();
        if (meta == PlantVariant.ROOT_STRAND.ordinal() || meta == PlantVariant.TORCHBERRY.ordinal()) {
            final Block block = world.func_180495_p(pos).func_177230_c();
            if (block == Blocks.field_150431_aC && block.func_176200_f((IBlockAccess)world, pos)) {
                side = EnumFacing.UP;
            }
            else if (!block.func_176200_f((IBlockAccess)world, pos)) {
                pos = pos.func_177972_a(side);
            }
            return BlockTFPlant.canPlaceRootAt(world, pos);
        }
        return super.func_179222_a(world, pos, side, player, stack);
    }
}
