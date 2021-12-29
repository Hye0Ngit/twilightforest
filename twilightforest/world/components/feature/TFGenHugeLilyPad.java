// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.world.level.material.Material;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.TFBlocks;
import twilightforest.block.HugeLilyPadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenHugeLilyPad extends Feature<NoneFeatureConfiguration>
{
    public TFGenHugeLilyPad(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random random = ctx.m_159776_();
        for (int i = 0; i < 10; ++i) {
            final BlockPos dPos = pos.m_142082_(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (this.shouldPlacePadAt((LevelAccessor)world, dPos) && world.isAreaLoaded(dPos, 1)) {
                final Direction horizontal = Direction.m_122407_(random.nextInt(4));
                final BlockState lilypad = (BlockState)((HugeLilyPadBlock)TFBlocks.HUGE_LILY_PAD.get()).m_49966_().m_61124_((Property)HugeLilyPadBlock.FACING, (Comparable)horizontal);
                world.m_7731_(dPos, (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NW), 18);
                world.m_7731_(dPos.m_142126_(), (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NE), 18);
                world.m_7731_(dPos.m_142126_().m_142128_(), (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.SE), 18);
                world.m_7731_(dPos.m_142128_(), (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.SW), 18);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final LevelAccessor world, final BlockPos pos) {
        return world.m_46859_(pos) && world.m_8055_(pos.m_7495_()).m_60767_() == Material.f_76305_ && world.m_46859_(pos.m_142126_()) && world.m_8055_(pos.m_142126_().m_7495_()).m_60767_() == Material.f_76305_ && world.m_46859_(pos.m_142128_()) && world.m_8055_(pos.m_142128_().m_7495_()).m_60767_() == Material.f_76305_ && world.m_46859_(pos.m_142126_().m_142128_()) && world.m_8055_(pos.m_142126_().m_142128_().m_7495_()).m_60767_() == Material.f_76305_;
    }
}
