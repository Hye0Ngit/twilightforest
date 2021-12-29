// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.conditions;

import net.minecraft.util.JSONUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootParameters;
import twilightforest.entity.CarminiteGhastlingEntity;
import javax.annotation.Nonnull;
import net.minecraft.loot.LootContext;
import twilightforest.loot.TFTreasure;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.conditions.ILootCondition;

public class IsMinion implements ILootCondition
{
    private final boolean inverse;
    
    public IsMinion(final boolean inverse) {
        this.inverse = inverse;
    }
    
    public LootConditionType func_230419_b_() {
        return TFTreasure.IS_MINION;
    }
    
    public boolean test(@Nonnull final LootContext context) {
        return context.func_216031_c(LootParameters.field_216281_a) instanceof CarminiteGhastlingEntity && ((CarminiteGhastlingEntity)context.func_216031_c(LootParameters.field_216281_a)).isMinion() == !this.inverse;
    }
    
    public static ILootCondition.IBuilder builder(final boolean inverse) {
        return () -> new IsMinion(inverse);
    }
    
    public static class Serializer implements ILootSerializer<IsMinion>
    {
        public void serialize(final JsonObject json, final IsMinion value, final JsonSerializationContext context) {
            json.addProperty("inverse", Boolean.valueOf(value.inverse));
        }
        
        public IsMinion deserialize(final JsonObject json, final JsonDeserializationContext context) {
            return new IsMinion(JSONUtils.func_151209_a(json, "inverse", false));
        }
    }
}
