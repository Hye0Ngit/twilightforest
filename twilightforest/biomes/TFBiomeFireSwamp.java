// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.world.TFGenFireJet;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import java.util.Random;

public class TFBiomeFireSwamp extends TFBiomeBase
{
    protected TFBiomeFireSwamp(final int i) {
        super(i);
        this.D = -0.25f;
        this.E = 0.0f;
        this.F = 1.0f;
        this.G = 0.4f;
        this.getTFBiomeDecorator().setDeadBushPerChunk(2);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(4);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(3);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(6);
        this.H = 7089196;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.getTFBiomeDecorator().lavaPoolChance = 0.125f;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
    }
    
    @Override
    public add a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (add)new adf(3, 0);
        }
        return (add)this.R;
    }
    
    public void a(final zv par1World, final Random par2Random, final int mapX, final int mapZ) {
        super.a(par1World, par2Random, mapX, mapZ);
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, par1World);
        if (nearFeature.chunkDecorationsEnabled) {
            final aea worldgenvines = new aea();
            for (int i = 0; i < 50; ++i) {
                final int j = mapX + par2Random.nextInt(16) + 8;
                final byte byte0 = (byte)TFWorld.SEALEVEL;
                final int k = mapZ + par2Random.nextInt(16) + 8;
                worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
            }
            final TFGenFireJet genSmoker = new TFGenFireJet(TFBlocks.fireJet.cz, 0);
            if (par2Random.nextInt(4) == 0) {
                final int j = mapX + par2Random.nextInt(16) + 8;
                final byte byte0 = (byte)TFWorld.SEALEVEL;
                final int k = mapZ + par2Random.nextInt(16) + 8;
                genSmoker.a(par1World, par2Random, j, byte0, k);
            }
            final TFGenFireJet genFireJet = new TFGenFireJet(TFBlocks.fireJet.cz, 8);
            for (int l = 0; l < 1; ++l) {
                final int m = mapX + par2Random.nextInt(16) + 8;
                final byte byte2 = (byte)TFWorld.SEALEVEL;
                final int k2 = mapZ + par2Random.nextInt(16) + 8;
                genFireJet.a(par1World, par2Random, m, byte2, k2);
            }
        }
    }
    
    public int k() {
        return 5713443;
    }
    
    public int l() {
        return 6563343;
    }
}
