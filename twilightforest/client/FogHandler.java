// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.biomes.TFBiomes;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GLContext;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", value = { Side.CLIENT })
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
            GlStateManager.func_187430_a(GlStateManager.FogMode.LINEAR);
            if (event.getFogMode() == -1) {
                GlStateManager.func_179102_b(0.0f);
                GlStateManager.func_179153_c(f);
            }
            else {
                GlStateManager.func_179102_b(f * 0.75f);
                GlStateManager.func_179153_c(f);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GlStateManager.func_187412_c(34138, 34139);
            }
        }
    }
    
    private static boolean isSpooky() {
        return Minecraft.func_71410_x().field_71441_e != null && Minecraft.func_71410_x().field_71439_g != null && Minecraft.func_71410_x().field_71441_e.func_180494_b(Minecraft.func_71410_x().field_71439_g.func_180425_c()) == TFBiomes.spookyForest;
    }
    
    static {
        spoopColors = new float[3];
        FogHandler.spoopColor = 0.0f;
        FogHandler.spoopFog = 1.0f;
    }
}
