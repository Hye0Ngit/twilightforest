// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.server.MinecraftServer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.GameRules;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;

public class EnforceProgressionStatusPacket
{
    private final boolean enforce;
    
    public EnforceProgressionStatusPacket(final PacketBuffer buf) {
        this.enforce = buf.readBoolean();
    }
    
    public EnforceProgressionStatusPacket(final boolean enforce) {
        this.enforce = enforce;
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeBoolean(this.enforce);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final EnforceProgressionStatusPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    ((GameRules.BooleanValue)Minecraft.func_71410_x().field_71441_e.func_82736_K().func_223585_a((GameRules.RuleKey)TwilightForestMod.ENFORCED_PROGRESSION_RULE)).func_223570_a(message.enforce, (MinecraftServer)null);
                }
            });
            return true;
        }
    }
}
