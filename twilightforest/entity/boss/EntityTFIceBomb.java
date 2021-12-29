// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import java.util.Iterator;
import java.util.List;
import net.minecraft.potion.PotionEffect;
import twilightforest.potions.TFPotions;
import net.minecraft.util.DamageSource;
import twilightforest.entity.EntityTFYeti;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import twilightforest.entity.EntityTFThrowable;

public class EntityTFIceBomb extends EntityTFThrowable
{
    private int zoneTimer;
    private boolean hasHit;
    
    public EntityTFIceBomb(final World world) {
        super(world);
        this.zoneTimer = 80;
    }
    
    public EntityTFIceBomb(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
        this.zoneTimer = 80;
    }
    
    protected void func_70184_a(final RayTraceResult ray) {
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
        for (int x = -3; x <= 3; ++x) {
            for (int y = -3; y <= 3; ++y) {
                for (int z = -3; z <= 3; ++z) {
                    this.doTerrainEffect(new BlockPos(ix + x, iy + y, iz + z));
                }
            }
        }
    }
    
    private void doTerrainEffect(final BlockPos pos) {
        final IBlockState state = this.field_70170_p.func_180495_p(pos);
        if (state.func_185904_a() == Material.field_151586_h) {
            this.field_70170_p.func_175656_a(pos, Blocks.field_150432_aD.func_176223_P());
        }
        if (state.func_185904_a() == Material.field_151587_i) {
            this.field_70170_p.func_175656_a(pos, Blocks.field_150343_Z.func_176223_P());
        }
        if (this.field_70170_p.func_175623_d(pos) && Blocks.field_150431_aC.func_176196_c(this.field_70170_p, pos)) {
            this.field_70170_p.func_175656_a(pos, Blocks.field_150431_aC.func_176223_P());
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.hasHit) {
            this.field_70159_w *= 0.1;
            this.field_70181_x *= 0.1;
            this.field_70179_y *= 0.1;
            --this.zoneTimer;
            this.makeIceZone();
            if (!this.field_70170_p.field_72995_K && this.zoneTimer <= 0) {
                this.field_70170_p.func_175718_b(2001, new BlockPos((Entity)this), Block.func_176210_f(Blocks.field_150432_aD.func_176223_P()));
                this.func_70106_y();
            }
        }
        else {
            this.makeTrail();
        }
    }
    
    public void makeTrail() {
        final int stateId = Block.func_176210_f(Blocks.field_150433_aE.func_176223_P());
        for (int i = 0; i < 10; ++i) {
            final double dx = this.field_70165_t + 0.75f * (this.field_70146_Z.nextFloat() - 0.5f);
            final double dy = this.field_70163_u + 0.75f * (this.field_70146_Z.nextFloat() - 0.5f);
            final double dz = this.field_70161_v + 0.75f * (this.field_70146_Z.nextFloat() - 0.5f);
            this.field_70170_p.func_175688_a(EnumParticleTypes.FALLING_DUST, dx, dy, dz, -this.field_70159_w, -this.field_70181_x, -this.field_70179_y, new int[] { stateId });
        }
    }
    
    private void makeIceZone() {
        if (this.field_70170_p.field_72995_K) {
            final int stateId = Block.func_176210_f(Blocks.field_150433_aE.func_176223_P());
            for (int i = 0; i < 20; ++i) {
                final double dx = this.field_70165_t + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                final double dy = this.field_70163_u + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                final double dz = this.field_70161_v + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                this.field_70170_p.func_175688_a(EnumParticleTypes.FALLING_DUST, dx, dy, dz, 0.0, 0.0, 0.0, new int[] { stateId });
            }
        }
        else if (this.zoneTimer % 10 == 0) {
            this.hitNearbyEntities();
        }
    }
    
    private void hitNearbyEntities() {
        final List<EntityLivingBase> nearby = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.func_174813_aQ().func_72314_b(3.0, 2.0, 3.0));
        for (final EntityLivingBase entity : nearby) {
            if (entity != this.func_85052_h()) {
                if (entity instanceof EntityTFYeti) {
                    final BlockPos pos = new BlockPos(entity.field_70142_S, entity.field_70137_T, entity.field_70136_U);
                    this.field_70170_p.func_175656_a(pos, Blocks.field_150432_aD.func_176223_P());
                    this.field_70170_p.func_175656_a(pos.func_177984_a(), Blocks.field_150432_aD.func_176223_P());
                    entity.func_70106_y();
                }
                else {
                    entity.func_70097_a(DamageSource.field_76376_m, 1.0f);
                    entity.func_70690_d(new PotionEffect(TFPotions.frosty, 100, 2));
                }
            }
        }
    }
    
    public IBlockState getBlock() {
        return Blocks.field_150403_cj.func_176223_P();
    }
    
    protected float func_70185_h() {
        return this.hasHit ? 0.0f : 0.025f;
    }
}
