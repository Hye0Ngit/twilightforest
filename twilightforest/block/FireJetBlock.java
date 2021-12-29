// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.tileentity.FireJetTileEntity;
import net.minecraft.tileentity.TileEntity;
import twilightforest.data.FluidTagGenerator;
import net.minecraft.tags.ITag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.pathfinding.PathNodeType;
import javax.annotation.Nullable;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import twilightforest.enums.FireJetVariant;
import net.minecraft.state.EnumProperty;
import net.minecraft.block.Block;

public class FireJetBlock extends Block
{
    public static final EnumProperty<FireJetVariant> STATE;
    
    protected FireJetBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.IDLE));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)FireJetBlock.STATE });
    }
    
    @Nullable
    public PathNodeType getAiPathNodeType(final BlockState state, final IBlockReader world, final BlockPos pos, @Nullable final MobEntity entity) {
        return (state.func_177229_b((Property)FireJetBlock.STATE) == FireJetVariant.IDLE) ? null : PathNodeType.DAMAGE_FIRE;
    }
    
    @Deprecated
    public void func_225542_b_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        if (!world.field_72995_K && state.func_177229_b((Property)FireJetBlock.STATE) == FireJetVariant.IDLE) {
            final BlockPos lavaPos = this.findLavaAround((World)world, pos.func_177977_b());
            if (this.isLava((World)world, lavaPos)) {
                world.func_175656_a(lavaPos, Blocks.field_150350_a.func_176223_P());
                world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.POPPING));
            }
        }
    }
    
    private BlockPos findLavaAround(final World world, final BlockPos pos) {
        if (this.isLava(world, pos)) {
            return pos;
        }
        for (int i = 0; i < 3; ++i) {
            final BlockPos randPos = pos.func_177982_a(world.field_73012_v.nextInt(3) - 1, 0, world.field_73012_v.nextInt(3) - 1);
            if (this.isLava(world, randPos)) {
                return randPos;
            }
        }
        return pos;
    }
    
    private boolean isLava(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        final Block b = state.func_177230_c();
        return b.func_203417_a((ITag)BlockTagGenerator.FIRE_JET_FUEL) || b.func_204507_t(state).func_206884_a((ITag)FluidTagGenerator.FIRE_JET_FUEL);
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return state.func_177229_b((Property)FireJetBlock.STATE) == FireJetVariant.POPPING || state.func_177229_b((Property)FireJetBlock.STATE) == FireJetVariant.FLAME;
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return this.hasTileEntity(state) ? new FireJetTileEntity() : null;
    }
    
    static {
        STATE = EnumProperty.func_177709_a("state", (Class)FireJetVariant.class);
    }
}
