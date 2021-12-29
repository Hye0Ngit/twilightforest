// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import twilightforest.enums.FireJetVariant;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class EncasedFireJetBlock extends FireJetBlock
{
    public static final EnumProperty<FireJetVariant> STATE;
    
    protected EncasedFireJetBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        final FireJetVariant variant = (FireJetVariant)state.m_61143_((Property)EncasedFireJetBlock.STATE);
        final boolean powered = world.m_46753_(pos);
        if (variant == FireJetVariant.IDLE && powered) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)EncasedFireJetBlock.STATE, (Comparable)FireJetVariant.POPPING));
            world.m_5594_((Player)null, pos, TFSounds.JET_START, SoundSource.BLOCKS, 0.3f, 0.6f);
        }
        else if (variant == FireJetVariant.TIMEOUT && !powered) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)EncasedFireJetBlock.STATE, (Comparable)FireJetVariant.IDLE));
        }
    }
    
    static {
        STATE = EnumProperty.m_61587_("state", (Class)FireJetVariant.class);
    }
}
