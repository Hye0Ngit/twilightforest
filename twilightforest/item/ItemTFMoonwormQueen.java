// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumAction;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import twilightforest.entity.EntityTFMoonwormShot;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class ItemTFMoonwormQueen extends ItemTF
{
    private static final int FIRING_TIME = 12;
    private IIcon[] icons;
    private String[] iconNames;
    
    protected ItemTFMoonwormQueen() {
        this.iconNames = new String[] { "moonwormQueen", "moonwormQueenAlt" };
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77777_bU = 1;
        this.func_77656_e(256);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player) {
        if (par1ItemStack.func_77960_j() < this.func_77612_l()) {
            player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        }
        else {
            player.func_71034_by();
        }
        return par1ItemStack;
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer player, final World world, int x, int y, int z, int side, final float hitX, final float hitY, final float hitZ) {
        final Block currentBlockID = world.func_147439_a(x, y, z);
        if (currentBlockID == TFBlocks.moonworm) {
            return false;
        }
        if (par1ItemStack != null && par1ItemStack.func_77960_j() == this.func_77612_l()) {
            return false;
        }
        if (currentBlockID == Blocks.field_150433_aE) {
            side = 1;
        }
        else if (currentBlockID != Blocks.field_150395_bd && currentBlockID != Blocks.field_150329_H && currentBlockID != Blocks.field_150330_I && (currentBlockID == Blocks.field_150350_a || !currentBlockID.isReplaceable((IBlockAccess)world, x, y, z))) {
            if (side == 0) {
                --y;
            }
            if (side == 1) {
                ++y;
            }
            if (side == 2) {
                --z;
            }
            if (side == 3) {
                ++z;
            }
            if (side == 4) {
                --x;
            }
            if (side == 5) {
                ++x;
            }
        }
        if (world.func_147472_a(TFBlocks.moonworm, x, y, z, false, side, (Entity)player, par1ItemStack)) {
            final int placementMeta = TFBlocks.moonworm.func_149660_a(world, x, y, z, side, hitX, hitY, hitZ, 0);
            if (world.func_147465_d(x, y, z, TFBlocks.moonworm, placementMeta, 3)) {
                if (world.func_147439_a(x, y, z) == TFBlocks.moonworm) {
                    TFBlocks.moonworm.func_149689_a(world, x, y, z, (EntityLivingBase)player, par1ItemStack);
                }
                world.func_72908_a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), this.getSound(), TFBlocks.moonworm.field_149762_H.func_150497_c() / 2.0f, TFBlocks.moonworm.field_149762_H.func_150494_d() * 0.8f);
                if (par1ItemStack != null) {
                    par1ItemStack.func_77972_a(1, (EntityLivingBase)player);
                    player.func_71034_by();
                }
            }
            return true;
        }
        return false;
    }
    
    public String getSound() {
        return "mob.slime.big";
    }
    
    public void func_77615_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player, final int useRemaining) {
        final int useTime = this.func_77626_a(par1ItemStack) - useRemaining;
        if (!world.field_72995_K && useTime > 12 && par1ItemStack.func_77960_j() + 1 < this.func_77612_l()) {
            final boolean fired = world.func_72838_d((Entity)new EntityTFMoonwormShot(world, (EntityLivingBase)player));
            if (fired) {
                par1ItemStack.func_77972_a(2, (EntityLivingBase)player);
                world.func_72956_a((Entity)player, this.getSound(), 1.0f, 1.0f);
            }
        }
    }
    
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.func_77973_b() == this) {
            final int useTime = usingItem.func_77988_m() - useRemaining;
            if (useTime >= 12) {
                return ((useTime >> 1) % 2 == 0) ? this.icons[0] : this.icons[1];
            }
        }
        return this.icons[0];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        super.func_94581_a(par1IconRegister);
        this.icons = new IIcon[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.func_94245_a("TwilightForest:" + this.iconNames[i]);
        }
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
}
