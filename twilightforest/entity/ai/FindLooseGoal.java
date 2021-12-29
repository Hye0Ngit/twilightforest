// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import twilightforest.entity.passive.QuestRam;
import net.minecraft.world.item.ItemStack;
import java.util.List;
import java.util.Comparator;
import java.util.EnumSet;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class FindLooseGoal extends Goal
{
    protected final PathfinderMob creature;
    private final double speed;
    protected ItemEntity closestItem;
    private int delayTemptCounter;
    private final Ingredient temptItem;
    
    public FindLooseGoal(final PathfinderMob creature, final double speed, final Ingredient temptItem) {
        this.creature = creature;
        this.speed = speed;
        this.temptItem = temptItem;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        final List<ItemEntity> items = this.creature.f_19853_.m_6443_((Class)ItemEntity.class, this.creature.m_142469_().m_82377_(16.0, 4.0, 16.0), e -> e.m_6084_() && !e.m_32055_().m_41619_());
        items.sort(Comparator.comparingDouble(i -> i.m_20238_(this.creature.m_20182_())));
        this.closestItem = (items.isEmpty() ? null : items.get(0));
        return this.closestItem != null && this.isTempting(this.closestItem.m_32055_());
    }
    
    protected boolean isTempting(final ItemStack stack) {
        final PathfinderMob creature = this.creature;
        if (creature instanceof final QuestRam ram) {
            if (stack.m_150922_((Tag)ItemTags.f_13167_)) {
                final DyeColor color = QuestRam.guessColor(stack);
                return color != null && !ram.isColorPresent(color);
            }
        }
        return this.temptItem.test(stack);
    }
    
    public void m_8056_() {
    }
    
    public void m_8041_() {
        this.closestItem = null;
        this.creature.m_21573_().m_26573_();
        this.delayTemptCounter = 100;
    }
    
    public void m_8037_() {
        this.creature.m_21563_().m_24960_((Entity)this.closestItem, (float)(this.creature.m_8085_() + 20), (float)this.creature.m_8132_());
        if (this.creature.m_20280_((Entity)this.closestItem) < 6.25) {
            this.creature.m_21573_().m_26573_();
        }
        else {
            this.creature.m_21573_().m_5624_((Entity)this.closestItem, this.speed);
        }
    }
}
