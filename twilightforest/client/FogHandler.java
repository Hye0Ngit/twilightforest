// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Objects;
import java.util.Optional;
import twilightforest.worldgen.biomes.BiomeKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FogRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.util.math.MathHelper;
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
            final float[] lerpColors = { 0.41568628f, 0.23529412f, 0.6f };
            for (int i = 0; i < 3; ++i) {
                final float real = realColors[i];
                final float spoop = lerpColors[i];
                final boolean inverse = real > spoop;
                FogHandler.spoopColors[i] = ((real == spoop) ? spoop : ((float)MathHelper.func_151238_b(inverse ? ((double)spoop) : ((double)real), inverse ? ((double)real) : ((double)spoop), (double)FogHandler.spoopColor)));
            }
            final float shift = (float)(0.009999999776482582 * event.getRenderPartialTicks());
            if (flag) {
                FogHandler.spoopColor += shift;
            }
            else {
                FogHandler.spoopColor -= shift;
            }
            FogHandler.spoopColor = MathHelper.func_76131_a(FogHandler.spoopColor, 0.0f, 1.0f);
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
            f = ((f >= event.getFarPlaneDistance()) ? event.getFarPlaneDistance() : ((float)MathHelper.func_151238_b((double)f, (double)event.getFarPlaneDistance(), (double)FogHandler.spoopFog)));
            final float shift = (float)(0.0010000000474974513 * event.getRenderPartialTicks());
            if (flag) {
                FogHandler.spoopFog -= shift;
            }
            else {
                FogHandler.spoopFog += shift;
            }
            FogHandler.spoopFog = MathHelper.func_76131_a(FogHandler.spoopFog, 0.0f, 1.0f);
            RenderSystem.fogMode(GlStateManager.FogMode.LINEAR);
            if (event.getType() == FogRenderer.FogType.FOG_SKY) {
                RenderSystem.fogStart(0.0f);
                RenderSystem.fogEnd(f);
            }
            else {
                RenderSystem.fogStart(f * 0.75f);
                RenderSystem.fogEnd(f);
            }
            RenderSystem.setupNvFogDistance();
        }
    }
    
    private static boolean isSpooky() {
        return Minecraft.func_71410_x().field_71441_e != null && Minecraft.func_71410_x().field_71439_g != null && Objects.equals(Minecraft.func_71410_x().field_71441_e.func_242406_i(Minecraft.func_71410_x().field_71439_g.func_233580_cy_()), Optional.of(BiomeKeys.SPOOKY_FOREST));
    }
    
    static {
        spoopColors = new float[3];
        FogHandler.spoopColor = 0.0f;
        FogHandler.spoopFog = 1.0f;
    }
}
