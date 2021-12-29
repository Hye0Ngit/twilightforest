// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityPig;

public class EntityTFBoar extends EntityPig
{
    public EntityTFBoar(final World world) {
        super(world);
        this.func_70105_a(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return (EntityAnimal)new EntityTFBoar(this.field_70170_p);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
