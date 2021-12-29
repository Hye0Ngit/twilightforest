// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.Item;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFTowerGolem extends EntityMob
{
    private int attackTimer;
    
    public EntityTFTowerGolem(final World par1World) {
        super(par1World);
        this.func_70105_a(1.4f, 2.9f);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(9.0);
    }
    
    public int func_70658_aO() {
        int var1 = super.func_70658_aO() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        this.attackTimer = 10;
        this.field_70170_p.func_72960_a((Entity)this, (byte)4);
        final boolean attackSuccess = super.func_70652_k(par1Entity);
        if (attackSuccess) {
            par1Entity.field_70181_x += 0.4000000059604645;
        }
        this.func_85030_a("mob.irongolem.throw", 1.0f, 1.0f);
        return attackSuccess;
    }
    
    protected String func_70639_aQ() {
        return "none";
    }
    
    protected String func_70621_aR() {
        return "mob.irongolem.hit";
    }
    
    protected String func_70673_aS() {
        return "mob.irongolem.death";
    }
    
    protected void func_145780_a(final int par1, final int par2, final int par3, final Block par4) {
        this.func_85030_a("mob.irongolem.walk", 1.0f, 1.0f);
    }
    
    protected void func_82167_n(final Entity par1Entity) {
        if (par1Entity instanceof IMob && this.func_70681_au().nextInt(10) == 0) {
            this.func_70624_b((EntityLivingBase)par1Entity);
        }
        super.func_82167_n(par1Entity);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7 && this.field_70146_Z.nextInt(5) == 0) {
            final int var1 = MathHelper.func_76128_c(this.field_70165_t);
            final int var2 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224 - this.field_70129_M);
            final int var3 = MathHelper.func_76128_c(this.field_70161_v);
            final Block block = this.field_70170_p.func_147439_a(var1, var2, var3);
            if (block.func_149688_o() != Material.field_151579_a) {
                this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(var1, var2, var3), this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, this.field_70121_D.field_72338_b + 0.1, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, 4.0 * (this.field_70146_Z.nextFloat() - 0.5), 0.5, (this.field_70146_Z.nextFloat() - 0.5) * 4.0);
            }
        }
        if (this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_72869_a("reddust", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.0, 0.0);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte par1) {
        if (par1 == 4) {
            this.attackTimer = 10;
            this.func_85030_a("mob.irongolem.throw", 1.0f, 1.0f);
        }
        else {
            super.func_70103_a(par1);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var4 = this.field_70146_Z.nextInt(3), i = 0; i < var4; ++i) {
            this.func_145779_a(Items.field_151042_j, 1);
        }
        for (int var4 = this.field_70146_Z.nextInt(3), i = 0; i < var4; ++i) {
            this.func_145779_a(Item.func_150898_a(TFBlocks.towerWood), 1);
        }
    }
    
    public int func_70641_bl() {
        return 16;
    }
}
