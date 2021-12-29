// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.Iterator;
import net.minecraft.client.gui.MapRenderer;
import java.util.Map;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import java.util.LinkedHashMap;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import twilightforest.item.MagicMapItem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import twilightforest.TFMagicMapData;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;

public class MagicMapPacket
{
    private final byte[] featureData;
    private final ClientboundMapItemDataPacket inner;
    
    public MagicMapPacket(final TFMagicMapData mapData, final ClientboundMapItemDataPacket inner) {
        this.featureData = mapData.serializeFeatures();
        this.inner = inner;
    }
    
    public MagicMapPacket(final FriendlyByteBuf buf) {
        this.featureData = buf.m_130052_();
        this.inner = new ClientboundMapItemDataPacket(buf);
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.m_130087_(this.featureData);
        this.inner.m_5779_(buf);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final MagicMapPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final MapRenderer mapitemrenderer = Minecraft.m_91087_().f_91063_.m_109151_();
                    final String s = MagicMapItem.getMapName(message.inner.m_132445_());
                    TFMagicMapData mapdata = TFMagicMapData.getMagicMapData((Level)Minecraft.m_91087_().f_91073_, s);
                    if (mapdata == null) {
                        mapdata = new TFMagicMapData(0, 0, message.inner.m_178982_(), false, false, message.inner.m_178983_(), (ResourceKey<Level>)Minecraft.m_91087_().f_91073_.m_46472_());
                        TFMagicMapData.registerMagicMapData((Level)Minecraft.m_91087_().f_91073_, mapdata, s);
                    }
                    message.inner.m_132437_((MapItemSavedData)mapdata);
                    mapdata.deserializeFeatures(message.featureData);
                    final Map<String, MapDecoration> saveVanilla = new LinkedHashMap<String, MapDecoration>(mapdata.f_77894_);
                    mapdata.f_77894_.clear();
                    for (final TFMagicMapData.TFMapDecoration tfDecor : mapdata.tfDecorations) {
                        mapdata.f_77894_.put(tfDecor.toString(), tfDecor);
                    }
                    mapdata.f_77894_.putAll(saveVanilla);
                    mapitemrenderer.m_168765_(message.inner.m_132445_(), (MapItemSavedData)mapdata);
                }
            });
            return true;
        }
    }
}
