// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityTFMistWolf extends EntityTFHostileWolf
{
    public EntityTFMistWolf(final World world) {
        super(world);
        this.func_70105_a(1.4f, 1.9f);
        this.field_70750_az = "/mods/twilightforest/textures/model/mistwolf.png";
    }
    
    public String func_70073_O() {
        return this.field_70750_az;
    }
    
    @Override
    public int func_70667_aM() {
        return 30;
    }
    
    public int getAttackStrength(final Entity par1Entity) {
        return 6;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final int damage = this.getAttackStrength(par1Entity);
        if (par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLiving)this), damage)) {
            final float myBrightness = this.func_70013_c(1.0f);
            if (par1Entity instanceof EntityLiving && myBrightness < 0.1f) {
                byte effectDuration = 0;
                if (this.field_70170_p.field_73013_u > 1) {
                    if (this.field_70170_p.field_73013_u == 2) {
                        effectDuration = 7;
                    }
                    else if (this.field_70170_p.field_73013_u == 3) {
                        effectDuration = 15;
                    }
                }
                if (effectDuration > 0) {
                    ((EntityLiving)par1Entity).func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
}
