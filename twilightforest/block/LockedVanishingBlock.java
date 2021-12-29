// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.item.TFItems;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;

public class LockedVanishingBlock extends VanishingBlock
{
    public static final BooleanProperty LOCKED;
    
    public LockedVanishingBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)LockedVanishingBlock.LOCKED, (Comparable)true));
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a(builder);
        builder.func_206894_a(new Property[] { (Property)LockedVanishingBlock.LOCKED });
    }
    
    @Override
    public float getExplosionResistance(final BlockState state, final IBlockReader world, final BlockPos pos, final Explosion explosion) {
        return state.func_177229_b((Property)LockedVanishingBlock.LOCKED) ? 6000000.0f : super.getExplosionResistance(state, world, pos, explosion);
    }
    
    @Override
    public boolean canEntityDestroy(final BlockState state, final IBlockReader world, final BlockPos pos, final Entity entity) {
        return !(boolean)state.func_177229_b((Property)LockedVanishingBlock.LOCKED) && super.canEntityDestroy(state, world, pos, entity);
    }
    
    @Override
    public ActionResultType func_225533_a_(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockRayTraceResult hit) {
        final ItemStack stack = player.func_184586_b(hand);
        if (!stack.func_190926_b() && stack.func_77973_b() == TFItems.tower_key.get() && (boolean)state.func_177229_b((Property)LockedVanishingBlock.LOCKED)) {
            if (!world.field_72995_K) {
                stack.func_190918_g(1);
                world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)LockedVanishingBlock.LOCKED, (Comparable)false));
                world.func_184133_a((PlayerEntity)null, pos, TFSounds.UNLOCK_VANISHING_BLOCK, SoundCategory.BLOCKS, 0.3f, 0.6f);
            }
            return ActionResultType.SUCCESS;
        }
        return super.func_225533_a_(state, world, pos, player, hand, hit);
    }
    
    static {
        LOCKED = BooleanProperty.func_177716_a("locked");
    }
}
