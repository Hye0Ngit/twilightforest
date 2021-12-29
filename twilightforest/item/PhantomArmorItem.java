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
import net.minecraft.enchantment.BindingCurseEnchantment;
import net.minecraft.enchantment.VanishingCurseEnchantment;
import net.minecraft.enchantment.Enchantment;
import twilightforest.client.model.armor.PhantomArmorModel;
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
import net.minecraft.item.ArmorItem;

public class PhantomArmorItem extends ArmorItem
{
    private static final Map<EquipmentSlotType, BipedModel<?>> phantomArmorModel;
    
    public PhantomArmorItem(final IArmorMaterial armorMaterial, final EquipmentSlotType armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        return "twilightforest:textures/armor/phantom_1.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlotType armorSlot, final A original) {
        return (A)PhantomArmorItem.phantomArmorModel.get(armorSlot);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void initArmorModel() {
        PhantomArmorItem.phantomArmorModel.put(EquipmentSlotType.HEAD, new PhantomArmorModel(EquipmentSlotType.HEAD, 0.75f));
        PhantomArmorItem.phantomArmorModel.put(EquipmentSlotType.CHEST, new PhantomArmorModel(EquipmentSlotType.CHEST, 1.0f));
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return !(enchantment instanceof VanishingCurseEnchantment) && !(enchantment instanceof BindingCurseEnchantment) && enchantment.field_77351_y.func_77557_a(stack.func_77973_b());
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flag) {
        tooltip.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
    
    static {
        phantomArmorModel = new EnumMap<EquipmentSlotType, BipedModel<?>>(EquipmentSlotType.class);
    }
}
