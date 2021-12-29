// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.block.Blocks;
import twilightforest.util.EntityUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.entity.player.PlayerEntity;
import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DirectionalBlock;

public class StrongholdShieldBlock extends DirectionalBlock
{
    public StrongholdShieldBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)StrongholdShieldBlock.field_176387_N, (Comparable)Direction.DOWN));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)StrongholdShieldBlock.field_176387_N });
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        return (BlockState)this.func_176223_P().func_206870_a((Property)StrongholdShieldBlock.field_176387_N, (Comparable)context.func_196010_d().func_176734_d());
    }
    
    @Deprecated
    public float func_180647_a(final BlockState state, final PlayerEntity player, final IBlockReader world, final BlockPos pos) {
        final BlockRayTraceResult ray = EntityUtil.rayTrace(player, range -> range + 1.0);
        final Direction hitFace = ray.func_216354_b();
        final boolean upOrDown = state.func_177229_b((Property)DirectionalBlock.field_176387_N) == Direction.UP || state.func_177229_b((Property)DirectionalBlock.field_176387_N) == Direction.DOWN;
        final Direction sideFace = ((Direction)state.func_177229_b((Property)DirectionalBlock.field_176387_N)).func_176734_d();
        final Direction upFace = (Direction)state.func_177229_b((Property)DirectionalBlock.field_176387_N);
        if (hitFace == (upOrDown ? upFace : sideFace)) {
            return player.getDigSpeed(Blocks.field_150348_b.func_176223_P(), pos) / 1.5f / 100.0f;
        }
        return super.func_180647_a(state, player, world, pos);
    }
    
    public boolean canEntityDestroy(final BlockState state, final IBlockReader world, final BlockPos pos, final Entity entity) {
        return false;
    }
}
