// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenGroveRuins extends Feature<NoFeatureConfig>
{
    private static final BlockState MOSSY_STONEBRICK;
    private static final BlockState CHISELED_STONEBRICK;
    
    public TFGenGroveRuins(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        if (rand.nextBoolean()) {
            return this.generateLargeArch((IWorld)world, rand, pos);
        }
        return this.generateSmallArch((IWorld)world, rand, pos);
    }
    
    private boolean generateLargeArch(final IWorld world, final Random rand, final BlockPos pos) {
        if (!FeatureUtil.isAreaSuitable(world, pos, 2, 7, 6)) {
            return false;
        }
        for (int dy = -2; dy <= 7; ++dy) {
            world.func_180501_a(pos.func_177982_a(0, dy, 1), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
            world.func_180501_a(pos.func_177982_a(1, dy, 1), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
            world.func_180501_a(pos.func_177982_a(0, dy, 2), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
            world.func_180501_a(pos.func_177982_a(1, dy, 2), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        }
        world.func_180501_a(pos.func_177982_a(0, -1, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, -1, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, -2, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, -2, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, -1, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, -1, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, -2, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, -2, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, -1, 5), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, -2, 5), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 6, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, 6, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 7, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, 7, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 6, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, 6, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 7, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, 7, 4), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, 7, 5), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 5, 0), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        return true;
    }
    
    private boolean generateSmallArch(final IWorld world, final Random rand, final BlockPos pos) {
        if (!FeatureUtil.isAreaSuitable(world, pos, 7, 5, 9)) {
            return false;
        }
        world.func_180501_a(pos.func_177982_a(0, 4, 0), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 3, 0), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(1, 4, 0), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(2, 4, 0), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 4, 1), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(0, 4, 2), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        for (int dy = -1; dy <= 5; ++dy) {
            world.func_180501_a(pos.func_177982_a(3, dy, 0), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        }
        world.func_180501_a(pos.func_177982_a(4, -1, 0), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(5, -1, 0), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(6, -1, 0), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(4, 5, 0), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        world.func_180501_a(pos.func_177982_a(5, 5, 0), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        for (int dy = -1; dy <= 5; ++dy) {
            world.func_180501_a(pos.func_177982_a(0, dy, 3), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
            world.func_180501_a(pos.func_177982_a(0, dy, 7), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        }
        for (int dz = 4; dz < 7; ++dz) {
            world.func_180501_a(pos.func_177982_a(0, -1, dz), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
            world.func_180501_a(pos.func_177982_a(0, 5, dz), TFGenGroveRuins.MOSSY_STONEBRICK, 3);
        }
        world.func_180501_a(pos.func_177982_a(0, 4, 8), TFGenGroveRuins.CHISELED_STONEBRICK, 3);
        return true;
    }
    
    static {
        MOSSY_STONEBRICK = Blocks.field_196698_dj.func_176223_P();
        CHISELED_STONEBRICK = Blocks.field_196702_dl.func_176223_P();
    }
}
