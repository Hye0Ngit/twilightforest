// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.renderer.TFSkyRenderer;
import net.minecraft.world.phys.Vec3;
import javax.annotation.Nullable;
import net.minecraftforge.client.IWeatherRenderHandler;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraft.client.renderer.DimensionSpecialEffects;

public class TwilightForestRenderInfo extends DimensionSpecialEffects
{
    private ISkyRenderHandler skyRenderer;
    private IWeatherRenderHandler weatherRenderer;
    
    public TwilightForestRenderInfo(final float cloudHeight, final boolean placebo, final DimensionSpecialEffects.SkyType fogType, final boolean brightenLightMap, final boolean entityLightingBottomsLit) {
        super(cloudHeight, placebo, fogType, brightenLightMap, entityLightingBottomsLit);
    }
    
    @Nullable
    public float[] m_7518_(final float daycycle, final float partialTicks) {
        return null;
    }
    
    public Vec3 m_5927_(final Vec3 biomeFogColor, final float daylight) {
        return biomeFogColor.m_82542_((double)(daylight * 0.94f + 0.06f), (double)(daylight * 0.94f + 0.06f), (double)(daylight * 0.91f + 0.09f));
    }
    
    public boolean m_5781_(final int x, final int y) {
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
