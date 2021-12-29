// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFNaga extends al
{
    public boolean showHead;
    public boolean showBody;
    public acf head;
    public acf body;
    
    public ModelTFNaga() {
        this.showHead = false;
        this.showBody = false;
        (this.head = new acf((al)this, 0, 0)).a(-8.0f, -12.0f, -8.0f, 16, 16, 16, 0.0f);
        this.head.a(0.0f, 0.0f, 0.0f);
        (this.body = new acf((al)this, 0, 0)).a(-8.0f, -4.0f, -8.0f, 16, 16, 16, 0.0f);
        this.body.a(0.0f, 0.0f, 0.0f);
    }
    
    public void a(final ia entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5);
        if (this.showHead) {
            this.head.a(f5 * 2.0f);
        }
        if (this.showBody) {
            this.body.a(f5 * 2.0f);
        }
    }
    
    public void switchToHead() {
        this.showHead = true;
        this.showBody = false;
    }
    
    public void switchToBody() {
        this.showHead = false;
        this.showBody = true;
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(f, f1, f2, f3, f4, f5);
    }
}
