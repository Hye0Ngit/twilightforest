// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import twilightforest.TwilightForestMod;
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

public class BlockTFUncraftingTable extends Block
{
    public static Icon tinkerTop;
    public static Icon tinkerSide;
    
    protected BlockTFUncraftingTable(final int par1) {
        super(par1, Material.field_76245_d);
        this.func_71848_c(2.5f);
        this.func_71884_a(Block.field_71967_e);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        return (side == 1) ? BlockTFUncraftingTable.tinkerTop : BlockTFUncraftingTable.tinkerSide;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFUncraftingTable.tinkerTop = par1IconRegister.func_94245_a("TwilightForest:uncrafting_top");
        BlockTFUncraftingTable.tinkerSide = par1IconRegister.func_94245_a("TwilightForest:uncrafting_side");
    }
    
    public boolean func_71903_a(final World world, final int x, final int y, final int z, final EntityPlayer player, final int par6, final float par7, final float par8, final float par9) {
        player.openGui((Object)TwilightForestMod.instance, 1, world, x, y, z);
        return true;
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
}
