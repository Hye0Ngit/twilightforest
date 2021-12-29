// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFCubeOfAnnihilation;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import java.util.HashMap;
import net.minecraft.util.IIcon;

public class ItemTFCubeOfAnnihilation extends ItemTF
{
    private IIcon annihilateIcon;
    private HashMap<ItemStack, Entity> launchedCubesMap;
    
    protected ItemTFCubeOfAnnihilation() {
        this.launchedCubesMap = new HashMap<ItemStack, Entity>();
        this.field_77777_bU = 1;
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ) {
        return false;
    }
    
    public ItemStack func_77659_a(final ItemStack stack, final World worldObj, final EntityPlayer player) {
        player.func_71008_a(stack, this.func_77626_a(stack));
        if (!worldObj.field_72995_K && !this.hasLaunchedCube(stack)) {
            final EntityTFCubeOfAnnihilation launchedCube = new EntityTFCubeOfAnnihilation(worldObj, (EntityLivingBase)player);
            worldObj.func_72838_d((Entity)launchedCube);
            this.setLaunchedCube(stack, launchedCube);
            setCubeAsThrown(stack);
        }
        return stack;
    }
    
    public static void setCubeAsThrown(final ItemStack stack) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new NBTTagCompound());
        }
        stack.func_77978_p().func_74757_a("thrown", true);
    }
    
    public static void setCubeAsReturned(final ItemStack stack) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new NBTTagCompound());
        }
        stack.func_77978_p().func_74757_a("thrown", false);
    }
    
    public static boolean doesTalismanHaveCube(final ItemStack stack) {
        return stack.func_77978_p() == null || !stack.func_77978_p().func_74767_n("thrown");
    }
    
    public static void setCubeAsReturned(final EntityPlayer player) {
        if (player != null && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() == TFItems.cubeOfAnnihilation) {
            setCubeAsReturned(player.func_71045_bC());
        }
    }
    
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (doesTalismanHaveCube(stack)) {
            return this.field_77791_bV;
        }
        return TFItems.cubeTalisman.func_77650_f(stack);
    }
    
    public boolean hasLaunchedCube(final ItemStack stack) {
        final Entity cube = this.launchedCubesMap.get(stack);
        return cube != null && !cube.field_70128_L;
    }
    
    public void setLaunchedCube(final ItemStack stack, final EntityTFCubeOfAnnihilation launchedCube) {
        this.launchedCubesMap.put(stack, (Entity)launchedCube);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
        this.annihilateIcon = par1IconRegister.func_94245_a("TwilightForest:annihilate_particle");
    }
    
    public IIcon getAnnihilateIcon() {
        return this.annihilateIcon;
    }
}
