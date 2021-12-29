// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFBoar extends wn
{
    public EntityTFBoar(final fq world) {
        super(world);
        this.ae = "/twilightforest/wildboar.png";
        this.b(0.9f, 0.9f);
    }
    
    protected bm a(final bm entityanimal) {
        return (bm)new EntityTFBoar(this.bi);
    }
}
