// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.EnumMap;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.stats.Stats;
import net.minecraft.state.Property;
import net.minecraft.block.CauldronBlock;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import twilightforest.client.model.armor.ArcticArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import java.util.Map;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ArmorItem;

public class ArcticArmorItem extends ArmorItem implements IDyeableArmorItem
{
    private static final Map<EquipmentSlotType, BipedModel<?>> arcticArmorModel;
    
    public ArcticArmorItem(final IArmorMaterial armorMaterial, final EquipmentSlotType armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "twilightforest:textures/armor/arcticarmor_2" + ((layer == null) ? "_dyed" : "_overlay") + ".png";
        }
        return "twilightforest:textures/armor/arcticarmor_1" + ((layer == null) ? "_dyed" : "_overlay") + ".png";
    }
    
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlotType armorSlot, final A oldM) {
        return (A)ArcticArmorItem.arcticArmorModel.get(armorSlot);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void initArmorModel() {
        ArcticArmorItem.arcticArmorModel.put(EquipmentSlotType.HEAD, new ArcticArmorModel(0.75f));
        ArcticArmorItem.arcticArmorModel.put(EquipmentSlotType.CHEST, new ArcticArmorModel(1.0f));
        ArcticArmorItem.arcticArmorModel.put(EquipmentSlotType.LEGS, new ArcticArmorModel(0.5f));
        ArcticArmorItem.arcticArmorModel.put(EquipmentSlotType.FEET, new ArcticArmorModel(1.0f));
    }
    
    public boolean func_200883_f_(final ItemStack stack) {
        final CompoundNBT CompoundNBT = stack.func_77978_p();
        return CompoundNBT != null && CompoundNBT.func_150297_b("display", 10) && CompoundNBT.func_74775_l("display").func_150297_b("color", 3);
    }
    
    public int func_200886_f(final ItemStack stack) {
        return this.getColor(stack, 1);
    }
    
    public void func_200884_g(final ItemStack stack) {
        this.removeColor(stack, 1);
    }
    
    public void func_200885_a(final ItemStack stack, final int color) {
        this.setColor(stack, color, 1);
    }
    
    public int getColor(final ItemStack stack, final int type) {
        final String string = "";
        final CompoundNBT stackTagCompound = stack.func_77978_p();
        int color = 12439513;
        if (stackTagCompound != null) {
            final CompoundNBT displayCompound = stackTagCompound.func_74775_l("display");
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
        final CompoundNBT stackTagCompound = stack.func_77978_p();
        if (stackTagCompound != null) {
            final CompoundNBT displayCompound = stackTagCompound.func_74775_l("display");
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
        CompoundNBT stackTagCompound = stack.func_77978_p();
        if (stackTagCompound == null) {
            stackTagCompound = new CompoundNBT();
            stack.func_77982_d(stackTagCompound);
        }
        final CompoundNBT displayCompound = stackTagCompound.func_74775_l("display");
        if (!stackTagCompound.func_150297_b("display", 10)) {
            stackTagCompound.func_218657_a("display", (INBT)displayCompound);
        }
        displayCompound.func_74768_a("color" + string, color);
        displayCompound.func_74757_a("hasColor", true);
    }
    
    public ActionResultType onItemUseFirst(final ItemStack itemstack, final ItemUseContext context) {
        if (this.func_200883_f_(itemstack)) {
            final BlockState blockAt = context.func_195991_k().func_180495_p(context.func_195995_a());
            if (blockAt.func_177230_c() instanceof CauldronBlock && (int)blockAt.func_177229_b((Property)CauldronBlock.field_176591_a) > 0) {
                this.func_200884_g(itemstack);
                context.func_195999_j().func_195066_a(Stats.field_188079_M);
                ((CauldronBlock)blockAt.func_177230_c()).func_176590_a(context.func_195991_k(), context.func_195995_a(), blockAt, (int)blockAt.func_177229_b((Property)CauldronBlock.field_176591_a) - 1);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        super.func_77624_a(stack, worldIn, (List)tooltip, flagIn);
        tooltip.add((ITextComponent)new TranslationTextComponent("item.twilightforest.arctic_armor.tooltip"));
    }
    
    static {
        arcticArmorModel = new EnumMap<EquipmentSlotType, BipedModel<?>>(EquipmentSlotType.class);
    }
}
