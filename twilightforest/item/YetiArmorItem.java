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
import twilightforest.client.model.armor.YetiArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.LivingEntity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemGroup;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import java.util.Map;
import net.minecraft.item.ArmorItem;

public class YetiArmorItem extends ArmorItem
{
    private static final Map<EquipmentSlotType, BipedModel<?>> yetiArmorModel;
    
    public YetiArmorItem(final IArmorMaterial material, final EquipmentSlotType slot, final Item.Properties props) {
        super(material, slot, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS || slot == EquipmentSlotType.CHEST) {
            return "twilightforest:textures/armor/yetiarmor_2.png";
        }
        return "twilightforest:textures/armor/yetiarmor_1.png";
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((IItemProvider)this);
            switch (this.field_77881_a) {
                case HEAD:
                case CHEST:
                case LEGS: {
                    istack.func_77966_a(Enchantments.field_180310_c, 2);
                    break;
                }
                case FEET: {
                    istack.func_77966_a(Enchantments.field_180310_c, 2);
                    istack.func_77966_a(Enchantments.field_180309_e, 4);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlotType armorSlot, final A _default) {
        return (A)YetiArmorItem.yetiArmorModel.get(armorSlot);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void initArmorModel() {
        YetiArmorItem.yetiArmorModel.put(EquipmentSlotType.HEAD, new YetiArmorModel(EquipmentSlotType.HEAD, 0.75f));
        YetiArmorItem.yetiArmorModel.put(EquipmentSlotType.CHEST, new YetiArmorModel(EquipmentSlotType.CHEST, 1.0f));
        YetiArmorItem.yetiArmorModel.put(EquipmentSlotType.LEGS, new YetiArmorModel(EquipmentSlotType.LEGS, 0.5f));
        YetiArmorItem.yetiArmorModel.put(EquipmentSlotType.FEET, new YetiArmorModel(EquipmentSlotType.FEET, 1.0f));
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltips, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltips, flags);
        tooltips.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
    
    static {
        yetiArmorModel = new EnumMap<EquipmentSlotType, BipedModel<?>>(EquipmentSlotType.class);
    }
}
