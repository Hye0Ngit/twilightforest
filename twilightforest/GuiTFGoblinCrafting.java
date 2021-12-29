// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import org.lwjgl.opengl.GL11;

public class GuiTFGoblinCrafting extends gb
{
    public GuiTFGoblinCrafting(final aak inventory, final xd world, final int x, final int y, final int z) {
        super((dd)new ContainerTFGoblinCrafting(inventory, world, x, y, z));
    }
    
    protected void d() {
        this.u.b("Goblin Tinkering Bench", 8, 6, 4210752);
        this.u.b(cy.a("container.inventory"), 8, this.c - 96 + 2, 4210752);
    }
    
    protected void a(final float var1, final int var2, final int var3) {
        final int backgroundTexture = this.p.p.b("/twilightforest/guigoblintinkering.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.p.p.b(backgroundTexture);
        final int frameX = (this.q - this.b) / 2;
        final int frameY = (this.r - this.c) / 2;
        this.b(frameX, frameY, 0, 0, this.b, this.c);
        final ContainerTFGoblinCrafting tfContainer = (ContainerTFGoblinCrafting)this.d;
        tf.c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)this.e, (float)this.f, 0.0f);
        for (int i = 0; i < 9; ++i) {
            final yu uncrafting = tfContainer.b(2 + i);
            final yu assembly = tfContainer.b(11 + i);
            this.drawSlotAsBackground(uncrafting, assembly);
        }
        GL11.glPopMatrix();
        final nl fontRenderer = this.p.q;
        tf.a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            if (this.p.h.aU < costVal && !this.p.h.aT.d) {
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
            if (this.p.h.aU < costVal && !this.p.h.aT.d) {
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
    
    private void drawSlotAsBackground(final yu backgroundSlot, final yu appearSlot) {
        final int screenX = appearSlot.d;
        final int screenY = appearSlot.e;
        final aan itemStackToRender = backgroundSlot.b();
        this.g = 50.0f;
        GuiTFGoblinCrafting.a.b = 50.0f;
        GuiTFGoblinCrafting.a.a(this.u, this.p.p, itemStackToRender, screenX, screenY);
        GuiTFGoblinCrafting.a.b(this.u, this.p.p, itemStackToRender, screenX, screenY);
        boolean itemBroken = false;
        if (backgroundSlot.c() && backgroundSlot.b().a == 0) {
            itemBroken = true;
        }
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        a(screenX, screenY, screenX + 16, screenY + 16, itemBroken ? -2130736245 : -1618244725);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GuiTFGoblinCrafting.a.b = 0.0f;
        this.g = 0.0f;
    }
}
