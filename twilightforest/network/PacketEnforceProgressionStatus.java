// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketEnforceProgressionStatus implements IMessage
{
    private boolean enforce;
    
    public PacketEnforceProgressionStatus() {
    }
    
    public PacketEnforceProgressionStatus(final boolean enforce) {
        this.enforce = enforce;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.enforce = buf.readBoolean();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.enforce);
    }
    
    public static class Handler implements IMessageHandler<PacketEnforceProgressionStatus, IMessage>
    {
        public IMessage onMessage(final PacketEnforceProgressionStatus message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    Minecraft.func_71410_x().field_71441_e.func_82736_K().func_82764_b("tfEnforcedProgression", String.valueOf(message.enforce));
                }
            });
            return null;
        }
    }
}
