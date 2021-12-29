// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

public abstract class TileEntityTFBossSpawner extends aqj
{
    protected String mobID;
    protected int counter;
    protected mp displayCreature;
    
    public TileEntityTFBossSpawner() {
        this.mobID = "Pig";
        this.displayCreature = null;
    }
    
    public boolean anyPlayerInRange() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, (double)this.getRange()) != null;
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void h() {
        ++this.counter;
        if (this.anyPlayerInRange()) {
            if (this.k.I) {
                final double rx = this.l + this.k.s.nextFloat();
                final double ry = this.m + this.k.s.nextFloat();
                final double rz = this.n + this.k.s.nextFloat();
                this.k.a("smoke", rx, ry, rz, 0.0, 0.0, 0.0);
                this.k.a("flame", rx, ry, rz, 0.0, 0.0, 0.0);
            }
            else if (this.k.r > 0) {
                final ng myCreature = this.makeMyCreature();
                final double rx2 = this.l + 0.5;
                final double ry2 = this.m + 0.5;
                final double rz2 = this.n + 0.5;
                myCreature.b(rx2, ry2, rz2, this.k.s.nextFloat() * 360.0f, 0.0f);
                this.initializeCreature(myCreature);
                this.k.d((mp)myCreature);
                this.k.f(this.l, this.m, this.n, 0, 0, 2);
            }
        }
    }
    
    public mp getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = (mp)this.makeMyCreature();
        }
        return this.displayCreature;
    }
    
    protected void initializeCreature(final ng myCreature) {
        myCreature.b(this.l, this.m, this.n, this.getRange());
    }
    
    protected int getRange() {
        return 50;
    }
    
    protected ng makeMyCreature() {
        return (ng)mv.a(this.mobID, this.k);
    }
}
