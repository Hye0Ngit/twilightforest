// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.world.storage.MapData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import twilightforest.TFMazeMapData;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.item.ItemTFMazeMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class TFMazeMapRenderer implements IItemRenderer
{
    private static final ResourceLocation mapBackgroundTextures;
    
    public TFMazeMapRenderer(final GameSettings gameSettings, final TextureManager textureManager) {
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return (item.field_77993_c == TFItems.mazeMap.field_77779_bT || item.field_77993_c == TFItems.oreMap.field_77779_bT) && RenderItem.field_82407_g && type == IItemRenderer.ItemRenderType.ENTITY;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        if (RenderItem.field_82407_g) {
            final RenderBlocks renderBlocks = (RenderBlocks)data[0];
            final EntityItem entity = (EntityItem)data[1];
            final TFMazeMapData mapData = ((ItemTFMazeMap)TFItems.mazeMap).getMapData(item, entity.field_70170_p);
            if (mapData != null) {
                this.renderMapInFrame(item, RenderManager.field_78727_a, mapData);
            }
        }
    }
    
    private void renderMapInFrame(final ItemStack item, final RenderManager renderManager, final TFMazeMapData mapData) {
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(0.0078125f, 0.0078125f, 0.0078125f);
        GL11.glTranslatef(-65.0f, -111.0f, -3.0f);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        renderManager.field_78724_e.func_110577_a(TFMazeMapRenderer.mapBackgroundTextures);
        final Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        final byte b0 = 7;
        tessellator.func_78374_a((double)(0 - b0), (double)(128 + b0), 0.0, 0.0, 1.0);
        tessellator.func_78374_a((double)(128 + b0), (double)(128 + b0), 0.0, 1.0, 1.0);
        tessellator.func_78374_a((double)(128 + b0), (double)(0 - b0), 0.0, 1.0, 0.0);
        tessellator.func_78374_a((double)(0 - b0), (double)(0 - b0), 0.0, 0.0, 0.0);
        tessellator.func_78381_a();
        GL11.glTranslatef(0.0f, 0.0f, -1.0f);
        renderManager.field_78721_f.field_78449_f.func_78319_a((EntityPlayer)null, renderManager.field_78724_e, (MapData)mapData);
    }
    
    static {
        mapBackgroundTextures = new ResourceLocation("textures/map/map_background.png");
    }
}
