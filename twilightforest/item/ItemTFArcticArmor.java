// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.stats.StatList;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockCauldron;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import twilightforest.client.ModelRegisterCallback;

public class ItemTFArcticArmor extends ItemTFArmor implements ModelRegisterCallback
{
    public ItemTFArcticArmor(final ItemArmor.ArmorMaterial armorMaterial, final EntityEquipmentSlot armorType, final EnumRarity rarity) {
        super(armorMaterial, armorType, rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/arcticarmor_2" + ((layer == null) ? "_dyed" : "_overlay") + ".png";
        }
        return "twilightforest:textures/armor/arcticarmor_1" + ((layer == null) ? "_dyed" : "_overlay") + ".png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            list.add((Object)istack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final ModelBiped oldM) {
        return TwilightForestMod.proxy.getArcticArmorModel(armorSlot);
    }
    
    public boolean hasOverlay(final ItemStack stack) {
        return this.func_82814_b(stack) != 16777215;
    }
    
    public boolean func_82816_b_(final ItemStack stack) {
        final NBTTagCompound nbttagcompound = stack.func_77978_p();
        return nbttagcompound != null && nbttagcompound.func_150297_b("display", 10) && nbttagcompound.func_74775_l("display").func_150297_b("color", 3);
    }
    
    public int func_82814_b(final ItemStack stack) {
        return this.getColor(stack, 1);
    }
    
    public void func_82815_c(final ItemStack stack) {
        this.removeColor(stack, 1);
    }
    
    public void func_82813_b(final ItemStack stack, final int color) {
        this.setColor(stack, color, 1);
    }
    
    public int getColor(final ItemStack stack, final int type) {
        final String string = "";
        final NBTTagCompound stackTagCompound = stack.func_77978_p();
        int color = 12439513;
        if (stackTagCompound != null) {
            final NBTTagCompound displayCompound = stackTagCompound.func_74775_l("display");
            if (displayCompound.func_150297_b("color" + string, 3)) {
                color = displayCompound.func_74762_e("color" + string);
            }
        }
        switch (type) {
            case 0: {
                return 16777215;
            }
            default: {
                return color;
            }
        }
    }
    
    public void removeColor(final ItemStack stack, final int type) {
        final String string = "";
        final NBTTagCompound stackTagCompound = stack.func_77978_p();
        if (stackTagCompound != null) {
            final NBTTagCompound displayCompound = stackTagCompound.func_74775_l("display");
            if (displayCompound.func_74764_b("color" + string)) {
                displayCompound.func_82580_o("color" + string);
            }
            if (displayCompound.func_74764_b("hasColor")) {
                displayCompound.func_74757_a("hasColor", false);
            }
        }
    }
    
    public void setColor(final ItemStack stack, final int color, final int type) {
        final String string = "";
        NBTTagCompound stackTagCompound = stack.func_77978_p();
        if (stackTagCompound == null) {
            stackTagCompound = new NBTTagCompound();
            stack.func_77982_d(stackTagCompound);
        }
        final NBTTagCompound displayCompound = stackTagCompound.func_74775_l("display");
        if (!stackTagCompound.func_150297_b("display", 10)) {
            stackTagCompound.func_74782_a("display", (NBTBase)displayCompound);
        }
        displayCompound.func_74768_a("color" + string, color);
        displayCompound.func_74757_a("hasColor", true);
    }
    
    public EnumActionResult onItemUseFirst(final EntityPlayer player, final World world, final BlockPos pos, final EnumFacing side, final float hitX, final float hitY, final float hitZ, final EnumHand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (this.func_82816_b_(stack)) {
            final IBlockState blockAt = world.func_180495_p(pos);
            if (blockAt.func_177230_c() instanceof BlockCauldron && (int)blockAt.func_177229_b((IProperty)BlockCauldron.field_176591_a) > 0) {
                this.func_82815_c(stack);
                player.func_71029_a(StatList.field_188079_M);
                ((BlockCauldron)blockAt.func_177230_c()).func_176590_a(world, pos, blockAt, (int)blockAt.func_177229_b((IProperty)BlockCauldron.field_176591_a) - 1);
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World worldIn, final List<String> tooltip, final ITooltipFlag flagIn) {
        super.func_77624_a(stack, worldIn, (List)tooltip, flagIn);
        tooltip.add(I18n.func_135052_a("item.twilightforest.arctic_armor.tooltip", new Object[0]));
    }
}
