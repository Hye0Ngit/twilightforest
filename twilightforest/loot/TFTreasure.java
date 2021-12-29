// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import com.google.common.collect.Sets;
import net.minecraft.world.level.Level;
import net.minecraft.world.Container;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.loot.conditions.ModExists;
import twilightforest.loot.conditions.IsMinion;
import twilightforest.loot.functions.ModItemSwap;
import net.minecraft.world.level.storage.loot.Serializer;
import twilightforest.loot.functions.Enchant;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.resources.ResourceLocation;
import java.util.Set;

public class TFTreasure
{
    private static final Set<ResourceLocation> TF_LOOT_TABLES;
    private static final int DEFAULT_PLACE_FLAG = 2;
    public static final TFTreasure SMALL_HOLLOW_HILL;
    public static final TFTreasure MEDIUM_HOLLOW_HILL;
    public static final TFTreasure LARGE_HOLLOW_HILL;
    public static final TFTreasure HEDGE_MAZE;
    public static final TFTreasure FANCY_WELL;
    public static final TFTreasure WELL;
    public static final TFTreasure LABYRINTH_ROOM;
    public static final TFTreasure LABYRINTH_DEAD_END;
    public static final TFTreasure TOWER_ROOM;
    public static final TFTreasure TOWER_LIBRARY;
    public static final TFTreasure BASEMENT;
    public static final TFTreasure FOUNDATION_BASEMENT;
    public static final TFTreasure LABYRINTH_VAULT;
    public static final TFTreasure DARKTOWER_CACHE;
    public static final TFTreasure DARKTOWER_KEY;
    public static final TFTreasure DARKTOWER_BOSS;
    public static final TFTreasure TREE_CACHE;
    public static final TFTreasure STRONGHOLD_CACHE;
    public static final TFTreasure STRONGHOLD_ROOM;
    public static final TFTreasure STRONGHOLD_BOSS;
    public static final TFTreasure AURORA_CACHE;
    public static final TFTreasure AURORA_ROOM;
    public static final TFTreasure TROLL_GARDEN;
    public static final TFTreasure TROLL_VAULT;
    public static final TFTreasure GRAVEYARD;
    public static final TFTreasure QUEST_GROVE;
    public static final TFTreasure USELESS_LOOT;
    public static final ResourceLocation BIGHORN_SHEEP_WHITE;
    public static final ResourceLocation BIGHORN_SHEEP_ORANGE;
    public static final ResourceLocation BIGHORN_SHEEP_MAGENTA;
    public static final ResourceLocation BIGHORN_SHEEP_LIGHT_BLUE;
    public static final ResourceLocation BIGHORN_SHEEP_YELLOW;
    public static final ResourceLocation BIGHORN_SHEEP_LIME;
    public static final ResourceLocation BIGHORN_SHEEP_PINK;
    public static final ResourceLocation BIGHORN_SHEEP_GRAY;
    public static final ResourceLocation BIGHORN_SHEEP_LIGHT_GRAY;
    public static final ResourceLocation BIGHORN_SHEEP_CYAN;
    public static final ResourceLocation BIGHORN_SHEEP_PURPLE;
    public static final ResourceLocation BIGHORN_SHEEP_BLUE;
    public static final ResourceLocation BIGHORN_SHEEP_BROWN;
    public static final ResourceLocation BIGHORN_SHEEP_GREEN;
    public static final ResourceLocation BIGHORN_SHEEP_RED;
    public static final ResourceLocation BIGHORN_SHEEP_BLACK;
    public static final ResourceLocation QUESTING_RAM_REWARDS;
    public static final ResourceLocation DEATH_TOME_HURT;
    public static final ResourceLocation DEATH_TOME_BOOKS;
    public static final ResourceLocation ALL_BOSSES;
    public static LootItemFunctionType ENCHANT;
    public static LootItemFunctionType ITEM_OR_DEFAULT;
    public static LootItemConditionType IS_MINION;
    public static LootItemConditionType MOD_EXISTS;
    public final ResourceLocation lootTable;
    
    private TFTreasure(final String path) {
        this.lootTable = TwilightForestMod.prefix(String.format("structures/%s", path));
    }
    
    public static void init() {
        TFTreasure.ENCHANT = registerFunction("enchant", new LootItemFunctionType((Serializer)new Enchant.Serializer()));
        TFTreasure.ITEM_OR_DEFAULT = registerFunction("item_or_default", new LootItemFunctionType((Serializer)new ModItemSwap.Serializer()));
        TFTreasure.IS_MINION = registerCondition("is_minion", new LootItemConditionType((Serializer)new IsMinion.ConditionSerializer()));
        TFTreasure.MOD_EXISTS = registerCondition("mod_exists", new LootItemConditionType((Serializer)new ModExists.ConditionSerializer()));
    }
    
    public void generateChest(final WorldGenLevel world, final BlockPos pos, final Direction dir, final boolean trapped) {
        this.generateLootContainer(world, pos, (BlockState)(trapped ? Blocks.f_50325_ : Blocks.f_50087_).m_49966_().m_61124_((Property)ChestBlock.f_51478_, (Comparable)dir), 2);
    }
    
    public void generateLootContainer(final WorldGenLevel world, final BlockPos pos, final BlockState state, final int flags) {
        world.m_7731_(pos, state, flags);
        this.generateChestContents(world, pos);
    }
    
    public void generateLootContainer(final LevelAccessor world, final BlockPos pos, final BlockState state, final int flags, final long seed) {
        world.m_7731_(pos, state, flags);
        this.generateChestContents(world, pos, seed);
    }
    
    public void generateChestContents(final WorldGenLevel world, final BlockPos pos) {
        this.generateChestContents((LevelAccessor)world, pos, world.m_7328_() * pos.m_123341_() + pos.m_123342_() ^ (long)pos.m_123343_());
    }
    
    public void generateChestContents(final LevelAccessor world, final BlockPos pos, final long seed) {
        final BlockEntity 7702_ = world.m_7702_(pos);
        if (7702_ instanceof final RandomizableContainerBlockEntity lootContainer) {
            lootContainer.m_59626_(this.lootTable, seed);
        }
    }
    
    private static LootItemFunctionType registerFunction(final String name, final LootItemFunctionType function) {
        return (LootItemFunctionType)Registry.m_122965_(Registry.f_122876_, TwilightForestMod.prefix(name), (Object)function);
    }
    
    private static LootItemConditionType registerCondition(final String name, final LootItemConditionType condition) {
        return (LootItemConditionType)Registry.m_122965_(Registry.f_122877_, TwilightForestMod.prefix(name), (Object)condition);
    }
    
    private static ResourceLocation register(final String id) {
        return register(TwilightForestMod.prefix(id));
    }
    
    private static ResourceLocation register(final ResourceLocation id) {
        if (TFTreasure.TF_LOOT_TABLES.add(id)) {
            return id;
        }
        throw new IllegalArgumentException(id + " is already a registered built-in loot table");
    }
    
    public static void entityDropsIntoContainer(final LivingEntity entity, final LootContext lootContext, final BlockState blockContaining, final BlockPos placement) {
        final Level f_19853_ = entity.f_19853_;
        if (f_19853_ instanceof final ServerLevel serverLevel) {
            if (serverLevel.m_7731_(placement, blockContaining, 2)) {
                final BlockEntity 7702_ = serverLevel.m_7702_(placement);
                if (7702_ instanceof final Container container) {
                    serverLevel.m_142572_().getServerResources().m_136172_().m_79217_(entity.m_5743_()).m_79123_(container, lootContext);
                }
            }
        }
    }
    
    static {
        TF_LOOT_TABLES = Sets.newHashSet();
        SMALL_HOLLOW_HILL = new TFTreasure("hill_1");
        MEDIUM_HOLLOW_HILL = new TFTreasure("hill_2");
        LARGE_HOLLOW_HILL = new TFTreasure("hill_3");
        HEDGE_MAZE = new TFTreasure("hedge_maze");
        FANCY_WELL = new TFTreasure("fancy_well");
        WELL = new TFTreasure("well");
        LABYRINTH_ROOM = new TFTreasure("labyrinth_room");
        LABYRINTH_DEAD_END = new TFTreasure("labyrinth_dead_end");
        TOWER_ROOM = new TFTreasure("tower_room");
        TOWER_LIBRARY = new TFTreasure("tower_library");
        BASEMENT = new TFTreasure("basement");
        FOUNDATION_BASEMENT = new TFTreasure("foundation_basement");
        LABYRINTH_VAULT = new TFTreasure("labyrinth_vault");
        DARKTOWER_CACHE = new TFTreasure("darktower_cache");
        DARKTOWER_KEY = new TFTreasure("darktower_key");
        DARKTOWER_BOSS = new TFTreasure("darktower_boss");
        TREE_CACHE = new TFTreasure("tree_cache");
        STRONGHOLD_CACHE = new TFTreasure("stronghold_cache");
        STRONGHOLD_ROOM = new TFTreasure("stronghold_room");
        STRONGHOLD_BOSS = new TFTreasure("stronghold_boss");
        AURORA_CACHE = new TFTreasure("aurora_cache");
        AURORA_ROOM = new TFTreasure("aurora_room");
        TROLL_GARDEN = new TFTreasure("troll_garden");
        TROLL_VAULT = new TFTreasure("troll_vault");
        GRAVEYARD = new TFTreasure("graveyard");
        QUEST_GROVE = new TFTreasure("quest_grove_dropper");
        USELESS_LOOT = new TFTreasure("useless");
        BIGHORN_SHEEP_WHITE = register("entities/bighorn_sheep/white");
        BIGHORN_SHEEP_ORANGE = register("entities/bighorn_sheep/orange");
        BIGHORN_SHEEP_MAGENTA = register("entities/bighorn_sheep/magenta");
        BIGHORN_SHEEP_LIGHT_BLUE = register("entities/bighorn_sheep/light_blue");
        BIGHORN_SHEEP_YELLOW = register("entities/bighorn_sheep/yellow");
        BIGHORN_SHEEP_LIME = register("entities/bighorn_sheep/lime");
        BIGHORN_SHEEP_PINK = register("entities/bighorn_sheep/pink");
        BIGHORN_SHEEP_GRAY = register("entities/bighorn_sheep/gray");
        BIGHORN_SHEEP_LIGHT_GRAY = register("entities/bighorn_sheep/light_gray");
        BIGHORN_SHEEP_CYAN = register("entities/bighorn_sheep/cyan");
        BIGHORN_SHEEP_PURPLE = register("entities/bighorn_sheep/purple");
        BIGHORN_SHEEP_BLUE = register("entities/bighorn_sheep/blue");
        BIGHORN_SHEEP_BROWN = register("entities/bighorn_sheep/brown");
        BIGHORN_SHEEP_GREEN = register("entities/bighorn_sheep/green");
        BIGHORN_SHEEP_RED = register("entities/bighorn_sheep/red");
        BIGHORN_SHEEP_BLACK = register("entities/bighorn_sheep/black");
        QUESTING_RAM_REWARDS = register("entities/questing_ram_rewards");
        DEATH_TOME_HURT = register("entities/death_tome_hurt");
        DEATH_TOME_BOOKS = register("entities/death_tome_books");
        ALL_BOSSES = register("entities/all_bosses");
    }
}
