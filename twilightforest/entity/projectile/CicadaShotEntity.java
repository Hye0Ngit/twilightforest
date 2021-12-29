// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.state.Property;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DirectionalPlaceContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFEntities;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class CicadaShotEntity extends TFThrowableEntity
{
    public CicadaShotEntity(final EntityType<? extends CicadaShotEntity> type, final World world) {
        super(type, world);
    }
    
    public CicadaShotEntity(final World worldIn, @Nullable final LivingEntity living, final double x, final double y, final double z) {
        super(TFEntities.cicada_shot, worldIn);
        final float yaw = (living != null) ? living.field_70177_z : 0.0f;
        final float pitch = (living != null) ? living.field_70125_A : 0.0f;
        this.func_70012_b(living.func_226277_ct_(), living.func_226278_cu_() + living.func_70047_e(), living.func_226281_cx_(), yaw, pitch);
        this.func_70107_b(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
        this.func_213293_j(x, y, z);
        this.func_212361_a((Entity)living);
        final Vector3d motion = this.func_213322_ci();
        this.func_70186_c(motion.field_72450_a, motion.field_72448_b, motion.field_72449_c, 3.0f, 1.0f);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
    }
    
    public float func_70013_c() {
        return 1.0f;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    protected float func_70185_h() {
        return 0.03f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_195590_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, ((Block)TFBlocks.cicada.get()).func_176223_P()), false, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0, 0.0, 0.0);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        if (!this.field_70170_p.field_72995_K) {
            if (ray instanceof BlockRayTraceResult) {
                final BlockRayTraceResult blockray = (BlockRayTraceResult)ray;
                final BlockPos pos = blockray.func_216350_a().func_177972_a(blockray.func_216354_b());
                final BlockState currentState = this.field_70170_p.func_180495_p(pos);
                final DirectionalPlaceContext context = new DirectionalPlaceContext(this.field_70170_p, pos, blockray.func_216354_b(), ItemStack.field_190927_a, blockray.func_216354_b().func_176734_d());
                if (currentState.func_196953_a((BlockItemUseContext)context)) {
                    this.field_70170_p.func_175656_a(pos, (BlockState)((Block)TFBlocks.cicada.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)((BlockRayTraceResult)ray).func_216354_b()));
                }
                else {
                    final ItemEntity squish = new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
                    squish.func_199703_a((IItemProvider)Items.field_196120_bj);
                }
            }
            if (ray instanceof EntityRayTraceResult && ((EntityRayTraceResult)ray).func_216348_a() != null) {
                ((EntityRayTraceResult)ray).func_216348_a().func_70097_a((DamageSource)new IndirectEntityDamageSource("cicada", (Entity)this, (Entity)null), 2.0f);
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
}
