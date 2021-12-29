// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.chunk.Chunk;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.block.Block;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.world.TFGenDarkCanopyTree;

public class TFDarkForestBiomeDecorator extends TFBiomeDecorator
{
    TFGenDarkCanopyTree darkCanopyTreeGen;
    
    public TFDarkForestBiomeDecorator(final TFBiomeDarkForest tfBiomeDarkForest) {
        super(tfBiomeDarkForest);
        this.darkCanopyTreeGen = new TFGenDarkCanopyTree();
    }
    
    @Override
    public void func_76796_a(final World world, final Random rand, final int mapX, final int mapZ) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, world);
        if (nearFeature.chunkDecorationsEnabled) {
            for (int nc = this.canopyPerChunk + rand.nextInt(2), i = 0; i < nc; ++i) {
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
                new WorldGenDeadBush(Block.field_71961_Y.field_71990_ca).func_76484_a(world, rand, rx, ry, rz);
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
                    new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 9).func_76484_a(world, rand, rx, ry, rz);
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
        }
        this.decorateUnderground(world, rand, mapX, mapZ);
        this.decorateOnlyOres(world, rand, mapX, mapZ);
    }
    
    public int getGroundLevel(final World world, final int x, final int z) {
        final Chunk chunk = world.func_72938_d(x, z);
        int lastDirt = TFWorld.SEALEVEL;
        for (int y = TFWorld.SEALEVEL; y < TFWorld.WORLDHEIGHT - 1; ++y) {
            final int blockID = chunk.func_76610_a(x & 0xF, y, z & 0xF);
            if (blockID == Block.field_71980_u.field_71990_ca) {
                return y + 1;
            }
            if (blockID == Block.field_71980_u.field_71990_ca || blockID == Block.field_71980_u.field_71990_ca || blockID == Block.field_71980_u.field_71990_ca) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
    }
}
