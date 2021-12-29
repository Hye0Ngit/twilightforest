// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.Vec3;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.boss.EntityTFSnowQueen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFHoverThenDrop extends EntityAIBase
{
    private static final float HOVER_HEIGHT = 6.0f;
    private static final float HOVER_RADIUS = 0.0f;
    private Class<? extends EntityLivingBase> classTarget;
    private EntityTFSnowQueen attacker;
    private double hoverPosX;
    private double hoverPosY;
    private double hoverPosZ;
    private int hoverTimer;
    private int dropTimer;
    private int maxHoverTime;
    private int maxDropTime;
    private int seekTimer;
    private int maxSeekTime;
    private double dropY;
    
    public EntityAITFHoverThenDrop(final EntityTFSnowQueen entityTFSnowQueen, final Class<EntityPlayer> class1, final int hoverTime, final int dropTime) {
        this.attacker = entityTFSnowQueen;
        this.classTarget = (Class<? extends EntityLivingBase>)class1;
        this.func_75248_a(3);
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxDropTime = dropTime;
        this.hoverTimer = 0;
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        return target != null && target.func_70089_S() && (this.classTarget == null || this.classTarget.isAssignableFrom(target.getClass())) && this.attacker.getCurrentPhase() == EntityTFSnowQueen.Phase.DROP;
    }
    
    public boolean func_75253_b() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        if (target == null || !target.func_70089_S()) {
            return false;
        }
        if (this.attacker.getCurrentPhase() != EntityTFSnowQueen.Phase.DROP) {
            return false;
        }
        if (this.seekTimer > this.maxSeekTime) {
            return false;
        }
        if (this.attacker.func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            ++this.hoverTimer;
            return true;
        }
        if (this.dropTimer < this.maxDropTime) {
            return true;
        }
        this.attacker.incrementSuccessfulDrops();
        return false;
    }
    
    public void func_75249_e() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        if (target != null) {
            this.makeNewHoverSpot(target);
        }
    }
    
    public void func_75251_c() {
        this.hoverTimer = 0;
        this.dropTimer = 0;
    }
    
    public void func_75246_d() {
        if (this.hoverTimer > 0) {
            ++this.hoverTimer;
        }
        else {
            ++this.seekTimer;
        }
        if (this.hoverTimer < this.maxHoverTime) {
            final double offsetX = this.hoverPosX - this.attacker.field_70165_t;
            final double offsetY = this.hoverPosY - this.attacker.field_70163_u;
            final double offsetZ = this.hoverPosZ - this.attacker.field_70161_v;
            double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
            distanceDesired = MathHelper.func_76133_a(distanceDesired);
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.05000000074505806;
            this.attacker.func_70024_g(velX, velY, velZ);
            final EntityLivingBase target = this.attacker.func_70638_az();
            if (target != null) {
                this.attacker.func_70625_a((Entity)target, 30.0f, 30.0f);
                this.attacker.func_70671_ap().func_75651_a((Entity)target, 30.0f, 30.0f);
            }
        }
        else {
            ++this.dropTimer;
            if (this.attacker.field_70163_u > this.dropY) {
                this.attacker.destroyBlocksInAABB(this.attacker.field_70121_D.func_72314_b(1.0, 0.5, 1.0));
            }
        }
    }
    
    private void makeNewHoverSpot(final EntityLivingBase target) {
        double hx = 0.0;
        double hy = 0.0;
        double hz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            hx = target.field_70165_t + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * 0.0f;
            hy = target.field_70163_u + 6.0;
            hz = target.field_70161_v + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * 0.0f;
            if (!this.isPositionOccupied(hx, hy, hz) && this.canEntitySee((Entity)this.attacker, hx, hy, hz) && this.canEntitySee((Entity)target, hx, hy, hz)) {
                break;
            }
        }
        if (tries == 99) {
            System.out.println("Found no spots, giving up");
        }
        this.hoverPosX = hx;
        this.hoverPosY = hy;
        this.hoverPosZ = hz;
        this.dropY = target.field_70163_u - 1.0;
        this.seekTimer = 0;
    }
    
    private boolean isPositionOccupied(final double hx, final double hy, final double hz) {
        final float radius = this.attacker.field_70130_N / 2.0f;
        final AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(hx - radius, hy, hz - radius, hx + radius, hy + this.attacker.field_70131_O, hz + radius);
        final boolean isOccupied = this.attacker.field_70170_p.func_72945_a((Entity)this.attacker, aabb).isEmpty();
        return isOccupied;
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return entity.field_70170_p.func_72933_a(Vec3.func_72443_a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v), Vec3.func_72443_a(dx, dy, dz)) == null;
    }
}
