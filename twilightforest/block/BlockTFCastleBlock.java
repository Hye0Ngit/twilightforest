// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.item.ItemTFMazebreakerPick;
import net.minecraft.item.ItemTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFCastleBlock extends Block
{
    private static IIcon brickIcon;
    private static IIcon crackIcon;
    private static IIcon fadedIcon;
    private static IIcon roofIcon;
    
    public BlockTFCastleBlock() {
        super(Material.field_151576_e);
        this.func_149711_c(100.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFCastleBlock.brickIcon;
            }
            case 1: {
                return BlockTFCastleBlock.fadedIcon;
            }
            case 2: {
                return BlockTFCastleBlock.crackIcon;
            }
            case 3: {
                return BlockTFCastleBlock.roofIcon;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFCastleBlock.brickIcon = par1IconRegister.func_94245_a("TwilightForest:castleblock_brick");
        BlockTFCastleBlock.fadedIcon = par1IconRegister.func_94245_a("TwilightForest:castleblock_faded");
        BlockTFCastleBlock.crackIcon = par1IconRegister.func_94245_a("TwilightForest:castleblock_cracked");
        BlockTFCastleBlock.roofIcon = par1IconRegister.func_94245_a("TwilightForest:castleblock_roof");
    }
    
    public void func_149636_a(final World world, final EntityPlayer entityplayer, final int x, final int y, final int z, final int meta) {
        final ItemStack cei = entityplayer.func_71045_bC();
        if (cei != null && cei.func_77973_b() instanceof ItemTool && !(cei.func_77973_b() instanceof ItemTFMazebreakerPick)) {
            cei.func_77972_a(16, (EntityLivingBase)entityplayer);
        }
        super.func_149636_a(world, entityplayer, x, y, z, meta);
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
}
