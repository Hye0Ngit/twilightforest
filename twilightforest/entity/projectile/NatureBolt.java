// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.projectile.ItemSupplier;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class NatureBolt extends TFThrowable implements ITFProjectile, ItemSupplier
{
    public NatureBolt(final EntityType<? extends NatureBolt> type, final Level world) {
        super(type, world);
    }
    
    public NatureBolt(final Level world, final LivingEntity owner) {
        super(TFEntities.NATURE_BOLT, world, owner);
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.makeTrail();
    }
    
    protected float m_7139_() {
        return 0.003f;
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.m_20185_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dy = this.m_20186_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            final double dz = this.m_20189_() + 0.5 * (this.f_19796_.nextDouble() - this.f_19796_.nextDouble());
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123748_, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.f_19853_.m_6493_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, Blocks.f_50050_.m_49966_()), false, this.m_20185_(), this.m_20186_(), this.m_20189_(), this.f_19796_.nextGaussian() * 0.05, this.f_19796_.nextDouble() * 0.2, this.f_19796_.nextGaussian() * 0.05);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_6532_(final HitResult ray) {
        if (!this.f_19853_.f_46443_) {
            if (ray.m_6662_() == HitResult.Type.BLOCK) {
                final BlockPos blockPosHit = ((BlockHitResult)ray).m_82425_();
                final Material materialHit = this.f_19853_.m_8055_(blockPosHit).m_60767_();
                if (materialHit == Material.f_76315_) {
                    final ItemStack dummy = new ItemStack((ItemLike)Items.f_42499_, 1);
                    if (BoneMealItem.m_40627_(dummy, this.f_19853_, blockPosHit)) {
                        this.f_19853_.m_46796_(2005, blockPosHit, 0);
                    }
                }
                else if (materialHit.m_76333_() && this.canReplaceBlock(this.f_19853_, blockPosHit)) {
                    this.f_19853_.m_46597_(blockPosHit, Blocks.f_50052_.m_49966_());
                }
            }
            if (ray instanceof EntityHitResult) {
                final Entity owner = this.m_37282_();
                final Entity entityHit = ((EntityHitResult)ray).m_82443_();
                if (entityHit instanceof LivingEntity && (owner == null || (entityHit != owner && entityHit != owner.m_20202_())) && entityHit.m_6469_(TFDamageSources.leafBrain((Entity)this, (LivingEntity)this.m_37282_()), 2.0f) && this.f_19853_.m_46791_() != Difficulty.PEACEFUL) {
                    final int poisonTime = (this.f_19853_.m_46791_() == Difficulty.HARD) ? 7 : 3;
                    ((LivingEntity)entityHit).m_7292_(new MobEffectInstance(MobEffects.f_19614_, poisonTime * 20, 0));
                }
            }
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
    
    private boolean canReplaceBlock(final Level world, final BlockPos pos) {
        final float hardness = world.m_8055_(pos).m_60800_((BlockGetter)world, pos);
        return hardness >= 0.0f && hardness < 50.0f;
    }
    
    public ItemStack m_7846_() {
        return new ItemStack((ItemLike)Items.f_42404_);
    }
}
