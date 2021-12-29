// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.core.Position;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;

public abstract class MoonwormDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    
    public MoonwormDispenseBehavior() {
        this.fired = false;
    }
    
    public ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
        final Level world = (Level)source.m_7727_();
        final Position iposition = DispenserBlock.m_52720_(source);
        final Direction direction = (Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_);
        if (!world.f_46443_ && stack.m_41776_() != stack.m_41773_() + 2) {
            final Projectile projectileentity = this.getProjectileEntity(world, iposition, stack);
            projectileentity.m_6686_((double)direction.m_122429_(), (double)(direction.m_122430_() + 0.1f), (double)direction.m_122431_(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
            world.m_7967_((Entity)projectileentity);
            if (stack.m_41629_(2, world.f_46441_, (ServerPlayer)null)) {
                stack.m_41764_(0);
            }
            this.fired = true;
        }
        return stack;
    }
    
    protected void m_6823_(final BlockSource source) {
        if (this.fired) {
            source.m_7727_().m_6263_((Player)null, source.m_7096_(), source.m_7098_(), source.m_7094_(), TFSounds.MOONWORM_SQUISH, SoundSource.NEUTRAL, 1.0f, 1.0f);
            this.fired = false;
        }
        else {
            source.m_7727_().m_46796_(1001, source.m_7961_(), 0);
        }
    }
    
    protected abstract Projectile getProjectileEntity(final Level p0, final Position p1, final ItemStack p2);
    
    protected float getProjectileInaccuracy() {
        return 18.0f;
    }
    
    protected float getProjectileVelocity() {
        return 1.1f;
    }
}
