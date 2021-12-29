// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Arrays;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.structures.hollowtree.StructureTFHollowTreeStart;
import twilightforest.TFFeature;
import twilightforest.TwilightForestMod;
import java.util.Iterator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import java.util.HashMap;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.List;
import net.minecraft.world.gen.structure.StructureStart;
import java.util.Map;
import net.minecraft.world.gen.MapGenBase;

public class MapGenTFHollowTree extends MapGenBase
{
    protected Map<Long, StructureStart> structureMap;
    public static List<BiomeGenBase> oakSpawnBiomes;
    
    public MapGenTFHollowTree() {
        this.structureMap = new HashMap<Long, StructureStart>();
    }
    
    protected void func_151538_a(final World world, final int chunkX, final int chunkZ, final int centerX, final int centerZ, final Block[] blockData) {
        if (!this.structureMap.containsKey(ChunkCoordIntPair.func_77272_a(chunkX, chunkZ))) {
            this.field_75038_b.nextInt();
            try {
                if (this.canSpawnStructureAtCoords(chunkX, chunkZ)) {
                    final StructureStart structurestart = this.getStructureStart(chunkX, chunkZ);
                    this.structureMap.put(ChunkCoordIntPair.func_77272_a(chunkX, chunkZ), structurestart);
                }
            }
            catch (Throwable throwable) {
                final CrashReport crashreport = CrashReport.func_85055_a(throwable, "Exception preparing hollow tree");
                final CrashReportCategory crashreportcategory = crashreport.func_85058_a("Feature being prepared");
                crashreportcategory.func_71500_a("Is feature chunk", (Callable)new Callable() {
                    private static final String __OBFID = "CL_00000506";
                    
                    @Override
                    public String call() {
                        return MapGenTFHollowTree.this.canSpawnStructureAtCoords(chunkX, chunkZ) ? "True" : "False";
                    }
                });
                crashreportcategory.func_71507_a("Chunk location", (Object)String.format("%d,%d", chunkX, chunkZ));
                crashreportcategory.func_71500_a("Chunk pos hash", (Callable)new Callable() {
                    private static final String __OBFID = "CL_00000507";
                    
                    @Override
                    public String call() {
                        return String.valueOf(ChunkCoordIntPair.func_77272_a(chunkX, chunkZ));
                    }
                });
                crashreportcategory.func_71500_a("Structure type", (Callable)new Callable() {
                    private static final String __OBFID = "CL_00000508";
                    
                    @Override
                    public String call() {
                        return MapGenTFHollowTree.this.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(crashreport);
            }
        }
    }
    
    public boolean generateStructuresInChunk(final World world, final Random rand, final int chunkX, final int chunkZ) {
        final int mapX = (chunkX << 4) + 8;
        final int mapZ = (chunkZ << 4) + 8;
        boolean flag = false;
        for (final StructureStart structurestart : this.structureMap.values()) {
            if (structurestart.func_75069_d() && structurestart.func_75071_a().func_78885_a(mapX, mapZ, mapX + 15, mapZ + 15)) {
                structurestart.func_75068_a(world, rand, new StructureBoundingBox(mapX, mapZ, mapX + 15, mapZ + 15));
                flag = true;
            }
        }
        return flag;
    }
    
    protected boolean canSpawnStructureAtCoords(final int chunkX, final int chunkZ) {
        return this.field_75038_b.nextInt(TwilightForestMod.twilightOakChance) == 0 && TFFeature.getNearestFeature(chunkX, chunkZ, this.field_75039_c).areChunkDecorationsEnabled && this.field_75039_c.func_72959_q().func_76940_a(chunkX * 16 + 8, chunkZ * 16 + 8, 0, (List)MapGenTFHollowTree.oakSpawnBiomes);
    }
    
    protected StructureStart getStructureStart(final int chunkX, final int chunkZ) {
        return new StructureTFHollowTreeStart(this.field_75039_c, this.field_75038_b, chunkX, chunkZ);
    }
    
    static {
        MapGenTFHollowTree.oakSpawnBiomes = Arrays.asList(TFBiomeBase.twilightForest, TFBiomeBase.twilightForest2, TFBiomeBase.mushrooms, TFBiomeBase.tfSwamp, TFBiomeBase.clearing, TFBiomeBase.oakSavanna, TFBiomeBase.fireflyForest, TFBiomeBase.deepMushrooms, TFBiomeBase.enchantedForest, TFBiomeBase.fireSwamp);
    }
}
