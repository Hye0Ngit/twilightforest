// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFTinyFirefly extends axa
{
    public ayf glow1;
    
    public ModelTFTinyFirefly() {
        (this.glow1 = new ayf((axa)this, 20, 0)).a(-5.0f, -5.0f, 0.0f, 10, 10, 0, 0.0f);
    }
    
    public void render(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.glow1.a(f5);
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
