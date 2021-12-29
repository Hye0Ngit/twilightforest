// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFDeer extends uj
{
    public EntityTFDeer(final wz world) {
        super(world);
        this.bm = "/twilightforest/wilddeer.png";
        this.a(0.7f, 2.3f);
    }
    
    protected String c_() {
        return null;
    }
    
    public boolean c(final yr entityplayer) {
        final aai itemstack = entityplayer.ap.b();
        return (itemstack == null || itemstack.c != ym.aw.bQ) && super.c(entityplayer);
    }
    
    public bb a(final bb entityanimal) {
        return (bb)new EntityTFDeer(this.k);
    }
}
