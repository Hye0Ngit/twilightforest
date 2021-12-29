// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import java.util.Iterator;
import java.util.List;
import java.util.EnumSet;
import net.minecraft.world.entity.item.ItemEntity;
import twilightforest.entity.passive.QuestRam;
import net.minecraft.world.entity.ai.goal.Goal;

public class EatLooseGoal extends Goal
{
    private final QuestRam temptedQuestRam;
    private int delayTemptCounter;
    private ItemEntity temptingItem;
    
    public EatLooseGoal(final QuestRam entityTFQuestRam) {
        this.temptedQuestRam = entityTFQuestRam;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingItem = null;
        final List<ItemEntity> nearbyItems = this.temptedQuestRam.f_19853_.m_6443_((Class)ItemEntity.class, this.temptedQuestRam.m_142469_().m_82377_(2.0, 2.0, 2.0), e -> e.m_6084_() && !e.m_32055_().m_41619_());
        for (final ItemEntity itemNearby : nearbyItems) {
            final DyeColor color = QuestRam.guessColor(itemNearby.m_32055_());
            if (color != null && !this.temptedQuestRam.isColorPresent(color)) {
                this.temptingItem = itemNearby;
                break;
            }
        }
        return this.temptingItem != null;
    }
    
    public void m_8041_() {
        this.temptingItem = null;
        this.temptedQuestRam.m_21573_().m_26573_();
        this.delayTemptCounter = 100;
    }
    
    public void m_8037_() {
        this.temptedQuestRam.m_21563_().m_24960_((Entity)this.temptingItem, 30.0f, (float)this.temptedQuestRam.m_8132_());
        if (this.temptedQuestRam.m_20280_((Entity)this.temptingItem) < 6.25 && this.temptedQuestRam.tryAccept(this.temptingItem.m_32055_())) {
            this.temptingItem.m_146870_();
        }
    }
}
