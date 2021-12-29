// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import com.google.gson.JsonSyntaxException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import twilightforest.TwilightForestMod;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.functions.LootFunction;

public class LootFunctionModItemSwap extends LootFunction
{
    private final Item item;
    private final boolean success;
    
    protected LootFunctionModItemSwap(final LootCondition[] conditionsIn, final Item itemIn, final boolean success) {
        super(conditionsIn);
        this.item = itemIn;
        this.success = success;
    }
    
    public ItemStack func_186553_a(final ItemStack stack, final Random rand, final LootContext context) {
        final ItemStack newStack = new ItemStack(this.item, stack.func_190916_E(), stack.func_77952_i());
        newStack.func_77982_d(stack.func_77978_p());
        return newStack;
    }
    
    public static class Serializer extends LootFunction.Serializer<LootFunctionModItemSwap>
    {
        protected Serializer() {
            super(TwilightForestMod.prefix("item_or_default"), (Class)LootFunctionModItemSwap.class);
        }
        
        public void serialize(final JsonObject object, final LootFunctionModItemSwap function, final JsonSerializationContext serializationContext) {
            if (function.success) {
                object.addProperty("item", function.item.getRegistryName().toString());
            }
            else {
                object.addProperty("default", function.item.getRegistryName().toString());
            }
        }
        
        public LootFunctionModItemSwap deserialize(final JsonObject object, final JsonDeserializationContext deserializationContext, final LootCondition[] conditionsIn) {
            Item item;
            boolean success;
            try {
                item = JsonUtils.func_188180_i(object, "item");
                success = true;
            }
            catch (JsonSyntaxException e) {
                item = JsonUtils.func_188180_i(object, "default");
                success = false;
            }
            return new LootFunctionModItemSwap(conditionsIn, item, success);
        }
    }
}
