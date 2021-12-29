// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class StructureClearedTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return StructureClearedTrigger.ID;
    }
    
    public Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext condition) {
        final String structureName = GsonHelper.m_13906_(json, "structure");
        return new Instance(player, structureName);
    }
    
    public void trigger(final ServerPlayer player, final String structureName) {
        this.m_66234_(player, instance -> instance.test(structureName));
    }
    
    static {
        ID = TwilightForestMod.prefix("structure_cleared");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        private final String structureName;
        
        public Instance(final EntityPredicate.Composite player, final String structureName) {
            super(StructureClearedTrigger.ID, player);
            this.structureName = structureName;
        }
        
        public static Instance clearedStructure(final String name) {
            return new Instance(EntityPredicate.Composite.f_36667_, name);
        }
        
        boolean test(final String structureName) {
            return this.structureName.equals(structureName);
        }
    }
}
