// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.EnumSet;
import twilightforest.entity.RovingCube;
import net.minecraft.world.entity.ai.goal.Goal;

public class CubeCenterOnSymbolGoal extends Goal
{
    private final RovingCube myCube;
    private final double speed;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    
    public CubeCenterOnSymbolGoal(final RovingCube entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.xPosition = this.myCube.symbolX;
        this.yPosition = this.myCube.symbolY;
        this.zPosition = this.myCube.symbolZ;
        this.speed = d;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean m_8036_() {
        this.xPosition = this.myCube.symbolX;
        this.yPosition = this.myCube.symbolY;
        this.zPosition = this.myCube.symbolZ;
        return this.myCube.m_21573_().m_26571_() && this.isCloseToSymbol();
    }
    
    public boolean m_8045_() {
        this.myCube.m_21566_().m_6849_(this.xPosition + 0.5, this.yPosition, this.zPosition + 0.5, this.speed);
        return this.distanceFromSymbol() > 0.10000000149011612 && this.isCourseTraversable();
    }
    
    private boolean isCourseTraversable() {
        return this.distanceFromSymbol() < 100.0;
    }
    
    private boolean isCloseToSymbol() {
        final double dist = this.distanceFromSymbol();
        return dist > 0.25 && dist < 10.0;
    }
    
    private double distanceFromSymbol() {
        final double dx = this.xPosition - this.myCube.m_20185_() + 0.5;
        final double dy = this.yPosition - this.myCube.m_20186_();
        final double dz = this.zPosition - this.myCube.m_20189_() + 0.5;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
