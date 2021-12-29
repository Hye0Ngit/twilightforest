// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.item.DyeColor;
import java.util.Iterator;
import java.util.List;
import java.util.EnumSet;
import net.minecraft.entity.item.ItemEntity;
import twilightforest.entity.passive.QuestRamEntity;
import net.minecraft.entity.ai.goal.Goal;

public class EatLooseGoal extends Goal
{
    private final QuestRamEntity temptedQuestRam;
    private int delayTemptCounter;
    private ItemEntity temptingItem;
    
    public EatLooseGoal(final QuestRamEntity entityTFQuestRam) {
        this.temptedQuestRam = entityTFQuestRam;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingItem = null;
        final List<ItemEntity> nearbyItems = this.temptedQuestRam.field_70170_p.func_175647_a((Class)ItemEntity.class, this.temptedQuestRam.func_174813_aQ().func_72314_b(2.0, 2.0, 2.0), e -> e.func_70089_S() && !e.func_92059_d().func_190926_b());
        for (final ItemEntity itemNearby : nearbyItems) {
            final DyeColor color = QuestRamEntity.guessColor(itemNearby.func_92059_d());
            if (color != null && !this.temptedQuestRam.isColorPresent(color)) {
                this.temptingItem = itemNearby;
                break;
            }
        }
        return this.temptingItem != null;
    }
    
    public void func_75251_c() {
        this.temptingItem = null;
        this.temptedQuestRam.func_70661_as().func_75499_g();
        this.delayTemptCounter = 100;
    }
    
    public void func_75246_d() {
        this.temptedQuestRam.func_70671_ap().func_75651_a((Entity)this.temptingItem, 30.0f, (float)this.temptedQuestRam.func_70646_bf());
        if (this.temptedQuestRam.func_70068_e((Entity)this.temptingItem) < 6.25 && this.temptedQuestRam.tryAccept(this.temptingItem.func_92059_d())) {
            this.temptingItem.func_70106_y();
        }
    }
}
