// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import java.util.Iterator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFHydraMortar extends EntityThrowable
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public int fuse;
    private boolean megaBlast;
    
    public EntityTFHydraMortar(final World world) {
        super(world);
        this.fuse = 80;
        this.megaBlast = false;
        this.func_70105_a(0.75f, 0.75f);
    }
    
    public EntityTFHydraMortar(final World world, final EntityTFHydraHead head) {
        super(world, (EntityLivingBase)head);
        this.fuse = 80;
        this.megaBlast = false;
        this.func_70105_a(0.75f, 0.75f);
        final Vec3d vector = head.func_70040_Z();
        final double dist = 3.5;
        final double px = head.field_70165_t + vector.field_72450_a * dist;
        final double py = head.field_70163_u + 1.0 + vector.field_72448_b * dist;
        final double pz = head.field_70161_v + vector.field_72449_c * dist;
        this.func_70012_b(px, py, pz, 0.0f, 0.0f);
        head.field_70159_w = 0.0;
        head.field_70181_x = 0.0;
        head.field_70179_y = 0.0;
        this.func_184538_a((Entity)head, head.field_70125_A, head.field_70177_z, -20.0f, 0.5f, 1.0f);
        TwilightForestMod.LOGGER.debug("Launching mortar! Current head motion is {}, {}", (Object)head.field_70159_w, (Object)head.field_70179_y);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.func_145771_j(this.field_70165_t, (this.func_174813_aQ().field_72338_b + this.func_174813_aQ().field_72337_e) / 2.0, this.field_70161_v);
        if (this.field_70122_E) {
            this.field_70159_w *= 0.9;
            this.field_70181_x *= 0.9;
            this.field_70179_y *= 0.9;
            if (!this.field_70170_p.field_72995_K && this.fuse-- <= 0) {
                this.detonate();
            }
        }
    }
    
    public void setToBlasting() {
        this.megaBlast = true;
    }
    
    protected void func_70184_a(final RayTraceResult ray) {
        if (ray.field_72308_g == null && !this.megaBlast) {
            this.field_70181_x = 0.0;
            this.field_70122_E = true;
        }
        else if (!this.field_70170_p.field_72995_K && ray.field_72308_g != this.field_70192_c && !this.isPartOfHydra(ray.field_72308_g)) {
            this.detonate();
        }
    }
    
    private boolean isPartOfHydra(final Entity entity) {
        if (this.field_70192_c instanceof EntityTFHydraPart) {
            final EntityTFHydra hydra = ((EntityTFHydraPart)this.field_70192_c).hydra;
            if (hydra == null || hydra.func_70021_al() == null) {
                return false;
            }
            if (entity == hydra) {
                return true;
            }
            for (final Entity e : hydra.func_70021_al()) {
                if (entity == e) {
                    return true;
                }
            }
            for (final HydraHeadContainer container : hydra.hc) {
                if (entity == container.headEntity) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public float func_180428_a(final Explosion explosion, final World world, final BlockPos pos, final IBlockState state) {
        float resistance = super.func_180428_a(explosion, world, pos, state);
        if (this.megaBlast && state.func_177230_c() != Blocks.field_150357_h && state.func_177230_c() != Blocks.field_150384_bq && state.func_177230_c() != Blocks.field_150378_br) {
            resistance = Math.min(0.8f, resistance);
        }
        return resistance;
    }
    
    private void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this);
        this.field_70170_p.func_72885_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, explosionPower, flag, flag);
        final DamageSource src = new EntityDamageSourceIndirect("onFire", (Entity)this, (Entity)this.func_85052_h()).func_76361_j().func_76349_b();
        for (final Entity nearby : this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ().func_72314_b(1.0, 1.0, 1.0))) {
            if (nearby.func_70097_a(src, 18.0f) && !nearby.func_70045_F()) {
                nearby.func_70015_d(5);
            }
        }
        this.func_70106_y();
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        super.func_70097_a(source, amount);
        if (source.func_76346_g() != null && !this.field_70170_p.field_72995_K) {
            final Vec3d vec3d = source.func_76346_g().func_70040_Z();
            if (vec3d != null) {
                this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 1.5f, 0.1f);
                this.field_70122_E = false;
                this.fuse += 20;
            }
            if (source.func_76346_g() instanceof EntityLivingBase) {
                this.field_70192_c = (EntityLivingBase)source.func_76346_g();
            }
            return true;
        }
        return false;
    }
    
    public boolean func_70027_ad() {
        return true;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.5f;
    }
    
    protected float func_70185_h() {
        return 0.05f;
    }
}
