// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.SoundType;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class ItemTFExperiment115 extends ItemTFFood
{
    public ItemTFExperiment115() {
        super(4, 0.3f, false);
    }
    
    public EnumActionResult func_180614_a(final EntityPlayer player, final World world, BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        final IBlockState state = world.func_180495_p(pos);
        final Block block = state.func_177230_c();
        if (player.func_71043_e(false)) {
            return EnumActionResult.PASS;
        }
        final IBlockState e115 = TFBlocks.experiment_115.func_176223_P();
        if (!block.func_176200_f((IBlockAccess)world, pos)) {
            pos = pos.func_177972_a(facing);
        }
        final ItemStack itemstack = player.func_184586_b(hand);
        if (!itemstack.func_190926_b() && player.func_175151_a(pos, facing, itemstack) && world.func_190527_a(e115.func_177230_c(), pos, false, facing, (Entity)null)) {
            if (world.func_180501_a(pos, e115, 11)) {
                TFBlocks.experiment_115.func_180633_a(world, pos, e115, (EntityLivingBase)player, itemstack);
                final SoundType soundtype = world.func_180495_p(pos).func_177230_c().getSoundType(world.func_180495_p(pos), world, pos, (Entity)player);
                world.func_184133_a(player, pos, soundtype.func_185841_e(), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0f) / 2.0f, soundtype.func_185847_b() * 0.8f);
                itemstack.func_190918_g(1);
            }
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)player, pos, itemstack);
            }
            return EnumActionResult.SUCCESS;
        }
        return super.func_180614_a(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }
}
