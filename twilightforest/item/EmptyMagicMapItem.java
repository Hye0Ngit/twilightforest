// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ComplexItem;

public class EmptyMagicMapItem extends ComplexItem
{
    protected EmptyMagicMapItem(final Item.Properties props) {
        super(props);
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level worldIn, final Player playerIn, final InteractionHand handIn) {
        final ItemStack emptyMapStack = playerIn.m_21120_(handIn);
        if (worldIn.f_46443_) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19098_((Object)emptyMapStack);
        }
        if (worldIn instanceof final ServerLevel level) {
            if (!TFGenerationSettings.usesTwilightChunkGenerator(level)) {
                playerIn.m_5661_((Component)new TranslatableComponent("twilightforest.ui.magicmap.fail"), true);
                return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)emptyMapStack);
            }
        }
        final ItemStack newMapStack = MagicMapItem.setupNewMap(worldIn, Mth.m_14107_(playerIn.m_20185_()), Mth.m_14107_(playerIn.m_20189_()), (byte)4, true, false);
        if (!playerIn.m_150110_().f_35937_) {
            emptyMapStack.m_41774_(1);
        }
        if (emptyMapStack.m_41619_()) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)newMapStack);
        }
        if (!playerIn.m_150109_().m_36054_(newMapStack.m_41777_())) {
            playerIn.m_36176_(newMapStack, false);
        }
        playerIn.m_36246_(Stats.f_12982_.m_12902_((Object)this));
        playerIn.f_19853_.m_6269_((Player)null, (Entity)playerIn, SoundEvents.f_12493_, playerIn.m_5720_(), 1.0f, 1.0f);
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)emptyMapStack);
    }
}
