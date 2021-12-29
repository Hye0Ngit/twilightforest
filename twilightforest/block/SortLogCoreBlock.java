// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.CompoundContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ChestBlock;
import twilightforest.util.WorldUtil;
import net.minecraft.world.Container;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SortLogCoreBlock extends SpecialMagicLogBlock
{
    public SortLogCoreBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    void performTreeEffect(final Level world, final BlockPos pos, final Random rand) {
        final List<Container> chests = new ArrayList<Container>();
        int itemCount = 0;
        for (final BlockPos iterPos : WorldUtil.getAllAround(pos, 16)) {
            Container chestInventory = null;
            Container teInventory = null;
            final Block block = world.m_8055_(iterPos).m_60734_();
            if (block instanceof final ChestBlock chestBlock) {
                chestInventory = ChestBlock.m_51511_(chestBlock, block.m_49966_(), world, iterPos, true);
            }
            final BlockEntity te = world.m_7702_(iterPos);
            if (te instanceof Container && !te.m_58901_()) {
                teInventory = (Container)te;
            }
            if (chestInventory != null && teInventory != null && !this.checkIfChestsContains(chests, teInventory)) {
                boolean empty = true;
                for (int i = 0; i < chestInventory.m_6643_(); ++i) {
                    if (!chestInventory.m_8020_(i).m_41619_()) {
                        empty = false;
                        ++itemCount;
                    }
                }
                if (empty) {
                    continue;
                }
                chests.add(chestInventory);
            }
        }
        ItemStack beingSorted = ItemStack.f_41583_;
        int sortedChestNum = -1;
        int sortedSlotNum = -1;
        if (itemCount == 0) {
            return;
        }
        final int itemNumber = rand.nextInt(itemCount);
        int currentNumber = 0;
        for (int j = 0; j < chests.size(); ++j) {
            final Container chest = chests.get(j);
            for (int slotNum = 0; slotNum < chest.m_6643_(); ++slotNum) {
                final ItemStack currentItem = chest.m_8020_(slotNum);
                if (!currentItem.m_41619_() && currentNumber++ == itemNumber) {
                    beingSorted = currentItem;
                    sortedChestNum = j;
                    sortedSlotNum = slotNum;
                }
            }
        }
        if (beingSorted.m_41619_()) {
            return;
        }
        int matchChestNum = -1;
        int matchCount = 0;
        for (int chestNum = 0; chestNum < chests.size(); ++chestNum) {
            final Container chest2 = chests.get(chestNum);
            int currentChestMatches = 0;
            for (int slotNum2 = 0; slotNum2 < chest2.m_6643_(); ++slotNum2) {
                final ItemStack currentItem2 = chest2.m_8020_(slotNum2);
                if (!currentItem2.m_41619_() && this.isSortingMatch(beingSorted, currentItem2)) {
                    currentChestMatches += currentItem2.m_41613_();
                }
            }
            if (currentChestMatches > matchCount) {
                matchCount = currentChestMatches;
                matchChestNum = chestNum;
            }
        }
        if (matchChestNum >= 0 && matchChestNum != sortedChestNum) {
            final Container moveChest = chests.get(matchChestNum);
            final Container oldChest = chests.get(sortedChestNum);
            final int moveSlot = this.getEmptySlotIn(moveChest);
            if (moveSlot >= 0) {
                oldChest.m_6836_(sortedSlotNum, ItemStack.f_41583_);
                moveChest.m_6836_(moveSlot, beingSorted);
            }
        }
        if (beingSorted.m_41613_() < beingSorted.m_41741_()) {
            for (final Container chest2 : chests) {
                for (int slotNum3 = 0; slotNum3 < chest2.m_6643_(); ++slotNum3) {
                    final ItemStack currentItem3 = chest2.m_8020_(slotNum3);
                    if (!currentItem3.m_41619_() && currentItem3 != beingSorted && beingSorted.m_41656_(currentItem3) && currentItem3.m_41783_() != null && beingSorted.m_41783_() != null && beingSorted.m_41783_().equals((Object)currentItem3.m_41783_()) && currentItem3.m_41613_() <= beingSorted.m_41741_() - beingSorted.m_41613_()) {
                        chest2.m_6836_(slotNum3, ItemStack.f_41583_);
                        beingSorted.m_41769_(currentItem3.m_41613_());
                        currentItem3.m_41764_(0);
                    }
                }
            }
        }
    }
    
    private boolean checkIfChestsContains(final List<Container> chests, final Container testChest) {
        for (final Container chest : chests) {
            if (chest == testChest) {
                return true;
            }
            if (chest instanceof CompoundContainer && ((CompoundContainer)chest).m_18927_(testChest)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isSortingMatch(final ItemStack beingSorted, final ItemStack currentItem) {
        return beingSorted.m_41720_().m_41471_() == currentItem.m_41720_().m_41471_();
    }
    
    private int getEmptySlotIn(final Container chest) {
        for (int i = 0; i < chest.m_6643_(); ++i) {
            if (chest.m_8020_(i).m_41619_()) {
                return i;
            }
        }
        return -1;
    }
}
