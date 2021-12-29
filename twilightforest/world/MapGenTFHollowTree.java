// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Arrays;
import twilightforest.biomes.TFBiomes;
import java.util.Iterator;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import twilightforest.structures.hollowtree.StructureTFHollowTreeStart;
import net.minecraft.world.gen.structure.StructureStart;
import twilightforest.TFFeature;
import twilightforest.TFConfig;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import java.util.function.Supplier;
import java.util.List;
import net.minecraft.world.gen.structure.MapGenStructure;

public class MapGenTFHollowTree extends MapGenStructure
{
    private static final List<Supplier<Biome>> oakSpawnBiomes;
    
    public String func_143025_a() {
        return "TFHollowTree";
    }
    
    @Nullable
    public BlockPos func_180706_b(final World worldIn, final BlockPos pos, final boolean findUnexplored) {
        this.field_75039_c = worldIn;
        return func_191069_a(worldIn, (MapGenStructure)this, pos, 20, 11, 10387313, true, 100, findUnexplored);
    }
    
    protected boolean func_75047_a(final int chunkX, final int chunkZ) {
        return this.field_75038_b.nextInt(TFConfig.performance.twilightOakChance) == 0 && TFFeature.getNearestFeature(chunkX, chunkZ, this.field_75039_c).areChunkDecorationsEnabled && this.field_75039_c.func_72959_q().func_76940_a(chunkX * 16 + 8, chunkZ * 16 + 8, 0, (List)getCurrentSpawnBiomes());
    }
    
    @Nonnull
    protected StructureStart func_75049_b(final int chunkX, final int chunkZ) {
        return new StructureTFHollowTreeStart(this.field_75039_c, this.field_75038_b, chunkX, chunkZ);
    }
    
    private static List<Biome> getCurrentSpawnBiomes() {
        final List<Biome> biomes = new ArrayList<Biome>(MapGenTFHollowTree.oakSpawnBiomes.size());
        for (final Supplier<Biome> biomeSupplier : MapGenTFHollowTree.oakSpawnBiomes) {
            biomes.add(biomeSupplier.get());
        }
        return biomes;
    }
    
    static {
        oakSpawnBiomes = Arrays.asList(() -> TFBiomes.twilightForest, () -> TFBiomes.denseTwilightForest, () -> TFBiomes.mushrooms, () -> TFBiomes.tfSwamp, () -> TFBiomes.clearing, () -> TFBiomes.oakSavanna, () -> TFBiomes.fireflyForest, () -> TFBiomes.deepMushrooms, () -> TFBiomes.enchantedForest, () -> TFBiomes.fireSwamp);
    }
}
