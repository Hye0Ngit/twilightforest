// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
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
import net.minecraft.world.item.context.DirectionalPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class MoonwormShot extends TFThrowable
{
    public MoonwormShot(final EntityType<? extends MoonwormShot> type, final Level world) {
        super(type, world);
    }
    
    public MoonwormShot(final EntityType<? extends MoonwormShot> type, final Level world, final LivingEntity thrower) {
        super(type, world, thrower);
        this.m_37251_((Entity)thrower, thrower.m_146909_(), thrower.m_146908_(), 0.0f, 1.5f, 1.0f);
    }
    
    public MoonwormShot(final Level worldIn, final double x, final double y, final double z) {
        super(TFEntities.MOONWORM_SHOT, worldIn, x, y, z);
    }
    
    public void m_8119_() {
        super.m_8119_();
        this.makeTrail();
    }
    
    public float m_6073_() {
        return 1.0f;
    }
    
    private void makeTrail() {
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
                this.f_19853_.m_6493_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, ((Block)TFBlocks.MOONWORM.get()).m_49966_()), false, this.m_20185_(), this.m_20186_(), this.m_20189_(), 0.0, 0.0, 0.0);
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
                final DirectionalPlaceContext context = new DirectionalPlaceContext(this.f_19853_, pos, blockray.m_82434_(), ItemStack.f_41583_, blockray.m_82434_().m_122424_());
                if (currentState.m_60767_().m_76336_() && !currentState.m_60620_((Tag)BlockTags.f_13076_) && !currentState.m_60713_(Blocks.f_49991_)) {
                    this.f_19853_.m_46597_(pos, (BlockState)((Block)TFBlocks.MOONWORM.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)((BlockHitResult)ray).m_82434_()));
                }
                else {
                    final ItemEntity squish = new ItemEntity(this.f_19853_, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), Items.f_42540_.m_7968_());
                    squish.m_19983_(squish.m_32055_());
                }
            }
            Label_0303: {
                if (ray instanceof final EntityHitResult entity) {
                    if (entity.m_82443_() != null) {
                        final Entity 82443_ = entity.m_82443_();
                        if (82443_ instanceof final Player player) {
                            if (!player.m_21033_(EquipmentSlot.HEAD)) {
                                player.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)TFBlocks.MOONWORM.get()));
                                break Label_0303;
                            }
                        }
                        entity.m_82443_().m_6469_((DamageSource)new IndirectEntityDamageSource("moonworm", (Entity)this, (Entity)this), (this.f_19796_.nextInt(3) == 0) ? 1.0f : 0.0f);
                    }
                }
            }
            this.f_19853_.m_7605_((Entity)this, (byte)3);
            this.m_146870_();
        }
    }
}
