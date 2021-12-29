// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.client.IWeatherRenderHandler;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.TwilightForestRenderInfo;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;

public class StructureProtectionClearPacket
{
    public StructureProtectionClearPacket() {
    }
    
    public StructureProtectionClearPacket(final FriendlyByteBuf unused) {
    }
    
    public void encode(final FriendlyByteBuf unused) {
    }
    
    public static class Handler
    {
        public static boolean onMessage(final StructureProtectionClearPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                final DimensionSpecialEffects info = (DimensionSpecialEffects)DimensionSpecialEffects.f_108857_.get((Object)TwilightForestMod.prefix("renderer"));
                if (info instanceof TwilightForestRenderInfo) {
                    final IWeatherRenderHandler weatherRenderer = info.getWeatherRenderHandler();
                    if (weatherRenderer instanceof final TFWeatherRenderer tfWeatherRenderer) {
                        tfWeatherRenderer.setProtectedBox(null);
                    }
                }
                return;
            });
            return true;
        }
    }
}
