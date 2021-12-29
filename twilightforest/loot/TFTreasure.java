// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.loot;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.TwilightForestMod;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.LootFunctionManager;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.entity.EntityTFYeti;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFWinterWolf;
import twilightforest.entity.EntityTFTroll;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFIceShooter;
import twilightforest.entity.EntityTFIceExploder;
import twilightforest.entity.boss.EntityTFIceCrystal;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFGiantMiner;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.entity.EntityTFBlockGoblin;
import java.util.function.Consumer;
import twilightforest.entity.passive.EntityTFBighorn;
import twilightforest.entity.passive.EntityTFBird;
import net.minecraft.world.storage.loot.LootTableList;
import twilightforest.entity.EntityTFArmoredGiant;
import net.minecraft.util.ResourceLocation;

public class TFTreasure
{
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
    public static final TFTreasure aurora_boss;
    public static final TFTreasure troll_garden;
    public static final TFTreasure troll_vault;
    public static final TFTreasure graveyard;
    private final ResourceLocation lootTable;
    
    public static void init() {
        LootTableList.func_186375_a(EntityTFArmoredGiant.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFBird.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFBighorn.SHEARED_LOOT_TABLE);
        EntityTFBighorn.COLORED_LOOT_TABLES.values().forEach(LootTableList::func_186375_a);
        LootTableList.func_186375_a(EntityTFBlockGoblin.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFBoar.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFBunny.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFDeathTome.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFDeathTome.HURT_LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFDeer.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFFireBeetle.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFGiantMiner.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFGoblinKnightUpper.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFHelmetCrab.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFHydra.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFIceCrystal.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFIceExploder.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFIceShooter.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFKobold.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFLich.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFMazeSlime.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFMiniGhast.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFMinoshroom.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFMinotaur.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFNaga.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFPenguin.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFQuestRam.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFQuestRam.REWARD_LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFRaven.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFRedcap.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFSkeletonDruid.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFSlimeBeetle.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFSnowGuardian.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFSnowQueen.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFSquirrel.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFTinyBird.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFTowerGolem.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFTowerTermite.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFTroll.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFWinterWolf.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFWraith.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFYeti.LOOT_TABLE);
        LootTableList.func_186375_a(EntityTFYetiAlpha.LOOT_TABLE);
        LootFunctionManager.func_186582_a((LootFunction.Serializer)new LootFunctionEnchant.Serializer());
        LootFunctionManager.func_186582_a((LootFunction.Serializer)new LootFunctionModItemSwap.Serializer());
        LootConditionManager.func_186639_a((LootCondition.Serializer)new LootConditionIsMinion.Serializer());
        LootConditionManager.func_186639_a((LootCondition.Serializer)new LootConditionModExists.Serializer());
    }
    
    private TFTreasure(final String path) {
        LootTableList.func_186375_a(this.lootTable = TwilightForestMod.prefix(String.format("structures/%s/%s", path, path)));
    }
    
    public void generateChest(final World world, final BlockPos pos, final boolean trapped) {
        world.func_180501_a(pos, trapped ? Blocks.field_150447_bR.func_176223_P() : Blocks.field_150486_ae.func_176223_P(), 2);
        final TileEntity te = world.func_175625_s(pos);
        if (te instanceof TileEntityChest) {
            ((TileEntityChest)te).func_189404_a(this.lootTable, world.func_72905_C() * pos.func_177958_n() + pos.func_177956_o() ^ (long)pos.func_177952_p());
        }
    }
    
    public void generateChestContents(final World world, final BlockPos pos) {
        final TileEntity te = world.func_175625_s(pos);
        if (te instanceof TileEntityChest) {
            ((TileEntityChest)te).func_189404_a(this.lootTable, world.func_72905_C() * pos.func_177958_n() + pos.func_177956_o() ^ (long)pos.func_177952_p());
        }
    }
    
    static {
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
        aurora_boss = new TFTreasure("aurora_boss");
        troll_garden = new TFTreasure("troll_garden");
        troll_vault = new TFTreasure("troll_vault");
        graveyard = new TFTreasure("graveyard");
    }
}
