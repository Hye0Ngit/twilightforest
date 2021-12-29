// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import twilightforest.structures.StructureTFStrongholdStart;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.ChunkPosition;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;

public class MapGenTFStronghold extends MapGenStructure
{
    private BiomeGenBase[] allowedBiomeGenBases;
    private boolean ranBiomeCheck;
    private ChunkCoordIntPair[] structureCoords;
    
    public MapGenTFStronghold() {
        this.allowedBiomeGenBases = new BiomeGenBase[] { TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.highlands, TFBiomeBase.mushrooms, TFBiomeBase.swamp, TFBiomeBase.stream, TFBiomeBase.snow, TFBiomeBase.glacier, TFBiomeBase.clearing, TFBiomeBase.clearingBorder, TFBiomeBase.deepMushrooms };
        this.structureCoords = new ChunkCoordIntPair[3];
    }
    
    protected boolean func_75047_a(final int par1, final int par2) {
        if (!this.ranBiomeCheck) {
            final Random var3 = new Random();
            var3.setSeed(this.field_75039_c.func_72905_C());
            double var4 = var3.nextDouble() * 3.141592653589793 * 2.0;
            for (int var5 = 0; var5 < this.structureCoords.length; ++var5) {
                final double var6 = (1.25 + var3.nextDouble()) * 32.0;
                int var7 = (int)Math.round(Math.cos(var4) * var6);
                int var8 = (int)Math.round(Math.sin(var4) * var6);
                final ArrayList var9 = new ArrayList();
                for (final BiomeGenBase var13 : this.allowedBiomeGenBases) {
                    var9.add(var13);
                }
                final ChunkPosition var14 = this.field_75039_c.func_72959_q().func_76941_a((var7 << 4) + 8, (var8 << 4) + 8, 112, (List)var9, var3);
                if (var14 != null) {
                    var7 = var14.field_76930_a >> 4;
                    var8 = var14.field_76929_c >> 4;
                }
                else {
                    System.out.println("Placed stronghold in INVALID biome at (" + var7 + ", " + var8 + ")");
                }
                this.structureCoords[var5] = new ChunkCoordIntPair(var7, var8);
                var4 += 6.283185307179586 / this.structureCoords.length;
            }
            this.ranBiomeCheck = true;
        }
        for (final ChunkCoordIntPair var18 : this.structureCoords) {
            if (par1 == var18.field_77276_a && par2 == var18.field_77275_b) {
                System.out.println(par1 + ", " + par2);
                return true;
            }
        }
        return false;
    }
    
    protected List func_40482_a() {
        final ArrayList var1 = new ArrayList();
        for (final ChunkCoordIntPair var5 : this.structureCoords) {
            if (var5 != null) {
                var1.add(var5.func_77271_a(64));
            }
        }
        return var1;
    }
    
    protected StructureStart func_75049_b(final int par1, final int par2) {
        StructureTFStrongholdStart var3;
        for (var3 = new StructureTFStrongholdStart(this.field_75039_c, this.field_75038_b, par1, par2); var3.func_75073_b().isEmpty() || var3.func_75073_b().get(0).field_75025_b == null; var3 = new StructureTFStrongholdStart(this.field_75039_c, this.field_75038_b, par1, par2)) {}
        return var3;
    }
}
