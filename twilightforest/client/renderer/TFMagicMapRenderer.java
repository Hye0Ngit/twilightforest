// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import java.util.Iterator;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.item.ItemTFMagicMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.renderer.RenderBlocks;
import twilightforest.TFMagicMapData;
import net.minecraft.world.storage.MapData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.entity.RenderItem;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class TFMagicMapRenderer implements IItemRenderer
{
    private static final ResourceLocation vanillaMapIcons;
    private static final ResourceLocation twilightMapIcons;
    private static final ResourceLocation mapBackgroundTextures;
    private int[] intArray;
    private DynamicTexture bufferedImage;
    private GameSettings gameSettings;
    private FontRenderer fontRenderer;
    private final ResourceLocation textureLoc;
    
    public TFMagicMapRenderer(final GameSettings par1GameSettings, final TextureManager par2TextureManager) {
        this.intArray = new int[16384];
        this.gameSettings = par1GameSettings;
        this.bufferedImage = new DynamicTexture(128, 128);
        this.textureLoc = par2TextureManager.func_110578_a("map", this.bufferedImage);
        this.intArray = this.bufferedImage.func_110565_c();
        for (int i = 0; i < this.intArray.length; ++i) {
            this.intArray[i] = 0;
        }
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return item.func_77973_b() == TFItems.magicMap && (type == IItemRenderer.ItemRenderType.FIRST_PERSON_MAP || (RenderItem.field_82407_g && type == IItemRenderer.ItemRenderType.ENTITY));
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        if (type == IItemRenderer.ItemRenderType.FIRST_PERSON_MAP) {
            final EntityPlayer player = (EntityPlayer)data[0];
            final TextureManager renderEngine = (TextureManager)data[1];
            final MapData mapData = (MapData)data[2];
            if (mapData != null && mapData instanceof TFMagicMapData) {
                this.renderMap(player, renderEngine, (TFMagicMapData)mapData);
            }
        }
        else if (RenderItem.field_82407_g) {
            final RenderBlocks renderBlocks = (RenderBlocks)data[0];
            final EntityItem entity = (EntityItem)data[1];
            final TFMagicMapData mapData2 = ((ItemTFMagicMap)TFItems.magicMap).getMapData(item, entity.field_70170_p);
            if (mapData2 != null) {
                this.renderMapInFrame(item, RenderManager.field_78727_a, mapData2);
            }
        }
    }
    
    public void renderMap(final EntityPlayer par1EntityPlayer, final TextureManager par2TextureManager, final TFMagicMapData par3MapData) {
        final TFMagicMapData magicMapData = par3MapData;
        for (int i = 0; i < 16384; ++i) {
            final int colorByte = par3MapData.field_76198_e[i] & 0xFF;
            if (colorByte == 0) {
                this.intArray[i] = (i + i / 128 & 0x1) * 8 + 16 << 24;
            }
            else {
                final int biomeID = colorByte - 1;
                final BiomeGenBase biome = BiomeGenBase.func_150565_n()[biomeID];
                if (biome != null) {
                    this.intArray[i] = (0xFF000000 | biome.field_76790_z);
                }
            }
        }
        this.bufferedImage.func_110564_a();
        final byte var15 = 0;
        final byte var16 = 0;
        final Tessellator tesselator = Tessellator.field_78398_a;
        final float var17 = 0.0f;
        par2TextureManager.func_110577_a(this.textureLoc);
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
        par2TextureManager.func_110577_a(TFMagicMapRenderer.vanillaMapIcons);
        for (final MapData.MapCoord mapCoord : par3MapData.field_76203_h.values()) {
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
        par2TextureManager.func_110577_a(TFMagicMapRenderer.twilightMapIcons);
        for (final MapData.MapCoord mapCoord : magicMapData.featuresVisibleOnMap) {
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
    
    private void renderMapInFrame(final ItemStack item, final RenderManager renderManager, final TFMagicMapData mapData) {
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(0.0078125f, 0.0078125f, 0.0078125f);
        GL11.glTranslatef(-65.0f, -111.0f, -3.0f);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        renderManager.field_78724_e.func_110577_a(TFMagicMapRenderer.mapBackgroundTextures);
        final Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        final byte b0 = 7;
        tessellator.func_78374_a((double)(0 - b0), (double)(128 + b0), 0.0, 0.0, 1.0);
        tessellator.func_78374_a((double)(128 + b0), (double)(128 + b0), 0.0, 1.0, 1.0);
        tessellator.func_78374_a((double)(128 + b0), (double)(0 - b0), 0.0, 1.0, 0.0);
        tessellator.func_78374_a((double)(0 - b0), (double)(0 - b0), 0.0, 0.0, 0.0);
        tessellator.func_78381_a();
        GL11.glTranslatef(0.0f, 0.0f, -1.0f);
        this.renderMap(null, renderManager.field_78724_e, mapData);
    }
    
    static {
        vanillaMapIcons = new ResourceLocation("textures/map/map_icons.png");
        twilightMapIcons = new ResourceLocation("twilightforest:textures/gui/mapicons.png");
        mapBackgroundTextures = new ResourceLocation("textures/map/map_background.png");
    }
}
