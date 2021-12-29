// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.BlockState;
import twilightforest.util.MushroomUtil;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenBigMushgloom extends Feature<NoFeatureConfig>
{
    public TFGenBigMushgloom(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final int height = 3 + rand.nextInt(2) + rand.nextInt(2);
        if (!FeatureUtil.isAreaSuitable((IWorld)world, pos.func_177982_a(-1, 0, -1), 3, height, 3)) {
            return false;
        }
        final Block blockUnder = world.func_180495_p(pos.func_177977_b()).func_177230_c();
        if (blockUnder != Blocks.field_150346_d && blockUnder != Blocks.field_196658_i && blockUnder != Blocks.field_150391_bh) {
            return false;
        }
        for (int dy = 0; dy < height - 2; ++dy) {
            world.func_180501_a(pos.func_177981_b(dy), ((Block)TFBlocks.huge_mushgloom_stem.get()).func_176223_P(), 3);
        }
        this.makeMushroomCap((IWorld)world, pos.func_177981_b(height - 2));
        if (rand.nextBoolean()) {
            this.makeMushroomCap((IWorld)world, pos.func_177981_b(height - 1));
        }
        return true;
    }
    
    private void makeMushroomCap(final IWorld world, final BlockPos pos) {
        final BlockState defState = ((Block)TFBlocks.huge_mushgloom.get()).func_176223_P();
        world.func_180501_a(pos.func_177982_a(-1, 0, -1), MushroomUtil.getState(MushroomUtil.Type.NORTH_WEST, defState), 3);
        world.func_180501_a(pos.func_177982_a(0, 0, -1), MushroomUtil.getState(MushroomUtil.Type.NORTH, defState), 3);
        world.func_180501_a(pos.func_177982_a(1, 0, -1), MushroomUtil.getState(MushroomUtil.Type.NORTH_EAST, defState), 3);
        world.func_180501_a(pos.func_177982_a(-1, 0, 0), MushroomUtil.getState(MushroomUtil.Type.WEST, defState), 3);
        world.func_180501_a(pos, MushroomUtil.getState(MushroomUtil.Type.CENTER, defState), 3);
        world.func_180501_a(pos.func_177982_a(1, 0, 0), MushroomUtil.getState(MushroomUtil.Type.EAST, defState), 3);
        world.func_180501_a(pos.func_177982_a(-1, 0, 1), MushroomUtil.getState(MushroomUtil.Type.SOUTH_WEST, defState), 3);
        world.func_180501_a(pos.func_177982_a(0, 0, 1), MushroomUtil.getState(MushroomUtil.Type.SOUTH, defState), 3);
        world.func_180501_a(pos.func_177982_a(1, 0, 1), MushroomUtil.getState(MushroomUtil.Type.SOUTH_EAST, defState), 3);
    }
}
