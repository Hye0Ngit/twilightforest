// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import twilightforest.world.WorldProviderTwilightForest;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSetSkylightEnabled implements IMessage
{
    private boolean enabled;
    
    public PacketSetSkylightEnabled() {
    }
    
    public PacketSetSkylightEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.enabled = buf.readBoolean();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.enabled);
    }
    
    public static class Handler implements IMessageHandler<PacketSetSkylightEnabled, IMessage>
    {
        public IMessage onMessage(final PacketSetSkylightEnabled message, final MessageContext ctx) {
            WorldProviderTwilightForest.setSkylightEnabled(message.enabled);
            return null;
        }
    }
}
