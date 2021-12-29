// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.world.TFWorld;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import twilightforest.world.TFGenHangingLamps;

public class TFBiomeLightedForest extends TFBiomeTwilightForest
{
    TFGenHangingLamps tfGenLamps;
    WorldGenTallGrass worldGenMushgloom;
    
    public TFBiomeLightedForest(final int i) {
        super(i);
        this.worldGenMushgloom = new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 9);
        this.tfGenLamps = new TFGenHangingLamps();
        this.field_76750_F = 0.5f;
        this.field_76751_G = 1.0f;
        this.getTFBiomeDecorator().setTreesPerChunk(2);
    }
    
    public void func_76728_a(final World world, final Random rand, final int mapX, final int mapZ) {
        super.func_76728_a(world, rand, mapX, mapZ);
        if (rand.nextInt(24) == 0) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = this.getGroundLevel(world, rx, rz);
            this.worldGenMushgloom.func_76484_a(world, rand, rx, ry, rz);
        }
        for (int i = 0; i < 30; ++i) {
            final int rx2 = mapX + rand.nextInt(16) + 8;
            final int rz2 = mapZ + rand.nextInt(16) + 8;
            final int ry2 = TFWorld.SEALEVEL + rand.nextInt(TFWorld.WORLDHEIGHT - TFWorld.SEALEVEL);
            this.tfGenLamps.func_76484_a(world, rand, rx2, ry2, rz2);
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
        for (int y = TFWorld.SEALEVEL; y < TFWorld.WORLDHEIGHT - 1; ++y) {
            final int blockID = chunk.func_76610_a(x & 0xF, y, z & 0xF);
            if (blockID == Block.field_71980_u.field_71990_ca) {
                return y + 1;
            }
            if (blockID == Block.field_71979_v.field_71990_ca || blockID == Block.field_71981_t.field_71990_ca || blockID == Block.field_71940_F.field_71990_ca) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
    }
}
