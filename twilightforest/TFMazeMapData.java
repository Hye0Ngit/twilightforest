// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.HashMap;
import net.minecraft.world.level.saveddata.SavedData;
import javax.annotation.Nullable;
import java.util.function.Function;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceKey;
import java.util.Map;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

public class TFMazeMapData extends MapItemSavedData
{
    private static final Map<String, TFMazeMapData> CLIENT_DATA;
    public int yCenter;
    
    public TFMazeMapData(final int x, final int z, final byte scale, final boolean trackpos, final boolean unlimited, final boolean locked, final ResourceKey<Level> dim) {
        super(x, z, scale, trackpos, unlimited, locked, (ResourceKey)dim);
    }
    
    public static TFMazeMapData load(final CompoundTag nbt) {
        final MapItemSavedData data = MapItemSavedData.m_164807_(nbt);
        final boolean trackingPosition = !nbt.m_128425_("trackingPosition", 1) || nbt.m_128471_("trackingPosition");
        final boolean unlimitedTracking = nbt.m_128471_("unlimitedTracking");
        final boolean locked = nbt.m_128471_("locked");
        final TFMazeMapData tfdata = new TFMazeMapData(data.f_77885_, data.f_77886_, data.f_77890_, trackingPosition, unlimitedTracking, locked, (ResourceKey<Level>)data.f_77887_);
        tfdata.f_77891_ = data.f_77891_;
        tfdata.f_77897_.putAll(data.f_77897_);
        tfdata.f_77894_.putAll(data.f_77894_);
        tfdata.f_77898_.putAll(data.f_77898_);
        tfdata.f_181308_ = data.f_181308_;
        tfdata.yCenter = nbt.m_128451_("yCenter");
        return tfdata;
    }
    
    public CompoundTag m_7176_(final CompoundTag nbt) {
        final CompoundTag ret = super.m_7176_(nbt);
        ret.m_128405_("yCenter", this.yCenter);
        return ret;
    }
    
    public void calculateMapCenter(final Level world, final int x, final int y, final int z) {
        this.yCenter = y;
        if (world instanceof ServerLevel && TFGenerationSettings.usesTwilightChunkGenerator((ServerLevel)world) && TFFeature.getFeatureForRegion(x >> 4, z >> 4, (WorldGenLevel)world) == TFFeature.LABYRINTH) {
            final BlockPos mc = TFFeature.getNearestCenterXYZ(x >> 4, z >> 4);
            this.f_77885_ = mc.m_123341_();
            this.f_77886_ = mc.m_123343_();
        }
    }
    
    @Nullable
    public static TFMazeMapData getMazeMapData(final Level world, final String name) {
        if (world.f_46443_) {
            return TFMazeMapData.CLIENT_DATA.get(name);
        }
        return (TFMazeMapData)world.m_142572_().m_129783_().m_8895_().m_164858_((Function)TFMazeMapData::load, name);
    }
    
    public static void registerMazeMapData(final Level world, final TFMazeMapData data, final String id) {
        if (world.f_46443_) {
            TFMazeMapData.CLIENT_DATA.put(id, data);
        }
        else {
            world.m_142572_().m_129783_().m_8895_().m_164855_(id, (SavedData)data);
        }
    }
    
    static {
        CLIENT_DATA = new HashMap<String, TFMazeMapData>();
    }
}
