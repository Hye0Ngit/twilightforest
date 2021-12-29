// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.EnumFacing;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.util.BlockSnapshot;
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
import net.minecraft.item.ItemBlock;

public class ItemBlockTFHugeWaterLily extends ItemBlock
{
    public ItemBlockTFHugeWaterLily(final Block block) {
        super(block);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World worldIn, final EntityPlayer playerIn, final EnumHand hand) {
        final ItemStack itemstack = playerIn.func_184586_b(hand);
        final RayTraceResult raytraceresult = this.func_77621_a(worldIn, playerIn, true);
        if (raytraceresult == null) {
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.PASS, (Object)itemstack);
        }
        if (raytraceresult.field_72313_a == RayTraceResult.Type.BLOCK) {
            final BlockPos blockpos = raytraceresult.func_178782_a();
            if (!worldIn.func_175660_a(playerIn, blockpos) || !playerIn.func_175151_a(blockpos.func_177972_a(raytraceresult.field_178784_b), raytraceresult.field_178784_b, itemstack)) {
                return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)itemstack);
            }
            final BlockPos blockpos2 = blockpos.func_177984_a();
            final IBlockState iblockstate = worldIn.func_180495_p(blockpos);
            if (iblockstate.func_185904_a() == Material.field_151586_h && (int)iblockstate.func_177229_b((IProperty)BlockLiquid.field_176367_b) == 0 && worldIn.func_175623_d(blockpos2)) {
                final BlockSnapshot blocksnapshot = BlockSnapshot.getBlockSnapshot(worldIn, blockpos2);
                worldIn.func_175656_a(blockpos2, TFBlocks.huge_waterlily.func_176223_P());
                if (ForgeEventFactory.onPlayerBlockPlace(playerIn, blocksnapshot, EnumFacing.UP, hand).isCanceled()) {
                    blocksnapshot.restore(true, false);
                    return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)itemstack);
                }
                worldIn.func_180501_a(blockpos2, TFBlocks.huge_waterlily.func_176223_P(), 11);
                if (playerIn instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)playerIn, blockpos2, itemstack);
                }
                if (!playerIn.field_71075_bZ.field_75098_d) {
                    itemstack.func_190918_g(1);
                }
                playerIn.func_71029_a(StatList.func_188057_b((Item)this));
                worldIn.func_184133_a(playerIn, blockpos, SoundEvents.field_187916_gp, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)itemstack);
            }
        }
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)itemstack);
    }
}
