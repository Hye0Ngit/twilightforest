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
import twilightforest.entity.TFEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class MoonwormShotEntity extends TFThrowableEntity
{
    public MoonwormShotEntity(final EntityType<? extends MoonwormShotEntity> type, final World world) {
        super(type, world);
    }
    
    public MoonwormShotEntity(final EntityType<? extends MoonwormShotEntity> type, final World world, final LivingEntity thrower) {
        super(type, world, thrower);
        this.func_234612_a_((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
    }
    
    public MoonwormShotEntity(final World worldIn, final double x, final double y, final double z) {
        super(TFEntities.moonworm_shot, worldIn, x, y, z);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    public float func_70013_c() {
        return 1.0f;
    }
    
    private void makeTrail() {
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
                this.field_70170_p.func_195590_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, ((Block)TFBlocks.moonworm.get()).func_176223_P()), false, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0, 0.0, 0.0);
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
                    this.field_70170_p.func_175656_a(pos, (BlockState)((Block)TFBlocks.moonworm.get()).func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)((BlockRayTraceResult)ray).func_216354_b()));
                }
                else {
                    final ItemEntity squish = new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
                    squish.func_199703_a((IItemProvider)Items.field_196116_bh);
                }
            }
            if (ray instanceof EntityRayTraceResult && ((EntityRayTraceResult)ray).func_216348_a() != null) {
                ((EntityRayTraceResult)ray).func_216348_a().func_70097_a((DamageSource)new IndirectEntityDamageSource("moonworm", (Entity)this, (Entity)this), (this.field_70146_Z.nextInt(3) == 0) ? 1.0f : 0.0f);
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
}
