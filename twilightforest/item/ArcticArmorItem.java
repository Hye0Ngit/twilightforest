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
import net.minecraft.world.level.Level;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ArmorItem;

public class ArcticArmorItem extends ArmorItem implements DyeableLeatherItem
{
    private static final MutableComponent TOOLTIP;
    
    public ArcticArmorItem(final ArmorMaterial armorMaterial, final EquipmentSlot armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, @Nullable final String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/arcticarmor_2" + ((layer == null) ? "_dyed" : "_overlay") + ".png";
        }
        return "twilightforest:textures/armor/arcticarmor_1" + ((layer == null) ? "_dyed" : "_overlay") + ".png";
    }
    
    public boolean m_41113_(final ItemStack stack) {
        final CompoundTag CompoundNBT = stack.m_41783_();
        return CompoundNBT != null && CompoundNBT.m_128425_("display", 10) && CompoundNBT.m_128469_("display").m_128425_("color", 3);
    }
    
    public int m_41121_(final ItemStack stack) {
        return this.getColor(stack, 1);
    }
    
    public void m_41123_(final ItemStack stack) {
        this.removeColor(stack, 1);
    }
    
    public void m_41115_(final ItemStack stack, final int color) {
        this.setColor(stack, color, 1);
    }
    
    public int getColor(final ItemStack stack, final int type) {
        final String string = "";
        final CompoundTag stackTagCompound = stack.m_41783_();
        int color = 12439513;
        if (stackTagCompound != null) {
            final CompoundTag displayCompound = stackTagCompound.m_128469_("display");
            if (displayCompound.m_128425_("color" + string, 3)) {
                color = displayCompound.m_128451_("color" + string);
            }
        }
        if (type == 0) {
            return 16777215;
        }
        return color;
    }
    
    public void removeColor(final ItemStack stack, final int type) {
        final String string = "";
        final CompoundTag stackTagCompound = stack.m_41783_();
        if (stackTagCompound != null) {
            final CompoundTag displayCompound = stackTagCompound.m_128469_("display");
            if (displayCompound.m_128441_("color" + string)) {
                displayCompound.m_128473_("color" + string);
            }
            if (displayCompound.m_128441_("hasColor")) {
                displayCompound.m_128379_("hasColor", false);
            }
        }
    }
    
    public void setColor(final ItemStack stack, final int color, final int type) {
        final String string = "";
        CompoundTag stackTagCompound = stack.m_41783_();
        if (stackTagCompound == null) {
            stackTagCompound = new CompoundTag();
            stack.m_41751_(stackTagCompound);
        }
        final CompoundTag displayCompound = stackTagCompound.m_128469_("display");
        if (!stackTagCompound.m_128425_("display", 10)) {
            stackTagCompound.m_128365_("display", (Tag)displayCompound);
        }
        displayCompound.m_128405_("color" + string, color);
        displayCompound.m_128379_("hasColor", true);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level worldIn, final List<Component> tooltip, final TooltipFlag flagIn) {
        super.m_7373_(stack, worldIn, (List)tooltip, flagIn);
        tooltip.add((Component)ArcticArmorItem.TOOLTIP);
    }
    
    public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
        consumer.accept((IItemRenderProperties)ArmorRender.INSTANCE);
    }
    
    static {
        TOOLTIP = new TranslatableComponent("item.twilightforest.arctic_armor.tooltip").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.GRAY));
    }
    
    private static final class ArmorRender implements IItemRenderProperties
    {
        private static final ArmorRender INSTANCE;
        
        public <A extends HumanoidModel<?>> A getArmorModel(final LivingEntity entityLiving, final ItemStack itemStack, final EquipmentSlot armorSlot, final A defModel) {
            final EntityModelSet models = Minecraft.m_91087_().m_167973_();
            final ModelPart root = models.m_171103_((armorSlot == EquipmentSlot.LEGS) ? TFModelLayers.ARCTIC_ARMOR_INNER : TFModelLayers.ARCTIC_ARMOR_OUTER);
            return (A)new TFArmorModel(root);
        }
        
        static {
            INSTANCE = new ArmorRender();
        }
    }
}
