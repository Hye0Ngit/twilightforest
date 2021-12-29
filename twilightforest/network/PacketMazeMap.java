// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.storage.MapData;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.world.storage.WorldSavedData;
import twilightforest.TFMazeMapData;
import net.minecraft.world.World;
import twilightforest.item.ItemTFMazeMap;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketMazeMap implements IMessage
{
    private SPacketMaps inner;
    
    public PacketMazeMap() {
    }
    
    public PacketMazeMap(final SPacketMaps inner) {
        this.inner = inner;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.inner = new SPacketMaps();
        try {
            this.inner.func_148837_a(new PacketBuffer(buf));
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read inner SPacketMaps", e);
        }
    }
    
    public void toBytes(final ByteBuf buf) {
        try {
            this.inner.func_148840_b(new PacketBuffer(buf));
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't write inner SPacketMaps", e);
        }
    }
    
    public static class Handler implements IMessageHandler<PacketMazeMap, IMessage>
    {
        public IMessage onMessage(final PacketMazeMap message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final MapItemRenderer mapItemRenderer = Minecraft.func_71410_x().field_71460_t.func_147701_i();
                    MapData mapData = ItemTFMazeMap.loadMapData(message.inner.func_149188_c(), (World)Minecraft.func_71410_x().field_71441_e);
                    if (mapData == null) {
                        final String s = "mazemap_" + message.inner.func_149188_c();
                        mapData = new TFMazeMapData(s);
                        if (mapItemRenderer.func_191205_a(s) != null) {
                            final MapData mapData2 = mapItemRenderer.func_191207_a(mapItemRenderer.func_191205_a(s));
                            if (mapData2 != null) {
                                mapData = mapData2;
                            }
                        }
                        Minecraft.func_71410_x().field_71441_e.func_72823_a(s, (WorldSavedData)mapData);
                    }
                    message.inner.func_179734_a(mapData);
                    mapItemRenderer.func_148246_a(mapData);
                }
            });
            return null;
        }
    }
}
