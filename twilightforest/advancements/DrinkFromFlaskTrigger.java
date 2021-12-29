// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.advancements.critereon.SerializationContext;
import javax.annotation.Nullable;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.advancements.critereon.MinMaxBounds;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.Registry;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.util.GsonHelper;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class DrinkFromFlaskTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return DrinkFromFlaskTrigger.ID;
    }
    
    protected Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext ctx) {
        Potion potion = null;
        if (json.has("potion")) {
            final ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.m_13906_(json, "potion"));
            potion = Registry.f_122828_.m_6612_(resourcelocation).orElseThrow(() -> new JsonSyntaxException("Unknown potion '" + resourcelocation));
        }
        if (json.has("doses") && GsonHelper.m_13927_(json, "doses") > 4) {
            throw new JsonSyntaxException("DrinkFromFlaskTrigger: can't have more than 4 doses.");
        }
        final MinMaxBounds.Ints doses = MinMaxBounds.Ints.m_55373_(json.get("doses"));
        return new Instance(player, doses, potion);
    }
    
    public void trigger(final ServerPlayer player, final int doses, final Potion potion) {
        this.m_66234_(player, instance -> instance.matches(doses, potion));
    }
    
    static {
        ID = TwilightForestMod.prefix("drink_from_flask");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        private final MinMaxBounds.Ints doses;
        @Nullable
        private final Potion potion;
        
        public Instance(final EntityPredicate.Composite player, final MinMaxBounds.Ints doses, @Nullable final Potion potion) {
            super(DrinkFromFlaskTrigger.ID, player);
            this.doses = doses;
            this.potion = potion;
        }
        
        public static Instance drankPotion(final int doses, final Potion potion) {
            return new Instance(EntityPredicate.Composite.f_36667_, MinMaxBounds.Ints.m_55371_(doses), potion);
        }
        
        public boolean matches(final int doses, final Potion potion) {
            return this.doses.m_55390_(doses) && this.potion != null && this.potion == potion;
        }
        
        public JsonObject m_7683_(final SerializationContext ctx) {
            final JsonObject object = super.m_7683_(ctx);
            object.add("doses", this.doses.m_55328_());
            if (this.potion != null) {
                object.addProperty("potion", Registry.f_122828_.m_7981_((Object)this.potion).toString());
            }
            return object;
        }
    }
}
