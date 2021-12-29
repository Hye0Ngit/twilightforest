// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.conditions;

import net.minecraft.util.GsonHelper;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.LootContext;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.fml.ModList;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class ModExists implements LootItemCondition
{
    private final boolean exists;
    private final String modID;
    
    public ModExists(final String modID) {
        this.exists = ModList.get().isLoaded(modID);
        this.modID = modID;
    }
    
    public LootItemConditionType m_7940_() {
        return TFTreasure.MOD_EXISTS;
    }
    
    public boolean test(final LootContext context) {
        return this.exists;
    }
    
    public static LootItemCondition.Builder builder(final String modid) {
        return () -> new ModExists(modid);
    }
    
    public static class ConditionSerializer implements Serializer<ModExists>
    {
        public void serialize(final JsonObject json, final ModExists value, final JsonSerializationContext context) {
            json.addProperty("mod_id", value.modID);
        }
        
        public ModExists deserialize(final JsonObject json, final JsonDeserializationContext context) {
            return new ModExists(GsonHelper.m_13906_(json, "mod_id"));
        }
    }
}
