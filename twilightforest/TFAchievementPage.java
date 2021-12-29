// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.block.Block;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class TFAchievementPage extends AchievementPage
{
    public static Achievement twilightPortal;
    public static Achievement twilightArrival;
    public static Achievement twilightHunter;
    public static Achievement twilightMagicMapFocus;
    public static Achievement twilightNaga;
    public static Achievement twilightNagaArmors;
    public static Achievement twilightLich;
    public static Achievement twilightLichScepters;
    public static Achievement twilightHill1;
    public static Achievement twilightHill2;
    public static Achievement twilightHill3;
    public static Achievement twilightHedge;
    public static Achievement twilightMagicMap;
    public static Achievement twilightMazeMap;
    public static Achievement twilightOreMap;
    
    public TFAchievementPage() {
        super("Twilight Forest", new Achievement[] { TFAchievementPage.twilightPortal, TFAchievementPage.twilightArrival, TFAchievementPage.twilightHunter, TFAchievementPage.twilightMagicMapFocus, TFAchievementPage.twilightNaga, TFAchievementPage.twilightNagaArmors, TFAchievementPage.twilightLich, TFAchievementPage.twilightLichScepters, TFAchievementPage.twilightHill1, TFAchievementPage.twilightHill2, TFAchievementPage.twilightHill3, TFAchievementPage.twilightHedge, TFAchievementPage.twilightMagicMap, TFAchievementPage.twilightMazeMap, TFAchievementPage.twilightOreMap });
        LanguageRegistry.instance().addStringLocalization("achievement.twilightPortal", "en_US", "Twilight Portal");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightPortal.desc", "en_US", "Build a portal to the Twilight Forest");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightArrival", "en_US", "Twilight Arrival");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightArrival.desc", "en_US", "Arrive in the Twilight Forest");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHunter", "en_US", "Twilight Hunter");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHunter.desc", "en_US", "Hunt some of the local wildlife");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightMagicMapFocus", "en_US", "With Fire It Writes");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightMagicMapFocus.desc", "en_US", "Craft the magic map focus with a raven's feather, glowstone dust, and torchberries");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightNaga", "en_US", "Naga Hunter");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightNaga.desc", "en_US", "Slay the naga");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightNagaArmors", "en_US", "Naga Armorer");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightNagaArmors.desc", "en_US", "Craft naga scale chest and leg armor");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightLich", "en_US", "Lich Hunter");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightLich.desc", "en_US", "Slay the lich");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightLichScepters", "en_US", "Scepter Mastery");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightLichScepters.desc", "en_US", "Acquire all three scepters of power");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHill1", "en_US", "The Boots Are Mine!");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHill1.desc", "en_US", "Defeat a redcap goblin in a small hollow hill");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHill2", "en_US", "Medium Hill [NYI]");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHill2.desc", "en_US", "Defeat a (no unique monster) in a medium hollow hill");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHill3", "en_US", "I See Right Through You");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHill3.desc", "en_US", "Defeat a twilight wraith in a large hollow hill");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHedge", "en_US", "Bug Stomper");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightHedge.desc", "en_US", "Defeat a spider in a hedge maze");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightMagicMap", "en_US", "I Can See For Miles");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightMagicMap.desc", "en_US", "Craft the magic map");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightMazeMap", "en_US", "And Now, to Find the Exit");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightMazeMap.desc", "en_US", "Craft the maze map after obtaining the focus from a goblin");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightOreMap", "en_US", "How Can That Be Worth It?");
        LanguageRegistry.instance().addStringLocalization("achievement.twilightOreMap.desc", "en_US", "Craft the maze/ore map");
    }
    
    static {
        TFAchievementPage.twilightPortal = new Achievement(7001, "twilightPortal", -2, 1, TFBlocks.portal, (Achievement)null).func_75987_b().func_75985_c();
        TFAchievementPage.twilightArrival = new Achievement(7002, "twilightArrival", 0, 0, new ItemStack(TFBlocks.log, 1, 9), TFAchievementPage.twilightPortal).func_75985_c();
        TFAchievementPage.twilightHunter = new Achievement(7003, "twilightHunter", 2, 2, TFItems.feather, TFAchievementPage.twilightArrival).func_75985_c();
        TFAchievementPage.twilightMagicMapFocus = new Achievement(7005, "twilightMagicMapFocus", 2, 0, TFItems.magicMapFocus, TFAchievementPage.twilightHunter).func_75985_c();
        TFAchievementPage.twilightNaga = new Achievement(7006, "twilightNaga", 2, 4, TFItems.nagaScale, TFAchievementPage.twilightHunter).func_75985_c();
        TFAchievementPage.twilightNagaArmors = new Achievement(7007, "twilightNagaArmors", 3, 5, TFItems.plateNaga, TFAchievementPage.twilightNaga).func_75987_b().func_75985_c();
        TFAchievementPage.twilightLich = new Achievement(7008, "twilightLich", 4, 3, TFItems.scepterTwilight, TFAchievementPage.twilightHunter).func_75985_c();
        TFAchievementPage.twilightLichScepters = new Achievement(7009, "twilightLichScepters", 6, 4, TFItems.scepterZombie, TFAchievementPage.twilightLich).func_75987_b().func_75985_c();
        TFAchievementPage.twilightHill1 = new Achievement(7010, "twilightHill1", -2, -1, Block.field_71949_H, TFAchievementPage.twilightArrival).func_75985_c();
        TFAchievementPage.twilightHill2 = new Achievement(7011, "twilightHill2", -3, -2, Block.field_71941_G, TFAchievementPage.twilightArrival).func_75985_c();
        TFAchievementPage.twilightHill3 = new Achievement(7012, "twilightHill3", -1, -3, Block.field_72073_aw, TFAchievementPage.twilightArrival).func_75985_c();
        TFAchievementPage.twilightHedge = new Achievement(7013, "twilightHedge", 2, -3, TFBlocks.hedge, TFAchievementPage.twilightArrival).func_75985_c();
        TFAchievementPage.twilightMagicMap = new Achievement(7014, "twilightMagicMap", 3, -1, TFItems.magicMap, TFAchievementPage.twilightMagicMapFocus).func_75985_c();
        TFAchievementPage.twilightMazeMap = new Achievement(7015, "twilightMazeMap", -4, -1, TFItems.mazeMap, TFAchievementPage.twilightHill1).func_75985_c();
        TFAchievementPage.twilightOreMap = new Achievement(7016, "twilightOreMap", -6, -3, TFItems.oreMap, TFAchievementPage.twilightMazeMap).func_75987_b().func_75985_c();
    }
}
