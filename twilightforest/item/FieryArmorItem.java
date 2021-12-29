// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.EntityModelSet;
import twilightforest.client.model.armor.FieryArmorModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.IItemRenderProperties;
import java.util.function.Consumer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;

public class FieryArmorItem extends ArmorItem
{
    private static final MutableComponent TOOLTIP;
    
    public FieryArmorItem(final ArmorMaterial armorMaterial, final EquipmentSlot armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, final String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/fiery_2.png";
        }
        return "twilightforest:textures/armor/fiery_1.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)FieryArmorItem.TOOLTIP);
    }
    
    public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
        consumer.accept((IItemRenderProperties)ArmorRender.INSTANCE);
    }
    
    static {
        TOOLTIP = new TranslatableComponent("item.twilightforest.fiery_armor.tooltip").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.GRAY));
    }
    
    private static final class ArmorRender implements IItemRenderProperties
    {
        private static final ArmorRender INSTANCE;
        
        public <A extends HumanoidModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlot armorSlot, final A defModel) {
            final EntityModelSet models = Minecraft.m_91087_().m_167973_();
            final ModelPart root = models.m_171103_((armorSlot == EquipmentSlot.LEGS) ? TFModelLayers.FIERY_ARMOR_INNER : TFModelLayers.FIERY_ARMOR_OUTER);
            return (A)new FieryArmorModel(root);
        }
        
        static {
            INSTANCE = new ArmorRender();
        }
    }
}
