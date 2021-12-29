// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

public abstract class TileEntityTFBossSpawner extends asm
{
    protected String mobID;
    protected int counter;
    protected nm displayCreature;
    
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
                this.spawnMyBoss();
                this.k.f(this.l, this.m, this.n, 0, 0, 2);
            }
        }
    }
    
    protected void spawnMyBoss() {
        final of myCreature = this.makeMyCreature();
        final double rx = this.l + 0.5;
        final double ry = this.m + 0.5;
        final double rz = this.n + 0.5;
        myCreature.b(rx, ry, rz, this.k.s.nextFloat() * 360.0f, 0.0f);
        this.initializeCreature(myCreature);
        this.k.d((nm)myCreature);
    }
    
    public nm getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = (nm)this.makeMyCreature();
        }
        return this.displayCreature;
    }
    
    protected void initializeCreature(final of myCreature) {
        if (myCreature instanceof om) {
            ((om)myCreature).b(this.l, this.m, this.n, 46);
        }
    }
    
    protected int getRange() {
        return 50;
    }
    
    protected of makeMyCreature() {
        return (of)ns.a(this.mobID, this.k);
    }
}
