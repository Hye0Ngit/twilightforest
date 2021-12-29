// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityTFBossSpawner extends TileEntity implements ITickable
{
    protected static final int SHORT_RANGE = 9;
    protected static final int LONG_RANGE = 50;
    protected final ResourceLocation mobID;
    protected Entity displayCreature;
    protected boolean spawnedBoss;
    
    protected TileEntityTFBossSpawner(final ResourceLocation mobID) {
        this.displayCreature = null;
        this.spawnedBoss = false;
        this.mobID = mobID;
    }
    
    public boolean anyPlayerInRange() {
        return this.field_145850_b.func_175636_b(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, (double)this.getRange());
    }
    
    public void func_73660_a() {
        if (this.spawnedBoss || !this.anyPlayerInRange()) {
            return;
        }
        if (this.field_145850_b.field_72995_K) {
            final double rx = this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextFloat();
            final double ry = this.field_174879_c.func_177956_o() + this.field_145850_b.field_73012_v.nextFloat();
            final double rz = this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextFloat();
            this.field_145850_b.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, rx, ry, rz, 0.0, 0.0, 0.0, new int[0]);
            this.field_145850_b.func_175688_a(EnumParticleTypes.FLAME, rx, ry, rz, 0.0, 0.0, 0.0, new int[0]);
        }
        else if (this.field_145850_b.func_175659_aa() != EnumDifficulty.PEACEFUL && this.spawnMyBoss()) {
            this.field_145850_b.func_175655_b(this.field_174879_c, false);
            this.spawnedBoss = true;
        }
    }
    
    protected boolean spawnMyBoss() {
        final EntityLiving myCreature = this.makeMyCreature();
        myCreature.func_174828_a(this.field_174879_c, this.field_145850_b.field_73012_v.nextFloat() * 360.0f, 0.0f);
        myCreature.func_180482_a(this.field_145850_b.func_175649_E(this.field_174879_c), (IEntityLivingData)null);
        this.initializeCreature(myCreature);
        return this.field_145850_b.func_72838_d((Entity)myCreature);
    }
    
    public Entity getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = (Entity)this.makeMyCreature();
        }
        return this.displayCreature;
    }
    
    protected void initializeCreature(final EntityLiving myCreature) {
        if (myCreature instanceof EntityCreature) {
            ((EntityCreature)myCreature).func_175449_a(this.field_174879_c, 46);
        }
    }
    
    protected int getRange() {
        return 9;
    }
    
    protected EntityLiving makeMyCreature() {
        return (EntityLiving)EntityList.func_188429_b(this.mobID, this.field_145850_b);
    }
}
