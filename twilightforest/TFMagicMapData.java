// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Collection;
import twilightforest.world.TFWorldChunkManager;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class TFMagicMapData extends alf
{
    private static final int FEATURE_DATA_BYTE = 18;
    public List<alh> featuresVisibleOnMap;
    
    public TFMagicMapData(final String par1Str) {
        super(par1Str);
        this.featuresVisibleOnMap = new ArrayList<alh>();
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        final byte[] featureStorage = par1NBTTagCompound.j("features");
        if (featureStorage.length > 0) {
            this.a(featureStorage);
        }
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.featuresVisibleOnMap.size() > 0) {
            final byte[] featureStorage = this.makeFeatureStorageArray();
            par1NBTTagCompound.a("features", featureStorage);
        }
    }
    
    public void addFeatureToMap(final TFFeature feature, final int x, final int z) {
        final byte relativeX = (byte)(x - this.a >> this.d);
        final byte relativeZ = (byte)(z - this.b >> this.d);
        final byte rangeX = 64;
        final byte rangeY = 64;
        if (relativeX >= -rangeX && relativeZ >= -rangeY && relativeX <= rangeX && relativeZ <= rangeY) {
            final byte markerIcon = (byte)feature.featureID;
            final byte mapX = (byte)(relativeX << 1);
            final byte mapZ = (byte)(relativeZ << 1);
            final byte mapRotation = 8;
            boolean featureFound = false;
            for (final alh existingCoord : this.featuresVisibleOnMap) {
                if (existingCoord.b == mapX && existingCoord.c == mapZ) {
                    featureFound = true;
                }
            }
            if (!featureFound) {
                this.featuresVisibleOnMap.add(new alh((alf)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
    }
    
    public void checkExistingFeatures(final abv world) {
        ArrayList toRemove = null;
        for (final alh coord : this.featuresVisibleOnMap) {
            final int worldX = (coord.b << this.d - 1) + this.a;
            final int worldZ = (coord.c << this.d - 1) + this.b;
            if (world != null && world.u() instanceof TFWorldChunkManager) {
                final TFWorldChunkManager tfManager = (TFWorldChunkManager)world.u();
                coord.a = (byte)tfManager.getFeatureID(worldX, worldZ, world);
                if (coord.a != 0) {
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
    
    public void a(final byte[] par1ArrayOfByte) {
        if (par1ArrayOfByte[0] == 18) {
            this.featuresVisibleOnMap.clear();
            for (int i = 0; i < (par1ArrayOfByte.length - 1) / 3; ++i) {
                final byte markerIcon = par1ArrayOfByte[i * 3 + 1];
                final byte mapX = par1ArrayOfByte[i * 3 + 2];
                final byte mapZ = par1ArrayOfByte[i * 3 + 3];
                final byte mapRotation = 8;
                this.featuresVisibleOnMap.add(new alh((alf)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
        else {
            super.a(par1ArrayOfByte);
        }
    }
    
    public byte[] makeFeatureStorageArray() {
        final byte[] storage = new byte[this.featuresVisibleOnMap.size() * 3 + 1];
        storage[0] = 18;
        for (int i = 0; i < this.featuresVisibleOnMap.size(); ++i) {
            final alh featureCoord = this.featuresVisibleOnMap.get(i);
            storage[i * 3 + 1] = featureCoord.a;
            storage[i * 3 + 2] = featureCoord.b;
            storage[i * 3 + 3] = featureCoord.c;
        }
        return storage;
    }
}
