// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.MobEffects;
import javax.annotation.Nullable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;

public class ItemTFScepterLifeDrain extends ItemTF
{
    protected ItemTFScepterLifeDrain(final EnumRarity rarity) {
        super(rarity);
        this.field_77777_bU = 1;
        this.func_77656_e(99);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, final EnumHand hand) {
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 1.0f;
    }
    
    private static void animateTargetShatter(final World world, final EntityLivingBase target) {
        final int itemId = Item.func_150891_b(getTargetDropItem(target));
        for (int i = 0; i < 50; ++i) {
            final double gaussX = ItemTFScepterLifeDrain.field_77697_d.nextGaussian() * 0.02;
            final double gaussY = ItemTFScepterLifeDrain.field_77697_d.nextGaussian() * 0.02;
            final double gaussZ = ItemTFScepterLifeDrain.field_77697_d.nextGaussian() * 0.02;
            final double gaussFactor = 10.0;
            world.func_175688_a(EnumParticleTypes.ITEM_CRACK, target.field_70165_t + ItemTFScepterLifeDrain.field_77697_d.nextFloat() * target.field_70130_N * 2.0f - target.field_70130_N - gaussX * gaussFactor, target.field_70163_u + ItemTFScepterLifeDrain.field_77697_d.nextFloat() * target.field_70131_O - gaussY * gaussFactor, target.field_70161_v + ItemTFScepterLifeDrain.field_77697_d.nextFloat() * target.field_70130_N * 2.0f - target.field_70130_N - gaussZ * gaussFactor, gaussX, gaussY, gaussZ, new int[] { itemId });
        }
    }
    
    private static Item getTargetDropItem(final EntityLivingBase target) {
        return Items.field_151078_bh;
    }
    
    @Nullable
    private Entity getPlayerLookTarget(final World world, final EntityLivingBase living) {
        Entity pointedEntity = null;
        final double range = 20.0;
        final Vec3d srcVec = new Vec3d(living.field_70165_t, living.field_70163_u + living.func_70047_e(), living.field_70161_v);
        final Vec3d lookVec = living.func_70676_i(1.0f);
        final Vec3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final float var9 = 1.0f;
        final List<Entity> possibleList = world.func_72839_b((Entity)living, living.func_174813_aQ().func_72321_a(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range).func_72314_b((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L()) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final RayTraceResult interceptPos = collisionBB.func_72327_a(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    pointedEntity = possibleEntity;
                    hitDist = 0.0;
                }
                else {
                    if (interceptPos == null) {
                        continue;
                    }
                    final double possibleDist = srcVec.func_72438_d(interceptPos.field_72307_f);
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
    
    public void onUsingTick(final ItemStack stack, final EntityLivingBase living, final int count) {
        final World world = living.field_70170_p;
        if (stack.func_77952_i() >= this.getMaxDamage(stack)) {
            living.func_184602_cy();
            return;
        }
        if (count % 5 == 0) {
            final Entity pointedEntity = this.getPlayerLookTarget(world, living);
            if (pointedEntity != null && pointedEntity instanceof EntityLivingBase) {
                final EntityLivingBase target = (EntityLivingBase)pointedEntity;
                if (target.func_70660_b(MobEffects.field_76421_d) != null || target.func_110143_aJ() < 1.0f) {
                    if (target.func_110143_aJ() <= 3.0f) {
                        this.makeRedMagicTrail(world, living.field_70165_t, living.field_70163_u + living.func_70047_e(), living.field_70161_v, target.field_70165_t, target.field_70163_u + target.func_70047_e(), target.field_70161_v);
                        if (target instanceof EntityLiving) {
                            ((EntityLiving)target).func_70656_aK();
                        }
                        target.func_184185_a(SoundEvents.field_187655_bw, 1.0f, ((ItemTFScepterLifeDrain.field_77697_d.nextFloat() - ItemTFScepterLifeDrain.field_77697_d.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                        animateTargetShatter(world, target);
                        if (!world.field_72995_K) {
                            target.func_70106_y();
                            target.func_70645_a(DamageSource.func_76354_b((Entity)living, (Entity)living));
                        }
                        living.func_184602_cy();
                    }
                    else if (!world.field_72995_K) {
                        target.func_70097_a(DamageSource.func_76354_b((Entity)living, (Entity)living), 3.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth(living)) {
                            target.field_70159_w = 0.0;
                            target.field_70181_x = 0.2;
                            target.field_70179_y = 0.0;
                        }
                        target.func_70690_d(new PotionEffect(MobEffects.field_76421_d, 20, 2));
                        if (count % 10 == 0) {
                            living.func_70691_i(1.0f);
                            if (living instanceof EntityPlayer) {
                                ((EntityPlayer)living).func_71024_bL().func_75122_a(1, 0.1f);
                            }
                        }
                    }
                }
                else {
                    this.makeRedMagicTrail(world, living.field_70165_t, living.field_70163_u + living.func_70047_e(), living.field_70161_v, target.field_70165_t, target.field_70163_u + target.func_70047_e(), target.field_70161_v);
                    living.func_184185_a(SoundEvents.field_187649_bu, 1.0f, (world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()) * 0.2f + 1.0f);
                    if (!world.field_72995_K) {
                        target.func_70097_a(DamageSource.func_76354_b((Entity)living, (Entity)living), 1.0f);
                        if (this.getMaxHealth(target) <= this.getMaxHealth(living)) {
                            target.field_70159_w = 0.0;
                            target.field_70181_x = 0.2;
                            target.field_70179_y = 0.0;
                        }
                        target.func_70690_d(new PotionEffect(MobEffects.field_76421_d, 20, 2));
                    }
                }
                if (!world.field_72995_K) {
                    stack.func_77972_a(1, living);
                }
            }
        }
    }
    
    private float getMaxHealth(final EntityLivingBase target) {
        return (float)target.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
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
            world.func_175688_a(EnumParticleTypes.SPELL_MOB, tx, ty, tz, (double)f, (double)f2, (double)f3, new int[0]);
        }
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BOW;
    }
    
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack) {
        return oldStack.func_77973_b() == newStack.func_77973_b();
    }
    
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged) {
        return slotChanged || newStack.func_77973_b() != oldStack.func_77973_b();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a("twilightforest.scepter_charges", new Object[] { stack.func_77958_k() - stack.func_77952_i() }));
    }
}
