// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities.shield;

import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import twilightforest.network.UpdateShieldPacket;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

public class ShieldCapabilityHandler implements IShieldCapability
{
    private int temporaryShields;
    private int permanentShields;
    private LivingEntity host;
    private int timer;
    private int breakTimer;
    
    @Override
    public void setEntity(final LivingEntity entity) {
        this.host = entity;
    }
    
    @Override
    public void update() {
        if (!this.host.f_19853_.f_46443_ && this.temporaryShieldsLeft() > 0 && this.timer-- <= 0 && this.breakTimer <= 0 && (!(this.host instanceof Player) || !((Player)this.host).m_7500_())) {
            this.breakShield();
        }
        if (this.breakTimer > 0) {
            --this.breakTimer;
        }
    }
    
    @Override
    public int shieldsLeft() {
        return this.temporaryShields + this.permanentShields;
    }
    
    @Override
    public int temporaryShieldsLeft() {
        return this.temporaryShields;
    }
    
    @Override
    public int permanentShieldsLeft() {
        return this.permanentShields;
    }
    
    @Override
    public void breakShield() {
        if (this.breakTimer <= 0) {
            if (this.temporaryShields > 0) {
                --this.temporaryShields;
                this.resetTimer();
            }
            else if (this.permanentShields > 0) {
                --this.permanentShields;
            }
            final LivingEntity host = this.host;
            if (host instanceof final Player player) {
                if (player instanceof ServerPlayer) {
                    player.m_36220_(TFStats.TF_SHIELDS_BROKEN);
                }
            }
            this.sendUpdatePacket();
            this.host.f_19853_.m_5594_((Player)null, this.host.m_142538_(), TFSounds.SHIELD_BREAK, SoundSource.PLAYERS, 1.0f, ((this.host.m_21187_().nextFloat() - this.host.m_21187_().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            this.breakTimer = 20;
        }
    }
    
    @Override
    public void replenishShields() {
        this.setShields(5, true);
        this.host.f_19853_.m_5594_((Player)null, this.host.m_142538_(), TFSounds.SHIELD_ADD, SoundSource.PLAYERS, 1.0f, (this.host.m_21187_().nextFloat() - this.host.m_21187_().nextFloat()) * 0.2f + 1.0f);
    }
    
    @Override
    public void setShields(final int amount, final boolean temp) {
        if (temp) {
            this.temporaryShields = Math.max(amount, 0);
            this.resetTimer();
        }
        else {
            this.permanentShields = Math.max(amount, 0);
        }
        this.sendUpdatePacket();
    }
    
    @Override
    public void addShields(final int amount, final boolean temp) {
        if (temp) {
            if (this.temporaryShields <= 0) {
                this.resetTimer();
            }
            this.temporaryShields = Math.max(this.temporaryShields + amount, 0);
        }
        else {
            this.permanentShields = Math.max(this.permanentShields + amount, 0);
        }
        this.sendUpdatePacket();
    }
    
    void initShields(final int temporary, final int permanent) {
        this.temporaryShields = Math.max(temporary, 0);
        this.permanentShields = Math.max(permanent, 0);
        this.resetTimer();
    }
    
    private void resetTimer() {
        this.timer = 240;
    }
    
    private void sendUpdatePacket() {
        if (this.host instanceof ServerPlayer) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this.host), (Object)new UpdateShieldPacket((Entity)this.host, this));
        }
    }
    
    public CompoundTag serializeNBT() {
        final CompoundTag tag = new CompoundTag();
        tag.m_128405_("tempshields", this.temporaryShieldsLeft());
        tag.m_128405_("permshields", this.permanentShieldsLeft());
        return tag;
    }
    
    public void deserializeNBT(final CompoundTag tag) {
        this.initShields(tag.m_128451_("tempshields"), tag.m_128451_("permshields"));
    }
}
