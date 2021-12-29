// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import java.util.Iterator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ThrowableEntity;

public class HydraMortarHead extends ThrowableEntity
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public int fuse;
    private boolean megaBlast;
    
    public HydraMortarHead(final EntityType<? extends HydraMortarHead> type, final World world) {
        super((EntityType)type, world);
        this.fuse = 80;
        this.megaBlast = false;
    }
    
    public HydraMortarHead(final EntityType<? extends HydraMortarHead> type, final World world, final HydraHeadEntity head) {
        super((EntityType)type, (LivingEntity)head.getParent(), world);
        this.fuse = 80;
        this.megaBlast = false;
        final Vector3d vector = head.func_70040_Z();
        final double dist = 3.5;
        final double px = head.func_226277_ct_() + vector.field_72450_a * dist;
        final double py = head.func_226278_cu_() + 1.0 + vector.field_72448_b * dist;
        final double pz = head.func_226281_cx_() + vector.field_72449_c * dist;
        this.func_70012_b(px, py, pz, 0.0f, 0.0f);
        head.func_213317_d(new Vector3d(0.0, 0.0, 0.0));
        this.func_234612_a_((Entity)head, head.field_70125_A, head.field_70177_z, -20.0f, 0.5f, 1.0f);
        TwilightForestMod.LOGGER.debug("Launching mortar! Current head motion is {}, {}", (Object)head.func_213322_ci().func_82615_a(), (Object)head.func_213322_ci().func_82616_c());
    }
    
    protected void func_70088_a() {
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.func_233570_aj_()) {
            this.func_213322_ci().func_216372_d(0.9, 0.9, 0.9);
            if (!this.field_70170_p.field_72995_K && this.fuse-- <= 0) {
                this.detonate();
            }
        }
    }
    
    public void setToBlasting() {
        this.megaBlast = true;
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        if (ray instanceof EntityRayTraceResult) {
            if (!this.field_70170_p.field_72995_K && (!(((EntityRayTraceResult)ray).func_216348_a() instanceof HydraMortarHead) || ((HydraMortarHead)((EntityRayTraceResult)ray).func_216348_a()).func_234616_v_() != this.func_234616_v_()) && ((EntityRayTraceResult)ray).func_216348_a() != this.func_234616_v_() && !this.isPartOfHydra(((EntityRayTraceResult)ray).func_216348_a())) {
                this.detonate();
            }
        }
        else if (!this.megaBlast) {
            this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.0, this.func_213322_ci().func_82616_c());
            this.field_70122_E = true;
        }
        else {
            this.detonate();
        }
    }
    
    private boolean isPartOfHydra(final Entity entity) {
        return this.func_234616_v_() instanceof HydraEntity && entity instanceof HydraPartEntity && ((HydraPartEntity)entity).getParent() == this.func_234616_v_();
    }
    
    public float func_180428_a(final Explosion explosion, final IBlockReader world, final BlockPos pos, final BlockState state, final FluidState fluid, final float p_180428_6_) {
        float resistance = super.func_180428_a(explosion, world, pos, state, fluid, p_180428_6_);
        if (this.megaBlast && state.func_177230_c() != Blocks.field_150357_h && state.func_177230_c() != Blocks.field_150384_bq && state.func_177230_c() != Blocks.field_150378_br) {
            resistance = Math.min(0.8f, resistance);
        }
        return resistance;
    }
    
    private void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this);
        final Explosion.Mode flag2 = flag ? Explosion.Mode.BREAK : Explosion.Mode.NONE;
        this.field_70170_p.func_217398_a((Entity)this, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), explosionPower, flag, flag2);
        final DamageSource src = new IndirectEntityDamageSource("onFire", (Entity)this, this.func_234616_v_()).func_76361_j().func_76349_b();
        for (final Entity nearby : this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ().func_72314_b(1.0, 1.0, 1.0))) {
            if (nearby.func_70097_a(src, 18.0f) && !nearby.func_230279_az_()) {
                nearby.func_70015_d(5);
            }
        }
        this.func_70106_y();
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        super.func_70097_a(source, amount);
        if (source.func_76346_g() != null && !this.field_70170_p.field_72995_K) {
            final Vector3d vec3d = source.func_76346_g().func_70040_Z();
            if (vec3d != null) {
                this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 1.5f, 0.1f);
                this.field_70122_E = false;
                this.fuse += 20;
            }
            if (source.func_76346_g() instanceof LivingEntity) {
                this.func_212361_a(source.func_76346_g());
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
    
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
