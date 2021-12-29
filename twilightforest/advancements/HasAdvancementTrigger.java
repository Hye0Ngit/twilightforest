// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.advancements.critereon.SerializationContext;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class HasAdvancementTrigger extends SimpleCriterionTrigger<Instance>
{
    private static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return HasAdvancementTrigger.ID;
    }
    
    public Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext condition) {
        final ResourceLocation advancementId = new ResourceLocation(GsonHelper.m_13906_(json, "advancement"));
        return new Instance(player, advancementId);
    }
    
    public void trigger(final ServerPlayer player, final Advancement advancement) {
        this.m_66234_(player, instance -> instance.test(advancement));
    }
    
    static {
        ID = TwilightForestMod.prefix("has_advancement");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        private final ResourceLocation advancementLocation;
        
        public Instance(final EntityPredicate.Composite player, final ResourceLocation advancementLocation) {
            super(HasAdvancementTrigger.ID, player);
            this.advancementLocation = advancementLocation;
        }
        
        public static Instance hasAdvancement(final ResourceLocation advancement) {
            return new Instance(EntityPredicate.Composite.f_36667_, advancement);
        }
        
        boolean test(final Advancement advancement) {
            return this.advancementLocation.equals((Object)advancement.m_138327_());
        }
        
        public JsonObject m_7683_(final SerializationContext serializer) {
            final JsonObject json = super.m_7683_(serializer);
            json.addProperty("advancement", this.advancementLocation.toString());
            return json;
        }
    }
}
