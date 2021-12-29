// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import java.util.HashMap;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonObject;
import twilightforest.TwilightForestMod;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.world.storage.loot.LootContext;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.IRegistryDelegate;
import java.util.Map;
import net.minecraft.world.storage.loot.functions.LootFunction;

public class LootFunctionEnchant extends LootFunction
{
    private final Map<IRegistryDelegate<Enchantment>, Short> enchantments;
    
    protected LootFunctionEnchant(final LootCondition[] conditions, final Map<IRegistryDelegate<Enchantment>, Short> enchantments) {
        super(conditions);
        this.enchantments = enchantments;
    }
    
    public ItemStack func_186553_a(final ItemStack stack, final Random rand, final LootContext context) {
        for (final Map.Entry<IRegistryDelegate<Enchantment>, Short> e : this.enchantments.entrySet()) {
            if (stack.func_77973_b() == Items.field_151134_bR) {
                ItemEnchantedBook.func_92115_a(stack, new EnchantmentData((Enchantment)e.getKey().get(), (int)e.getValue()));
            }
            else {
                this.addEnchantment(stack, (Enchantment)e.getKey().get(), e.getValue());
            }
        }
        return stack;
    }
    
    private void addEnchantment(final ItemStack stack, final Enchantment e, final short level) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new NBTTagCompound());
        }
        final String enchantedCompoundKey = (stack.func_77973_b() == Items.field_151134_bR) ? "StoredEnchantments" : "ench";
        if (!stack.func_77978_p().func_150297_b(enchantedCompoundKey, 9)) {
            stack.func_77978_p().func_74782_a(enchantedCompoundKey, (NBTBase)new NBTTagList());
        }
        final NBTTagList list = stack.func_77978_p().func_150295_c(enchantedCompoundKey, 10);
        for (int i = 0; i < list.func_74745_c(); ++i) {
            final NBTTagCompound existing = list.func_150305_b(i);
            if (existing.func_74765_d("id") == Enchantment.func_185258_b(e)) {
                existing.func_74777_a("lvl", level);
                return;
            }
        }
        final NBTTagCompound newCmp = new NBTTagCompound();
        newCmp.func_74777_a("id", (short)Enchantment.func_185258_b(e));
        newCmp.func_74777_a("lvl", level);
        list.func_74742_a((NBTBase)newCmp);
    }
    
    public static class Serializer extends LootFunction.Serializer<LootFunctionEnchant>
    {
        protected Serializer() {
            super(TwilightForestMod.prefix("enchant"), (Class)LootFunctionEnchant.class);
        }
        
        public void serialize(final JsonObject object, final LootFunctionEnchant function, final JsonSerializationContext ctx) {
            if (!function.enchantments.isEmpty()) {
                final JsonObject obj = new JsonObject();
                for (final Map.Entry<IRegistryDelegate<Enchantment>, Short> e : function.enchantments.entrySet()) {
                    obj.addProperty(((Enchantment)e.getKey().get()).getRegistryName().toString(), (Number)e.getValue());
                }
                object.add("enchantments", (JsonElement)obj);
            }
        }
        
        public LootFunctionEnchant deserialize(final JsonObject object, final JsonDeserializationContext ctx, final LootCondition[] conditions) {
            final Map<IRegistryDelegate<Enchantment>, Short> enchantments = new HashMap<IRegistryDelegate<Enchantment>, Short>();
            if (object.has("enchantments")) {
                final JsonObject enchantObj = JsonUtils.func_152754_s(object, "enchantments");
                for (final Map.Entry<String, JsonElement> e : enchantObj.entrySet()) {
                    final Enchantment ench = (Enchantment)Enchantment.field_185264_b.func_82594_a((Object)new ResourceLocation((String)e.getKey()));
                    if (ench == null) {
                        throw new JsonSyntaxException("Can't find enchantment " + e.getKey());
                    }
                    final short lvl = e.getValue().getAsShort();
                    for (final IRegistryDelegate<Enchantment> other : enchantments.keySet()) {
                        if (!ench.func_191560_c((Enchantment)other.get())) {
                            throw new JsonParseException(String.format("Enchantments %s and %s conflict", ench.getRegistryName(), ((Enchantment)other.get()).getRegistryName()));
                        }
                    }
                    enchantments.put((IRegistryDelegate<Enchantment>)ench.delegate, lvl);
                }
            }
            return new LootFunctionEnchant(conditions, enchantments);
        }
    }
}
