// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.item.TFItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class LockedVanishingBlock extends VanishingBlock
{
    public static final BooleanProperty LOCKED;
    
    public LockedVanishingBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)LockedVanishingBlock.LOCKED, (Comparable)true));
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)LockedVanishingBlock.LOCKED });
    }
    
    @Override
    public float getExplosionResistance(final BlockState state, final BlockGetter world, final BlockPos pos, final Explosion explosion) {
        return state.m_61143_((Property)LockedVanishingBlock.LOCKED) ? 6000000.0f : super.getExplosionResistance(state, world, pos, explosion);
    }
    
    @Override
    public boolean canEntityDestroy(final BlockState state, final BlockGetter world, final BlockPos pos, final Entity entity) {
        return !(boolean)state.m_61143_((Property)LockedVanishingBlock.LOCKED) && super.canEntityDestroy(state, world, pos, entity);
    }
    
    @Override
    public InteractionResult m_6227_(final BlockState state, final Level world, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        final ItemStack stack = player.m_21120_(hand);
        if (!stack.m_41619_() && stack.m_41720_() == TFItems.TOWER_KEY.get() && (boolean)state.m_61143_((Property)LockedVanishingBlock.LOCKED)) {
            if (!world.f_46443_) {
                stack.m_41774_(1);
                world.m_46597_(pos, (BlockState)state.m_61124_((Property)LockedVanishingBlock.LOCKED, (Comparable)false));
                world.m_5594_((Player)null, pos, TFSounds.UNLOCK_VANISHING_BLOCK, SoundSource.BLOCKS, 0.3f, 0.6f);
            }
            return InteractionResult.SUCCESS;
        }
        return super.m_6227_(state, world, pos, player, hand, hit);
    }
    
    static {
        LOCKED = BooleanProperty.m_61465_("locked");
    }
}
