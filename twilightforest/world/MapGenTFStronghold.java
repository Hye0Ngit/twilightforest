// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.structures.StructureTFStrongholdStart;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import twilightforest.biomes.TFBiomeBase;

public class MapGenTFStronghold extends aev
{
    private yy[] allowedBiomeGenBases;
    private boolean ranBiomeCheck;
    private xv[] structureCoords;
    
    public MapGenTFStronghold() {
        this.allowedBiomeGenBases = new yy[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.stream, TFBiomeBase.snow, TFBiomeBase.glacier, TFBiomeBase.clearing, TFBiomeBase.clearingBorder, TFBiomeBase.deepMushrooms };
        this.structureCoords = new xv[3];
    }
    
    protected boolean a(final int par1, final int par2) {
        if (!this.ranBiomeCheck) {
            final Random var3 = new Random();
            var3.setSeed(this.c.E());
            double var4 = var3.nextDouble() * 3.141592653589793 * 2.0;
            for (int var5 = 0; var5 < this.structureCoords.length; ++var5) {
                final double var6 = (1.25 + var3.nextDouble()) * 32.0;
                int var7 = (int)Math.round(Math.cos(var4) * var6);
                int var8 = (int)Math.round(Math.sin(var4) * var6);
                final ArrayList var9 = new ArrayList();
                for (final yy var13 : this.allowedBiomeGenBases) {
                    var9.add(var13);
                }
                final yv var14 = this.c.t().a((var7 << 4) + 8, (var8 << 4) + 8, 112, (List)var9, var3);
                if (var14 != null) {
                    var7 = var14.a >> 4;
                    var8 = var14.c >> 4;
                }
                else {
                    System.out.println("Placed stronghold in INVALID biome at (" + var7 + ", " + var8 + ")");
                }
                this.structureCoords[var5] = new xv(var7, var8);
                var4 += 6.283185307179586 / this.structureCoords.length;
            }
            this.ranBiomeCheck = true;
        }
        for (final xv var18 : this.structureCoords) {
            if (par1 == var18.a && par2 == var18.b) {
                System.out.println(par1 + ", " + par2);
                return true;
            }
        }
        return false;
    }
    
    protected List func_40482_a() {
        final ArrayList var1 = new ArrayList();
        for (final xv var5 : this.structureCoords) {
            if (var5 != null) {
                var1.add(var5.a(64));
            }
        }
        return var1;
    }
    
    protected afb b(final int par1, final int par2) {
        StructureTFStrongholdStart var3;
        for (var3 = new StructureTFStrongholdStart(this.c, this.b, par1, par2); var3.b().isEmpty() || var3.b().get(0).b == null; var3 = new StructureTFStrongholdStart(this.c, this.b, par1, par2)) {}
        return var3;
    }
}
