// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import net.minecraft.world.entity.EquipmentSlot;
import twilightforest.entity.monster.Kobold;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

public class FlockToSameKindGoal extends Goal
{
    private static final double MAX_DIST = 256.0;
    private static final double MIN_DIST = 25.0;
    private Mob flockCreature;
    private Vec3 flockPosition;
    double speed;
    private int moveTimer;
    
    public FlockToSameKindGoal(final Mob living, final double speed) {
        this.flockCreature = living;
        this.speed = speed;
    }
    
    public boolean m_8036_() {
        final Mob flockCreature = this.flockCreature;
        if (flockCreature instanceof final Kobold kobold) {
            if (kobold.m_6844_(EquipmentSlot.MAINHAND).m_150922_((Tag)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS)) {
                return false;
            }
        }
        if (this.flockCreature.m_21187_().nextInt(40) != 0) {
            return false;
        }
        final List<? extends Mob> flockList = this.flockCreature.f_19853_.m_45976_((Class)this.flockCreature.getClass(), this.flockCreature.m_142469_().m_82377_(16.0, 4.0, 16.0));
        if (flockList.size() > 5) {
            return false;
        }
        int flocknum = 0;
        double flockX = 0.0;
        double flockY = 0.0;
        double flockZ = 0.0;
        for (final LivingEntity flocker : flockList) {
            ++flocknum;
            flockX += flocker.m_20185_();
            flockY += flocker.m_20186_();
            flockZ += flocker.m_20189_();
        }
        flockX /= flocknum;
        flockY /= flocknum;
        flockZ /= flocknum;
        if (this.flockCreature.m_20275_(flockX, flockY, flockZ) < 25.0) {
            return false;
        }
        this.flockPosition = new Vec3(flockX, flockY, flockZ);
        return true;
    }
    
    public boolean m_8045_() {
        if (this.flockPosition == null) {
            return false;
        }
        final double distance = this.flockCreature.m_20275_(this.flockPosition.f_82479_, this.flockPosition.f_82480_, this.flockPosition.f_82481_);
        return distance >= 25.0 && distance <= 256.0;
    }
    
    public void m_8056_() {
        this.moveTimer = 0;
    }
    
    public void m_8041_() {
        this.flockPosition = null;
    }
    
    public void m_8037_() {
        final int moveTimer = this.moveTimer - 1;
        this.moveTimer = moveTimer;
        if (moveTimer <= 0) {
            this.moveTimer = 10;
            this.flockCreature.m_21573_().m_26519_(this.flockPosition.f_82479_, this.flockPosition.f_82480_, this.flockPosition.f_82481_, this.speed);
        }
    }
}
