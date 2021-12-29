// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.Blocks;
import twilightforest.util.FeatureLogic;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenFoundation extends Feature<NoneFeatureConfiguration>
{
    public TFGenFoundation(final Codec<NoneFeatureConfiguration> configIn) {
        super((Codec)configIn);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final int sx = 5 + rand.nextInt(5);
        final int sz = 5 + rand.nextInt(5);
        if (!FeatureUtil.isAreaSuitable(world, pos, sx + 1, 4, sz + 1)) {
            return false;
        }
        for (int cx = 0; cx <= sx; ++cx) {
            for (int cz = 0; cz <= sz; ++cz) {
                if (cx == 0 || cx == sx || cz == 0 || cz == sz) {
                    for (int ht = rand.nextInt(4) + 1, cy = 0; cy <= ht; ++cy) {
                        world.m_7731_(pos.m_142082_(cx, cy - 1, cz), FeatureLogic.randStone(rand, cy + 1), 3);
                    }
                }
                else if (rand.nextInt(3) != 0) {
                    world.m_7731_(pos.m_142082_(cx, -1, cz), Blocks.f_50705_.m_49966_(), 3);
                }
            }
        }
        if (rand.nextInt(2) == 0) {
            for (int cx = 1; cx < sx; ++cx) {
                for (int cz = 1; cz < sz; ++cz) {
                    world.m_7731_(pos.m_142082_(cx, -3, cz), Blocks.f_50016_.m_49966_(), 3);
                    world.m_7731_(pos.m_142082_(cx, -4, cz), Blocks.f_50016_.m_49966_(), 3);
                }
            }
            int cx = rand.nextInt(sx - 1) + 1;
            int cz = rand.nextInt(sz - 1) + 1;
            TFTreasure.FOUNDATION_BASEMENT.generateChest(world, pos.m_142082_(cx, -4, cz), Direction.NORTH, false);
        }
        return true;
    }
}
