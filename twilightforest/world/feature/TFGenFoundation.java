// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.util.Direction;
import twilightforest.loot.TFTreasure;
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

public class TFGenFoundation extends Feature<NoFeatureConfig>
{
    public TFGenFoundation(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final int sx = 5 + rand.nextInt(5);
        final int sz = 5 + rand.nextInt(5);
        if (!FeatureUtil.isAreaSuitable((IWorld)world, pos, sx, 4, sz)) {
            return false;
        }
        for (int cx = 0; cx <= sx; ++cx) {
            for (int cz = 0; cz <= sz; ++cz) {
                if (cx == 0 || cx == sx || cz == 0 || cz == sz) {
                    for (int ht = rand.nextInt(4) + 1, cy = 0; cy <= ht; ++cy) {
                        world.func_180501_a(pos.func_177982_a(cx, cy - 1, cz), FeatureUtil.randStone(rand, cy + 1), 3);
                    }
                }
                else if (rand.nextInt(3) != 0) {
                    world.func_180501_a(pos.func_177982_a(cx, -1, cz), Blocks.field_196662_n.func_176223_P(), 3);
                }
            }
        }
        if (rand.nextInt(2) == 0) {
            for (int cx = 1; cx < sx; ++cx) {
                for (int cz = 1; cz < sz; ++cz) {
                    world.func_180501_a(pos.func_177982_a(cx, -3, cz), Blocks.field_150350_a.func_176223_P(), 3);
                    world.func_180501_a(pos.func_177982_a(cx, -4, cz), Blocks.field_150350_a.func_176223_P(), 3);
                }
            }
            int cx = rand.nextInt(sx - 1) + 1;
            int cz = rand.nextInt(sz - 1) + 1;
            TFTreasure.basement.generateChest((IWorld)world, pos.func_177982_a(cx, -4, cz), Direction.NORTH, false);
        }
        return true;
    }
}
