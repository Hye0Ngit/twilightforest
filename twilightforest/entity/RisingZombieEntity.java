// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;

public class RisingZombieEntity extends ZombieEntity
{
    public RisingZombieEntity(final EntityType<? extends RisingZombieEntity> type, final World worldIn) {
        super((EntityType)type, worldIn);
    }
    
    protected void func_184651_r() {
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficultyIn, final SpawnReason reason, @Nullable final ILivingEntityData livingdata, @Nullable final CompoundNBT dataTag) {
        return livingdata;
    }
    
    public void func_70636_d() {
        this.func_213317_d(new Vector3d(0.0, 0.0, 0.0));
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 130 == 0) {
            this.func_70106_y();
            final ZombieEntity zombie = new ZombieEntity(this.field_70170_p);
            zombie.func_70634_a(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
            zombie.func_110148_a(Attributes.field_233818_a_).func_111128_a((double)this.func_110138_aP());
            zombie.func_70606_j(this.func_110143_aJ());
            zombie.func_82227_f(this.func_70631_g_());
            this.field_70170_p.func_217376_c((Entity)zombie);
            if (this.field_70146_Z.nextBoolean() && this.field_70170_p.func_180495_p(this.func_233580_cy_().func_177977_b()).func_177230_c() == Blocks.field_196658_i) {
                this.field_70170_p.func_175656_a(this.func_233580_cy_().func_177977_b(), Blocks.field_150346_d.func_176223_P());
            }
        }
        if (this.field_70170_p.field_72995_K && !this.field_70170_p.func_175623_d(this.func_233580_cy_().func_177977_b())) {
            for (int i = 0; i < 5; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, this.field_70170_p.func_180495_p(this.func_233580_cy_().func_177977_b())), this.func_226277_ct_() + this.field_70146_Z.nextGaussian() * 0.009999999776482582, this.func_226278_cu_() + this.field_70146_Z.nextGaussian() * 0.009999999776482582, this.func_226281_cx_() + this.field_70146_Z.nextGaussian() * 0.009999999776482582, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void func_233627_a_(final float strength, final double xRatio, final double zRatio) {
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
}
