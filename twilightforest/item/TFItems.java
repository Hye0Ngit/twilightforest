// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import twilightforest.TwilightForestMod;

public class TFItems
{
    public static sv ARMOR_NAGA;
    public static sv ARMOR_IRONWOOD;
    public static sv ARMOR_FIERY;
    public static sv ARMOR_STEELEAF;
    public static uq TOOL_IRONWOOD;
    public static uq TOOL_FIERY;
    public static uq TOOL_STEELEAF;
    public static up nagaScale;
    public static up plateNaga;
    public static up legsNaga;
    public static up scepterTwilight;
    public static up scepterLifeDrain;
    public static up scepterZombie;
    public static up wandPacification;
    public static up oreMeter;
    public static up magicMap;
    public static up mazeMap;
    public static up oreMap;
    public static up feather;
    public static up magicMapFocus;
    public static up mazeMapFocus;
    public static up liveRoot;
    public static up ironwoodRaw;
    public static up ironwoodIngot;
    public static up ironwoodHelm;
    public static up ironwoodPlate;
    public static up ironwoodLegs;
    public static up ironwoodBoots;
    public static up ironwoodSword;
    public static up ironwoodShovel;
    public static up ironwoodPick;
    public static up ironwoodAxe;
    public static up ironwoodHoe;
    public static up torchberries;
    public static up spawnEgg;
    public static up venisonRaw;
    public static up venisonCooked;
    public static up hydraChop;
    public static up fieryBlood;
    public static up hydraTrophy;
    public static up fieryIngot;
    public static up fieryHelm;
    public static up fieryPlate;
    public static up fieryLegs;
    public static up fieryBoots;
    public static up fierySword;
    public static up fieryPick;
    public static up steeleafIngot;
    public static up steeleafHelm;
    public static up steeleafPlate;
    public static up steeleafLegs;
    public static up steeleafBoots;
    public static up steeleafSword;
    public static up steeleafShovel;
    public static up steeleafPick;
    public static up steeleafAxe;
    public static up steeleafHoe;
    public static up minotaurAxe;
    public static up mazebreakerPick;
    public static up transformPowder;
    public static up meefRaw;
    public static up meefSteak;
    public static up meefStroganoff;
    public static up mazeWafer;
    public static up emptyMagicMap;
    public static up emptyMazeMap;
    public static up emptyOreMap;
    public static up oreMagnet;
    public static up crumbleHorn;
    public static up peacockFan;
    public static up moonwormQueen;
    public static up charmOfLife1;
    public static up charmOfLife2;
    public static up charmOfKeeping1;
    public static up charmOfKeeping2;
    public static up charmOfKeeping3;
    public static CreativeTabTwilightForest creativeTab;
    
    public TFItems() {
        final int nagaScaleRenderID = TwilightForestMod.proxy.registerArmorRenderID("twilightforest/nagascale_");
        final int ironwoodRenderID = TwilightForestMod.proxy.registerArmorRenderID("twilightforest/ironwood_");
        final int fieryRenderID = TwilightForestMod.proxy.registerArmorRenderID("twilightforest/fiery_");
        final int steeleafRenderID = TwilightForestMod.proxy.registerArmorRenderID("twilightforest/steeleaf_");
        TFItems.nagaScale = new ItemTF(TwilightForestMod.idItemNagaScale).c(0).b("nagaScale");
        TFItems.plateNaga = new ItemTFNagaArmor(TwilightForestMod.idItemPlateNaga, TFItems.ARMOR_NAGA, nagaScaleRenderID, 1).c(16).b("plateNaga").d(1);
        TFItems.legsNaga = new ItemTFNagaArmor(TwilightForestMod.idItemLegsNaga, TFItems.ARMOR_NAGA, nagaScaleRenderID, 2).c(32).b("legsNaga").d(1);
        TFItems.scepterTwilight = new ItemTFTwilightWand(TwilightForestMod.idItemScepterTwilight).c(3).b("scepterTwilight").d(1).o();
        TFItems.scepterLifeDrain = new ItemTFLifeDrainWand(TwilightForestMod.idItemScepterLifeDrain).c(4).b("scepterLifeDrain").d(1).o();
        TFItems.scepterZombie = new ItemTFZombieWand(TwilightForestMod.idItemScepterZombie).c(5).b("scepterZombie").d(1).o();
        TFItems.oreMeter = new ItemTFOreMeter(TwilightForestMod.idItemOreMeter).c(7).b("oreMeter").d(1);
        TFItems.magicMap = new ItemTFMagicMap(TwilightForestMod.idItemMagicMap).c(8).b("magicMap").d(1);
        TFItems.mazeMap = new ItemTFMazeMap(TwilightForestMod.idItemMazeMap, false).c(10).b("mazeMap").d(1);
        TFItems.oreMap = new ItemTFMazeMap(TwilightForestMod.idItemOreMap, true).c(11).b("oreMap").d(1);
        TFItems.feather = new ItemTF(TwilightForestMod.idItemFeather).c(12).b("tfFeather");
        TFItems.magicMapFocus = new ItemTF(TwilightForestMod.idItemMagicMapFocus).c(13).b("magicMapFocus");
        TFItems.mazeMapFocus = new ItemTF(TwilightForestMod.idItemMazeMapFocus).c(14).b("mazeMapFocus");
        TFItems.liveRoot = new ItemTF(TwilightForestMod.idItemLiveRoot).c(1).b("liveRoot");
        TFItems.ironwoodRaw = new ItemTF(TwilightForestMod.idItemIronwoodRaw).c(17).b("ironwoodRaw");
        TFItems.ironwoodIngot = new ItemTF(TwilightForestMod.idItemIronwoodIngot).c(33).b("ironwoodIngot");
        TFItems.ironwoodHelm = new ItemTFIronwoodArmor(TwilightForestMod.idItemIronwoodHelm, TFItems.ARMOR_IRONWOOD, ironwoodRenderID, 0).c(49).b("ironwoodHelm").d(1);
        TFItems.ironwoodPlate = new ItemTFIronwoodArmor(TwilightForestMod.idItemIronwoodPlate, TFItems.ARMOR_IRONWOOD, ironwoodRenderID, 1).c(65).b("ironwoodPlate").d(1);
        TFItems.ironwoodLegs = new ItemTFIronwoodArmor(TwilightForestMod.idItemIronwoodLegs, TFItems.ARMOR_IRONWOOD, ironwoodRenderID, 2).c(81).b("ironwoodLegs").d(1);
        TFItems.ironwoodBoots = new ItemTFIronwoodArmor(TwilightForestMod.idItemIronwoodBoots, TFItems.ARMOR_IRONWOOD, ironwoodRenderID, 3).c(97).b("ironwoodBoots").d(1);
        TFItems.ironwoodSword = new ItemTFIronwoodSword(TwilightForestMod.idItemIronwoodSword, TFItems.TOOL_IRONWOOD).c(113).b("ironwoodSword").d(1);
        TFItems.ironwoodShovel = new ItemTFIronwoodShovel(TwilightForestMod.idItemIronwoodShovel, TFItems.TOOL_IRONWOOD).c(129).b("ironwoodShovel").d(1);
        TFItems.ironwoodPick = new ItemTFIronwoodPick(TwilightForestMod.idItemIronwoodPick, TFItems.TOOL_IRONWOOD).c(145).b("ironwoodPick").d(1);
        TFItems.ironwoodAxe = new ItemTFIronwoodAxe(TwilightForestMod.idItemIronwoodAxe, TFItems.TOOL_IRONWOOD).c(161).b("ironwoodAxe").d(1);
        TFItems.ironwoodHoe = new ItemTFIronwoodHoe(TwilightForestMod.idItemIronwoodHoe, TFItems.TOOL_IRONWOOD).c(177).b("ironwoodHoe").d(1);
        TFItems.torchberries = new ItemTF(TwilightForestMod.idItemTorchberries).c(19).b("torchberries");
        TFItems.spawnEgg = new ItemTFSpawnEgg(TwilightForestMod.idItemSpawnEgg).b(9, 9).b("tfspawnegg");
        TFItems.venisonRaw = new uk(TwilightForestMod.idItemVenisonRaw, 3, 0.3f, true).b(9, 6).b("venisonRaw");
        TFItems.venisonCooked = new uk(TwilightForestMod.idItemVenisonCooked, 8, 0.8f, true).b(10, 6).b("venisonCooked");
        TFItems.hydraChop = new uk(TwilightForestMod.idItemHydraChops, 18, 2.0f, true).a(ll.l.H, 5, 0, 1.0f).b(8, 5).b("hydraChop");
        TFItems.fieryBlood = new ItemTF(TwilightForestMod.idItemFieryBlood).makeRare().c(21).b("fieryBlood");
        TFItems.hydraTrophy = new ItemTF(TwilightForestMod.idItemHydraTrophy).makeRare().c(22).b("hydraTrophy");
        TFItems.fieryIngot = new ItemTF(TwilightForestMod.idItemFieryIngot).makeRare().b(4, 2).b("fieryIngot");
        TFItems.fieryHelm = new ItemTFFieryArmor(TwilightForestMod.idItemFieryHelm, TFItems.ARMOR_FIERY, fieryRenderID, 0).b(4, 3).b("fieryHelm").d(1);
        TFItems.fieryPlate = new ItemTFFieryArmor(TwilightForestMod.idItemFieryPlate, TFItems.ARMOR_FIERY, fieryRenderID, 1).b(4, 4).b("fieryPlate").d(1);
        TFItems.fieryLegs = new ItemTFFieryArmor(TwilightForestMod.idItemFieryLegs, TFItems.ARMOR_FIERY, fieryRenderID, 2).b(4, 5).b("fieryLegs").d(1);
        TFItems.fieryBoots = new ItemTFFieryArmor(TwilightForestMod.idItemFieryBoots, TFItems.ARMOR_FIERY, fieryRenderID, 3).b(4, 6).b("fieryBoots").d(1);
        TFItems.fierySword = new ItemTFFierySword(TwilightForestMod.idItemFierySword, TFItems.TOOL_FIERY).b(4, 7).b("fierySword").d(1);
        TFItems.fieryPick = new ItemTFFieryPick(TwilightForestMod.idItemFieryPick, TFItems.TOOL_FIERY).b(4, 9).b("fieryPick").d(1);
        TFItems.steeleafIngot = new ItemTF(TwilightForestMod.idItemSteeleafIngot).b(2, 2).b("steeleafIngot");
        TFItems.steeleafHelm = new ItemTFSteeleafArmor(TwilightForestMod.idItemSteeleafHelm, TFItems.ARMOR_IRONWOOD, steeleafRenderID, 0).b(2, 3).b("steeleafHelm").d(1);
        TFItems.steeleafPlate = new ItemTFSteeleafArmor(TwilightForestMod.idItemSteeleafPlate, TFItems.ARMOR_IRONWOOD, steeleafRenderID, 1).b(2, 4).b("steeleafPlate").d(1);
        TFItems.steeleafLegs = new ItemTFSteeleafArmor(TwilightForestMod.idItemSteeleafLegs, TFItems.ARMOR_IRONWOOD, steeleafRenderID, 2).b(2, 5).b("steeleafLegs").d(1);
        TFItems.steeleafBoots = new ItemTFSteeleafArmor(TwilightForestMod.idItemSteeleafBoots, TFItems.ARMOR_IRONWOOD, steeleafRenderID, 3).b(2, 6).b("steeleafBoots").d(1);
        TFItems.steeleafSword = new ItemTFSteeleafSword(TwilightForestMod.idItemSteeleafSword, TFItems.TOOL_STEELEAF).b(2, 7).b("steeleafSword").d(1);
        TFItems.steeleafShovel = new ItemTFSteeleafShovel(TwilightForestMod.idItemSteeleafShovel, TFItems.TOOL_STEELEAF).b(2, 8).b("steeleafShovel").d(1);
        TFItems.steeleafPick = new ItemTFSteeleafPick(TwilightForestMod.idItemSteeleafPick, TFItems.TOOL_STEELEAF).b(2, 9).b("steeleafPick").d(1);
        TFItems.steeleafAxe = new ItemTFSteeleafAxe(TwilightForestMod.idItemSteeleafAxe, TFItems.TOOL_STEELEAF).b(2, 10).b("steeleafAxe").d(1);
        TFItems.steeleafHoe = new ItemTFSteeleafHoe(TwilightForestMod.idItemSteeleafHoe, TFItems.TOOL_STEELEAF).b(2, 11).b("steeleafHoe").d(1);
        TFItems.minotaurAxe = new ItemTFMinotaurAxe(TwilightForestMod.idItemMinotaurAxe, uq.d).b(0, 10).b("minotaurAxe").d(1);
        TFItems.mazebreakerPick = new ItemTFMazebreakerPick(TwilightForestMod.idItemMazebreakerPick, uq.d).b(0, 9).b("mazebreakerPick").d(1);
        TFItems.transformPowder = new ItemTFTransformPowder(TwilightForestMod.idItemTransformPowder).makeRare().b(7, 1).b("transformPowder");
        TFItems.meefRaw = new uk(TwilightForestMod.idItemMeefRaw, 2, 0.3f, true).b(9, 6).b("meefRaw");
        TFItems.meefSteak = new uk(TwilightForestMod.idItemMeefSteak, 6, 0.6f, true).b(10, 6).b("meefSteak");
        TFItems.meefStroganoff = new tc(TwilightForestMod.idItemMeefStroganoff, 8).b(8, 4).b("meefStroganoff");
        TFItems.mazeWafer = new uk(TwilightForestMod.idItemMazeWafer, 4, 0.6f, true).b(12, 5).b("mazeWafer");
        TFItems.emptyMagicMap = new ItemTFEmptyMagicMap(TwilightForestMod.idItemEmptyMagicMap).b(8, 1).b("emptyMagicMap");
        TFItems.emptyMazeMap = new ItemTFEmptyMazeMap(TwilightForestMod.idItemEmptyMazeMap, false).b(10, 1).b("emptyMazeMap");
        TFItems.emptyOreMap = new ItemTFEmptyMazeMap(TwilightForestMod.idItemEmptyOreMap, true).b(11, 1).b("emptyOreMap");
        TFItems.oreMagnet = new ItemTFOreMagnet(TwilightForestMod.idItemOreMagnet).b(13, 2).b("oreMagnet");
        TFItems.crumbleHorn = new ItemTFCrumbleHorn(TwilightForestMod.idItemCrumbleHorn).b(12, 1).b("crumbleHorn");
        TFItems.peacockFan = new ItemTFPeacockFan(TwilightForestMod.idItemPeacockFan).b(13, 1).b("peacockFan");
        TFItems.moonwormQueen = new ItemTFMoonwormQueen(TwilightForestMod.idItemMoonwormQueen).b(14, 1).b("moonwormQueen");
        TFItems.charmOfLife1 = new ItemTFCharm(TwilightForestMod.idItemCharmOfLife1).b(8, 2).b("charmOfLife1");
        TFItems.charmOfLife2 = new ItemTFCharm(TwilightForestMod.idItemCharmOfLife2).b(9, 2).b("charmOfLife2");
        TFItems.charmOfKeeping1 = new ItemTFCharm(TwilightForestMod.idItemCharmOfKeeping1).b(10, 2).b("charmOfKeeping1");
        TFItems.charmOfKeeping2 = new ItemTFCharm(TwilightForestMod.idItemCharmOfKeeping2).b(11, 2).b("charmOfKeeping2");
        TFItems.charmOfKeeping3 = new ItemTFCharm(TwilightForestMod.idItemCharmOfKeeping3).b(12, 2).b("charmOfKeeping3");
        this.registerTFItem(TFItems.nagaScale, "Naga Scale");
        this.registerTFItem(TFItems.plateNaga, "Naga Scale Tunic");
        this.registerTFItem(TFItems.legsNaga, "Naga Scale Leggings");
        this.registerTFItem(TFItems.scepterTwilight, "Scepter of Twilight");
        this.registerTFItem(TFItems.scepterLifeDrain, "Scepter of Life Draining");
        this.registerTFItem(TFItems.scepterZombie, "Zombie Scepter");
        this.registerTFItem(TFItems.oreMeter, "Ore Meter [WIP]");
        this.registerTFItem(TFItems.magicMap, "Magic Map");
        this.registerTFItem(TFItems.mazeMap, "Maze Map");
        this.registerTFItem(TFItems.oreMap, "Maze/Ore Map");
        this.registerTFItem(TFItems.feather, "Raven's Feather");
        this.registerTFItem(TFItems.magicMapFocus, "Magic Map Focus");
        this.registerTFItem(TFItems.mazeMapFocus, "Maze Map Focus");
        this.registerTFItem(TFItems.liveRoot, "Liveroot");
        this.registerTFItem(TFItems.ironwoodRaw, "Raw Ironwood Materials");
        this.registerTFItem(TFItems.ironwoodIngot, "Ironwood Ingot");
        this.registerTFItem(TFItems.ironwoodHelm, "Ironwood Helm");
        this.registerTFItem(TFItems.ironwoodPlate, "Ironwood Plate");
        this.registerTFItem(TFItems.ironwoodLegs, "Ironwood Legs");
        this.registerTFItem(TFItems.ironwoodBoots, "Ironwood Boots");
        this.registerTFItem(TFItems.ironwoodSword, "Ironwood Sword");
        this.registerTFItem(TFItems.ironwoodShovel, "Ironwood Shovel");
        this.registerTFItem(TFItems.ironwoodPick, "Ironwood Pick");
        this.registerTFItem(TFItems.ironwoodAxe, "Ironwood Axe");
        this.registerTFItem(TFItems.ironwoodHoe, "Ironwood Hoe");
        this.registerTFItem(TFItems.torchberries, "Torchberries");
        this.registerTFItem(TFItems.venisonRaw, "Raw Venison");
        this.registerTFItem(TFItems.venisonCooked, "Venison Steak");
        this.registerTFItem(TFItems.hydraChop, "Hydra Chop");
        this.registerTFItem(TFItems.fieryBlood, "Fiery Blood");
        this.registerTFItem(TFItems.hydraTrophy, "Hydra Trophy [NYI]");
        this.registerTFItem(TFItems.fieryIngot, "Fiery Ingot");
        this.registerTFItem(TFItems.fieryHelm, "Fiery Helm");
        this.registerTFItem(TFItems.fieryPlate, "Fiery Plate");
        this.registerTFItem(TFItems.fieryLegs, "Fiery Legs");
        this.registerTFItem(TFItems.fieryBoots, "Fiery Boots");
        this.registerTFItem(TFItems.fierySword, "Fiery Sword");
        this.registerTFItem(TFItems.fieryPick, "Fiery Pick");
        this.registerTFItem(TFItems.steeleafIngot, "Steeleaf");
        this.registerTFItem(TFItems.steeleafHelm, "Steeleaf Helm");
        this.registerTFItem(TFItems.steeleafPlate, "Steeleaf Plate");
        this.registerTFItem(TFItems.steeleafLegs, "Steeleaf Legs");
        this.registerTFItem(TFItems.steeleafBoots, "Steeleaf Boots");
        this.registerTFItem(TFItems.steeleafSword, "Steeleaf Sword");
        this.registerTFItem(TFItems.steeleafShovel, "Steeleaf Shovel");
        this.registerTFItem(TFItems.steeleafPick, "Steeleaf Pick");
        this.registerTFItem(TFItems.steeleafAxe, "Steeleaf Axe");
        this.registerTFItem(TFItems.steeleafHoe, "Steeleaf Hoe");
        this.registerTFItem(TFItems.minotaurAxe, "Minotaur Axe");
        this.registerTFItem(TFItems.mazebreakerPick, "Mazebreaker");
        this.registerTFItem(TFItems.transformPowder, "Transformation Powder");
        this.registerTFItem(TFItems.meefRaw, "Raw Meef");
        this.registerTFItem(TFItems.meefSteak, "Meef Steak");
        this.registerTFItem(TFItems.meefStroganoff, "Meef Stroganoff");
        this.registerTFItem(TFItems.mazeWafer, "Maze Wafer");
        this.registerTFItem(TFItems.emptyMagicMap, "Blank Magic Map");
        this.registerTFItem(TFItems.emptyMazeMap, "Blank Maze Map");
        this.registerTFItem(TFItems.emptyOreMap, "Blank Maze/Ore Map");
        this.registerTFItem(TFItems.oreMagnet, "Ore Magnet");
        this.registerTFItem(TFItems.crumbleHorn, "Crumble Horn");
        this.registerTFItem(TFItems.peacockFan, "Peacock Feather Fan");
        this.registerTFItem(TFItems.moonwormQueen, "Moonworm Queen");
        this.registerTFItem(TFItems.charmOfLife1, "Charm of Life I");
        this.registerTFItem(TFItems.charmOfLife2, "Charm of Life II");
        this.registerTFItem(TFItems.charmOfKeeping1, "Charm of Keeping I");
        this.registerTFItem(TFItems.charmOfKeeping2, "Charm of Keeping II");
        this.registerTFItem(TFItems.charmOfKeeping3, "Charm of Keeping III");
        this.registerTFItem(TFItems.spawnEgg, "Spawn");
        LanguageRegistry.instance().addStringLocalization("enchantment.tfFireReact", "Fiery Aura");
        LanguageRegistry.instance().addStringLocalization("itemGroup.twilightForest", "en_US", "Twilight Forest");
    }
    
    private void registerTFItem(final up item, final String englishName) {
        LanguageRegistry.instance().addNameForObject((Object)item, "en_US", englishName);
        GameRegistry.registerItem(item, item.a(), "TwilightForest");
    }
    
    static {
        TFItems.ARMOR_NAGA = EnumHelper.addArmorMaterial("NAGA_SCALE", 21, new int[] { 2, 7, 6, 3 }, 15);
        TFItems.ARMOR_IRONWOOD = EnumHelper.addArmorMaterial("IRONWOOD", 20, new int[] { 2, 7, 5, 2 }, 15);
        TFItems.ARMOR_FIERY = EnumHelper.addArmorMaterial("FIERY", 25, new int[] { 4, 9, 7, 4 }, 10);
        TFItems.ARMOR_STEELEAF = EnumHelper.addArmorMaterial("STEELEAF", 10, new int[] { 3, 8, 6, 3 }, 9);
        TFItems.TOOL_IRONWOOD = EnumHelper.addToolMaterial("IRONWOOD", 2, 512, 6.5f, 2, 25);
        TFItems.TOOL_FIERY = EnumHelper.addToolMaterial("FIERY", 4, 1024, 9.0f, 4, 10);
        TFItems.TOOL_STEELEAF = EnumHelper.addToolMaterial("STEELEAF", 3, 131, 8.0f, 3, 9);
        TFItems.creativeTab = new CreativeTabTwilightForest("twilightForest");
    }
}
