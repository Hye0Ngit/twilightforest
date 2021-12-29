// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import javax.annotation.Nonnull;
import com.google.gson.JsonObject;
import twilightforest.TwilightForestMod;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraftforge.fml.common.Loader;
import net.minecraft.world.storage.loot.conditions.LootCondition;

public class LootConditionModExists implements LootCondition
{
    private final boolean exists;
    private final String modID;
    
    public LootConditionModExists(final String modID) {
        this.exists = Loader.isModLoaded(modID);
        this.modID = modID;
    }
    
    public boolean func_186618_a(final Random rand, final LootContext context) {
        return this.exists;
    }
    
    public static class Serializer extends LootCondition.Serializer<LootConditionModExists>
    {
        protected Serializer() {
            super(TwilightForestMod.prefix("mod_exists"), (Class)LootConditionModExists.class);
        }
        
        public void serialize(@Nonnull final JsonObject json, @Nonnull final LootConditionModExists value, @Nonnull final JsonSerializationContext context) {
            json.addProperty("mod_id", value.modID);
        }
        
        @Nonnull
        public LootConditionModExists deserialize(@Nonnull final JsonObject json, @Nonnull final JsonDeserializationContext context) {
            return new LootConditionModExists(JsonUtils.func_151200_h(json, "mod_id"));
        }
    }
}
