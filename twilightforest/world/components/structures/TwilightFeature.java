// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import twilightforest.world.registration.TFFeature;

@Deprecated
public interface TwilightFeature
{
    @Deprecated
    default void setFeature(final TFFeature type) {
    }
    
    @Deprecated
    TFFeature getFeatureType();
}
