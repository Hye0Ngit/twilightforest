// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;

public class ThrowPlayerPacket
{
    private final float motionX;
    private final float motionY;
    private final float motionZ;
    
    public ThrowPlayerPacket(final float motionX, final float motionY, final float motionZ) {
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
    }
    
    public ThrowPlayerPacket(final FriendlyByteBuf buf) {
        this.motionX = buf.readFloat();
        this.motionY = buf.readFloat();
        this.motionZ = buf.readFloat();
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeFloat(this.motionX);
        buf.writeFloat(this.motionY);
        buf.writeFloat(this.motionZ);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final ThrowPlayerPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    Minecraft.m_91087_().f_91074_.m_5997_((double)message.motionX, (double)message.motionY, (double)message.motionZ);
                }
            });
            return true;
        }
    }
}
