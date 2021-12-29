// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import java.util.ArrayList;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.IShearable;
import net.minecraft.block.Block;

public class BlockTFTrollRoot extends Block implements IShearable
{
    protected BlockTFTrollRoot() {
        super(Material.field_151585_k);
        this.func_149675_a(true);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149672_a(BlockTFTrollRoot.field_149779_h);
        this.func_149658_d("TwilightForest:troll_root");
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack((Block)this));
        return ret;
    }
    
    public boolean func_149718_j(final World world, final int x, final int y, final int z) {
        return canPlaceRootBelow(world, x, y + 1, z);
    }
    
    public static boolean canPlaceRootBelow(final World world, final int x, final int y, final int z) {
        final Block blockAbove = world.func_147439_a(x, y, z);
        return blockAbove.func_149688_o() == Material.field_151576_e || blockAbove == TFBlocks.trollVidr || blockAbove == TFBlocks.trollBer || blockAbove == TFBlocks.unripeTrollBer;
    }
    
    public boolean func_149742_c(final World world, final int x, final int y, final int z) {
        return super.func_149742_c(world, x, y, z) && this.func_149718_j(world, x, y, z);
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public int func_149645_b() {
        return 1;
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random rand) {
        this.checkAndDropBlock(world, x, y, z);
    }
    
    public void func_149695_a(final World world, final int x, final int y, final int z, final Block block) {
        this.checkAndDropBlock(world, x, y, z);
    }
    
    protected void checkAndDropBlock(final World world, final int x, final int y, final int z) {
        if (!this.func_149718_j(world, x, y, z)) {
            this.func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
            world.func_147468_f(x, y, z);
        }
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        return 0;
    }
}
