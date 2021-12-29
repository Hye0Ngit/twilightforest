// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.EntityTFRedcapSapper;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.world.TFWorld;
import twilightforest.biomes.TFBiomeBase;
import java.util.Random;
import twilightforest.world.TFWorldChunkManager;
import java.util.List;
import java.util.ArrayList;

public class TFFeature
{
    public static final TFFeature[] featureList;
    public static final TFFeature nothing;
    public static final TFFeature hill1;
    public static final TFFeature hill2;
    public static final TFFeature hill3;
    public static final TFFeature hedgeMaze;
    public static final TFFeature nagaLair;
    public static final TFFeature wizardTower;
    public static final TFFeature glacierMaze;
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
    public static final TFFeature underground;
    ArrayList emptyList;
    public int featureID;
    public int size;
    public String name;
    public boolean chunkDecorationsEnabled;
    public boolean structureEnabled;
    protected List spawnableMonsterLists;
    protected List ambientCreatureList;
    protected List waterCreatureList;
    
    public TFFeature(final int parID, final int parSize, final String parName) {
        this.emptyList = new ArrayList();
        this.featureID = parID;
        TFFeature.featureList[parID] = this;
        this.size = parSize;
        this.name = parName;
        this.chunkDecorationsEnabled = false;
        this.structureEnabled = true;
        this.spawnableMonsterLists = new ArrayList();
        this.ambientCreatureList = new ArrayList();
        this.waterCreatureList = new ArrayList();
        this.ambientCreatureList.add(new aaq((Class)qa.class, 10, 8, 8));
    }
    
    public TFFeature enableDecorations() {
        this.chunkDecorationsEnabled = true;
        return this;
    }
    
    public TFFeature disableStructure() {
        this.structureEnabled = false;
        return this;
    }
    
    public TFFeature addMonster(final Class monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.addMonster(0, monsterClass, weight, minGroup, maxGroup);
        return this;
    }
    
    public TFFeature addMonster(final int listIndex, final Class monsterClass, final int weight, final int minGroup, final int maxGroup) {
        List monsterList;
        if (this.spawnableMonsterLists.size() > listIndex) {
            monsterList = this.spawnableMonsterLists.get(listIndex);
        }
        else {
            monsterList = new ArrayList();
            this.spawnableMonsterLists.add(listIndex, monsterList);
        }
        monsterList.add(new aaq(monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public TFFeature addWaterCreature(final Class monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.waterCreatureList.add(new aaq(monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final zv world) {
        if (world == null || !(world.t() instanceof TFWorldChunkManager)) {
            return TFFeature.nothing;
        }
        final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.t();
        if (tfManager.isInFeatureChunk(chunkX << 4, chunkZ << 4)) {
            return tfManager.getFeatureAt(chunkX << 4, chunkZ << 4, world);
        }
        return TFFeature.nothing;
    }
    
    public static TFFeature generateFeatureFor(final int chunkX, final int chunkZ, final zv world) {
        final aap biomeAt = world.a((chunkX << 4) + 8, (chunkZ << 4) + 8);
        final Random hillRNG = new Random(world.F() + chunkX * 25117 + chunkZ * 151121);
        final int randnum = hillRNG.nextInt(16);
        if (biomeAt == TFBiomeBase.glacier) {
            return TFFeature.glacierMaze;
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
        if (biomeAt == TFBiomeBase.clearing || biomeAt == TFBiomeBase.clearingBorder) {
            return TFFeature.labyrinth;
        }
        if (biomeAt == TFBiomeBase.darkForest) {
            switch (randnum % 3) {
                case 1: {
                    return TFFeature.darkTower;
                }
            }
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
                return (biomeAt != TFBiomeBase.swamp) ? TFFeature.nagaLair : TFFeature.hydraLair;
            }
            case 14:
            case 15: {
                return TFFeature.wizardTower;
            }
        }
    }
    
    public static TFFeature generateFeaturePreset5x5(final int chunkX, final int chunkZ, final zv world) {
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
    
    public static TFFeature generateFeaturePreset6x6(final int chunkX, final int chunkZ, final zv world) {
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
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final zv world) {
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
    
    public static TFFeature getNearestFeatureIncludeMore(final int chunkX, final int chunkZ, final zv world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    final TFFeature directlyAt = getFeatureDirectlyAt(x + chunkX, z + chunkZ, world);
                    if (directlyAt != TFFeature.nothing) {
                        return directlyAt;
                    }
                }
            }
        }
        return TFFeature.nothing;
    }
    
    public static int[] getNearestCenter(final int cx, final int cz, final zv world) {
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
    
    public static t getNearestCenterXYZ(final int cx, final int cz, final zv world) {
        final int fx = (int)(Math.round(cx / 256.0) * 256L + 8L);
        final int fz = (int)(Math.round(cz / 256.0) * 256L + 8L);
        return new t(fx, TFWorld.SEALEVEL, fz);
    }
    
    public List getSpawnableList(final nh par1EnumCreatureType) {
        if (par1EnumCreatureType == nh.a) {
            return this.getSpawnableList(nh.a, 0);
        }
        if (par1EnumCreatureType == nh.c) {
            return this.ambientCreatureList;
        }
        if (par1EnumCreatureType == nh.d) {
            return this.waterCreatureList;
        }
        return this.emptyList;
    }
    
    public List getSpawnableList(final nh par1EnumCreatureType, final int index) {
        if (par1EnumCreatureType != nh.a) {
            return this.getSpawnableList(par1EnumCreatureType);
        }
        if (index >= 0 && index < this.spawnableMonsterLists.size()) {
            return this.spawnableMonsterLists.get(index);
        }
        return this.emptyList;
    }
    
    static {
        featureList = new TFFeature[256];
        nothing = new TFFeature(0, 0, "No Feature").enableDecorations().disableStructure();
        hill1 = new TFFeature(1, 1, "Small Hollow Hill").enableDecorations();
        hill2 = new TFFeature(2, 2, "Medium Hollow Hill").enableDecorations();
        hill3 = new TFFeature(3, 3, "Large Hollow Hill").enableDecorations();
        hedgeMaze = new TFFeature(4, 2, "Hedge Maze");
        nagaLair = new TFFeature(5, 3, "Naga Courtyard");
        wizardTower = new TFFeature(6, 1, "Wizard Tower");
        glacierMaze = new TFFeature(7, 2, "Glacier Maze").disableStructure();
        questIsland = new TFFeature(8, 1, "Quest Island").disableStructure();
        questGrove = new TFFeature(9, 1, "Quest Grove");
        druidGrove = new TFFeature(10, 1, "Druid Grove").disableStructure();
        floatRuins = new TFFeature(11, 3, "Floating Ruins").disableStructure();
        hydraLair = new TFFeature(12, 2, "Hydra Lair");
        labyrinth = new TFFeature(13, 3, "Labyrinth").enableDecorations();
        darkTower = new TFFeature(14, 1, "Dark Tower");
        tfStronghold = new TFFeature(15, 3, "Knight Stronghold").enableDecorations();
        worldTree = new TFFeature(16, 3, "World Tree").disableStructure();
        yetiCave = new TFFeature(17, 2, "Yeti Lairs").disableStructure().enableDecorations();
        trollCave = new TFFeature(18, 2, "Troll Lairs").disableStructure().enableDecorations();
        finalCastle = new TFFeature(19, 2, "Final Castle").disableStructure();
        underground = new TFFeature(255, 0, "Underground");
        TFFeature.wizardTower.addMonster(sd.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(rz.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(ro.class, 1, 4, 4);
        TFFeature.wizardTower.addMonster(rp.class, 1, 1, 4);
        TFFeature.wizardTower.addMonster(EntityTFDeathTome.class, 10, 4, 4);
        TFFeature.hill1.addMonster(sb.class, 10, 4, 4);
        TFFeature.hill1.addMonster(sd.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFKobold.class, 10, 4, 8);
        TFFeature.hill2.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFRedcapSapper.class, 1, 1, 4);
        TFFeature.hill2.addMonster(EntityTFKobold.class, 10, 4, 8);
        TFFeature.hill2.addMonster(rz.class, 10, 4, 4);
        TFFeature.hill2.addMonster(EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill2.addMonster(sb.class, 10, 4, 4);
        TFFeature.hill2.addMonster(ro.class, 10, 4, 4);
        TFFeature.hill2.addMonster(EntityTFFireBeetle.class, 5, 4, 4);
        TFFeature.hill3.addMonster(EntityTFSlimeBeetle.class, 5, 4, 4);
        TFFeature.hill3.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFRedcapSapper.class, 2, 1, 4);
        TFFeature.hill3.addMonster(rz.class, 10, 4, 4);
        TFFeature.hill3.addMonster(rn.class, 10, 4, 4);
        TFFeature.hill3.addMonster(ro.class, 10, 4, 4);
        TFFeature.hill3.addMonster(rp.class, 1, 1, 4);
        TFFeature.hill3.addMonster(EntityTFWraith.class, 2, 1, 4);
        TFFeature.hill3.addMonster(EntityTFFireBeetle.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.labyrinth.addMonster(EntityTFMinotaur.class, 20, 2, 4);
        TFFeature.labyrinth.addMonster(rn.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(ro.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(EntityTFMazeSlime.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(rp.class, 1, 1, 4);
        TFFeature.labyrinth.addMonster(EntityTFFireBeetle.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.underground.addMonster(sb.class, 10, 4, 4);
        TFFeature.underground.addMonster(sd.class, 10, 4, 4);
        TFFeature.underground.addMonster(rz.class, 10, 4, 4);
        TFFeature.underground.addMonster(ro.class, 1, 4, 4);
        TFFeature.underground.addMonster(sa.class, 10, 4, 4);
        TFFeature.underground.addMonster(rp.class, 1, 1, 4);
        TFFeature.underground.addMonster(EntityTFKobold.class, 10, 4, 8);
        TFFeature.darkTower.addMonster(EntityTFTowerGolem.class, 10, 4, 4);
        TFFeature.darkTower.addMonster(rz.class, 10, 4, 4);
        TFFeature.darkTower.addMonster(ro.class, 10, 4, 4);
        TFFeature.darkTower.addMonster(rp.class, 2, 1, 4);
        TFFeature.darkTower.addMonster(EntityTFMiniGhast.class, 10, 1, 4);
        TFFeature.darkTower.addMonster(EntityTFTowerBroodling.class, 10, 8, 8);
        TFFeature.darkTower.addMonster(EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.darkTower.addMonster(1, EntityTFTowerGhast.class, 10, 1, 4);
        TFFeature.darkTower.addWaterCreature(ql.class, 10, 4, 4);
    }
}
