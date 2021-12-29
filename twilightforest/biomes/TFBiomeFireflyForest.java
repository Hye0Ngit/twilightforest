// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.BlockFlower;
import net.minecraft.util.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.world.TFWorld;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import twilightforest.world.TFGenLampposts;
import twilightforest.world.TFGenHangingLamps;

public class TFBiomeFireflyForest extends TFBiomeTwilightForest
{
    private static final int LAMPPOST_CHANCE = 4;
    TFGenHangingLamps tfGenHangingLamps;
    TFGenLampposts tfGenLampposts;
    WorldGenTallGrass worldGenMushgloom;
    
    public TFBiomeFireflyForest(final int i) {
        super(i);
        this.worldGenMushgloom = new WorldGenTallGrass(TFBlocks.plant, 9);
        this.tfGenHangingLamps = new TFGenHangingLamps();
        this.tfGenLampposts = new TFGenLampposts();
        this.field_76750_F = 0.5f;
        this.field_76751_G = 1.0f;
        this.field_76760_I.field_76802_A = 4;
        this.field_76760_I.field_76803_B = 1;
        this.getTFBiomeDecorator().setTreesPerChunk(2);
    }
    
    public void func_76728_a(final World world, final Random rand, final int mapX, final int mapZ) {
        for (int flowerCycles = rand.nextInt(3) - 1, successfulFlowers = 0; successfulFlowers < flowerCycles; ++successfulFlowers) {
            final int flowerType = rand.nextInt(3);
            if (flowerType == 0) {
                TFBiomeFireflyForest.field_150610_ae.func_150548_a(1);
            }
            else if (flowerType == 1) {
                TFBiomeFireflyForest.field_150610_ae.func_150548_a(4);
            }
            else if (flowerType == 2) {
                TFBiomeFireflyForest.field_150610_ae.func_150548_a(5);
            }
            for (int tallFlowerTries = 0; tallFlowerTries < 1; ++tallFlowerTries) {
                final int k1 = mapX + rand.nextInt(16) + 8;
                final int i2 = mapZ + rand.nextInt(16) + 8;
                final int l1 = rand.nextInt(world.func_72976_f(k1, i2) + 32);
                if (TFBiomeFireflyForest.field_150610_ae.func_76484_a(world, rand, k1, l1, i2)) {
                    break;
                }
            }
        }
        super.func_76728_a(world, rand, mapX, mapZ);
        if (rand.nextInt(24) == 0) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = this.getGroundLevel(world, rx, rz);
            this.worldGenMushgloom.func_76484_a(world, rand, rx, ry, rz);
        }
        for (int j = 0; j < 30; ++j) {
            final int rx2 = mapX + rand.nextInt(16) + 8;
            final int rz2 = mapZ + rand.nextInt(16) + 8;
            final int ry2 = TFWorld.SEALEVEL + rand.nextInt(TFWorld.CHUNKHEIGHT - TFWorld.SEALEVEL);
            this.tfGenHangingLamps.func_76484_a(world, rand, rx2, ry2, rz2);
        }
        if (rand.nextInt(4) == 0) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = this.getGroundLevel(world, rx, rz);
            this.tfGenLampposts.func_76484_a(world, rand, rx, ry, rz);
        }
        if (rand.nextInt(32) == 0) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = this.getGroundLevel(world, rx, rz);
            new WorldGenPumpkin().func_76484_a(world, rand, rx, ry, rz);
        }
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
    
    public String func_150572_a(final Random p_150572_1_, final int p_150572_2_, final int p_150572_3_, final int p_150572_4_) {
        final double flowerVar = MathHelper.func_151237_a((1.0 + TFBiomeFireflyForest.field_150606_ad.func_151601_a(p_150572_2_ / 48.0, p_150572_4_ / 48.0)) / 2.0, 0.0, 0.9999);
        int flowerIndex = (int)(flowerVar * BlockFlower.field_149859_a.length);
        if (flowerIndex == 1) {
            flowerIndex = 0;
        }
        return BlockFlower.field_149859_a[flowerIndex];
    }
}
