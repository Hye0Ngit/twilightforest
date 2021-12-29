// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.dispenser.IPosition;
import net.minecraft.world.World;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;

public abstract class MoonwormDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    
    public MoonwormDispenseBehavior() {
        this.fired = false;
    }
    
    public ItemStack func_82487_b(final IBlockSource source, final ItemStack stack) {
        final World world = (World)source.func_197524_h();
        final IPosition iposition = DispenserBlock.func_149939_a(source);
        final Direction direction = (Direction)source.func_189992_e().func_177229_b((Property)DispenserBlock.field_176441_a);
        if (!world.field_72995_K && stack.func_77958_k() != stack.func_77952_i() + 2) {
            final ProjectileEntity projectileentity = this.getProjectileEntity(world, iposition, stack);
            projectileentity.func_70186_c((double)direction.func_82601_c(), (double)(direction.func_96559_d() + 0.1f), (double)direction.func_82599_e(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
            world.func_217376_c((Entity)projectileentity);
            if (stack.func_96631_a(2, world.field_73012_v, (ServerPlayerEntity)null)) {
                stack.func_190920_e(0);
            }
            this.fired = true;
        }
        return stack;
    }
    
    protected void func_82485_a(final IBlockSource source) {
        if (this.fired) {
            source.func_197524_h().func_184148_a((PlayerEntity)null, source.func_82615_a(), source.func_82617_b(), source.func_82616_c(), TFSounds.MOONWORM_SQUISH, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            this.fired = false;
        }
        else {
            source.func_197524_h().func_217379_c(1001, source.func_180699_d(), 0);
        }
    }
    
    protected abstract ProjectileEntity getProjectileEntity(final World p0, final IPosition p1, final ItemStack p2);
    
    protected float getProjectileInaccuracy() {
        return 18.0f;
    }
    
    protected float getProjectileVelocity() {
        return 1.1f;
    }
}
