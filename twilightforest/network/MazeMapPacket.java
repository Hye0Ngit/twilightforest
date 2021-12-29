// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.World;
import twilightforest.TFMazeMapData;
import twilightforest.item.MazeMapItem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SMapDataPacket;

public class MazeMapPacket
{
    private final SMapDataPacket inner;
    
    public MazeMapPacket(final SMapDataPacket inner) {
        this.inner = inner;
    }
    
    public MazeMapPacket(final PacketBuffer buf) {
        this.inner = new SMapDataPacket();
        try {
            this.inner.func_148837_a(buf);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read inner SPacketMaps", e);
        }
    }
    
    public void encode(final PacketBuffer buf) {
        try {
            this.inner.func_148840_b(buf);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't write inner SPacketMaps", e);
        }
    }
    
    public static class Handler
    {
        public static boolean onMessage(final MazeMapPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final MapItemRenderer mapitemrenderer = Minecraft.func_71410_x().field_71460_t.func_147701_i();
                    final String s = MazeMapItem.getMapName(message.inner.func_149188_c());
                    TFMazeMapData mapdata = TFMazeMapData.getMazeMapData((World)Minecraft.func_71410_x().field_71441_e, s);
                    if (mapdata == null) {
                        mapdata = new TFMazeMapData(s);
                        if (mapitemrenderer.func_191205_a(s) != null) {
                            final MapData mapdata2 = mapitemrenderer.func_191207_a(mapitemrenderer.func_191205_a(s));
                            if (mapdata2 instanceof TFMazeMapData) {
                                mapdata = (TFMazeMapData)mapdata2;
                            }
                        }
                        TFMazeMapData.registerMazeMapData((World)Minecraft.func_71410_x().field_71441_e, mapdata);
                    }
                    message.inner.func_179734_a((MapData)mapdata);
                    mapitemrenderer.func_148246_a((MapData)mapdata);
                }
            });
            return true;
        }
    }
}
