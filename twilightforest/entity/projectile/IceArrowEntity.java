// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.potion.EffectInstance;
import twilightforest.potions.TFPotions;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.block.BlockState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.Blocks;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class IceArrowEntity extends TFArrowEntity
{
    public IceArrowEntity(final EntityType<? extends IceArrowEntity> type, final World world) {
        super(type, world);
    }
    
    public IceArrowEntity(final World world, final LivingEntity shooter) {
        super(TFEntities.ice_arrow, world, shooter);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K && !this.field_70254_i) {
            final BlockState stateId = Blocks.field_150433_aE.func_176223_P();
            for (int i = 0; i < 4; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197628_u, stateId), this.func_226277_ct_() + this.func_213322_ci().func_82615_a() * i / 4.0, this.func_226278_cu_() + this.func_213322_ci().func_82617_b() * i / 4.0, this.func_226281_cx_() + this.func_213322_ci().func_82616_c() * i / 4.0, -this.func_213322_ci().func_82615_a(), -this.func_213322_ci().func_82617_b() + 0.2, -this.func_213322_ci().func_82616_c());
            }
        }
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        super.func_70227_a(ray);
        if (ray instanceof EntityRayTraceResult && !this.field_70170_p.field_72995_K && ((EntityRayTraceResult)ray).func_216348_a() instanceof LivingEntity) {
            final int chillLevel = 2;
            ((LivingEntity)((EntityRayTraceResult)ray).func_216348_a()).func_195064_c(new EffectInstance((Effect)TFPotions.frosty.get(), 200, chillLevel));
        }
    }
}
