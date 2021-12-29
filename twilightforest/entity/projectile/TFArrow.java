// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;

public abstract class TFArrow extends AbstractArrow implements ITFProjectile
{
    public TFArrow(final EntityType<? extends TFArrow> type, final Level worldIn) {
        super((EntityType)type, worldIn);
    }
    
    public TFArrow(final EntityType<? extends TFArrow> type, final Level worldIn, final Entity shooter) {
        super((EntityType)type, worldIn);
        this.m_5602_(shooter);
        this.m_6034_(shooter.m_20185_(), shooter.m_20188_() - 0.1, shooter.m_20189_());
    }
    
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    protected ItemStack m_7941_() {
        return new ItemStack((ItemLike)Items.f_42412_);
    }
}
