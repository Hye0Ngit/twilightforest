// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.renderer.TFSkyRenderer;
import net.minecraft.util.math.vector.Vector3d;
import javax.annotation.Nullable;
import net.minecraftforge.client.IWeatherRenderHandler;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraft.client.world.DimensionRenderInfo;

public class TwilightForestRenderInfo extends DimensionRenderInfo
{
    private ISkyRenderHandler skyRenderer;
    private IWeatherRenderHandler weatherRenderer;
    
    public TwilightForestRenderInfo(final float cloudHeight, final boolean placebo, final DimensionRenderInfo.FogType fogType, final boolean brightenLightMap, final boolean entityLightingBottomsLit) {
        super(cloudHeight, placebo, fogType, brightenLightMap, entityLightingBottomsLit);
    }
    
    @Nullable
    public float[] func_230492_a_(final float daycycle, final float partialTicks) {
        return null;
    }
    
    public Vector3d func_230494_a_(final Vector3d biomeFogColor, final float daylight) {
        return biomeFogColor.func_216372_d((double)(daylight * 0.94f + 0.06f), (double)(daylight * 0.94f + 0.06f), (double)(daylight * 0.91f + 0.09f));
    }
    
    public boolean func_230493_a_(final int x, final int y) {
        return false;
    }
    
    @Nullable
    public ISkyRenderHandler getSkyRenderHandler() {
        if (this.skyRenderer == null) {
            this.skyRenderer = (ISkyRenderHandler)new TFSkyRenderer();
        }
        return this.skyRenderer;
    }
    
    @Nullable
    public IWeatherRenderHandler getWeatherRenderHandler() {
        if (this.weatherRenderer == null) {
            this.weatherRenderer = (IWeatherRenderHandler)new TFWeatherRenderer();
        }
        return this.weatherRenderer;
    }
}
