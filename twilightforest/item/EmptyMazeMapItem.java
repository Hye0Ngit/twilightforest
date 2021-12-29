// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ComplexItem;

public class EmptyMazeMapItem extends ComplexItem
{
    boolean mapOres;
    
    protected EmptyMazeMapItem(final boolean mapOres, final Item.Properties props) {
        super(props);
        this.mapOres = mapOres;
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level worldIn, final Player playerIn, final InteractionHand handIn) {
        final ItemStack itemstack = MazeMapItem.setupNewMap(worldIn, Mth.m_14107_(playerIn.m_20185_()), Mth.m_14107_(playerIn.m_20189_()), (byte)0, true, false, Mth.m_14107_(playerIn.m_20186_()), this.mapOres);
        final ItemStack itemstack2 = playerIn.m_21120_(handIn);
        if (!playerIn.m_150110_().f_35937_) {
            itemstack2.m_41774_(1);
        }
        if (itemstack2.m_41619_()) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)itemstack);
        }
        if (!playerIn.m_150109_().m_36054_(itemstack.m_41777_())) {
            playerIn.m_36176_(itemstack, false);
        }
        playerIn.m_36246_(Stats.f_12982_.m_12902_((Object)this));
        playerIn.f_19853_.m_6269_((Player)null, (Entity)playerIn, SoundEvents.f_12493_, playerIn.m_5720_(), 1.0f, 1.0f);
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)itemstack2);
    }
}
