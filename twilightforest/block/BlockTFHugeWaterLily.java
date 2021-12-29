// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockBush;

public class BlockTFHugeWaterLily extends BlockBush
{
    protected BlockTFHugeWaterLily() {
        super(Material.field_151585_k);
        this.func_149672_a(BlockTFHugeWaterLily.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        final float radius = 0.4f;
        this.func_149676_a(0.5f - radius, 0.5f - radius, 0.5f - radius, 0.5f + radius, 0.5f + radius, 0.5f + radius);
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean func_149718_j(final World world, final int x, final int y, final int z) {
        return world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151586_h && world.func_72805_g(x, y - 1, z) == 0;
    }
    
    protected boolean func_149854_a(final Block p_149854_1_) {
        return p_149854_1_ == Blocks.field_150355_j;
    }
}
