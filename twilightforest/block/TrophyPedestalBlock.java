// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.state.properties.BlockStateProperties;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.util.PlayerHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import java.util.Iterator;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.ITag;
import twilightforest.data.BlockTagGenerator;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.world.World;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.StateContainer;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Block;

public class TrophyPedestalBlock extends Block implements IWaterLoggable
{
    public static final BooleanProperty ACTIVE;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape AABB;
    
    public TrophyPedestalBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.func_176223_P().func_206870_a((Property)TrophyPedestalBlock.ACTIVE, (Comparable)false)).func_206870_a((Property)TrophyPedestalBlock.WATERLOGGED, (Comparable)false));
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)TrophyPedestalBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        final boolean flag = fluidstate.func_206886_c() == Fluids.field_204546_a;
        return (BlockState)super.func_196258_a(context).func_206870_a((Property)TrophyPedestalBlock.WATERLOGGED, (Comparable)flag);
    }
    
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.func_177229_b((Property)TrophyPedestalBlock.WATERLOGGED)) {
            worldIn.func_205219_F_().func_205360_a(currentPos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)worldIn));
        }
        return super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)TrophyPedestalBlock.ACTIVE, (Property)TrophyPedestalBlock.WATERLOGGED });
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return TrophyPedestalBlock.AABB;
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        world.func_175666_e(pos, (Block)this);
        if (world.field_72995_K || (boolean)state.func_177229_b((Property)TrophyPedestalBlock.ACTIVE) || !this.isTrophyOnTop(world, pos)) {
            return;
        }
        if (TFGenerationSettings.isProgressionEnforced(world)) {
            if (this.areNearbyPlayersEligible(world, pos)) {
                this.doPedestalEffect(world, pos, state);
            }
            this.warnIneligiblePlayers(world, pos);
        }
        else {
            this.doPedestalEffect(world, pos, state);
        }
        this.rewardNearbyPlayers(world, pos);
    }
    
    private boolean isTrophyOnTop(final World world, final BlockPos pos) {
        return world.func_180495_p(pos.func_177984_a()).func_177230_c().func_203417_a((ITag)BlockTagGenerator.TROPHIES);
    }
    
    private void warnIneligiblePlayers(final World world, final BlockPos pos) {
        for (final PlayerEntity player : world.func_217357_a((Class)PlayerEntity.class, new AxisAlignedBB(pos).func_186662_g(16.0))) {
            if (!this.isPlayerEligible(player)) {
                player.func_146105_b((ITextComponent)new TranslationTextComponent("twilightforest.trophy_pedestal.ineligible"), true);
            }
        }
    }
    
    private boolean areNearbyPlayersEligible(final World world, final BlockPos pos) {
        for (final PlayerEntity player : world.func_217357_a((Class)PlayerEntity.class, new AxisAlignedBB(pos).func_186662_g(16.0))) {
            if (this.isPlayerEligible(player)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPlayerEligible(final PlayerEntity player) {
        return PlayerHelper.doesPlayerHaveRequiredAdvancements(player, TwilightForestMod.prefix("progress_lich"));
    }
    
    private void doPedestalEffect(final World world, final BlockPos pos, final BlockState state) {
        world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)TrophyPedestalBlock.ACTIVE, (Comparable)true));
        this.removeNearbyShields(world, pos);
        world.func_184133_a((PlayerEntity)null, pos, TFSounds.PEDESTAL_ACTIVATE, SoundCategory.BLOCKS, 4.0f, 0.1f);
    }
    
    private void rewardNearbyPlayers(final World world, final BlockPos pos) {
        for (final ServerPlayerEntity player : world.func_217357_a((Class)ServerPlayerEntity.class, new AxisAlignedBB(pos).func_186662_g(16.0))) {
            TFAdvancements.PLACED_TROPHY_ON_PEDESTAL.trigger(player);
        }
    }
    
    private void removeNearbyShields(final World world, final BlockPos pos) {
        for (int sx = -5; sx <= 5; ++sx) {
            for (int sy = -5; sy <= 5; ++sy) {
                for (int sz = -5; sz <= 5; ++sz) {
                    if (world.func_180495_p(pos.func_177982_a(sx, sy, sz)).func_177230_c() == TFBlocks.stronghold_shield.get()) {
                        world.func_175655_b(pos.func_177982_a(sx, sy, sz), false);
                    }
                }
            }
        }
    }
    
    public float func_180647_a(final BlockState state, final PlayerEntity player, final IBlockReader worldIn, final BlockPos pos) {
        return state.func_177229_b((Property)TrophyPedestalBlock.ACTIVE) ? super.func_180647_a(state, player, worldIn, pos) : -1.0f;
    }
    
    public boolean func_149740_M(final BlockState state) {
        return true;
    }
    
    public int func_180641_l(final BlockState blockState, final World worldIn, final BlockPos pos) {
        final Block trophy = worldIn.func_180495_p(pos.func_177984_a()).func_177230_c();
        if (trophy instanceof TrophyBlock) {
            return ((TrophyBlock)trophy).getComparatorValue();
        }
        return 0;
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
        WATERLOGGED = BlockStateProperties.field_208198_y;
        AABB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375));
    }
}
