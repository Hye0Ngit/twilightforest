// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.Util;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import twilightforest.block.entity.SkullCandleBlockEntity;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SkullCandleBlock extends AbstractSkullCandleBlock
{
    public static final IntegerProperty ROTATION;
    protected static final VoxelShape SHAPE;
    protected static final VoxelShape ONE_CANDLE;
    protected static final VoxelShape TWO_CANDLE;
    protected static final VoxelShape THREE_CANDLE;
    protected static final VoxelShape FOUR_CANDLE;
    protected static final VoxelShape SKULL_WITH_ONE;
    protected static final VoxelShape SKULL_WITH_TWO;
    protected static final VoxelShape SKULL_WITH_THREE;
    protected static final VoxelShape SKULL_WITH_FOUR;
    private static final Int2ObjectMap<List<Vec3>> PARTICLE_OFFSETS;
    
    public SkullCandleBlock(final SkullBlock.Type type, final BlockBehaviour.Properties properties) {
        super(type, properties);
        this.m_49959_((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)0));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter getter, final BlockPos pos, final CollisionContext ctx) {
        final BlockEntity 7702_ = getter.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            return switch (sc.candleAmount) {
                default -> SkullCandleBlock.SKULL_WITH_ONE;
                case 2 -> SkullCandleBlock.SKULL_WITH_TWO;
                case 3 -> SkullCandleBlock.SKULL_WITH_THREE;
                case 4 -> SkullCandleBlock.SKULL_WITH_FOUR;
            };
        }
        return switch (this.getCandleCount()) {
            default -> SkullCandleBlock.SKULL_WITH_ONE;
            case 2 -> SkullCandleBlock.SKULL_WITH_TWO;
            case 3 -> SkullCandleBlock.SKULL_WITH_THREE;
            case 4 -> SkullCandleBlock.SKULL_WITH_FOUR;
        };
    }
    
    @Override
    protected Iterable<Vec3> getParticleOffsets(final BlockState state, final Level level, final BlockPos pos) {
        final BlockEntity 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            return (Iterable)SkullCandleBlock.PARTICLE_OFFSETS.get(sc.candleAmount);
        }
        return (Iterable)SkullCandleBlock.PARTICLE_OFFSETS.get(this.getCandleCount());
    }
    
    public BlockState m_5573_(final BlockPlaceContext ctx) {
        return (BlockState)((BlockState)this.m_49966_().m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)(Mth.m_14107_(ctx.m_7074_() * 16.0f / 360.0f + 0.5) & 0xF))).m_61124_((Property)SkullCandleBlock.LIGHTING, (Comparable)Lighting.NONE);
    }
    
    public BlockState m_6843_(final BlockState state, final Rotation rot) {
        return (BlockState)state.m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)rot.m_55949_((int)state.m_61143_((Property)SkullCandleBlock.ROTATION), 16));
    }
    
    public BlockState m_6943_(final BlockState state, final Mirror mirror) {
        return (BlockState)state.m_61124_((Property)SkullCandleBlock.ROTATION, (Comparable)mirror.m_54843_((int)state.m_61143_((Property)SkullCandleBlock.ROTATION), 16));
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)SkullCandleBlock.ROTATION });
    }
    
    static {
        ROTATION = BlockStateProperties.f_61390_;
        SHAPE = Block.m_49796_(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
        ONE_CANDLE = Block.m_49796_(7.0, 8.0, 7.0, 9.0, 14.0, 9.0);
        TWO_CANDLE = Block.m_49796_(5.0, 8.0, 6.0, 11.0, 14.0, 9.0);
        THREE_CANDLE = Block.m_49796_(5.0, 8.0, 6.0, 10.0, 14.0, 11.0);
        FOUR_CANDLE = Block.m_49796_(5.0, 8.0, 5.0, 11.0, 14.0, 10.0);
        SKULL_WITH_ONE = Shapes.m_83110_(SkullCandleBlock.SHAPE, SkullCandleBlock.ONE_CANDLE);
        SKULL_WITH_TWO = Shapes.m_83110_(SkullCandleBlock.SHAPE, SkullCandleBlock.TWO_CANDLE);
        SKULL_WITH_THREE = Shapes.m_83110_(SkullCandleBlock.SHAPE, SkullCandleBlock.THREE_CANDLE);
        SKULL_WITH_FOUR = Shapes.m_83110_(SkullCandleBlock.SHAPE, SkullCandleBlock.FOUR_CANDLE);
        PARTICLE_OFFSETS = (Int2ObjectMap)Util.m_137537_(() -> {
            final Int2ObjectOpenHashMap var0 = new Int2ObjectOpenHashMap();
            ((Int2ObjectMap)var0).defaultReturnValue((Object)ImmutableList.of());
            ((Int2ObjectMap)var0).put(1, (Object)ImmutableList.of((Object)new Vec3(0.5, 1.0, 0.5)));
            ((Int2ObjectMap)var0).put(2, (Object)ImmutableList.of((Object)new Vec3(0.375, 0.94, 0.5), (Object)new Vec3(0.625, 1.0, 0.44)));
            ((Int2ObjectMap)var0).put(3, (Object)ImmutableList.of((Object)new Vec3(0.5, 0.813, 0.625), (Object)new Vec3(0.375, 0.94, 0.5), (Object)new Vec3(0.56, 1.0, 0.44)));
            ((Int2ObjectMap)var0).put(4, (Object)ImmutableList.of((Object)new Vec3(0.44, 0.813, 0.56), (Object)new Vec3(0.625, 0.94, 0.56), (Object)new Vec3(0.375, 0.94, 0.375), (Object)new Vec3(0.56, 1.0, 0.375)));
            return Int2ObjectMaps.unmodifiable((Int2ObjectMap)var0);
        });
    }
}
