// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import java.util.Iterator;
import java.util.List;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.entity.item.EntityFallingBlock;

public class EntityTFFallingIce extends EntityFallingBlock
{
    private static final int HANG_TIME = 100;
    
    public EntityTFFallingIce(final World world) {
        super(world, 0.0, 0.0, 0.0, Blocks.field_150403_cj.func_176223_P());
        this.func_70105_a(2.98f, 2.98f);
    }
    
    public EntityTFFallingIce(final World world, final int x, final int y, final int z) {
        super(world, (double)x, (double)y, (double)z, Blocks.field_150403_cj.func_176223_P());
        this.func_70105_a(2.98f, 2.98f);
        this.field_145816_i = 10.0f;
        this.field_145815_h = 30;
        this.func_145806_a(true);
    }
    
    public void func_70071_h_() {
        if (this.field_145812_b > 100) {
            this.func_189654_d(true);
        }
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            final List<EntityTFFallingIce> nearby = this.field_70170_p.func_72872_a((Class)EntityTFFallingIce.class, this.func_174813_aQ());
            for (final EntityTFFallingIce entity : nearby) {
                if (entity != this && entity.field_145812_b < this.field_145812_b) {
                    entity.func_70106_y();
                }
            }
            this.destroyIceInAABB(this.func_174813_aQ().func_72314_b(0.5, 0.0, 0.5));
        }
        else {
            this.makeTrail();
        }
    }
    
    private void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.field_70165_t + 2.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dy = this.field_70163_u - 3.0 + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dz = this.field_70161_v + 2.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW_WARNING, dx, dy, dz, 0.0, -1.0, 0.0);
        }
    }
    
    public void func_180430_e(final float distance, final float multiplier) {
        if (this.field_145809_g) {
            final int i = MathHelper.func_76123_f(distance - 1.0f);
            if (i > 0) {
                final List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ());
                final DamageSource damagesource = DamageSource.field_82729_p;
                for (final Entity entity : list) {
                    if (!(entity instanceof EntityTFYetiAlpha)) {
                        entity.func_70097_a(damagesource, (float)Math.min(MathHelper.func_76141_d(i * this.field_145816_i), this.field_145815_h));
                    }
                }
            }
        }
        final int stateId = Block.func_176210_f(Blocks.field_150403_cj.func_176223_P());
        for (int j = 0; j < 200; ++j) {
            final double dx = this.field_70165_t + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dy = this.field_70163_u + 2.0 + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dz = this.field_70161_v + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, dx, dy, dz, 0.0, 0.0, 0.0, new int[] { stateId });
        }
        this.func_184185_a(Blocks.field_150403_cj.getSoundType(Blocks.field_150403_cj.func_176223_P(), this.field_70170_p, this.func_180425_c(), (Entity)null).func_185845_c(), 3.0f, 0.5f);
    }
    
    private void destroyIceInAABB(final AxisAlignedBB aabb) {
        final int minX = MathHelper.func_76128_c(aabb.field_72340_a);
        final int minY = MathHelper.func_76128_c(aabb.field_72338_b);
        final int minZ = MathHelper.func_76128_c(aabb.field_72339_c);
        final int maxX = MathHelper.func_76128_c(aabb.field_72336_d);
        final int maxY = MathHelper.func_76128_c(aabb.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(aabb.field_72334_f);
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final BlockPos pos = new BlockPos(dx, dy, dz);
                    final Block block = this.field_70170_p.func_180495_p(pos).func_177230_c();
                    if (block == Blocks.field_150432_aD || block == Blocks.field_150403_cj || block == Blocks.field_150348_b) {
                        this.field_70170_p.func_175655_b(pos, false);
                    }
                }
            }
        }
    }
}
