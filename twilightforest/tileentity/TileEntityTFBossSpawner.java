// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityTFBossSpawner extends TileEntity
{
    protected String mobID;
    protected int counter;
    protected Entity displayCreature;
    
    public TileEntityTFBossSpawner() {
        this.mobID = "Pig";
        this.displayCreature = null;
    }
    
    public boolean anyPlayerInRange() {
        return this.field_70331_k.func_72977_a(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, (double)this.getRange()) != null;
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void func_70316_g() {
        ++this.counter;
        if (this.anyPlayerInRange()) {
            if (this.field_70331_k.field_72995_K) {
                final double rx = this.field_70329_l + this.field_70331_k.field_73012_v.nextFloat();
                final double ry = this.field_70330_m + this.field_70331_k.field_73012_v.nextFloat();
                final double rz = this.field_70327_n + this.field_70331_k.field_73012_v.nextFloat();
                this.field_70331_k.func_72869_a("smoke", rx, ry, rz, 0.0, 0.0, 0.0);
                this.field_70331_k.func_72869_a("flame", rx, ry, rz, 0.0, 0.0, 0.0);
            }
            else if (this.field_70331_k.field_73013_u > 0) {
                this.spawnMyBoss();
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, 0, 0, 2);
            }
        }
    }
    
    protected void spawnMyBoss() {
        final EntityLiving myCreature = this.makeMyCreature();
        final double rx = this.field_70329_l + 0.5;
        final double ry = this.field_70330_m + 0.5;
        final double rz = this.field_70327_n + 0.5;
        myCreature.func_70012_b(rx, ry, rz, this.field_70331_k.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this.initializeCreature(myCreature);
        this.field_70331_k.func_72838_d((Entity)myCreature);
    }
    
    public Entity getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = (Entity)this.makeMyCreature();
        }
        return this.displayCreature;
    }
    
    protected void initializeCreature(final EntityLiving myCreature) {
        myCreature.func_70598_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.getRange());
    }
    
    protected int getRange() {
        return 50;
    }
    
    protected EntityLiving makeMyCreature() {
        return (EntityLiving)EntityList.func_75620_a(this.mobID, this.field_70331_k);
    }
}
