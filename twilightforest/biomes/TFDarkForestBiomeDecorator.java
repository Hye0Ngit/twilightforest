// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenTallGrass;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import twilightforest.world.feature.TFGenDarkCanopyTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFDarkForestBiomeDecorator extends TFBiomeDecorator
{
    private final WorldGenerator darkCanopyTreeGen;
    private final WorldGenerator worldGenDeadBush;
    private final WorldGenerator worldGenForestGrass;
    private final WorldGenerator worldGenMushgloom;
    
    public TFDarkForestBiomeDecorator() {
        this.darkCanopyTreeGen = (WorldGenerator)new TFGenDarkCanopyTree();
        this.worldGenDeadBush = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.DEADBUSH), 8);
        this.worldGenForestGrass = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.FORESTGRASS));
        this.worldGenMushgloom = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MUSHGLOOM));
    }
    
    @Override
    public void func_180292_a(final World world, final Random rand, final Biome biome, final BlockPos pos) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(pos.func_177958_n() >> 4, pos.func_177952_p() >> 4, world);
        if (nearFeature.areChunkDecorationsEnabled) {
            for (int nc = (int)this.canopyPerChunk + ((rand.nextFloat() < this.canopyPerChunk - (int)this.canopyPerChunk) ? 1 : 0), i = 0; i < nc; ++i) {
                final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                this.darkCanopyTreeGen.func_180709_b(world, rand, new BlockPos(rx, world.func_189649_b(rx, rz), rz));
            }
            for (int i = 0; i < this.field_76832_z; ++i) {
                final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                final int ry = TFWorld.getGroundLevel(world, rx, rz);
                final WorldGenerator treeFeature = (WorldGenerator)biome.func_150567_a(rand);
                treeFeature.func_175904_e();
                treeFeature.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
            }
            for (int i = 0; i < this.field_76804_C; ++i) {
                final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                final int ry = rand.nextInt(128);
                this.worldGenDeadBush.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
            }
            for (int i = 0; i < this.field_76804_C; ++i) {
                final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                final int ry = rand.nextInt(128);
                this.worldGenForestGrass.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
            }
            for (int i = 0; i < this.field_76798_D; ++i) {
                if (rand.nextInt(8) == 0) {
                    final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                    final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                    final int ry = TFWorld.getGroundLevel(world, rx, rz);
                    this.field_76828_s.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
                }
                if (rand.nextInt(16) == 0) {
                    final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                    final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                    final int ry = TFWorld.getGroundLevel(world, rx, rz);
                    this.field_76827_t.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
                }
                if (rand.nextInt(24) == 0) {
                    final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                    final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                    final int ry = TFWorld.getGroundLevel(world, rx, rz);
                    this.worldGenMushgloom.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
                }
            }
            if (rand.nextInt(4) == 0) {
                final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
                final int ry2 = rand.nextInt(128);
                this.field_76828_s.func_180709_b(world, rand, new BlockPos(rx2, ry2, rz2));
            }
            if (rand.nextInt(8) == 0) {
                final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
                final int ry2 = rand.nextInt(128);
                this.field_76827_t.func_180709_b(world, rand, new BlockPos(rx2, ry2, rz2));
            }
            if (rand.nextInt(32) == 0) {
                final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
                final int ry2 = TFWorld.getGroundLevel(world, rx2, rz2);
                new WorldGenPumpkin().func_180709_b(world, rand, new BlockPos(rx2, ry2, rz2));
            }
        }
        this.decorateUnderground(world, rand, pos);
        this.decorateOnlyOres(world, rand, pos);
    }
}
