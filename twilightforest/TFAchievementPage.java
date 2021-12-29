// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.AchievementPage;

public class TFAchievementPage extends AchievementPage
{
    public static aeb twilightPortal;
    public static aeb twilightArrival;
    public static aeb twilightHunter;
    public static aeb twilightMagicMapFocus;
    public static aeb twilightNaga;
    public static aeb twilightNagaArmors;
    public static aeb twilightLich;
    public static aeb twilightLichScepters;
    public static aeb twilightHill1;
    public static aeb twilightHill2;
    public static aeb twilightHill3;
    public static aeb twilightHedge;
    public static aeb twilightMagicMap;
    public static aeb twilightMazeMap;
    public static aeb twilightOreMap;
    
    public TFAchievementPage() {
        super("Twilight Forest", new aeb[] { TFAchievementPage.twilightPortal, TFAchievementPage.twilightArrival, TFAchievementPage.twilightHunter, TFAchievementPage.twilightMagicMapFocus, TFAchievementPage.twilightNaga, TFAchievementPage.twilightNagaArmors, TFAchievementPage.twilightLich, TFAchievementPage.twilightLichScepters, TFAchievementPage.twilightHill1, TFAchievementPage.twilightHill2, TFAchievementPage.twilightHill3, TFAchievementPage.twilightHedge, TFAchievementPage.twilightMagicMap, TFAchievementPage.twilightMazeMap, TFAchievementPage.twilightOreMap });
        ModLoader.addLocalization("achievement.twilightPortal", "Twilight Portal");
        ModLoader.addLocalization("achievement.twilightPortal.desc", "Build a portal to the Twilight Forest");
        ModLoader.addLocalization("achievement.twilightArrival", "Twilight Arrival");
        ModLoader.addLocalization("achievement.twilightArrival.desc", "Arrive in the Twilight Forest");
        ModLoader.addLocalization("achievement.twilightHunter", "Twilight Hunter");
        ModLoader.addLocalization("achievement.twilightHunter.desc", "Hunt some of the local wildlife");
        ModLoader.addLocalization("achievement.twilightMagicMapFocus", "With Fire It Writes");
        ModLoader.addLocalization("achievement.twilightMagicMapFocus.desc", "Craft the magic map focus with a raven's feather, glowstone dust, and blaze powder");
        ModLoader.addLocalization("achievement.twilightNaga", "Naga Hunter");
        ModLoader.addLocalization("achievement.twilightNaga.desc", "Slay the naga");
        ModLoader.addLocalization("achievement.twilightNagaArmors", "Naga Armorer [NYI]");
        ModLoader.addLocalization("achievement.twilightNagaArmors.desc", "Craft naga scale chest and leg armor");
        ModLoader.addLocalization("achievement.twilightLich", "Lich Hunter");
        ModLoader.addLocalization("achievement.twilightLich.desc", "Slay the lich");
        ModLoader.addLocalization("achievement.twilightLichScepters", "Scepter Mastery [NYI]");
        ModLoader.addLocalization("achievement.twilightLichScepters.desc", "Acquire all three scepters of power");
        ModLoader.addLocalization("achievement.twilightHill1", "The Boots Are Mine!");
        ModLoader.addLocalization("achievement.twilightHill1.desc", "Defeat a redcap goblin in a small hollow hill");
        ModLoader.addLocalization("achievement.twilightHill2", "Medium Hill [NYI]");
        ModLoader.addLocalization("achievement.twilightHill2.desc", "Defeat a (no unique monster) in a medium hollow hill");
        ModLoader.addLocalization("achievement.twilightHill3", "I See Right Through You");
        ModLoader.addLocalization("achievement.twilightHill3.desc", "Defeat a twilight wraith in a large hollow hill");
        ModLoader.addLocalization("achievement.twilightHedge", "Bug Stomper");
        ModLoader.addLocalization("achievement.twilightHedge.desc", "Defeat a spider in a hedge maze");
        ModLoader.addLocalization("achievement.twilightMagicMap", "I Can See For Miles");
        ModLoader.addLocalization("achievement.twilightMagicMap.desc", "Craft the magic map");
        ModLoader.addLocalization("achievement.twilightMazeMap", "And Now, to Find the Exit");
        ModLoader.addLocalization("achievement.twilightMazeMap.desc", "Craft the maze map after obtaining the focus from a goblin");
        ModLoader.addLocalization("achievement.twilightOreMap", "How Can That Be Worth It?");
        ModLoader.addLocalization("achievement.twilightOreMap.desc", "Craft the maze/ore map");
    }
    
    static {
        TFAchievementPage.twilightPortal = new aeb(7001, "twilightPortal", -2, 1, TFBlocks.portal, (aeb)null).b().c().d();
        TFAchievementPage.twilightArrival = new aeb(7002, "twilightArrival", 0, 0, new aan(TFBlocks.wood, 1, 9), TFAchievementPage.twilightPortal).d();
        TFAchievementPage.twilightHunter = new aeb(7003, "twilightHunter", 2, 2, TFItems.feather, TFAchievementPage.twilightArrival).d();
        TFAchievementPage.twilightMagicMapFocus = new aeb(7005, "twilightMagicMapFocus", 2, 0, TFItems.magicMapFocus, TFAchievementPage.twilightHunter).d();
        TFAchievementPage.twilightNaga = new aeb(7006, "twilightNaga", 2, 4, TFItems.nagaScale, TFAchievementPage.twilightHunter).d();
        TFAchievementPage.twilightNagaArmors = new aeb(7007, "twilightNagaArmors", 3, 5, TFItems.plateNaga, TFAchievementPage.twilightNaga).c().d();
        TFAchievementPage.twilightLich = new aeb(7008, "twilightLich", 4, 3, TFItems.scepterTwilight, TFAchievementPage.twilightHunter).d();
        TFAchievementPage.twilightLichScepters = new aeb(7009, "twilightLichScepters", 6, 4, TFItems.scepterZombie, TFAchievementPage.twilightLich).c().d();
        TFAchievementPage.twilightHill1 = new aeb(7010, "twilightHill1", -2, -1, pb.H, TFAchievementPage.twilightArrival).d();
        TFAchievementPage.twilightHill2 = new aeb(7011, "twilightHill2", -3, -2, pb.G, TFAchievementPage.twilightArrival).d();
        TFAchievementPage.twilightHill3 = new aeb(7012, "twilightHill3", -1, -3, pb.aw, TFAchievementPage.twilightArrival).d();
        TFAchievementPage.twilightHedge = new aeb(7013, "twilightHedge", 2, -3, TFBlocks.hedge, TFAchievementPage.twilightArrival).d();
        TFAchievementPage.twilightMagicMap = new aeb(7014, "twilightMagicMap", 3, -1, TFItems.magicMap, TFAchievementPage.twilightMagicMapFocus).d();
        TFAchievementPage.twilightMazeMap = new aeb(7015, "twilightMazeMap", -4, -1, TFItems.mazeMap, TFAchievementPage.twilightHill1).d();
        TFAchievementPage.twilightOreMap = new aeb(7016, "twilightOreMap", -6, -3, TFItems.oreMap, TFAchievementPage.twilightMazeMap).c().d();
    }
}
