// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.functions;

import com.google.gson.JsonSyntaxException;
import net.minecraft.util.GsonHelper;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraftforge.fml.ModList;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.item.ItemStack;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;

public class ModItemSwap extends LootItemConditionalFunction
{
    private final Item item;
    private final Item oldItem;
    private final boolean success;
    
    protected ModItemSwap(final LootItemCondition[] conditionsIn, final Item itemIn, final Item old, final boolean success) {
        super(conditionsIn);
        this.item = itemIn;
        this.oldItem = old;
        this.success = success;
    }
    
    public LootItemFunctionType m_7162_() {
        return TFTreasure.ITEM_OR_DEFAULT;
    }
    
    public ItemStack m_7372_(final ItemStack stack, final LootContext context) {
        final ItemStack newStack = new ItemStack((ItemLike)this.item, stack.m_41613_());
        newStack.m_41751_(stack.m_41783_());
        return newStack;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder extends LootItemConditionalFunction.Builder<Builder>
    {
        private String idtocheck;
        private Item item;
        private Item oldItem;
        
        protected Builder getThis() {
            return this;
        }
        
        public Builder apply(final String modid, final Item item, final Item old) {
            this.idtocheck = modid;
            this.item = item;
            this.oldItem = old;
            return this;
        }
        
        public LootItemFunction m_7453_() {
            return (LootItemFunction)new ModItemSwap(this.m_80699_(), this.item, this.oldItem, ModList.get().isLoaded(this.idtocheck));
        }
    }
    
    public static class Serializer extends LootItemConditionalFunction.Serializer<ModItemSwap>
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
        
        public ModItemSwap deserialize(final JsonObject object, final JsonDeserializationContext deserializationContext, final LootItemCondition[] conditionsIn) {
            Item item;
            boolean success;
            try {
                item = GsonHelper.m_13909_(object, "item");
                success = true;
            }
            catch (JsonSyntaxException e) {
                item = GsonHelper.m_13909_(object, "default");
                success = false;
            }
            return new ModItemSwap(conditionsIn, item, GsonHelper.m_13909_(object, "default"), success);
        }
    }
}
