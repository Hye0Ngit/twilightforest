// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import twilightforest.entity.ai.CubeCenterOnSymbolGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.ai.CubeMoveToRedstoneSymbolsGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class RovingCube extends Monster
{
    public boolean hasFoundSymbol;
    public int symbolX;
    public int symbolY;
    public int symbolZ;
    
    public RovingCube(final EntityType<? extends RovingCube> type, final Level world) {
        super((EntityType)type, world);
        this.hasFoundSymbol = false;
        this.symbolX = 0;
        this.symbolY = 0;
        this.symbolZ = 0;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new CubeMoveToRedstoneSymbolsGoal(this, 1.0));
        this.f_21345_.m_25352_(1, (Goal)new CubeCenterOnSymbolGoal(this, 1.0));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, 0.23000000417232513).m_22268_(Attributes.f_22281_, 5.0);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.f_19853_.f_46443_) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 2.0f;
                final float py = this.m_20192_() - 0.25f + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 2.0f;
                final float pz = (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 2.0f;
                this.f_19853_.m_7106_((ParticleOptions)TFParticleType.ANNIHILATE.get(), this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.0, 0.0);
            }
        }
    }
}
