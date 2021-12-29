// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.state.StateContainer;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorldReader;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.IItemProvider;
import net.minecraft.stats.Stats;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.ServerPlayerEntity;
import twilightforest.item.TFItems;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.block.Block;

public class Experiment115Block extends Block
{
    public static final IntegerProperty BITES_TAKEN;
    public static final BooleanProperty REGENERATE;
    private static final VoxelShape QUARTER_SHAPE;
    private static final VoxelShape HALF_SHAPE;
    private static final VoxelShape THREE_QUARTER_SHAPE;
    private static final VoxelShape FULL_SHAPE;
    
    public Experiment115Block() {
        super(AbstractBlock.Properties.func_200949_a(Material.field_151568_F, MaterialColor.field_151668_h).func_200943_b(0.5f).func_200947_a(SoundType.field_185854_g).func_200944_c());
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)Experiment115Block.BITES_TAKEN, (Comparable)7)).func_206870_a((Property)Experiment115Block.REGENERATE, (Comparable)false));
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        switch ((int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN)) {
            default: {
                return Experiment115Block.FULL_SHAPE;
            }
            case 2:
            case 3: {
                return Experiment115Block.THREE_QUARTER_SHAPE;
            }
            case 4:
            case 5: {
                return Experiment115Block.HALF_SHAPE;
            }
            case 6:
            case 7: {
                return Experiment115Block.QUARTER_SHAPE;
            }
        }
    }
    
    @Deprecated
    public ActionResultType func_225533_a_(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockRayTraceResult hit) {
        final int bitesTaken = (int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN);
        final ItemStack stack = player.func_184586_b(hand);
        if (!player.func_225608_bj_()) {
            if (bitesTaken > 0 && stack.func_77973_b() == TFItems.experiment_115.get()) {
                worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)Experiment115Block.BITES_TAKEN, (Comparable)(bitesTaken - 1)));
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                if (player instanceof ServerPlayerEntity) {
                    CriteriaTriggers.field_193137_x.func_193173_a((ServerPlayerEntity)player, pos, stack);
                }
                return ActionResultType.SUCCESS;
            }
            if (!(boolean)state.func_177229_b((Property)Experiment115Block.REGENERATE) && stack.func_77973_b() == Items.field_151137_ax && (player.func_184812_l_() || bitesTaken == 0)) {
                worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)Experiment115Block.REGENERATE, (Comparable)true));
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                if (player instanceof ServerPlayerEntity) {
                    CriteriaTriggers.field_193137_x.func_193173_a((ServerPlayerEntity)player, pos, stack);
                }
                return ActionResultType.SUCCESS;
            }
        }
        return this.eatCake(worldIn, pos, state, player);
    }
    
    private ActionResultType eatCake(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        if (!player.func_71043_e(false)) {
            return ActionResultType.PASS;
        }
        player.func_195066_a(Stats.field_188076_J);
        player.func_71024_bL().func_75122_a(4, 0.3f);
        final int i = (int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN);
        if (i < 7) {
            world.func_180501_a(pos, (BlockState)state.func_206870_a((Property)Experiment115Block.BITES_TAKEN, (Comparable)(i + 1)), 3);
        }
        else {
            world.func_217377_a(pos, false);
        }
        if (player instanceof ServerPlayerEntity) {
            CriteriaTriggers.field_193138_y.func_193148_a((ServerPlayerEntity)player, new ItemStack((IItemProvider)TFItems.experiment_115.get(), 8 - i));
        }
        return ActionResultType.SUCCESS;
    }
    
    @Deprecated
    public void func_225542_b_(final BlockState state, final ServerWorld worldIn, final BlockPos pos, final Random random) {
        if ((boolean)state.func_177229_b((Property)Experiment115Block.REGENERATE) && (int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN) != 0) {
            worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)Experiment115Block.BITES_TAKEN, (Comparable)((int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN) - 1)));
        }
    }
    
    @Deprecated
    public boolean func_196260_a(final BlockState state, final IWorldReader worldIn, final BlockPos pos) {
        return worldIn.func_180495_p(pos.func_177977_b()).func_185904_a().func_76220_a();
    }
    
    @Deprecated
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        return (facing == Direction.DOWN && !stateIn.func_196955_c((IWorldReader)worldIn, currentPos)) ? Blocks.field_150350_a.func_176223_P() : super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)Experiment115Block.BITES_TAKEN, (Property)Experiment115Block.REGENERATE });
    }
    
    @Deprecated
    public int func_180641_l(final BlockState state, final World world, final BlockPos pos) {
        return 15 - (int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN) * 2;
    }
    
    @Deprecated
    public boolean func_149740_M(final BlockState state) {
        return true;
    }
    
    @Deprecated
    public boolean func_149744_f(final BlockState state) {
        return (boolean)state.func_177229_b((Property)Experiment115Block.REGENERATE);
    }
    
    @Deprecated
    public int func_180656_a(final BlockState state, final IBlockReader blockAccess, final BlockPos pos, final Direction side) {
        return state.func_177229_b((Property)Experiment115Block.REGENERATE) ? (15 - (int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN) * 2) : 0;
    }
    
    static {
        BITES_TAKEN = IntegerProperty.func_177719_a("omnomnom", 0, 7);
        REGENERATE = BooleanProperty.func_177716_a("regenerate");
        QUARTER_SHAPE = func_208617_a(1.0, 0.0, 1.0, 8.0, 8.0, 8.0);
        HALF_SHAPE = func_208617_a(1.0, 0.0, 1.0, 8.0, 8.0, 15.0);
        THREE_QUARTER_SHAPE = VoxelShapes.func_197878_a(Experiment115Block.HALF_SHAPE, func_208617_a(8.0, 0.0, 8.0, 15.0, 8.0, 15.0), IBooleanFunction.field_223244_o_);
        FULL_SHAPE = func_208617_a(1.0, 0.0, 1.0, 15.0, 8.0, 15.0);
    }
}
