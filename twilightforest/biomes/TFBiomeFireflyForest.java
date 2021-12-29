// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.world.TFWorld;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenTallGrass;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.world.feature.TFGenLampposts;
import twilightforest.block.TFBlocks;
import twilightforest.world.feature.TFGenHangingLamps;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFBiomeFireflyForest extends TFBiomeBase
{
    private static final int LAMPPOST_CHANCE = 4;
    private final WorldGenerator tfGenHangingLamps;
    private final WorldGenerator tfGenLampposts;
    private final WorldGenerator worldGenMushgloom;
    
    public TFBiomeFireflyForest(final Biome.BiomeProperties props) {
        super(props);
        this.tfGenHangingLamps = new TFGenHangingLamps();
        this.tfGenLampposts = new TFGenLampposts(TFBlocks.firefly_jar.func_176223_P());
        this.worldGenMushgloom = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MUSHGLOOM));
        this.field_76760_I.field_76802_A = 4;
        this.field_76760_I.field_76803_B = 1;
        this.getTFBiomeDecorator().setTreesPerChunk(2);
    }
    
    public void func_180624_a(final World world, final Random rand, final BlockPos pos) {
        final int flowerCycles = rand.nextInt(3) - 1;
        if (Biomes.field_185444_T instanceof BiomeForest) {
            ((BiomeForest)Biomes.field_185444_T).func_185378_a(world, rand, pos, flowerCycles);
        }
        super.func_180624_a(world, rand, pos);
        if (rand.nextInt(24) == 0) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = TFWorld.getGroundLevel(world, rx, rz);
            this.worldGenMushgloom.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
        for (int i = 0; i < 30; ++i) {
            final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry2 = 31 + rand.nextInt(225);
            this.tfGenHangingLamps.func_180709_b(world, rand, new BlockPos(rx2, ry2, rz2));
        }
        if (rand.nextInt(4) == 0) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = TFWorld.getGroundLevel(world, rx, rz);
            this.tfGenLampposts.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
        if (rand.nextInt(32) == 0) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = TFWorld.getGroundLevel(world, rx, rz);
            new WorldGenPumpkin().func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
    }
}
