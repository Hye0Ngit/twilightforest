// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Objects;
import java.util.Optional;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.util.Mth;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", value = { Dist.CLIENT })
public class FogHandler
{
    private static final float[] spoopColors;
    private static float spoopColor;
    private static float spoopFog;
    
    @SubscribeEvent
    public static void fogColors(final EntityViewRenderEvent.FogColors event) {
        final boolean flag = isSpooky();
        if (flag || FogHandler.spoopColor > 0.0f) {
            final float[] realColors = { event.getRed(), event.getGreen(), event.getBlue() };
            final float[] lerpColors = { 0.50980395f, 0.4509804f, 0.5686275f };
            for (int i = 0; i < 3; ++i) {
                final float real = realColors[i];
                final float spoop = lerpColors[i];
                final boolean inverse = real > spoop;
                FogHandler.spoopColors[i] = ((real == spoop) ? spoop : Mth.m_144920_(inverse ? spoop : real, inverse ? real : spoop, FogHandler.spoopColor));
            }
            final float shift = (float)(0.009999999776482582 * event.getRenderPartialTicks());
            if (flag) {
                FogHandler.spoopColor += shift;
            }
            else {
                FogHandler.spoopColor -= shift;
            }
            FogHandler.spoopColor = Mth.m_14036_(FogHandler.spoopColor, 0.0f, 1.0f);
            event.setRed(FogHandler.spoopColors[0]);
            event.setGreen(FogHandler.spoopColors[1]);
            event.setBlue(FogHandler.spoopColors[2]);
        }
    }
    
    @SubscribeEvent
    public static void fog(final EntityViewRenderEvent.RenderFogEvent event) {
        final boolean flag = isSpooky();
        if (flag || FogHandler.spoopFog < 1.0f) {
            float f = 48.0f;
            f = ((f >= event.getFarPlaneDistance()) ? event.getFarPlaneDistance() : Mth.m_144920_(f, event.getFarPlaneDistance(), FogHandler.spoopFog));
            final float shift = (float)(0.0010000000474974513 * event.getRenderPartialTicks());
            if (flag) {
                FogHandler.spoopFog -= shift;
            }
            else {
                FogHandler.spoopFog += shift;
            }
            FogHandler.spoopFog = Mth.m_14036_(FogHandler.spoopFog, 0.0f, 1.0f);
            if (event.getType() == FogRenderer.FogMode.FOG_SKY) {
                RenderSystem.m_157445_(0.0f);
                RenderSystem.m_157443_(f);
            }
            else {
                RenderSystem.m_157445_(f * 0.75f);
                RenderSystem.m_157443_(f);
            }
        }
    }
    
    private static boolean isSpooky() {
        return Minecraft.m_91087_().f_91073_ != null && Minecraft.m_91087_().f_91074_ != null && Objects.equals(Minecraft.m_91087_().f_91073_.m_45837_(Minecraft.m_91087_().f_91074_.m_142538_()), Optional.of(BiomeKeys.SPOOKY_FOREST));
    }
    
    static {
        spoopColors = new float[3];
        FogHandler.spoopColor = 0.0f;
        FogHandler.spoopFog = 1.0f;
    }
}
