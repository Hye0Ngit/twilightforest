// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.item.TFItems;
import net.minecraft.util.MovingObjectPosition;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFMoonwormShot extends EntityThrowable
{
    public EntityTFMoonwormShot(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFMoonwormShot(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFMoonwormShot(final World par1World) {
        super(par1World);
    }
    
    protected float func_40077_c() {
        return 0.5f;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    public float func_70013_c(final float par1) {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b(final float par1) {
        return 15728880;
    }
    
    public void makeTrail() {
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    protected float func_70185_h() {
        return 0.03f;
    }
    
    protected void func_70184_a(final MovingObjectPosition mop) {
        if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && !this.field_70170_p.field_72995_K) {
            TFItems.moonwormQueen.func_77648_a((ItemStack)null, (EntityPlayer)this.func_85052_h(), this.field_70170_p, mop.field_72311_b, mop.field_72312_c, mop.field_72309_d, mop.field_72310_e, 0.0f, 0.0f, 0.0f);
        }
        if (mop.field_72308_g != null) {
            mop.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 0.0f);
        }
        for (int var3 = 0; var3 < 8; ++var3) {
            this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(TFBlocks.moonworm) + "_0", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}
