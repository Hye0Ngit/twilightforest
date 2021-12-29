import java.util.Iterator;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFHollowHill extends ss
{
    public MapGenTFHollowHill() {
        this.b = 3;
    }
    
    protected boolean a(final int chunkX, final int chunkZ) {
        final TFFeature featureType = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.d);
        return featureType == TFFeature.hill1 || featureType == TFFeature.hill2 || featureType == TFFeature.hill3;
    }
    
    protected wg b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowHillStart(this.d, this.c, chunkX, chunkZ);
    }
    
    public boolean a(final int par1, final int par2, final int par3) {
        for (final wg var5 : this.e.values()) {
            if (var5.a() && var5.b().a(par1, par3, par1, par3)) {
                for (final ln var7 : var5.c()) {
                    if (var7 instanceof ComponentTFHollowHill) {
                        final ComponentTFHollowHill hill = (ComponentTFHollowHill)var7;
                        if (hill.isInHill(par1, par2, par3)) {
                            return true;
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
