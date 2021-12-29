// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.conditions;

import net.minecraft.util.GsonHelper;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import twilightforest.entity.monster.CarminiteGhastling;
import javax.annotation.Nonnull;
import net.minecraft.world.level.storage.loot.LootContext;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class IsMinion implements LootItemCondition
{
    private final boolean inverse;
    
    public IsMinion(final boolean inverse) {
        this.inverse = inverse;
    }
    
    public LootItemConditionType m_7940_() {
        return TFTreasure.IS_MINION;
    }
    
    public boolean test(@Nonnull final LootContext context) {
        return context.m_78953_(LootContextParams.f_81455_) instanceof CarminiteGhastling && ((CarminiteGhastling)context.m_78953_(LootContextParams.f_81455_)).isMinion() == !this.inverse;
    }
    
    public static LootItemCondition.Builder builder(final boolean inverse) {
        return () -> new IsMinion(inverse);
    }
    
    public static class ConditionSerializer implements Serializer<IsMinion>
    {
        public void serialize(final JsonObject json, final IsMinion value, final JsonSerializationContext context) {
            json.addProperty("inverse", Boolean.valueOf(value.inverse));
        }
        
        public IsMinion deserialize(final JsonObject json, final JsonDeserializationContext context) {
            return new IsMinion(GsonHelper.m_13855_(json, "inverse", false));
        }
    }
}
