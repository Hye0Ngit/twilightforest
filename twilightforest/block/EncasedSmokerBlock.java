// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class EncasedSmokerBlock extends TFSmokerBlock
{
    public static final BooleanProperty ACTIVE;
    
    protected EncasedSmokerBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)EncasedSmokerBlock.ACTIVE, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)EncasedSmokerBlock.ACTIVE });
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.f_46443_) {
            return;
        }
        final boolean powered = world.m_46753_(pos);
        if (!(boolean)state.m_61143_((Property)EncasedSmokerBlock.ACTIVE) && powered) {
            world.m_7731_(pos, (BlockState)state.m_61124_((Property)EncasedSmokerBlock.ACTIVE, (Comparable)true), 3);
            world.m_5594_((Player)null, pos, TFSounds.SMOKER_START, SoundSource.BLOCKS, 0.3f, 0.6f);
        }
        if ((boolean)state.m_61143_((Property)EncasedSmokerBlock.ACTIVE) && !powered) {
            world.m_7731_(pos, (BlockState)state.m_61124_((Property)EncasedSmokerBlock.ACTIVE, (Comparable)false), 3);
            world.m_5594_((Player)null, pos, TFSounds.SMOKER_START, SoundSource.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
    }
}
