// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.core.BlockPos;
import twilightforest.util.WorldUtil;
import java.util.Iterator;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import twilightforest.TFSounds;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class PeacockFanItem extends Item
{
    boolean launched;
    
    PeacockFanItem(final Item.Properties props) {
        super(props);
        this.launched = false;
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        if (player.m_36335_().m_41519_((Item)this)) {
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.PASS, (Object)player.m_21120_(hand));
        }
        if (!world.f_46443_) {
            final int fanned = this.doFan(world, player);
            player.m_21120_(hand).m_41622_(fanned + 1, (LivingEntity)player, user -> user.m_21190_(hand));
            player.m_6672_(hand);
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.PASS, (Object)player.m_21120_(hand));
        }
        if (player.m_21255_()) {
            final Vec3 look = player.m_20154_();
            final Vec3 movement = player.m_20184_();
            player.m_20256_(movement.m_82520_(look.f_82479_ * 0.1 + (look.f_82479_ * 2.0 - movement.f_82479_) * 0.5, look.f_82480_ * 0.1 + (look.f_82480_ * 2.0 - movement.f_82480_) * 0.5 + 1.25, look.f_82481_ * 0.1 + (look.f_82481_ * 2.0 - movement.f_82481_) * 0.5));
        }
        if (!player.m_20096_() && !player.m_6069_() && !this.launched) {
            player.m_20256_(new Vec3(player.m_20184_().m_7096_() * 1.0499999523162842, 1.5, player.m_20184_().m_7094_() * 1.0499999523162842));
            this.launched = true;
        }
        else {
            final AABB fanBox = this.getEffectAABB(player);
            final Vec3 lookVec = player.m_20154_();
            for (int i = 0; i < 30; ++i) {
                world.m_7106_((ParticleOptions)ParticleTypes.f_123796_, fanBox.f_82288_ + world.f_46441_.nextFloat() * (fanBox.f_82291_ - fanBox.f_82288_), fanBox.f_82289_ + world.f_46441_.nextFloat() * (fanBox.f_82292_ - fanBox.f_82289_), fanBox.f_82290_ + world.f_46441_.nextFloat() * (fanBox.f_82293_ - fanBox.f_82290_), lookVec.f_82479_, lookVec.f_82480_, lookVec.f_82481_);
            }
        }
        player.m_5496_(TFSounds.FAN_WOOSH, 1.0f + world.f_46441_.nextFloat(), world.f_46441_.nextFloat() * 0.7f + 0.3f);
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)player.m_21120_(hand));
    }
    
    public void m_6883_(final ItemStack stack, final Level worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected) {
        if (entityIn instanceof final Player player) {
            if (player.m_21255_() && (player.m_21120_(InteractionHand.OFF_HAND).m_150930_((Item)this) || isSelected)) {
                player.f_19789_ = 0.0f;
            }
        }
        if (entityIn instanceof final Player player) {
            if (this.launched) {
                player.f_19789_ = 0.0f;
            }
        }
        if (entityIn instanceof final Player player) {
            if (player.m_20096_() && this.launched) {
                this.launched = false;
            }
        }
        super.m_6883_(stack, worldIn, entityIn, itemSlot, isSelected);
    }
    
    @Nonnull
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BLOCK;
    }
    
    public int m_8105_(final ItemStack stack) {
        return 20;
    }
    
    private int doFan(final Level world, final Player player) {
        final AABB fanBox = this.getEffectAABB(player);
        return this.fanBlocksInAABB(world, fanBox, player) + this.fanEntitiesInAABB(world, player, fanBox);
    }
    
    private int fanEntitiesInAABB(final Level world, final Player player, final AABB fanBox) {
        final Vec3 moveVec = player.m_20154_().m_82490_(2.0);
        final Item fan = player.m_21211_().m_41720_();
        int fannedEntities = 0;
        for (final Entity entity : world.m_45976_((Class)Entity.class, fanBox)) {
            if (entity.m_6094_() || entity instanceof ItemEntity || entity instanceof Projectile) {
                entity.m_20334_(moveVec.f_82479_, moveVec.f_82480_, moveVec.f_82481_);
                ++fannedEntities;
            }
            final Entity entity2 = entity;
            if (entity2 instanceof final Player pushedPlayer) {
                if (pushedPlayer == player || entity.m_6144_()) {
                    continue;
                }
                pushedPlayer.m_20334_(moveVec.f_82479_, moveVec.f_82480_, moveVec.f_82481_);
                player.m_36335_().m_41524_(fan, 40);
                fannedEntities += 2;
            }
        }
        return fannedEntities;
    }
    
    private AABB getEffectAABB(final Player player) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vec3 srcVec = new Vec3(player.m_20185_(), player.m_20186_() + player.m_20192_(), player.m_20189_());
        final Vec3 lookVec = player.m_20154_().m_82490_(range);
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_, lookVec.f_82480_, lookVec.f_82481_);
        return new AABB(destVec.f_82479_ - radius, destVec.f_82480_ - radius, destVec.f_82481_ - radius, destVec.f_82479_ + radius, destVec.f_82480_ + radius, destVec.f_82481_ + radius);
    }
    
    private int fanBlocksInAABB(final Level world, final AABB box, final Player player) {
        int fan = 0;
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            fan += this.fanBlock(world, pos, player);
        }
        return fan;
    }
    
    private int fanBlock(final Level world, final BlockPos pos, final Player player) {
        int cost = 0;
        final BlockState state = world.m_8055_(pos);
        if (state.m_60734_() instanceof FlowerBlock && world.f_46441_.nextInt(3) == 0 && !MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(world, pos, state, player))) {
            world.m_46961_(pos, true);
            ++cost;
        }
        return cost;
    }
}
