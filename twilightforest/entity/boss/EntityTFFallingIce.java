// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import twilightforest.TwilightForestMod;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EntityTFFallingIce extends Entity
{
    private static final int HANG_TIME = 100;
    private int fallTime;
    private float hurtAmount;
    private int hurtMax;
    
    public EntityTFFallingIce(final World par1World) {
        super(par1World);
        this.func_70105_a(2.98f, 2.98f);
        this.hurtAmount = 10.0f;
        this.hurtMax = 30;
    }
    
    public EntityTFFallingIce(final World par1World, final int x, final int y, final int z) {
        this(par1World);
        this.field_70156_m = true;
        this.func_70107_b((double)x, (double)y, (double)z);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = x;
        this.field_70167_r = y;
        this.field_70166_s = z;
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70088_a() {
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        ++this.fallTime;
        if (this.fallTime > 100) {
            this.field_70181_x -= 0.03999999910593033;
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= 0.9800000190734863;
        this.field_70181_x *= 0.9800000190734863;
        this.field_70179_y *= 0.9800000190734863;
        if (!this.field_70170_p.field_72995_K && this.field_70122_E) {
            this.field_70159_w *= 0.699999988079071;
            this.field_70179_y *= 0.699999988079071;
            this.field_70181_x *= -0.5;
            this.func_70106_y();
        }
        if (!this.field_70170_p.field_72995_K) {
            final ArrayList<Entity> nearby = new ArrayList<Entity>(this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D));
            for (final Entity entity : nearby) {
                if (entity instanceof EntityTFFallingIce) {
                    final EntityTFFallingIce otherIce = (EntityTFFallingIce)entity;
                    if (otherIce.getFallTime() >= this.fallTime) {
                        continue;
                    }
                    otherIce.func_70106_y();
                }
            }
            this.destroyIceInAABB(this.field_70121_D.func_72314_b(0.5, 0.0, 0.5));
        }
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.field_70165_t + 2.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dy = this.field_70163_u - 3.0 + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dz = this.field_70161_v + 2.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowwarning", dx, dy, dz, 0.0, -1.0, 0.0);
        }
    }
    
    protected void func_70069_a(final float par1) {
        final int distance = MathHelper.func_76123_f(par1 - 1.0f);
        if (distance > 0) {
            final ArrayList<Entity> nearby = new ArrayList<Entity>(this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(2.0, 0.0, 2.0)));
            final DamageSource damagesource = DamageSource.field_82729_p;
            for (final Entity entity : nearby) {
                if (!(entity instanceof EntityTFYetiAlpha)) {
                    entity.func_70097_a(damagesource, (float)Math.min(MathHelper.func_76141_d(distance * this.hurtAmount), this.hurtMax));
                }
            }
        }
        for (int i = 0; i < 200; ++i) {
            final double dx = this.field_70165_t + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dy = this.field_70163_u + 2.0 + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            final double dz = this.field_70161_v + 3.0f * (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat());
            this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(Blocks.field_150403_cj) + "_0", dx, dy, dz, 0.0, 0.0, 0.0);
        }
        this.func_85030_a(Blocks.field_150467_bQ.field_149762_H.func_150495_a(), 3.0f, 0.5f);
        this.func_85030_a(Blocks.field_150403_cj.field_149762_H.func_150495_a(), 3.0f, 0.5f);
    }
    
    public void destroyIceInAABB(final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final Block block = this.field_70170_p.func_147439_a(dx, dy, dz);
                    if (block == Blocks.field_150432_aD || block == Blocks.field_150403_cj || block == Blocks.field_150348_b) {
                        this.field_70170_p.func_147465_d(dx, dy, dz, Blocks.field_150350_a, 0, 3);
                    }
                }
            }
        }
    }
    
    protected void func_70037_a(final NBTTagCompound var1) {
    }
    
    protected void func_70014_b(final NBTTagCompound var1) {
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }
    
    public Block getBlock() {
        return Blocks.field_150403_cj;
    }
    
    public int getFallTime() {
        return this.fallTime;
    }
}
