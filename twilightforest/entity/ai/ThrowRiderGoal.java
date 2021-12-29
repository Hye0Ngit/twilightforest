// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraftforge.fml.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import twilightforest.network.ThrowPlayerPacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class ThrowRiderGoal extends MeleeAttackGoal
{
    private int throwTimer;
    private int timeout;
    
    public ThrowRiderGoal(final CreatureEntity creature, final double speedIn, final boolean useLongMemory) {
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
    
    protected void func_190102_a(final LivingEntity p_190102_1_, final double p_190102_2_) {
        final double d0 = this.func_179512_a(p_190102_1_);
        if (p_190102_2_ <= d0 && this.func_234041_j_() <= 0) {
            this.func_234039_g_();
            this.field_75441_b.func_184609_a(Hand.MAIN_HAND);
            if (this.field_75441_b.func_184188_bt().isEmpty() && p_190102_1_.func_184187_bx() == null) {
                p_190102_1_.func_184220_m((Entity)this.field_75441_b);
            }
        }
    }
    
    public void func_75251_c() {
        if (!this.field_75441_b.func_184188_bt().isEmpty()) {
            final Entity rider = this.field_75441_b.func_184188_bt().get(0);
            rider.func_184210_p();
            Vector3d throwVec = this.field_75441_b.func_70040_Z().func_186678_a(2.0);
            throwVec = new Vector3d(throwVec.field_72450_a, 0.9, throwVec.field_72449_c);
            rider.func_70024_g(throwVec.field_72450_a, throwVec.field_72448_b, throwVec.field_72449_c);
            if (rider instanceof ServerPlayerEntity) {
                final ServerPlayerEntity player = (ServerPlayerEntity)rider;
                final ThrowPlayerPacket message = new ThrowPlayerPacket((float)throwVec.field_72450_a, (float)throwVec.field_72448_b, (float)throwVec.field_72449_c);
                TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)message);
            }
        }
        super.func_75251_c();
    }
    
    public boolean func_75253_b() {
        return (this.throwTimer > 0 && !this.field_75441_b.func_184188_bt().isEmpty()) || (this.timeout > 0 && super.func_75253_b() && this.field_75441_b.func_184188_bt().isEmpty());
    }
}
