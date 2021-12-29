// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.entity.MobEntity;
import net.minecraft.potion.Effects;
import javax.annotation.Nullable;
import java.util.Optional;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class LifedrainScepterItem extends Item
{
    protected LifedrainScepterItem(final Item.Properties props) {
        super(props);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() == stack.func_77958_k()) {
            return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)player.func_184586_b(hand));
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)player.func_184586_b(hand));
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 1.0f;
    }
    
    private static void animateTargetShatter(final World world, final LivingEntity target) {
        final ItemStack itemId = new ItemStack((IItemProvider)getTargetDropItem());
        for (int i = 0; i < 50; ++i) {
            final double gaussX = LifedrainScepterItem.field_77697_d.nextGaussian() * 0.02;
            final double gaussY = LifedrainScepterItem.field_77697_d.nextGaussian() * 0.02;
            final double gaussZ = LifedrainScepterItem.field_77697_d.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            world.func_195594_a((IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, itemId), target.func_226277_ct_() + LifedrainScepterItem.field_77697_d.nextFloat() * target.func_213311_cf() * 2.0f - target.func_213311_cf() - gaussX * gaussFactor, target.func_226278_cu_() + LifedrainScepterItem.field_77697_d.nextFloat() * target.func_213302_cg() - gaussY * gaussFactor, target.func_226281_cx_() + LifedrainScepterItem.field_77697_d.nextFloat() * target.func_213311_cf() * 2.0f - target.func_213311_cf() - gaussZ * gaussFactor, gaussX, gaussY, gaussZ);
        }
    }
    
    private static Item getTargetDropItem() {
        return Items.field_151078_bh;
    }
    
    @Nullable
    private Entity getPlayerLookTarget(final World world, final LivingEntity living) {
        Entity pointedEntity = null;
        final double range = 20.0;
        final Vector3d srcVec = new Vector3d(living.func_226277_ct_(), living.func_226278_cu_() + living.func_70047_e(), living.func_226281_cx_());
        final Vector3d lookVec = living.func_70676_i(1.0f);
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 1.0f;
        final List<Entity> possibleList = world.func_72839_b((Entity)living, living.func_174813_aQ().func_72321_a(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L()) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vector3d> interceptPos = collisionBB.func_216365_b(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
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
                    final double possibleDist = srcVec.func_72438_d((Vector3d)interceptPos.get());
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
        final World world = living.field_70170_p;
        if (stack.func_77952_i() == this.getMaxDamage(stack)) {
            living.func_184602_cy();
            return;
        }
        if (count % 5 == 0) {
            final Entity pointedEntity = this.getPlayerLookTarget(world, living);
            if (pointedEntity instanceof LivingEntity) {
                final LivingEntity target = (LivingEntity)pointedEntity;
                if (target.func_70660_b(Effects.field_76421_d) != null || target.func_110143_aJ() < 1.0f) {
                    if (target.func_110143_aJ() <= 3.0f) {
                        this.makeRedMagicTrail(world, living.func_226277_ct_(), living.func_226278_cu_() + living.func_70047_e(), living.func_226281_cx_(), target.func_226277_ct_(), target.func_226278_cu_() + target.func_70047_e(), target.func_226281_cx_());
                        if (target instanceof MobEntity) {
                            ((MobEntity)target).func_70656_aK();
                        }
                        target.func_184185_a(TFSounds.SCEPTER_DRAIN, 1.0f, ((LifedrainScepterItem.field_77697_d.nextFloat() - LifedrainScepterItem.field_77697_d.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(world, target);
                        if (!world.field_72995_K) {
                            target.func_199701_a_(new ItemStack((IItemProvider)getTargetDropItem(), LifedrainScepterItem.field_77697_d.nextInt(3)));
                            target.func_70645_a(DamageSource.func_76354_b((Entity)living, (Entity)living));
                            target.func_70106_y();
                        }
                        living.func_184602_cy();
                    }
                    else if (!world.field_72995_K) {
                        target.func_70097_a(DamageSource.func_76354_b((Entity)living, (Entity)living), 3.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth(living)) {
                            target.func_213293_j(0.0, 0.2, 0.0);
                        }
                        target.func_195064_c(new EffectInstance(Effects.field_76421_d, 20, 2));
                        if (count % 10 == 0) {
                            living.func_70691_i(1.0f);
                            if (living instanceof PlayerEntity) {
                                ((PlayerEntity)living).func_71024_bL().func_75122_a(1, 0.1f);
                            }
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(world, living.func_226277_ct_(), living.func_226278_cu_() + living.func_70047_e(), living.func_226281_cx_(), target.func_226277_ct_(), target.func_226278_cu_() + target.func_70047_e(), target.func_226281_cx_());
                    living.func_184185_a(TFSounds.SCEPTER_USE, 1.0f, (world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()) * 0.2f + 1.0f);
                    if (!world.field_72995_K) {
                        target.func_70097_a(DamageSource.func_76354_b((Entity)living, (Entity)living), 1.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth(living)) {
                            target.func_213293_j(0.0, 0.2, 0.0);
                        }
                        target.func_195064_c(new EffectInstance(Effects.field_76421_d, 20, 2));
                    }
                }
                if (!world.field_72995_K && living instanceof PlayerEntity && !((PlayerEntity)living).func_184812_l_()) {
                    stack.func_96631_a(1, LifedrainScepterItem.field_77697_d, (ServerPlayerEntity)null);
                }
            }
        }
    }
    
    private float getMaxHealth(final LivingEntity target) {
        return (float)target.func_110148_a(Attributes.field_233818_a_).func_111125_b();
    }
    
    private void makeRedMagicTrail(final World world, final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + world.field_73012_v.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + world.field_73012_v.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + world.field_73012_v.nextGaussian() * 0.005;
            world.func_195594_a((IParticleData)ParticleTypes.field_197625_r, tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BOW;
    }
    
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack) {
        return oldStack.func_77973_b() == newStack.func_77973_b();
    }
    
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged) {
        return slotChanged || newStack.func_77973_b() != oldStack.func_77973_b();
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.scepter_charges", new Object[] { stack.func_77958_k() - stack.func_77952_i() }));
    }
}
