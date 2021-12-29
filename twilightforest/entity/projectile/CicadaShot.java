// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import twilightforest.TFSounds;
import twilightforest.TFConfig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.TFEntities;
import javax.annotation.Nullable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class CicadaShot extends TFThrowable
{
    public CicadaShot(final EntityType<? extends CicadaShot> type, final Level world) {
        super(type, world);
    }
    
    public CicadaShot(final Level worldIn, @Nullable final LivingEntity living, final double x, final double y, final double z) {
        super(TFEntities.CICADA_SHOT, worldIn);
        final float yaw = (living != null) ? living.m_146908_() : 0.0f;
        final float pitch = (living != null) ? living.m_146909_() : 0.0f;
        this.m_7678_(living.m_20185_(), living.m_20186_() + living.m_20192_(), living.m_20189_(), yaw, pitch);
        this.m_6034_(this.m_20185_(), this.m_20186_(), this.m_20189_());
        this.m_20334_(x, y, z);
        this.m_5602_((Entity)living);
        final Vec3 motion = this.m_20184_();
        this.m_6686_(motion.f_82479_, motion.f_82480_, motion.f_82481_, 3.0f, 1.0f);
    }
    
    public void m_8119_() {
        super.m_8119_();
    }
    
    public float m_6073_() {
        return 1.0f;
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    public float m_6143_() {
        return 1.0f;
    }
    
    protected float m_7139_() {
        return 0.03f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.f_19853_.m_6493_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, ((Block)TFBlocks.CICADA.get()).m_49966_()), false, this.m_20185_(), this.m_20186_(), this.m_20189_(), 0.0, 0.0, 0.0);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_6532_(final HitResult ray) {
        if (!this.f_19853_.f_46443_) {
            if (ray instanceof final BlockHitResult blockray) {
                final BlockPos pos = blockray.m_82425_().m_142300_(blockray.m_82434_());
                final BlockState currentState = this.f_19853_.m_8055_(pos);
                if (currentState.m_60767_().m_76336_() && !currentState.m_60620_((Tag)BlockTags.f_13076_) && !currentState.m_60713_(Blocks.f_49991_)) {
                    this.f_19853_.m_46597_(pos, (BlockState)((Block)TFBlocks.CICADA.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)((BlockHitResult)ray).m_82434_()));
                }
                else {
                    final ItemEntity squish = new ItemEntity(this.f_19853_, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), Items.f_42490_.m_7968_());
                    squish.m_19983_(squish.m_32055_());
                }
            }
            Label_0287: {
                if (ray instanceof final EntityHitResult entity) {
                    if (entity.m_82443_() != null) {
                        final Entity 82443_ = entity.m_82443_();
                        if (82443_ instanceof final Player player) {
                            if (!player.m_21033_(EquipmentSlot.HEAD)) {
                                player.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)TFBlocks.CICADA.get()));
                                if (!(boolean)TFConfig.CLIENT_CONFIG.silentCicadas.get()) {
                                    player.m_5496_(TFSounds.CICADA, 1.0f, 1.0f);
                                }
                                break Label_0287;
                            }
                        }
                        entity.m_82443_().m_6469_((DamageSource)new IndirectEntityDamageSource("cicada", (Entity)this, (Entity)null), 2.0f);
                    }
                }
            }
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
}
