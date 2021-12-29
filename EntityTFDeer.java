// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFDeer extends cf
{
    public EntityTFDeer(final fq world) {
        super(world);
        this.ae = "/twilightforest/wilddeer.png";
        this.b(0.7f, 2.3f);
    }
    
    protected String c_() {
        return null;
    }
    
    public boolean b(final hk entityplayer) {
        final jm itemstack = entityplayer.k.d();
        return (itemstack == null || itemstack.c != hg.av.bN) && super.b(entityplayer);
    }
    
    protected bm a(final bm entityanimal) {
        return (bm)new EntityTFDeer(this.bi);
    }
}
