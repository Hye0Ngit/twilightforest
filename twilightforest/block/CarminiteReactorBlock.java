// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import twilightforest.tileentity.ActiveCarminiteReactorTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Blocks;
import java.util.Arrays;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class CarminiteReactorBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    
    public CarminiteReactorBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)CarminiteReactorBlock.ACTIVE, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)CarminiteReactorBlock.ACTIVE });
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.field_72995_K) {
            return;
        }
        if (!(boolean)state.func_177229_b((Property)CarminiteReactorBlock.ACTIVE) && this.isReactorReady(world, pos)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)CarminiteReactorBlock.ACTIVE, (Comparable)true));
        }
    }
    
    private boolean isReactorReady(final World world, final BlockPos pos) {
        return Arrays.stream(Direction.values()).allMatch(e -> world.func_180495_p(pos.func_177972_a(e)).func_177230_c() == Blocks.field_150451_bX);
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return (boolean)state.func_177229_b((Property)CarminiteReactorBlock.ACTIVE);
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return this.hasTileEntity(state) ? new ActiveCarminiteReactorTileEntity() : null;
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
    }
}
