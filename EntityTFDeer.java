// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFDeer extends adr
{
    public EntityTFDeer(final ry world) {
        super(world);
        this.aA = "/twilightforest/wilddeer.png";
        this.a(0.7f, 2.3f);
    }
    
    protected String e() {
        return null;
    }
    
    public boolean c(final vi entityplayer) {
        final dk itemstack = entityplayer.by.a();
        return (itemstack == null || itemstack.c != acy.av.bM) && super.c(entityplayer);
    }
    
    protected fx a(final fx entityanimal) {
        return (fx)new EntityTFDeer(this.o);
    }
}
