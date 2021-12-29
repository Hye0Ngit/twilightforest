// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import com.google.common.collect.Sets;
import net.minecraft.util.registry.Registry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ISeedReader;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import twilightforest.loot.conditions.ModExists;
import twilightforest.loot.conditions.IsMinion;
import twilightforest.loot.functions.ModItemSwap;
import net.minecraft.loot.ILootSerializer;
import twilightforest.loot.functions.Enchant;
import twilightforest.TwilightForestMod;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.util.ResourceLocation;
import java.util.Set;

public class TFTreasure
{
    private static final Set<ResourceLocation> TF_LOOT_TABLES;
    public static final TFTreasure hill1;
    public static final TFTreasure hill2;
    public static final TFTreasure hill3;
    public static final TFTreasure hedgemaze;
    public static final TFTreasure labyrinth_room;
    public static final TFTreasure labyrinth_deadend;
    public static final TFTreasure tower_room;
    public static final TFTreasure tower_library;
    public static final TFTreasure basement;
    public static final TFTreasure labyrinth_vault;
    public static final TFTreasure darktower_cache;
    public static final TFTreasure darktower_key;
    public static final TFTreasure darktower_boss;
    public static final TFTreasure tree_cache;
    public static final TFTreasure stronghold_cache;
    public static final TFTreasure stronghold_room;
    public static final TFTreasure stronghold_boss;
    public static final TFTreasure aurora_cache;
    public static final TFTreasure aurora_room;
    public static final TFTreasure troll_garden;
    public static final TFTreasure troll_vault;
    public static final TFTreasure graveyard;
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
    public static final ResourceLocation USELESS_LOOT;
    public static final ResourceLocation ALL_BOSSES;
    public static LootFunctionType ENCHANT;
    public static LootFunctionType ITEM_OR_DEFAULT;
    public static LootConditionType IS_MINION;
    public static LootConditionType MOD_EXISTS;
    public final ResourceLocation lootTable;
    
    private TFTreasure(final String path) {
        this.lootTable = TwilightForestMod.prefix(String.format("structures/%s", path));
    }
    
    public static void init() {
        TFTreasure.ENCHANT = registerFunction("enchant", new LootFunctionType((ILootSerializer)new Enchant.Serializer()));
        TFTreasure.ITEM_OR_DEFAULT = registerFunction("item_or_default", new LootFunctionType((ILootSerializer)new ModItemSwap.Serializer()));
        TFTreasure.IS_MINION = registerCondition("is_minion", new LootConditionType((ILootSerializer)new IsMinion.Serializer()));
        TFTreasure.MOD_EXISTS = registerCondition("mod_exists", new LootConditionType((ILootSerializer)new ModExists.Serializer()));
    }
    
    public void generateChest(final IWorld world, final BlockPos pos, final Direction dir, final boolean trapped) {
        world.func_180501_a(pos, (BlockState)(trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae).func_176223_P().func_206870_a((Property)ChestBlock.field_176459_a, (Comparable)dir), 2);
        final TileEntity te = world.func_175625_s(pos);
        if (te instanceof ChestTileEntity) {
            ((ChestTileEntity)te).func_189404_a(this.lootTable, ((ISeedReader)world).func_72905_C() * pos.func_177958_n() + pos.func_177956_o() ^ (long)pos.func_177952_p());
        }
    }
    
    public void generateChestContents(final ISeedReader world, final BlockPos pos) {
        final TileEntity te = world.func_175625_s(pos);
        if (te instanceof ChestTileEntity) {
            ((ChestTileEntity)te).func_189404_a(this.lootTable, world.func_72905_C() * pos.func_177958_n() + pos.func_177956_o() ^ (long)pos.func_177952_p());
        }
    }
    
    private static LootFunctionType registerFunction(final String name, final LootFunctionType function) {
        return (LootFunctionType)Registry.func_218322_a(Registry.field_239694_aZ_, TwilightForestMod.prefix(name), (Object)function);
    }
    
    private static LootConditionType registerCondition(final String name, final LootConditionType condition) {
        return (LootConditionType)Registry.func_218322_a(Registry.field_239704_ba_, TwilightForestMod.prefix(name), (Object)condition);
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
    
    static {
        TF_LOOT_TABLES = Sets.newHashSet();
        hill1 = new TFTreasure("hill_1");
        hill2 = new TFTreasure("hill_2");
        hill3 = new TFTreasure("hill_3");
        hedgemaze = new TFTreasure("hedge_maze");
        labyrinth_room = new TFTreasure("labyrinth_room");
        labyrinth_deadend = new TFTreasure("labyrinth_dead_end");
        tower_room = new TFTreasure("tower_room");
        tower_library = new TFTreasure("tower_library");
        basement = new TFTreasure("basement");
        labyrinth_vault = new TFTreasure("labyrinth_vault");
        darktower_cache = new TFTreasure("darktower_cache");
        darktower_key = new TFTreasure("darktower_key");
        darktower_boss = new TFTreasure("darktower_boss");
        tree_cache = new TFTreasure("tree_cache");
        stronghold_cache = new TFTreasure("stronghold_cache");
        stronghold_room = new TFTreasure("stronghold_room");
        stronghold_boss = new TFTreasure("stronghold_boss");
        aurora_cache = new TFTreasure("aurora_cache");
        aurora_room = new TFTreasure("aurora_room");
        troll_garden = new TFTreasure("troll_garden");
        troll_vault = new TFTreasure("troll_vault");
        graveyard = new TFTreasure("graveyard");
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
        USELESS_LOOT = register("structures/useless");
        ALL_BOSSES = register("entities/all_bosses");
    }
}
