// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.Entity;
import twilightforest.capabilities.shield.IShieldCapability;

public class UpdateShieldPacket
{
    private final int entityID;
    private final int temporaryShields;
    private final int permanentShields;
    
    public UpdateShieldPacket(final int id, final IShieldCapability cap) {
        this.entityID = id;
        this.temporaryShields = cap.temporaryShieldsLeft();
        this.permanentShields = cap.permanentShieldsLeft();
    }
    
    public UpdateShieldPacket(final Entity entity, final IShieldCapability cap) {
        this(entity.func_145782_y(), cap);
    }
    
    public UpdateShieldPacket(final PacketBuffer buf) {
        this.entityID = buf.readInt();
        this.temporaryShields = buf.readInt();
        this.permanentShields = buf.readInt();
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeInt(this.entityID);
        buf.writeInt(this.temporaryShields);
        buf.writeInt(this.permanentShields);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final UpdateShieldPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Entity entity = Minecraft.func_71410_x().field_71441_e.func_73045_a(message.entityID);
                    if (entity instanceof LivingEntity) {
                        entity.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> {
                            cap.setShields(message.temporaryShields, true);
                            cap.setShields(message.permanentShields, false);
                        });
                    }
                }
            });
            return true;
        }
    }
}
