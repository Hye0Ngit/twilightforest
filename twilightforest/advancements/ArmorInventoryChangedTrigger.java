// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class ArmorInventoryChangedTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return ArmorInventoryChangedTrigger.ID;
    }
    
    public Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext condition) {
        final ItemPredicate from = ItemPredicate.m_45051_(json.get("from"));
        final ItemPredicate to = ItemPredicate.m_45051_(json.get("to"));
        return new Instance(player, from, to);
    }
    
    public void trigger(final ServerPlayer player, final ItemStack from, final ItemStack to) {
        this.m_66234_(player, instance -> instance.test(from, to));
    }
    
    static {
        ID = TwilightForestMod.prefix("armor_changed");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        private final ItemPredicate from;
        private final ItemPredicate to;
        
        public Instance(final EntityPredicate.Composite player, final ItemPredicate from, final ItemPredicate to) {
            super(ArmorInventoryChangedTrigger.ID, player);
            this.from = from;
            this.to = to;
        }
        
        public static Instance equipArmor(final ItemPredicate.Builder from, final ItemPredicate.Builder to) {
            return new Instance(EntityPredicate.Composite.f_36667_, from.m_45077_(), to.m_45077_());
        }
        
        public boolean test(final ItemStack from, final ItemStack to) {
            return this.from.m_45049_(from) && this.to.m_45049_(to);
        }
    }
}
