// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Iterator;
import twilightforest.world.TFWorldChunkManager;
import java.util.List;
import twilightforest.world.TFWorld;
import java.util.Random;
import twilightforest.TFFeature;

public class StructureTFMajorFeatureStart extends afb
{
    public TFFeature feature;
    
    public StructureTFMajorFeatureStart(final yc world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        this.feature = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, world);
        final aez firstComponent = this.makeFirstComponent(world, rand, this.feature, x, y, z);
        if (firstComponent != null) {
            this.a.add(firstComponent);
            firstComponent.a(firstComponent, (List)this.a, rand);
        }
        this.c();
        if (firstComponent instanceof ComponentTFTowerMain || firstComponent instanceof ComponentTFDarkTowerMain) {
            this.moveToAvgGroundLevel(world, x, z);
        }
    }
    
    public aez makeFirstComponent(final yc world, final Random rand, final TFFeature feature, final int x, final int y, final int z) {
        if (feature == TFFeature.nagaLair) {
            return new ComponentTFNagaCourtyard(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.hedgeMaze) {
            return new ComponentTFHedgeMaze(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.hill1) {
            return new ComponentTFHollowHill(world, rand, 0, 1, x, y, z);
        }
        if (feature == TFFeature.hill2) {
            return new ComponentTFHollowHill(world, rand, 0, 2, x, y, z);
        }
        if (feature == TFFeature.hill3) {
            return new ComponentTFHollowHill(world, rand, 0, 3, x, y, z);
        }
        if (feature == TFFeature.wizardTower) {
            return new ComponentTFTowerMain(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.questGrove) {
            return new ComponentTFQuestGrove(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.hydraLair) {
            return new ComponentTFHydraLair(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.labyrinth) {
            return new ComponentTFMazeRuins(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.darkTower) {
            return new ComponentTFDarkTowerMain(world, rand, 0, x, y, z);
        }
        return null;
    }
    
    public boolean d() {
        return this.feature.structureEnabled;
    }
    
    protected void moveToAvgGroundLevel(final yc world, final int x, final int z) {
        if (world.t() instanceof TFWorldChunkManager) {
            final yy biomeAt = world.a(x, z);
            final int offY = (int)((biomeAt.D + biomeAt.E) * 8.0f);
            if (offY > 0) {
                this.b.a(0, offY, 0);
                for (final aez com : this.b()) {
                    com.b().a(0, offY, 0);
                }
            }
        }
    }
}
