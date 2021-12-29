// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.ContainerTFUncrafting;

public class GuiTFGoblinCrafting extends awv
{
    private static final bjl textureLoc;
    
    public GuiTFGoblinCrafting(final uc inventory, final abv world, final int x, final int y, final int z) {
        super((ux)new ContainerTFUncrafting(inventory, world, x, y, z));
    }
    
    protected void b(final int var1, final int var2) {
        this.o.b("Uncrafting Table", 8, 6, 4210752);
        this.o.b(bt.a("container.inventory"), 8, this.d - 96 + 2, 4210752);
    }
    
    protected void a(final float var1, final int var2, final int var3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.f.J().a(GuiTFGoblinCrafting.textureLoc);
        final int frameX = (this.g - this.c) / 2;
        final int frameY = (this.h - this.d) / 2;
        this.b(frameX, frameY, 0, 0, this.c, this.d);
        final ContainerTFUncrafting tfContainer = (ContainerTFUncrafting)this.e;
        atq.c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)this.p, (float)this.q, 0.0f);
        for (int i = 0; i < 9; ++i) {
            final wd uncrafting = tfContainer.a(2 + i);
            final wd assembly = tfContainer.a(11 + i);
            if (uncrafting.d() != null) {
                this.drawSlotAsBackground(uncrafting, assembly);
            }
        }
        GL11.glPopMatrix();
        final avf fontRenderer = this.f.l;
        atq.a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            if (this.f.h.bH < costVal && !this.f.h.bG.d) {
                final int color = 10485760;
                final String cost = "" + costVal;
                fontRenderer.a(cost, frameX + 48 - fontRenderer.a(cost), frameY + 38, color);
            }
            else {
                final int color = 8453920;
                final String cost = "" + costVal;
                fontRenderer.a(cost, frameX + 48 - fontRenderer.a(cost), frameY + 38, color);
            }
        }
        costVal = tfContainer.getRecraftingCost();
        if (costVal > 0) {
            if (this.f.h.bH < costVal && !this.f.h.bG.d) {
                final int color = 10485760;
                final String cost = "" + costVal;
                fontRenderer.a(cost, frameX + 130 - fontRenderer.a(cost), frameY + 38, color);
            }
            else {
                final int color = 8453920;
                final String cost = "" + costVal;
                fontRenderer.a(cost, frameX + 130 - fontRenderer.a(cost), frameY + 38, color);
            }
        }
    }
    
    private void drawSlotAsBackground(final wd backgroundSlot, final wd appearSlot) {
        final int screenX = appearSlot.h;
        final int screenY = appearSlot.i;
        final yd itemStackToRender = backgroundSlot.d();
        this.n = 50.0f;
        GuiTFGoblinCrafting.b.f = 50.0f;
        GuiTFGoblinCrafting.b.a(this.o, this.f.N, itemStackToRender, screenX, screenY);
        GuiTFGoblinCrafting.b.c(this.o, this.f.N, itemStackToRender, screenX, screenY);
        boolean itemBroken = false;
        if (backgroundSlot.e() && backgroundSlot.d().b == 0) {
            itemBroken = true;
        }
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        a(screenX, screenY, screenX + 16, screenY + 16, itemBroken ? -2130736245 : -1618244725);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GuiTFGoblinCrafting.b.f = 0.0f;
        this.n = 0.0f;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/gui/guigoblintinkering.png");
    }
}
