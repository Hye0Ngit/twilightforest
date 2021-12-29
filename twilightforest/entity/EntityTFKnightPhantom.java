// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityFlying;

public class EntityTFKnightPhantom extends EntityFlying implements IMob
{
    int number;
    int ticksProgress;
    Formation currentFormation;
    
    public EntityTFKnightPhantom(final World par1World) {
        super(par1World);
        this.func_70105_a(2.0f, 3.0f);
        this.field_70750_az = "/mods/twilightforest/textures/model/knightphantom.png";
        this.func_70606_j(this.func_70667_aM());
        this.field_70145_X = true;
        this.field_70178_ae = true;
        this.currentFormation = Formation.HOVER;
        this.field_70728_aV = 93;
    }
    
    public int func_70667_aM() {
        return 70;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final int par2) {
        return !this.func_85032_ar() && par1DamageSource != DamageSource.field_76368_d && super.func_70097_a(par1DamageSource, par2);
    }
    
    public void func_70091_d(final double par1, final double par3, final double par5) {
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        super.func_70091_d(par1, par3, par5);
    }
    
    protected void func_70626_be() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        this.field_70145_X = (this.ticksProgress % 20 != 0);
        ++this.ticksProgress;
        if (this.ticksProgress >= this.getMaxTicksForFormation()) {
            this.switchToNextFormation();
        }
        final Vec3 dest = this.getDestination();
        final double moveX = dest.field_72450_a - this.field_70165_t;
        final double moveY = dest.field_72448_b - this.field_70163_u;
        final double moveZ = dest.field_72449_c - this.field_70161_v;
        double factor = moveX * moveX + moveY * moveY + moveZ * moveZ;
        factor = MathHelper.func_76133_a(factor);
        final double speed = 0.1;
        this.field_70159_w += moveX / factor * speed;
        this.field_70181_x += moveY / factor * speed;
        this.field_70179_y += moveZ / factor * speed;
        final EntityPlayer target = this.field_70170_p.func_72890_a((Entity)this, 9.0);
        if (target != null) {
            this.func_70625_a((Entity)target, 10.0f, 20.0f);
        }
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public void func_70653_a(final Entity par1Entity, final int par2, final double par3, final double par5) {
        this.field_70160_al = true;
        final float f = MathHelper.func_76133_a(par3 * par3 + par5 * par5);
        final float distance = 0.2f;
        this.field_70159_w /= 2.0;
        this.field_70181_x /= 2.0;
        this.field_70179_y /= 2.0;
        this.field_70159_w -= par3 / f * distance;
        this.field_70181_x += distance;
        this.field_70179_y -= par5 / f * distance;
        if (this.field_70181_x > 0.4000000059604645) {
            this.field_70181_x = 0.4000000059604645;
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
        switch (this.field_70146_Z.nextInt(8)) {
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
    
    private boolean isThisTheLeader(final List nearbyKnights) {
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
    
    private void broadcastMyFormation(final List nearbyKnights) {
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
    
    private Vec3 getDestination() {
        if (!this.func_70622_aF()) {}
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
                return this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
        }
    }
    
    private Vec3 getChargePosition(final boolean plus, final boolean alongX) {
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
        final double dx = this.func_70602_aC().field_71574_a + (alongX ? offset0 : offset2);
        final double dy = this.func_70602_aC().field_71572_b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.func_70602_aC().field_71573_c + (alongX ? offset2 : offset0);
        return this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz);
    }
    
    protected Vec3 getCirclePosition(final float distance, final boolean clockwise) {
        float angle = this.ticksProgress * 2.0f;
        if (!clockwise) {
            angle *= -1.0f;
        }
        angle += 60.0f * this.getNumber();
        final double dx = this.func_70602_aC().field_71574_a + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dy = this.func_70602_aC().field_71572_b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.func_70602_aC().field_71573_c + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz);
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        this.number = number;
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        super.func_70014_b(nbttagcompound);
        final ChunkCoordinates home = this.func_70602_aC();
        nbttagcompound.func_74782_a("Home", (NBTBase)this.func_70087_a(new double[] { home.field_71574_a, home.field_71572_b, home.field_71573_c }));
        nbttagcompound.func_74757_a("HasHome", this.func_70622_aF());
        nbttagcompound.func_74768_a("MyNumber", this.getNumber());
        nbttagcompound.func_74768_a("Formation", this.getFormationAsNumber());
        nbttagcompound.func_74768_a("TicksProgress", this.getTicksProgress());
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        final NBTTagList homelist = nbttagcompound.func_74761_m("Home");
        this.func_70598_b((int)((NBTTagDouble)homelist.func_74743_b(0)).field_74755_a, (int)((NBTTagDouble)homelist.func_74743_b(1)).field_74755_a, (int)((NBTTagDouble)homelist.func_74743_b(2)).field_74755_a, 20);
        if (!nbttagcompound.func_74767_n("HasHome")) {
            this.func_70677_aE();
        }
        this.setNumber(nbttagcompound.func_74762_e("MyNumber"));
        this.switchToFormationByNumber(nbttagcompound.func_74762_e("Formation"));
        this.setTicksProgress(nbttagcompound.func_74762_e("TicksProgress"));
    }
    
    public enum Formation
    {
        HOVER("HOVER", 0), 
        LARGE_CLOCKWISE("LARGE_CLOCKWISE", 1), 
        SMALL_CLOCKWISE("SMALL_CLOCKWISE", 2), 
        LARGE_ANTICLOCKWISE("LARGE_ANTICLOCKWISE", 3), 
        SMALL_ANTICLOCKWISE("SMALL_ANTICLOCKWISE", 4), 
        CHARGE_PLUSX("CHARGE_PLUSX", 5), 
        CHARGE_MINUSX("CHARGE_MINUSX", 6), 
        CHARGE_PLUSZ("CHARGE_PLUSZ", 7), 
        CHARGE_MINUSZ("CHARGE_MINUSZ", 8), 
        WAITING_FOR_LEADER("WAITING_FOR_LEADER", 9);
        
        private Formation(final String s, final int n) {
        }
    }
}
