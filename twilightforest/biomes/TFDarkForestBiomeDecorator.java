// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFGenDarkCanopyTree;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import twilightforest.world.TFGenTallGrass;
import twilightforest.world.TFTreeGenerator;

public class TFDarkForestBiomeDecorator extends TFBiomeDecorator
{
    TFTreeGenerator darkCanopyTreeGen;
    TFGenTallGrass worldGenDeadBush;
    WorldGenTallGrass worldGenForestGrass;
    WorldGenTallGrass worldGenMushgloom;
    
    public TFDarkForestBiomeDecorator(final TFBiomeDarkForest tfBiomeDarkForest) {
        super(tfBiomeDarkForest);
        this.darkCanopyTreeGen = new TFGenDarkCanopyTree();
        this.worldGenDeadBush = new TFGenTallGrass(TFBlocks.plant.field_71990_ca, 11, 8);
        this.worldGenForestGrass = new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 10);
        this.worldGenMushgloom = new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 9);
    }
    
    @Override
    public void func_76796_a(final World world, final Random rand, final int mapX, final int mapZ) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, world);
        if (nearFeature.areChunkDecorationsEnabled) {
            for (int nc = (int)this.canopyPerChunk + ((rand.nextFloat() < this.canopyPerChunk - (int)this.canopyPerChunk) ? 1 : 0), i = 0; i < nc; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.func_72976_f(rx, rz);
                this.darkCanopyTreeGen.func_76484_a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.field_76832_z; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = this.getGroundLevel(world, rx, rz);
                final WorldGenerator var5 = this.field_76812_e.func_76740_a(rand);
                var5.func_76487_a(1.0, 1.0, 1.0);
                var5.func_76484_a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.field_76804_C; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = rand.nextInt(128);
                this.worldGenDeadBush.func_76484_a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.field_76804_C; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = rand.nextInt(128);
                this.worldGenForestGrass.func_76484_a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.field_76798_D; ++i) {
                if (rand.nextInt(8) == 0) {
                    final int rx = mapX + rand.nextInt(16) + 8;
                    final int rz = mapZ + rand.nextInt(16) + 8;
                    final int ry = this.getGroundLevel(world, rx, rz);
                    this.field_76828_s.func_76484_a(world, rand, rx, ry, rz);
                }
                if (rand.nextInt(16) == 0) {
                    final int rx = mapX + rand.nextInt(16) + 8;
                    final int rz = mapZ + rand.nextInt(16) + 8;
                    final int ry = this.getGroundLevel(world, rx, rz);
                    this.field_76827_t.func_76484_a(world, rand, rx, ry, rz);
                }
                if (rand.nextInt(24) == 0) {
                    final int rx = mapX + rand.nextInt(16) + 8;
                    final int rz = mapZ + rand.nextInt(16) + 8;
                    final int ry = this.getGroundLevel(world, rx, rz);
                    this.worldGenMushgloom.func_76484_a(world, rand, rx, ry, rz);
                }
            }
            if (rand.nextInt(4) == 0) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = rand.nextInt(128);
                this.field_76828_s.func_76484_a(world, rand, rx2, ry2, rz2);
            }
            if (rand.nextInt(8) == 0) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = rand.nextInt(128);
                this.field_76827_t.func_76484_a(world, rand, rx2, ry2, rz2);
            }
            if (rand.nextInt(32) == 0) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = this.getGroundLevel(world, rx2, rz2);
                new WorldGenPumpkin().func_76484_a(world, rand, rx2, ry2, rz2);
            }
        }
        this.decorateUnderground(world, rand, mapX, mapZ);
        this.decorateOnlyOres(world, rand, mapX, mapZ);
    }
}
