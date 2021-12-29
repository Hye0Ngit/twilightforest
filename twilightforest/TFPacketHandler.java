// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import net.minecraft.network.packet.Packet;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.entity.player.EntityPlayer;
import java.nio.ByteBuffer;
import twilightforest.item.ItemTFMazeMap;
import twilightforest.item.ItemTFMagicMap;
import cpw.mods.fml.common.network.Player;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.INetworkManager;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;

public class TFPacketHandler implements IPacketHandler, IConnectionHandler
{
    public static final byte CHANGE_DIM_ID = 1;
    public static final byte TRANSFORM_BIOME = 2;
    
    public void onPacketData(final INetworkManager manager, final Packet250CustomPayload packet, final Player player) {
        if (packet.field_73630_a.equals("tfmagicmap")) {
            final Packet131MapData mapPacket = this.readMapPacket(packet.field_73629_c);
            ItemTFMagicMap.getMPMapData(mapPacket.field_73436_b, TwilightForestMod.proxy.getClientWorld()).func_76192_a(mapPacket.field_73437_c);
        }
        if (packet.field_73630_a.equals("tfmazemap")) {
            final Packet131MapData mapPacket = this.readMapPacket(packet.field_73629_c);
            ItemTFMazeMap.getMPMapData(mapPacket.field_73436_b, TwilightForestMod.proxy.getClientWorld()).func_76192_a(mapPacket.field_73437_c);
        }
        if (packet.field_73630_a.equals("TwilightForest") && packet.field_73629_c[0] == 1) {
            final ByteBuffer bBuffer = ByteBuffer.wrap(packet.field_73629_c);
            bBuffer.get();
            final int dim = bBuffer.getInt();
            TwilightForestMod.setDimensionID(dim);
        }
        if (packet.field_73630_a.equals("TwilightForest") && packet.field_73629_c[0] == 2) {
            final ByteBuffer bBuffer = ByteBuffer.wrap(packet.field_73629_c);
            bBuffer.get();
            final int x = bBuffer.getInt();
            final int z = bBuffer.getInt();
            final byte biomeID = bBuffer.get();
            final EntityPlayer playerEntity = (EntityPlayer)player;
            final Chunk chunkAt = playerEntity.field_70170_p.func_72938_d(x, z);
            chunkAt.func_76605_m()[(z & 0xF) << 4 | (x & 0xF)] = biomeID;
            playerEntity.field_70170_p.func_72909_d(x, 0, z, x, 255, z);
        }
    }
    
    public Packet131MapData readMapPacket(final byte[] databytes) {
        final DataInputStream dis = new DataInputStream(new ByteArrayInputStream(databytes));
        final Packet131MapData mapPacket = new Packet131MapData();
        try {
            mapPacket.func_73267_a(dis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return mapPacket;
    }
    
    public static Packet makeMagicMapPacket(final String mapChannel, final short itemID, final short mapID, final byte[] datas) {
        final Packet131MapData mapPacket = new Packet131MapData(itemID, mapID, datas);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
        final DataOutputStream dos = new DataOutputStream(bos);
        try {
            mapPacket.func_73273_a(dos);
        }
        catch (IOException ex) {}
        final Packet250CustomPayload pkt = new Packet250CustomPayload();
        pkt.field_73630_a = mapChannel;
        pkt.field_73629_c = bos.toByteArray();
        pkt.field_73628_b = bos.size();
        pkt.field_73287_r = true;
        return (Packet)pkt;
    }
    
    public void playerLoggedIn(final Player player, final NetHandler netHandler, final INetworkManager manager) {
    }
    
    public String connectionReceived(final NetLoginHandler netHandler, final INetworkManager manager) {
        final ByteBuffer bBuffer = ByteBuffer.allocate(5);
        bBuffer.put((byte)1);
        bBuffer.putInt(TwilightForestMod.dimensionID);
        final Packet250CustomPayload packet = new Packet250CustomPayload("TwilightForest", bBuffer.array());
        manager.func_74429_a((Packet)packet);
        return null;
    }
    
    public void connectionOpened(final NetHandler netClientHandler, final String server, final int port, final INetworkManager manager) {
    }
    
    public void connectionOpened(final NetHandler netClientHandler, final MinecraftServer server, final INetworkManager manager) {
    }
    
    public void connectionClosed(final INetworkManager manager) {
    }
    
    public void clientLoggedIn(final NetHandler clientHandler, final INetworkManager manager, final Packet1Login login) {
    }
}
