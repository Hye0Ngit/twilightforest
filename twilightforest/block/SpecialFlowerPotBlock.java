// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import javax.annotation.Nullable;
import java.util.function.Supplier;
import net.minecraft.world.level.block.FlowerPotBlock;

public class SpecialFlowerPotBlock extends FlowerPotBlock
{
    public SpecialFlowerPotBlock(@Nullable final Supplier<FlowerPotBlock> emptyPot, final Supplier<? extends Block> p_53528_, final BlockBehaviour.Properties properties) {
        super((Supplier)emptyPot, (Supplier)p_53528_, properties);
    }
    
    public InteractionResult m_6227_(final BlockState pState, final Level pLevel, final BlockPos pPos, final Player pPlayer, final InteractionHand pHand, final BlockHitResult pHit) {
        if (!this.m_153267_()) {
            pLevel.m_7731_(pPos, this.getEmptyPot().m_49966_(), 3);
            pLevel.m_142346_((Entity)pPlayer, GameEvent.f_157792_, pPos);
            return InteractionResult.m_19078_(pLevel.f_46443_);
        }
        return super.m_6227_(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
