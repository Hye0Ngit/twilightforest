// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityZombie;

public class EntityTFLichMinion extends EntityZombie
{
    EntityTFLich master;
    
    public EntityTFLichMinion(final World par1World) {
        super(par1World);
        this.master = null;
    }
    
    public EntityTFLichMinion(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public EntityTFLichMinion(final World par1World, final EntityTFLich entityTFLich) {
        super(par1World);
        this.master = entityTFLich;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final int par2) {
        final EntityLiving prevTarget = this.func_70638_az();
        if (super.func_70097_a(par1DamageSource, par2)) {
            if (par1DamageSource.func_76346_g() instanceof EntityTFLich) {
                this.func_70624_b(prevTarget);
                this.func_70604_c(prevTarget);
                this.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 200, 4));
                this.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 200, 1));
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
            this.field_70734_aK = 0;
        }
        super.func_70636_d();
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.field_70170_p.func_72872_a((Class)EntityTFLich.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.field_70165_t, this.field_70163_u + this.func_70047_e(), this.field_70161_v, this.master.field_70165_t, this.master.field_70163_u + this.master.func_70047_e(), this.master.field_70161_v);
                this.func_70624_b(this.master.func_70638_az());
                break;
            }
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public void func_82163_bD() {
        this.func_82164_bB();
        this.func_82162_bC();
    }
    
    protected void func_82164_bB() {
        final float[] equipChances = { 0.0f, 0.25f, 0.75f, 1.0f };
        if (this.field_70146_Z.nextFloat() < equipChances[this.field_70170_p.field_73013_u]) {
            int var1 = this.field_70146_Z.nextInt(2);
            final float var2 = (this.field_70170_p.field_73013_u == 3) ? 0.1f : 0.25f;
            if (this.field_70146_Z.nextFloat() < 0.07f) {
                ++var1;
            }
            if (this.field_70146_Z.nextFloat() < 0.07f) {
                ++var1;
            }
            if (this.field_70146_Z.nextFloat() < 0.07f) {
                ++var1;
            }
            for (int var3 = 3; var3 >= 0; --var3) {
                final ItemStack var4 = this.func_82169_q(var3);
                if (var3 < 3 && this.field_70146_Z.nextFloat() < var2) {
                    break;
                }
                if (var4 == null) {
                    final Item var5 = func_82161_a(var3 + 1, var1);
                    if (var5 != null) {
                        this.func_70062_b(var3 + 1, new ItemStack(var5));
                    }
                }
            }
        }
    }
}
