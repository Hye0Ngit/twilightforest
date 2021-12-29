// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import net.minecraft.block.SoundType;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import twilightforest.block.BlockTFGiantBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTFGiantBlock extends ItemBlock
{
    public ItemTFGiantBlock(final Block block) {
        super(block);
    }
    
    public EnumActionResult func_180614_a(final EntityPlayer player, final World worldIn, BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        final IBlockState iblockstate = worldIn.func_180495_p(pos);
        final Block block = iblockstate.func_177230_c();
        if (!block.func_176200_f((IBlockAccess)worldIn, pos)) {
            pos = pos.func_177972_a(facing);
        }
        final ItemStack itemstack = player.func_184586_b(hand);
        if (itemstack.func_190926_b()) {
            return EnumActionResult.FAIL;
        }
        for (final BlockPos iterPos : BlockTFGiantBlock.getVolume(pos)) {
            if (!player.func_175151_a(iterPos, facing, itemstack) || !worldIn.func_190527_a(this.field_150939_a, iterPos, false, facing, (Entity)null)) {
                return EnumActionResult.FAIL;
            }
        }
        pos = BlockTFGiantBlock.roundCoords(pos);
        final int i = this.func_77647_b(itemstack.func_77960_j());
        IBlockState iblockstate2 = this.field_150939_a.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, i, (EntityLivingBase)player, hand);
        if (this.placeBlockAt(itemstack, player, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate2)) {
            iblockstate2 = worldIn.func_180495_p(pos);
            final SoundType soundtype = iblockstate2.func_177230_c().getSoundType(iblockstate2, worldIn, pos, (Entity)player);
            worldIn.func_184133_a(player, pos, soundtype.func_185841_e(), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0f) / 2.0f, soundtype.func_185847_b() * 0.8f);
            itemstack.func_190918_g(1);
        }
        return EnumActionResult.SUCCESS;
    }
    
    public int getItemBurnTime(final ItemStack itemStack) {
        if (this.field_150939_a == TFBlocks.giant_log) {
            return 19200;
        }
        return super.getItemBurnTime(itemStack);
    }
}
