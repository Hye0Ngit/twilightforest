import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFMagicMapData extends km
{
    public List featuresVisibleOnMap;
    private byte[] lastPlayerByteData;
    
    public TFMagicMapData(final String par1Str) {
        super(par1Str);
        this.featuresVisibleOnMap = new ArrayList();
    }
    
    public void a(final ph par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        final byte[] featureStorage = par1NBTTagCompound.k("features");
        if (featureStorage.length > 0) {
            this.loadDataFromByteArray(featureStorage);
        }
    }
    
    public void b(final ph par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.featuresVisibleOnMap.size() > 0) {
            final byte[] featureStorage = this.makeFeatureStorageArray();
            par1NBTTagCompound.a("features", featureStorage);
        }
    }
    
    public void addFeatureToMap(final TFFeature feature, final int x, final int z) {
        final float relativeX = (float)(x - (double)this.b) / (1 << this.e);
        final float relativeZ = (float)(z - (double)this.c) / (1 << this.e);
        final byte rangeX = 64;
        final byte rangeY = 64;
        if (relativeX >= -rangeX && relativeZ >= -rangeY && relativeX <= rangeX && relativeZ <= rangeY) {
            final byte markerIcon = (byte)feature.featureID;
            final byte mapX = (byte)(relativeX * 2.0f + 0.5);
            final byte mapZ = (byte)(relativeZ * 2.0f + 0.5);
            final byte mapRotation = 8;
            boolean featureFound = false;
            for (final bi existingCoord : this.featuresVisibleOnMap) {
                if (existingCoord.b == mapX && existingCoord.c == mapZ) {
                    featureFound = true;
                }
            }
            if (!featureFound) {
                this.featuresVisibleOnMap.add(new bi((km)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
    }
    
    public void loadDataFromByteArray(final byte[] par1ArrayOfByte) {
        if (par1ArrayOfByte[0] == 18) {
            this.featuresVisibleOnMap.clear();
            for (int i = 0; i < (par1ArrayOfByte.length - 1) / 3; ++i) {
                final byte markerIcon = par1ArrayOfByte[i * 3 + 1];
                final byte mapX = par1ArrayOfByte[i * 3 + 2];
                final byte mapZ = par1ArrayOfByte[i * 3 + 3];
                final byte mapRotation = 8;
                this.featuresVisibleOnMap.add(new bi((km)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
    }
    
    public byte[] makeFeatureStorageArray() {
        final byte[] storage = new byte[this.featuresVisibleOnMap.size() * 3 + 1];
        storage[0] = 18;
        for (int i = 0; i < this.featuresVisibleOnMap.size(); ++i) {
            final bi featureCoord = this.featuresVisibleOnMap.get(i);
            storage[i * 3 + 1] = featureCoord.a;
            storage[i * 3 + 2] = featureCoord.b;
            storage[i * 3 + 3] = featureCoord.c;
        }
        return storage;
    }
}
