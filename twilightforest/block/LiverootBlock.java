// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ToolActions;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class LiverootBlock extends Block
{
    public LiverootBlock(final BlockBehaviour.Properties properties) {
        super(properties);
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hitResult) {
        if (player.m_21120_(hand).m_41720_().canPerformAction(player.m_21120_(hand), ToolActions.AXE_STRIP)) {
            level.m_46597_(pos, ((Block)TFBlocks.ROOT_BLOCK.get()).m_49966_());
            final ItemEntity liveroot = new ItemEntity(level, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), new ItemStack((ItemLike)TFItems.LIVEROOT.get()));
            level.m_7967_((Entity)liveroot);
            level.m_5594_((Player)null, pos, SoundEvents.f_11688_, SoundSource.BLOCKS, 1.0f, 1.0f);
            player.m_21120_(hand).m_41622_(1, (LivingEntity)player, evt -> evt.m_21190_(hand));
        }
        return super.m_6227_(state, level, pos, player, hand, hitResult);
    }
}
