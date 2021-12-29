// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.Iterator;
import net.minecraft.world.storage.MapDecoration;
import net.minecraft.client.gui.MapItemRenderer;
import java.util.Map;
import java.util.LinkedHashMap;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.World;
import twilightforest.item.ItemTFMagicMap;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import java.io.IOException;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.ByteBuf;
import twilightforest.TFMagicMapData;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketMagicMap implements IMessage
{
    private int mapID;
    private byte[] featureData;
    private SPacketMaps inner;
    
    public PacketMagicMap() {
    }
    
    public PacketMagicMap(final int mapID, final TFMagicMapData mapData, final SPacketMaps inner) {
        this.mapID = mapID;
        this.featureData = mapData.serializeFeatures();
        this.inner = inner;
    }
    
    public void fromBytes(final ByteBuf buf) {
        final PacketBuffer tmp = new PacketBuffer(buf);
        this.mapID = ByteBufUtils.readVarInt(buf, 5);
        this.featureData = tmp.func_179251_a();
        this.inner = new SPacketMaps();
        try {
            this.inner.func_148837_a(tmp);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read inner SPacketMaps", e);
        }
    }
    
    public void toBytes(final ByteBuf buf) {
        final PacketBuffer tmp = new PacketBuffer(buf);
        ByteBufUtils.writeVarInt(buf, this.mapID, 5);
        tmp.func_179250_a(this.featureData);
        try {
            this.inner.func_148840_b(tmp);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't write inner SPacketMaps", e);
        }
    }
    
    public static class Handler implements IMessageHandler<PacketMagicMap, IMessage>
    {
        public IMessage onMessage(final PacketMagicMap message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final MapItemRenderer mapItemRenderer = Minecraft.func_71410_x().field_71460_t.func_147701_i();
                    TFMagicMapData mapData = ItemTFMagicMap.loadMapData(message.mapID, (World)Minecraft.func_71410_x().field_71441_e);
                    if (mapData == null) {
                        final String s = "magicmap_" + message.mapID;
                        mapData = new TFMagicMapData(s);
                        if (mapItemRenderer.func_191205_a(s) != null) {
                            final MapData mapdata1 = mapItemRenderer.func_191207_a(mapItemRenderer.func_191205_a(s));
                            if (mapdata1 instanceof TFMagicMapData) {
                                mapData = (TFMagicMapData)mapdata1;
                            }
                        }
                        Minecraft.func_71410_x().field_71441_e.func_72823_a(s, (WorldSavedData)mapData);
                    }
                    message.inner.func_179734_a((MapData)mapData);
                    mapData.deserializeFeatures(message.featureData);
                    final Map<String, MapDecoration> saveVanilla = mapData.field_76203_h;
                    mapData.field_76203_h = new LinkedHashMap();
                    for (final TFMagicMapData.TFMapDecoration tfDecor : mapData.tfDecorations) {
                        mapData.field_76203_h.put(tfDecor.toString(), tfDecor);
                    }
                    mapData.field_76203_h.putAll(saveVanilla);
                    mapItemRenderer.func_148246_a((MapData)mapData);
                }
            });
            return null;
        }
    }
}
