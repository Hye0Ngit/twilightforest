// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.gui.MapRenderer;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import twilightforest.TFMazeMapData;
import twilightforest.item.MazeMapItem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;

public class MazeMapPacket
{
    private final ClientboundMapItemDataPacket inner;
    
    public MazeMapPacket(final ClientboundMapItemDataPacket inner) {
        this.inner = inner;
    }
    
    public MazeMapPacket(final FriendlyByteBuf buf) {
        this.inner = new ClientboundMapItemDataPacket(buf);
    }
    
    public void encode(final FriendlyByteBuf buf) {
        this.inner.m_5779_(buf);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final MazeMapPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final MapRenderer mapitemrenderer = Minecraft.m_91087_().f_91063_.m_109151_();
                    final String s = MazeMapItem.getMapName(message.inner.m_132445_());
                    TFMazeMapData mapdata = TFMazeMapData.getMazeMapData((Level)Minecraft.m_91087_().f_91073_, s);
                    if (mapdata == null) {
                        mapdata = new TFMazeMapData(0, 0, message.inner.m_178982_(), false, false, message.inner.m_178983_(), (ResourceKey<Level>)Minecraft.m_91087_().f_91073_.m_46472_());
                        TFMazeMapData.registerMazeMapData((Level)Minecraft.m_91087_().f_91073_, mapdata, s);
                    }
                    message.inner.m_132437_((MapItemSavedData)mapdata);
                    mapitemrenderer.m_168765_(message.inner.m_132445_(), (MapItemSavedData)mapdata);
                }
            });
            return true;
        }
    }
}
