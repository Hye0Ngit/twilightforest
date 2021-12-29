// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.block.material.PushReaction;
import net.minecraft.tags.ITag;
import net.minecraft.tags.FluidTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.GameRules;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.item.TFItems;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Explosion;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;
import twilightforest.tileentity.KeepsakeCasketTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockRenderType;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.IBlockReader;
import net.minecraft.item.ItemStack;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.DirectionProperty;
import twilightforest.enums.BlockLoggingEnum;
import net.minecraft.block.ContainerBlock;

public class KeepsakeCasketBlock extends ContainerBlock implements BlockLoggingEnum.IMultiLoggable
{
    public static final DirectionProperty FACING;
    public static final IntegerProperty BREAKAGE;
    private static final VoxelShape BOTTOM_X;
    private static final VoxelShape TOP_X;
    private static final VoxelShape BOTTOM_Z;
    private static final VoxelShape TOP_Z;
    private static final VoxelShape CASKET_X;
    private static final VoxelShape CASKET_Z;
    private static final VoxelShape SOLID;
    private static final VoxelShape TOPPER_X;
    private static final VoxelShape TOPPER_Z;
    private static final VoxelShape SOLID_X;
    private static final VoxelShape SOLID_Z;
    
    protected KeepsakeCasketBlock() {
        super(AbstractBlock.Properties.func_200949_a(Material.field_151573_f, MaterialColor.field_151646_E).func_226896_b_().func_235861_h_().func_200948_a(50.0f, 1200.0f).func_200947_a(SoundType.field_235594_P_));
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.func_176194_O().func_177621_b()).func_206870_a((Property)KeepsakeCasketBlock.FACING, (Comparable)Direction.NORTH)).func_206870_a((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)0));
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.wip0"));
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.wip1"));
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
    
    public BlockRenderType func_149645_b(final BlockState state) {
        return (((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getBlock() != Blocks.field_150350_a && ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() == Fluids.field_204541_a) ? BlockRenderType.MODEL : BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        final Direction direction = (Direction)state.func_177229_b((Property)BlockStateProperties.field_208157_J);
        if (((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getBlock() != Blocks.field_150350_a && ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() == Fluids.field_204541_a) {
            return (direction.func_176740_k() == Direction.Axis.X) ? KeepsakeCasketBlock.SOLID_X : KeepsakeCasketBlock.SOLID_Z;
        }
        return (direction.func_176740_k() == Direction.Axis.X) ? KeepsakeCasketBlock.CASKET_X : KeepsakeCasketBlock.CASKET_Z;
    }
    
    @Nullable
    public TileEntity func_196283_a_(final IBlockReader worldIn) {
        return (TileEntity)new KeepsakeCasketTileEntity();
    }
    
    public void func_196243_a(final BlockState state, final World worldIn, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (!state.func_203425_a(newState.func_177230_c())) {
            final TileEntity tileentity = worldIn.func_175625_s(pos);
            if (tileentity instanceof IInventory) {
                InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
                worldIn.func_175666_e(pos, (Block)this);
            }
            super.func_196243_a(state, worldIn, pos, newState, isMoving);
        }
    }
    
    public float getExplosionResistance(final BlockState state, final IBlockReader world, final BlockPos pos, final Explosion explosion) {
        return 1.0E9f;
    }
    
    public ActionResultType func_225533_a_(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        boolean flag = false;
        if (((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getBlock() == Blocks.field_150350_a || ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() != Fluids.field_204541_a) {
            final ItemStack stack = player.func_184586_b(handIn);
            if (stack.func_77973_b() != TFItems.charm_of_keeping_3.get()) {
                if (worldIn.field_72995_K) {
                    return ActionResultType.SUCCESS;
                }
                final INamedContainerProvider inamedcontainerprovider = this.func_220052_b(state, worldIn, pos);
                if (inamedcontainerprovider != null) {
                    player.func_213829_a(inamedcontainerprovider);
                }
                flag = true;
            }
            else if (stack.func_77973_b() == TFItems.charm_of_keeping_3.get() && (int)state.func_177229_b((Property)KeepsakeCasketBlock.BREAKAGE) > 0) {
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)((int)state.func_177229_b((Property)KeepsakeCasketBlock.BREAKAGE) - 1)));
                worldIn.func_184133_a((PlayerEntity)null, pos, TFSounds.CASKET_REPAIR, SoundCategory.BLOCKS, 0.5f, worldIn.field_73012_v.nextFloat() * 0.1f + 0.9f);
                flag = true;
            }
        }
        return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
    }
    
    public void func_176208_a(final World worldIn, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        if (!worldIn.field_72995_K && !player.func_184812_l_() && worldIn.func_82736_K().func_223586_b(GameRules.field_223603_f)) {
            final TileEntity tile = worldIn.func_175625_s(pos);
            if (tile instanceof KeepsakeCasketTileEntity) {
                final KeepsakeCasketTileEntity casket = (KeepsakeCasketTileEntity)tile;
                final ItemStack stack = new ItemStack((IItemProvider)this);
                final String nameCheck = new StringTextComponent(casket.name + "'s " + casket.func_145748_c_()).getString();
                final ItemEntity itementity = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), stack);
                final CompoundNBT nbt = new CompoundNBT();
                nbt.func_74768_a("damage", (int)state.func_177229_b((Property)KeepsakeCasketBlock.BREAKAGE));
                stack.func_77983_a("BlockStateTag", (INBT)nbt);
                if (casket.func_145818_k_()) {
                    if (nameCheck.equals(casket.func_200201_e().getString())) {
                        itementity.func_200203_b(casket.func_145748_c_());
                    }
                    else {
                        itementity.func_200203_b(casket.func_200201_e());
                    }
                }
                if (((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() == Fluids.field_204541_a) {
                    final Block block = ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getBlock();
                    if (block != Blocks.field_150350_a) {
                        final ItemStack blockstack = new ItemStack((IItemProvider)block);
                        final ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), blockstack);
                        item.func_174869_p();
                        worldIn.func_217376_c((Entity)item);
                    }
                }
                itementity.func_174869_p();
                worldIn.func_217376_c((Entity)itementity);
            }
        }
        super.func_176208_a(worldIn, pos, state, player);
    }
    
    public void func_180633_a(final World worldIn, final BlockPos pos, final BlockState state, final LivingEntity placer, final ItemStack stack) {
        final CompoundNBT nbt = stack.func_196082_o();
        if (nbt.func_74764_b("BlockStateTag")) {
            final CompoundNBT damageNbt = nbt.func_74775_l("BlockStateTag");
            if (damageNbt.func_74764_b("damage")) {
                worldIn.func_180501_a(pos, (BlockState)state.func_206870_a((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)damageNbt.func_74762_e("damage")), 2);
            }
        }
        if (stack.func_82837_s()) {
            final TileEntity tileentity = worldIn.func_175625_s(pos);
            if (tileentity instanceof KeepsakeCasketTileEntity) {
                ((KeepsakeCasketTileEntity)tileentity).func_213903_a(stack.func_200301_q());
            }
        }
    }
    
    public void func_220069_a(final BlockState state, final World worldIn, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        this.reactWithNeighbors(worldIn, pos, state);
        super.func_220069_a(state, worldIn, pos, blockIn, fromPos, isMoving);
    }
    
    private void reactWithNeighbors(final World worldIn, final BlockPos pos, final BlockState state) {
        if (state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED) == BlockLoggingEnum.LAVA) {
            final boolean flag = worldIn.func_180495_p(pos.func_177977_b()).func_203425_a(Blocks.field_235336_cN_);
            for (final Direction direction : Direction.values()) {
                if (direction != Direction.DOWN) {
                    final BlockPos blockpos = pos.func_177972_a(direction);
                    if (worldIn.func_204610_c(blockpos).func_206884_a((ITag)FluidTags.field_206959_a)) {
                        worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.OBSIDIAN));
                        worldIn.func_217379_c(1501, pos, 0);
                    }
                    if (flag && worldIn.func_180495_p(blockpos).func_203425_a(Blocks.field_205164_gk)) {
                        worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.BASALT));
                        worldIn.func_217379_c(1501, pos, 0);
                    }
                }
            }
        }
        else if (state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED) == BlockLoggingEnum.WATER) {
            for (final Direction direction2 : Direction.values()) {
                if (direction2 != Direction.DOWN) {
                    final BlockPos blockpos2 = pos.func_177972_a(direction2);
                    if (worldIn.func_204610_c(blockpos2).func_206884_a((ITag)FluidTags.field_206960_b)) {
                        worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.STONE));
                        worldIn.func_217379_c(1501, pos, 0);
                    }
                }
            }
        }
    }
    
    public PushReaction func_149656_h(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    public boolean func_149740_M(final BlockState state) {
        return true;
    }
    
    public int func_180641_l(final BlockState blockState, final World worldIn, final BlockPos pos) {
        return Container.func_178144_a(worldIn.func_175625_s(pos));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        builder.func_206894_a(new Property[] { (Property)BlockLoggingEnum.MULTILOGGED, (Property)KeepsakeCasketBlock.FACING, (Property)KeepsakeCasketBlock.BREAKAGE });
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        return (BlockState)((BlockState)super.func_196258_a(context).func_206870_a((Property)KeepsakeCasketBlock.FACING, (Comparable)context.func_195992_f().func_176734_d())).func_206870_a((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.getFromFluid(context.func_195991_k().func_204610_c(context.func_195995_a()).func_206886_c()));
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return ((BlockLoggingEnum)state.func_177229_b((Property)BlockLoggingEnum.MULTILOGGED)).getFluid().func_207188_f();
    }
    
    @OnlyIn(Dist.CLIENT)
    public static TileEntityMerger.ICallback<KeepsakeCasketTileEntity, Float2FloatFunction> getLidRotationCallback(final IChestLid lid) {
        return (TileEntityMerger.ICallback<KeepsakeCasketTileEntity, Float2FloatFunction>)new TileEntityMerger.ICallback<KeepsakeCasketTileEntity, Float2FloatFunction>() {
            public Float2FloatFunction func_225539_a_(final KeepsakeCasketTileEntity p_225539_1_, final KeepsakeCasketTileEntity p_225539_2_) {
                return angle -> Math.max(p_225539_1_.func_195480_a(angle), p_225539_2_.func_195480_a(angle));
            }
            
            public Float2FloatFunction func_225538_a_(final KeepsakeCasketTileEntity p_225538_1_) {
                return p_225538_1_::func_195480_a;
            }
            
            public Float2FloatFunction func_225537_b_() {
                return lid::func_195480_a;
            }
        };
    }
    
    static {
        FACING = TFHorizontalBlock.field_185512_D;
        BREAKAGE = IntegerProperty.func_177719_a("damage", 0, 2);
        BOTTOM_X = Block.func_208617_a(2.0, 0.0, 1.0, 14.0, 6.0, 15.0);
        TOP_X = Block.func_208617_a(1.0, 6.0, 0.0, 15.0, 14.0, 16.0);
        BOTTOM_Z = Block.func_208617_a(1.0, 0.0, 2.0, 15.0, 6.0, 14.0);
        TOP_Z = Block.func_208617_a(0.0, 6.0, 1.0, 16.0, 14.0, 15.0);
        CASKET_X = VoxelShapes.func_197872_a(KeepsakeCasketBlock.BOTTOM_X, KeepsakeCasketBlock.TOP_X);
        CASKET_Z = VoxelShapes.func_197872_a(KeepsakeCasketBlock.BOTTOM_Z, KeepsakeCasketBlock.TOP_Z);
        SOLID = Block.func_208617_a(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
        TOPPER_X = Block.func_208617_a(1.0, 12.0, 0.0, 15.0, 14.0, 16.0);
        TOPPER_Z = Block.func_208617_a(0.0, 12.0, 1.0, 16.0, 14.0, 15.0);
        SOLID_X = VoxelShapes.func_197872_a(KeepsakeCasketBlock.SOLID, KeepsakeCasketBlock.TOPPER_X);
        SOLID_Z = VoxelShapes.func_197872_a(KeepsakeCasketBlock.SOLID, KeepsakeCasketBlock.TOPPER_Z);
    }
}
