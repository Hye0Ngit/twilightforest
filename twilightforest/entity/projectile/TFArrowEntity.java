// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.AbstractArrowEntity;

public abstract class TFArrowEntity extends AbstractArrowEntity implements ITFProjectile
{
    public TFArrowEntity(final EntityType<? extends TFArrowEntity> type, final World worldIn) {
        super((EntityType)type, worldIn);
    }
    
    public TFArrowEntity(final EntityType<? extends TFArrowEntity> type, final World worldIn, final LivingEntity shooter) {
        super((EntityType)type, shooter, worldIn);
    }
    
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    protected ItemStack func_184550_j() {
        return new ItemStack((IItemProvider)Items.field_151032_g);
    }
}
