// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import java.util.List;
import java.util.Comparator;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.GroundPathNavigator;
import java.util.EnumSet;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;

public class FindLooseGoal extends Goal
{
    protected final CreatureEntity creature;
    private final double speed;
    protected ItemEntity closestItem;
    private int delayTemptCounter;
    private final Ingredient temptItem;
    
    public FindLooseGoal(final CreatureEntity creature, final double speed, final Ingredient temptItem) {
        this.creature = creature;
        this.speed = speed;
        this.temptItem = temptItem;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        if (!(creature.func_70661_as() instanceof GroundPathNavigator) && !(creature.func_70661_as() instanceof FlyingPathNavigator)) {
            throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
        }
    }
    
    public boolean func_75250_a() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        final List<ItemEntity> items = this.creature.field_70170_p.func_175647_a((Class)ItemEntity.class, this.creature.func_174813_aQ().func_72314_b(16.0, 4.0, 16.0), e -> e.func_70089_S() && !e.func_92059_d().func_190926_b());
        items.sort(Comparator.comparingDouble(i -> i.func_195048_a(this.creature.func_213303_ch())));
        this.closestItem = (items.isEmpty() ? null : items.get(0));
        return this.closestItem != null && this.isTempting(this.closestItem.func_92059_d());
    }
    
    protected boolean isTempting(final ItemStack stack) {
        return this.temptItem.test(stack);
    }
    
    public void func_75249_e() {
    }
    
    public void func_75251_c() {
        this.closestItem = null;
        this.creature.func_70661_as().func_75499_g();
        this.delayTemptCounter = 100;
    }
    
    public void func_75246_d() {
        this.creature.func_70671_ap().func_75651_a((Entity)this.closestItem, (float)(this.creature.func_184649_cE() + 20), (float)this.creature.func_70646_bf());
        if (this.creature.func_70068_e((Entity)this.closestItem) < 6.25) {
            this.creature.func_70661_as().func_75499_g();
        }
        else {
            this.creature.func_70661_as().func_75497_a((Entity)this.closestItem, this.speed);
        }
    }
}
