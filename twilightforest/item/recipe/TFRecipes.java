// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import java.util.function.Supplier;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.function.Function;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;

public class TFRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS;
    public static final RegistryObject<SimpleRecipeSerializer<?>> MOONWORM_QUEEN_REPAIR_RECIPE;
    public static final RegistryObject<RecipeSerializer<UncraftingRecipe>> UNCRAFTING_SERIALIZER;
    public static final RecipeType<UncraftingRecipe> UNCRAFTING_RECIPE;
    
    static {
        RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "twilightforest");
        MOONWORM_QUEEN_REPAIR_RECIPE = TFRecipes.RECIPE_SERIALIZERS.register("moonworm_queen_repair_recipe", () -> new SimpleRecipeSerializer((Function)MoonwormQueenRepairRecipe::new));
        UNCRAFTING_SERIALIZER = TFRecipes.RECIPE_SERIALIZERS.register("uncrafting", (Supplier)UncraftingRecipe.Serializer::new);
        UNCRAFTING_RECIPE = RecipeType.m_44119_("twilightforest:unique_uncrafting");
    }
}
