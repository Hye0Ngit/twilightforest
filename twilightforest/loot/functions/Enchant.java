// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.functions;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JSONUtils;
import java.util.HashMap;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.loot.functions.ILootFunction;
import com.google.common.collect.Maps;
import java.util.Iterator;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import twilightforest.loot.TFTreasure;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.IRegistryDelegate;
import java.util.Map;
import net.minecraft.loot.LootFunction;

public class Enchant extends LootFunction
{
    private final Map<IRegistryDelegate<Enchantment>, Short> enchantments;
    
    protected Enchant(final ILootCondition[] conditions, final Map<IRegistryDelegate<Enchantment>, Short> enchantments) {
        super(conditions);
        this.enchantments = enchantments;
    }
    
    public LootFunctionType func_230425_b_() {
        return TFTreasure.ENCHANT;
    }
    
    public ItemStack func_215859_a(final ItemStack stack, final LootContext context) {
        for (final Map.Entry<IRegistryDelegate<Enchantment>, Short> e : this.enchantments.entrySet()) {
            if (stack.func_77973_b() == Items.field_151134_bR) {
                EnchantedBookItem.func_92115_a(stack, new EnchantmentData((Enchantment)e.getKey().get(), (int)e.getValue()));
            }
            else {
                stack.func_77966_a((Enchantment)e.getKey().get(), (int)e.getValue());
            }
        }
        return stack;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder extends LootFunction.Builder<Builder>
    {
        private final Map<IRegistryDelegate<Enchantment>, Short> enchants;
        
        public Builder() {
            this.enchants = Maps.newHashMap();
        }
        
        protected Builder doCast() {
            return this;
        }
        
        public Builder apply(final Enchantment p_216077_1_, final Integer p_216077_2_) {
            this.enchants.put((IRegistryDelegate<Enchantment>)p_216077_1_.delegate, p_216077_2_.shortValue());
            return this;
        }
        
        public ILootFunction func_216052_b() {
            return (ILootFunction)new Enchant(this.func_216053_g(), this.enchants);
        }
    }
    
    public static class Serializer extends LootFunction.Serializer<Enchant>
    {
        public void serialize(final JsonObject object, final Enchant function, final JsonSerializationContext ctx) {
            if (!function.enchantments.isEmpty()) {
                final JsonObject obj = new JsonObject();
                for (final Map.Entry<IRegistryDelegate<Enchantment>, Short> e : function.enchantments.entrySet()) {
                    obj.addProperty(((Enchantment)e.getKey().get()).getRegistryName().toString(), (Number)e.getValue());
                }
                object.add("enchantments", (JsonElement)obj);
            }
        }
        
        public Enchant deserialize(final JsonObject object, final JsonDeserializationContext ctx, final ILootCondition[] conditions) {
            final Map<IRegistryDelegate<Enchantment>, Short> enchantments = new HashMap<IRegistryDelegate<Enchantment>, Short>();
            if (object.has("enchantments")) {
                final JsonObject enchantObj = JSONUtils.func_152754_s(object, "enchantments");
                for (final Map.Entry<String, JsonElement> e : enchantObj.entrySet()) {
                    final ResourceLocation id = new ResourceLocation((String)e.getKey());
                    if (!ForgeRegistries.ENCHANTMENTS.containsKey(id)) {
                        throw new JsonSyntaxException("Can't find enchantment " + e.getKey());
                    }
                    final Enchantment ench = (Enchantment)ForgeRegistries.ENCHANTMENTS.getValue(id);
                    final short lvl = e.getValue().getAsShort();
                    for (final IRegistryDelegate<Enchantment> other : enchantments.keySet()) {
                        if (!ench.func_191560_c((Enchantment)other.get())) {
                            throw new JsonParseException(String.format("Enchantments %s and %s conflict", ench.getRegistryName(), ((Enchantment)other.get()).getRegistryName()));
                        }
                    }
                    enchantments.put((IRegistryDelegate<Enchantment>)ench.delegate, lvl);
                }
            }
            return new Enchant(conditions, enchantments);
        }
    }
}
