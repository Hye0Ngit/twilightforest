// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class TFPacketHandler
{
    public static final SimpleNetworkWrapper CHANNEL;
    
    public static void init() {
        int id = 0;
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketAnnihilateBlock.Handler.class, (Class)PacketAnnihilateBlock.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketAreaProtection.Handler.class, (Class)PacketAreaProtection.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketChangeBiome.Handler.class, (Class)PacketChangeBiome.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketEnforceProgressionStatus.Handler.class, (Class)PacketEnforceProgressionStatus.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketStructureProtection.Handler.class, (Class)PacketStructureProtection.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketStructureProtectionClear.Handler.class, (Class)PacketStructureProtectionClear.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketThrowPlayer.Handler.class, (Class)PacketThrowPlayer.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketMagicMap.Handler.class, (Class)PacketMagicMap.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketMazeMap.Handler.class, (Class)PacketMazeMap.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketUpdateShield.Handler.class, (Class)PacketUpdateShield.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketSetSkylightEnabled.Handler.class, (Class)PacketSetSkylightEnabled.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketSpawnEntityParticles.Handler.class, (Class)PacketSpawnEntityParticles.class, id++, Side.CLIENT);
        TFPacketHandler.CHANNEL.registerMessage((Class)PacketUncraftingGui.Handler.class, (Class)PacketUncraftingGui.class, id++, Side.SERVER);
    }
    
    static {
        CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel("twilightforest");
    }
}
