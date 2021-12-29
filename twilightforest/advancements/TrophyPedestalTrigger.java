// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class TrophyPedestalTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return TrophyPedestalTrigger.ID;
    }
    
    public Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext condition) {
        return new Instance(player);
    }
    
    public void trigger(final ServerPlayer player) {
        this.m_66234_(player, instance -> true);
    }
    
    static {
        ID = TwilightForestMod.prefix("placed_on_trophy_pedestal");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        public Instance(final EntityPredicate.Composite player) {
            super(TrophyPedestalTrigger.ID, player);
        }
        
        public static Instance activatePedestal() {
            return new Instance(EntityPredicate.Composite.f_36667_);
        }
    }
}
