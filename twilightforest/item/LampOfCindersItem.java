// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.item.UseAnim;
import java.util.Iterator;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.TFSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class LampOfCindersItem extends Item
{
    private static final int FIRING_TIME = 12;
    
    LampOfCindersItem(final Item.Properties props) {
        super(props);
    }
    
    public boolean m_8120_(final ItemStack pStack) {
        return false;
    }
    
    public boolean isBookEnchantable(final ItemStack stack, final ItemStack book) {
        return false;
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return false;
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        player.m_6672_(hand);
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)player.m_21120_(hand));
    }
    
    @Nonnull
    public InteractionResult m_6225_(final UseOnContext context) {
        final Level world = context.m_43725_();
        final BlockPos pos = context.m_8083_();
        final Player player = context.m_43723_();
        if (this.burnBlock(world, pos)) {
            if (player instanceof final ServerPlayer serverPlayer) {
                CriteriaTriggers.f_10591_.m_59469_(serverPlayer, pos, player.m_21120_(context.m_43724_()));
            }
            player.m_5496_(TFSounds.LAMP_BURN, 0.5f, 1.5f);
            for (int i = 0; i < 10; ++i) {
                final float dx = pos.m_123341_() + 0.5f + (world.f_46441_.nextFloat() - world.f_46441_.nextFloat()) * 0.75f;
                final float dy = pos.m_123342_() + 0.5f + (world.f_46441_.nextFloat() - world.f_46441_.nextFloat()) * 0.75f;
                final float dz = pos.m_123343_() + 0.5f + (world.f_46441_.nextFloat() - world.f_46441_.nextFloat()) * 0.75f;
                world.m_7106_((ParticleOptions)ParticleTypes.f_123762_, (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0);
                world.m_7106_((ParticleOptions)ParticleTypes.f_123744_, (double)dx, (double)dy, (double)dz, 0.0, 0.0, 0.0);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    private boolean burnBlock(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        if (state.m_60734_() == TFBlocks.BROWN_THORNS.get() || state.m_60734_() == TFBlocks.GREEN_THORNS.get()) {
            world.m_46597_(pos, (BlockState)((Block)TFBlocks.BURNT_THORNS.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)state.m_61143_((Property)RotatedPillarBlock.f_55923_)));
            return true;
        }
        return false;
    }
    
    public void m_5551_(final ItemStack stack, final Level world, final LivingEntity living, final int useRemaining) {
        final int useTime = this.m_8105_(stack) - useRemaining;
        if (useTime > 12 && stack.m_41773_() + 1 < this.getMaxDamage(stack)) {
            this.doBurnEffect(world, living);
        }
    }
    
    private void doBurnEffect(final Level world, final LivingEntity living) {
        final BlockPos pos = new BlockPos(Mth.m_14107_(living.f_19790_), Mth.m_14107_(living.f_19791_ + living.m_20192_()), Mth.m_14107_(living.f_19792_));
        final int range = 4;
        if (!world.f_46443_) {
            world.m_6263_((Player)null, living.m_20185_(), living.m_20186_(), living.m_20189_(), TFSounds.LAMP_BURN, living.m_5720_(), 1.5f, 0.8f);
            for (int dx = -range; dx <= range; ++dx) {
                for (int dy = -range; dy <= range; ++dy) {
                    for (int dz = -range; dz <= range; ++dz) {
                        this.burnBlock(world, pos.m_142082_(dx, dy, dz));
                    }
                }
            }
        }
        if (living instanceof final Player player) {
            for (int i = 0; i < 6; ++i) {
                final BlockPos rPos = pos.m_142082_(world.f_46441_.nextInt(range) - world.f_46441_.nextInt(range), world.f_46441_.nextInt(2), world.f_46441_.nextInt(range) - world.f_46441_.nextInt(range));
                world.m_5898_(player, 2004, rPos, 0);
            }
            for (final LivingEntity targets : world.m_45976_((Class)LivingEntity.class, new AABB(new BlockPos(living.m_20185_(), living.m_20188_(), living.m_20189_())).m_82400_(4.0))) {
                if (!(targets instanceof Player)) {
                    targets.m_20254_(5);
                }
            }
        }
    }
    
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BOW;
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
}
