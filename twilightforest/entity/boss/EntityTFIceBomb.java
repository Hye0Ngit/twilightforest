// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.block.Block;
import java.util.Iterator;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import twilightforest.entity.EntityTFYeti;
import java.util.Collection;
import java.util.ArrayList;
import twilightforest.TwilightForestMod;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFIceBomb extends EntityThrowable
{
    private int zoneTimer;
    private boolean hasHit;
    
    public EntityTFIceBomb(final World par1World) {
        super(par1World);
        this.zoneTimer = 80;
    }
    
    public EntityTFIceBomb(final World par1World, final EntityLivingBase thrower) {
        super(par1World, thrower);
        this.zoneTimer = 80;
    }
    
    protected void func_70184_a(final MovingObjectPosition mop) {
        if (this.func_85052_h() != null && this.func_85052_h() instanceof EntityTFYetiAlpha) {
            final double dist = this.func_70068_e((Entity)this.func_85052_h());
            if (dist <= 100.0) {
                this.func_70106_y();
            }
        }
        this.field_70181_x = 0.0;
        this.hasHit = true;
        if (!this.field_70170_p.field_72995_K) {
            this.doTerrainEffects();
        }
    }
    
    private void doTerrainEffects() {
        final int range = 3;
        final int ix = MathHelper.func_76128_c(this.field_70142_S);
        final int iy = MathHelper.func_76128_c(this.field_70137_T);
        final int iz = MathHelper.func_76128_c(this.field_70136_U);
        for (int x = -range; x <= range; ++x) {
            for (int y = -range; y <= range; ++y) {
                for (int z = -range; z <= range; ++z) {
                    this.doTerrainEffect(ix + x, iy + y, iz + z);
                }
            }
        }
    }
    
    private void doTerrainEffect(final int x, final int y, final int z) {
        if (this.field_70170_p.func_147439_a(x, y, z).func_149688_o() == Material.field_151586_h) {
            this.field_70170_p.func_147449_b(x, y, z, Blocks.field_150432_aD);
        }
        if (this.field_70170_p.func_147439_a(x, y, z).func_149688_o() == Material.field_151587_i) {
            this.field_70170_p.func_147449_b(x, y, z, Blocks.field_150343_Z);
        }
        if (this.field_70170_p.func_147437_c(x, y, z) && Blocks.field_150431_aC.func_149742_c(this.field_70170_p, x, y, z)) {
            this.field_70170_p.func_147449_b(x, y, z, Blocks.field_150431_aC);
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.hasHit) {
            if (!this.field_70170_p.field_72995_K) {
                this.field_70159_w *= 0.1;
                this.field_70181_x *= 0.1;
                this.field_70179_y *= 0.1;
            }
            --this.zoneTimer;
            this.makeIceZone();
            if (this.zoneTimer <= 0) {
                this.detonate();
            }
        }
        else {
            this.makeTrail();
        }
    }
    
    public void makeTrail() {
        for (int i = 0; i < 10; ++i) {
            final double dx = this.field_70165_t + 0.75f * (this.field_70146_Z.nextFloat() - 0.5f);
            final double dy = this.field_70163_u + 0.75f * (this.field_70146_Z.nextFloat() - 0.5f);
            final double dz = this.field_70161_v + 0.75f * (this.field_70146_Z.nextFloat() - 0.5f);
            TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowstuff", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    private void makeIceZone() {
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 20; ++i) {
                final double dx = this.field_70165_t + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                final double dy = this.field_70163_u + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                final double dz = this.field_70161_v + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowstuff", dx, dy, dz, 0.0, 0.0, 0.0);
            }
        }
        else if (this.zoneTimer % 10 == 0) {
            this.hitNearbyEntities();
        }
    }
    
    private void hitNearbyEntities() {
        final ArrayList<Entity> nearby = new ArrayList<Entity>(this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(3.0, 2.0, 3.0)));
        for (final Entity entity : nearby) {
            if (entity instanceof EntityLivingBase && entity != this.func_85052_h()) {
                if (entity instanceof EntityTFYeti) {
                    entity.func_70106_y();
                    final int ix = MathHelper.func_76128_c(entity.field_70142_S);
                    final int iy = MathHelper.func_76128_c(entity.field_70137_T);
                    final int iz = MathHelper.func_76128_c(entity.field_70136_U);
                    this.field_70170_p.func_147449_b(ix, iy, iz, Blocks.field_150432_aD);
                    this.field_70170_p.func_147449_b(ix, iy + 1, iz, Blocks.field_150432_aD);
                }
                else {
                    entity.func_70097_a(DamageSource.field_76376_m, 1.0f);
                    final int chillLevel = 2;
                    ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 100, chillLevel, true));
                }
            }
        }
    }
    
    private void detonate() {
        this.func_70106_y();
    }
    
    public Block getBlock() {
        return Blocks.field_150403_cj;
    }
    
    protected float func_70182_d() {
        return 0.75f;
    }
    
    protected float func_70185_h() {
        return this.hasHit ? 0.0f : 0.025f;
    }
    
    protected float func_70183_g() {
        return -20.0f;
    }
}
