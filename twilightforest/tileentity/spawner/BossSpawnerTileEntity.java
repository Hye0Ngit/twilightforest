// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.MobEntity;

public abstract class BossSpawnerTileEntity<T extends MobEntity> extends TileEntity implements ITickableTileEntity
{
    protected static final int SHORT_RANGE = 9;
    protected static final int LONG_RANGE = 50;
    protected final EntityType<T> entityType;
    protected Entity displayCreature;
    protected boolean spawnedBoss;
    
    protected BossSpawnerTileEntity(final TileEntityType<?> type, final EntityType<T> entityType) {
        super((TileEntityType)type);
        this.displayCreature = null;
        this.spawnedBoss = false;
        this.entityType = entityType;
    }
    
    public boolean anyPlayerInRange() {
        return this.field_145850_b.func_217358_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, (double)this.getRange());
    }
    
    public void func_73660_a() {
        if (this.spawnedBoss || !this.anyPlayerInRange()) {
            return;
        }
        if (this.field_145850_b.field_72995_K) {
            final double rx = this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextFloat();
            final double ry = this.field_174879_c.func_177956_o() + this.field_145850_b.field_73012_v.nextFloat();
            final double rz = this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextFloat();
            this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197601_L, rx, ry, rz, 0.0, 0.0, 0.0);
            this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197631_x, rx, ry, rz, 0.0, 0.0, 0.0);
        }
        else if (this.field_145850_b.func_175659_aa() != Difficulty.PEACEFUL && this.spawnMyBoss((IServerWorld)this.field_145850_b)) {
            this.field_145850_b.func_175655_b(this.field_174879_c, false);
            this.spawnedBoss = true;
        }
    }
    
    protected boolean spawnMyBoss(final IServerWorld world) {
        final T myCreature = this.makeMyCreature();
        myCreature.func_174828_a(this.field_174879_c, world.func_201672_e().field_73012_v.nextFloat() * 360.0f, 0.0f);
        myCreature.func_213386_a(world, world.func_175649_E(this.field_174879_c), SpawnReason.SPAWNER, (ILivingEntityData)null, (CompoundNBT)null);
        this.initializeCreature(myCreature);
        return world.func_217376_c((Entity)myCreature);
    }
    
    protected void initializeCreature(final T myCreature) {
        myCreature.func_213390_a(this.field_174879_c, 46);
    }
    
    protected int getRange() {
        return 9;
    }
    
    protected T makeMyCreature() {
        return (T)this.entityType.func_200721_a(this.field_145850_b);
    }
}
