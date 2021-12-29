// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import java.util.List;
import twilightforest.world.TFWorld;
import twilightforest.entity.EntityTFMosquitoSwarm;
import java.util.ArrayList;
import java.util.Random;

public class TFBiomeSwamp extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    Random monsterRNG;
    ArrayList emptyList;
    
    public TFBiomeSwamp(final int i) {
        super(i);
        this.monsterRNG = new Random(53439L);
        this.emptyList = new ArrayList();
        this.D = -0.25f;
        this.E = 0.0f;
        this.F = 0.8f;
        this.G = 0.9f;
        this.getTFBiomeDecorator().setDeadBushPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(10);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(2);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(6);
        this.H = 14745518;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.getTFBiomeDecorator().lakesPerChunk = 2;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
        this.J.add(new aaq((Class)EntityTFMosquitoSwarm.class, 10, 1, 1));
        this.J.add(new aaq((Class)ro.class, 10, 4, 4));
        this.J.add(new aaq((Class)sd.class, 10, 4, 4));
    }
    
    @Override
    public add a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (add)new adf(3, 0);
        }
        return (add)this.R;
    }
    
    public void a(final zv par1World, final Random par2Random, final int par3, final int par4) {
        super.a(par1World, par2Random, par3, par4);
        final aea worldgenvines = new aea();
        for (int i = 0; i < 50; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.a(par1World, par2Random, j, (int)byte0, k);
        }
    }
    
    public int k() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((zu.a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public int l() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((zr.a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public List a(final nh par1EnumCreatureType) {
        if (par1EnumCreatureType == nh.a) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.J : this.emptyList;
        }
        return (par1EnumCreatureType == nh.b) ? this.K : ((par1EnumCreatureType == nh.d) ? this.L : ((par1EnumCreatureType == nh.c) ? this.M : null));
    }
}
