// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import twilightforest.TwilightForestMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFCastleMagic extends Block
{
    public static IIcon[] magicIcons;
    public static int[] magicColors;
    
    public BlockTFCastleMagic() {
        super(Material.field_151576_e);
        this.func_149711_c(100.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = par1IconRegister.func_94245_a("TwilightForest:castleblock_brick");
        for (int i = 0; i < 8; ++i) {
            BlockTFCastleMagic.magicIcons[i] = par1IconRegister.func_94245_a("TwilightForest:castleblock_magic_" + i);
        }
    }
    
    public static IIcon getMagicIconFor(final int x, final int y, final int z) {
        long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
        seed = seed * seed * 42317861L + seed * 11L;
        final int index = (int)(seed >> 12 & 0x7L);
        return BlockTFCastleMagic.magicIcons[index];
    }
    
    public static int getMagicColorFor(final int meta) {
        int color = BlockTFCastleMagic.magicColors[meta & 0x3];
        if ((meta & 0x8) != 0x0) {
            color ^= 0xFFFFFF;
        }
        return color;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getCastleMagicBlockRenderID();
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
    
    public int func_149692_a(final int meta) {
        return meta;
    }
    
    static {
        BlockTFCastleMagic.magicIcons = new IIcon[8];
        BlockTFCastleMagic.magicColors = new int[] { 65535, 16776960, 16711935, 4915330 };
    }
}
