// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
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
        this(entity.m_142049_(), cap);
    }
    
    public UpdateShieldPacket(final FriendlyByteBuf buf) {
        this.entityID = buf.readInt();
        this.temporaryShields = buf.readInt();
        this.permanentShields = buf.readInt();
    }
    
    public void encode(final FriendlyByteBuf buf) {
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
                    final Entity entity = Minecraft.m_91087_().f_91073_.m_6815_(message.entityID);
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
