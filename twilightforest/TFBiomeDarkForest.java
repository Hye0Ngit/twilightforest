// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
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
        this.J.add(new bg((Class)jg.class, 1, 1, 4));
        this.J.add(new bg((Class)ajg.class, 5, 1, 4));
        this.J.add(new bg((Class)xr.class, 5, 1, 4));
        this.J.add(new bg((Class)EntityTFHostileWolf.class, 10, 1, 4));
        this.J.add(new bg((Class)cb.class, 10, 1, 4));
    }
    
    @Override
    protected yg a() {
        return new TFDarkForestBiomeDecorator(this);
    }
    
    @Override
    public li a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (li)new agm(3, 0);
        }
        if (random.nextInt(8) == 0) {
            return (li)this.P;
        }
        return (li)this.N;
    }
    
    public int k() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((zv.a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public int l() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((gu.a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public List a(final acf par1EnumCreatureType) {
        if (par1EnumCreatureType == acf.a) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.J : null;
        }
        return (par1EnumCreatureType == acf.b) ? this.K : ((par1EnumCreatureType == acf.c) ? this.L : null);
    }
}
