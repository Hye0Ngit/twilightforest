// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.EnumMap;
import twilightforest.client.model.armor.KnightlyArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import java.util.Map;
import net.minecraft.item.ArmorItem;

public class KnightmetalArmorItem extends ArmorItem
{
    private static final Map<EquipmentSlotType, BipedModel<?>> knightlyArmorModel;
    
    public KnightmetalArmorItem(final IArmorMaterial material, final EquipmentSlotType slot, final Item.Properties props) {
        super(material, slot, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "twilightforest:textures/armor/knightly_2.png";
        }
        return "twilightforest:textures/armor/knightly_1.png";
    }
    
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlotType armorSlot, final A original) {
        return (A)KnightmetalArmorItem.knightlyArmorModel.get(armorSlot);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void initArmorModel() {
        KnightmetalArmorItem.knightlyArmorModel.put(EquipmentSlotType.HEAD, new KnightlyArmorModel(0.75f));
        KnightmetalArmorItem.knightlyArmorModel.put(EquipmentSlotType.CHEST, new KnightlyArmorModel(1.0f));
        KnightmetalArmorItem.knightlyArmorModel.put(EquipmentSlotType.LEGS, new KnightlyArmorModel(0.5f));
        KnightmetalArmorItem.knightlyArmorModel.put(EquipmentSlotType.FEET, new KnightlyArmorModel(1.0f));
    }
    
    static {
        knightlyArmorModel = new EnumMap<EquipmentSlotType, BipedModel<?>>(EquipmentSlotType.class);
    }
}
