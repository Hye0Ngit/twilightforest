// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.projectile.ThrownWep;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.world.entity.ai.goal.Goal;

public class PhantomThrowWeaponGoal extends Goal
{
    private final KnightPhantom boss;
    
    public PhantomThrowWeaponGoal(final KnightPhantom entity) {
        this.boss = entity;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        return this.boss.m_5448_() != null && this.boss.getCurrentFormation() == KnightPhantom.Formation.ATTACK_PLAYER_ATTACK;
    }
    
    public void m_8037_() {
        if (this.boss.m_5448_() != null && this.boss.getTicksProgress() % 4 == 0) {
            if (this.boss.isAxeKnight()) {
                this.launchAxeAt((Entity)this.boss.m_5448_());
            }
            else if (this.boss.isPickKnight()) {
                this.launchPicks();
            }
        }
    }
    
    private void launchAxeAt(final Entity targetedEntity) {
        final float bodyFacingAngle = this.boss.f_20883_ * 3.141593f / 180.0f;
        final double sx = this.boss.m_20185_() + Mth.m_14089_(bodyFacingAngle) * 1.0f;
        final double sy = this.boss.m_20186_() + this.boss.m_20206_() * 0.82;
        final double sz = this.boss.m_20189_() + Mth.m_14031_(bodyFacingAngle) * 1.0f;
        final double tx = targetedEntity.m_20185_() - sx;
        final double ty = targetedEntity.m_142469_().f_82289_ + targetedEntity.m_20206_() / 2.0f - (this.boss.m_20186_() + this.boss.m_20206_() / 2.0f);
        final double tz = targetedEntity.m_20189_() - sz;
        this.boss.m_5496_(TFSounds.PHANTOM_THROW_AXE, 1.0f, (this.boss.m_21187_().nextFloat() - this.boss.m_21187_().nextFloat()) * 0.2f + 0.4f);
        final ThrownWep projectile = new ThrownWep(TFEntities.THROWN_WEP, this.boss.f_19853_, (LivingEntity)this.boss).setItem(new ItemStack((ItemLike)TFItems.KNIGHTMETAL_AXE.get()));
        final float speed = 0.75f;
        projectile.m_6686_(tx, ty, tz, speed, 1.0f);
        projectile.m_7678_(sx, sy, sz, this.boss.m_146908_(), this.boss.m_146909_());
        this.boss.f_19853_.m_7967_((Entity)projectile);
    }
    
    private void launchPicks() {
        this.boss.m_5496_(TFSounds.PHANTOM_THROW_PICK, 1.0f, (this.boss.m_21187_().nextFloat() - this.boss.m_21187_().nextFloat()) * 0.2f + 0.4f);
        for (int i = 0; i < 8; ++i) {
            final float throwAngle = i * 3.1415915f / 4.0f;
            final double sx = this.boss.m_20185_() + Mth.m_14089_(throwAngle) * 1.0f;
            final double sy = this.boss.m_20186_() + this.boss.m_20206_() * 0.82;
            final double sz = this.boss.m_20189_() + Mth.m_14031_(throwAngle) * 1.0f;
            final double vx = Mth.m_14089_(throwAngle);
            final double vy = 0.0;
            final double vz = Mth.m_14031_(throwAngle);
            final ThrownWep projectile = new ThrownWep(TFEntities.THROWN_WEP, this.boss.f_19853_, (LivingEntity)this.boss).setDamage(3.0f).setVelocity(0.015f).setItem(new ItemStack((ItemLike)TFItems.KNIGHTMETAL_PICKAXE.get()));
            projectile.m_7678_(sx, sy, sz, i * 45.0f, this.boss.m_146909_());
            final float speed = 0.5f;
            projectile.m_6686_(vx, vy, vz, speed, 1.0f);
            this.boss.f_19853_.m_7967_((Entity)projectile);
        }
    }
}
