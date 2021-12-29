// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.ArrayList;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.structures.stronghold.ComponentTFStrongholdEntrance;
import java.util.Iterator;
import twilightforest.structures.darktower.ComponentTFDarkTowerMain;
import java.util.List;
import twilightforest.world.TFWorld;
import java.util.Random;
import twilightforest.TFFeature;

public class StructureTFMajorFeatureStart extends ais
{
    public TFFeature feature;
    
    public StructureTFMajorFeatureStart(final abv world, final Random rand, final int chunkX, final int chunkZ) {
        ahr.a();
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        this.feature = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, world);
        final aiq firstComponent = this.makeFirstComponent(world, rand, this.feature, x, y, z);
        if (firstComponent != null) {
            this.a.add(firstComponent);
            firstComponent.a(firstComponent, (List)this.a, rand);
        }
        this.c();
        if (firstComponent instanceof aih) {
            final List var6 = ((aih)firstComponent).c;
            while (!var6.isEmpty()) {
                final int var7 = rand.nextInt(var6.size());
                final aiq var8 = var6.remove(var7);
                var8.a(firstComponent, (List)this.a, rand);
            }
            this.c();
            final int offY = -33;
            this.b.a(0, offY, 0);
            for (final aiq com : this.b()) {
                com.b().a(0, offY, 0);
            }
        }
        if (firstComponent instanceof ComponentTFTowerMain || firstComponent instanceof ComponentTFDarkTowerMain) {
            this.moveToAvgGroundLevel(world, x, z);
        }
    }
    
    public aiq makeFirstComponent(final abv world, final Random rand, final TFFeature feature, final int x, final int y, final int z) {
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
            return new ComponentTFStrongholdEntrance(world, rand, 0, x, y, z);
        }
        return null;
    }
    
    public boolean d() {
        return this.feature.structureEnabled;
    }
    
    protected void moveToAvgGroundLevel(final abv world, final int x, final int z) {
        if (world.u() instanceof TFWorldChunkManager) {
            final acp biomeAt = world.a(x, z);
            int offY = (int)((biomeAt.D + biomeAt.E) * 8.0f);
            if (biomeAt == TFBiomeBase.darkForest) {
                offY += 4;
            }
            if (offY > 0) {
                this.b.a(0, offY, 0);
                for (final aiq com : this.b()) {
                    com.b().a(0, offY, 0);
                }
            }
        }
    }
    
    public void a(final abv par1World, final Random par2Random, final age par3StructureBoundingBox) {
        if (this.b().getFirst() instanceof ComponentTFStrongholdEntrance) {
            for (final aiq component : this.b()) {
                if (this.isShieldable(component)) {
                    if (!this.isIntersectingLarger(par3StructureBoundingBox, component)) {
                        continue;
                    }
                }
                else if (!this.isIntersectingLarger(par3StructureBoundingBox, component)) {
                    continue;
                }
                if (this.isShieldable(component)) {
                    this.addShieldFor(par1World, component, this.b(), par3StructureBoundingBox);
                }
                component.a(par1World, par2Random, par3StructureBoundingBox);
            }
        }
        else {
            super.a(par1World, par2Random, par3StructureBoundingBox);
        }
    }
    
    private boolean isIntersectingLarger(final age chunkBB, final aiq component) {
        final age compBB = component.b();
        return compBB.d + 1 >= chunkBB.a && compBB.a - 1 <= chunkBB.d && compBB.f + 1 >= chunkBB.c && compBB.c - 1 <= chunkBB.f;
    }
    
    private boolean isShieldable(final aiq component) {
        return component.b().e <= 32;
    }
    
    private void addShieldFor(final abv world, final aiq component, final List<aiq> otherComponents, final age chunkBox) {
        final age age;
        final age shieldBox = age = new age(component.b());
        --age.a;
        final age age2 = shieldBox;
        --age2.b;
        final age age3 = shieldBox;
        --age3.c;
        final age age4 = shieldBox;
        ++age4.d;
        final age age5 = shieldBox;
        ++age5.e;
        final age age6 = shieldBox;
        ++age6.f;
        final ArrayList<aiq> intersecting = new ArrayList<aiq>();
        for (final aiq other : otherComponents) {
            if (other != component && shieldBox.a(other.b())) {
                intersecting.add(other);
            }
        }
        for (int x = shieldBox.a; x <= shieldBox.d; ++x) {
            for (int y = shieldBox.b; y <= shieldBox.e; ++y) {
                for (int z = shieldBox.c; z <= shieldBox.f; ++z) {
                    if ((x == shieldBox.a || x == shieldBox.d || y == shieldBox.b || y == shieldBox.e || z == shieldBox.c || z == shieldBox.f) && chunkBox.b(x, y, z)) {
                        boolean notIntersecting = true;
                        for (final aiq other2 : intersecting) {
                            if (other2.b().b(x, y, z)) {
                                notIntersecting = false;
                            }
                        }
                        if (notIntersecting) {
                            world.f(x, y, z, TFBlocks.shield.cF, this.calculateShieldMeta(shieldBox, x, y, z), 2);
                        }
                    }
                }
            }
        }
    }
    
    private int calculateShieldMeta(final age shieldBox, final int x, final int y, final int z) {
        int shieldMeta = 0;
        if (x == shieldBox.a) {
            shieldMeta = 5;
        }
        if (x == shieldBox.d) {
            shieldMeta = 4;
        }
        if (z == shieldBox.c) {
            shieldMeta = 3;
        }
        if (z == shieldBox.f) {
            shieldMeta = 2;
        }
        if (y == shieldBox.b) {
            shieldMeta = 1;
        }
        if (y == shieldBox.e) {
            shieldMeta = 0;
        }
        return shieldMeta;
    }
}
