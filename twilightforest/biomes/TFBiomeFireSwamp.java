// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.world.TFGenFireJet;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.feature.WorldGenVines;
import twilightforest.TFFeature;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class TFBiomeFireSwamp extends TFBiomeBase
{
    protected TFBiomeFireSwamp(final int i) {
        super(i);
        this.field_76748_D = -0.25f;
        this.field_76749_E = 0.0f;
        this.field_76750_F = 1.0f;
        this.field_76751_G = 0.4f;
        this.getTFBiomeDecorator().setDeadBushPerChunk(2);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(4);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(3);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(6);
        this.field_76759_H = 7089196;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().lavaPoolChance = 0.125f;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenerator)new WorldGenShrub(3, 0);
        }
        return (WorldGenerator)this.field_76763_Q;
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int mapX, final int mapZ) {
        super.func_76728_a(par1World, par2Random, mapX, mapZ);
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, par1World);
        if (nearFeature.areChunkDecorationsEnabled) {
            final WorldGenVines worldgenvines = new WorldGenVines();
            for (int i = 0; i < 50; ++i) {
                final int j = mapX + par2Random.nextInt(16) + 8;
                final byte byte0 = (byte)TFWorld.SEALEVEL;
                final int k = mapZ + par2Random.nextInt(16) + 8;
                worldgenvines.func_76484_a(par1World, par2Random, j, (int)byte0, k);
            }
            final TFGenFireJet genSmoker = new TFGenFireJet(TFBlocks.fireJet.field_71990_ca, 0);
            if (par2Random.nextInt(4) == 0) {
                final int j = mapX + par2Random.nextInt(16) + 8;
                final byte byte0 = (byte)TFWorld.SEALEVEL;
                final int k = mapZ + par2Random.nextInt(16) + 8;
                genSmoker.func_76484_a(par1World, par2Random, j, byte0, k);
            }
            final TFGenFireJet genFireJet = new TFGenFireJet(TFBlocks.fireJet.field_71990_ca, 8);
            for (int l = 0; l < 1; ++l) {
                final int m = mapX + par2Random.nextInt(16) + 8;
                final byte byte2 = (byte)TFWorld.SEALEVEL;
                final int k2 = mapZ + par2Random.nextInt(16) + 8;
                genFireJet.func_76484_a(par1World, par2Random, m, byte2, k2);
            }
        }
    }
    
    @Override
    public int func_76737_k() {
        return 5713443;
    }
    
    @Override
    public int func_76726_l() {
        return 6563343;
    }
}
