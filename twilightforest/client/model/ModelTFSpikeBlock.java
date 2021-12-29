// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFSpikeBlock extends bbl
{
    bcr block;
    bcr[] spikes;
    
    public ModelTFSpikeBlock() {
        this.spikes = new bcr[27];
        (this.block = new bcr((bbl)this, 32, 16)).a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.block.a(0.0f, 0.0f, 0.0f);
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
        this.block.a(f5);
    }
}
