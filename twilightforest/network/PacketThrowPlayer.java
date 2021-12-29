// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketThrowPlayer implements IMessage
{
    private float motionX;
    private float motionY;
    private float motionZ;
    
    public PacketThrowPlayer() {
    }
    
    public PacketThrowPlayer(final float motionX, final float motionY, final float motionZ) {
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.motionX = buf.readFloat();
        this.motionY = buf.readFloat();
        this.motionZ = buf.readFloat();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeFloat(this.motionX);
        buf.writeFloat(this.motionY);
        buf.writeFloat(this.motionZ);
    }
    
    public static class Handler implements IMessageHandler<PacketThrowPlayer, IMessage>
    {
        public IMessage onMessage(final PacketThrowPlayer message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    Minecraft.func_71410_x().field_71439_g.func_70024_g((double)message.motionX, (double)message.motionY, (double)message.motionZ);
                }
            });
            return null;
        }
    }
}
