// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFPenguin extends rd
{
    public EntityTFPenguin(final xd world) {
        super(world);
        this.bm = "/twilightforest/penguin.png";
        (this.bT = new nb()).a(0, (rc)new aje((acq)this));
        this.bT.a(1, (rc)new ke((aaa)this, 0.38f));
        this.bT.a(2, (rc)new als((bc)this, 0.25f));
        this.bT.a(3, (rc)new akz((aaa)this, 0.25f, yr.aU.bQ, false));
        this.bT.a(4, (rc)new ek((bc)this, 0.28f));
        this.bT.a(5, (rc)new acu((aaa)this, 0.25f));
        this.bT.a(6, (rc)new ob((acq)this, (Class)yw.class, 6.0f));
        this.bT.a(7, (rc)new vi((acq)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.bT.a(8, (rc)new bd((acq)this));
    }
    
    public EntityTFPenguin(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    protected String m() {
        return null;
    }
    
    public bc a(final bc par1EntityAnimal) {
        return (bc)new EntityTFPenguin(this.k);
    }
    
    public boolean a(final aan par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.c == yr.aU.bQ;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
