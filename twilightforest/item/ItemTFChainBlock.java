// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumAction;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFChainBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import java.util.Set;
import com.google.common.collect.Sets;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import java.util.HashMap;
import net.minecraft.item.ItemTool;

public class ItemTFChainBlock extends ItemTool
{
    private HashMap<ItemStack, Entity> launchedBlocksMap;
    
    protected ItemTFChainBlock() {
        super(6.0f, TFItems.TOOL_KNIGHTLY, (Set)Sets.newHashSet((Object[])new Block[] { Blocks.field_150348_b }));
        this.launchedBlocksMap = new HashMap<ItemStack, Entity>();
        this.field_77777_bU = 1;
        this.func_77656_e(99);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ItemStack func_77659_a(final ItemStack stack, final World worldObj, final EntityPlayer player) {
        player.func_71008_a(stack, this.func_77626_a(stack));
        if (!worldObj.field_72995_K && !this.hasLaunchedBlock(stack)) {
            worldObj.func_72956_a((Entity)player, "random.bow", 1.0f, 1.0f / (ItemTFChainBlock.field_77697_d.nextFloat() * 0.4f + 1.2f));
            final EntityTFChainBlock launchedBlock = new EntityTFChainBlock(worldObj, (EntityLivingBase)player);
            worldObj.func_72838_d((Entity)launchedBlock);
            this.setLaunchedBlock(stack, launchedBlock);
            setChainAsThrown(stack);
            stack.func_77972_a(1, (EntityLivingBase)player);
        }
        return stack;
    }
    
    public static void setChainAsThrown(final ItemStack stack) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new NBTTagCompound());
        }
        stack.func_77978_p().func_74757_a("thrown", true);
    }
    
    public static void setChainAsReturned(final ItemStack stack) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new NBTTagCompound());
        }
        stack.func_77978_p().func_74757_a("thrown", false);
    }
    
    public static boolean doesChainHaveBlock(final ItemStack stack) {
        return stack.func_77978_p() == null || !stack.func_77978_p().func_74767_n("thrown");
    }
    
    public static void setChainAsReturned(final EntityPlayer player) {
        if (player != null && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() == TFItems.chainBlock) {
            setChainAsReturned(player.func_71045_bC());
        }
    }
    
    public boolean hasLaunchedBlock(final ItemStack stack) {
        final Entity cube = this.launchedBlocksMap.get(stack);
        return cube != null && !cube.field_70128_L;
    }
    
    public void setLaunchedBlock(final ItemStack stack, final EntityTFChainBlock launchedCube) {
        this.launchedBlocksMap.put(stack, (Entity)launchedCube);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
    
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (doesChainHaveBlock(stack)) {
            return this.field_77791_bV;
        }
        return TFItems.knightmetalRing.func_77650_f(stack);
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.block;
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        return false;
    }
    
    public int getHarvestLevel(final ItemStack stack, final String toolClass) {
        if (toolClass != null && toolClass.equals("pickaxe")) {
            return 2;
        }
        return -1;
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.knightMetal || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
}
