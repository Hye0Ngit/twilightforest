// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public abstract class IceMobEntity extends MonsterEntity
{
    public IceMobEntity(final EntityType<? extends IceMobEntity> type, final World worldIn) {
        super((EntityType)type, worldIn);
    }
    
    public void func_70636_d() {
        if (!this.field_70122_E && this.func_213322_ci().func_82617_b() < 0.0) {
            final Vector3d motion = this.func_213322_ci();
            this.func_213293_j(motion.field_72450_a, motion.field_72448_b * 0.6, motion.field_72449_c);
        }
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
                final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
                this.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW_GUARDIAN.get(), this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
                if (this.field_70170_p.func_226691_t_(this.func_233580_cy_()).func_225486_c(this.func_233580_cy_()) > 1.0f || this.func_70027_ad()) {
                    this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197613_f, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.10000000149011612, 0.0);
                    this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197618_k, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
                }
            }
        }
        if (this.field_70170_p.func_226691_t_(this.func_233580_cy_()).func_225486_c(this.func_233580_cy_()) > 1.0f && this.field_70173_aa % 20 == 0) {
            this.func_70097_a(DamageSource.field_76370_b, 1.0f);
        }
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_225503_b_(final float distance, final float damageMultiplier) {
        return false;
    }
    
    protected void func_184231_a(final double y, final boolean onGroundIn, final BlockState state, final BlockPos pos) {
    }
}
