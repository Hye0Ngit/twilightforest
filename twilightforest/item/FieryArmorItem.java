// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.EnumMap;
import twilightforest.client.model.armor.FieryArmorModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import java.util.Map;
import net.minecraft.item.ArmorItem;

public class FieryArmorItem extends ArmorItem
{
    private static final Map<EquipmentSlotType, BipedModel<?>> fieryArmorModel;
    
    public FieryArmorItem(final IArmorMaterial armorMaterial, final EquipmentSlotType armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "twilightforest:textures/armor/fiery_2.png";
        }
        return "twilightforest:textures/armor/fiery_1.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
    
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlotType armorSlot, final A oldModel) {
        return (A)FieryArmorItem.fieryArmorModel.get(armorSlot);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void initArmorModel() {
        FieryArmorItem.fieryArmorModel.put(EquipmentSlotType.HEAD, new FieryArmorModel(0.75f));
        FieryArmorItem.fieryArmorModel.put(EquipmentSlotType.CHEST, new FieryArmorModel(1.0f));
        FieryArmorItem.fieryArmorModel.put(EquipmentSlotType.LEGS, new FieryArmorModel(0.5f));
        FieryArmorItem.fieryArmorModel.put(EquipmentSlotType.FEET, new FieryArmorModel(1.0f));
    }
    
    static {
        fieryArmorModel = new EnumMap<EquipmentSlotType, BipedModel<?>>(EquipmentSlotType.class);
    }
}
