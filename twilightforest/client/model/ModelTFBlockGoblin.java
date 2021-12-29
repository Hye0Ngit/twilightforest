// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFBlockGoblin extends bbg
{
    public bcr helmet;
    bcr block;
    bcr[] spikes;
    
    public ModelTFBlockGoblin() {
        this.spikes = new bcr[27];
        (this.c = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.c.a(0.0f, 11.0f, 0.0f);
        (this.d = new bcr((bbl)this, 0, 0)).a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.5f);
        this.d.a(0.0f, 11.0f, 0.0f);
        (this.helmet = new bcr((bbl)this, 24, 0)).a(-2.5f, -9.0f, -2.5f, 5, 9, 5);
        this.helmet.g = 0.7853982f;
        this.d.a(this.helmet);
        (this.e = new bcr((bbl)this, 0, 21)).a(-3.5f, 0.0f, -2.0f, 7, 7, 4, 0.0f);
        this.e.a(0.0f, 11.0f, 0.0f);
        (this.f = new bcr((bbl)this, 52, 0)).a(-3.0f, -1.0f, -2.0f, 3, 12, 3, 0.0f);
        this.f.a(-3.5f, 12.0f, 0.0f);
        (this.g = new bcr((bbl)this, 52, 0)).a(0.0f, -1.0f, -1.5f, 3, 12, 3, 0.0f);
        this.g.a(3.5f, 12.0f, 0.0f);
        (this.h = new bcr((bbl)this, 0, 12)).a(-1.5f, 0.0f, -1.5f, 3, 6, 3, 0.0f);
        this.h.a(-2.0f, 18.0f, 0.0f);
        (this.i = new bcr((bbl)this, 0, 12)).a(-1.5f, 0.0f, -1.5f, 3, 6, 3, 0.0f);
        this.i.a(2.0f, 18.0f, 0.0f);
        (this.block = new bcr((bbl)this, 32, 16)).a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.block.a(6.0f, 0.0f, 0.0f);
        for (int i = 0; i < this.spikes.length; ++i) {
            (this.spikes[i] = new bcr((bbl)this, 56, 16)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.0f);
            this.block.a(this.spikes[i]);
        }
        this.spikes[2].c = 4.0f;
        this.spikes[3].c = 4.0f;
        this.spikes[4].c = 4.0f;
        this.spikes[11].c = 4.0f;
        this.spikes[12].c = 5.0f;
        this.spikes[13].c = 4.0f;
        this.spikes[20].c = 4.0f;
        this.spikes[21].c = 4.0f;
        this.spikes[22].c = 4.0f;
        this.spikes[6].c = -4.0f;
        this.spikes[7].c = -4.0f;
        this.spikes[8].c = -4.0f;
        this.spikes[15].c = -4.0f;
        this.spikes[16].c = -5.0f;
        this.spikes[17].c = -4.0f;
        this.spikes[24].c = -4.0f;
        this.spikes[25].c = -4.0f;
        this.spikes[26].c = -4.0f;
        this.spikes[0].d = -9.0f;
        this.spikes[1].d = -8.0f;
        this.spikes[2].d = -8.0f;
        this.spikes[3].d = -8.0f;
        this.spikes[4].d = -8.0f;
        this.spikes[5].d = -8.0f;
        this.spikes[6].d = -8.0f;
        this.spikes[7].d = -8.0f;
        this.spikes[8].d = -8.0f;
        this.spikes[9].d = -4.0f;
        this.spikes[10].d = -4.0f;
        this.spikes[11].d = -4.0f;
        this.spikes[12].d = -4.0f;
        this.spikes[13].d = -4.0f;
        this.spikes[14].d = -4.0f;
        this.spikes[15].d = -4.0f;
        this.spikes[16].d = -4.0f;
        this.spikes[17].d = -4.0f;
        this.spikes[18].d = 1.0f;
        this.spikes[1].e = 4.0f;
        this.spikes[2].e = 4.0f;
        this.spikes[8].e = 4.0f;
        this.spikes[10].e = 4.0f;
        this.spikes[11].e = 5.0f;
        this.spikes[17].e = 4.0f;
        this.spikes[19].e = 4.0f;
        this.spikes[20].e = 4.0f;
        this.spikes[26].e = 4.0f;
        this.spikes[4].e = -4.0f;
        this.spikes[5].e = -4.0f;
        this.spikes[6].e = -4.0f;
        this.spikes[13].e = -4.0f;
        this.spikes[14].e = -5.0f;
        this.spikes[15].e = -4.0f;
        this.spikes[22].e = -4.0f;
        this.spikes[23].e = -4.0f;
        this.spikes[24].e = -4.0f;
        final float fourtyFive = 0.7853982f;
        this.spikes[1].f = fourtyFive;
        this.spikes[5].f = fourtyFive;
        this.spikes[19].f = fourtyFive;
        this.spikes[23].f = fourtyFive;
        this.spikes[11].g = fourtyFive;
        this.spikes[13].g = fourtyFive;
        this.spikes[15].g = fourtyFive;
        this.spikes[17].g = fourtyFive;
        this.spikes[3].h = fourtyFive;
        this.spikes[7].h = fourtyFive;
        this.spikes[21].h = fourtyFive;
        this.spikes[25].h = fourtyFive;
        this.spikes[2].f = -0.95993114f;
        this.spikes[2].g = fourtyFive;
        this.spikes[24].f = -0.95993114f;
        this.spikes[24].g = fourtyFive;
        this.spikes[4].f = -0.6108653f;
        this.spikes[4].g = -fourtyFive;
        this.spikes[26].f = -0.6108653f;
        this.spikes[26].g = -fourtyFive;
        this.spikes[6].g = fourtyFive;
        this.spikes[6].f = -0.6108653f;
        this.spikes[20].g = fourtyFive;
        this.spikes[20].f = -0.6108653f;
        this.spikes[8].f = -0.95993114f;
        this.spikes[8].g = -fourtyFive;
        this.spikes[22].f = -0.95993114f;
        this.spikes[22].g = -fourtyFive;
    }
    
    public void a(final nm entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
    }
    
    public void a(final float f, final float f1, final float f2, final float yaw, final float pitch, final float time, final nm entity) {
        this.o = false;
        super.a(f, f1, f2, yaw, pitch, time, entity);
        this.c.d = 11.0f;
        this.d.d = 11.0f;
        this.e.d = 11.0f;
        this.h.d = 18.0f;
        this.i.d = 18.0f;
        this.f.a(-3.5f, 12.0f, 0.0f);
        final bcr f3 = this.f;
        f3.f += (float)3.141592653589793;
        this.g.a(3.5f, 12.0f, 0.0f);
        final bcr g = this.g;
        g.f += (float)3.141592653589793;
        final float angle = f2 / 4.0f;
        final float length = 0.0f;
        this.block.c = (float)Math.sin(angle) * length;
        this.block.e = (float)(-Math.cos(angle)) * length;
        this.block.g = -angle;
    }
}
