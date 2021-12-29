// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.conditions;

import net.minecraft.util.JSONUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootContext;
import twilightforest.loot.TFTreasure;
import net.minecraft.loot.LootConditionType;
import net.minecraftforge.fml.ModList;
import net.minecraft.loot.conditions.ILootCondition;

public class ModExists implements ILootCondition
{
    private final boolean exists;
    private final String modID;
    
    public ModExists(final String modID) {
        this.exists = ModList.get().isLoaded(modID);
        this.modID = modID;
    }
    
    public LootConditionType func_230419_b_() {
        return TFTreasure.MOD_EXISTS;
    }
    
    public boolean test(final LootContext context) {
        return this.exists;
    }
    
    public static ILootCondition.IBuilder builder(final String modid) {
        return () -> new ModExists(modid);
    }
    
    public static class Serializer implements ILootSerializer<ModExists>
    {
        public void serialize(final JsonObject json, final ModExists value, final JsonSerializationContext context) {
            json.addProperty("mod_id", value.modID);
        }
        
        public ModExists deserialize(final JsonObject json, final JsonDeserializationContext context) {
            return new ModExists(JSONUtils.func_151200_h(json, "mod_id"));
        }
    }
}
