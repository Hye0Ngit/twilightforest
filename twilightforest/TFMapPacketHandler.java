// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.storage.MapData;
import net.minecraft.client.Minecraft;
import twilightforest.item.ItemTFMazeMap;
import twilightforest.item.ItemTFMagicMap;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.Unpooled;
import net.minecraft.network.Packet;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S34PacketMaps;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class TFMapPacketHandler
{
    public S34PacketMaps readMapPacket(final ByteBuf byteBuf) {
        final S34PacketMaps mapPacket = new S34PacketMaps();
        try {
            mapPacket.func_148837_a(new PacketBuffer(byteBuf));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mapPacket;
    }
    
    public static Packet makeMagicMapPacket(final String mapChannel, final short mapID, final byte[] datas) {
        final S34PacketMaps mapPacket = new S34PacketMaps((int)mapID, datas);
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        try {
            mapPacket.func_148840_b(payload);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, mapChannel);
        return (Packet)pkt;
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void incomingPacket(final FMLNetworkEvent.ClientCustomPacketEvent event) {
        if (event.packet.channel().equals("magicmap")) {
            final S34PacketMaps mapPacket = this.readMapPacket(event.packet.payload());
            ItemTFMagicMap.getMPMapData(mapPacket.func_149188_c(), TwilightForestMod.proxy.getClientWorld()).func_76192_a(mapPacket.func_149187_d());
        }
        else if (event.packet.channel().equals("mazemap")) {
            final S34PacketMaps mapPacket = this.readMapPacket(event.packet.payload());
            final TFMazeMapData data = ItemTFMazeMap.getMPMapData(mapPacket.func_149188_c(), TwilightForestMod.proxy.getClientWorld());
            data.func_76192_a(mapPacket.func_149187_d());
            Minecraft.func_71410_x().field_71460_t.func_147701_i().func_148246_a((MapData)data);
        }
    }
}
