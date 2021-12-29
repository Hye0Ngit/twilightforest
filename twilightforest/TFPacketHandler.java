// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.server.MinecraftServer;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import twilightforest.item.ItemTFMazeMap;
import twilightforest.item.ItemTFMagicMap;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;

public class TFPacketHandler implements IPacketHandler, IConnectionHandler
{
    private static final byte CHANGE_DIM_ID = 1;
    
    public void onPacketData(final cg manager, final dk packet, final Player player) {
        if (packet.a.equals("tfmagicmap")) {
            final db mapPacket = this.readMapPacket(packet.c);
            ItemTFMagicMap.getMPMapData(mapPacket.b, TwilightForestMod.proxy.getClientWorld()).a(mapPacket.c);
        }
        if (packet.a.equals("tfmazemap")) {
            final db mapPacket = this.readMapPacket(packet.c);
            ItemTFMazeMap.getMPMapData(mapPacket.b, TwilightForestMod.proxy.getClientWorld()).a(mapPacket.c);
        }
        if (packet.a.equals("TwilightForest") && packet.c[0] == 1) {
            final ByteBuffer bBuffer = ByteBuffer.wrap(packet.c);
            bBuffer.get();
            final int dim = bBuffer.getInt();
            TwilightForestMod.setDimensionID(dim);
        }
    }
    
    public db readMapPacket(final byte[] databytes) {
        final DataInputStream dis = new DataInputStream(new ByteArrayInputStream(databytes));
        final db mapPacket = new db();
        try {
            mapPacket.a(dis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mapPacket;
    }
    
    public static ei makeMagicMapPacket(final String mapChannel, final short itemID, final short mapID, final byte[] datas) {
        final db mapPacket = new db(itemID, mapID, datas);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        final DataOutputStream dos = new DataOutputStream(bos);
        try {
            mapPacket.a(dos);
        }
        catch (IOException ex) {}
        final dk pkt = new dk();
        pkt.a = mapChannel;
        pkt.c = bos.toByteArray();
        pkt.b = bos.size();
        pkt.s = true;
        return (ei)pkt;
    }
    
    public void playerLoggedIn(final Player player, final ej netHandler, final cg manager) {
    }
    
    public String connectionReceived(final jf netHandler, final cg manager) {
        final ByteBuffer bBuffer = ByteBuffer.allocate(5);
        bBuffer.put((byte)1);
        bBuffer.putInt(TwilightForestMod.dimensionID);
        final dk packet = new dk("TwilightForest", bBuffer.array());
        manager.a((ei)packet);
        return null;
    }
    
    public void connectionOpened(final ej netClientHandler, final String server, final int port, final cg manager) {
    }
    
    public void connectionOpened(final ej netClientHandler, final MinecraftServer server, final cg manager) {
    }
    
    public void connectionClosed(final cg manager) {
    }
    
    public void clientLoggedIn(final ej clientHandler, final cg manager, final dz login) {
    }
}
