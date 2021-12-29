// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.Iterator;
import net.minecraft.client.gui.MapItemRenderer;
import java.util.Map;
import net.minecraft.world.storage.MapDecoration;
import java.util.LinkedHashMap;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.World;
import twilightforest.item.MagicMapItem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import twilightforest.TFMagicMapData;
import net.minecraft.network.play.server.SMapDataPacket;

public class MagicMapPacket
{
    private final byte[] featureData;
    private final SMapDataPacket inner;
    
    public MagicMapPacket(final TFMagicMapData mapData, final SMapDataPacket inner) {
        this.featureData = mapData.serializeFeatures();
        this.inner = inner;
    }
    
    public MagicMapPacket(final PacketBuffer buf) {
        this.featureData = buf.func_179251_a();
        this.inner = new SMapDataPacket();
        try {
            this.inner.func_148837_a(buf);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read inner SPacketMaps", e);
        }
    }
    
    public void encode(final PacketBuffer buf) {
        buf.func_179250_a(this.featureData);
        try {
            this.inner.func_148840_b(buf);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't write inner SPacketMaps", e);
        }
    }
    
    public static class Handler
    {
        public static boolean onMessage(final MagicMapPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final MapItemRenderer mapitemrenderer = Minecraft.func_71410_x().field_71460_t.func_147701_i();
                    final String s = MagicMapItem.getMapName(message.inner.func_149188_c());
                    TFMagicMapData mapdata = TFMagicMapData.getMagicMapData((World)Minecraft.func_71410_x().field_71441_e, s);
                    if (mapdata == null) {
                        mapdata = new TFMagicMapData(s);
                        if (mapitemrenderer.func_191205_a(s) != null) {
                            final MapData mapdata2 = mapitemrenderer.func_191207_a(mapitemrenderer.func_191205_a(s));
                            if (mapdata2 instanceof TFMagicMapData) {
                                mapdata = (TFMagicMapData)mapdata2;
                            }
                        }
                        TFMagicMapData.registerMagicMapData((World)Minecraft.func_71410_x().field_71441_e, mapdata);
                    }
                    message.inner.func_179734_a((MapData)mapdata);
                    mapdata.deserializeFeatures(message.featureData);
                    final Map<String, MapDecoration> saveVanilla = new LinkedHashMap<String, MapDecoration>(mapdata.field_76203_h);
                    mapdata.field_76203_h.clear();
                    for (final TFMagicMapData.TFMapDecoration tfDecor : mapdata.tfDecorations) {
                        mapdata.field_76203_h.put(tfDecor.toString(), tfDecor);
                    }
                    mapdata.field_76203_h.putAll(saveVanilla);
                    mapitemrenderer.func_148246_a((MapData)mapdata);
                }
            });
            return true;
        }
    }
}
