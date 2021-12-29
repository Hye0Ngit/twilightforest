// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import net.minecraft.world.item.crafting.Recipe;
import javax.annotation.Nullable;
import net.minecraft.network.FriendlyByteBuf;
import java.util.Set;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import java.util.Iterator;
import com.google.gson.JsonSyntaxException;
import com.google.common.collect.Maps;
import java.util.Map;
import com.google.gson.JsonElement;
import net.minecraft.util.GsonHelper;
import com.google.gson.JsonObject;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import java.util.Arrays;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraftforge.common.crafting.IShapedRecipe;

public class UncraftingRecipe implements IUncraftingRecipe, IShapedRecipe<CraftingContainer>
{
    private final ResourceLocation recipeID;
    private final int cost;
    private final int width;
    private final int height;
    private final Ingredient ingredient;
    private final int count;
    private final NonNullList<Ingredient> resultItems;
    
    public UncraftingRecipe(final ResourceLocation recipeID, final int cost, final int width, final int height, final Ingredient ingredient, final int count, final NonNullList<Ingredient> resultItems) {
        this.recipeID = recipeID;
        this.cost = cost;
        this.width = width;
        this.height = height;
        this.ingredient = ingredient;
        this.count = count;
        this.resultItems = resultItems;
    }
    
    public boolean matches(final CraftingContainer pContainer, final Level pLevel) {
        return false;
    }
    
    public ItemStack assemble(final CraftingContainer pContainer) {
        return ItemStack.f_41583_;
    }
    
    public ItemStack m_8043_() {
        return new ItemStack((ItemLike)Items.f_41852_, this.count);
    }
    
    public boolean m_8004_(final int width, final int height) {
        return width >= this.width && height >= this.height;
    }
    
    public boolean isItemStackAnIngredient(final ItemStack itemStack) {
        return Arrays.stream(this.ingredient.m_43908_()).anyMatch(i -> itemStack.m_41720_() == i.m_41720_() && itemStack.m_41613_() >= i.m_41613_());
    }
    
    public ResourceLocation m_6423_() {
        return this.recipeID;
    }
    
    public RecipeSerializer<?> m_7707_() {
        return (RecipeSerializer<?>)TFRecipes.UNCRAFTING_SERIALIZER.get();
    }
    
    @Override
    public RecipeType<?> m_6671_() {
        return TFRecipes.UNCRAFTING_RECIPE;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public int getRecipeWidth() {
        return this.width;
    }
    
    public int getRecipeHeight() {
        return this.height;
    }
    
    public NonNullList<Ingredient> m_7527_() {
        return this.resultItems;
    }
    
    public Ingredient getIngredient() {
        return this.ingredient;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<UncraftingRecipe>
    {
        public UncraftingRecipe fromJson(final ResourceLocation id, final JsonObject json) {
            final int cost = GsonHelper.m_13927_(json, "cost");
            final JsonElement jsonelement = (JsonElement)(GsonHelper.m_13885_(json, "ingredient") ? GsonHelper.m_13933_(json, "ingredient") : GsonHelper.m_13930_(json, "ingredient"));
            final Ingredient ingredient = Ingredient.m_43917_(jsonelement);
            final int count = GsonHelper.m_13927_(json, "count");
            final Map<String, Ingredient> key = keyFromJson(GsonHelper.m_13930_(json, "key"));
            final String[] pattern = shrink(patternFromJson(GsonHelper.m_13933_(json, "pattern")));
            final int width = pattern[0].length();
            final int height = pattern.length;
            final NonNullList<Ingredient> ingredients = dissolvePattern(pattern, key, width, height);
            return new UncraftingRecipe(id, cost, width, height, ingredient, count, ingredients);
        }
        
        private static Map<String, Ingredient> keyFromJson(final JsonObject json) {
            final Map<String, Ingredient> map = Maps.newHashMap();
            for (final Map.Entry<String, JsonElement> entry : json.entrySet()) {
                if (entry.getKey().length() != 1) {
                    throw new JsonSyntaxException("Invalid key entry: '" + (String)entry.getKey() + "' is an invalid symbol (must be 1 character only).");
                }
                if (" ".equals(entry.getKey())) {
                    throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
                }
                map.put(entry.getKey(), Ingredient.m_43917_((JsonElement)entry.getValue()));
            }
            map.put(" ", Ingredient.f_43901_);
            return map;
        }
        
        static String[] shrink(final String... prePattern) {
            int i = Integer.MAX_VALUE;
            int j = 0;
            int k = 0;
            int l = 0;
            for (int i2 = 0; i2 < prePattern.length; ++i2) {
                final String s = prePattern[i2];
                i = Math.min(i, firstNonSpace(s));
                final int j2 = lastNonSpace(s);
                j = Math.max(j, j2);
                if (j2 < 0) {
                    if (k == i2) {
                        ++k;
                    }
                    ++l;
                }
                else {
                    l = 0;
                }
            }
            if (prePattern.length == l) {
                return new String[0];
            }
            final String[] shrunk = new String[prePattern.length - l - k];
            for (int k2 = 0; k2 < shrunk.length; ++k2) {
                shrunk[k2] = prePattern[k2 + k].substring(i, j + 1);
            }
            return shrunk;
        }
        
        private static int firstNonSpace(final String first) {
            int i;
            for (i = 0; i < first.length() && first.charAt(i) == ' '; ++i) {}
            return i;
        }
        
        private static int lastNonSpace(final String last) {
            int i;
            for (i = last.length() - 1; i >= 0 && last.charAt(i) == ' '; --i) {}
            return i;
        }
        
        private static String[] patternFromJson(final JsonArray pattern) {
            final String[] stringPattern = new String[pattern.size()];
            if (stringPattern.length > 3) {
                throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
            }
            if (stringPattern.length == 0) {
                throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
            }
            for (int i = 0; i < stringPattern.length; ++i) {
                final String s = GsonHelper.m_13805_(pattern.get(i), "pattern[" + i);
                if (s.length() > 3) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
                }
                if (i > 0 && stringPattern[0].length() != s.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }
                stringPattern[i] = s;
            }
            return stringPattern;
        }
        
        private static NonNullList<Ingredient> dissolvePattern(final String[] pattern, final Map<String, Ingredient> key, final int width, final int height) {
            final NonNullList<Ingredient> results = (NonNullList<Ingredient>)NonNullList.m_122780_(width * height, (Object)Ingredient.f_43901_);
            final Set<String> set = Sets.newHashSet((Iterable)key.keySet());
            set.remove(" ");
            for (int i = 0; i < pattern.length; ++i) {
                for (int j = 0; j < pattern[i].length(); ++j) {
                    final String s = pattern[i].substring(j, j + 1);
                    final Ingredient ingredient = key.get(s);
                    if (ingredient == null) {
                        throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                    }
                    set.remove(s);
                    results.set(j + width * i, (Object)ingredient);
                }
            }
            if (!set.isEmpty()) {
                throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
            }
            return results;
        }
        
        @Nullable
        public UncraftingRecipe fromNetwork(final ResourceLocation id, final FriendlyByteBuf buffer) {
            final int cost = buffer.m_130242_();
            final int width = buffer.m_130242_();
            final int height = buffer.m_130242_();
            final Ingredient result = Ingredient.m_43940_(buffer);
            final int count = buffer.m_130242_();
            final NonNullList<Ingredient> ingredients = (NonNullList<Ingredient>)NonNullList.m_122780_(width * height, (Object)Ingredient.f_43901_);
            for (int k = 0; k < ingredients.size(); ++k) {
                ingredients.set(k, (Object)Ingredient.m_43940_(buffer));
            }
            return new UncraftingRecipe(id, cost, width, height, result, count, ingredients);
        }
        
        public void toNetwork(final FriendlyByteBuf buffer, final UncraftingRecipe recipe) {
            buffer.m_130130_(recipe.cost);
            buffer.m_130130_(recipe.width);
            buffer.m_130130_(recipe.height);
            recipe.ingredient.m_43923_(buffer);
            buffer.m_130130_(recipe.count);
            for (final Ingredient i : recipe.resultItems) {
                i.m_43923_(buffer);
            }
        }
    }
}
