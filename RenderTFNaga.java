// 
// Decompiled by Procyon v0.6-prerelease
// 

public class RenderTFNaga extends acq
{
    public RenderTFNaga(final al modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final nq entityliving, final double d, final double d1, final double d2, final float f, final float f1) {
        if (entityliving instanceof EntityTFNaga) {
            ((ModelTFNaga)this.g).switchToHead();
        }
        if (entityliving instanceof EntityTFNagaSegment) {
            final EntityTFNagaSegment ns = (EntityTFNagaSegment)entityliving;
            if (ns.getSegment() % 2 == 0) {
                ((ModelTFNaga)this.g).switchToBody();
            }
            else {
                ((ModelTFNaga)this.g).switchToBody();
            }
        }
        super.a(entityliving, d, d1, d2, f, f1);
    }
}
