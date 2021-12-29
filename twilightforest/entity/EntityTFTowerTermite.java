// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import twilightforest.item.TFItems;
import net.minecraft.util.Facing;
import twilightforest.block.TFBlocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFTowerTermite extends EntityMob
{
    private int allySummonCooldown;
    
    public EntityTFTowerTermite(final World par1World) {
        super(par1World);
        this.func_70105_a(0.3f, 0.7f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.27);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected Entity func_70782_k() {
        final double var1 = 8.0;
        return (Entity)this.field_70170_p.func_72856_b((Entity)this, var1);
    }
    
    protected String func_70639_aQ() {
        return "mob.silverfish.say";
    }
    
    protected String func_70621_aR() {
        return "mob.silverfish.hit";
    }
    
    protected String func_70673_aS() {
        return "mob.silverfish.kill";
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final int par2) {
        if (this.func_85032_ar()) {
            return false;
        }
        if (this.allySummonCooldown <= 0 && (par1DamageSource instanceof EntityDamageSource || par1DamageSource == DamageSource.field_76376_m)) {
            this.allySummonCooldown = 20;
        }
        return super.func_70097_a(par1DamageSource, (float)par2);
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.allySummonCooldown > 0) {
            --this.allySummonCooldown;
            if (this.allySummonCooldown == 0) {
                this.tryToSummonAllies();
            }
        }
        if (this.func_70638_az() == null && this.func_70661_as().func_75500_f()) {
            this.tryToBurrow();
        }
    }
    
    protected void tryToSummonAllies() {
        final int sx = MathHelper.func_76128_c(this.field_70165_t);
        final int sy = MathHelper.func_76128_c(this.field_70163_u);
        final int sz = MathHelper.func_76128_c(this.field_70161_v);
        boolean stopSummoning = false;
        for (int dy = 0; !stopSummoning && dy <= 5 && dy >= -5; dy = ((dy <= 0) ? (1 - dy) : (0 - dy))) {
            for (int dx = 0; !stopSummoning && dx <= 10 && dx >= -10; dx = ((dx <= 0) ? (1 - dx) : (0 - dx))) {
                for (int dz = 0; !stopSummoning && dz <= 10 && dz >= -10; dz = ((dz <= 0) ? (1 - dz) : (0 - dz))) {
                    final int blockID = this.field_70170_p.func_72798_a(sx + dx, sy + dy, sz + dz);
                    final int blockMeta = this.field_70170_p.func_72805_g(sx + dx, sy + dy, sz + dz);
                    if (blockID == TFBlocks.towerWood.field_71990_ca && blockMeta == 4) {
                        this.field_70170_p.func_72926_e(2001, sx + dx, sy + dy, sz + dz, blockID + (blockMeta << 12));
                        this.field_70170_p.func_72832_d(sx + dx, sy + dy, sz + dz, 0, 0, 3);
                        TFBlocks.towerWood.func_71898_d(this.field_70170_p, sx + dx, sy + dy, sz + dz, 4);
                        if (this.field_70146_Z.nextBoolean()) {
                            stopSummoning = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    protected void tryToBurrow() {
        int x = MathHelper.func_76128_c(this.field_70165_t);
        int y = MathHelper.func_76128_c(this.field_70163_u + 0.5);
        int z = MathHelper.func_76128_c(this.field_70161_v);
        final int randomFacing = this.field_70146_Z.nextInt(6);
        x += Facing.field_71586_b[randomFacing];
        y += Facing.field_71587_c[randomFacing];
        z += Facing.field_71585_d[randomFacing];
        final int blockIDNearby = this.field_70170_p.func_72798_a(x, y, z);
        final int blockMetaNearby = this.field_70170_p.func_72805_g(x, y, z);
        if (this.canBurrowIn(blockIDNearby, blockMetaNearby)) {
            this.field_70170_p.func_72832_d(x, y, z, TFBlocks.towerWood.field_71990_ca, 4, 3);
            this.func_70656_aK();
            this.func_70106_y();
        }
    }
    
    protected boolean canBurrowIn(final int blockIDNearby, final int blockMetaNearby) {
        return blockIDNearby == TFBlocks.towerWood.field_71990_ca && blockMetaNearby == 0;
    }
    
    protected boolean isInfestedBlock(final int blockIDNearby, final int blockMetaNearby) {
        return blockIDNearby == TFBlocks.towerWood.field_71990_ca && blockMetaNearby == 4;
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.func_85030_a("mob.silverfish.step", 0.15f, 1.0f);
    }
    
    protected int func_70633_aT() {
        return TFItems.borerEssence.field_77779_bT;
    }
    
    public void func_70071_h_() {
        this.field_70761_aq = this.field_70177_z;
        super.func_70071_h_();
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
}
