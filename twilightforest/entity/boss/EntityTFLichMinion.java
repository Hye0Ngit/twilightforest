// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.EntityZombie;

public class EntityTFLichMinion extends EntityZombie
{
    private static final DataParameter<Boolean> STRONG;
    EntityTFLich master;
    
    public EntityTFLichMinion(final World world) {
        super(world);
        this.master = null;
    }
    
    public EntityTFLichMinion(final World world, final EntityTFLich entityTFLich) {
        super(world);
        this.master = entityTFLich;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFLichMinion.STRONG, (Object)false);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        final EntityLivingBase prevTarget = this.func_70638_az();
        if (super.func_70097_a(source, amount)) {
            if (source.func_76346_g() instanceof EntityTFLich) {
                this.func_70604_c(prevTarget);
                this.func_70690_d(new PotionEffect(MobEffects.field_76424_c, 200, 4));
                this.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    public void func_70636_d() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || this.master.field_70128_L) {
            this.func_70606_j(0.0f);
        }
        super.func_70636_d();
    }
    
    private void findNewMaster() {
        final List<EntityTFLich> nearbyLiches = this.field_70170_p.func_72872_a((Class)EntityTFLich.class, new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.field_70165_t, this.field_70163_u + this.func_70047_e(), this.field_70161_v, this.master.field_70165_t, this.master.field_70163_u + this.master.func_70047_e(), this.master.field_70161_v);
                this.func_70624_b(this.master.func_70638_az());
                break;
            }
        }
    }
    
    protected void func_70670_a(final PotionEffect effect) {
        super.func_70670_a(effect);
        if (!this.field_70170_p.field_72995_K && effect.func_188419_a() == MobEffects.field_76420_g) {
            this.field_70180_af.func_187227_b((DataParameter)EntityTFLichMinion.STRONG, (Object)true);
        }
    }
    
    protected void func_70688_c(final PotionEffect effect) {
        super.func_70688_c(effect);
        if (!this.field_70170_p.field_72995_K && effect.func_188419_a() == MobEffects.field_76420_g) {
            this.field_70180_af.func_187227_b((DataParameter)EntityTFLichMinion.STRONG, (Object)false);
        }
    }
    
    public boolean isStrong() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFLichMinion.STRONG);
    }
    
    static {
        STRONG = EntityDataManager.func_187226_a((Class)EntityTFLichMinion.class, DataSerializers.field_187198_h);
    }
}
