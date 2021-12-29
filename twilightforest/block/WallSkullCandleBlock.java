// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.Util;
import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import twilightforest.block.entity.SkullCandleBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.phys.Vec3;
import java.util.List;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import java.util.Map;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class WallSkullCandleBlock extends AbstractSkullCandleBlock
{
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> AABBS;
    private static final Int2ObjectMap<List<Vec3>> PARTICLE_OFFSETS;
    
    public WallSkullCandleBlock(final SkullBlock.Type type, final BlockBehaviour.Properties properties) {
        super(type, properties);
        this.m_49959_((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)Direction.NORTH));
    }
    
    public VoxelShape m_5940_(final BlockState p_58114_, final BlockGetter p_58115_, final BlockPos p_58116_, final CollisionContext p_58117_) {
        return WallSkullCandleBlock.AABBS.get(p_58114_.m_61143_((Property)WallSkullCandleBlock.FACING));
    }
    
    @Override
    protected Iterable<Vec3> getParticleOffsets(final BlockState state, final Level level, final BlockPos pos) {
        final BlockEntity 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            return (Iterable)WallSkullCandleBlock.PARTICLE_OFFSETS.get(sc.candleAmount);
        }
        return (Iterable)WallSkullCandleBlock.PARTICLE_OFFSETS.get(1);
    }
    
    public BlockState m_5573_(final BlockPlaceContext ctx) {
        BlockState state = this.m_49966_();
        final BlockGetter getter = (BlockGetter)ctx.m_43725_();
        final BlockPos pos = ctx.m_8083_();
        final Direction[] 6232_;
        final Direction[] directions = 6232_ = ctx.m_6232_();
        for (final Direction dir : 6232_) {
            if (dir.m_122434_().m_122479_()) {
                final Direction var10 = dir.m_122424_();
                state = (BlockState)state.m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)var10);
                if (!getter.m_8055_(pos.m_142300_(dir)).m_60629_(ctx)) {
                    return (BlockState)state.m_61124_((Property)WallSkullCandleBlock.LIGHTING, (Comparable)Lighting.NONE);
                }
            }
        }
        return null;
    }
    
    @Override
    public void m_7100_(final BlockState state, final Level level, final BlockPos pos, final Random rand) {
        final Direction dir = (Direction)state.m_61143_((Property)WallSkullCandleBlock.FACING);
        if (state.m_61143_((Property)WallSkullCandleBlock.LIGHTING) != Lighting.NONE) {
            this.getParticleOffsets(state, level, pos).forEach(offset -> AbstractLightableBlock.addParticlesAndSound(level, offset.m_82520_((double)(pos.m_123341_() - dir.m_122429_() * 0.25f), (double)pos.m_123342_(), (double)(pos.m_123343_() - dir.m_122431_() * 0.25f)), rand, state.m_61143_((Property)WallSkullCandleBlock.LIGHTING) == Lighting.OMINOUS));
        }
    }
    
    public BlockState m_6843_(final BlockState state, final Rotation rot) {
        return (BlockState)state.m_61124_((Property)WallSkullCandleBlock.FACING, (Comparable)rot.m_55954_((Direction)state.m_61143_((Property)WallSkullCandleBlock.FACING)));
    }
    
    public BlockState m_6943_(final BlockState state, final Mirror mirror) {
        return state.m_60717_(mirror.m_54846_((Direction)state.m_61143_((Property)WallSkullCandleBlock.FACING)));
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)WallSkullCandleBlock.FACING });
    }
    
    static {
        FACING = HorizontalDirectionalBlock.f_54117_;
        AABBS = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.m_49796_(4.0, 4.0, 8.0, 12.0, 12.0, 16.0), (Object)Direction.SOUTH, (Object)Block.m_49796_(4.0, 4.0, 0.0, 12.0, 12.0, 8.0), (Object)Direction.EAST, (Object)Block.m_49796_(0.0, 4.0, 4.0, 8.0, 12.0, 12.0), (Object)Direction.WEST, (Object)Block.m_49796_(8.0, 4.0, 4.0, 16.0, 12.0, 12.0)));
        PARTICLE_OFFSETS = (Int2ObjectMap)Util.m_137537_(() -> {
            final Int2ObjectOpenHashMap var0 = new Int2ObjectOpenHashMap();
            ((Int2ObjectMap)var0).defaultReturnValue((Object)ImmutableList.of());
            ((Int2ObjectMap)var0).put(1, (Object)ImmutableList.of((Object)new Vec3(0.5, 1.25, 0.5)));
            ((Int2ObjectMap)var0).put(2, (Object)ImmutableList.of((Object)new Vec3(0.375, 1.19, 0.5), (Object)new Vec3(0.625, 1.25, 0.44)));
            ((Int2ObjectMap)var0).put(3, (Object)ImmutableList.of((Object)new Vec3(0.5, 1.063, 0.625), (Object)new Vec3(0.375, 1.19, 0.5), (Object)new Vec3(0.56, 1.25, 0.44)));
            ((Int2ObjectMap)var0).put(4, (Object)ImmutableList.of((Object)new Vec3(0.44, 1.063, 0.56), (Object)new Vec3(0.625, 1.19, 0.56), (Object)new Vec3(0.375, 1.19, 0.375), (Object)new Vec3(0.56, 1.25, 0.375)));
            return Int2ObjectMaps.unmodifiable((Int2ObjectMap)var0);
        });
    }
}
