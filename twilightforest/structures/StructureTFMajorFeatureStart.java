// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.structures.trollcave.TFTrollCavePieces;
import twilightforest.structures.hollowtree.TFHollowTreePieces;
import twilightforest.structures.mushroomtower.TFMushroomTowerPieces;
import twilightforest.structures.icetower.TFIceTowerPieces;
import twilightforest.structures.lichtower.TFLichTowerPieces;
import twilightforest.structures.darktower.TFDarkTowerPieces;
import twilightforest.structures.minotaurmaze.TFMinotaurMazePieces;
import twilightforest.structures.stronghold.TFStrongholdPieces;
import twilightforest.structures.hollowtree.StructureTFHollowTreeStart;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.block.TFBlocks;
import java.util.ArrayList;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.structures.trollcave.ComponentTFTrollCaveMain;
import twilightforest.structures.mushroomtower.ComponentTFMushroomTowerMain;
import twilightforest.structures.icetower.ComponentTFIceTowerMain;
import twilightforest.structures.stronghold.ComponentTFStrongholdEntrance;
import twilightforest.structures.minotaurmaze.ComponentTFMazeRuins;
import java.util.Iterator;
import twilightforest.structures.darktower.ComponentTFDarkTowerMain;
import twilightforest.structures.lichtower.ComponentTFTowerMain;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureTFMajorFeatureStart extends StructureStart
{
    public static int NUM_LOCKS;
    public TFFeature feature;
    public boolean isConquered;
    public byte[] lockBytes;
    
    public StructureTFMajorFeatureStart() {
        this.lockBytes = new byte[StructureTFMajorFeatureStart.NUM_LOCKS];
    }
    
    public StructureTFMajorFeatureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
        this.lockBytes = new byte[StructureTFMajorFeatureStart.NUM_LOCKS];
        StructureStrongholdPieces.func_75198_a();
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        this.feature = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, world);
        this.isConquered = false;
        final StructureComponent firstComponent = this.makeFirstComponent(world, rand, this.feature, x, y, z);
        if (firstComponent != null) {
            this.field_75075_a.add(firstComponent);
            firstComponent.func_74861_a(firstComponent, (List)this.field_75075_a, rand);
        }
        this.func_75072_c();
        if (firstComponent instanceof StructureStrongholdPieces.Stairs2) {
            final List var6 = ((StructureStrongholdPieces.Stairs2)firstComponent).field_75026_c;
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
        if (feature == TFFeature.nagaCourtyard) {
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
        if (feature == TFFeature.lichTower) {
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
        if (feature == TFFeature.iceTower) {
            return new ComponentTFIceTowerMain(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.mushroomTower) {
            return new ComponentTFMushroomTowerMain(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.yetiCave) {
            return new ComponentTFYetiCave(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.trollCave) {
            return new ComponentTFTrollCaveMain(world, rand, 0, x, y, z);
        }
        if (feature == TFFeature.finalCastle) {
            return new TFFinalCastlePieces.Main(world, rand, 0, x, y, z);
        }
        return null;
    }
    
    public boolean func_75069_d() {
        return this.feature.isStructureEnabled;
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
    
    private boolean isIntersectingLarger(final StructureBoundingBox chunkBB, final StructureComponent component) {
        final StructureBoundingBox compBB = component.func_74874_b();
        return compBB.field_78893_d + 1 >= chunkBB.field_78897_a && compBB.field_78897_a - 1 <= chunkBB.field_78893_d && compBB.field_78892_f + 1 >= chunkBB.field_78896_c && compBB.field_78896_c - 1 <= chunkBB.field_78892_f;
    }
    
    private boolean isShieldable(final StructureComponent component) {
        return component.func_74874_b().field_78894_e <= 32;
    }
    
    private void addShieldFor(final World world, final StructureComponent component, final List<StructureComponent> otherComponents, final StructureBoundingBox chunkBox) {
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
        final ArrayList<StructureComponent> intersecting = new ArrayList<StructureComponent>();
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
                            world.func_147465_d(x, y, z, TFBlocks.shield, this.calculateShieldMeta(shieldBox, x, y, z), 2);
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
    
    public void func_143022_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143022_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("Conquered", this.isConquered);
        par1NBTTagCompound.func_74768_a("FeatureID", this.feature.featureID);
        par1NBTTagCompound.func_74773_a("Locks", this.lockBytes);
    }
    
    public void func_143017_b(final NBTTagCompound nbttagcompound) {
        super.func_143017_b(nbttagcompound);
        this.isConquered = nbttagcompound.func_74767_n("Conquered");
        this.feature = TFFeature.featureList[nbttagcompound.func_74762_e("FeatureID")];
        this.lockBytes = nbttagcompound.func_74770_j("Locks");
    }
    
    public boolean isLocked(final int lockIndex) {
        if (lockIndex < this.lockBytes.length) {
            System.out.println("Checking locks for lockIndex " + lockIndex);
            for (int i = 0; i < this.lockBytes.length; ++i) {
                System.out.println("Lock " + i + " = " + this.lockBytes[i]);
            }
            return this.lockBytes[lockIndex] != 0;
        }
        System.out.println("Current lock index, " + lockIndex + " is beyond array bounds " + this.lockBytes.length);
        return false;
    }
    
    static {
        StructureTFMajorFeatureStart.NUM_LOCKS = 4;
        MapGenStructureIO.func_143034_b((Class)StructureTFMajorFeatureStart.class, "TFFeature");
        MapGenStructureIO.func_143034_b((Class)StructureTFHollowTreeStart.class, "TFHollowTree");
        TFStrongholdPieces.registerPieces();
        TFMinotaurMazePieces.registerPieces();
        TFDarkTowerPieces.registerPieces();
        TFLichTowerPieces.registerPieces();
        TFIceTowerPieces.registerPieces();
        TFMushroomTowerPieces.registerPieces();
        TFHollowTreePieces.registerPieces();
        TFTrollCavePieces.registerPieces();
        TFFinalCastlePieces.registerFinalCastlePieces();
        MapGenStructureIO.func_143031_a((Class)ComponentTFHedgeMaze.class, "TFHedge");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHillMaze.class, "TFHillMaze");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowHill.class, "TFHill");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHydraLair.class, "TFHydra");
        MapGenStructureIO.func_143031_a((Class)ComponentTFNagaCourtyard.class, "TFNaga");
        MapGenStructureIO.func_143031_a((Class)ComponentTFQuestGrove.class, "TFQuest1");
        MapGenStructureIO.func_143031_a((Class)ComponentTFYetiCave.class, "TFYeti");
    }
}
