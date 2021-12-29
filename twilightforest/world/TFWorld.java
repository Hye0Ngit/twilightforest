// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import java.util.function.Predicate;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.biome.Biome;
import twilightforest.TFConfig;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;

public class TFWorld
{
    public static final int SEALEVEL = 31;
    public static final int CHUNKHEIGHT = 256;
    public static final int MAXHEIGHT = 256;
    
    @Nullable
    public static ChunkGeneratorTFBase getChunkGenerator(final World world) {
        if (world instanceof WorldServer) {
            final IChunkGenerator chunkGenerator = ((WorldServer)world).func_72863_F().field_186029_c;
            return (chunkGenerator instanceof ChunkGeneratorTFBase) ? chunkGenerator : null;
        }
        return null;
    }
    
    public static boolean isTwilightForest(final World world) {
        return world.field_73011_w instanceof WorldProviderTwilightForest;
    }
    
    public static NBTTagCompound getDimensionData(final World world) {
        return world.func_72912_H().getDimensionData(TFConfig.dimension.dimensionID);
    }
    
    public static void setDimensionData(final World world, final NBTTagCompound data) {
        world.func_72912_H().setDimensionData(TFConfig.dimension.dimensionID, data);
    }
    
    public static boolean isProgressionEnforced(final World world) {
        return world.func_82736_K().func_82766_b("tfEnforcedProgression");
    }
    
    public static boolean isBiomeSafeFor(final Biome biome, final Entity entity) {
        return !(biome instanceof TFBiomeBase) || !(entity instanceof EntityPlayer) || ((TFBiomeBase)biome).doesPlayerHaveRequiredAdvancements((EntityPlayer)entity);
    }
    
    public static void markStructureConquered(final World world, final BlockPos pos, final TFFeature feature) {
        final ChunkGeneratorTFBase generator = getChunkGenerator(world);
        if (generator != null && TFFeature.getFeatureAt(pos.func_177958_n(), pos.func_177952_p(), world) == feature) {
            generator.setStructureConquered(pos, true);
        }
    }
    
    public static int getGroundLevel(final World world, final int x, final int z) {
        return getGroundLevel(world, x, z, block -> false);
    }
    
    public static int getGroundLevel(final World world, final int x, final int z, final Predicate<Block> extraBlocks) {
        final Chunk chunk = world.func_72964_e(x >> 4, z >> 4);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int lastDirt = 31;
        for (int y = 31; y < 255; ++y) {
            final Block block = chunk.func_177435_g((BlockPos)pos.func_181079_c(x, y, z)).func_177230_c();
            if (block == Blocks.field_150349_c) {
                return y + 1;
            }
            if (block == Blocks.field_150346_d || block == Blocks.field_150348_b || block == Blocks.field_150351_n || extraBlocks.test(block)) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
    }
}
