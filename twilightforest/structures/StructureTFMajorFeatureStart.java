// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.world.TFWorldChunkManager;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.structures.darktower.ComponentTFDarkTowerMain;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import java.util.List;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureTFMajorFeatureStart extends StructureStart
{
    public TFFeature feature;
    
    public StructureTFMajorFeatureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
        StructureStrongholdPieces.func_75198_a();
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        this.feature = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, world);
        final StructureComponent firstComponent = this.makeFirstComponent(world, rand, this.feature, x, y, z);
        if (firstComponent != null) {
            this.field_75075_a.add(firstComponent);
            firstComponent.func_74861_a(firstComponent, (List)this.field_75075_a, rand);
        }
        this.func_75072_c();
        if (firstComponent instanceof ComponentStrongholdStairs2) {
            final ArrayList var6 = ((ComponentStrongholdStairs2)firstComponent).field_75026_c;
            while (!var6.isEmpty()) {
                final int var7 = rand.nextInt(var6.size());
                final StructureComponent var8 = var6.remove(var7);
                var8.func_74861_a(firstComponent, (List)this.field_75075_a, rand);
            }
            this.func_75072_c();
            final int offY = -33;
            this.field_75074_b.func_78886_a(0, offY, 0);
            for (final StructureComponent com : this.func_75073_b()) {
                com.func_74874_b().func_78886_a(0, offY, 0);
            }
        }
        if (firstComponent instanceof ComponentTFTowerMain || firstComponent instanceof ComponentTFDarkTowerMain) {
            this.moveToAvgGroundLevel(world, x, z);
        }
    }
    
    public StructureComponent makeFirstComponent(final World world, final Random rand, final TFFeature feature, final int x, final int y, final int z) {
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
            return new ComponentTFDarkTowerMain(world, rand, 0, x, y - 1, z);
        }
        if (feature == TFFeature.tfStronghold) {
            return (StructureComponent)new ComponentStrongholdStairs2(0, rand, x + 2, z + 2);
        }
        return null;
    }
    
    public boolean func_75069_d() {
        return this.feature.structureEnabled;
    }
    
    protected void moveToAvgGroundLevel(final World world, final int x, final int z) {
        if (world.func_72959_q() instanceof TFWorldChunkManager) {
            final BiomeGenBase biomeAt = world.func_72807_a(x, z);
            int offY = (int)((biomeAt.field_76748_D + biomeAt.field_76749_E) * 8.0f);
            if (biomeAt == TFBiomeBase.darkForest) {
                offY += 4;
            }
            if (offY > 0) {
                this.field_75074_b.func_78886_a(0, offY, 0);
                for (final StructureComponent com : this.func_75073_b()) {
                    com.func_74874_b().func_78886_a(0, offY, 0);
                }
            }
        }
    }
}
