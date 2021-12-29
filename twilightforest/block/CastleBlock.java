// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import twilightforest.item.MazebreakerPickItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.block.Block;

public class CastleBlock extends Block
{
    public CastleBlock(final MaterialColor color) {
        super(BlockBehaviour.Properties.m_60944_(Material.f_76278_, color).m_60999_().m_60913_(100.0f, 50.0f).m_60918_(SoundType.f_56742_));
    }
    
    public void m_6240_(final Level world, final Player player, final BlockPos pos, final BlockState state, @Nullable final BlockEntity te, final ItemStack stack) {
        final ItemStack cei = player.m_21205_();
        if (cei.m_41720_() instanceof DiggerItem && !(cei.m_41720_() instanceof MazebreakerPickItem)) {
            cei.m_41622_(16, (LivingEntity)player, user -> user.m_21190_(InteractionHand.MAIN_HAND));
        }
        super.m_6240_(world, player, pos, state, te, stack);
    }
}
