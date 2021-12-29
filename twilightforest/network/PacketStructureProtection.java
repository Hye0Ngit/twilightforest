// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.client.IRenderHandler;
import net.minecraft.world.WorldProvider;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketStructureProtection implements IMessage
{
    private StructureBoundingBox sbb;
    
    public PacketStructureProtection() {
    }
    
    public PacketStructureProtection(final StructureBoundingBox sbb) {
        this.sbb = sbb;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.sbb = new StructureBoundingBox(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.sbb.field_78897_a);
        buf.writeInt(this.sbb.field_78895_b);
        buf.writeInt(this.sbb.field_78896_c);
        buf.writeInt(this.sbb.field_78893_d);
        buf.writeInt(this.sbb.field_78894_e);
        buf.writeInt(this.sbb.field_78892_f);
    }
    
    public static class Handler implements IMessageHandler<PacketStructureProtection, IMessage>
    {
        public IMessage onMessage(final PacketStructureProtection message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a(() -> {
                final WorldProvider provider = Minecraft.func_71410_x().field_71441_e.field_73011_w;
                if (provider instanceof WorldProviderTwilightForest) {
                    final IRenderHandler weatherRenderer = provider.getWeatherRenderer();
                    if (weatherRenderer instanceof TFWeatherRenderer) {
                        ((TFWeatherRenderer)weatherRenderer).setProtectedBox(message.sbb);
                    }
                }
                return;
            });
            return null;
        }
    }
}
