// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelTFGhast extends bbl
{
    bcr body;
    protected bcr[] tentacles;
    
    public ModelTFGhast() {
        this.tentacles = new bcr[9];
        final byte yOffset = -16;
        (this.body = new bcr((bbl)this, 0, 0)).a(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        final bcr body = this.body;
        body.d += 24 + yOffset;
        final Random rand = new Random(1660L);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.makeTentacle(yOffset, rand, i);
        }
    }
    
    protected void makeTentacle(final byte yOffset, final Random random, final int i) {
        this.tentacles[i] = new bcr((bbl)this, 0, 0);
        final float xPoint = ((i % 3 - i / 3 % 2 * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
        final float zPoint = (i / 3 / 2.0f * 2.0f - 1.0f) * 5.0f;
        final int length = random.nextInt(7) + 8;
        this.tentacles[i].a(-1.0f, 0.0f, -1.0f, 2, length, 2);
        this.tentacles[i].c = xPoint;
        this.tentacles[i].e = zPoint;
        this.tentacles[i].d = (float)(23 + yOffset);
        this.body.a(this.tentacles[i]);
    }
    
    public void a(final float par1, final float par2, final float par3, final float yaw, final float pitch, final float par6, final nm par7Entity) {
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].f = 0.2f * lr.a(par3 * 0.3f + i) + 0.4f;
        }
        this.body.f = pitch / 57.295776f;
        this.body.g = yaw / 57.295776f;
    }
    
    public void a(final nm par1Entity, final float par2, final float par3, final float par4, final float yaw, final float pitch, final float time) {
        this.a(par2, par3, par4, yaw, pitch, time, par1Entity);
        this.body.a(time);
    }
}
