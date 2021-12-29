// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.DustParticleOptions;
import com.mojang.math.Vector3f;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Random;
import net.minecraft.world.level.Level;
import java.util.Iterator;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.Direction;
import java.util.Map;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Block;

public class TrollsteinnBlock extends Block
{
    private static final BooleanProperty DOWN_LIT;
    private static final BooleanProperty UP_LIT;
    private static final BooleanProperty NORTH_LIT;
    private static final BooleanProperty SOUTH_LIT;
    private static final BooleanProperty WEST_LIT;
    private static final BooleanProperty EAST_LIT;
    private static final Map<Direction, BooleanProperty> PROPERTY_MAP;
    private static final int LIGHT_THRESHHOLD = 7;
    
    public TrollsteinnBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)TrollsteinnBlock.DOWN_LIT, (Comparable)false)).m_61124_((Property)TrollsteinnBlock.UP_LIT, (Comparable)false)).m_61124_((Property)TrollsteinnBlock.NORTH_LIT, (Comparable)false)).m_61124_((Property)TrollsteinnBlock.SOUTH_LIT, (Comparable)false)).m_61124_((Property)TrollsteinnBlock.WEST_LIT, (Comparable)false)).m_61124_((Property)TrollsteinnBlock.EAST_LIT, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)TrollsteinnBlock.DOWN_LIT, (Property)TrollsteinnBlock.UP_LIT, (Property)TrollsteinnBlock.NORTH_LIT, (Property)TrollsteinnBlock.SOUTH_LIT, (Property)TrollsteinnBlock.WEST_LIT, (Property)TrollsteinnBlock.EAST_LIT });
    }
    
    public BlockState m_7417_(final BlockState state, final Direction dirToNeighbor, final BlockState neighborState, final LevelAccessor world, final BlockPos pos, final BlockPos neighborPos) {
        final boolean lit = world.m_46803_(neighborPos) > 7;
        return (BlockState)state.m_61124_((Property)TrollsteinnBlock.PROPERTY_MAP.get(dirToNeighbor), (Comparable)lit);
    }
    
    public BlockState m_5573_(final BlockPlaceContext ctx) {
        BlockState ret = this.m_49966_();
        for (final Map.Entry<Direction, BooleanProperty> e : TrollsteinnBlock.PROPERTY_MAP.entrySet()) {
            final int light = ctx.m_43725_().m_46803_(ctx.m_8083_().m_142300_((Direction)e.getKey()));
            ret = (BlockState)ret.m_61124_((Property)e.getValue(), (Comparable)(light > 7));
        }
        return ret;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState state, final Level world, final BlockPos pos, final Random rand) {
        if (rand.nextInt(2) == 0) {
            this.sparkle(world, pos);
        }
    }
    
    private void sparkle(final Level world, final BlockPos pos) {
        final Random random = world.f_46441_;
        final int threshhold = 7;
        for (final Direction side : Direction.values()) {
            double rx = pos.m_123341_() + random.nextFloat();
            double ry = pos.m_123342_() + random.nextFloat();
            double rz = pos.m_123343_() + random.nextFloat();
            if (side == Direction.DOWN && !world.m_8055_(pos.m_7495_()).m_60804_((BlockGetter)world, pos) && world.m_46803_(pos.m_7495_()) <= threshhold) {
                ry = pos.m_123342_() - 0.0625;
            }
            if (side == Direction.UP && !world.m_8055_(pos.m_7494_()).m_60804_((BlockGetter)world, pos) && world.m_46803_(pos.m_7494_()) <= threshhold) {
                ry = pos.m_123342_() + 0.0625 + 1.0;
            }
            if (side == Direction.NORTH && !world.m_8055_(pos.m_142127_()).m_60804_((BlockGetter)world, pos) && world.m_46803_(pos.m_142127_()) <= threshhold) {
                rz = pos.m_123343_() - 0.0625;
            }
            if (side == Direction.SOUTH && !world.m_8055_(pos.m_142128_()).m_60804_((BlockGetter)world, pos) && world.m_46803_(pos.m_142128_()) <= threshhold) {
                rz = pos.m_123343_() + 0.0625 + 1.0;
            }
            if (side == Direction.WEST && !world.m_8055_(pos.m_142125_()).m_60804_((BlockGetter)world, pos) && world.m_46803_(pos.m_142125_()) <= threshhold) {
                rx = pos.m_123341_() - 0.0625;
            }
            if (side == Direction.EAST && !world.m_8055_(pos.m_142126_()).m_60804_((BlockGetter)world, pos) && world.m_46803_(pos.m_142126_()) <= threshhold) {
                rx = pos.m_123341_() + 0.0625 + 1.0;
            }
            if (rx < pos.m_123341_() || rx > pos.m_123341_() + 1 || ry < 0.0 || ry > pos.m_123342_() + 1 || rz < pos.m_123343_() || rz > pos.m_123343_() + 1) {
                world.m_7106_((ParticleOptions)new DustParticleOptions(new Vector3f(0.5f, 0.0f, 0.5f), 1.0f), rx, ry, rz, 0.25, -1.0, 0.5);
            }
        }
    }
    
    static {
        DOWN_LIT = BooleanProperty.m_61465_("down");
        UP_LIT = BooleanProperty.m_61465_("up");
        NORTH_LIT = BooleanProperty.m_61465_("north");
        SOUTH_LIT = BooleanProperty.m_61465_("south");
        WEST_LIT = BooleanProperty.m_61465_("west");
        EAST_LIT = BooleanProperty.m_61465_("east");
        PROPERTY_MAP = (Map)ImmutableMap.builder().put((Object)Direction.DOWN, (Object)TrollsteinnBlock.DOWN_LIT).put((Object)Direction.UP, (Object)TrollsteinnBlock.UP_LIT).put((Object)Direction.NORTH, (Object)TrollsteinnBlock.NORTH_LIT).put((Object)Direction.SOUTH, (Object)TrollsteinnBlock.SOUTH_LIT).put((Object)Direction.WEST, (Object)TrollsteinnBlock.WEST_LIT).put((Object)Direction.EAST, (Object)TrollsteinnBlock.EAST_LIT).build();
    }
}
