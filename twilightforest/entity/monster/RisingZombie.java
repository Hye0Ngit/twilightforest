// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;

public class RisingZombie extends Zombie
{
    public RisingZombie(final EntityType<? extends RisingZombie> type, final Level worldIn) {
        super((EntityType)type, worldIn);
    }
    
    protected void m_8099_() {
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficultyIn, final MobSpawnType reason, @Nullable final SpawnGroupData livingdata, @Nullable final CompoundTag dataTag) {
        return livingdata;
    }
    
    public void m_8107_() {
        this.m_20256_(new Vec3(0.0, 0.0, 0.0));
        super.m_8107_();
        if (!this.f_19853_.f_46443_ && this.f_19797_ % 130 == 0) {
            this.m_146870_();
            final Zombie zombie = new Zombie(this.f_19853_);
            zombie.m_6021_(this.m_20185_(), this.m_20186_(), this.m_20189_());
            zombie.m_21051_(Attributes.f_22276_).m_22100_((double)this.m_21233_());
            zombie.m_21153_(this.m_21223_());
            zombie.m_6863_(this.m_6162_());
            this.f_19853_.m_7967_((Entity)zombie);
            if (this.f_19796_.nextBoolean() && this.f_19853_.m_8055_(this.m_142538_().m_7495_()).m_60734_() == Blocks.f_50440_) {
                this.f_19853_.m_46597_(this.m_142538_().m_7495_(), Blocks.f_50493_.m_49966_());
            }
        }
        if (this.f_19853_.f_46443_ && !this.f_19853_.m_46859_(this.m_142538_().m_7495_())) {
            for (int i = 0; i < 5; ++i) {
                this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, this.f_19853_.m_8055_(this.m_142538_().m_7495_())), this.m_20185_() + this.f_19796_.nextGaussian() * 0.009999999776482582, this.m_20186_() + this.f_19796_.nextGaussian() * 0.009999999776482582, this.m_20189_() + this.f_19796_.nextGaussian() * 0.009999999776482582, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void m_147240_(final double strength, final double xRatio, final double zRatio) {
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
}
