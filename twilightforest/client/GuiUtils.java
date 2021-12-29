// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;

public class GuiUtils
{
    public static void drawModalRectWithCustomSizedTexture(final int x, final int y, final float z, final float u, final float v, final int width, final int height, final float textureWidth, final float textureHeight) {
        final float f = 1.0f / textureWidth;
        final float f2 = 1.0f / textureHeight;
        final Tessellator tessellator = Tessellator.func_178181_a();
        final BufferBuilder bufferbuilder = tessellator.func_178180_c();
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b((double)x, (double)(y + height), (double)z).func_187315_a((double)(u * f), (double)((v + height) * f2)).func_181675_d();
        bufferbuilder.func_181662_b((double)(x + width), (double)(y + height), (double)z).func_187315_a((double)((u + width) * f), (double)((v + height) * f2)).func_181675_d();
        bufferbuilder.func_181662_b((double)(x + width), (double)y, (double)z).func_187315_a((double)((u + width) * f), (double)(v * f2)).func_181675_d();
        bufferbuilder.func_181662_b((double)x, (double)y, (double)z).func_187315_a((double)(u * f), (double)(v * f2)).func_181675_d();
        tessellator.func_78381_a();
    }
}
