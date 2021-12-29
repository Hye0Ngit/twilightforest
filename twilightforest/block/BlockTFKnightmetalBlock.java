// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;
import twilightforest.TwilightForestMod;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.BlockCompressed;

public class BlockTFKnightmetalBlock extends BlockCompressed
{
    private static final float BLOCK_DAMAGE = 4.0f;
    
    public BlockTFKnightmetalBlock() {
        super(MapColor.field_151668_h);
        this.func_149711_c(5.0f);
        this.func_149752_b(41.0f);
        this.func_149672_a(Block.field_149777_j);
        this.func_149658_d("TwilightForest:knightmetal_block");
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int x, final int y, final int z) {
        final float f = 0.0625f;
        return AxisAlignedBB.func_72330_a((double)(x + f), (double)(y + f), (double)(z + f), (double)(x + 1 - f), (double)(y + 1 - f), (double)(z + 1 - f));
    }
    
    public void func_149670_a(final World world, final int x, final int y, final int z, final Entity entity) {
        entity.func_70097_a(DamageSource.field_76367_g, 4.0f);
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getKnightmetalBlockRenderID();
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        return true;
    }
}
