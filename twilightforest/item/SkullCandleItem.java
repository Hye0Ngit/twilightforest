// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.level.ItemLike;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import twilightforest.block.entity.SkullCandleBlockEntity;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtUtils;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import org.apache.commons.lang3.StringUtils;
import twilightforest.block.TFBlocks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import org.apache.commons.lang3.text.WordUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import twilightforest.block.AbstractSkullCandleBlock;
import net.minecraft.world.item.StandingAndWallBlockItem;

public class SkullCandleItem extends StandingAndWallBlockItem
{
    public SkullCandleItem(final AbstractSkullCandleBlock floor, final AbstractSkullCandleBlock wall, final Item.Properties properties) {
        super((Block)floor, (Block)wall, properties);
    }
    
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flag) {
        if (stack.m_41782_()) {
            final CompoundTag tag = stack.m_41737_("BlockEntityTag");
            if (tag != null && tag.m_128441_("CandleColor") && tag.m_128441_("CandleAmount")) {
                tooltip.add((Component)new TranslatableComponent((tag.m_128451_("CandleAmount") > 1) ? "item.twilightforest.skull_candle.desc.multiple" : "item.twilightforest.skull_candle.desc", new Object[] { String.valueOf(tag.m_128451_("CandleAmount")), WordUtils.capitalize(AbstractSkullCandleBlock.CandleColors.colorFromInt(tag.m_128451_("CandleColor")).m_7912_().replace("\"", "").replace("_", " ")) }).m_130940_(ChatFormatting.GRAY));
            }
        }
    }
    
    public Component m_7626_(final ItemStack pStack) {
        if (pStack.m_150930_(((AbstractSkullCandleBlock)TFBlocks.PLAYER_SKULL_CANDLE.get()).m_5456_()) && pStack.m_41782_()) {
            String s = null;
            final CompoundTag compoundtag = pStack.m_41783_();
            if (compoundtag.m_128425_("SkullOwner", 8)) {
                s = compoundtag.m_128461_("SkullOwner");
            }
            else if (compoundtag.m_128425_("SkullOwner", 10)) {
                final CompoundTag compoundtag2 = compoundtag.m_128469_("SkullOwner");
                if (compoundtag2.m_128425_("Name", 8)) {
                    s = compoundtag2.m_128461_("Name");
                }
            }
            if (s != null) {
                return (Component)new TranslatableComponent(this.m_5524_() + ".named", new Object[] { s });
            }
        }
        return super.m_7626_(pStack);
    }
    
    public void m_142312_(final CompoundTag pCompoundTag) {
        super.m_142312_(pCompoundTag);
        if (pCompoundTag.m_128425_("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)pCompoundTag.m_128461_("SkullOwner"))) {
            final GameProfile gameprofile = new GameProfile((UUID)null, pCompoundTag.m_128461_("SkullOwner"));
            SkullCandleBlockEntity.m_155738_(gameprofile, p_151177_ -> pCompoundTag.m_128365_("SkullOwner", (Tag)NbtUtils.m_129230_(new CompoundTag(), p_151177_)));
        }
    }
    
    public boolean canEquip(final ItemStack stack, final EquipmentSlot armorType, final Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }
    
    @Nullable
    public EquipmentSlot getEquipmentSlot(final ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> list) {
        if (this.m_41389_(tab)) {
            final ItemStack istack = new ItemStack((ItemLike)this);
            final CompoundTag tag = new CompoundTag();
            tag.m_128405_("CandleAmount", 1);
            tag.m_128405_("CandleColor", 0);
            istack.m_41700_("BlockEntityTag", (Tag)tag);
            list.add((Object)istack);
        }
    }
}
