// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.client.IWeatherRenderHandler;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.TwilightForestRenderInfo;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class StructureProtectionPacket
{
    private final BoundingBox sbb;
    
    public StructureProtectionPacket(final BoundingBox sbb) {
        this.sbb = sbb;
    }
    
    public StructureProtectionPacket(final FriendlyByteBuf buf) {
        this.sbb = new BoundingBox(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeInt(this.sbb.m_162395_());
        buf.writeInt(this.sbb.m_162396_());
        buf.writeInt(this.sbb.m_162398_());
        buf.writeInt(this.sbb.m_162399_());
        buf.writeInt(this.sbb.m_162400_());
        buf.writeInt(this.sbb.m_162401_());
    }
    
    public static class Handler
    {
        public static boolean onMessage(final StructureProtectionPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                final DimensionSpecialEffects info = (DimensionSpecialEffects)DimensionSpecialEffects.f_108857_.get((Object)TwilightForestMod.prefix("renderer"));
                if (info instanceof TwilightForestRenderInfo) {
                    final IWeatherRenderHandler weatherRenderer = info.getWeatherRenderHandler();
                    if (weatherRenderer instanceof final TFWeatherRenderer tfWeatherRenderer) {
                        tfWeatherRenderer.setProtectedBox(message.sbb);
                    }
                }
                return;
            });
            return true;
        }
    }
}
