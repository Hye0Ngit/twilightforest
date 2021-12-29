// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.EntityModelSet;
import twilightforest.client.model.armor.TFArmorModel;
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
import java.util.Iterator;
import java.util.Map;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import twilightforest.data.CustomTagGenerator;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;

public class PhantomArmorItem extends ArmorItem
{
    private static final MutableComponent TOOLTIP;
    
    public PhantomArmorItem(final ArmorMaterial armorMaterial, final EquipmentSlot armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, final String layer) {
        return "twilightforest:textures/armor/phantom_1.png";
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return !CustomTagGenerator.EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS.m_8110_((Object)enchantment) && super.canApplyAtEnchantingTable(stack, enchantment);
    }
    
    public boolean isBookEnchantable(final ItemStack stack, final ItemStack book) {
        final Map<Enchantment, Integer> enchants = EnchantmentHelper.m_44831_(book);
        for (final Enchantment ench : enchants.keySet()) {
            if (CustomTagGenerator.EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS.m_8110_((Object)ench)) {
                return false;
            }
        }
        return super.isBookEnchantable(stack, book);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flag) {
        tooltip.add((Component)PhantomArmorItem.TOOLTIP);
    }
    
    public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
        consumer.accept((IItemRenderProperties)ArmorRender.INSTANCE);
    }
    
    static {
        TOOLTIP = new TranslatableComponent("item.twilightforest.phantom_armor.tooltip").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.GRAY));
    }
    
    private static final class ArmorRender implements IItemRenderProperties
    {
        private static final ArmorRender INSTANCE;
        
        public <A extends HumanoidModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlot armorSlot, final A defModel) {
            final EntityModelSet models = Minecraft.m_91087_().m_167973_();
            final ModelPart root = models.m_171103_((armorSlot == EquipmentSlot.LEGS) ? TFModelLayers.PHANTOM_ARMOR_INNER : TFModelLayers.PHANTOM_ARMOR_OUTER);
            return (A)new TFArmorModel(root);
        }
        
        static {
            INSTANCE = new ArmorRender();
        }
    }
}
