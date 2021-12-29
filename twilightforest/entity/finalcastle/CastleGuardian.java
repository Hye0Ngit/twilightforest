// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.finalcastle;

import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;

public class CastleGuardian extends PathfinderMob
{
    public CastleGuardian(final EntityType<? extends CastleGuardian> type, final Level worldIn) {
        super((EntityType)type, worldIn);
    }
    
    protected void m_8099_() {
    }
    
    protected float m_5632_(final float renderYawOffset, float p_110146_2_) {
        final float f = Mth.m_14177_(renderYawOffset - this.f_20883_);
        this.f_20883_ += f * 0.5f;
        float f2 = Mth.m_14177_(this.m_146908_() - this.f_20883_);
        final boolean flag = f2 < -90.0f || f2 >= 90.0f;
        if (f2 < -75.0f) {
            f2 = -75.0f;
        }
        if (f2 >= 75.0f) {
            f2 = 75.0f;
        }
        this.f_20883_ = this.m_146908_() - f2;
        if (f2 * f2 > 2500.0f) {
            this.f_20883_ += f2 * 0.5f;
        }
        if (flag) {
            p_110146_2_ *= -1.0f;
        }
        return p_110146_2_;
    }
    
    public boolean m_5829_() {
        return true;
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    public boolean m_6063_() {
        return false;
    }
    
    public float m_20236_(final Pose pose) {
        return 1.865f;
    }
    
    public boolean m_6040_() {
        return false;
    }
}
