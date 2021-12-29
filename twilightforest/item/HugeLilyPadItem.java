// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import twilightforest.block.HugeLilyPadBlock;
import net.minecraft.world.item.WaterLilyBlockItem;

public class HugeLilyPadItem extends WaterLilyBlockItem
{
    public HugeLilyPadItem(final HugeLilyPadBlock block, final Item.Properties props) {
        super((Block)block, props);
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack itemstack = player.m_21120_(hand);
        final HitResult raytraceresult = (HitResult)m_41435_(world, player, ClipContext.Fluid.SOURCE_ONLY);
        if (raytraceresult.m_6662_() == HitResult.Type.MISS) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19098_((Object)itemstack);
        }
        if (raytraceresult.m_6662_() == HitResult.Type.BLOCK) {
            final BlockHitResult blockraytraceresult = (BlockHitResult)raytraceresult;
            final BlockPos blockpos = blockraytraceresult.m_82425_();
            final Direction direction = blockraytraceresult.m_82434_();
            if (!world.m_7966_(player, blockpos) || !player.m_36204_(blockpos.m_142300_(direction), direction, itemstack) || !world.m_7966_(player, blockpos.m_142126_()) || !player.m_36204_(blockpos.m_142300_(direction).m_142126_(), direction, itemstack) || !world.m_7966_(player, blockpos.m_142128_()) || !player.m_36204_(blockpos.m_142300_(direction).m_142128_(), direction, itemstack) || !world.m_7966_(player, blockpos.m_142126_().m_142128_()) || !player.m_36204_(blockpos.m_142300_(direction).m_142126_().m_142128_(), direction, itemstack)) {
                return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)itemstack);
            }
            final BlockPos blockpos2 = blockpos.m_7494_();
            final BlockState blockstate = world.m_8055_(blockpos);
            final Material material = blockstate.m_60767_();
            final FluidState ifluidstate = world.m_6425_(blockpos);
            if ((ifluidstate.m_76152_() == Fluids.f_76193_ || material == Material.f_76276_) && world.m_46859_(blockpos2) && (world.m_6425_(blockpos.m_142126_()).m_76152_() == Fluids.f_76193_ || world.m_8055_(blockpos.m_142126_()).m_60767_() == Material.f_76276_) && world.m_46859_(blockpos2.m_142126_()) && (world.m_6425_(blockpos.m_142128_()).m_76152_() == Fluids.f_76193_ || world.m_8055_(blockpos.m_142128_()).m_60767_() == Material.f_76276_) && world.m_46859_(blockpos2.m_142128_()) && (world.m_6425_(blockpos.m_142126_().m_142128_()).m_76152_() == Fluids.f_76193_ || world.m_8055_(blockpos.m_142126_().m_142128_()).m_60767_() == Material.f_76276_) && world.m_46859_(blockpos2.m_142126_().m_142128_())) {
                final BlockState lilypad = (BlockState)this.m_40614_().m_49966_().m_61124_((Property)HugeLilyPadBlock.FACING, (Comparable)player.m_6350_());
                world.m_7731_(blockpos2, (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NW), 11);
                world.m_7731_(blockpos2.m_142126_(), (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NE), 11);
                world.m_7731_(blockpos2.m_142126_().m_142128_(), (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.SE), 11);
                world.m_7731_(blockpos2.m_142128_(), (BlockState)lilypad.m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.SW), 11);
                if (player instanceof final ServerPlayer serverPlayer) {
                    CriteriaTriggers.f_10591_.m_59469_(serverPlayer, blockpos2, itemstack);
                    CriteriaTriggers.f_10591_.m_59469_((ServerPlayer)player, blockpos2.m_142126_(), itemstack);
                    CriteriaTriggers.f_10591_.m_59469_((ServerPlayer)player, blockpos2.m_142126_().m_142128_(), itemstack);
                    CriteriaTriggers.f_10591_.m_59469_((ServerPlayer)player, blockpos2.m_142128_(), itemstack);
                }
                if (!player.m_150110_().f_35937_) {
                    itemstack.m_41774_(1);
                }
                player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
                world.m_5594_(player, blockpos, SoundEvents.f_12581_, SoundSource.BLOCKS, 1.0f, 1.0f);
                return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)itemstack);
            }
        }
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)itemstack);
    }
}
