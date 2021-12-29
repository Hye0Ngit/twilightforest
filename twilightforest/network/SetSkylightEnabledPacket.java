// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;

public class SetSkylightEnabledPacket
{
    private final boolean enabled;
    
    public SetSkylightEnabledPacket(final boolean enabled) {
        this.enabled = enabled;
    }
    
    public SetSkylightEnabledPacket(final PacketBuffer buf) {
        this.enabled = buf.readBoolean();
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeBoolean(this.enabled);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final SetSkylightEnabledPacket message, final Supplier<NetworkEvent.Context> ctx) {
            return true;
        }
    }
}
