// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.Blocks;
import twilightforest.util.EntityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.DirectionalBlock;

public class StrongholdShieldBlock extends DirectionalBlock
{
    public StrongholdShieldBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)StrongholdShieldBlock.f_52588_, (Comparable)Direction.DOWN));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)StrongholdShieldBlock.f_52588_ });
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)this.m_49966_().m_61124_((Property)StrongholdShieldBlock.f_52588_, (Comparable)context.m_7820_().m_122424_());
    }
    
    @Deprecated
    public float m_5880_(final BlockState state, final Player player, final BlockGetter world, final BlockPos pos) {
        final BlockHitResult ray = EntityUtil.rayTrace(player, range -> range + 1.0);
        final Direction hitFace = ray.m_82434_();
        final boolean upOrDown = state.m_61143_((Property)DirectionalBlock.f_52588_) == Direction.UP || state.m_61143_((Property)DirectionalBlock.f_52588_) == Direction.DOWN;
        final Direction sideFace = ((Direction)state.m_61143_((Property)DirectionalBlock.f_52588_)).m_122424_();
        final Direction upFace = (Direction)state.m_61143_((Property)DirectionalBlock.f_52588_);
        if (hitFace == (upOrDown ? upFace : sideFace)) {
            return player.getDigSpeed(Blocks.f_50069_.m_49966_(), pos) / 1.5f / 100.0f;
        }
        return super.m_5880_(state, player, world, pos);
    }
    
    public boolean canEntityDestroy(final BlockState state, final BlockGetter world, final BlockPos pos, final Entity entity) {
        return false;
    }
}
