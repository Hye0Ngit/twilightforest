// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFDarkLeaves extends Block implements ModelRegisterCallback
{
    protected BlockTFDarkLeaves() {
        super(Material.field_151584_j);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_180651_a(final IBlockState state) {
        return 3;
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        return 0;
    }
    
    public int func_149745_a(final Random random) {
        return (random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        return Item.func_150898_a((Block)TFBlocks.twilight_sapling);
    }
    
    public ItemStack func_185473_a(final World world, final BlockPos pos, final IBlockState state) {
        return new ItemStack((Block)this);
    }
    
    public void getDrops(final NonNullList<ItemStack> drops, final IBlockAccess world, final BlockPos pos, final IBlockState state, final int fortune) {
        final Random rand = (world instanceof World) ? ((World)world).field_73012_v : BlockTFDarkLeaves.RANDOM;
        if (rand.nextInt(40) == 0) {
            final Item item = this.func_180660_a(state, rand, fortune);
            drops.add((Object)new ItemStack(item, 1, this.func_180651_a(state)));
        }
    }
}
