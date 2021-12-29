// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Arrays;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.structures.hollowtree.StructureTFHollowTreeStart;
import net.minecraft.world.gen.structure.StructureStart;
import twilightforest.TFFeature;
import twilightforest.TwilightForestMod;
import java.util.List;
import net.minecraft.world.gen.structure.MapGenStructure;

public class MapGenTFHollowTree extends MapGenStructure
{
    public static List oakSpawnBiomes;
    
    protected boolean func_75047_a(final int chunkX, final int chunkZ) {
        return this.field_75038_b.nextInt(TwilightForestMod.twilightOakChance) == 0 && TFFeature.getNearestFeature(chunkX, chunkZ, this.field_75039_c).areChunkDecorationsEnabled && this.field_75039_c.func_72959_q().func_76940_a(chunkX * 16 + 8, chunkZ * 16 + 8, 0, MapGenTFHollowTree.oakSpawnBiomes);
    }
    
    public String func_143025_a() {
        return "HollowTree";
    }
    
    protected StructureStart func_75049_b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowTreeStart(this.field_75039_c, this.field_75038_b, chunkX, chunkZ);
    }
    
    static {
        MapGenTFHollowTree.oakSpawnBiomes = Arrays.asList(TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.mushrooms, TFBiomeBase.tfSwamp, TFBiomeBase.clearing, TFBiomeBase.oakSavanna, TFBiomeBase.lightedForest, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest, TFBiomeBase.fireSwamp);
    }
}
