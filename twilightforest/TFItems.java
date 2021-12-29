// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.EnumHelper;
import forge.MinecraftForgeClient;

public class TFItems
{
    public static cg ARMOR_NAGA;
    public static cg ARMOR_IRONWOOD;
    public static uk TOOL_IRONWOOD;
    public static yr nagaScale;
    public static yr plateNaga;
    public static yr legsNaga;
    public static yr scepterTwilight;
    public static yr scepterLifeDrain;
    public static yr scepterZombie;
    public static yr wandPacification;
    public static yr oreMeter;
    public static yr magicMap;
    public static yr mazeMap;
    public static yr oreMap;
    public static yr feather;
    public static yr magicMapFocus;
    public static yr mazeMapFocus;
    public static yr liveRoot;
    public static yr ironwoodRaw;
    public static yr ironwoodIngot;
    public static yr ironwoodHelm;
    public static yr ironwoodPlate;
    public static yr ironwoodLegs;
    public static yr ironwoodBoots;
    public static yr ironwoodSword;
    public static yr ironwoodShovel;
    public static yr ironwoodPick;
    public static yr ironwoodAxe;
    public static yr ironwoodHoe;
    public static yr torchberries;
    
    public TFItems() {
        MinecraftForgeClient.preloadTexture("/twilightforest/items.png");
        TFItems.nagaScale = new ItemTF(mod_TwilightForest.idItemNagaScale).e(0).a("nagaScale");
        TFItems.plateNaga = new ItemTFNagaArmor(mod_TwilightForest.idItemPlateNaga, TFItems.ARMOR_NAGA, 7777, 1).e(16).a("plateNaga").f(1);
        TFItems.legsNaga = new ItemTFNagaArmor(mod_TwilightForest.idItemLegsNaga, TFItems.ARMOR_NAGA, 7777, 2).e(32).a("legsNaga").f(1);
        TFItems.scepterTwilight = new ItemTFTwilightWand(mod_TwilightForest.idItemScepterTwilight).e(3).a("scepterTwilight").f(1).j();
        TFItems.scepterLifeDrain = new ItemTFLifeDrainWand(mod_TwilightForest.idItemScepterLifeDrain).e(4).a("scepterLifeDrain").f(1).j();
        TFItems.scepterZombie = new ItemTFZombieWand(mod_TwilightForest.idItemScepterZombie).e(5).a("scepterZombie").f(1).j();
        TFItems.wandPacification = new ItemTF(mod_TwilightForest.idItemWandPacification).e(6).a("wandPacification").f(1).j();
        TFItems.oreMeter = new ItemTFOreMeter(mod_TwilightForest.idItemOreMeter).e(7).a("oreMeter").f(1);
        TFItems.magicMap = new ItemTFMagicMap(mod_TwilightForest.idItemMagicMap).e(8).a("magicMap").f(1);
        TFItems.mazeMap = new ItemTFMazeMap(mod_TwilightForest.idItemMazeMap, false).e(10).a("mazeMap").f(1);
        TFItems.oreMap = new ItemTFMazeMap(mod_TwilightForest.idItemOreMap, true).e(11).a("oreMap").f(1);
        TFItems.feather = new ItemTF(mod_TwilightForest.idItemFeather).e(12).a("tfFeather");
        TFItems.magicMapFocus = new ItemTF(mod_TwilightForest.idItemMagicMapFocus).e(13).a("magicMapFocus");
        TFItems.mazeMapFocus = new ItemTF(mod_TwilightForest.idItemMazeMapFocus).e(14).a("mazeMapFocus");
        TFItems.liveRoot = new ItemTF(mod_TwilightForest.idItemLiveRoot).e(1).a("liveRoot");
        TFItems.ironwoodRaw = new ItemTF(mod_TwilightForest.idItemIronwoodRaw).e(17).a("ironwoodRaw");
        TFItems.ironwoodIngot = new ItemTF(mod_TwilightForest.idItemIronwoodIngot).e(33).a("ironwoodIngot");
        TFItems.ironwoodHelm = new ItemTFIronwoodArmor(mod_TwilightForest.idItemIronwoodHelm, TFItems.ARMOR_IRONWOOD, 7778, 0).e(49).a("ironwoodHelm").f(1);
        TFItems.ironwoodPlate = new ItemTFIronwoodArmor(mod_TwilightForest.idItemIronwoodPlate, TFItems.ARMOR_IRONWOOD, 7778, 1).e(65).a("ironwoodPlate").f(1);
        TFItems.ironwoodLegs = new ItemTFIronwoodArmor(mod_TwilightForest.idItemIronwoodLegs, TFItems.ARMOR_IRONWOOD, 7778, 2).e(81).a("ironwoodLegs").f(1);
        TFItems.ironwoodBoots = new ItemTFIronwoodArmor(mod_TwilightForest.idItemIronwoodBoots, TFItems.ARMOR_IRONWOOD, 7778, 3).e(97).a("ironwoodBoots").f(1);
        TFItems.ironwoodSword = new ItemTFIronwoodSword(mod_TwilightForest.idItemIronwoodSword, TFItems.TOOL_IRONWOOD).e(113).a("ironwoodSword").f(1);
        TFItems.ironwoodShovel = new ItemTFIronwoodShovel(mod_TwilightForest.idItemIronwoodShovel, TFItems.TOOL_IRONWOOD).e(129).a("ironwoodShovel").f(1);
        TFItems.ironwoodPick = new ItemTFIronwoodPick(mod_TwilightForest.idItemIronwoodPick, TFItems.TOOL_IRONWOOD).e(145).a("ironwoodPick").f(1);
        TFItems.ironwoodAxe = new ItemTFIronwoodAxe(mod_TwilightForest.idItemIronwoodAxe, TFItems.TOOL_IRONWOOD).e(161).a("ironwoodAxe").f(1);
        TFItems.ironwoodHoe = new ItemTFIronwoodHoe(mod_TwilightForest.idItemIronwoodHoe, TFItems.TOOL_IRONWOOD).e(177).a("ironwoodHoe").f(1);
        TFItems.torchberries = new ItemTF(mod_TwilightForest.idItemTorchberries).e(19).a("torchberries");
        ModLoader.addName((Object)TFItems.nagaScale, "Naga Scale");
        ModLoader.addName((Object)TFItems.plateNaga, "Naga Scale Tunic");
        ModLoader.addName((Object)TFItems.legsNaga, "Naga Scale Leggings");
        ModLoader.addName((Object)TFItems.scepterTwilight, "Scepter of Twilight");
        ModLoader.addName((Object)TFItems.scepterLifeDrain, "Scepter of Life Draining");
        ModLoader.addName((Object)TFItems.scepterZombie, "Zombie Scepter");
        ModLoader.addName((Object)TFItems.wandPacification, "Wand of Pacification [NYI]");
        ModLoader.addName((Object)TFItems.oreMeter, "Ore Meter [WIP]");
        ModLoader.addName((Object)TFItems.magicMap, "Magic Map");
        ModLoader.addName((Object)TFItems.mazeMap, "Maze Map");
        ModLoader.addName((Object)TFItems.oreMap, "Maze/Ore Map");
        ModLoader.addName((Object)TFItems.feather, "Raven's Feather");
        ModLoader.addName((Object)TFItems.magicMapFocus, "Magic Map Focus");
        ModLoader.addName((Object)TFItems.mazeMapFocus, "Maze Map Focus");
        ModLoader.addName((Object)TFItems.liveRoot, "Liveroot");
        ModLoader.addName((Object)TFItems.ironwoodRaw, "Raw Ironwood Materials");
        ModLoader.addName((Object)TFItems.ironwoodIngot, "Ironwood Ingot");
        ModLoader.addName((Object)TFItems.ironwoodHelm, "Ironwood Helm");
        ModLoader.addName((Object)TFItems.ironwoodPlate, "Ironwood Plate");
        ModLoader.addName((Object)TFItems.ironwoodLegs, "Ironwood Legs");
        ModLoader.addName((Object)TFItems.ironwoodBoots, "Ironwood Boots");
        ModLoader.addName((Object)TFItems.ironwoodSword, "Ironwood Sword");
        ModLoader.addName((Object)TFItems.ironwoodShovel, "Ironwood Shovel");
        ModLoader.addName((Object)TFItems.ironwoodPick, "Ironwood Pick");
        ModLoader.addName((Object)TFItems.ironwoodAxe, "Ironwood Axe");
        ModLoader.addName((Object)TFItems.ironwoodHoe, "Ironwood Hoe");
        ModLoader.addName((Object)TFItems.torchberries, "Torchberries");
    }
    
    static {
        TFItems.ARMOR_NAGA = EnumHelper.addArmorMaterial("NAGA_SCALE", 21, new int[] { 2, 7, 6, 3 }, 15);
        TFItems.ARMOR_IRONWOOD = EnumHelper.addArmorMaterial("IRONWOOD", 20, new int[] { 2, 7, 5, 2 }, 15);
        TFItems.TOOL_IRONWOOD = EnumHelper.addToolMaterial("IRONWOOD", 2, 512, 6.5f, 2, 25);
    }
}
