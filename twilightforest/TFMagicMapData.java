// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class TFMagicMapData extends ahn
{
    private static final int FEATURE_DATA_BYTE = 18;
    public List featuresVisibleOnMap;
    private byte[] lastPlayerByteData;
    
    public TFMagicMapData(final String par1Str) {
        super(par1Str);
        this.featuresVisibleOnMap = new ArrayList();
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        final byte[] featureStorage = par1NBTTagCompound.j("features");
        if (featureStorage.length > 0) {
            this.loadDataFromByteArray(featureStorage);
        }
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.featuresVisibleOnMap.size() > 0) {
            final byte[] featureStorage = this.makeFeatureStorageArray();
            par1NBTTagCompound.a("features", featureStorage);
        }
    }
    
    public void addFeatureToMap(final TFFeature feature, final int x, final int z) {
        final float relativeX = (float)(x - (double)this.a) / (1 << this.d);
        final float relativeZ = (float)(z - (double)this.b) / (1 << this.d);
        final byte rangeX = 64;
        final byte rangeY = 64;
        if (relativeX >= -rangeX && relativeZ >= -rangeY && relativeX <= rangeX && relativeZ <= rangeY) {
            final byte markerIcon = (byte)feature.featureID;
            final byte mapX = (byte)(relativeX * 2.0f + 0.5);
            final byte mapZ = (byte)(relativeZ * 2.0f + 0.5);
            final byte mapRotation = 8;
            boolean featureFound = false;
            for (final ahp existingCoord : this.featuresVisibleOnMap) {
                if (existingCoord.b == mapX && existingCoord.c == mapZ) {
                    featureFound = true;
                }
            }
            if (!featureFound) {
                this.featuresVisibleOnMap.add(new ahp((ahn)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
    }
    
    public void loadDataFromByteArray(final byte[] par1ArrayOfByte) {
        if (par1ArrayOfByte[0] == 16) {
            par1ArrayOfByte[0] = 0;
            super.a(par1ArrayOfByte);
        }
        else if (par1ArrayOfByte[0] == 17) {
            par1ArrayOfByte[0] = 1;
            super.a(par1ArrayOfByte);
        }
        else if (par1ArrayOfByte[0] == 18) {
            this.featuresVisibleOnMap.clear();
            for (int i = 0; i < (par1ArrayOfByte.length - 1) / 3; ++i) {
                final byte markerIcon = par1ArrayOfByte[i * 3 + 1];
                final byte mapX = par1ArrayOfByte[i * 3 + 2];
                final byte mapZ = par1ArrayOfByte[i * 3 + 3];
                final byte mapRotation = 8;
                this.featuresVisibleOnMap.add(new ahp((ahn)this, markerIcon, mapX, mapZ, mapRotation));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final byte[] par1ArrayOfByte) {
        if (par1ArrayOfByte[0] == 18) {
            this.featuresVisibleOnMap.clear();
            for (int i = 0; i < (par1ArrayOfByte.length - 1) / 3; ++i) {
                final byte markerIcon = par1ArrayOfByte[i * 3 + 1];
                final byte mapX = par1ArrayOfByte[i * 3 + 2];
                final byte mapZ = par1ArrayOfByte[i * 3 + 3];
                final byte mapRotation = 8;
                this.featuresVisibleOnMap.add(new ahp((ahn)this, markerIcon, mapX, mapZ, mapRotation));
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
            final ahp featureCoord = this.featuresVisibleOnMap.get(i);
            storage[i * 3 + 1] = featureCoord.a;
            storage[i * 3 + 2] = featureCoord.b;
            storage[i * 3 + 3] = featureCoord.c;
        }
        return storage;
    }
}
