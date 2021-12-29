// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

public class ModelTFHydraMortar extends bbx
{
    public bdc box;
    
    public ModelTFHydraMortar() {
        this.t = 32;
        this.u = 32;
        (this.box = new bdc((bbx)this, 0, 0)).a(-4.0f, 0.0f, -4.0f, 8, 8, 8, 0.0f);
        this.box.a(0.0f, 0.0f, 0.0f);
    }
    
    public void render(final float f5) {
        this.box.a(f5);
    }
}
