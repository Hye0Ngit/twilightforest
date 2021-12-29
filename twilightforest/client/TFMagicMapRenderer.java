// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Iterator;
import net.minecraft.world.storage.MapCoord;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.TFMagicMapData;
import net.minecraft.world.storage.MapData;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.IItemRenderer;

public class TFMagicMapRenderer implements IItemRenderer
{
    private int[] intArray;
    private int bufferedImage;
    private GameSettings gameSettings;
    private FontRenderer fontRenderer;
    
    public TFMagicMapRenderer(final FontRenderer par1FontRenderer, final GameSettings par2GameSettings, final RenderEngine par3RenderEngine) {
        this.intArray = new int[16384];
        this.gameSettings = par2GameSettings;
        this.fontRenderer = par1FontRenderer;
        this.bufferedImage = par3RenderEngine.func_78353_a(new BufferedImage(128, 128, 2));
        for (int var4 = 0; var4 < 16384; ++var4) {
            this.intArray[var4] = 0;
        }
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return item.field_77993_c == TFItems.magicMap.field_77779_bT && type == IItemRenderer.ItemRenderType.FIRST_PERSON_MAP;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        final EntityPlayer player = (EntityPlayer)data[0];
        final RenderEngine renderEngine = (RenderEngine)data[1];
        final MapData mapData = (MapData)data[2];
        if (mapData != null) {
            this.renderMap(player, renderEngine, mapData);
        }
    }
    
    public void renderMap(final EntityPlayer par1EntityPlayer, final RenderEngine par2RenderEngine, final MapData par3MapData) {
        final TFMagicMapData magicMapData = (TFMagicMapData)par3MapData;
        for (int i = 0; i < 16384; ++i) {
            final int colorByte = par3MapData.field_76198_e[i] & 0xFF;
            if (colorByte == 0) {
                this.intArray[i] = (i + i / 128 & 0x1) * 8 + 16 << 24;
            }
            else {
                final int biomeID = colorByte - 1;
                final BiomeGenBase biome = BiomeGenBase.field_76773_a[biomeID];
                if (biome != null) {
                    this.intArray[i] = (0xFF000000 | biome.field_76790_z);
                }
            }
        }
        par2RenderEngine.func_78349_a(this.intArray, 128, 128, this.bufferedImage);
        final byte var15 = 0;
        final byte var16 = 0;
        final Tessellator tesselator = Tessellator.field_78398_a;
        final float var17 = 0.0f;
        GL11.glBindTexture(3553, this.bufferedImage);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glDisable(3008);
        tesselator.func_78382_b();
        tesselator.func_78374_a((double)(var15 + 0 + var17), (double)(var16 + 128 - var17), -0.009999999776482582, 0.0, 1.0);
        tesselator.func_78374_a((double)(var15 + 128 - var17), (double)(var16 + 128 - var17), -0.009999999776482582, 1.0, 1.0);
        tesselator.func_78374_a((double)(var15 + 128 - var17), (double)(var16 + 0 + var17), -0.009999999776482582, 1.0, 0.0);
        tesselator.func_78374_a((double)(var15 + 0 + var17), (double)(var16 + 0 + var17), -0.009999999776482582, 0.0, 0.0);
        tesselator.func_78381_a();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        par2RenderEngine.func_98185_a();
        par2RenderEngine.func_98187_b("/misc/mapicons.png");
        for (final MapCoord mapCoord : par3MapData.field_76203_h.values()) {
            GL11.glPushMatrix();
            GL11.glTranslatef(var15 + mapCoord.field_76214_b / 2.0f + 64.0f, var16 + mapCoord.field_76215_c / 2.0f + 64.0f, -0.04f);
            GL11.glRotatef(mapCoord.field_76212_d * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            final float var18 = (mapCoord.field_76216_a % 4 + 0) / 4.0f;
            final float var19 = (mapCoord.field_76216_a / 4 + 0) / 4.0f;
            final float var20 = (mapCoord.field_76216_a % 4 + 1) / 4.0f;
            final float var21 = (mapCoord.field_76216_a / 4 + 1) / 4.0f;
            tesselator.func_78382_b();
            tesselator.func_78374_a(-1.0, 1.0, 0.0, (double)var18, (double)var19);
            tesselator.func_78374_a(1.0, 1.0, 0.0, (double)var20, (double)var19);
            tesselator.func_78374_a(1.0, -1.0, 0.0, (double)var20, (double)var21);
            tesselator.func_78374_a(-1.0, -1.0, 0.0, (double)var18, (double)var21);
            tesselator.func_78381_a();
            GL11.glPopMatrix();
        }
        par2RenderEngine.func_98185_a();
        par2RenderEngine.func_98187_b("/mods/twilightforest/textures/gui/mapicons.png");
        for (final MapCoord mapCoord : magicMapData.featuresVisibleOnMap) {
            GL11.glPushMatrix();
            GL11.glTranslatef(var15 + mapCoord.field_76214_b / 2.0f + 64.0f, var16 + mapCoord.field_76215_c / 2.0f + 64.0f, -0.02f);
            GL11.glRotatef(mapCoord.field_76212_d * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            final float var18 = (mapCoord.field_76216_a % 8 + 0) / 8.0f;
            final float var19 = (mapCoord.field_76216_a / 8 + 0) / 8.0f;
            final float var20 = (mapCoord.field_76216_a % 8 + 1) / 8.0f;
            final float var21 = (mapCoord.field_76216_a / 8 + 1) / 8.0f;
            tesselator.func_78382_b();
            tesselator.func_78374_a(-1.0, 1.0, 0.0, (double)var18, (double)var19);
            tesselator.func_78374_a(1.0, 1.0, 0.0, (double)var20, (double)var19);
            tesselator.func_78374_a(1.0, -1.0, 0.0, (double)var20, (double)var21);
            tesselator.func_78374_a(-1.0, -1.0, 0.0, (double)var18, (double)var21);
            tesselator.func_78381_a();
            GL11.glPopMatrix();
        }
    }
}
