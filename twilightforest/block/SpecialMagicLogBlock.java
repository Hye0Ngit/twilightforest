// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.RotatedPillarBlock;

public abstract class SpecialMagicLogBlock extends RotatedPillarBlock
{
    public static final BooleanProperty ACTIVE;
    
    protected SpecialMagicLogBlock(final BlockBehaviour.Properties props) {
        super(props.m_60978_(2.0f).m_60918_(SoundType.f_56736_).m_60953_(state -> 15));
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)SpecialMagicLogBlock.ACTIVE, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> container) {
        super.m_7926_((StateDefinition.Builder)container);
        container.m_61104_(new Property[] { (Property)SpecialMagicLogBlock.ACTIVE });
    }
    
    public int tickRate() {
        return 20;
    }
    
    @Deprecated
    public void m_6807_(final BlockState state, final Level world, final BlockPos pos, final BlockState oldState, final boolean isMoving) {
        world.m_6219_().m_5945_(pos, (Object)this, this.tickRate());
    }
    
    @Deprecated
    public void m_7458_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random rand) {
        if (world.f_46443_ || !(boolean)state.m_61143_((Property)SpecialMagicLogBlock.ACTIVE)) {
            return;
        }
        this.playSound((Level)world, pos, rand);
        this.performTreeEffect((Level)world, pos, rand);
        world.m_6219_().m_5945_(pos, (Object)this, this.tickRate());
    }
    
    @Deprecated
    public InteractionResult m_6227_(final BlockState state, final Level world, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        if (!(boolean)state.m_61143_((Property)SpecialMagicLogBlock.ACTIVE)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)SpecialMagicLogBlock.ACTIVE, (Comparable)true));
            world.m_6219_().m_5945_(pos, (Object)this, this.tickRate());
            return InteractionResult.SUCCESS;
        }
        if (state.m_61143_((Property)SpecialMagicLogBlock.ACTIVE)) {
            world.m_46597_(pos, (BlockState)state.m_61124_((Property)SpecialMagicLogBlock.ACTIVE, (Comparable)false));
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    abstract void performTreeEffect(final Level p0, final BlockPos p1, final Random p2);
    
    protected void playSound(final Level level, final BlockPos pos, final Random rand) {
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
    }
}
