// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.block.TorchberryPlantBlock;
import twilightforest.block.AbstractParticleSpawnerBlock;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraft.world.level.storage.loot.functions.CopyBlockState;
import twilightforest.block.HollowLogClimbable;
import twilightforest.enums.HollowLogVariants;
import twilightforest.block.HollowLogHorizontal;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.storage.loot.providers.nbt.NbtProvider;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import twilightforest.block.TrophyBlock;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.block.Blocks;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.storage.loot.LootTable;
import java.util.HashSet;
import net.minecraft.world.level.block.Block;
import java.util.Set;
import net.minecraft.data.loot.BlockLoot;

public class BlockLootTables extends BlockLoot
{
    private final Set<Block> knownBlocks;
    private static final float[] DEFAULT_SAPLING_DROP_RATES;
    private static final float[] RARE_SAPLING_DROP_RATES;
    
    public BlockLootTables() {
        this.knownBlocks = new HashSet<Block>();
    }
    
    protected void m_124165_(final Block block, final LootTable.Builder builder) {
        super.m_124165_(block, builder);
        this.knownBlocks.add(block);
    }
    
    protected void addTables() {
        this.registerEmpty((Block)TFBlocks.EXPERIMENT_115.get());
        this.m_124288_((Block)TFBlocks.TOWERWOOD.get());
        this.m_124288_((Block)TFBlocks.ENCASED_TOWERWOOD.get());
        this.m_124288_((Block)TFBlocks.CRACKED_TOWERWOOD.get());
        this.m_124288_((Block)TFBlocks.MOSSY_TOWERWOOD.get());
        this.registerEmpty((Block)TFBlocks.ANTIBUILDER.get());
        this.m_124288_((Block)TFBlocks.CARMINITE_BUILDER.get());
        this.m_124288_((Block)TFBlocks.GHAST_TRAP.get());
        this.m_124288_((Block)TFBlocks.CARMINITE_REACTOR.get());
        this.m_124288_((Block)TFBlocks.REAPPEARING_BLOCK.get());
        this.m_124288_((Block)TFBlocks.VANISHING_BLOCK.get());
        this.m_124288_((Block)TFBlocks.LOCKED_VANISHING_BLOCK.get());
        this.m_124288_((Block)TFBlocks.FIREFLY.get());
        this.m_124288_((Block)TFBlocks.CICADA.get());
        this.m_124288_((Block)TFBlocks.MOONWORM.get());
        this.m_124288_((Block)TFBlocks.TROPHY_PEDESTAL.get());
        this.m_124288_((Block)TFBlocks.AURORA_BLOCK.get());
        this.m_124288_((Block)TFBlocks.AURORA_PILLAR.get());
        this.m_124165_((Block)TFBlocks.AURORA_SLAB.get(), m_124290_((Block)TFBlocks.AURORA_SLAB.get()));
        this.m_124272_((Block)TFBlocks.AURORALIZED_GLASS.get());
        this.m_124288_((Block)TFBlocks.UNDERBRICK.get());
        this.m_124288_((Block)TFBlocks.CRACKED_UNDERBRICK.get());
        this.m_124288_((Block)TFBlocks.MOSSY_UNDERBRICK.get());
        this.m_124288_((Block)TFBlocks.UNDERBRICK_FLOOR.get());
        this.m_124288_((Block)TFBlocks.THORN_ROSE.get());
        this.m_124165_((Block)TFBlocks.THORN_LEAVES.get(), silkAndStick((Block)TFBlocks.THORN_LEAVES.get(), (ItemLike)Items.f_42398_, BlockLootTables.RARE_SAPLING_DROP_RATES));
        this.m_124165_((Block)TFBlocks.BEANSTALK_LEAVES.get(), silkAndStick((Block)TFBlocks.BEANSTALK_LEAVES.get(), (ItemLike)TFItems.MAGIC_BEANS.get(), BlockLootTables.RARE_SAPLING_DROP_RATES));
        this.m_124288_((Block)TFBlocks.DEADROCK.get());
        this.m_124288_((Block)TFBlocks.CRACKED_DEADROCK.get());
        this.m_124288_((Block)TFBlocks.WEATHERED_DEADROCK.get());
        this.m_124288_((Block)TFBlocks.TROLLSTEINN.get());
        this.m_124272_((Block)TFBlocks.WISPY_CLOUD.get());
        this.m_124288_((Block)TFBlocks.FLUFFY_CLOUD.get());
        this.m_124288_((Block)TFBlocks.GIANT_COBBLESTONE.get());
        this.m_124288_((Block)TFBlocks.GIANT_LOG.get());
        this.m_124288_((Block)TFBlocks.GIANT_LEAVES.get());
        this.m_124288_((Block)TFBlocks.GIANT_OBSIDIAN.get());
        this.m_124165_((Block)TFBlocks.UBEROUS_SOIL.get(), m_124126_((ItemLike)Blocks.f_50493_));
        this.m_124288_((Block)TFBlocks.HUGE_STALK.get());
        this.m_124165_((Block)TFBlocks.HUGE_MUSHGLOOM.get(), m_124277_((Block)TFBlocks.HUGE_MUSHGLOOM.get(), (ItemLike)TFBlocks.MUSHGLOOM.get()));
        this.m_124165_((Block)TFBlocks.HUGE_MUSHGLOOM_STEM.get(), m_124277_((Block)TFBlocks.HUGE_MUSHGLOOM_STEM.get(), (ItemLike)TFBlocks.MUSHGLOOM.get()));
        this.m_124165_((Block)TFBlocks.TROLLVIDR.get(), m_124286_((ItemLike)TFBlocks.TROLLVIDR.get()));
        this.m_124165_((Block)TFBlocks.UNRIPE_TROLLBER.get(), m_124286_((ItemLike)TFBlocks.UNRIPE_TROLLBER.get()));
        this.m_124165_((Block)TFBlocks.TROLLBER.get(), m_124267_((Block)TFBlocks.TROLLBER.get(), (LootPoolEntryContainer.Builder)LootItem.m_79579_((ItemLike)TFItems.TORCHBERRIES.get()).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_(4.0f, 8.0f))).m_5577_((LootItemFunction.Builder)ApplyBonusCount.m_79915_(Enchantments.f_44987_))));
        this.m_124288_((Block)TFBlocks.HUGE_LILY_PAD.get());
        this.m_124288_((Block)TFBlocks.HUGE_WATER_LILY.get());
        this.m_124288_((Block)TFBlocks.CASTLE_BRICK.get());
        this.m_124288_((Block)TFBlocks.WORN_CASTLE_BRICK.get());
        this.m_124288_((Block)TFBlocks.CRACKED_CASTLE_BRICK.get());
        this.m_124288_((Block)TFBlocks.MOSSY_CASTLE_BRICK.get());
        this.m_124288_((Block)TFBlocks.THICK_CASTLE_BRICK.get());
        this.m_124288_((Block)TFBlocks.CASTLE_ROOF_TILE.get());
        this.m_124288_((Block)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get());
        this.m_124288_((Block)TFBlocks.ENCASED_CASTLE_BRICK_TILE.get());
        this.m_124288_((Block)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get());
        this.m_124288_((Block)TFBlocks.BOLD_CASTLE_BRICK_TILE.get());
        this.m_124288_((Block)TFBlocks.CASTLE_BRICK_STAIRS.get());
        this.m_124288_((Block)TFBlocks.WORN_CASTLE_BRICK_STAIRS.get());
        this.m_124288_((Block)TFBlocks.CRACKED_CASTLE_BRICK_STAIRS.get());
        this.m_124288_((Block)TFBlocks.MOSSY_CASTLE_BRICK_STAIRS.get());
        this.m_124288_((Block)TFBlocks.ENCASED_CASTLE_BRICK_STAIRS.get());
        this.m_124288_((Block)TFBlocks.BOLD_CASTLE_BRICK_STAIRS.get());
        this.m_124288_((Block)TFBlocks.VIOLET_CASTLE_RUNE_BRICK.get());
        this.m_124288_((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get());
        this.m_124288_((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get());
        this.m_124288_((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get());
        this.m_124288_((Block)TFBlocks.CINDER_FURNACE.get());
        this.m_124288_((Block)TFBlocks.CINDER_LOG.get());
        this.m_124288_((Block)TFBlocks.CINDER_WOOD.get());
        this.m_124288_((Block)TFBlocks.VIOLET_CASTLE_DOOR.get());
        this.m_124288_((Block)TFBlocks.YELLOW_CASTLE_DOOR.get());
        this.m_124288_((Block)TFBlocks.PINK_CASTLE_DOOR.get());
        this.m_124288_((Block)TFBlocks.BLUE_CASTLE_DOOR.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get());
        this.m_124288_((Block)TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE.get());
        this.m_124288_((Block)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get());
        this.m_124288_((Block)TFBlocks.KNIGHTMETAL_BLOCK.get());
        this.m_124288_((Block)TFBlocks.IRONWOOD_BLOCK.get());
        this.m_124288_((Block)TFBlocks.FIERY_BLOCK.get());
        this.m_124288_((Block)TFBlocks.STEELEAF_BLOCK.get());
        this.m_124288_((Block)TFBlocks.ARCTIC_FUR_BLOCK.get());
        this.m_124288_((Block)TFBlocks.CARMINITE_BLOCK.get());
        this.m_124288_((Block)TFBlocks.MAZESTONE.get());
        this.m_124288_((Block)TFBlocks.MAZESTONE_BRICK.get());
        this.m_124288_((Block)TFBlocks.CUT_MAZESTONE.get());
        this.m_124288_((Block)TFBlocks.DECORATIVE_MAZESTONE.get());
        this.m_124288_((Block)TFBlocks.CRACKED_MAZESTONE.get());
        this.m_124288_((Block)TFBlocks.MOSSY_MAZESTONE.get());
        this.m_124288_((Block)TFBlocks.MAZESTONE_MOSAIC.get());
        this.m_124288_((Block)TFBlocks.MAZESTONE_BORDER.get());
        this.m_124272_((Block)TFBlocks.HEDGE.get());
        this.m_124165_((Block)TFBlocks.ROOT_BLOCK.get(), m_176042_((Block)TFBlocks.ROOT_BLOCK.get(), (ItemLike)Items.f_42398_, (NumberProvider)UniformGenerator.m_165780_(3.0f, 5.0f)));
        this.m_124165_((Block)TFBlocks.LIVEROOT_BLOCK.get(), m_124168_((Block)TFBlocks.LIVEROOT_BLOCK.get(), (LootPoolEntryContainer.Builder)m_124134_((ItemLike)TFBlocks.LIVEROOT_BLOCK.get(), (ConditionUserBuilder)LootItem.m_79579_((ItemLike)TFItems.LIVEROOT.get()).m_5577_((LootItemFunction.Builder)ApplyBonusCount.m_79915_(Enchantments.f_44987_)))));
        this.m_124165_((Block)TFBlocks.MANGROVE_ROOT.get(), m_176042_((Block)TFBlocks.MANGROVE_ROOT.get(), (ItemLike)Items.f_42398_, (NumberProvider)UniformGenerator.m_165780_(3.0f, 5.0f)));
        this.m_124288_((Block)TFBlocks.UNCRAFTING_TABLE.get());
        this.m_124288_((Block)TFBlocks.FIREFLY_JAR.get());
        this.m_124165_((Block)TFBlocks.FIREFLY_SPAWNER.get(), particleSpawner());
        this.m_124288_((Block)TFBlocks.CICADA_JAR.get());
        this.m_124165_((Block)TFBlocks.MOSS_PATCH.get(), m_124286_((ItemLike)TFBlocks.MOSS_PATCH.get()));
        this.m_124165_((Block)TFBlocks.MAYAPPLE.get(), m_124286_((ItemLike)TFBlocks.MAYAPPLE.get()));
        this.m_124165_((Block)TFBlocks.CLOVER_PATCH.get(), m_124286_((ItemLike)TFBlocks.CLOVER_PATCH.get()));
        this.m_124165_((Block)TFBlocks.FIDDLEHEAD.get(), m_124286_((ItemLike)TFBlocks.FIDDLEHEAD.get()));
        this.m_124288_((Block)TFBlocks.MUSHGLOOM.get());
        this.m_124165_((Block)TFBlocks.TORCHBERRY_PLANT.get(), torchberryPlant((Block)TFBlocks.TORCHBERRY_PLANT.get()));
        this.m_124175_((Block)TFBlocks.ROOT_STRAND.get(), block -> m_124267_(block, (LootPoolEntryContainer.Builder)m_124131_((ItemLike)block, (FunctionUserBuilder)LootItem.m_79579_((ItemLike)Items.f_42398_).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_(1.0f, 3.0f))))));
        this.m_124165_((Block)TFBlocks.FALLEN_LEAVES.get(), m_124286_((ItemLike)TFBlocks.FALLEN_LEAVES.get()));
        this.m_124288_((Block)TFBlocks.SMOKER.get());
        this.m_124288_((Block)TFBlocks.ENCASED_SMOKER.get());
        this.m_124288_((Block)TFBlocks.FIRE_JET.get());
        this.m_124288_((Block)TFBlocks.ENCASED_FIRE_JET.get());
        this.m_124288_((Block)TFBlocks.NAGASTONE_HEAD.get());
        this.m_124288_((Block)TFBlocks.NAGASTONE.get());
        this.m_124288_((Block)TFBlocks.SPIRAL_BRICKS.get());
        this.m_124288_((Block)TFBlocks.NAGASTONE_PILLAR.get());
        this.m_124288_((Block)TFBlocks.MOSSY_NAGASTONE_PILLAR.get());
        this.m_124288_((Block)TFBlocks.CRACKED_NAGASTONE_PILLAR.get());
        this.m_124288_((Block)TFBlocks.ETCHED_NAGASTONE.get());
        this.m_124288_((Block)TFBlocks.MOSSY_ETCHED_NAGASTONE.get());
        this.m_124288_((Block)TFBlocks.CRACKED_ETCHED_NAGASTONE.get());
        this.m_124288_((Block)TFBlocks.NAGASTONE_STAIRS_LEFT.get());
        this.m_124288_((Block)TFBlocks.NAGASTONE_STAIRS_RIGHT.get());
        this.m_124288_((Block)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get());
        this.m_124288_((Block)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get());
        this.m_124288_((Block)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get());
        this.m_124288_((Block)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get());
        this.m_124165_((Block)TFBlocks.NAGA_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.NAGA_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.NAGA_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.NAGA_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.LICH_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.LICH_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.LICH_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.LICH_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.MINOSHROOM_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.MINOSHROOM_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.MINOSHROOM_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.MINOSHROOM_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.HYDRA_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.HYDRA_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.HYDRA_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.HYDRA_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.KNIGHT_PHANTOM_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.KNIGHT_PHANTOM_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.KNIGHT_PHANTOM_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.UR_GHAST_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.UR_GHAST_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.UR_GHAST_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.UR_GHAST_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.ALPHA_YETI_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.ALPHA_YETI_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.ALPHA_YETI_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.ALPHA_YETI_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.SNOW_QUEEN_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.SNOW_QUEEN_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.SNOW_QUEEN_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.SNOW_QUEEN_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.QUEST_RAM_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.QUEST_RAM_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.QUEST_RAM_WALL_TROPHY.get(), m_124126_((ItemLike)((TrophyBlock)TFBlocks.QUEST_RAM_TROPHY.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.ZOMBIE_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50314_));
        this.m_124165_((Block)TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50314_));
        this.m_124165_((Block)TFBlocks.SKELETON_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50310_));
        this.m_124165_((Block)TFBlocks.SKELETON_WALL_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50310_));
        this.m_124165_((Block)TFBlocks.WITHER_SKELE_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50312_));
        this.m_124165_((Block)TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50312_));
        this.m_124165_((Block)TFBlocks.CREEPER_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50318_));
        this.m_124165_((Block)TFBlocks.CREEPER_WALL_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50318_));
        this.m_124165_((Block)TFBlocks.PLAYER_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50316_).m_5577_((LootItemFunction.Builder)CopyNbtFunction.m_165180_((NbtProvider)ContextNbtProvider.f_165562_).m_80279_("SkullOwner", "SkullOwner")));
        this.m_124165_((Block)TFBlocks.PLAYER_WALL_SKULL_CANDLE.get(), dropWithoutSilk(Blocks.f_50316_).m_5577_((LootItemFunction.Builder)CopyNbtFunction.m_165180_((NbtProvider)ContextNbtProvider.f_165562_).m_80279_("SkullOwner", "SkullOwner")));
        this.m_124288_((Block)TFBlocks.IRON_LADDER.get());
        this.m_124288_((Block)TFBlocks.TWISTED_STONE.get());
        this.m_124288_((Block)TFBlocks.TWISTED_STONE_PILLAR.get());
        this.m_124288_((Block)TFBlocks.BOLD_STONE_PILLAR.get());
        this.registerEmpty((Block)TFBlocks.DEATH_TOME_SPAWNER.get());
        this.m_124272_((Block)TFBlocks.EMPTY_CANOPY_BOOKSHELF.get());
        this.m_124165_((Block)TFBlocks.KEEPSAKE_CASKET.get(), casketInfo((Block)TFBlocks.KEEPSAKE_CASKET.get()));
        this.m_124288_((Block)TFBlocks.CANDELABRA.get());
        this.m_124252_((Block)TFBlocks.POTTED_TWILIGHT_OAK_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_CANOPY_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_MANGROVE_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_DARKWOOD_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_HOLLOW_OAK_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_RAINBOW_OAK_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_TIME_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_TRANSFORMATION_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_MINING_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_SORTING_SAPLING.get());
        this.m_124252_((Block)TFBlocks.POTTED_MAYAPPLE.get());
        this.m_124252_((Block)TFBlocks.POTTED_FIDDLEHEAD.get());
        this.m_124252_((Block)TFBlocks.POTTED_MUSHGLOOM.get());
        this.m_124165_((Block)TFBlocks.POTTED_THORN.get(), m_124126_((ItemLike)Items.f_42618_));
        this.m_124165_((Block)TFBlocks.POTTED_GREEN_THORN.get(), m_124126_((ItemLike)Items.f_42618_));
        this.m_124165_((Block)TFBlocks.POTTED_DEAD_THORN.get(), m_124126_((ItemLike)Items.f_42618_));
        this.m_124288_((Block)TFBlocks.OAK_BANISTER.get());
        this.m_124288_((Block)TFBlocks.SPRUCE_BANISTER.get());
        this.m_124288_((Block)TFBlocks.BIRCH_BANISTER.get());
        this.m_124288_((Block)TFBlocks.JUNGLE_BANISTER.get());
        this.m_124288_((Block)TFBlocks.ACACIA_BANISTER.get());
        this.m_124288_((Block)TFBlocks.DARK_OAK_BANISTER.get());
        this.m_124288_((Block)TFBlocks.CRIMSON_BANISTER.get());
        this.m_124288_((Block)TFBlocks.WARPED_BANISTER.get());
        this.m_124165_((Block)TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL.get(), this.hollowLog((Block)TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_OAK_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_OAK_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_SPRUCE_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_SPRUCE_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_BIRCH_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_BIRCH_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_JUNGLE_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_JUNGLE_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_ACACIA_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_ACACIA_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_DARK_OAK_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_DARK_OAK_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_CRIMSON_STEM_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_CRIMSON_STEM_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_WARPED_STEM_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_WARPED_STEM_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_CANOPY_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_CANOPY_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_MANGROVE_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_MANGROVE_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_DARK_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_DARK_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TIME_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_TIME_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TRANSFORMATION_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_TRANSFORMATION_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_MINING_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_MINING_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_SORTING_LOG_VERTICAL.get(), this.verticalHollowLog((Block)TFBlocks.HOLLOW_SORTING_LOG_VERTICAL.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_OAK_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_OAK_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_SPRUCE_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_SPRUCE_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_BIRCH_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_BIRCH_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_JUNGLE_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_JUNGLE_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_ACACIA_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_ACACIA_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_DARK_OAK_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_DARK_OAK_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_CRIMSON_STEM_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_CRIMSON_STEM_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_WARPED_STEM_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_WARPED_STEM_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_CANOPY_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_CANOPY_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_MANGROVE_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_MANGROVE_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_DARK_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_DARK_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TIME_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_TIME_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_TRANSFORMATION_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_TRANSFORMATION_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_MINING_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_MINING_LOG_CLIMBABLE.get()));
        this.m_124165_((Block)TFBlocks.HOLLOW_SORTING_LOG_CLIMBABLE.get(), this.hollowLog((Block)TFBlocks.HOLLOW_SORTING_LOG_CLIMBABLE.get()));
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_TWILIGHT_OAK_LOG.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_SAPLING.get());
        this.m_124165_((Block)TFBlocks.TWILIGHT_OAK_LEAVES.get(), m_124157_((Block)TFBlocks.TWILIGHT_OAK_LEAVES.get(), (Block)TFBlocks.TWILIGHT_OAK_SAPLING.get(), BlockLootTables.DEFAULT_SAPLING_DROP_RATES));
        this.m_124288_((Block)TFBlocks.RAINBOW_OAK_SAPLING.get());
        this.m_124165_((Block)TFBlocks.RAINBOW_OAK_LEAVES.get(), m_124157_((Block)TFBlocks.RAINBOW_OAK_LEAVES.get(), (Block)TFBlocks.RAINBOW_OAK_SAPLING.get(), BlockLootTables.RARE_SAPLING_DROP_RATES));
        this.m_124288_((Block)TFBlocks.HOLLOW_OAK_SAPLING.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_PLANKS.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_STAIRS.get());
        this.m_124165_((Block)TFBlocks.TWILIGHT_OAK_SLAB.get(), m_124290_((Block)TFBlocks.TWILIGHT_OAK_SLAB.get()));
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_BUTTON.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_FENCE.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_GATE.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_PLATE.get());
        this.m_124165_((Block)TFBlocks.TWILIGHT_OAK_DOOR.get(), m_124161_((Block)TFBlocks.TWILIGHT_OAK_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.TWILIGHT_OAK_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.TWILIGHT_OAK_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.TWILIGHT_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.TWILIGHT_OAK_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_BANISTER.get());
        this.m_124288_((Block)TFBlocks.TWILIGHT_OAK_CHEST.get());
        this.m_124288_((Block)TFBlocks.CANOPY_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_CANOPY_LOG.get());
        this.m_124288_((Block)TFBlocks.CANOPY_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_CANOPY_WOOD.get());
        this.m_124288_((Block)TFBlocks.CANOPY_SAPLING.get());
        this.m_124165_((Block)TFBlocks.CANOPY_LEAVES.get(), m_124157_((Block)TFBlocks.CANOPY_LEAVES.get(), (Block)TFBlocks.CANOPY_SAPLING.get(), BlockLootTables.DEFAULT_SAPLING_DROP_RATES));
        this.m_124288_((Block)TFBlocks.CANOPY_PLANKS.get());
        this.m_124288_((Block)TFBlocks.CANOPY_STAIRS.get());
        this.m_124165_((Block)TFBlocks.CANOPY_SLAB.get(), m_124290_((Block)TFBlocks.CANOPY_SLAB.get()));
        this.m_124288_((Block)TFBlocks.CANOPY_BUTTON.get());
        this.m_124288_((Block)TFBlocks.CANOPY_FENCE.get());
        this.m_124288_((Block)TFBlocks.CANOPY_GATE.get());
        this.m_124288_((Block)TFBlocks.CANOPY_PLATE.get());
        this.m_124165_((Block)TFBlocks.CANOPY_DOOR.get(), m_124161_((Block)TFBlocks.CANOPY_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.CANOPY_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.CANOPY_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.CANOPY_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.CANOPY_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.CANOPY_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.CANOPY_BOOKSHELF.get(), m_176042_((Block)TFBlocks.CANOPY_BOOKSHELF.get(), (ItemLike)Items.f_42517_, (NumberProvider)ConstantValue.m_165692_(3.0f)));
        this.m_124288_((Block)TFBlocks.CANOPY_BANISTER.get());
        this.m_124288_((Block)TFBlocks.CANOPY_CHEST.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_MANGROVE_LOG.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_MANGROVE_WOOD.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_SAPLING.get());
        this.m_124165_((Block)TFBlocks.MANGROVE_LEAVES.get(), m_124157_((Block)TFBlocks.MANGROVE_LEAVES.get(), (Block)TFBlocks.MANGROVE_SAPLING.get(), BlockLootTables.DEFAULT_SAPLING_DROP_RATES));
        this.m_124288_((Block)TFBlocks.MANGROVE_PLANKS.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_STAIRS.get());
        this.m_124165_((Block)TFBlocks.MANGROVE_SLAB.get(), m_124290_((Block)TFBlocks.MANGROVE_SLAB.get()));
        this.m_124288_((Block)TFBlocks.MANGROVE_BUTTON.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_FENCE.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_GATE.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_PLATE.get());
        this.m_124165_((Block)TFBlocks.MANGROVE_DOOR.get(), m_124161_((Block)TFBlocks.MANGROVE_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.MANGROVE_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.MANGROVE_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.MANGROVE_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.MANGROVE_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.MANGROVE_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.MANGROVE_BANISTER.get());
        this.m_124288_((Block)TFBlocks.MANGROVE_CHEST.get());
        this.m_124288_((Block)TFBlocks.DARK_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_DARK_LOG.get());
        this.m_124288_((Block)TFBlocks.DARK_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_DARK_WOOD.get());
        this.m_124288_((Block)TFBlocks.DARKWOOD_SAPLING.get());
        this.m_124165_((Block)TFBlocks.DARK_LEAVES.get(), m_124157_((Block)TFBlocks.DARK_LEAVES.get(), (Block)TFBlocks.DARKWOOD_SAPLING.get(), BlockLootTables.RARE_SAPLING_DROP_RATES));
        this.m_124165_((Block)TFBlocks.HARDENED_DARK_LEAVES.get(), m_124157_((Block)TFBlocks.DARK_LEAVES.get(), (Block)TFBlocks.DARKWOOD_SAPLING.get(), BlockLootTables.RARE_SAPLING_DROP_RATES));
        this.m_124288_((Block)TFBlocks.DARK_PLANKS.get());
        this.m_124288_((Block)TFBlocks.DARK_STAIRS.get());
        this.m_124165_((Block)TFBlocks.DARK_SLAB.get(), m_124290_((Block)TFBlocks.DARK_SLAB.get()));
        this.m_124288_((Block)TFBlocks.DARK_BUTTON.get());
        this.m_124288_((Block)TFBlocks.DARK_FENCE.get());
        this.m_124288_((Block)TFBlocks.DARK_GATE.get());
        this.m_124288_((Block)TFBlocks.DARK_PLATE.get());
        this.m_124165_((Block)TFBlocks.DARK_DOOR.get(), m_124161_((Block)TFBlocks.DARK_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.DARK_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.DARKWOOD_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.DARKWOOD_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.DARKWOOD_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.DARKWOOD_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.DARKWOOD_BANISTER.get());
        this.m_124288_((Block)TFBlocks.DARKWOOD_CHEST.get());
        this.m_124288_((Block)TFBlocks.TIME_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_TIME_LOG.get());
        this.m_124288_((Block)TFBlocks.TIME_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_TIME_WOOD.get());
        this.m_124147_((Block)TFBlocks.TIME_LOG_CORE.get(), (ItemLike)TFBlocks.TIME_LOG.get());
        this.m_124288_((Block)TFBlocks.TIME_SAPLING.get());
        this.registerLeavesNoSapling((Block)TFBlocks.TIME_LEAVES.get());
        this.m_124288_((Block)TFBlocks.TIME_PLANKS.get());
        this.m_124288_((Block)TFBlocks.TIME_STAIRS.get());
        this.m_124165_((Block)TFBlocks.TIME_SLAB.get(), m_124290_((Block)TFBlocks.TIME_SLAB.get()));
        this.m_124288_((Block)TFBlocks.TIME_BUTTON.get());
        this.m_124288_((Block)TFBlocks.TIME_FENCE.get());
        this.m_124288_((Block)TFBlocks.TIME_GATE.get());
        this.m_124288_((Block)TFBlocks.TIME_PLATE.get());
        this.m_124165_((Block)TFBlocks.TIME_DOOR.get(), m_124161_((Block)TFBlocks.TIME_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.TIME_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.TIME_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.TIME_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.TIME_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.TIME_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.TIME_BANISTER.get());
        this.m_124288_((Block)TFBlocks.TIME_CHEST.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_TRANSFORMATION_LOG.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_TRANSFORMATION_WOOD.get());
        this.m_124147_((Block)TFBlocks.TRANSFORMATION_LOG_CORE.get(), (ItemLike)TFBlocks.TRANSFORMATION_LOG.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_SAPLING.get());
        this.registerLeavesNoSapling((Block)TFBlocks.TRANSFORMATION_LEAVES.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_PLANKS.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_STAIRS.get());
        this.m_124165_((Block)TFBlocks.TRANSFORMATION_SLAB.get(), m_124290_((Block)TFBlocks.TRANSFORMATION_SLAB.get()));
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_BUTTON.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_FENCE.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_GATE.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_PLATE.get());
        this.m_124165_((Block)TFBlocks.TRANSFORMATION_DOOR.get(), m_124161_((Block)TFBlocks.TRANSFORMATION_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.TRANSFORMATION_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.TRANSFORMATION_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.TRANSFORMATION_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.TRANSFORMATION_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_BANISTER.get());
        this.m_124288_((Block)TFBlocks.TRANSFORMATION_CHEST.get());
        this.m_124288_((Block)TFBlocks.MINING_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_MINING_LOG.get());
        this.m_124288_((Block)TFBlocks.MINING_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_MINING_WOOD.get());
        this.m_124147_((Block)TFBlocks.MINING_LOG_CORE.get(), (ItemLike)TFBlocks.MINING_LOG.get());
        this.m_124288_((Block)TFBlocks.MINING_SAPLING.get());
        this.registerLeavesNoSapling((Block)TFBlocks.MINING_LEAVES.get());
        this.m_124288_((Block)TFBlocks.MINING_PLANKS.get());
        this.m_124288_((Block)TFBlocks.MINING_STAIRS.get());
        this.m_124165_((Block)TFBlocks.MINING_SLAB.get(), m_124290_((Block)TFBlocks.MINING_SLAB.get()));
        this.m_124288_((Block)TFBlocks.MINING_BUTTON.get());
        this.m_124288_((Block)TFBlocks.MINING_FENCE.get());
        this.m_124288_((Block)TFBlocks.MINING_GATE.get());
        this.m_124288_((Block)TFBlocks.MINING_PLATE.get());
        this.m_124165_((Block)TFBlocks.MINING_DOOR.get(), m_124161_((Block)TFBlocks.MINING_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.MINING_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.MINING_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.MINING_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.MINING_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.MINING_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.MINING_BANISTER.get());
        this.m_124288_((Block)TFBlocks.MINING_CHEST.get());
        this.m_124288_((Block)TFBlocks.SORTING_LOG.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_SORTING_LOG.get());
        this.m_124288_((Block)TFBlocks.SORTING_WOOD.get());
        this.m_124288_((Block)TFBlocks.STRIPPED_SORTING_WOOD.get());
        this.m_124147_((Block)TFBlocks.SORTING_LOG_CORE.get(), (ItemLike)TFBlocks.SORTING_LOG.get());
        this.m_124288_((Block)TFBlocks.SORTING_SAPLING.get());
        this.registerLeavesNoSapling((Block)TFBlocks.SORTING_LEAVES.get());
        this.m_124288_((Block)TFBlocks.SORTING_PLANKS.get());
        this.m_124288_((Block)TFBlocks.SORTING_STAIRS.get());
        this.m_124165_((Block)TFBlocks.SORTING_SLAB.get(), m_124290_((Block)TFBlocks.SORTING_SLAB.get()));
        this.m_124288_((Block)TFBlocks.SORTING_BUTTON.get());
        this.m_124288_((Block)TFBlocks.SORTING_FENCE.get());
        this.m_124288_((Block)TFBlocks.SORTING_GATE.get());
        this.m_124288_((Block)TFBlocks.SORTING_PLATE.get());
        this.m_124165_((Block)TFBlocks.SORTING_DOOR.get(), m_124161_((Block)TFBlocks.SORTING_DOOR.get(), (Property)DoorBlock.f_52730_, (Comparable)DoubleBlockHalf.LOWER));
        this.m_124288_((Block)TFBlocks.SORTING_TRAPDOOR.get());
        this.m_124165_((Block)TFBlocks.SORTING_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.SORTING_SIGN.get()).m_5456_()));
        this.m_124165_((Block)TFBlocks.SORTING_WALL_SIGN.get(), m_124126_((ItemLike)((StandingSignBlock)TFBlocks.SORTING_SIGN.get()).m_5456_()));
        this.m_124288_((Block)TFBlocks.SORTING_BANISTER.get());
        this.m_124288_((Block)TFBlocks.SORTING_CHEST.get());
    }
    
    private void registerLeavesNoSapling(final Block leaves) {
        final LootPoolEntryContainer.Builder<?> sticks = (LootPoolEntryContainer.Builder<?>)m_124131_((ItemLike)leaves, (FunctionUserBuilder)LootItem.m_79579_((ItemLike)Items.f_42398_).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_(1.0f, 2.0f))).m_6509_(BonusLevelTableCondition.m_81517_(Enchantments.f_44987_, new float[] { 0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f })));
        this.m_124165_(leaves, m_124283_(leaves, (LootPoolEntryContainer.Builder)sticks));
    }
    
    private LootTable.Builder hollowLog(final Block log) {
        final LootItemCondition.Builder HAS_SILK_TOUCH = (LootItemCondition.Builder)ObfuscationReflectionHelper.getPrivateValue((Class)BlockLoot.class, (Object)null, "f_124062_");
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)log.m_5456_()).m_6509_(HAS_SILK_TOUCH)).m_7170_((LootPoolEntryContainer.Builder)LootItem.m_79579_((ItemLike)Items.f_42398_).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_(2.0f, 4.0f))).m_5577_((LootItemFunction.Builder)ApplyBonusCount.m_79939_(Enchantments.f_44987_))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)Blocks.f_50034_).m_6509_(HAS_SILK_TOUCH)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.MOSS_AND_GRASS))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)TFBlocks.MOSS_PATCH.get()).m_6509_(HAS_SILK_TOUCH)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.MOSS_AND_GRASS))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)TFBlocks.MOSS_PATCH.get()).m_6509_(HAS_SILK_TOUCH)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.MOSS))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)Items.f_42452_).m_6509_(HAS_SILK_TOUCH)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogHorizontal.VARIANT, (Comparable)HollowLogVariants.Horizontal.SNOW))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)Blocks.f_50191_).m_6509_(HAS_SILK_TOUCH)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.VINE))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(LootItem.m_79579_((ItemLike)Blocks.f_50155_).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.LADDER))))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(LootItem.m_79579_((ItemLike)Blocks.f_50155_).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(log).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67697_((Property)HollowLogClimbable.VARIANT, (Comparable)HollowLogVariants.Climbable.LADDER_WATERLOGGED)))));
    }
    
    private LootTable.Builder verticalHollowLog(final Block log) {
        final LootItemCondition.Builder HAS_SILK_TOUCH = (LootItemCondition.Builder)ObfuscationReflectionHelper.getPrivateValue((Class)BlockLoot.class, (Object)null, "f_124062_");
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_((LootPoolEntryContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.m_79579_((ItemLike)log.m_5456_()).m_6509_(HAS_SILK_TOUCH)).m_7170_((LootPoolEntryContainer.Builder)LootItem.m_79579_((ItemLike)Items.f_42398_).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_(2.0f, 4.0f))).m_5577_((LootItemFunction.Builder)ApplyBonusCount.m_79939_(Enchantments.f_44987_)))));
    }
    
    private static LootTable.Builder silkAndStick(final Block block, final ItemLike nonSilk, final float... nonSilkFortune) {
        final LootItemCondition.Builder NOT_SILK_TOUCH_OR_SHEARS = (LootItemCondition.Builder)ObfuscationReflectionHelper.getPrivateValue((Class)BlockLoot.class, (Object)null, "f_124066_");
        return m_124283_(block, ((LootPoolSingletonContainer.Builder)m_124134_((ItemLike)block, (ConditionUserBuilder)LootItem.m_79579_((ItemLike)nonSilk.m_5456_()))).m_6509_(BonusLevelTableCondition.m_81517_(Enchantments.f_44987_, nonSilkFortune))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_6509_(NOT_SILK_TOUCH_OR_SHEARS).m_79076_(((LootPoolSingletonContainer.Builder)m_124131_((ItemLike)block, (FunctionUserBuilder)LootItem.m_79579_((ItemLike)Items.f_42398_).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)UniformGenerator.m_165780_(1.0f, 2.0f))))).m_6509_(BonusLevelTableCondition.m_81517_(Enchantments.f_44987_, new float[] { 0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f }))));
    }
    
    private static LootTable.Builder casketInfo(final Block block) {
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_5577_((LootItemFunction.Builder)CopyBlockState.m_80062_(block).m_80084_((Property)KeepsakeCasketBlock.BREAKAGE)));
    }
    
    private static LootTable.Builder particleSpawner() {
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_((LootPoolEntryContainer.Builder)m_124131_((ItemLike)TFBlocks.FIREFLY_SPAWNER.get(), (FunctionUserBuilder)LootItem.m_79579_((ItemLike)TFBlocks.FIREFLY_SPAWNER.get())))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_((LootPoolEntryContainer.Builder)LootItem.m_79579_((ItemLike)TFBlocks.FIREFLY.get()).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 2)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(2.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 3)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(3.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 4)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(4.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 5)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(5.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 6)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(6.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 7)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(7.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 8)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(8.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 9)))).m_5577_((LootItemFunction.Builder)SetItemCountFunction.m_165412_((NumberProvider)ConstantValue.m_165692_(9.0f)).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_((Block)TFBlocks.FIREFLY_SPAWNER.get()).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67694_((Property)AbstractParticleSpawnerBlock.RADIUS, 10))))));
    }
    
    protected static LootTable.Builder torchberryPlant(final Block pBlock) {
        final LootItemCondition.Builder HAS_SHEARS = (LootItemCondition.Builder)ObfuscationReflectionHelper.getPrivateValue((Class)BlockLoot.class, (Object)null, "f_124064_");
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(LootItem.m_79579_((ItemLike)pBlock).m_6509_(HAS_SHEARS))).m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_79076_(LootItem.m_79579_((ItemLike)TFItems.TORCHBERRIES.get()).m_6509_((LootItemCondition.Builder)LootItemBlockStatePropertyCondition.m_81769_(pBlock).m_81784_(StatePropertiesPredicate.Builder.m_67693_().m_67703_((Property)TorchberryPlantBlock.HAS_BERRIES, true)))));
    }
    
    private static LootTable.Builder dropWithoutSilk(final Block block) {
        final LootItemCondition.Builder HAS_SILK_TOUCH = (LootItemCondition.Builder)ObfuscationReflectionHelper.getPrivateValue((Class)BlockLoot.class, (Object)null, "f_124062_");
        return LootTable.m_79147_().m_79161_(LootPool.m_79043_().m_165133_((NumberProvider)ConstantValue.m_165692_(1.0f)).m_6509_(HAS_SILK_TOUCH.m_81807_()).m_79076_((LootPoolEntryContainer.Builder)LootItem.m_79579_((ItemLike)block)));
    }
    
    private void registerEmpty(final Block b) {
        this.m_124165_(b, LootTable.m_79147_());
    }
    
    protected Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }
    
    static {
        DEFAULT_SAPLING_DROP_RATES = new float[] { 0.05f, 0.0625f, 0.083333336f, 0.1f };
        RARE_SAPLING_DROP_RATES = new float[] { 0.025f, 0.027777778f, 0.03125f, 0.041666668f, 0.1f };
    }
}
