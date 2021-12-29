// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import java.util.Random;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.util.math.vector.Vector3i;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.Property;
import net.minecraft.block.DispenserBlock;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;

public class FeatherFanDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    
    public FeatherFanDispenseBehavior() {
        this.fired = false;
    }
    
    protected ItemStack func_82487_b(final IBlockSource source, final ItemStack stack) {
        final World world = (World)source.func_197524_h();
        final BlockPos blockpos = source.func_180699_d().func_177972_a((Direction)source.func_189992_e().func_177229_b((Property)DispenserBlock.field_176441_a));
        final int damage = stack.func_77958_k() - stack.func_77952_i();
        if (!world.field_72995_K) {
            final List<LivingEntity> thingsToPush = world.func_175647_a((Class)LivingEntity.class, new AxisAlignedBB(blockpos).func_186662_g(3.0), EntityPredicates.field_180132_d);
            if (thingsToPush.size() < damage) {
                for (final Entity entity : thingsToPush) {
                    final Vector3i lookVec = ((Direction)world.func_180495_p(source.func_180699_d()).func_177229_b((Property)DispenserBlock.field_176441_a)).func_176730_m();
                    if (entity.func_70104_M() || entity instanceof ItemEntity) {
                        entity.func_213293_j((double)lookVec.func_177958_n(), (double)lookVec.func_177956_o(), (double)lookVec.func_177952_p());
                    }
                    if (stack.func_96631_a(1, world.field_73012_v, (ServerPlayerEntity)null)) {
                        stack.func_190920_e(0);
                    }
                }
                this.fired = true;
            }
        }
        return stack;
    }
    
    protected void func_82485_a(final IBlockSource source) {
        if (this.fired) {
            final Random random = source.func_197524_h().func_201674_k();
            source.func_197524_h().func_184133_a((PlayerEntity)null, source.func_180699_d(), TFSounds.FAN_WOOSH, SoundCategory.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
            this.fired = false;
        }
        else {
            source.func_197524_h().func_217379_c(1001, source.func_180699_d(), 0);
        }
    }
    
    protected void func_82489_a(final IBlockSource source, final Direction direction) {
        final BlockPos blockpos = source.func_180699_d().func_177972_a((Direction)source.func_189992_e().func_177229_b((Property)DispenserBlock.field_176441_a));
        final World world = (World)source.func_197524_h();
        final Random random = world.func_201674_k();
        final int j1 = direction.func_82601_c();
        final int j2 = direction.func_96559_d();
        final int k2 = direction.func_82599_e();
        final double d18 = blockpos.func_177958_n() + j1 * 0.6 + 0.5;
        final double d19 = blockpos.func_177956_o() + j2 * 0.6 + 0.5;
        final double d20 = blockpos.func_177952_p() + k2 * 0.6 + 0.5;
        for (int i = 0; i < 30; ++i) {
            final double d21 = random.nextDouble() * 0.2 + 0.01;
            final double d22 = d18 + j1 * 0.01 + (random.nextDouble() - 0.5) * k2 * 0.5;
            final double d23 = d19 + j2 * 0.01 + (random.nextDouble() - 0.5) * j2 * 0.5;
            final double d24 = d20 + k2 * 0.01 + (random.nextDouble() - 0.5) * j1 * 0.5;
            final double d25 = j1 * d21 + random.nextGaussian() * 0.01;
            final double d26 = j2 * d21 + random.nextGaussian() * 0.01;
            final double d27 = k2 * d21 + random.nextGaussian() * 0.01;
            world.func_195594_a((IParticleData)ParticleTypes.field_197613_f, d22, d23, d24, d25, d26, d27);
        }
    }
}
