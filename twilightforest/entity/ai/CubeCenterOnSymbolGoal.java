// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.EnumSet;
import twilightforest.entity.RovingCubeEntity;
import net.minecraft.entity.ai.goal.Goal;

public class CubeCenterOnSymbolGoal extends Goal
{
    private final RovingCubeEntity myCube;
    private final double speed;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    
    public CubeCenterOnSymbolGoal(final RovingCubeEntity entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.xPosition = this.myCube.symbolX;
        this.yPosition = this.myCube.symbolY;
        this.zPosition = this.myCube.symbolZ;
        this.speed = d;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean func_75250_a() {
        this.xPosition = this.myCube.symbolX;
        this.yPosition = this.myCube.symbolY;
        this.zPosition = this.myCube.symbolZ;
        return this.myCube.func_70661_as().func_75500_f() && this.isCloseToSymbol();
    }
    
    public boolean func_75253_b() {
        this.myCube.func_70605_aq().func_75642_a(this.xPosition + 0.5, this.yPosition, this.zPosition + 0.5, this.speed);
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
        final double dx = this.xPosition - this.myCube.func_226277_ct_() + 0.5;
        final double dy = this.yPosition - this.myCube.func_226278_cu_();
        final double dz = this.zPosition - this.myCube.func_226281_cx_() + 0.5;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
