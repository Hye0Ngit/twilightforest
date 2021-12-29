// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.functions;

import com.google.gson.JsonSyntaxException;
import net.minecraft.util.JSONUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraftforge.fml.ModList;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraft.util.IItemProvider;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import twilightforest.loot.TFTreasure;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.item.Item;
import net.minecraft.loot.LootFunction;

public class ModItemSwap extends LootFunction
{
    private final Item item;
    private final Item oldItem;
    private final boolean success;
    
    protected ModItemSwap(final ILootCondition[] conditionsIn, final Item itemIn, final Item old, final boolean success) {
        super(conditionsIn);
        this.item = itemIn;
        this.oldItem = old;
        this.success = success;
    }
    
    public LootFunctionType func_230425_b_() {
        return TFTreasure.ITEM_OR_DEFAULT;
    }
    
    public ItemStack func_215859_a(final ItemStack stack, final LootContext context) {
        final ItemStack newStack = new ItemStack((IItemProvider)this.item, stack.func_190916_E());
        newStack.func_77982_d(stack.func_77978_p());
        return newStack;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder extends LootFunction.Builder<Builder>
    {
        private String idtocheck;
        private Item item;
        private Item oldItem;
        
        protected Builder doCast() {
            return this;
        }
        
        public Builder apply(final String modid, final Item item, final Item old) {
            this.idtocheck = modid;
            this.item = item;
            this.oldItem = old;
            return this;
        }
        
        public ILootFunction func_216052_b() {
            return (ILootFunction)new ModItemSwap(this.func_216053_g(), this.item, this.oldItem, ModList.get().isLoaded(this.idtocheck));
        }
    }
    
    public static class Serializer extends LootFunction.Serializer<ModItemSwap>
    {
        public void serialize(final JsonObject object, final ModItemSwap function, final JsonSerializationContext serializationContext) {
            if (function.success) {
                object.addProperty("item", function.item.getRegistryName().toString());
            }
            else {
                object.addProperty("default", function.item.getRegistryName().toString());
            }
            object.addProperty("default", function.oldItem.getRegistryName().toString());
        }
        
        public ModItemSwap deserialize(final JsonObject object, final JsonDeserializationContext deserializationContext, final ILootCondition[] conditionsIn) {
            Item item;
            boolean success;
            try {
                item = JSONUtils.func_188180_i(object, "item");
                success = true;
            }
            catch (JsonSyntaxException e) {
                item = JSONUtils.func_188180_i(object, "default");
                success = false;
            }
            return new ModItemSwap(conditionsIn, item, JSONUtils.func_188180_i(object, "default"), success);
        }
    }
}
