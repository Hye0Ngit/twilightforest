// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.EntityModelSet;
import twilightforest.client.model.armor.YetiArmorModel;
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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;

public class YetiArmorItem extends ArmorItem
{
    private static final MutableComponent TOOLTIP;
    
    public YetiArmorItem(final ArmorMaterial material, final EquipmentSlot slot, final Item.Properties props) {
        super(material, slot, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, final String layer) {
        if (slot == EquipmentSlot.LEGS || slot == EquipmentSlot.CHEST) {
            return "twilightforest:textures/armor/yetiarmor_2.png";
        }
        return "twilightforest:textures/armor/yetiarmor_1.png";
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> list) {
        if (this.m_41389_(tab)) {
            final ItemStack istack = new ItemStack((ItemLike)this);
            switch (this.f_40377_) {
                case HEAD:
                case CHEST:
                case LEGS: {
                    istack.m_41663_(Enchantments.f_44965_, 2);
                    break;
                }
                case FEET: {
                    istack.m_41663_(Enchantments.f_44965_, 2);
                    istack.m_41663_(Enchantments.f_44967_, 4);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltips, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltips, flags);
        tooltips.add((Component)YetiArmorItem.TOOLTIP);
    }
    
    public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
        consumer.accept((IItemRenderProperties)ArmorRender.INSTANCE);
    }
    
    static {
        TOOLTIP = new TranslatableComponent("item.twilightforest.yeti_armor.tooltip").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.GRAY));
    }
    
    private static final class ArmorRender implements IItemRenderProperties
    {
        private static final ArmorRender INSTANCE;
        
        public <A extends HumanoidModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlot armorSlot, final A defModel) {
            final EntityModelSet models = Minecraft.m_91087_().m_167973_();
            final ModelPart root = models.m_171103_((armorSlot == EquipmentSlot.LEGS) ? TFModelLayers.YETI_ARMOR_INNER : TFModelLayers.YETI_ARMOR_OUTER);
            return (A)new YetiArmorModel(armorSlot, root);
        }
        
        static {
            INSTANCE = new ArmorRender();
        }
    }
}
