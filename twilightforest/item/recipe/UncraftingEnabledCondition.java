// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import com.google.gson.JsonObject;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import twilightforest.TFConfig;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class UncraftingEnabledCondition implements ICondition
{
    public ResourceLocation getID() {
        return TwilightForestMod.prefix("uncrafting_enabled");
    }
    
    public boolean test() {
        return !(boolean)TFConfig.COMMON_CONFIG.disableUncrafting.get();
    }
    
    public static class Serializer implements IConditionSerializer<UncraftingEnabledCondition>
    {
        public static final Serializer INSTANCE;
        
        public void write(final JsonObject json, final UncraftingEnabledCondition value) {
        }
        
        public UncraftingEnabledCondition read(final JsonObject json) {
            return new UncraftingEnabledCondition();
        }
        
        public ResourceLocation getID() {
            return TwilightForestMod.prefix("uncrafting_enabled");
        }
        
        static {
            INSTANCE = new Serializer();
        }
    }
}
