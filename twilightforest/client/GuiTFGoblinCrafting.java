// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.ContainerTFUncrafting;

public class GuiTFGoblinCrafting extends auy
{
    public GuiTFGoblinCrafting(final qw inventory, final xv world, final int x, final int y, final int z) {
        super((rp)new ContainerTFUncrafting(inventory, world, x, y, z));
    }
    
    protected void b(final int var1, final int var2) {
        this.l.b("Uncrafting Table", 8, 6, 4210752);
        this.l.b(bm.a("container.inventory"), 8, this.c - 96 + 2, 4210752);
    }
    
    protected void a(final float var1, final int var2, final int var3) {
        final int backgroundTexture = this.f.o.b("/twilightforest/guigoblintinkering.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.f.o.b(backgroundTexture);
        final int frameX = (this.g - this.b) / 2;
        final int frameY = (this.h - this.c) / 2;
        this.b(frameX, frameY, 0, 0, this.b, this.c);
        final ContainerTFUncrafting tfContainer = (ContainerTFUncrafting)this.d;
        aro.c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)this.n, (float)this.o, 0.0f);
        for (int i = 0; i < 9; ++i) {
            final sq uncrafting = tfContainer.a(2 + i);
            final sq assembly = tfContainer.a(11 + i);
            if (uncrafting.c() != null) {
                this.drawSlotAsBackground(uncrafting, assembly);
            }
        }
        GL11.glPopMatrix();
        final atj fontRenderer = this.f.p;
        aro.a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            if (this.f.g.cd < costVal && !this.f.g.cc.d) {
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
            if (this.f.g.cd < costVal && !this.f.g.cc.d) {
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
    
    private void drawSlotAsBackground(final sq backgroundSlot, final sq appearSlot) {
        final int screenX = appearSlot.h;
        final int screenY = appearSlot.i;
        final um itemStackToRender = backgroundSlot.c();
        this.j = 50.0f;
        GuiTFGoblinCrafting.a.f = 50.0f;
        GuiTFGoblinCrafting.a.a(this.l, this.f.o, itemStackToRender, screenX, screenY);
        GuiTFGoblinCrafting.a.c(this.l, this.f.o, itemStackToRender, screenX, screenY);
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
