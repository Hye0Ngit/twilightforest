// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot.functions;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import java.util.HashMap;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import com.google.common.collect.Maps;
import java.util.Iterator;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.item.ItemStack;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.IRegistryDelegate;
import java.util.Map;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;

public class Enchant extends LootItemConditionalFunction
{
    private final Map<IRegistryDelegate<Enchantment>, Short> enchantments;
    
    protected Enchant(final LootItemCondition[] conditions, final Map<IRegistryDelegate<Enchantment>, Short> enchantments) {
        super(conditions);
        this.enchantments = enchantments;
    }
    
    public LootItemFunctionType m_7162_() {
        return TFTreasure.ENCHANT;
    }
    
    public ItemStack m_7372_(final ItemStack stack, final LootContext context) {
        for (final Map.Entry<IRegistryDelegate<Enchantment>, Short> e : this.enchantments.entrySet()) {
            if (stack.m_41720_() == Items.f_42690_) {
                EnchantedBookItem.m_41153_(stack, new EnchantmentInstance((Enchantment)e.getKey().get(), (int)e.getValue()));
            }
            else {
                stack.m_41663_((Enchantment)e.getKey().get(), (int)e.getValue());
            }
        }
        return stack;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder extends LootItemConditionalFunction.Builder<Builder>
    {
        private final Map<IRegistryDelegate<Enchantment>, Short> enchants;
        
        public Builder() {
            this.enchants = Maps.newHashMap();
        }
        
        protected Builder getThis() {
            return this;
        }
        
        public Builder apply(final Enchantment p_216077_1_, final Integer p_216077_2_) {
            this.enchants.put((IRegistryDelegate<Enchantment>)p_216077_1_.delegate, p_216077_2_.shortValue());
            return this;
        }
        
        public LootItemFunction m_7453_() {
            return (LootItemFunction)new Enchant(this.m_80699_(), this.enchants);
        }
    }
    
    public static class Serializer extends LootItemConditionalFunction.Serializer<Enchant>
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
        
        public Enchant deserialize(final JsonObject object, final JsonDeserializationContext ctx, final LootItemCondition[] conditions) {
            final Map<IRegistryDelegate<Enchantment>, Short> enchantments = new HashMap<IRegistryDelegate<Enchantment>, Short>();
            if (object.has("enchantments")) {
                final JsonObject enchantObj = GsonHelper.m_13930_(object, "enchantments");
                for (final Map.Entry<String, JsonElement> e : enchantObj.entrySet()) {
                    final ResourceLocation id = new ResourceLocation((String)e.getKey());
                    if (!ForgeRegistries.ENCHANTMENTS.containsKey(id)) {
                        throw new JsonSyntaxException("Can't find enchantment " + (String)e.getKey());
                    }
                    final Enchantment ench = (Enchantment)ForgeRegistries.ENCHANTMENTS.getValue(id);
                    final short lvl = e.getValue().getAsShort();
                    for (final IRegistryDelegate<Enchantment> other : enchantments.keySet()) {
                        if (!ench.m_44695_((Enchantment)other.get())) {
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
