// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public abstract class EntityTFIceMob extends EntityMob
{
    public EntityTFIceMob(final World worldIn) {
        super(worldIn);
    }
    
    public void func_70636_d() {
        if (!this.field_70122_E && this.field_70181_x < 0.0) {
            this.field_70181_x *= 0.6;
        }
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
                final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW_GUARDIAN, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
                if (this.field_70170_p.func_180494_b(this.func_180425_c()).func_180626_a(this.func_180425_c()) > 1.0f || this.func_70027_ad()) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.CLOUD, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.10000000149011612, 0.0, new int[0]);
                    this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_DROP, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
        if (this.field_70170_p.func_180494_b(this.func_180425_c()).func_180626_a(this.func_180425_c()) > 1.0f && this.field_70173_aa % 20 == 0) {
            this.func_70097_a(DamageSource.field_76370_b, 1.0f);
        }
    }
    
    public void func_180430_e(final float distance, final float damageMultiplier) {
    }
    
    protected void func_184231_a(final double y, final boolean onGroundIn, final IBlockState state, final BlockPos pos) {
    }
}
