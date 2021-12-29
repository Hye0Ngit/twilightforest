// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.function.Predicate;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import twilightforest.TwilightForestMod;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import java.util.function.Function;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class TFPacketHandler
{
    private static final String PROTOCOL_VERSION = "2";
    public static final SimpleChannel CHANNEL;
    
    public static void init() {
        int id = 0;
        TFPacketHandler.CHANNEL.messageBuilder((Class)AreaProtectionPacket.class, id++).encoder(AreaProtectionPacket::encode).decoder((Function)AreaProtectionPacket::new).consumer((SimpleChannel.MessageBuilder.ToBooleanBiFunction)new SimpleChannel.MessageBuilder.ToBooleanBiFunction<AreaProtectionPacket, Supplier<NetworkEvent.Context>>() {
            public boolean applyAsBool(final AreaProtectionPacket message, final Supplier<NetworkEvent.Context> ctx) {
                return AreaProtectionPacket.Handler.onMessage(message, ctx);
            }
        }).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)ChangeBiomePacket.class, id++).encoder(ChangeBiomePacket::encode).decoder((Function)ChangeBiomePacket::new).consumer(ChangeBiomePacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)EnforceProgressionStatusPacket.class, id++).encoder(EnforceProgressionStatusPacket::encode).decoder((Function)EnforceProgressionStatusPacket::new).consumer(EnforceProgressionStatusPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)StructureProtectionPacket.class, id++).encoder(StructureProtectionPacket::encode).decoder((Function)StructureProtectionPacket::new).consumer(StructureProtectionPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)StructureProtectionClearPacket.class, id++).encoder(StructureProtectionClearPacket::encode).decoder((Function)StructureProtectionClearPacket::new).consumer(StructureProtectionClearPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)ThrowPlayerPacket.class, id++).encoder(ThrowPlayerPacket::encode).decoder((Function)ThrowPlayerPacket::new).consumer(ThrowPlayerPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)MagicMapPacket.class, id++).encoder(MagicMapPacket::encode).decoder((Function)MagicMapPacket::new).consumer(MagicMapPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)MazeMapPacket.class, id++).encoder(MazeMapPacket::encode).decoder((Function)MazeMapPacket::new).consumer(MazeMapPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)UpdateShieldPacket.class, id++).encoder(UpdateShieldPacket::encode).decoder((Function)UpdateShieldPacket::new).consumer(UpdateShieldPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)UncraftingGuiPacket.class, id++).encoder(UncraftingGuiPacket::encode).decoder((Function)UncraftingGuiPacket::new).consumer(UncraftingGuiPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)UpdateTFMultipartPacket.class, id++).encoder(UpdateTFMultipartPacket::encode).decoder((Function)UpdateTFMultipartPacket::new).consumer(UpdateTFMultipartPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)SpawnFallenLeafFromPacket.class, id++).encoder(SpawnFallenLeafFromPacket::encode).decoder((Function)SpawnFallenLeafFromPacket::new).consumer(SpawnFallenLeafFromPacket.Handler::onMessage).add();
        TFPacketHandler.CHANNEL.messageBuilder((Class)MissingAdvancementToastPacket.class, id++).encoder(MissingAdvancementToastPacket::encode).decoder((Function)MissingAdvancementToastPacket::new).consumer(MissingAdvancementToastPacket::handle).add();
    }
    
    static {
        CHANNEL = NetworkRegistry.newSimpleChannel(TwilightForestMod.prefix("channel"), () -> "2", (Predicate)"2"::equals, (Predicate)"2"::equals);
    }
}
