// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFKnightlyArmor extends bbg
{
    public bcr righthorn1;
    public bcr righthorn2;
    public bcr lefthorn1;
    public bcr lefthorn2;
    public bcr shoulderSpike1;
    public bcr shoulderSpike2;
    public bcr shoeSpike1;
    public bcr shoeSpike2;
    
    public ModelTFKnightlyArmor(final int part, final float expand) {
        super(expand);
        (this.righthorn1 = new bcr((bbl)this, 32, 0)).a(-5.5f, -1.5f, -1.5f, 5, 3, 3);
        this.righthorn1.a(-4.0f, -6.5f, 0.0f);
        this.righthorn1.g = -0.2617994f;
        this.righthorn1.h = 0.17453294f;
        (this.righthorn2 = new bcr((bbl)this, 32, 6)).a(-3.5f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.h = 0.17453294f;
        this.righthorn1.a(this.righthorn2);
        this.lefthorn1 = new bcr((bbl)this, 32, 0);
        this.lefthorn1.i = true;
        this.lefthorn1.a(0.5f, -1.5f, -1.5f, 5, 3, 3);
        this.lefthorn1.a(4.0f, -6.5f, 0.0f);
        this.lefthorn1.g = 0.2617994f;
        this.lefthorn1.h = -0.17453294f;
        (this.lefthorn2 = new bcr((bbl)this, 32, 6)).a(0.5f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.h = -0.17453294f;
        this.lefthorn1.a(this.lefthorn2);
        this.c.a(this.righthorn1);
        this.c.a(this.lefthorn1);
        (this.shoulderSpike1 = new bcr((bbl)this, 32, 10)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoulderSpike1.a(-3.75f, -2.5f, 0.0f);
        this.shoulderSpike1.f = 0.7853982f;
        this.shoulderSpike1.g = 0.17453294f;
        this.shoulderSpike1.h = 0.6108653f;
        this.f.a(this.shoulderSpike1);
        (this.shoulderSpike2 = new bcr((bbl)this, 32, 10)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoulderSpike2.a(3.75f, -2.5f, 0.0f);
        this.shoulderSpike2.f = -0.7853982f;
        this.shoulderSpike2.g = -0.17453294f;
        this.shoulderSpike2.h = 0.95993114f;
        this.g.a(this.shoulderSpike2);
        (this.shoeSpike1 = new bcr((bbl)this, 32, 10)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoeSpike1.a(-2.5f, 11.0f, 2.0f);
        this.shoeSpike1.g = -0.7853982f;
        this.h.a(this.shoeSpike1);
        (this.shoeSpike2 = new bcr((bbl)this, 32, 10)).a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoeSpike2.a(2.5f, 11.0f, 2.0f);
        this.shoeSpike2.g = 0.7853982f;
        this.i.a(this.shoeSpike2);
        switch (part) {
            case 0: {
                this.c.j = true;
                this.d.j = false;
                this.e.j = false;
                this.f.j = false;
                this.g.j = false;
                this.h.j = false;
                this.i.j = false;
                break;
            }
            case 1: {
                this.c.j = false;
                this.d.j = false;
                this.e.j = true;
                this.f.j = true;
                this.g.j = true;
                this.h.j = false;
                this.i.j = false;
                break;
            }
            case 2: {
                this.c.j = false;
                this.d.j = false;
                this.e.j = true;
                this.f.j = false;
                this.g.j = false;
                this.h.j = true;
                this.i.j = true;
                break;
            }
            case 3: {
                this.c.j = false;
                this.d.j = false;
                this.e.j = false;
                this.f.j = false;
                this.g.j = false;
                this.h.j = true;
                this.i.j = true;
                break;
            }
        }
    }
}
