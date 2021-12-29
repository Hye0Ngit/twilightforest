// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFRoots extends Block
{
    public static Icon spRootSide;
    public static Icon spOreRootSide;
    public static final int ROOT_META = 0;
    public static final int OREROOT_META = 1;
    
    public BlockTFRoots(final int par1) {
        super(par1, Material.field_76245_d);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
        this.func_71848_c(2.0f);
        this.func_71884_a(Block.field_71967_e);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        if (meta == 1) {
            return BlockTFRoots.spOreRootSide;
        }
        return BlockTFRoots.spRootSide;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFRoots.spRootSide = par1IconRegister.func_94245_a("TwilightForest:rootblock");
        BlockTFRoots.spOreRootSide = par1IconRegister.func_94245_a("TwilightForest:oreroots");
    }
    
    public int func_71885_a(final int meta, final Random random, final int j) {
        switch (meta) {
            case 0: {
                return Item.field_77669_D.field_77779_bT;
            }
            case 1: {
                return TFItems.liveRoot.field_77779_bT;
            }
            default: {
                return this.field_71990_ca;
            }
        }
    }
    
    public int func_71899_b(final int meta) {
        switch (meta) {
            case 0: {
                return 0;
            }
            case 1: {
                return 0;
            }
            default: {
                return meta | 0x8;
            }
        }
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        switch (meta) {
            case 0: {
                return 3 + random.nextInt(2);
            }
            default: {
                return super.quantityDropped(meta, fortune, random);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
}
