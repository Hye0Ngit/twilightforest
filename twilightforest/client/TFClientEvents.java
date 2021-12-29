// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import twilightforest.TwilightForestMod;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.util.ResourceLocation;

public class TFClientEvents
{
    protected static final ResourceLocation dangerTexPath;
    private static float dangerBrightness;
    
    @SubscribeEvent
    public void renderOverlay(final RenderGameOverlayEvent.Pre event) {
        final boolean dangerous = TwilightForestMod.proxy.isDangerOverlayShown();
        if (event.type == RenderGameOverlayEvent.ElementType.HELMET) {
            this.renderDangerOverlay(dangerous, event.resolution.func_78326_a(), event.resolution.func_78328_b());
        }
    }
    
    private void renderDangerOverlay(final boolean dangerous, final int width, final int height) {
        if (dangerous && TFClientEvents.dangerBrightness < 1.0f) {
            TFClientEvents.dangerBrightness += 0.01f;
        }
        if (!dangerous && TFClientEvents.dangerBrightness > 0.0f) {
            TFClientEvents.dangerBrightness -= 0.01f;
        }
        if (TFClientEvents.dangerBrightness > 0.0f) {
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, TFClientEvents.dangerBrightness);
            GL11.glDisable(3008);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(TFClientEvents.dangerTexPath);
            final Tessellator tessellator = Tessellator.field_78398_a;
            tessellator.func_78382_b();
            tessellator.func_78374_a(0.0, (double)height, -90.0, 0.0, 1.0);
            tessellator.func_78374_a((double)width, (double)height, -90.0, 1.0, 1.0);
            tessellator.func_78374_a((double)width, 0.0, -90.0, 1.0, 0.0);
            tessellator.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
            tessellator.func_78381_a();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3008);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    static {
        dangerTexPath = new ResourceLocation("twilightforest:textures/gui/glow_overlay.png");
        TFClientEvents.dangerBrightness = 0.0f;
    }
}
