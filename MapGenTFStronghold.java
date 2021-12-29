import java.util.List;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class MapGenTFStronghold extends hl
{
    private sr[] allowedBiomeGenBases;
    private boolean ranBiomeCheck;
    private acm[] structureCoords;
    
    public MapGenTFStronghold() {
        this.allowedBiomeGenBases = new sr[] { TFBiomeBase.twilightForest, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.stream, TFBiomeBase.snow, TFBiomeBase.glacier };
        this.structureCoords = new acm[3];
    }
    
    protected boolean a(final int i, final int j) {
        if (!this.ranBiomeCheck) {
            this.b.setSeed(this.c.t());
            double d = this.b.nextDouble() * 3.141592653589793 * 2.0;
            for (int l = 0; l < this.structureCoords.length; ++l) {
                final double d2 = (1.25 + this.b.nextDouble()) * 32.0;
                int j2 = (int)Math.round(Math.cos(d) * d2);
                int k1 = (int)Math.round(Math.sin(d) * d2);
                final ArrayList arraylist = new ArrayList();
                for (final sr biomegenbase : this.allowedBiomeGenBases) {
                    arraylist.add(biomegenbase);
                }
                final am chunkposition = this.c.a().a((j2 << 4) + 8, (k1 << 4) + 8, 112, (List)arraylist, this.b);
                if (chunkposition != null) {
                    j2 = chunkposition.a >> 4;
                    k1 = chunkposition.c >> 4;
                }
                else {
                    System.out.println("Placed stronghold in INVALID biome at (" + j2 + ", " + k1 + ")");
                }
                this.structureCoords[l] = new acm(j2, k1);
                d += 6.283185307179586 / this.structureCoords.length;
            }
            this.ranBiomeCheck = true;
        }
        for (final acm chunkcoordintpair : this.structureCoords) {
            if (i == chunkcoordintpair.a && j == chunkcoordintpair.b) {
                return true;
            }
        }
        return false;
    }
    
    protected oa b(final int i, final int j) {
        return new StructureTFStrongholdStart(this.c, this.b, i, j);
    }
}
