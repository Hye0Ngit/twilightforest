// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;

public class BlockTFRipeTorchCluster extends BlockTFTrollRoot
{
    protected BlockTFRipeTorchCluster() {
        this.func_149715_a(1.0f);
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return TFItems.torchberries;
    }
    
    @Override
    public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
        return this.func_149679_a(fortune, random);
    }
    
    public int func_149745_a(final Random rand) {
        return 4 + rand.nextInt(5);
    }
    
    public int func_149679_a(final int bonus, final Random rand) {
        if (bonus > 0 && Item.func_150898_a((Block)this) != this.func_180660_a(this.func_176223_P(), rand, bonus)) {
            int j = rand.nextInt(bonus + 2) - 1;
            if (j < 0) {
                j = 0;
            }
            return this.func_149745_a(rand) * (j + 1);
        }
        return this.func_149745_a(rand);
    }
    
    public void func_180657_a(final World world, final EntityPlayer player, final BlockPos pos, final IBlockState state, @Nullable final TileEntity te, final ItemStack stack) {
        if (world.field_72995_K || stack.func_77973_b() != Items.field_151097_aZ) {
            super.func_180657_a(world, player, pos, state, te, stack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
}
