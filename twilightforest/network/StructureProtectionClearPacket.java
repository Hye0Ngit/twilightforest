// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.client.IWeatherRenderHandler;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.TwilightForestRenderInfo;
import twilightforest.TwilightForestMod;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;

public class StructureProtectionClearPacket
{
    public StructureProtectionClearPacket() {
    }
    
    public StructureProtectionClearPacket(final PacketBuffer unused) {
    }
    
    public void encode(final PacketBuffer unused) {
    }
    
    public static class Handler
    {
        public static boolean onMessage(final StructureProtectionClearPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                final DimensionRenderInfo info = (DimensionRenderInfo)DimensionRenderInfo.field_239208_a_.get((Object)TwilightForestMod.prefix("renderer"));
                if (info instanceof TwilightForestRenderInfo) {
                    final IWeatherRenderHandler weatherRenderer = info.getWeatherRenderHandler();
                    if (weatherRenderer instanceof TFWeatherRenderer) {
                        ((TFWeatherRenderer)weatherRenderer).setProtectedBox(null);
                    }
                }
                return;
            });
            return true;
        }
    }
}
