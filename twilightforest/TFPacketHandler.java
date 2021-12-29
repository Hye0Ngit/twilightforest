// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.network.IPacketHandler;

public class TFPacketHandler implements IPacketHandler
{
    public void onPacketData(final ce manager, final dj packet, final Player player) {
        if (packet.a.equals("tfmagicmap")) {
            final da mapPacket = this.readMapPacket(packet.c);
            ItemTFMagicMap.getMPMapData(mapPacket.b, TwilightForestMod.proxy.getClientWorld()).a(mapPacket.c);
        }
        if (packet.a.equals("tfmazemap")) {
            final da mapPacket = this.readMapPacket(packet.c);
            ItemTFMazeMap.getMPMapData(mapPacket.b, TwilightForestMod.proxy.getClientWorld()).a(mapPacket.c);
        }
    }
    
    public da readMapPacket(final byte[] databytes) {
        final DataInputStream dis = new DataInputStream(new ByteArrayInputStream(databytes));
        final da mapPacket = new da();
        try {
            mapPacket.a(dis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mapPacket;
    }
    
    public static eg makeMagicMapPacket(final String mapChannel, final short itemID, final short mapID, final byte[] datas) {
        final da mapPacket = new da(itemID, mapID, datas);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        final DataOutputStream dos = new DataOutputStream(bos);
        try {
            mapPacket.a(dos);
        }
        catch (IOException ex) {}
        final dj pkt = new dj();
        pkt.a = mapChannel;
        pkt.c = bos.toByteArray();
        pkt.b = bos.size();
        pkt.r = true;
        return (eg)pkt;
    }
}
