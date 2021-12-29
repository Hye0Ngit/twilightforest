// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;

public class EntityAITFFlockToSameKind extends nc
{
    private static final double MAX_DIST = 256.0;
    private static final double MIN_DIST = 25.0;
    md flockCreature;
    aoj flockPosition;
    float speed;
    private int moveTimer;
    
    public EntityAITFFlockToSameKind(final md par1EntityLiving, final float par2) {
        this.flockCreature = par1EntityLiving;
        this.speed = par2;
    }
    
    public boolean a() {
        if (this.flockCreature.aB().nextInt(40) != 0) {
            return false;
        }
        final List flockList = this.flockCreature.p.a((Class)this.flockCreature.getClass(), this.flockCreature.D.b(16.0, 4.0, 16.0));
        int flocknum = 0;
        double flockX = 0.0;
        double flockY = 0.0;
        double flockZ = 0.0;
        for (final md flocker : flockList) {
            ++flocknum;
            flockX += flocker.t;
            flockY += flocker.u;
            flockZ += flocker.v;
        }
        flockX /= flocknum;
        flockY /= flocknum;
        flockZ /= flocknum;
        if (this.flockCreature.e(flockX, flockY, flockZ) < 25.0) {
            return false;
        }
        this.flockPosition = this.flockCreature.p.S().a(flockX, flockY, flockZ);
        return true;
    }
    
    public boolean b() {
        if (this.flockPosition == null) {
            return false;
        }
        final double distance = this.flockCreature.e(this.flockPosition.c, this.flockPosition.d, this.flockPosition.e);
        return distance >= 25.0 && distance <= 256.0;
    }
    
    public void c() {
        this.moveTimer = 0;
    }
    
    public void d() {
        this.flockPosition = null;
    }
    
    public void e() {
        final int moveTimer = this.moveTimer - 1;
        this.moveTimer = moveTimer;
        if (moveTimer <= 0) {
            this.moveTimer = 10;
            this.flockCreature.az().a(this.flockPosition.c, this.flockPosition.d, this.flockPosition.e, this.speed);
        }
    }
}
