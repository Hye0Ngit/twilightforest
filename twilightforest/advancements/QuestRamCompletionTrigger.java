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

public class QuestRamCompletionTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return QuestRamCompletionTrigger.ID;
    }
    
    public Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext condition) {
        return new Instance(player);
    }
    
    public void trigger(final ServerPlayer player) {
        this.m_66234_(player, instance -> true);
    }
    
    static {
        ID = TwilightForestMod.prefix("complete_quest_ram");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        public Instance(final EntityPredicate.Composite player) {
            super(QuestRamCompletionTrigger.ID, player);
        }
        
        public static Instance completeRam() {
            return new Instance(EntityPredicate.Composite.f_36667_);
        }
    }
}
