// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import twilightforest.item.TFItems;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import java.util.Random;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.block.BlockState;
import java.util.Iterator;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ThrowableEntity;

public class CubeOfAnnihilationEntity extends ThrowableEntity
{
    private boolean hasHitObstacle;
    
    public CubeOfAnnihilationEntity(final EntityType<? extends CubeOfAnnihilationEntity> type, final World world) {
        super((EntityType)type, world);
        this.hasHitObstacle = false;
        this.func_230279_az_();
    }
    
    public CubeOfAnnihilationEntity(final EntityType<? extends CubeOfAnnihilationEntity> type, final World world, final LivingEntity thrower) {
        super((EntityType)type, thrower, world);
        this.hasHitObstacle = false;
        this.func_230279_az_();
        this.func_234612_a_((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
    }
    
    protected void func_70088_a() {
    }
    
    protected float func_70185_h() {
        return 0.0f;
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (ray instanceof EntityRayTraceResult && ((EntityRayTraceResult)ray).func_216348_a() instanceof LivingEntity && ((EntityRayTraceResult)ray).func_216348_a().func_70097_a(this.getDamageSource(), 10.0f)) {
            this.field_70173_aa += 60;
        }
        if (ray instanceof BlockRayTraceResult && ((BlockRayTraceResult)ray).func_216350_a() != null && !this.field_70170_p.func_175623_d(((BlockRayTraceResult)ray).func_216350_a())) {
            this.affectBlocksInAABB(this.func_174813_aQ().func_72314_b(0.20000000298023224, 0.20000000298023224, 0.20000000298023224));
        }
    }
    
    private DamageSource getDamageSource() {
        final LivingEntity thrower = (LivingEntity)this.func_234616_v_();
        if (thrower instanceof PlayerEntity) {
            return DamageSource.func_76365_a((PlayerEntity)thrower);
        }
        if (thrower != null) {
            return DamageSource.func_76358_a(thrower);
        }
        return DamageSource.func_76356_a((Entity)this, (Entity)null);
    }
    
    private void affectBlocksInAABB(final AxisAlignedBB box) {
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            final BlockState state = this.field_70170_p.func_180495_p(pos);
            if (!state.func_177230_c().isAir(state, (IBlockReader)this.field_70170_p, pos) && this.func_234616_v_() instanceof PlayerEntity) {
                final PlayerEntity player = (PlayerEntity)this.func_234616_v_();
                if (!MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(this.field_70170_p, pos, state, player))) {
                    if (this.canAnnihilate(pos, state)) {
                        this.field_70170_p.func_217377_a(pos, false);
                        this.func_184185_a(SoundEvents.field_187541_bC, 0.125f, this.field_70146_Z.nextFloat() * 0.25f + 0.75f);
                        this.annihilateParticles(this.field_70170_p, pos);
                    }
                    else {
                        this.hasHitObstacle = true;
                    }
                }
                else {
                    this.hasHitObstacle = true;
                }
            }
        }
    }
    
    private boolean canAnnihilate(final BlockPos pos, final BlockState state) {
        final Block block = state.func_177230_c();
        return block.func_203417_a((ITag)BlockTagGenerator.ANNIHILATION_INCLUSIONS) || (block.func_149638_a() < 8.0f && state.func_185887_b((IBlockReader)this.field_70170_p, pos) >= 0.0f);
    }
    
    private void annihilateParticles(final World world, final BlockPos pos) {
        final Random rand = world.func_201674_k();
        if (world instanceof ServerWorld) {
            for (int dx = 0; dx < 3; ++dx) {
                for (int dy = 0; dy < 3; ++dy) {
                    for (int dz = 0; dz < 3; ++dz) {
                        final double x = pos.func_177958_n() + (dx + 0.5) / 4.0;
                        final double y = pos.func_177956_o() + (dy + 0.5) / 4.0;
                        final double z = pos.func_177952_p() + (dz + 0.5) / 4.0;
                        final double speed = rand.nextGaussian() * 0.2;
                        ((ServerWorld)world).func_195598_a((IParticleData)TFParticleType.ANNIHILATE.get(), x, y, z, 1, 0.0, 0.0, 0.0, speed);
                    }
                }
            }
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_234616_v_() == null) {
                this.func_70106_y();
                return;
            }
            Vector3d destPoint = new Vector3d(this.func_234616_v_().func_226277_ct_(), this.func_234616_v_().func_226278_cu_() + this.func_234616_v_().func_70047_e(), this.func_234616_v_().func_226281_cx_());
            final double distToPlayer = this.func_70032_d(this.func_234616_v_());
            if (this.isReturning()) {
                if (distToPlayer < 2.0) {
                    this.func_70106_y();
                }
            }
            else {
                destPoint = destPoint.func_178787_e(this.func_234616_v_().func_70040_Z().func_186678_a(16.0));
            }
            final Vector3d velocity = new Vector3d(this.func_226277_ct_() - destPoint.func_82615_a(), this.func_226278_cu_() + this.func_213302_cg() / 2.0f - destPoint.func_82617_b(), this.func_226281_cx_() - destPoint.func_82616_c());
            this.func_213293_j(-velocity.func_82615_a(), -velocity.func_82617_b(), -velocity.func_82616_c());
            final float currentSpeed = MathHelper.func_76133_a(this.func_213322_ci().func_82615_a() * this.func_213322_ci().func_82615_a() + this.func_213322_ci().func_82617_b() * this.func_213322_ci().func_82617_b() + this.func_213322_ci().func_82616_c() * this.func_213322_ci().func_82616_c());
            final float maxSpeed = 0.5f;
            if (currentSpeed > maxSpeed) {
                this.func_213317_d(new Vector3d(this.func_213322_ci().func_82615_a() / (currentSpeed / maxSpeed), this.func_213322_ci().func_82617_b() / (currentSpeed / maxSpeed), this.func_213322_ci().func_82616_c() / (currentSpeed / maxSpeed)));
            }
            else {
                final float slow = 0.5f;
                this.func_213322_ci().func_216372_d((double)slow, (double)slow, (double)slow);
            }
            this.affectBlocksInAABB(this.func_174813_aQ().func_72314_b(0.20000000298023224, 0.20000000298023224, 0.20000000298023224));
        }
    }
    
    public void func_70106_y() {
        super.func_70106_y();
        final LivingEntity thrower = (LivingEntity)this.func_234616_v_();
        if (thrower != null && thrower.func_184607_cu().func_77973_b() == TFItems.cube_of_annihilation.get()) {
            thrower.func_184602_cy();
        }
    }
    
    private boolean isReturning() {
        if (this.hasHitObstacle || this.func_234616_v_() == null || !(this.func_234616_v_() instanceof PlayerEntity)) {
            return true;
        }
        final PlayerEntity player = (PlayerEntity)this.func_234616_v_();
        return !player.func_184587_cr();
    }
    
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
