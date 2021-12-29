// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFRovingCube;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAICubeCenterOnSymbol extends EntityAIBase
{
    private EntityTFRovingCube myCube;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    
    public EntityAICubeCenterOnSymbol(final EntityTFRovingCube entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.xPosition = this.myCube.symbolX;
        this.yPosition = this.myCube.symbolY;
        this.zPosition = this.myCube.symbolZ;
        this.speed = d;
    }
    
    public boolean func_75250_a() {
        this.xPosition = this.myCube.symbolX;
        this.yPosition = this.myCube.symbolY;
        this.zPosition = this.myCube.symbolZ;
        return this.myCube.func_70661_as().func_75500_f() && this.isCloseToSymbol();
    }
    
    public boolean func_75253_b() {
        final double dist = this.distanceFromSymbol();
        this.myCube.func_70605_aq().func_75642_a(this.xPosition + 0.5, this.yPosition, this.zPosition + 0.5, this.speed);
        if (this.myCube.field_70173_aa % 5 == 0) {}
        return dist > 0.10000000149011612 && this.isCourseTraversable();
    }
    
    private boolean isCourseTraversable() {
        return this.distanceFromSymbol() < 100.0;
    }
    
    private boolean isCloseToSymbol() {
        final double dist = this.distanceFromSymbol();
        return dist > 0.25 && dist < 10.0;
    }
    
    public double distanceFromSymbol() {
        final double dx = this.xPosition - this.myCube.field_70165_t + 0.5;
        final double dy = this.yPosition - this.myCube.field_70163_u;
        final double dz = this.zPosition - this.myCube.field_70161_v + 0.5;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
