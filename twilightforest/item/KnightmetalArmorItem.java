// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.EntityModelSet;
import twilightforest.client.model.armor.TFArmorModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import java.util.EnumMap;
import net.minecraftforge.client.IItemRenderProperties;
import java.util.function.Consumer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import java.util.Map;
import net.minecraft.world.item.ArmorItem;

public class KnightmetalArmorItem extends ArmorItem
{
    private static final Map<EquipmentSlot, HumanoidModel<?>> knightlyArmorModel;
    
    public KnightmetalArmorItem(final ArmorMaterial material, final EquipmentSlot slot, final Item.Properties props) {
        super(material, slot, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, final String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/knightly_2.png";
        }
        return "twilightforest:textures/armor/knightly_1.png";
    }
    
    public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
        consumer.accept((IItemRenderProperties)ArmorRender.INSTANCE);
    }
    
    static {
        knightlyArmorModel = new EnumMap<EquipmentSlot, HumanoidModel<?>>(EquipmentSlot.class);
    }
    
    private static final class ArmorRender implements IItemRenderProperties
    {
        private static final ArmorRender INSTANCE;
        
        public <A extends HumanoidModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlot armorSlot, final A defModel) {
            final EntityModelSet models = Minecraft.m_91087_().m_167973_();
            final ModelPart root = models.m_171103_((armorSlot == EquipmentSlot.LEGS) ? TFModelLayers.KNIGHTMETAL_ARMOR_INNER : TFModelLayers.KNIGHTMETAL_ARMOR_OUTER);
            return (A)new TFArmorModel(root);
        }
        
        static {
            INSTANCE = new ArmorRender();
        }
    }
}
