// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.server.MinecraftServer;
import java.io.DataOutput;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.DataInput;
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
    public static final byte CHANGE_DIM_ID = 1;
    public static final byte TRANSFORM_BIOME = 2;
    
    public void onPacketData(final cl manager, final dz packet, final Player player) {
        if (packet.a.equals("tfmagicmap")) {
            final dq mapPacket = this.readMapPacket(packet.c);
            ItemTFMagicMap.getMPMapData(mapPacket.b, TwilightForestMod.proxy.getClientWorld()).a(mapPacket.c);
        }
        if (packet.a.equals("tfmazemap")) {
            final dq mapPacket = this.readMapPacket(packet.c);
            ItemTFMazeMap.getMPMapData(mapPacket.b, TwilightForestMod.proxy.getClientWorld()).a(mapPacket.c);
        }
        if (packet.a.equals("TwilightForest") && packet.c[0] == 1) {
            final ByteBuffer bBuffer = ByteBuffer.wrap(packet.c);
            bBuffer.get();
            final int dim = bBuffer.getInt();
            TwilightForestMod.setDimensionID(dim);
        }
        if (packet.a.equals("TwilightForest") && packet.c[0] == 2) {
            final ByteBuffer bBuffer = ByteBuffer.wrap(packet.c);
            bBuffer.get();
            final int x = bBuffer.getInt();
            final int z = bBuffer.getInt();
            final byte biomeID = bBuffer.get();
            final ue playerEntity = (ue)player;
            final adq chunkAt = playerEntity.q.d(x, z);
            chunkAt.m()[(z & 0xF) << 4 | (x & 0xF)] = biomeID;
            playerEntity.q.g(x, 0, z, x, 255, z);
        }
    }
    
    public dq readMapPacket(final byte[] databytes) {
        final DataInputStream dis = new DataInputStream(new ByteArrayInputStream(databytes));
        final dq mapPacket = new dq();
        try {
            mapPacket.a((DataInput)dis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mapPacket;
    }
    
    public static ex makeMagicMapPacket(final String mapChannel, final short itemID, final short mapID, final byte[] datas) {
        final dq mapPacket = new dq(itemID, mapID, datas);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        final DataOutputStream dos = new DataOutputStream(bos);
        try {
            mapPacket.a((DataOutput)dos);
        }
        catch (IOException ex) {}
        final dz pkt = new dz();
        pkt.a = mapChannel;
        pkt.c = bos.toByteArray();
        pkt.b = bos.size();
        pkt.s = true;
        return (ex)pkt;
    }
    
    public void playerLoggedIn(final Player player, final ey netHandler, final cl manager) {
    }
    
    public String connectionReceived(final jx netHandler, final cl manager) {
        final ByteBuffer bBuffer = ByteBuffer.allocate(5);
        bBuffer.put((byte)1);
        bBuffer.putInt(TwilightForestMod.dimensionID);
        final dz packet = new dz("TwilightForest", bBuffer.array());
        manager.a((ex)packet);
        return null;
    }
    
    public void connectionOpened(final ey netClientHandler, final String server, final int port, final cl manager) {
    }
    
    public void connectionOpened(final ey netClientHandler, final MinecraftServer server, final cl manager) {
    }
    
    public void connectionClosed(final cl manager) {
    }
    
    public void clientLoggedIn(final ey clientHandler, final cl manager, final eo login) {
    }
}
