// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.inventory.Slot;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.StatCollector;
import net.minecraft.inventory.Container;
import twilightforest.uncrafting.ContainerTFUncrafting;
import net.minecraft.world.World;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiTFGoblinCrafting extends GuiContainer
{
    private static final ResourceLocation textureLoc;
    
    public GuiTFGoblinCrafting(final InventoryPlayer inventory, final World world, final int x, final int y, final int z) {
        super((Container)new ContainerTFUncrafting(inventory, world, x, y, z));
    }
    
    protected void func_146979_b(final int var1, final int var2) {
        this.field_146289_q.func_78276_b("Uncrafting Table", 8, 6, 4210752);
        this.field_146289_q.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_147000_g - 96 + 2, 4210752);
    }
    
    protected void func_146976_a(final float var1, final int var2, final int var3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(GuiTFGoblinCrafting.textureLoc);
        final int frameX = (this.field_146294_l - this.field_146999_f) / 2;
        final int frameY = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(frameX, frameY, 0, 0, this.field_146999_f, this.field_147000_g);
        final ContainerTFUncrafting tfContainer = (ContainerTFUncrafting)this.field_147002_h;
        RenderHelper.func_74520_c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)this.field_147003_i, (float)this.field_147009_r, 0.0f);
        for (int i = 0; i < 9; ++i) {
            final Slot uncrafting = tfContainer.func_75139_a(2 + i);
            final Slot assembly = tfContainer.func_75139_a(11 + i);
            if (uncrafting.func_75211_c() != null) {
                this.drawSlotAsBackground(uncrafting, assembly);
            }
        }
        GL11.glPopMatrix();
        final FontRenderer fontRendererObj = this.field_146297_k.field_71466_p;
        RenderHelper.func_74518_a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            if (this.field_146297_k.field_71439_g.field_71068_ca < costVal && !this.field_146297_k.field_71439_g.field_71075_bZ.field_75098_d) {
                final int color = 10485760;
                final String cost = "" + costVal;
                fontRendererObj.func_78261_a(cost, frameX + 48 - fontRendererObj.func_78256_a(cost), frameY + 38, color);
            }
            else {
                final int color = 8453920;
                final String cost = "" + costVal;
                fontRendererObj.func_78261_a(cost, frameX + 48 - fontRendererObj.func_78256_a(cost), frameY + 38, color);
            }
        }
        costVal = tfContainer.getRecraftingCost();
        if (costVal > 0) {
            if (this.field_146297_k.field_71439_g.field_71068_ca < costVal && !this.field_146297_k.field_71439_g.field_71075_bZ.field_75098_d) {
                final int color = 10485760;
                final String cost = "" + costVal;
                fontRendererObj.func_78261_a(cost, frameX + 130 - fontRendererObj.func_78256_a(cost), frameY + 38, color);
            }
            else {
                final int color = 8453920;
                final String cost = "" + costVal;
                fontRendererObj.func_78261_a(cost, frameX + 130 - fontRendererObj.func_78256_a(cost), frameY + 38, color);
            }
        }
    }
    
    private void drawSlotAsBackground(final Slot backgroundSlot, final Slot appearSlot) {
        final int screenX = appearSlot.field_75223_e;
        final int screenY = appearSlot.field_75221_f;
        final ItemStack itemStackToRender = backgroundSlot.func_75211_c();
        this.field_73735_i = 50.0f;
        GuiTFGoblinCrafting.field_146296_j.field_77023_b = 50.0f;
        GuiTFGoblinCrafting.field_146296_j.func_77015_a(this.field_146289_q, this.field_146297_k.field_71446_o, itemStackToRender, screenX, screenY);
        GuiTFGoblinCrafting.field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.field_71446_o, itemStackToRender, screenX, screenY);
        boolean itemBroken = false;
        if (backgroundSlot.func_75216_d() && backgroundSlot.func_75211_c().field_77994_a == 0) {
            itemBroken = true;
        }
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        Gui.func_73734_a(screenX, screenY, screenX + 16, screenY + 16, itemBroken ? -2130736245 : -1618244725);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GuiTFGoblinCrafting.field_146296_j.field_77023_b = 0.0f;
        this.field_73735_i = 0.0f;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/gui/guigoblintinkering.png");
    }
}
