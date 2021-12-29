// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.FriendlyByteBuf;
import twilightforest.item.TFItems;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Iterator;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.BlockHitResult;
import twilightforest.TFSounds;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import twilightforest.enchantment.TFEnchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.monster.BlockChainGoblin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraftforge.fmllegacy.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class ChainBlock extends ThrowableProjectile implements IEntityAdditionalSpawnData
{
    private int MAX_SMASH;
    private static final int MAX_CHAIN = 16;
    private static final EntityDataAccessor<Boolean> HAND;
    private static final EntityDataAccessor<Boolean> IS_FOIL;
    private boolean isReturning;
    private boolean ignoreBlocks;
    private ItemStack stack;
    private int blocksSmashed;
    private double velX;
    private double velY;
    private double velZ;
    public final Chain chain1;
    public final Chain chain2;
    public final Chain chain3;
    public final Chain chain4;
    public final Chain chain5;
    private BlockChainGoblin.MultipartGenericsAreDumb[] partsArray;
    
    public ChainBlock(final EntityType<? extends ChainBlock> type, final Level world) {
        super((EntityType)type, world);
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.chain1 = new Chain((Entity)this);
        this.chain2 = new Chain((Entity)this);
        this.chain3 = new Chain((Entity)this);
        this.chain4 = new Chain((Entity)this);
        this.chain5 = new Chain((Entity)this);
        this.partsArray = new BlockChainGoblin.MultipartGenericsAreDumb[] { this.chain1, this.chain2, this.chain3, this.chain4, this.chain5 };
    }
    
    public ChainBlock(final EntityType<? extends ChainBlock> type, final Level world, final LivingEntity thrower, final InteractionHand hand, final ItemStack stack) {
        super((EntityType)type, thrower, world);
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.isReturning = false;
        this.ignoreBlocks = (EnchantmentHelper.m_44843_((Enchantment)TFEnchantments.PRESERVATION.get(), stack) > 0);
        this.MAX_SMASH = 12 + EnchantmentHelper.m_44843_((Enchantment)TFEnchantments.DESTRUCTION.get(), stack) * 10;
        this.stack = stack;
        this.setHand(hand);
        this.chain1 = new Chain((Entity)this);
        this.chain2 = new Chain((Entity)this);
        this.chain3 = new Chain((Entity)this);
        this.chain4 = new Chain((Entity)this);
        this.chain5 = new Chain((Entity)this);
        this.partsArray = new BlockChainGoblin.MultipartGenericsAreDumb[] { this.chain1, this.chain2, this.chain3, this.chain4, this.chain5 };
        this.m_37251_((Entity)thrower, thrower.m_146909_(), thrower.m_146908_(), 0.0f, 1.5f, 1.0f);
        this.f_19804_.m_135381_((EntityDataAccessor)ChainBlock.IS_FOIL, (Object)stack.m_41790_());
    }
    
    private void setHand(final InteractionHand hand) {
        this.f_19804_.m_135381_((EntityDataAccessor)ChainBlock.HAND, (Object)(hand == InteractionHand.MAIN_HAND));
    }
    
    public InteractionHand getHand() {
        return this.f_19804_.m_135370_((EntityDataAccessor)ChainBlock.HAND) ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
    }
    
    public boolean isFoil() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)ChainBlock.IS_FOIL);
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    public void m_6686_(final double x, final double y, final double z, final float speed, final float accuracy) {
        super.m_6686_(x, y, z, speed, accuracy);
        this.velX = this.m_20184_().m_7096_();
        this.velY = this.m_20184_().m_7098_();
        this.velZ = this.m_20184_().m_7094_();
    }
    
    protected float m_7139_() {
        return 0.05f;
    }
    
    protected void m_5790_(final EntityHitResult result) {
        super.m_5790_(result);
        if (!this.f_19853_.f_46443_ && result.m_82443_() instanceof LivingEntity && result.m_82443_() != this.m_37282_() && result.m_82443_().m_6469_(TFDamageSources.spiked((Entity)this, (LivingEntity)this.m_37282_()), 10.0f)) {
            this.m_5496_(TFSounds.BLOCKCHAIN_HIT, 1.0f, this.f_19796_.nextFloat());
            this.f_19797_ += 60;
        }
    }
    
    protected void m_8060_(final BlockHitResult result) {
        super.m_8060_(result);
        if (!this.f_19853_.f_46443_ && !this.f_19853_.m_46859_(result.m_82425_())) {
            if (!this.isReturning) {
                this.m_5496_(TFSounds.BLOCKCHAIN_COLLIDE, 0.125f, this.f_19796_.nextFloat());
            }
            if (this.blocksSmashed < this.MAX_SMASH) {
                if (this.f_19853_.m_8055_(result.m_82425_()).m_60800_((BlockGetter)this.f_19853_, result.m_82425_()) < 0.0f || this.f_19853_.m_8055_(result.m_82425_()).m_60800_((BlockGetter)this.f_19853_, result.m_82425_()) > 0.3f) {
                    final double bounce = 0.6;
                    this.velX *= bounce;
                    this.velY *= bounce;
                    this.velZ *= bounce;
                    switch (result.m_82434_()) {
                        case DOWN: {
                            if (this.velY > 0.0) {
                                this.velY *= -bounce;
                                break;
                            }
                            break;
                        }
                        case UP: {
                            if (this.velY < 0.0) {
                                this.velY *= -bounce;
                                break;
                            }
                            break;
                        }
                        case NORTH: {
                            if (this.velZ > 0.0) {
                                this.velZ *= -bounce;
                                break;
                            }
                            break;
                        }
                        case SOUTH: {
                            if (this.velZ < 0.0) {
                                this.velZ *= -bounce;
                                break;
                            }
                            break;
                        }
                        case WEST: {
                            if (this.velX > 0.0) {
                                this.velX *= -bounce;
                                break;
                            }
                            break;
                        }
                        case EAST: {
                            if (this.velX < 0.0) {
                                this.velX *= -bounce;
                                break;
                            }
                            break;
                        }
                    }
                }
                if (!this.ignoreBlocks) {
                    this.affectBlocksInAABB(this.m_142469_().m_82400_(0.5 + EnchantmentHelper.m_44843_((Enchantment)TFEnchantments.DESTRUCTION.get(), this.stack) * 0.5));
                }
            }
            this.isReturning = true;
            if (this.blocksSmashed > this.MAX_SMASH && this.f_19797_ < 60) {
                this.f_19797_ += 60;
            }
        }
    }
    
    private void affectBlocksInAABB(final AABB box) {
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            final BlockState state = this.f_19853_.m_8055_(pos);
            final Block block = state.m_60734_();
            if (!state.m_60795_() && block.getExplosionResistance(state, (BlockGetter)this.f_19853_, pos, (Explosion)null) < 15.0f + EnchantmentHelper.m_44843_((Enchantment)TFEnchantments.BLOCK_STRENGTH.get(), this.stack) * 20.0f && state.m_60800_((BlockGetter)this.f_19853_, pos) >= 0.0f && block.canEntityDestroy(state, (BlockGetter)this.f_19853_, pos, (Entity)this)) {
                final Entity 37282_ = this.m_37282_();
                if (!(37282_ instanceof Player)) {
                    continue;
                }
                final Player player = (Player)37282_;
                if (MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(this.f_19853_, pos, state, player)) || !ForgeEventFactory.doPlayerHarvestCheck(player, state, !state.m_60834_() || player.m_21120_(this.getHand()).m_41735_(state))) {
                    continue;
                }
                block.m_6240_(this.f_19853_, player, pos, state, this.f_19853_.m_7702_(pos), player.m_21120_(this.getHand()));
                this.f_19853_.m_46961_(pos, false);
                ++this.blocksSmashed;
            }
        }
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (this.f_19853_.f_46443_) {
            this.chain1.m_8119_();
            this.chain2.m_8119_();
            this.chain3.m_8119_();
            this.chain4.m_8119_();
            this.chain5.m_8119_();
            if (this.m_37282_() != null) {
                final Vec3 handVec = this.m_37282_().m_20154_().m_82524_((this.getHand() == InteractionHand.MAIN_HAND) ? -0.4f : 0.4f);
                final double sx = this.m_37282_().m_20185_() + handVec.f_82479_;
                final double sy = this.m_37282_().m_20186_() + handVec.f_82480_ - 0.4000000059604645 + this.m_37282_().m_20192_();
                final double sz = this.m_37282_().m_20189_() + handVec.f_82481_;
                final double ox = sx - this.m_20185_();
                final double oy = sy - this.m_20186_() - 0.25;
                final double oz = sz - this.m_20189_();
                this.chain1.m_6034_(sx - ox * 0.05, sy - oy * 0.05, sz - oz * 0.05);
                this.chain2.m_6034_(sx - ox * 0.25, sy - oy * 0.25, sz - oz * 0.25);
                this.chain3.m_6034_(sx - ox * 0.45, sy - oy * 0.45, sz - oz * 0.45);
                this.chain4.m_6034_(sx - ox * 0.65, sy - oy * 0.65, sz - oz * 0.65);
                this.chain5.m_6034_(sx - ox * 0.85, sy - oy * 0.85, sz - oz * 0.85);
            }
        }
        else if (this.m_37282_() == null) {
            this.m_146870_();
        }
        else {
            final double distToPlayer = this.m_20270_(this.m_37282_());
            if (!this.isReturning && distToPlayer > 16.0) {
                this.isReturning = true;
            }
            if (this.isReturning) {
                if (distToPlayer < 2.0) {
                    this.m_146870_();
                }
                final LivingEntity returnTo = (LivingEntity)this.m_37282_();
                final Vec3 back = new Vec3(returnTo.m_20185_(), returnTo.m_20186_() + returnTo.m_20192_(), returnTo.m_20189_()).m_82546_(this.m_20182_()).m_82541_();
                final float age = Math.min(this.f_19797_ * 0.03f, 1.0f);
                this.m_20256_(new Vec3(this.velX * (1.0 - age) + back.f_82479_ * 2.0 * age, this.velY * (1.0 - age) + back.f_82480_ * 2.0 * age - this.m_7139_(), this.velZ * (1.0 - age) + back.f_82481_ * 2.0 * age));
            }
        }
    }
    
    protected void m_8097_() {
        this.f_19804_.m_135372_((EntityDataAccessor)ChainBlock.HAND, (Object)true);
        this.f_19804_.m_135372_((EntityDataAccessor)ChainBlock.IS_FOIL, (Object)false);
    }
    
    public void m_142687_(final Entity.RemovalReason reason) {
        super.m_142687_(reason);
        final LivingEntity thrower = (LivingEntity)this.m_37282_();
        if (thrower != null && thrower.m_21211_().m_41720_() == TFItems.BLOCK_AND_CHAIN.get()) {
            thrower.m_5810_();
        }
    }
    
    public void writeSpawnData(final FriendlyByteBuf buffer) {
        buffer.writeInt((this.m_37282_() != null) ? this.m_37282_().m_142049_() : -1);
        buffer.writeBoolean(this.getHand() == InteractionHand.MAIN_HAND);
    }
    
    public void readSpawnData(final FriendlyByteBuf additionalData) {
        final Entity e = this.f_19853_.m_6815_(additionalData.readInt());
        if (e instanceof LivingEntity) {
            this.m_5602_(e);
        }
        this.setHand(additionalData.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
    }
    
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    static {
        HAND = SynchedEntityData.m_135353_((Class)ChainBlock.class, EntityDataSerializers.f_135035_);
        IS_FOIL = SynchedEntityData.m_135353_((Class)ChainBlock.class, EntityDataSerializers.f_135035_);
    }
}
