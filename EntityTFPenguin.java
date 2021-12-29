// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFPenguin extends qz
{
    public EntityTFPenguin(final wz world) {
        super(world);
        this.bm = "/twilightforest/penguin.png";
        (this.bT = new my()).a(0, (qy)new aiy((acl)this));
        this.bT.a(1, (qy)new kb((zv)this, 0.38f));
        this.bT.a(2, (qy)new alm((bb)this, 0.25f));
        this.bT.a(3, (qy)new akt((zv)this, 0.25f, ym.aU.bQ, false));
        this.bT.a(4, (qy)new eh((bb)this, 0.28f));
        this.bT.a(5, (qy)new acp((zv)this, 0.25f));
        this.bT.a(6, (qy)new nx((acl)this, (Class)yr.class, 6.0f));
        this.bT.a(7, (qy)new ve((acl)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.bT.a(8, (qy)new bc((acl)this));
    }
    
    protected String c_() {
        return null;
    }
    
    public bb a(final bb par1EntityAnimal) {
        return (bb)new EntityTFPenguin(this.k);
    }
    
    public boolean a(final aai par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.c == ym.aU.bQ;
    }
}
