// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import javax.annotation.Nullable;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import twilightforest.TwilightForestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.ItemLike;
import net.minecraft.data.recipes.FinishedRecipe;
import java.util.function.Consumer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeProvider;

public class StonecuttingGenerator extends RecipeProvider
{
    public StonecuttingGenerator(final DataGenerator generator) {
        super(generator);
    }
    
    protected void m_176531_(final Consumer<FinishedRecipe> consumer) {
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CASTLE_BRICK.get(), (ItemLike)TFBlocks.THICK_CASTLE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CRACKED_CASTLE_BRICK.get(), (ItemLike)TFBlocks.THICK_CASTLE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.WORN_CASTLE_BRICK.get(), (ItemLike)TFBlocks.THICK_CASTLE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MOSSY_CASTLE_BRICK.get(), (ItemLike)TFBlocks.THICK_CASTLE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CASTLE_BRICK.get(), (ItemLike)TFBlocks.WORN_CASTLE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.THICK_CASTLE_BRICK.get(), (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_TILE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_TILE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_STAIRS.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_STAIRS.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CASTLE_BRICK.get(), (ItemLike)TFBlocks.CASTLE_BRICK_STAIRS.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.WORN_CASTLE_BRICK.get(), (ItemLike)TFBlocks.WORN_CASTLE_BRICK_STAIRS.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CRACKED_CASTLE_BRICK.get(), (ItemLike)TFBlocks.CRACKED_CASTLE_BRICK_STAIRS.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MOSSY_CASTLE_BRICK.get(), (ItemLike)TFBlocks.MOSSY_CASTLE_BRICK_STAIRS.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.ETCHED_NAGASTONE.get(), (ItemLike)TFBlocks.NAGASTONE_STAIRS_LEFT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.ETCHED_NAGASTONE.get(), (ItemLike)TFBlocks.NAGASTONE_STAIRS_RIGHT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MOSSY_ETCHED_NAGASTONE.get(), (ItemLike)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MOSSY_ETCHED_NAGASTONE.get(), (ItemLike)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CRACKED_ETCHED_NAGASTONE.get(), (ItemLike)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CRACKED_ETCHED_NAGASTONE.get(), (ItemLike)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.NAGASTONE_STAIRS_RIGHT.get(), (ItemLike)TFBlocks.NAGASTONE_STAIRS_LEFT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.NAGASTONE_STAIRS_LEFT.get(), (ItemLike)TFBlocks.NAGASTONE_STAIRS_RIGHT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get(), (ItemLike)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get(), (ItemLike)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get(), (ItemLike)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get(), (ItemLike)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DARK_LOG.get(), (ItemLike)TFBlocks.TOWERWOOD.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DARK_WOOD.get(), (ItemLike)TFBlocks.TOWERWOOD.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.TOWERWOOD.get(), (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_BORDER.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE.get(), (ItemLike)TFBlocks.CUT_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE.get(), (ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_MOSAIC.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BRICK.get(), (ItemLike)TFBlocks.MAZESTONE_BORDER.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BRICK.get(), (ItemLike)TFBlocks.CUT_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BRICK.get(), (ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BRICK.get(), (ItemLike)TFBlocks.MAZESTONE_MOSAIC.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BORDER.get(), (ItemLike)TFBlocks.MAZESTONE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BORDER.get(), (ItemLike)TFBlocks.CUT_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BORDER.get(), (ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_BORDER.get(), (ItemLike)TFBlocks.MAZESTONE_MOSAIC.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CUT_MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_BORDER.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CUT_MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CUT_MAZESTONE.get(), (ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CUT_MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_MOSAIC.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_BORDER.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get(), (ItemLike)TFBlocks.CUT_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get(), (ItemLike)TFBlocks.MAZESTONE_MOSAIC.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_MOSAIC.get(), (ItemLike)TFBlocks.MAZESTONE_BORDER.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_MOSAIC.get(), (ItemLike)TFBlocks.CUT_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_MOSAIC.get(), (ItemLike)TFBlocks.DECORATIVE_MAZESTONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MAZESTONE_MOSAIC.get(), (ItemLike)TFBlocks.MAZESTONE_BRICK.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.TWILIGHT_OAK_LOG.get(), (ItemLike)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.CANOPY_LOG.get(), (ItemLike)TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MANGROVE_LOG.get(), (ItemLike)TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.DARK_LOG.get(), (ItemLike)TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.TIME_LOG.get(), (ItemLike)TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.TRANSFORMATION_LOG.get(), (ItemLike)TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.MINING_LOG.get(), (ItemLike)TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.SORTING_LOG.get(), (ItemLike)TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_49999_, (ItemLike)TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50000_, (ItemLike)TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50001_, (ItemLike)TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50002_, (ItemLike)TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50003_, (ItemLike)TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50004_, (ItemLike)TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50695_, (ItemLike)TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50686_, (ItemLike)TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50069_, (ItemLike)TFBlocks.TWISTED_STONE.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)Blocks.f_50069_, (ItemLike)TFBlocks.BOLD_STONE_PILLAR.get()));
        consumer.accept((FinishedRecipe)stonecutting((ItemLike)TFBlocks.UNDERBRICK.get(), (ItemLike)TFBlocks.UNDERBRICK_FLOOR.get()));
    }
    
    public String m_6055_() {
        return "Twilight Forest stonecutting recipes";
    }
    
    private static Wrapper stonecutting(final ItemLike input, final ItemLike output) {
        return stonecutting(input, output, 1);
    }
    
    private static Wrapper stonecutting(final ItemLike input, final ItemLike output, final int count) {
        return new Wrapper(getIdFor(input.m_5456_(), output.m_5456_()), Ingredient.m_43929_(new ItemLike[] { input }), output.m_5456_(), count);
    }
    
    private static ResourceLocation getIdFor(final Item input, final Item output) {
        final String path = String.format("stonecutting/%s/%s", input.getRegistryName().m_135815_(), output.getRegistryName().m_135815_());
        return TwilightForestMod.prefix(path);
    }
    
    public static class Wrapper extends SingleItemRecipeBuilder.Result
    {
        public Wrapper(final ResourceLocation id, final Ingredient input, final Item output, final int count) {
            super(id, RecipeSerializer.f_44095_, "", input, output, count, (Advancement.Builder)null, (ResourceLocation)null);
        }
        
        @Nullable
        public JsonObject m_5860_() {
            return null;
        }
        
        @Nullable
        public ResourceLocation m_6448_() {
            return null;
        }
    }
}
