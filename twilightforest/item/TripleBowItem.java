// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.stats.Stats;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;

public class TripleBowItem extends BowItem
{
    public TripleBowItem(final Item.Properties props) {
        super(props);
    }
    
    public void m_5551_(final ItemStack stack, final Level worldIn, final LivingEntity entityLiving, final int timeLeft) {
        if (entityLiving instanceof final Player entityplayer) {
            final boolean flag = entityplayer.m_150110_().f_35937_ || EnchantmentHelper.m_44843_(Enchantments.f_44952_, stack) > 0;
            ItemStack itemstack = entityplayer.m_6298_(stack);
            int i = this.m_8105_(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.m_41619_() || flag);
            if (i < 0) {
                return;
            }
            if (!itemstack.m_41619_() || flag) {
                if (itemstack.m_41619_()) {
                    itemstack = new ItemStack((ItemLike)Items.f_42412_);
                }
                final float f = m_40661_(i);
                if (f >= 0.1) {
                    final boolean flag2 = entityplayer.m_150110_().f_35937_ || (itemstack.m_41720_() instanceof ArrowItem && ((ArrowItem)itemstack.m_41720_()).isInfinite(itemstack, stack, entityplayer));
                    if (!worldIn.f_46443_) {
                        final ArrowItem arrowitem = (ArrowItem)((itemstack.m_41720_() instanceof ArrowItem) ? itemstack.m_41720_() : Items.f_42412_);
                        final AbstractArrow entityarrow = arrowitem.m_6394_(worldIn, itemstack, (LivingEntity)entityplayer);
                        entityarrow.m_37251_((Entity)entityplayer, entityplayer.m_146909_(), entityplayer.m_146908_(), 0.0f, f * 3.0f, 1.0f);
                        final AbstractArrow entityarrow2 = arrowitem.m_6394_(worldIn, itemstack, (LivingEntity)entityplayer);
                        entityarrow2.m_37251_((Entity)entityLiving, entityLiving.m_146909_(), entityLiving.m_146908_(), 0.0f, f * 2.0f, 1.0f);
                        entityarrow2.m_20256_(entityarrow2.m_20184_().m_82520_(0.0, 0.15, 0.0));
                        entityarrow2.m_6034_(entityarrow2.m_20185_(), entityarrow2.m_20186_() + 0.02500000037252903, entityarrow2.m_20189_());
                        entityarrow2.f_36705_ = AbstractArrow.Pickup.CREATIVE_ONLY;
                        final AbstractArrow entityarrow3 = arrowitem.m_6394_(worldIn, itemstack, (LivingEntity)entityplayer);
                        entityarrow3.m_37251_((Entity)entityLiving, entityLiving.m_146909_(), entityLiving.m_146908_(), 0.0f, f * 2.0f, 1.0f);
                        entityarrow3.m_20256_(entityarrow3.m_20184_().m_82492_(0.0, 0.15, 0.0));
                        entityarrow3.m_6034_(entityarrow3.m_20185_(), entityarrow3.m_20186_() + 0.02500000037252903, entityarrow3.m_20189_());
                        entityarrow3.f_36705_ = AbstractArrow.Pickup.CREATIVE_ONLY;
                        if (f == 1.0f) {
                            entityarrow.m_36762_(true);
                            entityarrow2.m_36762_(true);
                            entityarrow3.m_36762_(true);
                        }
                        final int j = EnchantmentHelper.m_44843_(Enchantments.f_44988_, stack);
                        if (j > 0) {
                            entityarrow.m_36781_(entityarrow.m_36789_() + j * 0.5 + 0.5);
                            entityarrow2.m_36781_(entityarrow.m_36789_() + j * 0.5 + 0.5);
                            entityarrow3.m_36781_(entityarrow.m_36789_() + j * 0.5 + 0.5);
                        }
                        final int k = EnchantmentHelper.m_44843_(Enchantments.f_44989_, stack);
                        if (k > 0) {
                            entityarrow.m_36735_(k);
                            entityarrow2.m_36735_(k);
                            entityarrow3.m_36735_(k);
                        }
                        if (EnchantmentHelper.m_44843_(Enchantments.f_44990_, stack) > 0) {
                            entityarrow.m_20254_(100);
                            entityarrow2.m_20254_(100);
                            entityarrow3.m_20254_(100);
                        }
                        stack.m_41622_(1, (LivingEntity)entityplayer, user -> user.m_21190_(entityplayer.m_7655_()));
                        if (flag2 || (entityplayer.m_150110_().f_35937_ && (itemstack.m_41720_() == Items.f_42737_ || itemstack.m_41720_() == Items.f_42738_))) {
                            entityarrow.f_36705_ = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        worldIn.m_7967_((Entity)entityarrow);
                        worldIn.m_7967_((Entity)entityarrow2);
                        worldIn.m_7967_((Entity)entityarrow3);
                    }
                    worldIn.m_6263_((Player)null, entityplayer.m_20185_(), entityplayer.m_20186_(), entityplayer.m_20189_(), SoundEvents.f_11687_, SoundSource.PLAYERS, 1.0f, 1.0f / (worldIn.f_46441_.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
                    if (!flag2 && !entityplayer.m_150110_().f_35937_) {
                        itemstack.m_41774_(1);
                        if (itemstack.m_41619_()) {
                            entityplayer.m_150109_().m_36057_(itemstack);
                        }
                    }
                    entityplayer.m_36246_(Stats.f_12982_.m_12902_((Object)this));
                }
            }
        }
    }
}
