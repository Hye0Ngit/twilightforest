// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities.shield;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayerMP;
import twilightforest.network.TFPacketHandler;
import net.minecraft.entity.Entity;
import twilightforest.network.PacketUpdateShield;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;

public class ShieldCapabilityHandler implements IShieldCapability
{
    private int temporaryShields;
    private int permanentShields;
    private EntityLivingBase host;
    private int timer;
    
    @Override
    public void setEntity(final EntityLivingBase entity) {
        this.host = entity;
    }
    
    @Override
    public void update() {
        if (!this.host.field_70170_p.field_72995_K && this.shieldsLeft() > 0 && this.timer-- <= 0 && (!(this.host instanceof EntityPlayer) || !((EntityPlayer)this.host).func_184812_l_())) {
            this.breakShield();
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
        if (this.temporaryShields > 0) {
            --this.temporaryShields;
            this.resetTimer();
        }
        else if (this.permanentShields > 0) {
            --this.permanentShields;
        }
        this.host.field_70170_p.func_184133_a((EntityPlayer)null, this.host.func_180425_c(), SoundEvents.field_187635_cQ, SoundCategory.PLAYERS, 1.0f, ((this.host.func_70681_au().nextFloat() - this.host.func_70681_au().nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.sendUpdatePacket();
    }
    
    @Override
    public void replenishShields() {
        this.setShields(5, true);
        this.host.field_70170_p.func_184133_a((EntityPlayer)null, this.host.func_180425_c(), SoundEvents.field_187665_Y, SoundCategory.PLAYERS, 1.0f, (this.host.func_70681_au().nextFloat() - this.host.func_70681_au().nextFloat()) * 0.2f + 1.0f);
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
        if (!this.host.field_70170_p.field_72995_K) {
            final IMessage message = (IMessage)new PacketUpdateShield((Entity)this.host, this);
            TFPacketHandler.CHANNEL.sendToAllTracking(message, (Entity)this.host);
            if (this.host instanceof EntityPlayerMP) {
                TFPacketHandler.CHANNEL.sendTo(message, (EntityPlayerMP)this.host);
            }
        }
    }
}
