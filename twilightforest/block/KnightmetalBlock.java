// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.item.ItemStack;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.pathfinding.PathNodeType;
import javax.annotation.Nullable;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.Block;

public class KnightmetalBlock extends Block
{
    private static final VoxelShape SHAPE;
    private static final float BLOCK_DAMAGE = 4.0f;
    
    public KnightmetalBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return KnightmetalBlock.SHAPE;
    }
    
    @Nullable
    public PathNodeType getAiPathNodeType(final BlockState state, final IBlockReader world, final BlockPos pos, @Nullable final MobEntity entity) {
        return PathNodeType.DAMAGE_CACTUS;
    }
    
    @Deprecated
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entity) {
        entity.func_70097_a(TFDamageSources.KNIGHTMETAL, 4.0f);
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("block.knightmetal.tooltip"));
    }
    
    static {
        SHAPE = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0625, 0.0625, 0.0625, 0.9375, 0.9375, 0.9375));
    }
}
