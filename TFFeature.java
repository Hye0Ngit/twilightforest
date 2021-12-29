import java.util.Random;
import java.util.ArrayList;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

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
    public int featureID;
    public int size;
    public String name;
    public boolean chunkDecorationsEnabled;
    protected List spawnableMonsterList;
    
    public TFFeature(final int parID, final int parSize, final String parName) {
        this.featureID = parID;
        this.size = parSize;
        this.name = parName;
        this.chunkDecorationsEnabled = false;
        this.spawnableMonsterList = new ArrayList();
    }
    
    public TFFeature enableDecorations() {
        this.chunkDecorationsEnabled = true;
        return this;
    }
    
    public TFFeature addMonster(final Class monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.spawnableMonsterList.add(new bw(monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final ge world) {
        if (!(world.a() instanceof TFWorldChunkManager)) {
            return TFFeature.nothing;
        }
        if (!((TFWorldChunkManager)world.a()).isInFeatureChunk(chunkX << 4, chunkZ << 4)) {
            return TFFeature.nothing;
        }
        final lt biomeAt = world.a().a(chunkX << 12, chunkZ << 12);
        final Random hillRNG = new Random(world.n() + chunkX * 25117 + chunkZ * 151121);
        final int randnum = hillRNG.nextInt(16);
        if (biomeAt == TFBiomeBase.glacier && randnum % 2 == 0) {
            return TFFeature.glacierMaze;
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
                return (biomeAt != TFBiomeBase.glacier) ? TFFeature.hedgeMaze : TFFeature.nothing;
            }
            case 13: {
                return (biomeAt != TFBiomeBase.glacier && biomeAt != TFBiomeBase.tfLake) ? TFFeature.nagaLair : TFFeature.nothing;
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
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final ge world) {
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
    
    public static int[] getNearestCenter(final int cx, final int cz, final ge world) {
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
    
    public List getSpawnableList(final mu par1EnumCreatureType) {
        return this.spawnableMonsterList;
    }
    
    static {
        nothing = new TFFeature(0, 0, "No Feature").enableDecorations();
        hill1 = new TFFeature(1, 1, "Small Hollow Hill").enableDecorations();
        hill2 = new TFFeature(2, 2, "Medium Hollow Hill").enableDecorations();
        hill3 = new TFFeature(3, 3, "Large Hollow Hill").enableDecorations();
        hedgeMaze = new TFFeature(4, 2, "Hedge Maze");
        nagaLair = new TFFeature(5, 3, "Naga Courtyard");
        wizardTower = new TFFeature(6, 1, "Wizard Tower");
        glacierMaze = new TFFeature(7, 2, "Glacier Maze");
        TFFeature.wizardTower.addMonster(dg.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(wl.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(hc.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(hn.class, 1, 4, 4);
        TFFeature.wizardTower.addMonster(wa.class, 10, 4, 4);
        TFFeature.wizardTower.addMonster(oa.class, 1, 1, 4);
        TFFeature.hill1.addMonster(dg.class, 10, 4, 4);
        TFFeature.hill1.addMonster(wl.class, 10, 4, 4);
        TFFeature.hill1.addMonster(yg.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill1.addMonster(EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill2.addMonster(EntityTFRedcap.class, 10, 4, 4);
        TFFeature.hill2.addMonster(wl.class, 10, 4, 4);
        TFFeature.hill2.addMonster(hc.class, 10, 4, 4);
        TFFeature.hill2.addMonster(EntityTFSwarmSpider.class, 10, 4, 4);
        TFFeature.hill2.addMonster(iu.class, 10, 4, 4);
        TFFeature.hill2.addMonster(hn.class, 10, 4, 4);
        TFFeature.hill3.addMonster(wl.class, 10, 4, 4);
        TFFeature.hill3.addMonster(hc.class, 10, 4, 4);
        TFFeature.hill3.addMonster(iu.class, 10, 4, 4);
        TFFeature.hill3.addMonster(hn.class, 10, 4, 4);
        TFFeature.hill3.addMonster(wa.class, 10, 4, 4);
        TFFeature.hill3.addMonster(oa.class, 1, 1, 4);
        TFFeature.hill3.addMonster(EntityTFWraith.class, 1, 1, 4);
    }
}
