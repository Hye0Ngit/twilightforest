// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.entity.EntityTFTroll;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.entity.EntityTFYeti;
import net.minecraft.entity.monster.EntitySlime;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFBlockGoblin;
import net.minecraft.entity.passive.EntitySquid;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFWraith;
import net.minecraft.entity.monster.EntityCaveSpider;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.EntityTFRedcapSapper;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import twilightforest.entity.EntityTFDeathTome;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EnumCreatureType;
import twilightforest.world.TFWorld;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.biomes.TFBiomeBase;
import java.util.Random;
import twilightforest.world.TFWorldChunkManager;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.stats.Achievement;
import java.util.List;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.ArrayList;

public class TFFeature
{
    public static final TFFeature[] featureList;
    public static final TFFeature nothing;
    public static final TFFeature hill1;
    public static final TFFeature hill2;
    public static final TFFeature hill3;
    public static final TFFeature hedgeMaze;
    public static final TFFeature nagaCourtyard;
    public static final TFFeature lichTower;
    public static final TFFeature iceTower;
    public static final TFFeature questIsland;
    public static final TFFeature questGrove;
    public static final TFFeature druidGrove;
    public static final TFFeature floatRuins;
    public static final TFFeature hydraLair;
    public static final TFFeature labyrinth;
    public static final TFFeature darkTower;
    public static final TFFeature tfStronghold;
    public static final TFFeature worldTree;
    public static final TFFeature yetiCave;
    public static final TFFeature trollCave;
    public static final TFFeature finalCastle;
    public static final TFFeature mushroomTower;
    ArrayList<BiomeGenBase.SpawnListEntry> emptyList;
    public int featureID;
    public int size;
    public String name;
    public boolean areChunkDecorationsEnabled;
    public boolean isStructureEnabled;
    public boolean isTerrainAltered;
    protected List<List<BiomeGenBase.SpawnListEntry>> spawnableMonsterLists;
    protected List<BiomeGenBase.SpawnListEntry> ambientCreatureList;
    protected List<BiomeGenBase.SpawnListEntry> waterCreatureList;
    protected Achievement requiredAchievement;
    
    public TFFeature(final int parID, final int parSize, final String parName) {
        this.emptyList = new ArrayList<BiomeGenBase.SpawnListEntry>();
        this.requiredAchievement = null;
        this.featureID = parID;
        TFFeature.featureList[parID] = this;
        this.size = parSize;
        this.name = parName;
        this.areChunkDecorationsEnabled = false;
        this.isStructureEnabled = true;
        this.isTerrainAltered = false;
        this.spawnableMonsterLists = new ArrayList<List<BiomeGenBase.SpawnListEntry>>();
        this.ambientCreatureList = new ArrayList<BiomeGenBase.SpawnListEntry>();
        this.waterCreatureList = new ArrayList<BiomeGenBase.SpawnListEntry>();
        this.ambientCreatureList.add(new BiomeGenBase.SpawnListEntry((Class)EntityBat.class, 10, 8, 8));
    }
    
    public TFFeature enableDecorations() {
        this.areChunkDecorationsEnabled = true;
        return this;
    }
    
    public TFFeature disableStructure() {
        this.isStructureEnabled = false;
        return this;
    }
    
    public TFFeature enableTerrainAlterations() {
        this.isTerrainAltered = true;
        return this;
    }
    
    public TFFeature addMonster(final Class<? extends EntityLivingBase> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.addMonster(0, monsterClass, weight, minGroup, maxGroup);
        return this;
    }
    
    public TFFeature addMonster(final int listIndex, final Class<? extends EntityLivingBase> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        List<BiomeGenBase.SpawnListEntry> monsterList;
        if (this.spawnableMonsterLists.size() > listIndex) {
            monsterList = this.spawnableMonsterLists.get(listIndex);
        }
        else {
            monsterList = new ArrayList<BiomeGenBase.SpawnListEntry>();
            this.spawnableMonsterLists.add(listIndex, monsterList);
        }
        monsterList.add(new BiomeGenBase.SpawnListEntry((Class)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public TFFeature addWaterCreature(final Class<? extends EntityLivingBase> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.waterCreatureList.add(new BiomeGenBase.SpawnListEntry((Class)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final World world) {
        if (world == null || !(world.func_72959_q() instanceof TFWorldChunkManager)) {
            return TFFeature.nothing;
        }
        final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.func_72959_q();
        if (tfManager.isInFeatureChunk(world, chunkX << 4, chunkZ << 4)) {
            return tfManager.getFeatureAt(chunkX << 4, chunkZ << 4, world);
        }
        return TFFeature.nothing;
    }
    
    public static TFFeature generateFeatureForOldMapGen(final int chunkX, final int chunkZ, final World world) {
        final BiomeGenBase biomeAt = world.func_72807_a((chunkX << 4) + 8, (chunkZ << 4) + 8);
        final Random hillRNG = new Random(world.func_72905_C() + chunkX * 25117 + chunkZ * 151121);
        final int randnum = hillRNG.nextInt(16);
        if (biomeAt == TFBiomeBase.glacier) {
            return TFFeature.iceTower;
        }
        if (biomeAt == TFBiomeBase.tfLake) {
            return TFFeature.questIsland;
        }
        if (biomeAt == TFBiomeBase.enchantedForest) {
            return TFFeature.questGrove;
        }
        if (biomeAt == TFBiomeBase.fireSwamp) {
            return TFFeature.hydraLair;
        }
        if (biomeAt == TFBiomeBase.clearing || biomeAt == TFBiomeBase.oakSavanna) {
            return TFFeature.labyrinth;
        }
        if (biomeAt == TFBiomeBase.darkForest) {
            switch (randnum % 3) {
                case 1: {
                    return TFFeature.darkTower;
                }
                case 2: {
                    return TFFeature.tfStronghold;
                }
            }
        }
        if (biomeAt == TFBiomeBase.deepMushrooms) {
            return TFFeature.mushroomTower;
        }
        switch (randnum) {
            default: {
                return TFFeature.hill1;
            }
            case 7:
            case 8:
            case 9: {
                return TFFeature.hill2;
            }
            case 10: {
                return TFFeature.hill3;
            }
            case 11:
            case 12: {
                return TFFeature.hedgeMaze;
            }
            case 13: {
                return (biomeAt != TFBiomeBase.tfSwamp) ? TFFeature.nagaCourtyard : TFFeature.hydraLair;
            }
            case 14:
            case 15: {
                return TFFeature.lichTower;
            }
        }
    }
    
    public static TFFeature generateFeatureFor1Point7(int chunkX, int chunkZ, final World world) {
        if (TwilightForestMod.oldMapGen) {
            return generateFeatureForOldMapGen(chunkX, chunkZ, world);
        }
        chunkX = Math.round(chunkX / 16.0f) * 16;
        chunkZ = Math.round(chunkZ / 16.0f) * 16;
        final BiomeGenBase biomeAt = world.func_72807_a((chunkX << 4) + 8, (chunkZ << 4) + 8);
        final Random hillRNG = new Random(world.func_72905_C() + chunkX * 25117 + chunkZ * 151121);
        final int randnum = hillRNG.nextInt(16);
        if (biomeAt == TFBiomeBase.glacier) {
            return TFFeature.iceTower;
        }
        if (biomeAt == TFBiomeBase.tfSnow) {
            return TFFeature.yetiCave;
        }
        if (biomeAt == TFBiomeBase.tfLake) {
            return TFFeature.questIsland;
        }
        if (biomeAt == TFBiomeBase.enchantedForest) {
            return TFFeature.questGrove;
        }
        if (biomeAt == TFBiomeBase.fireSwamp) {
            return TFFeature.hydraLair;
        }
        if (biomeAt == TFBiomeBase.tfSwamp) {
            return TFFeature.labyrinth;
        }
        if (biomeAt == TFBiomeBase.darkForest) {
            return TFFeature.tfStronghold;
        }
        if (biomeAt == TFBiomeBase.darkForestCenter) {
            return TFFeature.darkTower;
        }
        if (biomeAt == TFBiomeBase.highlandsCenter) {
            return TFFeature.finalCastle;
        }
        if (biomeAt == TFBiomeBase.highlands) {
            return TFFeature.trollCave;
        }
        if (biomeAt == TFBiomeBase.deepMushrooms) {
            return TFFeature.mushroomTower;
        }
        final int regionOffsetX = Math.abs((chunkX + 64 >> 4) % 8);
        final int regionOffsetZ = Math.abs((chunkZ + 64 >> 4) % 8);
        if ((regionOffsetX == 4 && regionOffsetZ == 5) || (regionOffsetX == 4 && regionOffsetZ == 3)) {
            return TFFeature.lichTower;
        }
        if ((regionOffsetX == 5 && regionOffsetZ == 4) || (regionOffsetX == 3 && regionOffsetZ == 4)) {
            return TFFeature.nagaCourtyard;
        }
        switch (randnum) {
            default: {
                return TFFeature.hill1;
            }
            case 6:
            case 7:
            case 8: {
                return TFFeature.hill2;
            }
            case 9: {
                return TFFeature.hill3;
            }
            case 10:
            case 11: {
                return TFFeature.hedgeMaze;
            }
            case 12:
            case 13: {
                return TFFeature.nagaCourtyard;
            }
            case 14:
            case 15: {
                return TFFeature.lichTower;
            }
        }
    }
    
    public static TFFeature generateFeaturePreset5x5(final int chunkX, final int chunkZ, final World world) {
        final int cf = 16;
        if (chunkX % cf != 0 || chunkZ % cf != 0) {
            return TFFeature.nothing;
        }
        final int mx = chunkX / cf + 4;
        final int mz = chunkZ / cf + 4;
        final int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 19, 18, 8, 15, 14, 0 }, { 0, 0, 18, 18, 2, 3, 15, 0 }, { 0, 0, 4, 4, 5, 16, 9, 0 }, { 0, 0, 13, 6, 1, 2, 17, 0 }, { 0, 0, 12, 13, 3, 17, 7, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
        if (mx >= 0 && mx < 8 && mz >= 0 && mz < 8) {
            return TFFeature.featureList[map[mz][mx]];
        }
        return TFFeature.nothing;
    }
    
    public static TFFeature generateFeaturePreset6x6(final int chunkX, final int chunkZ, final World world) {
        final int cf = 16;
        if (chunkX % cf != 0 || chunkZ % cf != 0) {
            return TFFeature.nothing;
        }
        final int mx = chunkX / cf + 3;
        final int mz = chunkZ / cf + 3;
        final int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 19, 19, 18, 15, 0, 0, 0 }, { 0, 18, 18, 18, 0, 14, 0, 0 }, { 0, 0, 4, 1, 2, 3, 15, 0 }, { 0, 4, 1, 5, 16, 9, 17, 0 }, { 0, 0, 13, 2, 3, 17, 17, 0 }, { 0, 0, 12, 13, 6, 17, 7, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
        if (mx >= 0 && mx < 8 && mz >= 0 && mz < 8) {
            return TFFeature.featureList[map[mz][mx]];
        }
        return TFFeature.nothing;
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final World world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    final TFFeature directlyAt = getFeatureDirectlyAt(x + cx, z + cz, world);
                    if (directlyAt.size == rad) {
                        return directlyAt;
                    }
                }
            }
        }
        return TFFeature.nothing;
    }
    
    public static TFFeature getFeatureForRegion(final int chunkX, final int chunkZ, final World world) {
        final int featureX = Math.round(chunkX / 16.0f) * 16;
        final int featureZ = Math.round(chunkZ / 16.0f) * 16;
        return generateFeatureFor1Point7(featureX, featureZ, world);
    }
    
    public static int[] getNearestCenter(final int cx, final int cz, final World world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    if (getFeatureDirectlyAt(x + cx, z + cz, world).size == rad) {
                        final int[] center = { x * 16 + 8, z * 16 + 8 };
                        return center;
                    }
                }
            }
        }
        final int[] no = { 0, 0 };
        return no;
    }
    
    public static ChunkCoordinates getNearestCenterXYZ(final int cx, final int cz, final World world) {
        if (TwilightForestMod.oldMapGen) {
            return getNearestCenterXYZOld(cx, cz, world);
        }
        final int chunkX = cx;
        final int chunkZ = cz;
        final int regionX = chunkX + 8 >> 4;
        final int regionZ = chunkZ + 8 >> 4;
        long seed = (long)(regionX * 3129871) ^ regionZ * 116129781L;
        seed = seed * seed * 42317861L + seed * 7L;
        final int num0 = (int)(seed >> 12 & 0x3L);
        final int num2 = (int)(seed >> 15 & 0x3L);
        final int num3 = (int)(seed >> 18 & 0x3L);
        final int num4 = (int)(seed >> 21 & 0x3L);
        final int centerX = 8 + num0 - num2;
        final int centerZ = 8 + num3 - num4;
        int ccz;
        if (regionZ >= 0) {
            ccz = (regionZ * 16 + centerZ - 8) * 16 + 8;
        }
        else {
            ccz = (regionZ * 16 + (16 - centerZ) - 8) * 16 + 9;
        }
        int ccx;
        if (regionX >= 0) {
            ccx = (regionX * 16 + centerX - 8) * 16 + 8;
        }
        else {
            ccx = (regionX * 16 + (16 - centerX) - 8) * 16 + 9;
        }
        return new ChunkCoordinates(ccx, TFWorld.SEALEVEL, ccz);
    }
    
    private static ChunkCoordinates getNearestCenterXYZOld(final int cx, final int cz, final World world) {
        final int fx = (int)(Math.round(cx / 256.0) * 256L + 8L);
        final int fz = (int)(Math.round(cz / 256.0) * 256L + 8L);
        return new ChunkCoordinates(fx, TFWorld.SEALEVEL, fz);
    }
    
    public List<BiomeGenBase.SpawnListEntry> getSpawnableList(final EnumCreatureType par1EnumCreatureType) {
        if (par1EnumCreatureType == EnumCreatureType.monster) {
            return this.getSpawnableList(EnumCreatureType.monster, 0);
        }
        if (par1EnumCreatureType == EnumCreatureType.ambient) {
            return this.ambientCreatureList;
        }
        if (par1EnumCreatureType == EnumCreatureType.waterCreature) {
            return this.waterCreatureList;
        }
        return this.emptyList;
    }
    
    public List<BiomeGenBase.SpawnListEntry> getSpawnableList(final EnumCreatureType par1EnumCreatureType, final int index) {
        if (par1EnumCreatureType != EnumCreatureType.monster) {
            return this.getSpawnableList(par1EnumCreatureType);
        }
        if (index >= 0 && index < this.spawnableMonsterLists.size()) {
            return this.spawnableMonsterLists.get(index);
        }
        return this.emptyList;
    }
    
    private TFFeature setRequiredAchievement(final Achievement required) {
        this.requiredAchievement = required;
        return this;
    }
    
    public boolean doesPlayerHaveRequiredAchievement(final EntityPlayer player) {
        if (this.requiredAchievement == null) {
            return true;
        }
        if (player instanceof EntityPlayerMP && ((EntityPlayerMP)player).func_147099_x() != null) {
            final StatisticsFile stats = ((EntityPlayerMP)player).func_147099_x();
            return stats.func_77443_a(this.requiredAchievement);
        }
        return false;
    }
    
    static {
        featureList = new TFFeature[256];
        nothing = new TFFeature(0, 0, "No Feature").enableDecorations().disableStructure();
        hill1 = new TFFeature(1, 1, "Small Hollow Hill").enableDecorations().enableTerrainAlterations();
        hill2 = new TFFeature(2, 2, "Medium Hollow Hill").enableDecorations().enableTerrainAlterations();
        hill3 = new TFFeature(3, 3, "Large Hollow Hill").enableDecorations().enableTerrainAlterations();
        hedgeMaze = new TFFeature(4, 2, "Hedge Maze").enableTerrainAlterations();
        nagaCourtyard = new TFFeature(5, 3, "Naga Courtyard").enableTerrainAlterations();
        lichTower = new TFFeature(6, 1, "Lich Tower").setRequiredAchievement(TFAchievementPage.twilightKillNaga);
        iceTower = new TFFeature(7, 2, "Ice Tower");
        questIsland = new TFFeature(8, 1, "Quest Island").disableStructure();
        questGrove = new TFFeature(9, 1, "Quest Grove").enableTerrainAlterations();
        druidGrove = new TFFeature(10, 1, "Druid Grove").disableStructure();
        floatRuins = new TFFeature(11, 3, "Floating Ruins").disableStructure();
        hydraLair = new TFFeature(12, 2, "Hydra Lair").enableTerrainAlterations();
        labyrinth = new TFFeature(13, 3, "Labyrinth").enableDecorations().setRequiredAchievement(TFAchievementPage.twilightKillLich);
        darkTower = new TFFeature(14, 1, "Dark Tower").setRequiredAchievement(TFAchievementPage.twilightProgressKnights);
        tfStronghold = new TFFeature(15, 3, "Knight Stronghold").enableDecorations().setRequiredAchievement(TFAchievementPage.twilightProgressTrophyPedestal);
        worldTree = new TFFeature(16, 3, "World Tree").disableStructure();
        yetiCave = new TFFeature(17, 2, "Yeti Lairs").enableDecorations().enableTerrainAlterations();
        trollCave = new TFFeature(18, 3, "Troll Lairs").enableDecorations().disableStructure();
        finalCastle = new TFFeature(19, 2, "Final Castle").disableStructure();
        mushroomTower = new TFFeature(20, 2, "Mushroom Tower");
        TFFeature.lichTower.addMonster((Class<? extends EntityLivingBase>)EntityZombie.class, 10, 4, 4);
        TFFeature.lichTower.addMonster((Class<? extends EntityLivingBase>)EntitySkeleton.class, 10, 4, 4);
        TFFeature.lichTower.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 1, 4, 4);
        TFFeature.lichTower.addMonster((Class<? extends EntityLivingBase>)EntityEnderman.class, 1, 1, 4);
        TFFeature.lichTower.addMonster((Class<? extends EntityLivingBase>)EntityTFDeathTome.class, 10, 4, 4);
        TFFeature.lichTower.addMonster((Class<? extends EntityLivingBase>)EntityWitch.class, 1, 1, 1);
        TFFeature.hill1.addMonster((Class<? extends EntityLivingBase>)EntitySpider.class, 10, 4, 4);
        TFFeature.hill1.addMonster((Class<? extends EntityLivingBase>)EntityZombie.class, 10, 4, 4);
        TFFeature.hill1.addMonster((Class<? extends EntityLivingBase>)EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill1.addMonster((Class<? extends EntityLivingBase>)EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill1.addMonster((Class<? extends EntityLivingBase>)EntityTFKobold.class, 10, 4, 8);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityTFRedcapSapper.class, 1, 1, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityTFKobold.class, 10, 4, 8);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntitySkeleton.class, 10, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntitySpider.class, 10, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 10, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityTFFireBeetle.class, 5, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityTFSlimeBeetle.class, 5, 4, 4);
        TFFeature.hill2.addMonster((Class<? extends EntityLivingBase>)EntityWitch.class, 1, 1, 1);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityTFRedcapSapper.class, 2, 1, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntitySkeleton.class, 10, 4, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityCaveSpider.class, 10, 4, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 10, 4, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityEnderman.class, 1, 1, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityTFWraith.class, 2, 1, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityTFFireBeetle.class, 10, 4, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.hill3.addMonster((Class<? extends EntityLivingBase>)EntityWitch.class, 1, 1, 1);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityTFMinotaur.class, 20, 2, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityCaveSpider.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityTFMazeSlime.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityEnderman.class, 1, 1, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityTFFireBeetle.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster((Class<? extends EntityLivingBase>)EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityTFTowerGolem.class, 10, 4, 4);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntitySkeleton.class, 10, 4, 4);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 10, 4, 4);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityEnderman.class, 2, 1, 4);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityWitch.class, 1, 1, 1);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityTFMiniGhast.class, 10, 1, 4);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityTFTowerBroodling.class, 10, 8, 8);
        TFFeature.darkTower.addMonster((Class<? extends EntityLivingBase>)EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.darkTower.addMonster(1, (Class<? extends EntityLivingBase>)EntityTFTowerGhast.class, 10, 1, 4);
        TFFeature.darkTower.addWaterCreature((Class<? extends EntityLivingBase>)EntitySquid.class, 10, 4, 4);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityTFBlockGoblin.class, 10, 4, 4);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityTFGoblinKnightLower.class, 5, 1, 2);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityTFHelmetCrab.class, 10, 4, 4);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityTFRedcapSapper.class, 2, 1, 4);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityTFKobold.class, 10, 4, 8);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 10, 4, 4);
        TFFeature.tfStronghold.addMonster((Class<? extends EntityLivingBase>)EntitySlime.class, 5, 4, 4);
        TFFeature.yetiCave.addMonster((Class<? extends EntityLivingBase>)EntityTFYeti.class, 10, 4, 4);
        TFFeature.iceTower.addMonster((Class<? extends EntityLivingBase>)EntityTFSnowGuardian.class, 10, 4, 4);
        TFFeature.iceTower.addMonster((Class<? extends EntityLivingBase>)EntityTFDeathTome.class, 10, 4, 4);
        TFFeature.iceTower.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 2, 4, 4);
        TFFeature.trollCave.addMonster((Class<? extends EntityLivingBase>)EntityCreeper.class, 2, 4, 4);
        TFFeature.trollCave.addMonster((Class<? extends EntityLivingBase>)EntitySkeleton.class, 10, 4, 4);
        TFFeature.trollCave.addMonster((Class<? extends EntityLivingBase>)EntityTFTroll.class, 10, 4, 4);
    }
}
