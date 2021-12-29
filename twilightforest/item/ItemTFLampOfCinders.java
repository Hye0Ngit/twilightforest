// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumAction;
import net.minecraft.util.MathHelper;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFLampOfCinders extends ItemTF
{
    private static final int FIRING_TIME = 12;
    
    public ItemTFLampOfCinders() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77777_bU = 1;
        this.func_77656_e(1024);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
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
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ) {
        if (this.burnBlock(player, world, x, y, z)) {
            world.func_72956_a((Entity)player, this.getSound(), 0.5f, 1.5f);
            for (int i = 0; i < 10; ++i) {
                final float dx = x + 0.5f + (ItemTFLampOfCinders.field_77697_d.nextFloat() - ItemTFLampOfCinders.field_77697_d.nextFloat()) * 0.75f;
                final float dy = y + 0.5f + (ItemTFLampOfCinders.field_77697_d.nextFloat() - ItemTFLampOfCinders.field_77697_d.nextFloat()) * 0.75f;
                final float dz = z + 0.5f + (ItemTFLampOfCinders.field_77697_d.nextFloat() - ItemTFLampOfCinders.field_77697_d.nextFloat()) * 0.75f;
                world.func_72869_a("smoke", (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0);
                world.func_72869_a("flame", (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0);
            }
            return true;
        }
        return false;
    }
    
    private boolean burnBlock(final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final Block block = world.func_147439_a(x, y, z);
        if (block == TFBlocks.thorns) {
            world.func_147465_d(x, y, z, TFBlocks.burntThorns, world.func_72805_g(x, y, z) & 0xC, 2);
            return true;
        }
        return false;
    }
    
    public void func_77615_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player, final int useRemaining) {
        final int useTime = this.func_77626_a(par1ItemStack) - useRemaining;
        if (useTime > 12 && par1ItemStack.func_77960_j() + 1 < this.func_77612_l()) {
            final int px = MathHelper.func_76128_c(player.field_70142_S);
            final int py = MathHelper.func_76128_c(player.field_70137_T + player.func_70047_e());
            final int pz = MathHelper.func_76128_c(player.field_70136_U);
            if (!world.field_72995_K) {
                world.func_72956_a((Entity)player, this.getSound(), 1.5f, 0.8f);
                for (int dx = -3; dx <= 3; ++dx) {
                    for (int dy = -3; dy <= 3; ++dy) {
                        for (int dz = -3; dz <= 3; ++dz) {
                            this.burnBlock(player, world, px + dx, py + dy, pz + dz);
                        }
                    }
                }
            }
            for (int i = 0; i < 6; ++i) {
                final int rx = px + ItemTFLampOfCinders.field_77697_d.nextInt(3) - ItemTFLampOfCinders.field_77697_d.nextInt(3);
                final int ry = py + ItemTFLampOfCinders.field_77697_d.nextInt(2);
                final int rz = pz + ItemTFLampOfCinders.field_77697_d.nextInt(3) - ItemTFLampOfCinders.field_77697_d.nextInt(3);
                world.func_72889_a(player, 2004, rx, ry, rz, 0);
            }
        }
    }
    
    public String getSound() {
        return "mob.ghast.fireball";
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
}
