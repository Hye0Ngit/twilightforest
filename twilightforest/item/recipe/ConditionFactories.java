// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import twilightforest.TFConfig;
import java.util.function.BooleanSupplier;
import com.google.gson.JsonObject;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.common.crafting.IConditionFactory;

public class ConditionFactories
{
    public static class UncraftingEnabled implements IConditionFactory
    {
        public BooleanSupplier parse(final JsonContext context, final JsonObject json) {
            return () -> !TFConfig.disableUncrafting;
        }
    }
}
