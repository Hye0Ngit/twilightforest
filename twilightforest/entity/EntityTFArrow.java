// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityArrow;

public abstract class EntityTFArrow extends EntityArrow implements ITFProjectile
{
    public EntityTFArrow(final World worldIn) {
        super(worldIn);
    }
    
    public EntityTFArrow(final World worldIn, final EntityLivingBase shooter) {
        super(worldIn, shooter);
    }
    
    protected ItemStack func_184550_j() {
        return new ItemStack(Items.field_151032_g);
    }
    
    public Entity getThrower() {
        return this.field_70250_c;
    }
    
    public void setThrower(final Entity entity) {
        this.field_70250_c = entity;
    }
}
