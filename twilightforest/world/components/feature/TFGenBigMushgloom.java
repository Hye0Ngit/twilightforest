// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import twilightforest.util.HugeMushroomUtil;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenBigMushgloom extends Feature<NoneFeatureConfiguration>
{
    public TFGenBigMushgloom(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final int height = 3 + rand.nextInt(2) + rand.nextInt(2);
        if (!FeatureUtil.isAreaSuitable(world, pos.m_142082_(-1, 0, -1), 3, height, 3)) {
            return false;
        }
        final BlockState blockUnder = world.m_8055_(pos.m_7495_());
        if (!m_159759_(blockUnder) && !blockUnder.m_60620_((Tag)BlockTags.f_13057_)) {
            return false;
        }
        for (int dy = 0; dy < height - 2; ++dy) {
            world.m_7731_(pos.m_6630_(dy), ((Block)TFBlocks.HUGE_MUSHGLOOM_STEM.get()).m_49966_(), 3);
        }
        this.makeMushroomCap((LevelAccessor)world, pos.m_6630_(height - 2));
        if (rand.nextBoolean()) {
            this.makeMushroomCap((LevelAccessor)world, pos.m_6630_(height - 1));
        }
        return true;
    }
    
    private void makeMushroomCap(final LevelAccessor world, final BlockPos pos) {
        final BlockState defState = ((Block)TFBlocks.HUGE_MUSHGLOOM.get()).m_49966_();
        world.m_7731_(pos.m_142082_(-1, 0, -1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_WEST, defState), 3);
        world.m_7731_(pos.m_142082_(0, 0, -1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH, defState), 3);
        world.m_7731_(pos.m_142082_(1, 0, -1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_EAST, defState), 3);
        world.m_7731_(pos.m_142082_(-1, 0, 0), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.WEST, defState), 3);
        world.m_7731_(pos, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, defState), 3);
        world.m_7731_(pos.m_142082_(1, 0, 0), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.EAST, defState), 3);
        world.m_7731_(pos.m_142082_(-1, 0, 1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_WEST, defState), 3);
        world.m_7731_(pos.m_142082_(0, 0, 1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH, defState), 3);
        world.m_7731_(pos.m_142082_(1, 0, 1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_EAST, defState), 3);
    }
}
