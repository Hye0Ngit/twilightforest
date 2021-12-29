// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLiving;
import twilightforest.item.ItemTFMazebreakerPick;
import net.minecraft.item.ItemTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFMazestone extends Block
{
    private static Icon TEX_PLAIN;
    private static Icon TEX_BRICK;
    private static Icon TEX_PILLAR;
    private static Icon TEX_DECO;
    private static Icon TEX_CRACKED;
    private static Icon TEX_MOSSY;
    private static Icon TEX_MOSAIC;
    private static Icon TEX_BORDER;
    
    public BlockTFMazestone(final int id) {
        super(id, Material.field_76246_e);
        this.func_71848_c(100.0f);
        this.func_71894_b(5.0f);
        this.func_71884_a(Block.field_71976_h);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFMazestone.TEX_PLAIN;
            }
            case 1: {
                return BlockTFMazestone.TEX_BRICK;
            }
            case 2: {
                return (side > 1) ? BlockTFMazestone.TEX_PILLAR : BlockTFMazestone.TEX_PLAIN;
            }
            case 3: {
                return (side > 1) ? BlockTFMazestone.TEX_DECO : BlockTFMazestone.TEX_BRICK;
            }
            case 4: {
                return BlockTFMazestone.TEX_CRACKED;
            }
            case 5: {
                return BlockTFMazestone.TEX_MOSSY;
            }
            case 6: {
                return (side > 1) ? BlockTFMazestone.TEX_BRICK : BlockTFMazestone.TEX_MOSAIC;
            }
            case 7: {
                return (side > 1) ? BlockTFMazestone.TEX_BRICK : BlockTFMazestone.TEX_BORDER;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFMazestone.TEX_PLAIN = par1IconRegister.func_94245_a("twilightforest:mazestone_plain");
        BlockTFMazestone.TEX_BRICK = par1IconRegister.func_94245_a("twilightforest:mazestone_brick");
        BlockTFMazestone.TEX_PILLAR = par1IconRegister.func_94245_a("twilightforest:mazestone_pillar");
        BlockTFMazestone.TEX_DECO = par1IconRegister.func_94245_a("twilightforest:mazestone_decorative");
        BlockTFMazestone.TEX_CRACKED = par1IconRegister.func_94245_a("twilightforest:mazestone_cracked");
        BlockTFMazestone.TEX_MOSSY = par1IconRegister.func_94245_a("twilightforest:mazestone_mossy");
        BlockTFMazestone.TEX_MOSAIC = par1IconRegister.func_94245_a("twilightforest:mazestone_mosaic");
        BlockTFMazestone.TEX_BORDER = par1IconRegister.func_94245_a("twilightforest:mazestone_border");
    }
    
    public void func_71893_a(final World world, final EntityPlayer entityplayer, final int x, final int y, final int z, final int meta) {
        final ItemStack cei = entityplayer.func_71045_bC();
        if (cei != null && cei.func_77973_b() instanceof ItemTool && !(cei.func_77973_b() instanceof ItemTFMazebreakerPick)) {
            cei.func_77972_a(16, (EntityLiving)entityplayer);
        }
        super.func_71893_a(world, entityplayer, x, y, z, meta);
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
    }
    
    public int func_71899_b(final int meta) {
        return meta;
    }
}
