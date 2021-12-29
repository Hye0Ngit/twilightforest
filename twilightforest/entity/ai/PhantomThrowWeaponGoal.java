// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import twilightforest.entity.boss.ThrownWepEntity;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import twilightforest.entity.boss.KnightPhantomEntity;
import net.minecraft.entity.ai.goal.Goal;

public class PhantomThrowWeaponGoal extends Goal
{
    private final KnightPhantomEntity boss;
    
    public PhantomThrowWeaponGoal(final KnightPhantomEntity entity) {
        this.boss = entity;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        return this.boss.func_70638_az() != null && this.boss.getCurrentFormation() == KnightPhantomEntity.Formation.ATTACK_PLAYER_ATTACK;
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
        final double sx = this.boss.func_226277_ct_() + MathHelper.func_76134_b(bodyFacingAngle) * 1.0f;
        final double sy = this.boss.func_226278_cu_() + this.boss.func_213302_cg() * 0.82;
        final double sz = this.boss.func_226281_cx_() + MathHelper.func_76126_a(bodyFacingAngle) * 1.0f;
        final double tx = targetedEntity.func_226277_ct_() - sx;
        final double ty = targetedEntity.func_174813_aQ().field_72338_b + targetedEntity.func_213302_cg() / 2.0f - (this.boss.func_226278_cu_() + this.boss.func_213302_cg() / 2.0f);
        final double tz = targetedEntity.func_226281_cx_() - sz;
        this.boss.func_184185_a(TFSounds.PHANTOM_THROW_AXE, 1.0f, (this.boss.func_70681_au().nextFloat() - this.boss.func_70681_au().nextFloat()) * 0.2f + 0.4f);
        final ThrownWepEntity projectile = new ThrownWepEntity(TFEntities.thrown_wep, this.boss.field_70170_p, (LivingEntity)this.boss).setItem(new ItemStack((IItemProvider)TFItems.knightmetal_axe.get()));
        final float speed = 0.75f;
        projectile.func_70186_c(tx, ty, tz, speed, 1.0f);
        projectile.func_70012_b(sx, sy, sz, this.boss.field_70177_z, this.boss.field_70125_A);
        this.boss.field_70170_p.func_217376_c((Entity)projectile);
    }
    
    private void launchPicks() {
        this.boss.func_184185_a(TFSounds.PHANTOM_THROW_PICK, 1.0f, (this.boss.func_70681_au().nextFloat() - this.boss.func_70681_au().nextFloat()) * 0.2f + 0.4f);
        for (int i = 0; i < 8; ++i) {
            final float throwAngle = i * 3.1415915f / 4.0f;
            final double sx = this.boss.func_226277_ct_() + MathHelper.func_76134_b(throwAngle) * 1.0f;
            final double sy = this.boss.func_226278_cu_() + this.boss.func_213302_cg() * 0.82;
            final double sz = this.boss.func_226281_cx_() + MathHelper.func_76126_a(throwAngle) * 1.0f;
            final double vx = MathHelper.func_76134_b(throwAngle);
            final double vy = 0.0;
            final double vz = MathHelper.func_76126_a(throwAngle);
            final ThrownWepEntity projectile = new ThrownWepEntity(TFEntities.thrown_wep, this.boss.field_70170_p, (LivingEntity)this.boss).setDamage(3.0f).setVelocity(0.015f).setItem(new ItemStack((IItemProvider)TFItems.knightmetal_pickaxe.get()));
            projectile.func_70012_b(sx, sy, sz, i * 45.0f, this.boss.field_70125_A);
            final float speed = 0.5f;
            projectile.func_70186_c(vx, vy, vz, speed, 1.0f);
            this.boss.field_70170_p.func_217376_c((Entity)projectile);
        }
    }
}
