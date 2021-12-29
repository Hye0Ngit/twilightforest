// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.server.MinecraftServer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;

public class EnforceProgressionStatusPacket
{
    private final boolean enforce;
    
    public EnforceProgressionStatusPacket(final FriendlyByteBuf buf) {
        this.enforce = buf.readBoolean();
    }
    
    public EnforceProgressionStatusPacket(final boolean enforce) {
        this.enforce = enforce;
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeBoolean(this.enforce);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final EnforceProgressionStatusPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    ((GameRules.BooleanValue)Minecraft.m_91087_().f_91073_.m_46469_().m_46170_((GameRules.Key)TwilightForestMod.ENFORCED_PROGRESSION_RULE)).m_46246_(message.enforce, (MinecraftServer)null);
                }
            });
            return true;
        }
    }
}
