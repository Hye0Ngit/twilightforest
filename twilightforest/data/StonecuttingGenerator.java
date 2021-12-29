// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import javax.annotation.Nullable;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.data.SingleItemRecipeBuilder;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import twilightforest.block.TFBlocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.data.IFinishedRecipe;
import java.util.function.Consumer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.RecipeProvider;

public class StonecuttingGenerator extends RecipeProvider
{
    public StonecuttingGenerator(final DataGenerator generator) {
        super(generator);
    }
    
    protected void func_200404_a(final Consumer<IFinishedRecipe> consumer) {
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick.get(), (IItemProvider)TFBlocks.castle_brick_frame.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_cracked.get(), (IItemProvider)TFBlocks.castle_brick_frame.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_worn.get(), (IItemProvider)TFBlocks.castle_brick_frame.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_mossy.get(), (IItemProvider)TFBlocks.castle_brick_frame.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick.get(), (IItemProvider)TFBlocks.castle_brick_worn.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_frame.get(), (IItemProvider)TFBlocks.castle_pillar_bold.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_pillar_bold.get(), (IItemProvider)TFBlocks.castle_pillar_bold_tile.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_pillar_encased.get(), (IItemProvider)TFBlocks.castle_pillar_encased_tile.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_pillar_encased.get(), (IItemProvider)TFBlocks.castle_stairs_encased.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_pillar_bold.get(), (IItemProvider)TFBlocks.castle_stairs_bold.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick.get(), (IItemProvider)TFBlocks.castle_stairs_brick.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_worn.get(), (IItemProvider)TFBlocks.castle_stairs_worn.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_cracked.get(), (IItemProvider)TFBlocks.castle_stairs_cracked.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.castle_brick_mossy.get(), (IItemProvider)TFBlocks.castle_stairs_mossy.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.etched_nagastone.get(), (IItemProvider)TFBlocks.nagastone_stairs_left.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.etched_nagastone.get(), (IItemProvider)TFBlocks.nagastone_stairs_right.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.etched_nagastone_mossy.get(), (IItemProvider)TFBlocks.nagastone_stairs_mossy_left.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.etched_nagastone_mossy.get(), (IItemProvider)TFBlocks.nagastone_stairs_mossy_right.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.etched_nagastone_weathered.get(), (IItemProvider)TFBlocks.nagastone_stairs_weathered_left.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.etched_nagastone_weathered.get(), (IItemProvider)TFBlocks.nagastone_stairs_weathered_right.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.dark_log.get(), (IItemProvider)TFBlocks.tower_wood.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.dark_wood.get(), (IItemProvider)TFBlocks.tower_wood.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.tower_wood.get(), (IItemProvider)TFBlocks.tower_wood_encased.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone.get(), (IItemProvider)TFBlocks.maze_stone_border.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone.get(), (IItemProvider)TFBlocks.maze_stone_brick.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone.get(), (IItemProvider)TFBlocks.maze_stone_chiseled.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone.get(), (IItemProvider)TFBlocks.maze_stone_decorative.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone.get(), (IItemProvider)TFBlocks.maze_stone_mosaic.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_brick.get(), (IItemProvider)TFBlocks.maze_stone_border.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_brick.get(), (IItemProvider)TFBlocks.maze_stone_chiseled.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_brick.get(), (IItemProvider)TFBlocks.maze_stone_decorative.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_brick.get(), (IItemProvider)TFBlocks.maze_stone_mosaic.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_border.get(), (IItemProvider)TFBlocks.maze_stone_brick.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_border.get(), (IItemProvider)TFBlocks.maze_stone_chiseled.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_border.get(), (IItemProvider)TFBlocks.maze_stone_decorative.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_border.get(), (IItemProvider)TFBlocks.maze_stone_mosaic.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_chiseled.get(), (IItemProvider)TFBlocks.maze_stone_border.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_chiseled.get(), (IItemProvider)TFBlocks.maze_stone_brick.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_chiseled.get(), (IItemProvider)TFBlocks.maze_stone_decorative.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_chiseled.get(), (IItemProvider)TFBlocks.maze_stone_mosaic.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_decorative.get(), (IItemProvider)TFBlocks.maze_stone_border.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_decorative.get(), (IItemProvider)TFBlocks.maze_stone_chiseled.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_decorative.get(), (IItemProvider)TFBlocks.maze_stone_brick.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_decorative.get(), (IItemProvider)TFBlocks.maze_stone_mosaic.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_mosaic.get(), (IItemProvider)TFBlocks.maze_stone_border.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_mosaic.get(), (IItemProvider)TFBlocks.maze_stone_chiseled.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_mosaic.get(), (IItemProvider)TFBlocks.maze_stone_decorative.get()));
        consumer.accept((IFinishedRecipe)stonecutting((IItemProvider)TFBlocks.maze_stone_mosaic.get(), (IItemProvider)TFBlocks.maze_stone_brick.get()));
    }
    
    public String func_200397_b() {
        return "Twilight Forest stonecutting recipes";
    }
    
    private static Wrapper stonecutting(final IItemProvider input, final IItemProvider output) {
        return stonecutting(input, output, 1);
    }
    
    private static Wrapper stonecutting(final IItemProvider input, final IItemProvider output, final int count) {
        return new Wrapper(getIdFor(input.func_199767_j(), output.func_199767_j()), Ingredient.func_199804_a(new IItemProvider[] { input }), output.func_199767_j(), count);
    }
    
    private static ResourceLocation getIdFor(final Item input, final Item output) {
        final String path = String.format("stonecutting/%s/%s", input.getRegistryName().func_110623_a(), output.getRegistryName().func_110623_a());
        return TwilightForestMod.prefix(path);
    }
    
    public static class Wrapper extends SingleItemRecipeBuilder.Result
    {
        public Wrapper(final ResourceLocation id, final Ingredient input, final Item output, final int count) {
            super(id, IRecipeSerializer.field_222175_s, "", input, output, count, (Advancement.Builder)null, (ResourceLocation)null);
        }
        
        @Nullable
        public JsonObject func_200440_c() {
            return null;
        }
        
        @Nullable
        public ResourceLocation func_200443_d() {
            return null;
        }
    }
}
