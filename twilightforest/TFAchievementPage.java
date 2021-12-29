// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.init.Blocks;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class TFAchievementPage extends AchievementPage
{
    public static Achievement twilightPortal;
    public static Achievement twilightArrival;
    public static Achievement twilightHunter;
    public static Achievement twilightMagicMapFocus;
    public static Achievement twilightHill1;
    public static Achievement twilightHill2;
    public static Achievement twilightHill3;
    public static Achievement twilightHedge;
    public static Achievement twilightMagicMap;
    public static Achievement twilightKillNaga;
    public static Achievement twilightProgressNaga;
    public static Achievement twilightKillLich;
    public static Achievement twilightProgressLich;
    public static Achievement twilightProgressLabyrinth;
    public static Achievement twilightKillHydra;
    public static Achievement twilightProgressHydra;
    public static Achievement twilightProgressTrophyPedestal;
    public static Achievement twilightProgressKnights;
    public static Achievement twilightProgressUrghast;
    public static Achievement twilightProgressYeti;
    public static Achievement twilightProgressGlacier;
    public static Achievement twilightProgressTroll;
    public static Achievement twilightProgressThorns;
    public static Achievement twilightProgressCastle;
    public static Achievement twilightNagaArmors;
    public static Achievement twilightLichScepters;
    public static Achievement twilightMazeMap;
    public static Achievement twilightOreMap;
    public static Achievement twilightHydraChop;
    public static Achievement twilightMazebreaker;
    public static Achievement twilightFierySet;
    public static Achievement twilightQuestRam;
    
    public TFAchievementPage() {
        super("Twilight Forest", new Achievement[] { TFAchievementPage.twilightPortal, TFAchievementPage.twilightArrival, TFAchievementPage.twilightHunter, TFAchievementPage.twilightMagicMapFocus, TFAchievementPage.twilightKillNaga, TFAchievementPage.twilightNagaArmors, TFAchievementPage.twilightKillLich, TFAchievementPage.twilightLichScepters, TFAchievementPage.twilightHill1, TFAchievementPage.twilightHill2, TFAchievementPage.twilightHill3, TFAchievementPage.twilightHedge, TFAchievementPage.twilightMagicMap, TFAchievementPage.twilightMazeMap, TFAchievementPage.twilightOreMap, TFAchievementPage.twilightProgressNaga, TFAchievementPage.twilightProgressLich, TFAchievementPage.twilightProgressLabyrinth, TFAchievementPage.twilightHydraChop, TFAchievementPage.twilightProgressKnights, TFAchievementPage.twilightProgressUrghast, TFAchievementPage.twilightProgressYeti, TFAchievementPage.twilightProgressGlacier, TFAchievementPage.twilightProgressTroll, TFAchievementPage.twilightProgressThorns, TFAchievementPage.twilightProgressCastle, TFAchievementPage.twilightKillHydra, TFAchievementPage.twilightHydraChop, TFAchievementPage.twilightProgressTrophyPedestal, TFAchievementPage.twilightProgressHydra, TFAchievementPage.twilightMazebreaker, TFAchievementPage.twilightFierySet, TFAchievementPage.twilightQuestRam });
    }
    
    static {
        TFAchievementPage.twilightPortal = new Achievement("TwilightForest1", "twilightPortal", -2, 1, TFBlocks.portal, (Achievement)null).func_75987_b().func_75971_g();
        TFAchievementPage.twilightArrival = new Achievement("TwilightForest2", "twilightArrival", 0, 0, new ItemStack(TFBlocks.log, 1, 9), TFAchievementPage.twilightPortal).func_75971_g();
        TFAchievementPage.twilightHunter = new Achievement("TwilightForest3", "twilightHunter", 2, 2, TFItems.feather, TFAchievementPage.twilightArrival).func_75971_g();
        TFAchievementPage.twilightMagicMapFocus = new Achievement("TwilightForest5", "twilightMagicMapFocus", 2, 0, TFItems.magicMapFocus, TFAchievementPage.twilightHunter).func_75971_g();
        TFAchievementPage.twilightHill1 = new Achievement("TwilightForest10", "twilightHill1", -2, -1, Blocks.field_150366_p, TFAchievementPage.twilightArrival).func_75971_g();
        TFAchievementPage.twilightHill2 = new Achievement("TwilightForest11", "twilightHill2", -3, -2, Blocks.field_150352_o, TFAchievementPage.twilightArrival).func_75971_g();
        TFAchievementPage.twilightHill3 = new Achievement("TwilightForest12", "twilightHill3", -1, -3, Blocks.field_150482_ag, TFAchievementPage.twilightArrival).func_75971_g();
        TFAchievementPage.twilightHedge = new Achievement("TwilightForest13", "twilightHedge", 2, -3, TFBlocks.hedge, TFAchievementPage.twilightArrival).func_75971_g();
        TFAchievementPage.twilightMagicMap = new Achievement("TwilightForest14", "twilightMagicMap", 4, -1, TFItems.magicMap, TFAchievementPage.twilightMagicMapFocus).func_75971_g();
        TFAchievementPage.twilightKillNaga = new Achievement("TwilightForest6", "twilightKillNaga", 4, 3, new ItemStack(TFItems.trophy, 1, 1), TFAchievementPage.twilightHunter).func_75971_g();
        TFAchievementPage.twilightProgressNaga = new Achievement("TwilightForest17", "twilightProgressNaga", 4, 5, TFItems.nagaScale, TFAchievementPage.twilightKillNaga).func_75971_g();
        TFAchievementPage.twilightKillLich = new Achievement("TwilightForest8", "twilightKillLich", 2, 5, new ItemStack(TFItems.trophy, 1, 2), TFAchievementPage.twilightProgressNaga).func_75971_g();
        TFAchievementPage.twilightProgressLich = new Achievement("TwilightForest18", "twilightProgressLich", -1, 4, TFItems.scepterLifeDrain, TFAchievementPage.twilightKillLich).func_75971_g();
        TFAchievementPage.twilightProgressLabyrinth = new Achievement("TwilightForest28", "twilightProgressLabyrinth", -4, 6, TFItems.meefStroganoff, TFAchievementPage.twilightProgressLich).func_75971_g();
        TFAchievementPage.twilightKillHydra = new Achievement("TwilightForest30", "twilightKillHydra", -6, 4, new ItemStack(TFItems.trophy, 1, 0), TFAchievementPage.twilightProgressLabyrinth).func_75971_g();
        TFAchievementPage.twilightProgressHydra = new Achievement("TwilightForest20", "twilightProgressHydra", -8, 4, TFItems.fieryBlood, TFAchievementPage.twilightKillHydra).func_75971_g();
        TFAchievementPage.twilightProgressTrophyPedestal = new Achievement("TwilightForest29", "twilightProgressTrophyPedestal", -5, 2, TFBlocks.trophyPedestal, TFAchievementPage.twilightProgressHydra).func_75971_g();
        TFAchievementPage.twilightProgressKnights = new Achievement("TwilightForest21", "twilightProgressKnights", -5, -1, TFItems.phantomHelm, TFAchievementPage.twilightProgressTrophyPedestal).func_75971_g();
        TFAchievementPage.twilightProgressUrghast = new Achievement("TwilightForest22", "twilightProgressUrghast", -7, -1, new ItemStack(TFItems.trophy, 1, 3), TFAchievementPage.twilightProgressKnights).func_75971_g();
        TFAchievementPage.twilightProgressYeti = new Achievement("TwilightForest23", "twilightProgressYeti", -7, -3, TFItems.alphaFur, TFAchievementPage.twilightProgressUrghast).func_75971_g();
        TFAchievementPage.twilightProgressGlacier = new Achievement("TwilightForest24", "twilightProgressGlacier", -5, -5, new ItemStack(TFItems.trophy, 1, 4), TFAchievementPage.twilightProgressYeti).func_75971_g();
        TFAchievementPage.twilightProgressTroll = new Achievement("TwilightForest25", "twilightProgressTroll", -5, -7, TFItems.lampOfCinders, TFAchievementPage.twilightProgressGlacier).func_75971_g();
        TFAchievementPage.twilightProgressThorns = new Achievement("TwilightForest26", "twilightProgressThorns", -3, -7, TFBlocks.thorns, TFAchievementPage.twilightProgressTroll).func_75971_g();
        TFAchievementPage.twilightProgressCastle = new Achievement("TwilightForest27", "twilightProgressCastle", -1, -7, Blocks.field_150417_aV, TFAchievementPage.twilightProgressThorns).func_75971_g();
        TFAchievementPage.twilightNagaArmors = new Achievement("TwilightForest7", "twilightNagaArmors", 5, 1, TFItems.plateNaga, TFAchievementPage.twilightKillNaga).func_75987_b().func_75971_g();
        TFAchievementPage.twilightLichScepters = new Achievement("TwilightForest9", "twilightLichScepters", 3, 7, TFItems.scepterZombie, TFAchievementPage.twilightKillLich).func_75987_b().func_75971_g();
        TFAchievementPage.twilightMazeMap = new Achievement("TwilightForest15", "twilightMazeMap", 1, 7, TFItems.mazeMap, TFAchievementPage.twilightProgressLich).func_75971_g();
        TFAchievementPage.twilightOreMap = new Achievement("TwilightForest16", "twilightOreMap", 1, 9, TFItems.oreMap, TFAchievementPage.twilightMazeMap).func_75987_b().func_75971_g();
        TFAchievementPage.twilightHydraChop = new Achievement("TwilightForest31", "twilightHydraChop", -6, 6, TFItems.hydraChop, TFAchievementPage.twilightKillHydra).func_75971_g();
        TFAchievementPage.twilightMazebreaker = new Achievement("TwilightForest32", "twilightMazebreaker", -3, 4, TFItems.mazebreakerPick, TFAchievementPage.twilightProgressLich).func_75987_b().func_75971_g();
        TFAchievementPage.twilightFierySet = new Achievement("TwilightForest33", "twilightFierySet", -8, 7, TFItems.fierySword, TFAchievementPage.twilightProgressHydra).func_75987_b().func_75971_g();
        TFAchievementPage.twilightQuestRam = new Achievement("TwilightForest34", "twilightQuestRam", 1, -5, TFItems.crumbleHorn, TFAchievementPage.twilightArrival).func_75987_b().func_75971_g();
    }
}
