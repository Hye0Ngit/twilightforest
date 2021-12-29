// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityLivingBase;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.MultiPartEntityPart;

public class EntityTFNagaSegment extends MultiPartEntityPart
{
    private final EntityTFNaga naga;
    private final int segment;
    private int deathCounter;
    
    public EntityTFNagaSegment(final EntityTFNaga myNaga, final int segNum) {
        super((IEntityMultiPart)myNaga, "segment" + segNum, 0.0f, 0.0f);
        this.naga = myNaga;
        this.segment = segNum;
        this.field_70138_W = 2.0f;
        this.deactivate();
    }
    
    public boolean func_70097_a(final DamageSource src, final float damage) {
        return super.func_70097_a(src, damage * 2.0f / 3.0f);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.field_70173_aa;
        if (!this.func_82150_aj()) {
            this.collideWithOthers();
        }
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter <= 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    final EnumParticleTypes explosionType = this.field_70146_Z.nextBoolean() ? EnumParticleTypes.EXPLOSION_LARGE : EnumParticleTypes.EXPLOSION_NORMAL;
                    this.field_70170_p.func_175688_a(explosionType, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3, new int[0]);
                }
                this.deactivate();
            }
        }
    }
    
    private void collideWithOthers() {
        final List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ().func_72314_b(0.2, 0.0, 0.2));
        for (final Entity entity : list) {
            if (entity.func_70104_M()) {
                this.collideWithEntity(entity);
            }
        }
    }
    
    private void collideWithEntity(final Entity entity) {
        entity.func_70108_f((Entity)this);
        if (entity instanceof EntityLivingBase && !(entity instanceof EntityTFNaga) && !(entity instanceof EntityTFNagaSegment)) {
            int attackStrength = 2;
            if (entity instanceof EntityAnimal) {
                attackStrength *= 3;
            }
            entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.naga), (float)attackStrength);
        }
    }
    
    public void deactivate() {
        this.func_70105_a(0.0f, 0.0f);
        this.func_82142_c(true);
    }
    
    public void activate() {
        this.func_70105_a(1.8f, 1.8f);
        this.func_82142_c(false);
    }
    
    public void func_70101_b(final float yaw, final float pitch) {
        super.func_70101_b(yaw, pitch);
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
    }
    
    public void selfDestruct() {
        this.deathCounter = 10;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
}
