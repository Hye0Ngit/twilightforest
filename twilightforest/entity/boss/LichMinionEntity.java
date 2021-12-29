// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;

public class LichMinionEntity extends ZombieEntity
{
    LichEntity master;
    
    public LichMinionEntity(final EntityType<? extends LichMinionEntity> type, final World world) {
        super((EntityType)type, world);
        this.master = null;
    }
    
    public LichMinionEntity(final World world, final LichEntity entityTFLich) {
        super(world);
        this.master = entityTFLich;
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        final LivingEntity prevTarget = this.func_70638_az();
        if (super.func_70097_a(source, amount)) {
            if (source.func_76346_g() instanceof LichEntity) {
                this.func_70604_c(prevTarget);
                this.func_195064_c(new EffectInstance(Effects.field_76424_c, 200, 4));
                this.func_195064_c(new EffectInstance(Effects.field_76420_g, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.MINION_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.MINION_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.MINION_DEATH;
    }
    
    protected SoundEvent func_190731_di() {
        return TFSounds.MINION_STEP;
    }
    
    public void func_70636_d() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || !this.master.func_70089_S()) {
            this.func_70606_j(0.0f);
        }
        super.func_70636_d();
    }
    
    private void findNewMaster() {
        final List<LichEntity> nearbyLiches = this.field_70170_p.func_217357_a((Class)LichEntity.class, new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(32.0, 16.0, 32.0));
        for (final LichEntity nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion()) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.func_226277_ct_(), this.func_226278_cu_() + this.func_70047_e(), this.func_226281_cx_(), this.master.func_226277_ct_(), this.master.func_226278_cu_() + this.master.func_70047_e(), this.master.func_226281_cx_());
                this.func_70624_b(this.master.func_70638_az());
                break;
            }
        }
    }
}
