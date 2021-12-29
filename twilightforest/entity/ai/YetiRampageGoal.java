// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.projectile.IceBomb;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.Entity;
import twilightforest.TFSounds;
import java.util.EnumSet;
import twilightforest.entity.boss.AlphaYeti;
import net.minecraft.world.entity.ai.goal.Goal;

public class YetiRampageGoal extends Goal
{
    private AlphaYeti yeti;
    private int currentTimeOut;
    private int currentDuration;
    private int maxTantrumTimeOut;
    private int tantrumDuration;
    
    public YetiRampageGoal(final AlphaYeti entityTFYetiAlpha, final int timeout, final int duration) {
        this.yeti = entityTFYetiAlpha;
        this.currentTimeOut = timeout;
        this.maxTantrumTimeOut = timeout;
        this.tantrumDuration = duration;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }
    
    public boolean m_8036_() {
        if (this.yeti.m_5448_() != null && this.yeti.canRampage()) {
            --this.currentTimeOut;
        }
        return this.currentTimeOut <= 0;
    }
    
    public void m_8056_() {
        this.currentDuration = this.tantrumDuration;
        this.yeti.setRampaging(true);
        this.yeti.m_5496_(TFSounds.ALPHAYETI_ROAR, 4.0f, 0.5f + this.yeti.m_21187_().nextFloat() * 0.5f);
    }
    
    public boolean m_8045_() {
        return this.currentDuration > 0;
    }
    
    public void m_8037_() {
        --this.currentDuration;
        if (this.yeti.m_5448_() != null) {
            this.yeti.m_21563_().m_24960_((Entity)this.yeti.m_5448_(), 10.0f, (float)this.yeti.m_8132_());
        }
        if (this.yeti.m_20096_()) {
            this.yeti.m_20334_(0.0, 0.4, 0.0);
        }
        this.yeti.destroyBlocksInAABB(this.yeti.m_142469_().m_82377_(1.0, 2.0, 1.0).m_82386_(0.0, 2.0, 0.0));
        if (this.currentDuration % 20 == 0) {
            this.yeti.makeRandomBlockFall();
        }
        if (this.currentDuration % 40 == 0) {
            this.yeti.makeBlockAboveTargetFall();
        }
        if (this.currentDuration < 40 && this.currentDuration % 10 == 0) {
            this.yeti.makeNearbyBlockFall();
        }
        if (this.currentDuration % 10 == 0) {
            final IceBomb ice = new IceBomb(TFEntities.THROWN_ICE, this.yeti.f_19853_, (LivingEntity)this.yeti);
            final Vec3 vec = new Vec3((double)(0.5f + this.yeti.m_21187_().nextFloat() * 0.5f), (double)(0.5f + this.yeti.m_21187_().nextFloat() * 0.3f), 0.0).m_82524_(this.yeti.m_21187_().nextFloat() * 360.0f);
            ice.m_6686_(vec.f_82479_, vec.f_82480_, vec.f_82481_, 0.4f + this.yeti.m_21187_().nextFloat() * 0.3f, 0.0f);
            this.yeti.m_5496_(TFSounds.ALPHAYETI_ICE, 1.0f, 1.0f / (this.yeti.m_21187_().nextFloat() * 0.4f + 0.8f));
            this.yeti.f_19853_.m_7967_((Entity)ice);
        }
    }
    
    public void m_8041_() {
        this.currentTimeOut = this.maxTantrumTimeOut;
        this.yeti.setRampaging(false);
        this.yeti.setTired(true);
    }
}
