// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.boss.EntityTFThrownWep;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIPhantomThrowWeapon extends EntityAIBase
{
    private final EntityTFKnightPhantom boss;
    
    public EntityAIPhantomThrowWeapon(final EntityTFKnightPhantom entity) {
        this.boss = entity;
        this.func_75248_a(2);
    }
    
    public boolean func_75250_a() {
        return this.boss.func_70638_az() != null && this.boss.getCurrentFormation() == EntityTFKnightPhantom.Formation.ATTACK_PLAYER_ATTACK;
    }
    
    public void func_75246_d() {
        if (this.boss.func_70638_az() != null && this.boss.getTicksProgress() % 4 == 0) {
            if (this.boss.isAxeKnight()) {
                this.launchAxeAt((Entity)this.boss.func_70638_az());
            }
            else if (this.boss.isPickKnight()) {
                this.launchPicks();
            }
        }
    }
    
    private void launchAxeAt(final Entity targetedEntity) {
        final float bodyFacingAngle = this.boss.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.boss.field_70165_t + MathHelper.func_76134_b(bodyFacingAngle) * 1.0f;
        final double sy = this.boss.field_70163_u + this.boss.field_70131_O * 0.82;
        final double sz = this.boss.field_70161_v + MathHelper.func_76126_a(bodyFacingAngle) * 1.0f;
        final double tx = targetedEntity.field_70165_t - sx;
        final double ty = targetedEntity.func_174813_aQ().field_72338_b + targetedEntity.field_70131_O / 2.0f - (this.boss.field_70163_u + this.boss.field_70131_O / 2.0f);
        final double tz = targetedEntity.field_70161_v - sz;
        this.boss.func_184185_a(SoundEvents.field_187797_fA, 1.0f, (this.boss.func_70681_au().nextFloat() - this.boss.func_70681_au().nextFloat()) * 0.2f + 0.4f);
        final EntityTFThrownWep projectile = new EntityTFThrownWep(this.boss.field_70170_p, (EntityLivingBase)this.boss).setItem(new ItemStack(TFItems.knightmetal_axe));
        final float speed = 0.75f;
        projectile.func_70186_c(tx, ty, tz, speed, 1.0f);
        projectile.func_70012_b(sx, sy, sz, this.boss.field_70177_z, this.boss.field_70125_A);
        this.boss.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    private void launchPicks() {
        this.boss.func_184185_a(SoundEvents.field_187737_v, 1.0f, (this.boss.func_70681_au().nextFloat() - this.boss.func_70681_au().nextFloat()) * 0.2f + 0.4f);
        for (int i = 0; i < 8; ++i) {
            final float throwAngle = i * 3.1415915f / 4.0f;
            final double sx = this.boss.field_70165_t + MathHelper.func_76134_b(throwAngle) * 1.0f;
            final double sy = this.boss.field_70163_u + this.boss.field_70131_O * 0.82;
            final double sz = this.boss.field_70161_v + MathHelper.func_76126_a(throwAngle) * 1.0f;
            final double vx = MathHelper.func_76134_b(throwAngle);
            final double vy = 0.0;
            final double vz = MathHelper.func_76126_a(throwAngle);
            final EntityTFThrownWep projectile = new EntityTFThrownWep(this.boss.field_70170_p, (EntityLivingBase)this.boss).setDamage(3.0f).setVelocity(0.015f).setItem(new ItemStack(TFItems.knightmetal_pickaxe));
            projectile.func_70012_b(sx, sy, sz, i * 45.0f, this.boss.field_70125_A);
            final float speed = 0.5f;
            projectile.func_70186_c(vx, vy, vz, speed, 1.0f);
            this.boss.field_70170_p.func_72838_d((Entity)projectile);
        }
    }
}
