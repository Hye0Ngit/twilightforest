// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.IItemRenderer;

public class TFGiantBlockRenderer implements IItemRenderer
{
    public TFGiantBlockRenderer(final GameSettings gameSettings, final TextureManager textureManager) {
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.ENTITY || type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return (type == IItemRenderer.ItemRenderType.ENTITY && (helper == IItemRenderer.ItemRendererHelper.ENTITY_ROTATION || helper == IItemRenderer.ItemRendererHelper.ENTITY_BOBBING)) || helper == IItemRenderer.ItemRendererHelper.BLOCK_3D;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            final float scale = 4.0f;
            GL11.glScalef(scale, scale, scale);
            GL11.glTranslatef(1.0f, 0.3f, 0.75f);
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            final IIcon iicon = ((EntityLivingBase)data[1]).func_70620_b(item, 0);
            final RenderBlocks renderBlocks = (RenderBlocks)data[0];
            this.renderGiantItemEquipped(iicon, renderBlocks, item);
        }
        else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            final float scale = 4.0f;
            GL11.glScalef(scale, scale, scale);
            GL11.glTranslatef(0.25f, 0.3f, -0.5f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
            final IIcon iicon = ((EntityLivingBase)data[1]).func_70620_b(item, 0);
            final RenderBlocks renderBlocks = (RenderBlocks)data[0];
            this.renderGiantItemEquipped(iicon, renderBlocks, item);
        }
        else if (type == IItemRenderer.ItemRenderType.ENTITY) {
            final float scale = 4.0f;
            GL11.glScalef(scale, scale, scale);
            GL11.glTranslatef(0.0f, 0.5f, 0.0f);
            final RenderBlocks renderBlocks2 = (RenderBlocks)data[0];
            final EntityItem entityItem = (EntityItem)data[1];
            this.renderDroppedItem(entityItem, renderBlocks2, item);
        }
    }
    
    private void renderGiantItemEquipped(final IIcon iicon, final RenderBlocks renderBlocks, final ItemStack itemStack) {
        final Block block = Block.func_149634_a(itemStack.func_77973_b());
        renderBlocks.func_147800_a(block, itemStack.func_77960_j(), 1.0f);
    }
    
    private void renderDroppedItem(final EntityItem entityItem, final RenderBlocks renderBlocks, final ItemStack itemStack) {
        final Block block = Block.func_149634_a(itemStack.func_77973_b());
        renderBlocks.func_147800_a(block, itemStack.func_77960_j(), 1.0f);
    }
}
