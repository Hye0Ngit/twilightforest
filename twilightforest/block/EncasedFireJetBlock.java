// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.state.Property;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import twilightforest.enums.FireJetVariant;
import net.minecraft.state.EnumProperty;

public class EncasedFireJetBlock extends FireJetBlock
{
    public static final EnumProperty<FireJetVariant> STATE;
    
    protected EncasedFireJetBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        final FireJetVariant variant = (FireJetVariant)state.func_177229_b((Property)EncasedFireJetBlock.STATE);
        final boolean powered = world.func_175640_z(pos);
        if (variant == FireJetVariant.IDLE && powered) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)EncasedFireJetBlock.STATE, (Comparable)FireJetVariant.POPPING));
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.JET_START, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    static {
        STATE = EnumProperty.func_177709_a("state", (Class)FireJetVariant.class);
    }
}
