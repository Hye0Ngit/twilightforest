// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import twilightforest.TwilightForestMod;
import twilightforest.entity.EntityTFMiniGhast;
import net.minecraft.world.storage.loot.LootContext;
import javax.annotation.Nonnull;
import java.util.Random;
import net.minecraft.world.storage.loot.conditions.LootCondition;

public class LootConditionIsMinion implements LootCondition
{
    private final boolean inverse;
    
    public LootConditionIsMinion(final boolean inverse) {
        this.inverse = inverse;
    }
    
    public boolean func_186618_a(@Nonnull final Random rand, @Nonnull final LootContext context) {
        return context.func_186493_a() instanceof EntityTFMiniGhast && ((EntityTFMiniGhast)context.func_186493_a()).isMinion() == !this.inverse;
    }
    
    public static class Serializer extends LootCondition.Serializer<LootConditionIsMinion>
    {
        protected Serializer() {
            super(TwilightForestMod.prefix("is_minion"), (Class)LootConditionIsMinion.class);
        }
        
        public void serialize(@Nonnull final JsonObject json, @Nonnull final LootConditionIsMinion value, @Nonnull final JsonSerializationContext context) {
            json.addProperty("inverse", Boolean.valueOf(value.inverse));
        }
        
        @Nonnull
        public LootConditionIsMinion deserialize(@Nonnull final JsonObject json, @Nonnull final JsonDeserializationContext context) {
            return new LootConditionIsMinion(JsonUtils.func_151209_a(json, "inverse", false));
        }
    }
}
