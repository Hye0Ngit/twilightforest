// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFHydraMortar extends awt
{
    public axx box;
    
    public ModelTFHydraMortar() {
        this.t = 32;
        this.u = 32;
        (this.box = new axx((awt)this, 0, 0)).a(-4.0f, 0.0f, -4.0f, 8, 8, 8, 0.0f);
        this.box.a(0.0f, 0.0f, 0.0f);
    }
    
    public void render(final float f5) {
        this.box.a(f5);
    }
}
