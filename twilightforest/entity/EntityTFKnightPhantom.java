// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Iterator;
import java.util.List;

public class EntityTFKnightPhantom extends oa implements tg
{
    int number;
    int ticksProgress;
    Formation currentFormation;
    private t homePosition;
    private float maximumHomeDistance;
    
    public EntityTFKnightPhantom(final abv par1World) {
        super(par1World);
        this.homePosition = new t(0, 0, 0);
        this.maximumHomeDistance = -1.0f;
        this.a(2.0f, 3.0f);
        this.Z = true;
        this.ag = true;
        this.currentFormation = Formation.HOVER;
        this.b = 93;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(70.0);
    }
    
    protected boolean t() {
        return false;
    }
    
    public boolean attackEntityFrom(final na par1DamageSource, final int par2) {
        return !this.aq() && par1DamageSource != na.d && super.a(par1DamageSource, (float)par2);
    }
    
    public void d(final double par1, final double par3, final double par5) {
        this.b(this.u, this.v, this.w);
        super.d(par1, par3, par5);
    }
    
    protected void bk() {
        if (!this.q.I && this.q.r == 0) {
            this.w();
        }
        this.bo();
        this.Z = (this.ticksProgress % 20 != 0);
        ++this.ticksProgress;
        if (this.ticksProgress >= this.getMaxTicksForFormation()) {
            this.switchToNextFormation();
        }
        final asz dest = this.getDestination();
        final double moveX = dest.c - this.u;
        final double moveY = dest.d - this.v;
        final double moveZ = dest.e - this.w;
        double factor = moveX * moveX + moveY * moveY + moveZ * moveZ;
        factor = lr.a(factor);
        final double speed = 0.1;
        this.x += moveX / factor * speed;
        this.y += moveY / factor * speed;
        this.z += moveZ / factor * speed;
        final ue target = this.q.a((nm)this, 9.0);
        if (target != null) {
            this.a((nm)target, 10.0f, 20.0f);
        }
    }
    
    public boolean L() {
        return true;
    }
    
    public void a(final nm par1Entity, final float damage, final double par3, final double par5) {
        this.an = true;
        final float f = lr.a(par3 * par3 + par5 * par5);
        final float distance = 0.2f;
        this.x /= 2.0;
        this.y /= 2.0;
        this.z /= 2.0;
        this.x -= par3 / f * distance;
        this.y += distance;
        this.z -= par5 / f * distance;
        if (this.y > 0.4000000059604645) {
            this.y = 0.4000000059604645;
        }
    }
    
    private void switchToNextFormation() {
        this.pickNextFormation();
        this.ticksProgress = 0;
    }
    
    protected void pickNextFormation() {
        switch (this.currentFormation) {
            default: {
                this.currentFormation = Formation.SMALL_CLOCKWISE;
                break;
            }
            case SMALL_CLOCKWISE: {
                this.currentFormation = Formation.LARGE_ANTICLOCKWISE;
                break;
            }
            case LARGE_ANTICLOCKWISE: {
                this.currentFormation = Formation.SMALL_ANTICLOCKWISE;
                break;
            }
            case SMALL_ANTICLOCKWISE: {
                this.currentFormation = Formation.CHARGE_PLUSX;
                break;
            }
            case CHARGE_PLUSX: {
                this.currentFormation = Formation.CHARGE_MINUSX;
                break;
            }
            case CHARGE_MINUSX: {
                this.currentFormation = Formation.CHARGE_PLUSZ;
                break;
            }
            case CHARGE_PLUSZ: {
                this.currentFormation = Formation.CHARGE_MINUSZ;
                break;
            }
            case CHARGE_MINUSZ: {
                this.currentFormation = Formation.LARGE_CLOCKWISE;
                break;
            }
        }
    }
    
    protected void pickRandomFormation() {
        switch (this.ab.nextInt(8)) {
            case 0: {
                this.currentFormation = Formation.SMALL_CLOCKWISE;
                break;
            }
            case 1: {
                this.currentFormation = Formation.LARGE_ANTICLOCKWISE;
                break;
            }
            case 2: {
                this.currentFormation = Formation.SMALL_ANTICLOCKWISE;
                break;
            }
            case 3: {
                this.currentFormation = Formation.CHARGE_PLUSX;
                break;
            }
            case 4: {
                this.currentFormation = Formation.CHARGE_MINUSX;
                break;
            }
            case 5: {
                this.currentFormation = Formation.CHARGE_PLUSZ;
                break;
            }
            case 6: {
                this.currentFormation = Formation.CHARGE_MINUSZ;
                break;
            }
            case 7: {
                this.currentFormation = Formation.LARGE_CLOCKWISE;
                break;
            }
        }
    }
    
    private boolean isThisTheLeader(final List<EntityTFKnightPhantom> nearbyKnights) {
        boolean iAmTheLowest = true;
        System.out.println("Checking " + nearbyKnights.size() + " knights to see if I'm the leader");
        for (final EntityTFKnightPhantom knight : nearbyKnights) {
            if (knight.getNumber() < this.getNumber()) {
                iAmTheLowest = false;
                break;
            }
        }
        return iAmTheLowest;
    }
    
    private void broadcastMyFormation(final List<EntityTFKnightPhantom> nearbyKnights) {
        System.out.println("Broadcasting to " + nearbyKnights.size() + " knights");
        for (final EntityTFKnightPhantom knight : nearbyKnights) {
            System.out.println("Telling knight " + knight + " to switch");
            knight.switchToFormation(this.currentFormation);
        }
        System.out.println("knight phantom broadcast switch to formation " + this.currentFormation);
    }
    
    private void switchToFormationByNumber(final int formationNumber) {
        switch (formationNumber) {
            default: {
                this.currentFormation = Formation.HOVER;
                break;
            }
            case 1: {
                this.currentFormation = Formation.LARGE_CLOCKWISE;
                break;
            }
            case 2: {
                this.currentFormation = Formation.SMALL_CLOCKWISE;
                break;
            }
            case 3: {
                this.currentFormation = Formation.LARGE_ANTICLOCKWISE;
                break;
            }
            case 4: {
                this.currentFormation = Formation.SMALL_ANTICLOCKWISE;
                break;
            }
            case 5: {
                this.currentFormation = Formation.CHARGE_PLUSX;
                break;
            }
            case 6: {
                this.currentFormation = Formation.CHARGE_MINUSX;
                break;
            }
            case 7: {
                this.currentFormation = Formation.CHARGE_PLUSZ;
                break;
            }
            case 8: {
                this.currentFormation = Formation.CHARGE_MINUSZ;
                break;
            }
            case 9: {
                this.currentFormation = Formation.WAITING_FOR_LEADER;
                break;
            }
        }
        this.ticksProgress = 0;
    }
    
    public void switchToFormation(final Formation formation) {
        System.out.println("Knight " + this.getNumber() + " now switchign to formation " + formation);
        this.currentFormation = formation;
        this.ticksProgress = 0;
    }
    
    public int getFormationAsNumber() {
        switch (this.currentFormation) {
            default: {
                return 0;
            }
            case LARGE_CLOCKWISE: {
                return 1;
            }
            case SMALL_CLOCKWISE: {
                return 2;
            }
            case LARGE_ANTICLOCKWISE: {
                return 3;
            }
            case SMALL_ANTICLOCKWISE: {
                return 4;
            }
            case CHARGE_PLUSX: {
                return 5;
            }
            case CHARGE_MINUSX: {
                return 6;
            }
            case CHARGE_PLUSZ: {
                return 7;
            }
            case CHARGE_MINUSZ: {
                return 8;
            }
            case WAITING_FOR_LEADER: {
                return 9;
            }
        }
    }
    
    public int getTicksProgress() {
        return this.ticksProgress;
    }
    
    public void setTicksProgress(final int ticksProgress) {
        this.ticksProgress = ticksProgress;
    }
    
    public int getMaxTicksForFormation() {
        switch (this.currentFormation) {
            default: {
                return 90;
            }
            case LARGE_CLOCKWISE: {
                return 180;
            }
            case SMALL_CLOCKWISE: {
                return 90;
            }
            case LARGE_ANTICLOCKWISE: {
                return 180;
            }
            case SMALL_ANTICLOCKWISE: {
                return 90;
            }
            case CHARGE_PLUSX: {
                return 180;
            }
            case CHARGE_MINUSX: {
                return 180;
            }
            case CHARGE_PLUSZ: {
                return 180;
            }
            case CHARGE_MINUSZ: {
                return 180;
            }
            case WAITING_FOR_LEADER: {
                return 5;
            }
        }
    }
    
    private asz getDestination() {
        if (!this.hasHome()) {}
        switch (this.currentFormation) {
            case LARGE_CLOCKWISE: {
                return this.getCirclePosition(8.5f, true);
            }
            case SMALL_CLOCKWISE: {
                return this.getCirclePosition(2.5f, true);
            }
            case LARGE_ANTICLOCKWISE: {
                return this.getCirclePosition(8.5f, false);
            }
            case SMALL_ANTICLOCKWISE: {
                return this.getCirclePosition(2.5f, false);
            }
            case CHARGE_PLUSX: {
                return this.getChargePosition(true, true);
            }
            case CHARGE_MINUSX: {
                return this.getChargePosition(false, true);
            }
            case CHARGE_PLUSZ: {
                return this.getChargePosition(true, false);
            }
            case CHARGE_MINUSZ: {
                return this.getChargePosition(false, false);
            }
            default: {
                return this.q.V().a(this.u, this.v, this.w);
            }
        }
    }
    
    private asz getChargePosition(final boolean plus, final boolean alongX) {
        final float offset0 = this.getNumber() * 3.0f - 7.5f;
        float offset2;
        if (this.ticksProgress < 60) {
            offset2 = -7.0f;
        }
        else {
            offset2 = -7.0f + (this.ticksProgress - 60) / 120.0f * 14.0f;
        }
        if (!plus) {
            offset2 *= -1.0f;
        }
        final double dx = this.getHomePosition().a + (alongX ? offset0 : offset2);
        final double dy = this.getHomePosition().b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.getHomePosition().c + (alongX ? offset2 : offset0);
        return this.q.V().a(dx, dy, dz);
    }
    
    protected asz getCirclePosition(final float distance, final boolean clockwise) {
        float angle = this.ticksProgress * 2.0f;
        if (!clockwise) {
            angle *= -1.0f;
        }
        angle += 60.0f * this.getNumber();
        final double dx = this.getHomePosition().a + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dy = this.getHomePosition().b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.getHomePosition().c + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return this.q.V().a(dx, dy, dz);
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        this.number = number;
    }
    
    public void b(final bx nbttagcompound) {
        super.b(nbttagcompound);
        final t home = this.getHomePosition();
        nbttagcompound.a("Home", (ck)this.a(new double[] { home.a, home.b, home.c }));
        nbttagcompound.a("HasHome", this.hasHome());
        nbttagcompound.a("MyNumber", this.getNumber());
        nbttagcompound.a("Formation", this.getFormationAsNumber());
        nbttagcompound.a("TicksProgress", this.getTicksProgress());
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        final cf homelist = nbttagcompound.m("Home");
        this.setHomeArea((int)((ca)homelist.b(0)).a, (int)((ca)homelist.b(1)).a, (int)((ca)homelist.b(2)).a, 20);
        if (!nbttagcompound.n("HasHome")) {
            this.detachHome();
        }
        this.setNumber(nbttagcompound.e("MyNumber"));
        this.switchToFormationByNumber(nbttagcompound.e("Formation"));
        this.setTicksProgress(nbttagcompound.e("TicksProgress"));
    }
    
    public void setHomeArea(final int par1, final int par2, final int par3, final int par4) {
        this.homePosition.b(par1, par2, par3);
        this.maximumHomeDistance = (float)par4;
    }
    
    public t getHomePosition() {
        return this.homePosition;
    }
    
    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }
    
    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    public enum Formation
    {
        HOVER, 
        LARGE_CLOCKWISE, 
        SMALL_CLOCKWISE, 
        LARGE_ANTICLOCKWISE, 
        SMALL_ANTICLOCKWISE, 
        CHARGE_PLUSX, 
        CHARGE_MINUSX, 
        CHARGE_PLUSZ, 
        CHARGE_MINUSZ, 
        WAITING_FOR_LEADER;
    }
}
