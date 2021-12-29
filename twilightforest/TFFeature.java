// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

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
import java.util.ArrayList;
import java.util.List;

public class TFFeature
{
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
    public static final TFFeature underground;
    public int featureID;
    public int size;
    public String name;
    public boolean chunkDecorationsEnabled;
    public boolean structureEnabled;
    protected List spawnableMonsterList;
    protected List ambientMonsterList;
    
    public TFFeature(final int parID, final int parSize, final String parName) {
        this.featureID = parID;
        this.size = parSize;
        this.name = parName;
        this.chunkDecorationsEnabled = false;
        this.structureEnabled = true;
        this.spawnableMonsterList = new ArrayList();
        (this.ambientMonsterList = new ArrayList()).add(new yz((Class)ow.class, 10, 8, 8));
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
        this.spawnableMonsterList.add(new yz(monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final yc world) {
        if (world == null || !(world.t() instanceof TFWorldChunkManager)) {
            return TFFeature.nothing;
        }
        final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.t();
        if (tfManager.isInFeatureChunk(chunkX << 4, chunkZ << 4)) {
            return generateFeatureFor(chunkX, chunkZ, world);
        }
        return TFFeature.nothing;
    }
    
    public static TFFeature generateFeatureFor(final int chunkX, final int chunkZ, final yc world) {
        final yy biomeAt = world.a((chunkX << 4) + 8, (chunkZ << 4) + 8);
        final Random hillRNG = new Random(world.E() + chunkX * 25117 + chunkZ * 151121);
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
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
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
            default: {
                return TFFeature.nothing;
            }
        }
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final yc world) {
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
    
    public static int[] getNearestCenter(final int cx, final int cz, final yc world) {
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
    
    public static s getNearestCenterXYZ(final int cx, final int cz, final yc world) {
        final int fx = cx / 256 * 256 + 8;
        final int fz = cz / 256 * 256 + 8;
        return new s(fx, TFWorld.SEALEVEL, fz);
    }
    
    public List getSpawnableList(final me par1EnumCreatureType) {
        if (par1EnumCreatureType == me.a) {
            return this.spawnableMonsterList;
        }
        if (par1EnumCreatureType == me.c) {
            return this.ambientMonsterList;
        }
        return null;
    }
    
    static {
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
        tfStronghold = new TFFeature(15, 3, "Knight Stronghold").disableStructure();
        underground = new TFFeature(255, 0, "Underground");
        TFFeature.wizardTower.addMonster(qr.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(qn.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(qc.class, 1, 4, 4);
        TFFeature.wizardTower.addMonster(qd.class, 1, 1, 4);
        TFFeature.wizardTower.addMonster(EntityTFDeathTome.class, 10, 4, 4);
        TFFeature.hill1.addMonster(qp.class, 10, 4, 4);
        TFFeature.hill1.addMonster(qr.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFKobold.class, 10, 4, 8);
        TFFeature.hill2.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFRedcapSapper.class, 1, 1, 4);
        TFFeature.hill2.addMonster(EntityTFKobold.class, 10, 4, 8);
        TFFeature.hill2.addMonster(qn.class, 10, 4, 4);
        TFFeature.hill2.addMonster(EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill2.addMonster(qp.class, 10, 4, 4);
        TFFeature.hill2.addMonster(qc.class, 10, 4, 4);
        TFFeature.hill2.addMonster(EntityTFFireBeetle.class, 5, 4, 4);
        TFFeature.hill3.addMonster(EntityTFSlimeBeetle.class, 5, 4, 4);
        TFFeature.hill3.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFRedcapSapper.class, 2, 1, 4);
        TFFeature.hill3.addMonster(qn.class, 10, 4, 4);
        TFFeature.hill3.addMonster(qb.class, 10, 4, 4);
        TFFeature.hill3.addMonster(qc.class, 10, 4, 4);
        TFFeature.hill3.addMonster(qd.class, 1, 1, 4);
        TFFeature.hill3.addMonster(EntityTFWraith.class, 2, 1, 4);
        TFFeature.hill3.addMonster(EntityTFFireBeetle.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.hill3.addMonster(EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.labyrinth.addMonster(EntityTFMinotaur.class, 20, 2, 4);
        TFFeature.labyrinth.addMonster(qb.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(qc.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(EntityTFMazeSlime.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(qd.class, 1, 1, 4);
        TFFeature.labyrinth.addMonster(EntityTFFireBeetle.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(EntityTFSlimeBeetle.class, 10, 4, 4);
        TFFeature.labyrinth.addMonster(EntityTFPinchBeetle.class, 10, 2, 4);
        TFFeature.underground.addMonster(qp.class, 10, 4, 4);
        TFFeature.underground.addMonster(qr.class, 10, 4, 4);
        TFFeature.underground.addMonster(qn.class, 10, 4, 4);
        TFFeature.underground.addMonster(qc.class, 1, 4, 4);
        TFFeature.underground.addMonster(qo.class, 10, 4, 4);
        TFFeature.underground.addMonster(qd.class, 1, 1, 4);
        TFFeature.underground.addMonster(EntityTFKobold.class, 10, 4, 8);
        TFFeature.darkTower.addMonster(qr.class, 10, 4, 4);
        TFFeature.darkTower.addMonster(qn.class, 10, 4, 4);
        TFFeature.darkTower.addMonster(qc.class, 1, 4, 4);
        TFFeature.darkTower.addMonster(qd.class, 1, 1, 4);
        TFFeature.darkTower.addMonster(EntityTFDeathTome.class, 10, 4, 4);
    }
}
