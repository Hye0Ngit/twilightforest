// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import twilightforest.tileentity.CinderFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class CinderFurnaceBlock extends Block
{
    public static final BooleanProperty LIT;
    private static final DirectionProperty FACING;
    
    CinderFurnaceBlock() {
        super(AbstractBlock.Properties.func_200945_a(Material.field_151575_d).harvestTool(ToolType.PICKAXE).func_235861_h_().func_200943_b(7.0f).func_235838_a_(state -> 15));
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)CinderFurnaceBlock.FACING, (Comparable)Direction.NORTH)).func_206870_a((Property)CinderFurnaceBlock.LIT, (Comparable)false));
    }
    
    public int getLightValue(final BlockState state, final IBlockReader world, final BlockPos pos) {
        return state.func_177229_b((Property)CinderFurnaceBlock.LIT) ? 15 : 0;
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)CinderFurnaceBlock.LIT, (Property)CinderFurnaceBlock.FACING });
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return (TileEntity)new CinderFurnaceTileEntity();
    }
    
    @Deprecated
    public boolean func_189539_a(final BlockState state, final World worldIn, final BlockPos pos, final int id, final int param) {
        super.func_189539_a(state, worldIn, pos, id, param);
        final TileEntity tileentity = worldIn.func_175625_s(pos);
        return tileentity != null && tileentity.func_145842_c(id, param);
    }
    
    @Deprecated
    public ActionResultType func_225533_a_(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        if (!world.field_72995_K && world.func_175625_s(pos) instanceof CinderFurnaceTileEntity) {
            player.func_213829_a((INamedContainerProvider)world.func_175625_s(pos));
        }
        return ActionResultType.PASS;
    }
    
    public void func_180633_a(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        if (stack.func_82837_s()) {
            ((FurnaceTileEntity)world.func_175625_s(pos)).func_213903_a(stack.func_200301_q());
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((Property)CinderFurnaceBlock.LIT)) {
            Blocks.field_150460_al.func_180655_c(state, world, pos, random);
        }
    }
    
    @Deprecated
    public void func_196243_a(final BlockState state, final World worldIn, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (state.func_177230_c() != newState.func_177230_c()) {
            final TileEntity tileentity = worldIn.func_175625_s(pos);
            if (tileentity instanceof CinderFurnaceTileEntity) {
                InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
                worldIn.func_175666_e(pos, (Block)this);
            }
            super.func_196243_a(state, worldIn, pos, newState, isMoving);
        }
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
    
    static {
        LIT = BooleanProperty.func_177716_a("lit");
        FACING = TFHorizontalBlock.field_185512_D;
    }
}
