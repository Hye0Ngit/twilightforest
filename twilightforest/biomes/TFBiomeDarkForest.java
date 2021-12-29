// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import java.util.List;
import twilightforest.TFDarkForestBiomeDecorator;
import twilightforest.EntityTFKobold;
import twilightforest.EntityTFHostileWolf;
import java.util.Random;

public class TFBiomeDarkForest extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    Random monsterRNG;
    
    public TFBiomeDarkForest(final int i) {
        super(i);
        this.F = 0.7f;
        this.G = 0.8f;
        this.getTFBiomeDecorator().canopyPerChunk = 5;
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(-99);
        this.getTFBiomeDecorator().setFlowersPerChunk(-99);
        this.getTFBiomeDecorator().setMushroomsPerChunk(1);
        this.getTFBiomeDecorator().setDeadBushPerChunk(10);
        this.D = 0.05f;
        this.E = 0.05f;
        this.monsterRNG = new Random();
        this.J.add(new ys((Class)qd.class, 1, 1, 4));
        this.J.add(new ys((Class)qr.class, 5, 1, 4));
        this.J.add(new ys((Class)qn.class, 5, 1, 4));
        this.J.add(new ys((Class)EntityTFHostileWolf.class, 10, 1, 4));
        this.J.add(new ys((Class)qp.class, 10, 1, 4));
        this.J.add(new ys((Class)EntityTFKobold.class, 10, 4, 8));
    }
    
    @Override
    public yv a() {
        return new TFDarkForestBiomeDecorator(this);
    }
    
    @Override
    public abf a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (abf)new abh(3, 0);
        }
        if (random.nextInt(8) == 0) {
            return (abf)this.Q;
        }
        return (abf)this.O;
    }
    
    public int k() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((xu.a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public int l() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((xr.a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public List a(final me par1EnumCreatureType) {
        if (par1EnumCreatureType == me.a) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.J : null;
        }
        return (par1EnumCreatureType == me.b) ? this.K : ((par1EnumCreatureType == me.d) ? this.L : ((par1EnumCreatureType == me.c) ? this.M : null));
    }
    
    public boolean e() {
        return true;
    }
}
