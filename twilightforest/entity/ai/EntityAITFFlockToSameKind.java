// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFFlockToSameKind extends EntityAIBase
{
    private static final double MAX_DIST = 256.0;
    private static final double MIN_DIST = 25.0;
    private EntityLiving flockCreature;
    private Vec3d flockPosition;
    double speed;
    private int moveTimer;
    
    public EntityAITFFlockToSameKind(final EntityLiving living, final double speed) {
        this.flockCreature = living;
        this.speed = speed;
    }
    
    public boolean func_75250_a() {
        if (this.flockCreature.func_70681_au().nextInt(40) != 0) {
            return false;
        }
        final List<EntityLiving> flockList = this.flockCreature.field_70170_p.func_72872_a((Class)this.flockCreature.getClass(), this.flockCreature.func_174813_aQ().func_72314_b(16.0, 4.0, 16.0));
        int flocknum = 0;
        double flockX = 0.0;
        double flockY = 0.0;
        double flockZ = 0.0;
        for (final EntityLiving flocker : flockList) {
            ++flocknum;
            flockX += flocker.field_70165_t;
            flockY += flocker.field_70163_u;
            flockZ += flocker.field_70161_v;
        }
        flockX /= flocknum;
        flockY /= flocknum;
        flockZ /= flocknum;
        if (this.flockCreature.func_70092_e(flockX, flockY, flockZ) < 25.0) {
            return false;
        }
        this.flockPosition = new Vec3d(flockX, flockY, flockZ);
        return true;
    }
    
    public boolean func_75253_b() {
        if (this.flockPosition == null) {
            return false;
        }
        final double distance = this.flockCreature.func_70092_e(this.flockPosition.field_72450_a, this.flockPosition.field_72448_b, this.flockPosition.field_72449_c);
        return distance >= 25.0 && distance <= 256.0;
    }
    
    public void func_75249_e() {
        this.moveTimer = 0;
    }
    
    public void func_75251_c() {
        this.flockPosition = null;
    }
    
    public void func_75246_d() {
        final int moveTimer = this.moveTimer - 1;
        this.moveTimer = moveTimer;
        if (moveTimer <= 0) {
            this.moveTimer = 10;
            this.flockCreature.func_70661_as().func_75492_a(this.flockPosition.field_72450_a, this.flockPosition.field_72448_b, this.flockPosition.field_72449_c, this.speed);
        }
    }
}
