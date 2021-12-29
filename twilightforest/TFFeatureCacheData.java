// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.io.Serializable;

public class TFFeatureCacheData implements Serializable
{
    public int xPosition;
    public int zPosition;
    public byte featureID;
    public byte featureStatus;
    
    public TFFeatureCacheData(final TFFeatureCache par1FeatureCache, final int chunkX, final int chunkZ) {
        this.xPosition = chunkX;
        this.zPosition = chunkZ;
    }
}
