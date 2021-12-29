// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.World;
import net.minecraft.util.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class TranslucentBuiltBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    
    public TranslucentBuiltBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> container) {
        super.func_206840_a((StateContainer.Builder)container);
        container.func_206894_a(new Property[] { (Property)TranslucentBuiltBlock.ACTIVE });
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((Property)TranslucentBuiltBlock.ACTIVE)) {
            world.func_217377_a(pos, false);
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.BUILDER_REPLACE, SoundCategory.BLOCKS, 0.3f, 0.5f);
            for (final Direction e : Direction.values()) {
                BuilderBlock.activateBuiltBlocks((World)world, pos.func_177972_a(e));
            }
        }
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
    }
}
