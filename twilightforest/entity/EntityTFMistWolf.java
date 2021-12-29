// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFMistWolf extends EntityTFHostileWolf
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFMistWolf(final World world) {
        super(world);
        this.func_70105_a(1.4f, 1.9f);
        this.func_175547_a(EnumDyeColor.GRAY);
    }
    
    @Override
    protected void setAttributes() {
        super.setAttributes();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (super.func_70652_k(entity)) {
            final float myBrightness = this.func_70013_c();
            if (entity instanceof EntityLivingBase && myBrightness < 0.1f) {
                int effectDuration = 0;
                switch (this.field_70170_p.func_175659_aa()) {
                    case EASY: {
                        effectDuration = 0;
                        break;
                    }
                    default: {
                        effectDuration = 7;
                        break;
                    }
                    case HARD: {
                        effectDuration = 15;
                        break;
                    }
                }
                if (effectDuration > 0) {
                    ((EntityLivingBase)entity).func_70690_d(new PotionEffect(MobEffects.field_76440_q, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.6f;
    }
    
    @Override
    protected ResourceLocation func_184647_J() {
        return EntityTFMistWolf.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/mist_wolf");
    }
}
