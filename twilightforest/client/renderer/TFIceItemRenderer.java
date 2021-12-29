// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class TFIceItemRenderer implements IItemRenderer
{
    private static final ResourceLocation RES_ITEM_GLINT;
    private TextureManager texturemanager;
    
    public TFIceItemRenderer(final GameSettings gameSettings, final TextureManager textureManager) {
        this.texturemanager = textureManager;
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.ENTITY || type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.INVENTORY;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return type == IItemRenderer.ItemRenderType.ENTITY && (helper == IItemRenderer.ItemRendererHelper.ENTITY_ROTATION || helper == IItemRenderer.ItemRendererHelper.ENTITY_BOBBING);
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            final IIcon iicon = ((EntityLivingBase)data[1]).func_70620_b(item, 0);
            this.renderIcyItemEquipped(iicon, item);
        }
        else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            final IIcon iicon = ((EntityLivingBase)data[1]).func_70620_b(item, 0);
            this.renderIcyItemEquipped(iicon, item);
        }
        else if (type == IItemRenderer.ItemRenderType.ENTITY) {
            final EntityItem entityItem = (EntityItem)data[1];
            this.renderDroppedItem(entityItem, item);
        }
        else if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            this.renderInventoryItem(item, (RenderBlocks)data[0]);
        }
    }
    
    private void renderIcyItemEquipped(final IIcon iicon, final ItemStack par2ItemStack) {
        final int par3 = 0;
        if (iicon == null) {
            GL11.glPopMatrix();
            return;
        }
        this.texturemanager.func_110577_a(this.texturemanager.func_130087_a(par2ItemStack.func_94608_d()));
        TextureUtil.func_152777_a(false, false, 1.0f);
        final Tessellator tessellator = Tessellator.field_78398_a;
        final float f = iicon.func_94209_e();
        final float f2 = iicon.func_94212_f();
        final float f3 = iicon.func_94206_g();
        final float f4 = iicon.func_94210_h();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        ItemRenderer.func_78439_a(tessellator, f2, f3, f, f4, iicon.func_94211_a(), iicon.func_94216_b(), 0.0625f);
        GL11.glDisable(3042);
        if (par2ItemStack.hasEffect(par3)) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            this.texturemanager.func_110577_a(TFIceItemRenderer.RES_ITEM_GLINT);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(768, 1, 1, 0);
            final float f5 = 0.76f;
            GL11.glColor4f(0.5f * f5, 0.25f * f5, 0.8f * f5, 1.0f);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            final float f6 = 0.125f;
            GL11.glScalef(f6, f6, f6);
            float f7 = Minecraft.func_71386_F() % 3000L / 3000.0f * 8.0f;
            GL11.glTranslatef(f7, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.func_78439_a(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f6, f6, f6);
            f7 = Minecraft.func_71386_F() % 4873L / 4873.0f * 8.0f;
            GL11.glTranslatef(-f7, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.func_78439_a(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
        this.texturemanager.func_110577_a(this.texturemanager.func_130087_a(par2ItemStack.func_94608_d()));
        TextureUtil.func_147945_b();
    }
    
    private void renderDroppedItem(final EntityItem entityItem, final ItemStack item) {
        final Tessellator tessellator = Tessellator.field_78398_a;
        final float f9 = 0.5f;
        final float f10 = 0.25f;
        GL11.glPushMatrix();
        final float f11 = 0.0625f;
        final float f12 = 0.021875f;
        GL11.glTranslatef(-f9, -f10, -(f11 + f12));
        GL11.glTranslatef(0.0f, 0.0f, f11 + f12);
        this.texturemanager.func_110577_a(TextureMap.field_110576_c);
        final IIcon par2Icon = item.func_77954_c();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        ItemRenderer.func_78439_a(tessellator, par2Icon.func_94212_f(), par2Icon.func_94206_g(), par2Icon.func_94209_e(), par2Icon.func_94210_h(), par2Icon.func_94211_a(), par2Icon.func_94216_b(), f11);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private void renderInventoryItem(final ItemStack itemStack, final RenderBlocks renderBlocks) {
        final IIcon iicon = itemStack.func_77973_b().getIcon(itemStack, -1);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderItem.getInstance().func_94149_a(0, 0, iicon, 16, 16);
        GL11.glDisable(3042);
        GL11.glDisable(3008);
        GL11.glEnable(2896);
        if (itemStack.hasEffect(0)) {
            RenderItem.getInstance().renderEffect(this.texturemanager, 0, 0);
        }
        GL11.glEnable(2896);
    }
    
    static {
        RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    }
}
