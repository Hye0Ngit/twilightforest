// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.server.level.ServerPlayer;
import java.util.Iterator;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import twilightforest.TFSounds;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.Item;

public class BrittleFlaskItem extends Item
{
    private static Potion lastUsedPotion;
    private static int timesUsed;
    private static boolean advancementWindow;
    public static int seconds;
    
    public BrittleFlaskItem(final Item.Properties properties) {
        super(properties);
    }
    
    public ItemStack m_7968_() {
        final ItemStack stack = new ItemStack((ItemLike)this);
        stack.m_41784_().m_128405_("Uses", 0);
        stack.m_41784_().m_128405_("Breakage", 0);
        stack.m_41784_().m_128379_("Refillable", true);
        PotionUtils.m_43549_(stack, Potions.f_43598_);
        return stack;
    }
    
    public boolean m_142522_(final ItemStack stack) {
        return stack.m_41784_().m_128441_("Potion");
    }
    
    public int m_142159_(final ItemStack stack) {
        return PotionUtils.m_43575_(stack);
    }
    
    public boolean m_5812_(final ItemStack stack) {
        return super.m_5812_(stack) || !PotionUtils.m_43547_(stack).isEmpty();
    }
    
    public boolean m_142305_(final ItemStack stack, final ItemStack other, final Slot slot, final ClickAction action, final Player player, final SlotAccess access) {
        final CompoundTag flaskTag = stack.m_41784_();
        final CompoundTag potionTag = other.m_41784_();
        if (action == ClickAction.SECONDARY && other.m_150930_(Items.f_42589_) && potionTag.m_128441_("Potion") && this.canBeRefilled(stack)) {
            if (flaskTag.m_128441_("Potion") && flaskTag.m_128461_("Potion").equals(potionTag.m_128461_("Potion")) && flaskTag.m_128451_("Uses") < 4) {
                if (!player.m_150110_().f_35937_) {
                    other.m_41774_(1);
                    player.m_150109_().m_36054_(new ItemStack((ItemLike)Items.f_42590_));
                }
                flaskTag.m_128405_("Uses", flaskTag.m_128451_("Uses") + 1);
                player.f_19853_.m_6269_((Player)null, (Entity)player, TFSounds.FLASK_FILL, player.m_5720_(), flaskTag.m_128451_("Uses") * 0.33f, player.f_19853_.f_46441_.nextFloat() * 0.1f + 0.9f);
                return true;
            }
            if (!flaskTag.m_128441_("Potion")) {
                if (!player.m_150110_().f_35937_) {
                    other.m_41774_(1);
                    player.m_150109_().m_36054_(new ItemStack((ItemLike)Items.f_42590_));
                }
                flaskTag.m_128359_("Potion", potionTag.m_128461_("Potion"));
                flaskTag.m_128405_("Uses", flaskTag.m_128451_("Uses") + 1);
                player.f_19853_.m_6269_((Player)null, (Entity)player, TFSounds.FLASK_FILL, player.m_5720_(), flaskTag.m_128451_("Uses") * 0.33f, player.f_19853_.f_46441_.nextFloat() * 0.1f + 0.9f);
                return true;
            }
        }
        return false;
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level level, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        final CompoundTag tag = stack.m_41783_();
        if (tag != null && tag.m_128441_("Potion") && tag.m_128461_("Potion").equals(Potions.f_43598_.toString())) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)player.m_21120_(hand));
        }
        if (tag != null && tag.m_128441_("Uses") && tag.m_128451_("Uses") > 0) {
            return (InteractionResultHolder<ItemStack>)ItemUtils.m_150959_(level, player, hand);
        }
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)player.m_21120_(hand));
    }
    
    public int m_8105_(final ItemStack pStack) {
        return 32;
    }
    
    public UseAnim m_6164_(final ItemStack pStack) {
        return UseAnim.DRINK;
    }
    
    public ItemStack m_5922_(final ItemStack stack, final Level level, final LivingEntity entity) {
        final CompoundTag tag = stack.m_41784_();
        if (entity instanceof final Player player) {
            if (!level.f_46443_) {
                if (!player.m_7500_()) {
                    this.addTowardsAdvancement(Potion.m_43489_(tag.m_128461_("Potion")), player);
                }
                for (final MobEffectInstance mobeffectinstance : PotionUtils.m_43547_(stack)) {
                    if (mobeffectinstance.m_19544_().m_8093_()) {
                        mobeffectinstance.m_19544_().m_19461_((Entity)player, (Entity)player, (LivingEntity)player, mobeffectinstance.m_19564_(), 1.0);
                    }
                    else {
                        player.m_7292_(new MobEffectInstance(mobeffectinstance));
                    }
                }
            }
            player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
            if (!player.m_150110_().f_35937_) {
                tag.m_128405_("Uses", tag.m_128451_("Uses") - 1);
            }
            if (tag.m_128451_("Uses") <= 0) {
                tag.m_128473_("Potion");
            }
            if (this.canBreak() && !player.m_150110_().f_35937_) {
                if (tag.m_128451_("Uses") <= 0) {
                    stack.m_41774_(1);
                    level.m_6269_((Player)null, (Entity)player, TFSounds.BRITTLE_FLASK_BREAK, player.m_5720_(), 1.5f, 0.7f);
                }
                else {
                    tag.m_128405_("Breakage", tag.m_128451_("Breakage") + 1);
                    tag.m_128379_("Refillable", false);
                    level.m_6269_((Player)null, (Entity)player, TFSounds.BRITTLE_FLASK_CRACK, player.m_5720_(), 1.5f, 2.0f);
                }
            }
        }
        return super.m_5922_(stack, level, entity);
    }
    
    private void addTowardsAdvancement(final Potion potionDrank, final Player drinker) {
        if (BrittleFlaskItem.lastUsedPotion == null) {
            BrittleFlaskItem.lastUsedPotion = Potions.f_43598_;
        }
        if (!BrittleFlaskItem.lastUsedPotion.equals(potionDrank)) {
            BrittleFlaskItem.timesUsed = 1;
            BrittleFlaskItem.lastUsedPotion = potionDrank;
            BrittleFlaskItem.advancementWindow = true;
        }
        else {
            ++BrittleFlaskItem.timesUsed;
        }
        if (drinker instanceof final ServerPlayer player) {
            if (drinker.m_6084_() && BrittleFlaskItem.advancementWindow) {
                TFAdvancements.DRINK_FROM_FLASK.trigger(player, BrittleFlaskItem.timesUsed, BrittleFlaskItem.lastUsedPotion);
            }
        }
    }
    
    public static void ticker() {
        if (BrittleFlaskItem.advancementWindow) {
            ++BrittleFlaskItem.seconds;
        }
        if (BrittleFlaskItem.seconds == 8) {
            BrittleFlaskItem.advancementWindow = false;
            BrittleFlaskItem.timesUsed = 0;
            BrittleFlaskItem.lastUsedPotion = null;
            BrittleFlaskItem.seconds = 0;
        }
    }
    
    public boolean canBreak() {
        return true;
    }
    
    public boolean canBeRefilled(final ItemStack stack) {
        return stack.m_41784_().m_128471_("Refillable");
    }
    
    public void m_7373_(final ItemStack stack, @Nullable final Level level, final List<Component> tooltip, final TooltipFlag flag) {
        PotionUtils.m_43555_(stack, (List)tooltip, 1.0f);
        tooltip.add((Component)new TranslatableComponent("item.twilightforest.flask_doses", new Object[] { stack.m_41784_().m_128451_("Uses"), 4 }).m_130940_(ChatFormatting.GRAY));
        if (!stack.m_41784_().m_128471_("Refillable")) {
            tooltip.add((Component)new TranslatableComponent("item.twilightforest.flask_no_refill").m_130940_(ChatFormatting.RED));
        }
    }
    
    public int m_142158_(final ItemStack stack) {
        return (int)(Math.abs(stack.m_41784_().m_128451_("Uses") - 4.0) / 4.0);
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> items) {
        if (this.m_41389_(tab)) {
            final ItemStack stack = new ItemStack((ItemLike)this);
            stack.m_41784_().m_128405_("Uses", 0);
            stack.m_41784_().m_128405_("Breakage", 0);
            stack.m_41784_().m_128379_("Refillable", true);
            items.add((Object)stack);
        }
    }
}
