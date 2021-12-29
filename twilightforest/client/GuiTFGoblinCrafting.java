// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.ContainerTFUncrafting;

public class GuiTFGoblinCrafting extends ayf
{
    public GuiTFGoblinCrafting(final si inventory, final zv world, final int x, final int y, final int z) {
        super((td)new ContainerTFUncrafting(inventory, world, x, y, z));
    }
    
    protected void b(final int var1, final int var2) {
        this.l.b("Uncrafting Table", 8, 6, 4210752);
        this.l.b(bo.a("container.inventory"), 8, this.c - 96 + 2, 4210752);
    }
    
    protected void a(final float var1, final int var2, final int var3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.f.p.b("/mods/twilightforest/textures/gui/guigoblintinkering.png");
        final int frameX = (this.g - this.b) / 2;
        final int frameY = (this.h - this.c) / 2;
        this.b(frameX, frameY, 0, 0, this.b, this.c);
        final ContainerTFUncrafting tfContainer = (ContainerTFUncrafting)this.d;
        auv.c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)this.n, (float)this.o, 0.0f);
        for (int i = 0; i < 9; ++i) {
            final uf uncrafting = tfContainer.a(2 + i);
            final uf assembly = tfContainer.a(11 + i);
            if (uncrafting.c() != null) {
                this.drawSlotAsBackground(uncrafting, assembly);
            }
        }
        GL11.glPopMatrix();
        final awp fontRenderer = this.f.q;
        auv.a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            if (this.f.g.cf < costVal && !this.f.g.ce.d) {
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
            if (this.f.g.cf < costVal && !this.f.g.ce.d) {
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
    
    private void drawSlotAsBackground(final uf backgroundSlot, final uf appearSlot) {
        final int screenX = appearSlot.h;
        final int screenY = appearSlot.i;
        final wg itemStackToRender = backgroundSlot.c();
        this.j = 50.0f;
        GuiTFGoblinCrafting.a.f = 50.0f;
        GuiTFGoblinCrafting.a.a(this.l, this.f.p, itemStackToRender, screenX, screenY);
        GuiTFGoblinCrafting.a.c(this.l, this.f.p, itemStackToRender, screenX, screenY);
        boolean itemBroken = false;
        if (backgroundSlot.d() && backgroundSlot.c().a == 0) {
            itemBroken = true;
        }
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        a(screenX, screenY, screenX + 16, screenY + 16, itemBroken ? -2130736245 : -1618244725);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GuiTFGoblinCrafting.a.f = 0.0f;
        this.j = 0.0f;
    }
}
