// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.client.IWeatherRenderHandler;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.TwilightForestRenderInfo;
import twilightforest.TwilightForestMod;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.MutableBoundingBox;

public class StructureProtectionPacket
{
    private final MutableBoundingBox sbb;
    
    public StructureProtectionPacket(final MutableBoundingBox sbb) {
        this.sbb = sbb;
    }
    
    public StructureProtectionPacket(final PacketBuffer buf) {
        this.sbb = new MutableBoundingBox(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeInt(this.sbb.field_78897_a);
        buf.writeInt(this.sbb.field_78895_b);
        buf.writeInt(this.sbb.field_78896_c);
        buf.writeInt(this.sbb.field_78893_d);
        buf.writeInt(this.sbb.field_78894_e);
        buf.writeInt(this.sbb.field_78892_f);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final StructureProtectionPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                final DimensionRenderInfo info = (DimensionRenderInfo)DimensionRenderInfo.field_239208_a_.get((Object)TwilightForestMod.prefix("renderer"));
                if (info instanceof TwilightForestRenderInfo) {
                    final IWeatherRenderHandler weatherRenderer = info.getWeatherRenderHandler();
                    if (weatherRenderer instanceof TFWeatherRenderer) {
                        ((TFWeatherRenderer)weatherRenderer).setProtectedBox(message.sbb);
                    }
                }
                return;
            });
            return true;
        }
    }
}
