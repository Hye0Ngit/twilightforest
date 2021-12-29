// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFMinotaur extends awp
{
    axx horn1a;
    axx horn1b;
    axx horn2a;
    axx horn2b;
    axx snout;
    
    public ModelTFMinotaur() {
        (this.horn1a = new axx((awt)this, 24, 0)).a(0.0f, -1.0f, -1.0f, 3, 2, 2);
        this.horn1a.a(4.0f, -6.0f, 0.0f);
        this.horn1a.g = 0.2617994f;
        this.c.a(this.horn1a);
        (this.horn1b = new axx((awt)this, 24, 2)).a(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.horn1b.a(2.75f, 0.0f, 0.0f);
        this.horn1b.f = 0.5235988f;
        this.horn1b.g = -0.5235988f;
        this.horn1a.a(this.horn1b);
        (this.horn2a = new axx((awt)this, 24, 0)).a(-3.0f, -1.0f, -1.0f, 3, 2, 2);
        this.horn2a.a(-4.0f, -6.0f, 0.0f);
        this.horn2a.g = -0.2617994f;
        this.c.a(this.horn2a);
        (this.horn2b = new axx((awt)this, 24, 2)).a(-1.0f, -4.0f, -1.0f, 2, 4, 2);
        this.horn2b.a(-2.75f, 0.0f, 0.0f);
        this.horn2b.f = 0.5235988f;
        this.horn2b.g = 0.5235988f;
        this.horn2a.a(this.horn2b);
        (this.snout = new axx((awt)this, 9, 12)).a(-2.0f, -1.0f, -1.0f, 4, 3, 1);
        this.snout.a(0.0f, -2.0f, -4.0f);
        this.c.a(this.snout);
    }
}
