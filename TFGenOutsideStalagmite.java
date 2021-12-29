import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenOutsideStalagmite extends TFGenCaveStalactite
{
    public TFGenOutsideStalagmite() {
        super((byte)vz.t.bO, 1.0, false);
    }
    
    @Override
    public boolean a(final ge world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        final int length = rand.nextInt(10) + 5;
        return this.isAreaClear(world, rand, x, y, z, 1, length, 1) && this.makeSpike(rand, x, y - 1, z, length);
    }
}
