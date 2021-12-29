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
import net.minecraft.entity.EntityLivingData;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntitySheep;

public class EntityTFBighorn extends EntitySheep
{
    public EntityTFBighorn(final World world) {
        super(world);
        this.func_70105_a(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public static int func_70895_a(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData) {
        par1EntityLivingData = super.func_110161_a(par1EntityLivingData);
        this.func_70891_b(func_70895_a(this.field_70170_p.field_73012_v));
        return par1EntityLivingData;
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.field_70170_p);
        if (this.field_70146_Z.nextBoolean()) {
            babySheep.func_70891_b(this.func_70896_n());
        }
        else {
            babySheep.func_70891_b(otherParent.func_70896_n());
        }
        return (EntityAnimal)babySheep;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
