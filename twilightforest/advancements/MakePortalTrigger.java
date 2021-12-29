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

public class MakePortalTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return MakePortalTrigger.ID;
    }
    
    public Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext condition) {
        return new Instance(player);
    }
    
    public void trigger(final ServerPlayer player) {
        this.m_66234_(player, instance -> true);
    }
    
    static {
        ID = TwilightForestMod.prefix("make_tf_portal");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        public Instance(final EntityPredicate.Composite player) {
            super(MakePortalTrigger.ID, player);
        }
        
        public static Instance makePortal() {
            return new Instance(EntityPredicate.Composite.f_36667_);
        }
    }
}
