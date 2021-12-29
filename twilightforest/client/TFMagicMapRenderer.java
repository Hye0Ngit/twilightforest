// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Iterator;
import org.lwjgl.opengl.GL11;
import twilightforest.TFMagicMapData;
import twilightforest.item.TFItems;
import java.awt.image.BufferedImage;
import net.minecraftforge.client.IItemRenderer;

public class TFMagicMapRenderer implements IItemRenderer
{
    private int[] intArray;
    private int bufferedImage;
    private avs gameSettings;
    private awp fontRenderer;
    
    public TFMagicMapRenderer(final awp par1FontRenderer, final avs par2GameSettings, final bfy par3RenderEngine) {
        this.intArray = new int[16384];
        this.gameSettings = par2GameSettings;
        this.fontRenderer = par1FontRenderer;
        this.bufferedImage = par3RenderEngine.a(new BufferedImage(128, 128, 2));
        for (int var4 = 0; var4 < 16384; ++var4) {
            this.intArray[var4] = 0;
        }
    }
    
    public boolean handleRenderType(final wg item, final IItemRenderer.ItemRenderType type) {
        return item.c == TFItems.magicMap.cp && type == IItemRenderer.ItemRenderType.FIRST_PERSON_MAP;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final wg item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final wg item, final Object... data) {
        final sk player = (sk)data[0];
        final bfy renderEngine = (bfy)data[1];
        final ajf mapData = (ajf)data[2];
        if (mapData != null) {
            this.renderMap(player, renderEngine, mapData);
        }
    }
    
    public void renderMap(final sk par1EntityPlayer, final bfy par2RenderEngine, final ajf par3MapData) {
        final TFMagicMapData magicMapData = (TFMagicMapData)par3MapData;
        for (int i = 0; i < 16384; ++i) {
            final int colorByte = par3MapData.e[i] & 0xFF;
            if (colorByte == 0) {
                this.intArray[i] = (i + i / 128 & 0x1) * 8 + 16 << 24;
            }
            else {
                final int biomeID = colorByte - 1;
                final aap biome = aap.a[biomeID];
                if (biome != null) {
                    this.intArray[i] = (0xFF000000 | biome.z);
                }
            }
        }
        par2RenderEngine.a(this.intArray, 128, 128, this.bufferedImage);
        final byte var15 = 0;
        final byte var16 = 0;
        final bfx tesselator = bfx.a;
        final float var17 = 0.0f;
        GL11.glBindTexture(3553, this.bufferedImage);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glDisable(3008);
        tesselator.b();
        tesselator.a((double)(var15 + 0 + var17), (double)(var16 + 128 - var17), -0.009999999776482582, 0.0, 1.0);
        tesselator.a((double)(var15 + 128 - var17), (double)(var16 + 128 - var17), -0.009999999776482582, 1.0, 1.0);
        tesselator.a((double)(var15 + 128 - var17), (double)(var16 + 0 + var17), -0.009999999776482582, 1.0, 0.0);
        tesselator.a((double)(var15 + 0 + var17), (double)(var16 + 0 + var17), -0.009999999776482582, 0.0, 0.0);
        tesselator.a();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        par2RenderEngine.b("/misc/mapicons.png");
        for (final ajh mapCoord : par3MapData.g.values()) {
            GL11.glPushMatrix();
            GL11.glTranslatef(var15 + mapCoord.b / 2.0f + 64.0f, var16 + mapCoord.c / 2.0f + 64.0f, -0.04f);
            GL11.glRotatef(mapCoord.d * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            final float var18 = (mapCoord.a % 4 + 0) / 4.0f;
            final float var19 = (mapCoord.a / 4 + 0) / 4.0f;
            final float var20 = (mapCoord.a % 4 + 1) / 4.0f;
            final float var21 = (mapCoord.a / 4 + 1) / 4.0f;
            tesselator.b();
            tesselator.a(-1.0, 1.0, 0.0, (double)var18, (double)var19);
            tesselator.a(1.0, 1.0, 0.0, (double)var20, (double)var19);
            tesselator.a(1.0, -1.0, 0.0, (double)var20, (double)var21);
            tesselator.a(-1.0, -1.0, 0.0, (double)var18, (double)var21);
            tesselator.a();
            GL11.glPopMatrix();
        }
        par2RenderEngine.b("/mods/twilightforest/textures/gui/mapicons.png");
        for (final ajh mapCoord : magicMapData.featuresVisibleOnMap) {
            GL11.glPushMatrix();
            GL11.glTranslatef(var15 + mapCoord.b / 2.0f + 64.0f, var16 + mapCoord.c / 2.0f + 64.0f, -0.02f);
            GL11.glRotatef(mapCoord.d * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            final float var18 = (mapCoord.a % 8 + 0) / 8.0f;
            final float var19 = (mapCoord.a / 8 + 0) / 8.0f;
            final float var20 = (mapCoord.a % 8 + 1) / 8.0f;
            final float var21 = (mapCoord.a / 8 + 1) / 8.0f;
            tesselator.b();
            tesselator.a(-1.0, 1.0, 0.0, (double)var18, (double)var19);
            tesselator.a(1.0, 1.0, 0.0, (double)var20, (double)var19);
            tesselator.a(1.0, -1.0, 0.0, (double)var20, (double)var21);
            tesselator.a(-1.0, -1.0, 0.0, (double)var18, (double)var21);
            tesselator.a();
            GL11.glPopMatrix();
        }
    }
}
