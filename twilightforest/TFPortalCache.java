// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.io.Serializable;

public class TFPortalCache implements Serializable
{
    private transient boolean hasChanged;
    private TFPortalCache instance;
    
    public TFPortalCache() {
        this.hasChanged = false;
        this.instance = this;
    }
    
    public TFPortalCache getInstance() {
        return this.instance;
    }
    
    public void registerTFPortal(final uh location, final int dimension) {
    }
    
    public uh getPortalNearest(final uh location, final int dimension, final int searchRadius) {
        return location;
    }
}
