// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTFNatureBolt extends EntityTFThrowable implements ITFProjectile
{
    public EntityTFNatureBolt(final World world) {
        super(world);
    }
    
    public EntityTFNatureBolt(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
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
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_175688_a(EnumParticleTypes.VILLAGER_HAPPY, dx, dy, dz, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final int stateId = Block.func_176210_f(Blocks.field_150362_t.func_176223_P());
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05, new int[] { stateId });
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70184_a(final RayTraceResult ray) {
        if (!this.field_70170_p.field_72995_K) {
            if (ray.func_178782_a() != null) {
                final Material materialHit = this.field_70170_p.func_180495_p(ray.func_178782_a()).func_185904_a();
                if (materialHit == Material.field_151577_b) {
                    final ItemStack dummy = new ItemStack(Items.field_151100_aR, 1, 15);
                    if (ItemDye.func_179234_a(dummy, this.field_70170_p, ray.func_178782_a())) {
                        this.field_70170_p.func_175718_b(2005, ray.func_178782_a(), 0);
                    }
                }
                else if (materialHit.func_76220_a() && this.canReplaceBlock(this.field_70170_p, ray.func_178782_a())) {
                    this.field_70170_p.func_175656_a(ray.func_178782_a(), Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.BIRCH));
                }
            }
            if (ray.field_72308_g instanceof EntityLivingBase && (this.field_70192_c == null || (ray.field_72308_g != this.field_70192_c && ray.field_72308_g != this.field_70192_c.func_184187_bx())) && ray.field_72308_g.func_70097_a(DamageSource.func_76354_b((Entity)this, (Entity)this.func_85052_h()), 2.0f) && this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL) {
                final int poisonTime = (this.field_70170_p.func_175659_aa() == EnumDifficulty.HARD) ? 7 : 3;
                ((EntityLivingBase)ray.field_72308_g).func_70690_d(new PotionEffect(MobEffects.field_76436_u, poisonTime * 20, 0));
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
    
    private boolean canReplaceBlock(final World world, final BlockPos pos) {
        final float hardness = world.func_180495_p(pos).func_185887_b(world, pos);
        return hardness >= 0.0f && hardness < 50.0f;
    }
}
