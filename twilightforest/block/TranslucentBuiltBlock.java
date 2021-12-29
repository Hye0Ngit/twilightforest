// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Block;

public class TranslucentBuiltBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    
    public TranslucentBuiltBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> container) {
        super.m_7926_((StateDefinition.Builder)container);
        container.m_61104_(new Property[] { (Property)TranslucentBuiltBlock.ACTIVE });
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        if (state.m_61143_((Property)TranslucentBuiltBlock.ACTIVE)) {
            world.m_7471_(pos, false);
            world.m_5594_((Player)null, pos, TFSounds.BUILDER_REPLACE, SoundSource.BLOCKS, 0.3f, 0.5f);
            for (final Direction e : Direction.values()) {
                BuilderBlock.activateBuiltBlocks((Level)world, pos.m_142300_(e));
            }
        }
    }
    
    public PushReaction m_5537_(final BlockState pState) {
        return PushReaction.BLOCK;
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
    }
}
