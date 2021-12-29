// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Collection;
import twilightforest.world.TFWorldChunkManager;
import net.minecraft.world.World;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import java.util.ArrayList;
import net.minecraft.world.storage.MapCoord;
import java.util.List;
import net.minecraft.world.storage.MapData;

public class TFMagicMapData extends MapData
{
    private static final int FEATURE_DATA_BYTE = 18;
    public List<MapCoord> featuresVisibleOnMap;
    
    public TFMagicMapData(final String par1Str) {
        super(par1Str);
        this.featuresVisibleOnMap = new ArrayList<MapCoord>();
    }
    
    public void func_76184_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_76184_a(par1NBTTagCompound);
        final byte[] featureStorage = par1NBTTagCompound.func_74770_j("features");
        if (featureStorage.length > 0) {
            this.func_76192_a(featureStorage);
        }
    }
    
    public void func_76187_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_76187_b(par1NBTTagCompound);
        if (this.featuresVisibleOnMap.size() > 0) {
            final byte[] featureStorage = this.makeFeatureStorageArray();
            par1NBTTagCompound.func_74773_a("features", featureStorage);
        }
    }
    
    public void addFeatureToMap(final TFFeature feature, final int x, final int z) {
        final byte relativeX = (byte)(x - this.field_76201_a >> this.field_76197_d);
        final byte relativeZ = (byte)(z - this.field_76199_b >> this.field_76197_d);
        final byte rangeX = 64;
        final byte rangeY = 64;
        if (relativeX >= -rangeX && relativeZ >= -rangeY && relativeX <= rangeX && relativeZ <= rangeY) {
            final byte markerIcon = (byte)feature.featureID;
            final byte mapX = (byte)(relativeX << 1);
            final byte mapZ = (byte)(relativeZ << 1);
            final byte mapRotation = 8;
            boolean featureFound = false;
            for (final MapCoord existingCoord : this.featuresVisibleOnMap) {
                if (existingCoord.field_76214_b == mapX && existingCoord.field_76215_c == mapZ) {
                    featureFound = true;
                }
            }
            if (!featureFound) {
                this.featuresVisibleOnMap.add(new MapCoord((MapData)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
    }
    
    public void checkExistingFeatures(final World world) {
        ArrayList toRemove = null;
        for (final MapCoord coord : this.featuresVisibleOnMap) {
            final int worldX = (coord.field_76214_b << this.field_76197_d - 1) + this.field_76201_a;
            final int worldZ = (coord.field_76215_c << this.field_76197_d - 1) + this.field_76199_b;
            if (world != null && world.func_72959_q() instanceof TFWorldChunkManager) {
                final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.func_72959_q();
                coord.field_76216_a = (byte)tfManager.getFeatureID(worldX, worldZ, world);
                if (coord.field_76216_a != 0) {
                    continue;
                }
                if (toRemove == null) {
                    toRemove = new ArrayList();
                }
                toRemove.add(coord);
            }
        }
        if (toRemove != null) {
            this.featuresVisibleOnMap.removeAll(toRemove);
        }
    }
    
    public void func_76192_a(final byte[] par1ArrayOfByte) {
        if (par1ArrayOfByte[0] == 18) {
            this.featuresVisibleOnMap.clear();
            for (int i = 0; i < (par1ArrayOfByte.length - 1) / 3; ++i) {
                final byte markerIcon = par1ArrayOfByte[i * 3 + 1];
                final byte mapX = par1ArrayOfByte[i * 3 + 2];
                final byte mapZ = par1ArrayOfByte[i * 3 + 3];
                final byte mapRotation = 8;
                this.featuresVisibleOnMap.add(new MapCoord((MapData)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
        else {
            super.func_76192_a(par1ArrayOfByte);
        }
    }
    
    public byte[] makeFeatureStorageArray() {
        final byte[] storage = new byte[this.featuresVisibleOnMap.size() * 3 + 1];
        storage[0] = 18;
        for (int i = 0; i < this.featuresVisibleOnMap.size(); ++i) {
            final MapCoord featureCoord = this.featuresVisibleOnMap.get(i);
            storage[i * 3 + 1] = featureCoord.field_76216_a;
            storage[i * 3 + 2] = featureCoord.field_76214_b;
            storage[i * 3 + 3] = featureCoord.field_76215_c;
        }
        return storage;
    }
}
