// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import java.util.List;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFMistWolf;
import java.util.ArrayList;
import java.util.Random;

public class TFBiomeDarkForest extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    Random monsterRNG;
    ArrayList emptyList;
    
    public TFBiomeDarkForest(final int i) {
        super(i);
        this.emptyList = new ArrayList();
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
        this.J.add(new aaq((Class)rp.class, 1, 1, 4));
        this.J.add(new aaq((Class)sd.class, 5, 1, 4));
        this.J.add(new aaq((Class)rz.class, 5, 1, 4));
        this.J.add(new aaq((Class)EntityTFMistWolf.class, 10, 1, 4));
        this.J.add(new aaq((Class)EntityTFSkeletonDruid.class, 10, 1, 4));
        this.J.add(new aaq((Class)EntityTFKingSpider.class, 10, 1, 4));
        this.J.add(new aaq((Class)EntityTFKobold.class, 10, 4, 8));
    }
    
    @Override
    public aat a() {
        return new TFDarkForestBiomeDecorator(this);
    }
    
    @Override
    public add a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (add)new adf(3, 0);
        }
        if (random.nextInt(8) == 0) {
            return (add)this.Q;
        }
        return (add)this.O;
    }
    
    public int k() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((zu.a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public int l() {
        final double var1 = this.j();
        final double var2 = this.i();
        return ((zr.a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public List a(final nh par1EnumCreatureType) {
        if (par1EnumCreatureType == nh.a) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.J : this.emptyList;
        }
        return (par1EnumCreatureType == nh.b) ? this.K : ((par1EnumCreatureType == nh.d) ? this.L : ((par1EnumCreatureType == nh.c) ? this.M : null));
    }
    
    public boolean e() {
        return true;
    }
}
