import forge.EnumHelper;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFItems
{
    public static dq ARMOR_NAGA;
    public static id nagaScale;
    public static id plateNaga;
    public static id legsNaga;
    public static id scepterTwilight;
    public static id scepterLifeDrain;
    public static id scepterZombie;
    public static id wandPacification;
    public static id oreMeter;
    public static id magicMap;
    public static id mazeMap;
    public static id oreMap;
    public static id feather;
    public static id magicMapFocus;
    public static id mazeMapFocus;
    
    public TFItems() {
        TFItems.nagaScale = new ItemTF(mod_TwilightForest.idItemNagaScale).d(0).a("nagaScale").b("+4+0+13");
        TFItems.plateNaga = new ItemTFNagaArmor(mod_TwilightForest.idItemPlateNaga, TFItems.ARMOR_NAGA, 5, 1).d(17).a("plateNaga").e(1);
        TFItems.legsNaga = new ItemTFNagaArmor(mod_TwilightForest.idItemLegsNaga, TFItems.ARMOR_NAGA, 5, 2).d(33).a("legsNaga").e(1);
        TFItems.scepterTwilight = new ItemTFTwilightWand(mod_TwilightForest.idItemScepterTwilight).d(3).a("scepterTwilight").e(1).h();
        TFItems.scepterLifeDrain = new ItemTFLifeDrainWand(mod_TwilightForest.idItemScepterLifeDrain).d(4).a("scepterLifeDrain").e(1).h();
        TFItems.scepterZombie = new ItemTFZombieWand(mod_TwilightForest.idItemScepterZombie).d(5).a("scepterZombie").e(1).h();
        TFItems.wandPacification = new ItemTF(mod_TwilightForest.idItemWandPacification).d(6).a("wandPacification").e(1).h();
        TFItems.oreMeter = new ItemTFOreMeter(mod_TwilightForest.idItemOreMeter).d(7).a("oreMeter").e(1);
        TFItems.magicMap = new ItemTFMagicMap(mod_TwilightForest.idItemMagicMap).d(8).a("magicMap").e(1);
        TFItems.mazeMap = new ItemTFMazeMap(mod_TwilightForest.idItemMazeMap, false).d(10).a("mazeMap").e(1);
        TFItems.oreMap = new ItemTFMazeMap(mod_TwilightForest.idItemOreMap, true).d(11).a("oreMap").e(1);
        TFItems.feather = new ItemTF(mod_TwilightForest.idItemFeather).d(12).a("feather");
        TFItems.magicMapFocus = new ItemTF(mod_TwilightForest.idItemMagicMapFocus).d(13).a("magicMapFocus");
        TFItems.mazeMapFocus = new ItemTF(mod_TwilightForest.idItemMazeMapFocus).d(14).a("mazeMapFocus");
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
    }
    
    static {
        TFItems.ARMOR_NAGA = EnumHelper.addArmorMaterial("NAGA_SCALE", 21, new int[] { 2, 7, 5, 3 }, 15);
    }
}
