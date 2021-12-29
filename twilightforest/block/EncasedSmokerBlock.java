// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;

public class EncasedSmokerBlock extends TFSmokerBlock
{
    public static final BooleanProperty ACTIVE;
    
    protected EncasedSmokerBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)EncasedSmokerBlock.ACTIVE, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)EncasedSmokerBlock.ACTIVE });
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.field_72995_K) {
            return;
        }
        final boolean powered = world.func_175640_z(pos);
        if (!(boolean)state.func_177229_b((Property)EncasedSmokerBlock.ACTIVE) && powered) {
            world.func_180501_a(pos, (BlockState)state.func_206870_a((Property)EncasedSmokerBlock.ACTIVE, (Comparable)true), 3);
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.SMOKER_START, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
        if ((boolean)state.func_177229_b((Property)EncasedSmokerBlock.ACTIVE) && !powered) {
            world.func_180501_a(pos, (BlockState)state.func_206870_a((Property)EncasedSmokerBlock.ACTIVE, (Comparable)false), 3);
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.SMOKER_START, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    @Override
    public boolean hasTileEntity(final BlockState state) {
        return (boolean)state.func_177229_b((Property)EncasedSmokerBlock.ACTIVE);
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
    }
}
