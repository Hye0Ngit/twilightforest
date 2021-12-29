// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import java.util.Iterator;
import java.util.List;
import net.minecraft.potion.EffectInstance;
import twilightforest.potions.TFPotions;
import net.minecraft.potion.Effect;
import net.minecraft.entity.Entity;
import twilightforest.util.TFDamageSources;
import twilightforest.entity.YetiEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorldReader;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import twilightforest.entity.projectile.TFThrowableEntity;

public class IceBombEntity extends TFThrowableEntity
{
    private int zoneTimer;
    private boolean hasHit;
    
    public IceBombEntity(final EntityType<? extends IceBombEntity> type, final World world) {
        super(type, world);
        this.zoneTimer = 80;
    }
    
    public IceBombEntity(final EntityType<? extends IceBombEntity> type, final World world, final LivingEntity thrower) {
        super(type, world, thrower);
        this.zoneTimer = 80;
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        this.func_213293_j(0.0, 0.0, 0.0);
        this.hasHit = true;
        this.doTerrainEffects();
    }
    
    private void doTerrainEffects() {
        final int range = 3;
        final int ix = MathHelper.func_76128_c(this.field_70142_S);
        final int iy = MathHelper.func_76128_c(this.field_70137_T);
        final int iz = MathHelper.func_76128_c(this.field_70136_U);
        for (int x = -3; x <= 3; ++x) {
            for (int y = -3; y <= 3; ++y) {
                for (int z = -3; z <= 3; ++z) {
                    final BlockPos pos = new BlockPos(ix + x, iy + y, iz + z);
                    this.doTerrainEffect(pos);
                }
            }
        }
    }
    
    private void doTerrainEffect(final BlockPos pos) {
        final BlockState state = this.field_70170_p.func_180495_p(pos);
        if (state.func_185904_a() == Material.field_151586_h) {
            this.field_70170_p.func_175656_a(pos, Blocks.field_150432_aD.func_176223_P());
        }
        if (state.getBlockState() == Blocks.field_150353_l.func_176223_P()) {
            this.field_70170_p.func_175656_a(pos, Blocks.field_150343_Z.func_176223_P());
        }
        if (this.field_70170_p.func_175623_d(pos) && Blocks.field_150433_aE.func_176223_P().func_196955_c((IWorldReader)this.field_70170_p, pos)) {
            this.field_70170_p.func_175656_a(pos, Blocks.field_150433_aE.func_176223_P());
        }
        if (this.field_70170_p.func_180495_p(pos) == Blocks.field_150349_c.func_176223_P() || this.field_70170_p.func_180495_p(pos) == Blocks.field_196804_gh.func_176223_P()) {
            this.field_70170_p.func_180501_a(pos, Blocks.field_150433_aE.func_176223_P(), 3);
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.hasHit) {
            this.func_213322_ci().func_216372_d(0.1, 0.1, 0.1);
            --this.zoneTimer;
            this.makeIceZone();
            if (!this.field_70170_p.field_72995_K && this.zoneTimer <= 0) {
                this.field_70170_p.func_217379_c(2001, new BlockPos((Vector3i)this.func_233580_cy_()), Block.func_196246_j(Blocks.field_150432_aD.func_176223_P()));
                this.func_70106_y();
            }
        }
        else {
            this.makeTrail();
        }
    }
    
    public void makeTrail() {
        final BlockState stateId = Blocks.field_150433_aE.func_176223_P();
        for (int i = 0; i < 5; ++i) {
            final double dx = this.func_226277_ct_() + 1.5f * (this.field_70146_Z.nextFloat() - 0.5f);
            final double dy = this.func_226278_cu_() + 1.5f * (this.field_70146_Z.nextFloat() - 0.5f);
            final double dz = this.func_226281_cx_() + 1.5f * (this.field_70146_Z.nextFloat() - 0.5f);
            this.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197628_u, stateId), dx, dy, dz, -this.func_213322_ci().func_82615_a(), -this.func_213322_ci().func_82617_b(), -this.func_213322_ci().func_82616_c());
        }
    }
    
    private void makeIceZone() {
        if (this.field_70170_p.field_72995_K) {
            final BlockState stateId = Blocks.field_150433_aE.func_176223_P();
            for (int i = 0; i < 15; ++i) {
                final double dx = this.func_226277_ct_() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                final double dy = this.func_226278_cu_() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                final double dz = this.func_226281_cx_() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 3.0f;
                this.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197628_u, stateId), dx, dy, dz, 0.0, 0.0, 0.0);
            }
        }
        else if (this.zoneTimer % 10 == 0) {
            this.hitNearbyEntities();
        }
    }
    
    private void hitNearbyEntities() {
        final List<LivingEntity> nearby = this.field_70170_p.func_217357_a((Class)LivingEntity.class, this.func_174813_aQ().func_72314_b(3.0, 2.0, 3.0));
        for (final LivingEntity entity : nearby) {
            if (entity != this.func_234616_v_()) {
                if (entity instanceof YetiEntity) {
                    final BlockPos pos = new BlockPos(entity.field_70142_S, entity.field_70137_T, entity.field_70136_U);
                    this.field_70170_p.func_175656_a(pos, Blocks.field_150432_aD.func_176223_P());
                    this.field_70170_p.func_175656_a(pos.func_177984_a(), Blocks.field_150432_aD.func_176223_P());
                    entity.func_70106_y();
                }
                else {
                    entity.func_70097_a(TFDamageSources.FROZEN((Entity)this, (LivingEntity)this.func_234616_v_()), 1.0f);
                    entity.func_195064_c(new EffectInstance((Effect)TFPotions.frosty.get(), 100, 2));
                }
            }
        }
    }
    
    public BlockState getBlockState() {
        return Blocks.field_150403_cj.func_176223_P();
    }
    
    protected float func_70185_h() {
        return this.hasHit ? 0.0f : 0.025f;
    }
}
