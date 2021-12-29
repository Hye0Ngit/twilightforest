// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.effect.MobEffects;
import twilightforest.entity.boss.AlphaYeti;
import net.minecraft.world.entity.decoration.ArmorStand;
import javax.annotation.Nullable;
import java.util.Optional;
import net.minecraft.world.phys.AABB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Items;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class LifedrainScepterItem extends Item
{
    protected LifedrainScepterItem(final Item.Properties props) {
        super(props);
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_41773_() == stack.m_41776_()) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)player.m_21120_(hand));
        }
        player.m_6672_(hand);
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)player.m_21120_(hand));
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
    
    private static void animateTargetShatter(final Level world, final LivingEntity target) {
        final ItemStack itemId = new ItemStack((ItemLike)getTargetDropItem());
        for (int i = 0; i < 50; ++i) {
            final double gaussX = world.f_46441_.nextGaussian() * 0.02;
            final double gaussY = world.f_46441_.nextGaussian() * 0.02;
            final double gaussZ = world.f_46441_.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            world.m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, itemId), target.m_20185_() + world.f_46441_.nextFloat() * target.m_20205_() * 2.0f - target.m_20205_() - gaussX * gaussFactor, target.m_20186_() + world.f_46441_.nextFloat() * target.m_20206_() - gaussY * gaussFactor, target.m_20189_() + world.f_46441_.nextFloat() * target.m_20205_() * 2.0f - target.m_20205_() - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    private static Item getTargetDropItem() {
        return Items.f_42583_;
    }
    
    @Nullable
    private Entity getPlayerLookTarget(final Level world, final LivingEntity living) {
        Entity pointedEntity = null;
        final double range = 20.0;
        final Vec3 srcVec = new Vec3(living.m_20185_(), living.m_20186_() + living.m_20192_(), living.m_20189_());
        final Vec3 lookVec = living.m_20252_(1.0f);
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range);
        final float var9 = 1.0f;
        final List<Entity> possibleList = world.m_45933_((Entity)living, living.m_142469_().m_82363_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range).m_82377_((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.m_6087_()) {
                final float borderSize = possibleEntity.m_6143_();
                final AABB collisionBB = possibleEntity.m_142469_().m_82377_((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vec3> interceptPos = collisionBB.m_82371_(srcVec, destVec);
                if (collisionBB.m_82390_(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (!interceptPos.isPresent()) {
                        continue;
                    }
                    final double possibleDist = srcVec.m_82554_((Vec3)interceptPos.get());
                    if (possibleDist >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = possibleDist;
                }
            }
        }
        return pointedEntity;
    }
    
    public void onUsingTick(final ItemStack stack, final LivingEntity living, final int count) {
        final Level world = living.f_19853_;
        if (stack.m_41773_() == this.getMaxDamage(stack)) {
            living.m_5810_();
            return;
        }
        if (count % 5 == 0) {
            final Entity playerLookTarget;
            final Entity pointedEntity = playerLookTarget = this.getPlayerLookTarget(world, living);
            if (playerLookTarget instanceof final LivingEntity target) {
                if (!(target instanceof ArmorStand)) {
                    final LivingEntity livingEntity = target;
                    if (livingEntity instanceof final AlphaYeti alpha) {
                        if (!alpha.isRampaging() && !alpha.isTired()) {
                            return;
                        }
                    }
                    if (target.m_21124_(MobEffects.f_19597_) != null || target.m_21223_() < 1.0f) {
                        if (target.m_21223_() <= 3.0f) {
                            this.makeRedMagicTrail(world, living.m_20185_(), living.m_20186_() + living.m_20192_(), living.m_20189_(), target.m_20185_(), target.m_20186_() + target.m_20192_(), target.m_20189_());
                            if (target instanceof final Mob mob) {
                                mob.m_21373_();
                            }
                            target.m_5496_(TFSounds.SCEPTER_DRAIN, 1.0f, ((world.f_46441_.nextFloat() - world.f_46441_.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                            animateTargetShatter(world, target);
                            if (!world.f_46443_) {
                                target.m_19983_(new ItemStack((ItemLike)getTargetDropItem(), world.f_46441_.nextInt(3)));
                                target.m_6667_(DamageSource.m_19367_((Entity)living, (Entity)living));
                                target.m_146870_();
                            }
                            living.m_5810_();
                        }
                        else if (!world.f_46443_) {
                            target.m_6469_(DamageSource.m_19367_((Entity)living, (Entity)living), 3.0f);
                            if (this.getMaxHealth(target) <= this.getMaxHealth(living)) {
                                target.m_20334_(0.0, 0.2, 0.0);
                            }
                            target.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 2));
                            if (count % 10 == 0) {
                                living.m_5634_(1.0f);
                                if (living instanceof final Player player) {
                                    player.m_36324_().m_38707_(1, 0.1f);
                                }
                            }
                        }
                    }
                    else {
                        this.makeRedMagicTrail(world, living.m_20185_(), living.m_20186_() + living.m_20192_(), living.m_20189_(), target.m_20185_(), target.m_20186_() + target.m_20192_(), target.m_20189_());
                        living.m_5496_(TFSounds.SCEPTER_USE, 1.0f, (world.f_46441_.nextFloat() - world.f_46441_.nextFloat()) * 0.2f + 1.0f);
                        if (!world.f_46443_) {
                            target.m_6469_(DamageSource.m_19367_((Entity)living, (Entity)living), 1.0f);
                            if (this.getMaxHealth(target) <= this.getMaxHealth(living)) {
                                target.m_20334_(0.0, 0.2, 0.0);
                            }
                            target.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 2));
                        }
                    }
                    if (!world.f_46443_ && living instanceof Player && !((Player)living).m_7500_()) {
                        stack.m_41629_(1, world.f_46441_, (ServerPlayer)null);
                    }
                }
            }
        }
    }
    
    private float getMaxHealth(final LivingEntity target) {
        return (float)target.m_21051_(Attributes.f_22276_).m_22115_();
    }
    
    private void makeRedMagicTrail(final Level world, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + world.f_46441_.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + world.f_46441_.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + world.f_46441_.nextGaussian() * 0.005;
            world.m_7106_((ParticleOptions)ParticleTypes.f_123811_, tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
    
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BOW;
    }
    
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack) {
        return oldStack.m_41720_() == newStack.m_41720_();
    }
    
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged) {
        return slotChanged || newStack.m_41720_() != oldStack.m_41720_();
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)new TranslatableComponent("twilightforest.scepter_charges", new Object[] { stack.m_41776_() - stack.m_41773_() }).m_130940_(ChatFormatting.GRAY));
    }
}
