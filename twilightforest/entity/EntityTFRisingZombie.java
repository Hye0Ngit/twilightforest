// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.block.Block;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import javax.annotation.Nullable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityZombie;

public class EntityTFRisingZombie extends EntityZombie
{
    public EntityTFRisingZombie(final World worldIn) {
        super(worldIn);
    }
    
    protected void func_184651_r() {
    }
    
    @Nullable
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, @Nullable final IEntityLivingData livingdata) {
        return livingdata;
    }
    
    public void func_70636_d() {
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 130 == 0) {
            this.func_70106_y();
            final EntityZombie zombie = new EntityZombie(this.field_70170_p);
            zombie.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            zombie.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.func_110138_aP());
            zombie.func_70606_j(this.func_110143_aJ());
            zombie.func_82227_f(this.func_70631_g_());
            this.field_70170_p.func_72838_d((Entity)zombie);
            if (this.field_70146_Z.nextBoolean() && this.field_70170_p.func_180495_p(this.func_180425_c().func_177977_b()).func_177230_c() == Blocks.field_150349_c) {
                this.field_70170_p.func_175656_a(this.func_180425_c().func_177977_b(), Blocks.field_150346_d.func_176223_P());
            }
        }
        if (this.field_70170_p.field_72995_K && !this.field_70170_p.func_175623_d(this.func_180425_c().func_177977_b())) {
            for (int i = 0; i < 5; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t + this.field_70146_Z.nextGaussian() * 0.009999999776482582, this.field_70163_u + this.field_70146_Z.nextGaussian() * 0.009999999776482582, this.field_70161_v + this.field_70146_Z.nextGaussian() * 0.009999999776482582, 0.0, 0.0, 0.0, new int[] { Block.func_176210_f(this.field_70170_p.func_180495_p(this.func_180425_c().func_177977_b())) });
            }
        }
    }
    
    public void func_70653_a(final Entity entityIn, final float strength, final double xRatio, final double zRatio) {
    }
}
