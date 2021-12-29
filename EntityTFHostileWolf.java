// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHostileWolf extends hc
{
    public EntityTFHostileWolf(final fq world) {
        super(world);
        this.c(true);
        this.ap = 10;
    }
    
    public void y_() {
        super.y_();
        if (!this.bi.I && this.bi.v == 0) {
            this.T();
        }
    }
}
