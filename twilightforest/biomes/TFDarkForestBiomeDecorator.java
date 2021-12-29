// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Blocks;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.TFFeature;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFGenDarkCanopyTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import twilightforest.world.TFGenTallGrass;
import twilightforest.world.TFTreeGenerator;

public class TFDarkForestBiomeDecorator extends TFBiomeDecorator
{
    TFTreeGenerator darkCanopyTreeGen;
    TFGenTallGrass worldGenDeadBush;
    WorldGenTallGrass worldGenForestGrass;
    WorldGenTallGrass worldGenMushgloom;
    
    public TFDarkForestBiomeDecorator() {
        this.darkCanopyTreeGen = new TFGenDarkCanopyTree();
        this.worldGenDeadBush = new TFGenTallGrass(TFBlocks.plant, 11, 8);
        this.worldGenForestGrass = new WorldGenTallGrass(TFBlocks.plant, 10);
        this.worldGenMushgloom = new WorldGenTallGrass(TFBlocks.plant, 9);
    }
    
    @Override
    public void func_150512_a(final World world, final Random rand, final BiomeGenBase biome, final int mapX, final int mapZ) {
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
                final WorldGenerator var5 = (WorldGenerator)biome.func_150567_a(rand);
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
    
    public int getGroundLevel(final World world, final int x, final int z) {
        final Chunk chunk = world.func_72938_d(x, z);
        int lastDirt = TFWorld.SEALEVEL;
        for (int y = TFWorld.SEALEVEL; y < TFWorld.CHUNKHEIGHT - 1; ++y) {
            final Block blockID = chunk.func_150810_a(x & 0xF, y, z & 0xF);
            if (blockID == Blocks.field_150349_c) {
                return y + 1;
            }
            if (blockID == Blocks.field_150346_d || blockID == Blocks.field_150348_b || blockID == Blocks.field_150351_n) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
    }
}
