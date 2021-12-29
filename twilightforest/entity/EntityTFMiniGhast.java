// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityTFMiniGhast extends EntityTFTowerGhast
{
    public boolean isMinion;
    
    public EntityTFMiniGhast(final World par1World) {
        super(par1World);
        this.isMinion = false;
        this.func_70105_a(1.1f, 1.5f);
        this.aggroRange = 16.0f;
        this.stareRange = 8.0f;
        this.wanderFactor = 4.0f;
    }
    
    @Override
    public int func_70641_bl() {
        return 16;
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(this.isMinion ? 6.0 : 10.0);
    }
    
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        final byte aggroStatus = this.field_70180_af.func_75683_a(16);
    }
    
    @Override
    protected boolean shouldAttackPlayer(final EntityPlayer par1EntityPlayer) {
        final ItemStack playerHeadArmor = par1EntityPlayer.field_71071_by.field_70460_b[3];
        if (playerHeadArmor != null && playerHeadArmor.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) {
            return false;
        }
        if (par1EntityPlayer.func_70032_d((Entity)this) <= 3.5f && par1EntityPlayer.func_70685_l((Entity)this)) {
            return true;
        }
        final Vec3 var3 = par1EntityPlayer.func_70676_i(1.0f).func_72432_b();
        Vec3 var4 = Vec3.func_72443_a(this.field_70165_t - par1EntityPlayer.field_70165_t, this.field_70121_D.field_72338_b + this.field_70131_O / 2.0f - (par1EntityPlayer.field_70163_u + par1EntityPlayer.func_70047_e()), this.field_70161_v - par1EntityPlayer.field_70161_v);
        final double var5 = var4.func_72433_c();
        var4 = var4.func_72432_b();
        final double var6 = var3.func_72430_b(var4);
        return var6 > 1.0 - 0.025 / var5 && par1EntityPlayer.func_70685_l((Entity)this);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        if (this.isMinion) {
            return true;
        }
        final int myX = MathHelper.func_76128_c(this.field_70165_t);
        final int myY = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        final int myZ = MathHelper.func_76128_c(this.field_70161_v);
        if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, myX, myY, myZ) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int lightLevel = this.field_70170_p.func_72957_l(myX, myY, myZ);
        if (this.field_70170_p.func_72911_I()) {
            final int var5 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            lightLevel = this.field_70170_p.func_72957_l(myX, myY, myZ);
            this.field_70170_p.field_73008_k = var5;
        }
        return lightLevel <= this.field_70146_Z.nextInt(8);
    }
    
    public void makeBossMinion() {
        this.wanderFactor = 0.005f;
        this.isMinion = true;
        this.func_70606_j(this.func_110138_aP());
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        if (!this.isMinion) {
            super.func_70628_a(par1, par2);
        }
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        nbttagcompound.func_74757_a("isMinion", this.isMinion);
        super.func_70014_b(nbttagcompound);
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        if (nbttagcompound.func_74767_n("isMinion")) {
            this.makeBossMinion();
        }
    }
}
