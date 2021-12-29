// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.advancements.critereon.SerializationContext;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class HurtBossTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    protected Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext ctx) {
        final EntityPredicate.Composite composite = EntityPredicate.Composite.m_36677_(json, "hurt_entity", ctx);
        return new Instance(player, composite);
    }
    
    public ResourceLocation m_7295_() {
        return HurtBossTrigger.ID;
    }
    
    public void trigger(final ServerPlayer player, final Entity hurt) {
        final LootContext entity = EntityPredicate.m_36616_(player, hurt);
        this.m_66234_(player, instance -> instance.matches(entity));
    }
    
    static {
        ID = TwilightForestMod.prefix("hurt_boss");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        private final EntityPredicate.Composite hurt;
        
        public Instance(final EntityPredicate.Composite player, final EntityPredicate.Composite hurt) {
            super(HurtBossTrigger.ID, player);
            this.hurt = hurt;
        }
        
        public boolean matches(final LootContext hurt) {
            return this.hurt.m_36681_(hurt);
        }
        
        public static Instance hurtBoss(final EntityPredicate.Builder hurt) {
            return new Instance(EntityPredicate.Composite.f_36667_, EntityPredicate.Composite.m_36673_(hurt.m_36662_()));
        }
        
        public JsonObject m_7683_(final SerializationContext ctx) {
            final JsonObject json = super.m_7683_(ctx);
            json.add("hurt_entity", this.hurt.m_36675_(ctx));
            return json;
        }
    }
}
