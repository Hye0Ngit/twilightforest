// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.structures.stronghold.ComponentTFStrongholdEntrance;
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
            return new ComponentTFStrongholdEntrance(world, rand, 0, x, y, z);
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
    
    public void func_75068_a(final World par1World, final Random par2Random, final StructureBoundingBox par3StructureBoundingBox) {
        if (this.func_75073_b().getFirst() instanceof ComponentTFStrongholdEntrance) {
            for (final StructureComponent component : this.func_75073_b()) {
                if (this.isShieldable(component)) {
                    if (!this.isIntersectingLarger(par3StructureBoundingBox, component)) {
                        continue;
                    }
                }
                else if (!this.isIntersectingLarger(par3StructureBoundingBox, component)) {
                    continue;
                }
                if (this.isShieldable(component)) {
                    this.addShieldFor(par1World, component, this.func_75073_b(), par3StructureBoundingBox);
                }
                component.func_74875_a(par1World, par2Random, par3StructureBoundingBox);
            }
        }
        else {
            super.func_75068_a(par1World, par2Random, par3StructureBoundingBox);
        }
    }
    
    private boolean isIntersectingLarger(final StructureBoundingBox chunkBB, final StructureComponent component) {
        final StructureBoundingBox compBB = component.func_74874_b();
        return compBB.field_78893_d + 1 >= chunkBB.field_78897_a && compBB.field_78897_a - 1 <= chunkBB.field_78893_d && compBB.field_78892_f + 1 >= chunkBB.field_78896_c && compBB.field_78896_c - 1 <= chunkBB.field_78892_f;
    }
    
    private boolean isShieldable(final StructureComponent component) {
        return component.func_74874_b().field_78894_e <= 32;
    }
    
    private void addShieldFor(final World world, final StructureComponent component, final List otherComponents, final StructureBoundingBox chunkBox) {
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox shieldBox = structureBoundingBox = new StructureBoundingBox(component.func_74874_b());
        --structureBoundingBox.field_78897_a;
        final StructureBoundingBox structureBoundingBox2 = shieldBox;
        --structureBoundingBox2.field_78895_b;
        final StructureBoundingBox structureBoundingBox3 = shieldBox;
        --structureBoundingBox3.field_78896_c;
        final StructureBoundingBox structureBoundingBox4 = shieldBox;
        ++structureBoundingBox4.field_78893_d;
        final StructureBoundingBox structureBoundingBox5 = shieldBox;
        ++structureBoundingBox5.field_78894_e;
        final StructureBoundingBox structureBoundingBox6 = shieldBox;
        ++structureBoundingBox6.field_78892_f;
        final ArrayList intersecting = new ArrayList();
        for (final StructureComponent other : otherComponents) {
            if (other != component && shieldBox.func_78884_a(other.func_74874_b())) {
                intersecting.add(other);
            }
        }
        for (int x = shieldBox.field_78897_a; x <= shieldBox.field_78893_d; ++x) {
            for (int y = shieldBox.field_78895_b; y <= shieldBox.field_78894_e; ++y) {
                for (int z = shieldBox.field_78896_c; z <= shieldBox.field_78892_f; ++z) {
                    if ((x == shieldBox.field_78897_a || x == shieldBox.field_78893_d || y == shieldBox.field_78895_b || y == shieldBox.field_78894_e || z == shieldBox.field_78896_c || z == shieldBox.field_78892_f) && chunkBox.func_78890_b(x, y, z)) {
                        boolean notIntersecting = true;
                        for (final StructureComponent other2 : intersecting) {
                            if (other2.func_74874_b().func_78890_b(x, y, z)) {
                                notIntersecting = false;
                            }
                        }
                        if (notIntersecting) {
                            world.func_72832_d(x, y, z, TFBlocks.shield.field_71990_ca, this.calculateShieldMeta(shieldBox, x, y, z), 2);
                        }
                    }
                }
            }
        }
    }
    
    private int calculateShieldMeta(final StructureBoundingBox shieldBox, final int x, final int y, final int z) {
        int shieldMeta = 0;
        if (x == shieldBox.field_78897_a) {
            shieldMeta = 5;
        }
        if (x == shieldBox.field_78893_d) {
            shieldMeta = 4;
        }
        if (z == shieldBox.field_78896_c) {
            shieldMeta = 3;
        }
        if (z == shieldBox.field_78892_f) {
            shieldMeta = 2;
        }
        if (y == shieldBox.field_78895_b) {
            shieldMeta = 1;
        }
        if (y == shieldBox.field_78894_e) {
            shieldMeta = 0;
        }
        return shieldMeta;
    }
}
