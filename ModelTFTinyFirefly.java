// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFTinyFirefly extends hl
{
    public ql glow1;
    
    public ModelTFTinyFirefly() {
        (this.glow1 = new ql((hl)this, 18, -1)).a(-5.0f, -5.0f, 0.0f, 10, 10, 1, 0.0f);
    }
    
    public void render(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.glow1.a(f5);
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
