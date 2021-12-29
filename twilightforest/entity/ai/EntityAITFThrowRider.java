// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.TFPacketHandler;
import twilightforest.network.PacketThrowPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAITFThrowRider extends EntityAIAttackMelee
{
    private int throwTimer;
    private int timeout;
    
    public EntityAITFThrowRider(final EntityCreature creature, final double speedIn, final boolean useLongMemory) {
        super(creature, speedIn, useLongMemory);
    }
    
    public boolean func_75250_a() {
        return this.field_75441_b.func_184188_bt().isEmpty() && super.func_75250_a();
    }
    
    public void func_75249_e() {
        this.throwTimer = 10 + this.field_75441_b.func_70681_au().nextInt(30);
        this.timeout = 80 + this.field_75441_b.func_70681_au().nextInt(40);
        super.func_75249_e();
    }
    
    public void func_75246_d() {
        --this.timeout;
        if (!this.field_75441_b.func_184188_bt().isEmpty()) {
            --this.throwTimer;
        }
        else {
            super.func_75246_d();
        }
    }
    
    protected void func_190102_a(final EntityLivingBase p_190102_1_, final double p_190102_2_) {
        final double d0 = this.func_179512_a(p_190102_1_);
        if (p_190102_2_ <= d0 && this.field_75439_d <= 0) {
            this.field_75439_d = 20;
            this.field_75441_b.func_184609_a(EnumHand.MAIN_HAND);
            if (this.field_75441_b.func_184188_bt().isEmpty() && p_190102_1_.func_184187_bx() == null) {
                p_190102_1_.func_184220_m((Entity)this.field_75441_b);
            }
        }
    }
    
    public void func_75251_c() {
        if (!this.field_75441_b.func_184188_bt().isEmpty()) {
            final Entity rider = this.field_75441_b.func_184188_bt().get(0);
            rider.func_184210_p();
            Vec3d throwVec = this.field_75441_b.func_70040_Z().func_186678_a(2.0);
            throwVec = new Vec3d(throwVec.field_72450_a, 0.9, throwVec.field_72449_c);
            rider.func_70024_g(throwVec.field_72450_a, throwVec.field_72448_b, throwVec.field_72449_c);
            if (rider instanceof EntityPlayerMP) {
                final EntityPlayerMP player = (EntityPlayerMP)rider;
                final IMessage message = (IMessage)new PacketThrowPlayer((float)throwVec.field_72450_a, (float)throwVec.field_72448_b, (float)throwVec.field_72449_c);
                TFPacketHandler.CHANNEL.sendTo(message, player);
            }
        }
        super.func_75251_c();
    }
    
    public boolean func_75253_b() {
        return (this.throwTimer > 0 && !this.field_75441_b.func_184188_bt().isEmpty()) || (this.timeout > 0 && super.func_75253_b() && this.field_75441_b.func_184188_bt().isEmpty());
    }
}
