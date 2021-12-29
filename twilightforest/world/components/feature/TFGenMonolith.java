// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.passive.Raven;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenMonolith extends Feature<NoneFeatureConfiguration>
{
    public TFGenMonolith(final Codec<NoneFeatureConfiguration> configIn) {
        super((Codec)configIn);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final int ht = rand.nextInt(10) + 10;
        final int dir = rand.nextInt(4);
        if (!FeatureUtil.isAreaSuitable(world, pos, 2, ht, 2)) {
            return false;
        }
        int h0 = 0;
        int h2 = 0;
        int h3 = 0;
        int h4 = 0;
        switch (dir) {
            case 0: {
                h0 = ht;
                h2 = (int)(ht * 0.75);
                h3 = (int)(ht * 0.75);
                h4 = (int)(ht * 0.5);
                break;
            }
            case 1: {
                h0 = (int)(ht * 0.5);
                h2 = ht;
                h3 = (int)(ht * 0.75);
                h4 = (int)(ht * 0.75);
                break;
            }
            case 2: {
                h0 = (int)(ht * 0.75);
                h2 = (int)(ht * 0.5);
                h3 = ht;
                h4 = (int)(ht * 0.75);
                break;
            }
            default: {
                h0 = (int)(ht * 0.75);
                h2 = (int)(ht * 0.75);
                h3 = (int)(ht * 0.5);
                h4 = ht;
                break;
            }
        }
        for (int cy = 0; cy <= h0; ++cy) {
            world.m_7731_(pos.m_142082_(0, cy - 1, 0), (cy == ht) ? Blocks.f_50060_.m_49966_() : Blocks.f_50080_.m_49966_(), 3);
        }
        for (int cy = 0; cy <= h2; ++cy) {
            world.m_7731_(pos.m_142082_(1, cy - 1, 0), (cy == ht) ? Blocks.f_50060_.m_49966_() : Blocks.f_50080_.m_49966_(), 3);
        }
        for (int cy = 0; cy <= h3; ++cy) {
            world.m_7731_(pos.m_142082_(0, cy - 1, 1), (cy == ht) ? Blocks.f_50060_.m_49966_() : Blocks.f_50080_.m_49966_(), 3);
        }
        for (int cy = 0; cy <= h4; ++cy) {
            world.m_7731_(pos.m_142082_(1, cy - 1, 1), (cy == ht) ? Blocks.f_50060_.m_49966_() : Blocks.f_50080_.m_49966_(), 3);
        }
        for (int i = 0; i < 2; ++i) {
            BlockPos dPos = pos.m_142082_(rand.nextInt(8) - rand.nextInt(8), 0, rand.nextInt(8) - rand.nextInt(8));
            dPos = world.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, dPos);
            if (dPos.m_123342_() > 0) {
                final Raven raven = new Raven(TFEntities.RAVEN, (Level)world.m_6018_());
                raven.m_20035_(dPos, rand.nextFloat() * 360.0f, 0.0f);
                world.m_7967_((Entity)raven);
            }
        }
        return true;
    }
}
