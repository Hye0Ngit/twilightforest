// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.item.BoneMealItem;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.block.Blocks;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.IRendersAsItem;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class NatureBoltEntity extends TFThrowableEntity implements ITFProjectile, IRendersAsItem
{
    public NatureBoltEntity(final EntityType<? extends NatureBoltEntity> type, final World world) {
        super(type, world);
    }
    
    public NatureBoltEntity(final World world, final LivingEntity owner) {
        super(TFEntities.nature_bolt, world, owner);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.func_226277_ct_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.func_226278_cu_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.func_226281_cx_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197632_y, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_195590_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, Blocks.field_196642_W.func_176223_P()), false, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        if (!this.field_70170_p.field_72995_K) {
            if (ray.func_216346_c() == RayTraceResult.Type.BLOCK) {
                final BlockPos blockPosHit = ((BlockRayTraceResult)ray).func_216350_a();
                final Material materialHit = this.field_70170_p.func_180495_p(blockPosHit).func_185904_a();
                if (materialHit == Material.field_151577_b) {
                    final ItemStack dummy = new ItemStack((IItemProvider)Items.field_196106_bc, 1);
                    if (BoneMealItem.func_195966_a(dummy, this.field_70170_p, blockPosHit)) {
                        this.field_70170_p.func_217379_c(2005, blockPosHit, 0);
                    }
                }
                else if (materialHit.func_76220_a() && this.canReplaceBlock(this.field_70170_p, blockPosHit)) {
                    this.field_70170_p.func_175656_a(blockPosHit, Blocks.field_196647_Y.func_176223_P());
                }
            }
            if (ray instanceof EntityRayTraceResult) {
                final Entity owner = this.func_234616_v_();
                final Entity entityHit = ((EntityRayTraceResult)ray).func_216348_a();
                if (entityHit instanceof LivingEntity && (owner == null || (entityHit != owner && entityHit != owner.func_184187_bx())) && entityHit.func_70097_a(TFDamageSources.LEAF_BRAIN((Entity)this, (LivingEntity)this.func_234616_v_()), 2.0f) && this.field_70170_p.func_175659_aa() != Difficulty.PEACEFUL) {
                    final int poisonTime = (this.field_70170_p.func_175659_aa() == Difficulty.HARD) ? 7 : 3;
                    ((LivingEntity)entityHit).func_195064_c(new EffectInstance(Effects.field_76436_u, poisonTime * 20, 0));
                }
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
    
    private boolean canReplaceBlock(final World world, final BlockPos pos) {
        final float hardness = world.func_180495_p(pos).func_185887_b((IBlockReader)world, pos);
        return hardness >= 0.0f && hardness < 50.0f;
    }
    
    public ItemStack func_184543_l() {
        return new ItemStack((IItemProvider)Items.field_151014_N);
    }
}
