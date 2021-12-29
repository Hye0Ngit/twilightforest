// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.client.IRenderHandler;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketStructureProtectionClear implements IMessage
{
    public void fromBytes(final ByteBuf buf) {
    }
    
    public void toBytes(final ByteBuf buf) {
    }
    
    public static class Handler implements IMessageHandler<PacketStructureProtectionClear, IMessage>
    {
        public IMessage onMessage(final PacketStructureProtectionClear message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a(() -> {
                final WorldProvider provider = Minecraft.func_71410_x().field_71441_e.field_73011_w;
                if (provider instanceof WorldProviderTwilightForest) {
                    final IRenderHandler weatherRenderer = provider.getWeatherRenderer();
                    if (weatherRenderer instanceof TFWeatherRenderer) {
                        ((TFWeatherRenderer)weatherRenderer).setProtectedBox(null);
                    }
                }
                return;
            });
            return null;
        }
    }
}
