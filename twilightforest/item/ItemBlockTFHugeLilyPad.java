// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import twilightforest.enums.HugeLilypadPiece;
import twilightforest.block.BlockTFHugeLilyPad;
import twilightforest.block.TFBlocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.item.ItemColored;

public class ItemBlockTFHugeLilyPad extends ItemColored
{
    public ItemBlockTFHugeLilyPad(final Block block) {
        super(block, false);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World worldIn, final EntityPlayer playerIn, final EnumHand hand) {
        final ItemStack itemstack = playerIn.func_184586_b(hand);
        final RayTraceResult raytraceresult = this.func_77621_a(worldIn, playerIn, true);
        if (raytraceresult == null) {
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.PASS, (Object)itemstack);
        }
        if (raytraceresult.field_72313_a == RayTraceResult.Type.BLOCK) {
            final BlockPos blockpos = raytraceresult.func_178782_a();
            final BlockPos blockpos2 = blockpos.func_177984_a();
            if (!worldIn.func_175660_a(playerIn, blockpos) || !playerIn.func_175151_a(blockpos.func_177972_a(raytraceresult.field_178784_b), raytraceresult.field_178784_b, itemstack) || !worldIn.func_175660_a(playerIn, blockpos.func_177974_f()) || !playerIn.func_175151_a(blockpos.func_177972_a(raytraceresult.field_178784_b).func_177974_f(), raytraceresult.field_178784_b, itemstack) || !worldIn.func_175660_a(playerIn, blockpos.func_177968_d()) || !playerIn.func_175151_a(blockpos.func_177972_a(raytraceresult.field_178784_b).func_177968_d(), raytraceresult.field_178784_b, itemstack) || !worldIn.func_175660_a(playerIn, blockpos.func_177974_f().func_177968_d()) || !playerIn.func_175151_a(blockpos.func_177972_a(raytraceresult.field_178784_b).func_177974_f().func_177968_d(), raytraceresult.field_178784_b, itemstack)) {
                return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)itemstack);
            }
            final IBlockState iblockstate = worldIn.func_180495_p(blockpos);
            final IBlockState iblockstatee = worldIn.func_180495_p(blockpos.func_177974_f());
            final IBlockState iblockstatese = worldIn.func_180495_p(blockpos.func_177974_f().func_177968_d());
            final IBlockState iblockstates = worldIn.func_180495_p(blockpos.func_177968_d());
            if (iblockstate.func_185904_a() == Material.field_151586_h && (int)iblockstate.func_177229_b((IProperty)BlockLiquid.field_176367_b) == 0 && iblockstatee.func_185904_a() == Material.field_151586_h && (int)iblockstatee.func_177229_b((IProperty)BlockLiquid.field_176367_b) == 0 && iblockstatee.func_185904_a() == Material.field_151586_h && (int)iblockstatee.func_177229_b((IProperty)BlockLiquid.field_176367_b) == 0 && iblockstatese.func_185904_a() == Material.field_151586_h && (int)iblockstatee.func_177229_b((IProperty)BlockLiquid.field_176367_b) == 0 && iblockstates.func_185904_a() == Material.field_151586_h && (int)iblockstatee.func_177229_b((IProperty)BlockLiquid.field_176367_b) == 0 && worldIn.func_175623_d(blockpos2) && worldIn.func_175623_d(blockpos2.func_177974_f()) && worldIn.func_175623_d(blockpos2.func_177974_f().func_177968_d()) && worldIn.func_175623_d(blockpos2.func_177968_d())) {
                final EnumFacing direction = playerIn.func_174811_aO();
                final IBlockState lilypad = TFBlocks.huge_lilypad.func_176223_P().func_177226_a((IProperty)BlockTFHugeLilyPad.FACING, (Comparable)direction);
                worldIn.func_180501_a(blockpos2, lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.NW), 10);
                worldIn.func_180501_a(blockpos2.func_177974_f(), lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.NE), 10);
                worldIn.func_180501_a(blockpos2.func_177974_f().func_177968_d(), lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.SE), 10);
                worldIn.func_180501_a(blockpos2.func_177968_d(), lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.SW), 11);
                if (playerIn instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)playerIn, blockpos2, itemstack);
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)playerIn, blockpos2.func_177974_f(), itemstack);
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)playerIn, blockpos2.func_177974_f().func_177968_d(), itemstack);
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)playerIn, blockpos2.func_177968_d(), itemstack);
                }
                if (!playerIn.field_71075_bZ.field_75098_d) {
                    itemstack.func_190918_g(1);
                }
                playerIn.func_71029_a(StatList.func_188057_b((Item)this));
                worldIn.func_184133_a(playerIn, blockpos, TFBlocks.huge_lilypad.getSoundType(iblockstate, worldIn, blockpos, (Entity)playerIn).func_185841_e(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)itemstack);
            }
        }
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)itemstack);
    }
}
