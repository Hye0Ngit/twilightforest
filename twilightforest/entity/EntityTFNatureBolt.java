// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFNatureBolt extends EntityThrowable
{
    private EntityPlayer playerTarget;
    
    public EntityTFNatureBolt(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFNatureBolt(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFNatureBolt(final World par1World) {
        super(par1World);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_72869_a("happyVillager", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null && par1MovingObjectPosition.field_72308_g instanceof EntityLivingBase && par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76354_b((Entity)this, (Entity)this.func_85052_h()), 2.0f)) {
            final byte poisonStrength = (byte)((this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) ? 0 : ((this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) ? 3 : 7));
            if (poisonStrength > 0) {
                ((EntityLivingBase)par1MovingObjectPosition.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, poisonStrength * 20, 0));
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b((Block)Blocks.field_150362_t) + "_0", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
            if (par1MovingObjectPosition != null) {
                final int dx = MathHelper.func_76128_c((double)par1MovingObjectPosition.field_72311_b);
                final int dy = MathHelper.func_76128_c((double)par1MovingObjectPosition.field_72312_c);
                final int dz = MathHelper.func_76128_c((double)par1MovingObjectPosition.field_72309_d);
                final Material materialHit = this.field_70170_p.func_147439_a(dx, dy, dz).func_149688_o();
                if (materialHit == Material.field_151577_b && this.playerTarget != null) {
                    Items.field_151100_aR.func_77648_a(new ItemStack(Items.field_151100_aR, 1, 15), this.playerTarget, this.field_70170_p, dx, dy, dz, 0, 0.0f, 0.0f, 0.0f);
                }
                else if (materialHit.func_76220_a() && this.canReplaceBlock(this.field_70170_p, dx, dy, dz)) {
                    this.field_70170_p.func_147465_d(dx, dy, dz, (Block)Blocks.field_150362_t, 2, 3);
                }
            }
        }
    }
    
    private boolean canReplaceBlock(final World worldObj, final int dx, final int dy, final int dz) {
        final Block blockObj;
        final Block blockID = blockObj = worldObj.func_147439_a(dx, dy, dz);
        final float hardness = (blockObj == null) ? -1.0f : blockObj.func_149712_f(worldObj, dx, dy, dz);
        return hardness >= 0.0f && hardness < 50.0f;
    }
    
    public void setTarget(final EntityLivingBase attackTarget) {
        if (attackTarget instanceof EntityPlayer) {
            this.playerTarget = (EntityPlayer)attackTarget;
        }
    }
}
