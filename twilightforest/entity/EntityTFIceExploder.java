// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.Entity;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import twilightforest.TwilightForestMod;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

public class EntityTFIceExploder extends EntityMob
{
    private static final float EXPLOSION_RADIUS = 1.0f;
    
    public EntityTFIceExploder(final World par1World) {
        super(par1World);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70105_a(0.8f, 1.8f);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected Item func_146068_u() {
        return Items.field_151126_ay;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 3; ++i) {
            final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
            final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowguardian", this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
        }
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.ice.noise";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.ice.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.ice.death";
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.6f;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    protected void func_70609_aI() {
        ++this.field_70725_aQ;
        if (this.field_70725_aQ == 60) {
            final boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
            this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0f, flag);
            if (flag) {
                this.detonate();
            }
            if (!this.field_70170_p.field_72995_K && (this.field_70718_bc > 0 || this.func_70684_aJ()) && this.func_146066_aG() && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                int i = this.func_70693_a(this.field_70717_bb);
                while (i > 0) {
                    final int j = EntityXPOrb.func_70527_a(i);
                    i -= j;
                    this.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
                }
            }
            this.func_70106_y();
            for (int i = 0; i < 20; ++i) {
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d4 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_72869_a("explode", this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d2, d3, d4);
            }
        }
    }
    
    private void detonate() {
        final int range = 4;
        final int sx = MathHelper.func_76128_c(this.field_70165_t);
        final int sy = MathHelper.func_76128_c(this.field_70163_u);
        final int sz = MathHelper.func_76128_c(this.field_70161_v);
        for (int dx = -range; dx <= range; ++dx) {
            for (int dy = -range; dy <= range; ++dy) {
                for (int dz = -range; dz <= range; ++dz) {
                    final double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                    final float randRange = range + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 2.0f;
                    if (distance < randRange) {
                        this.transformBlock(sx + dx, sy + dy, sz + dz);
                    }
                }
            }
        }
    }
    
    private void transformBlock(final int x, final int y, final int z) {
        final Block block = this.field_70170_p.func_147439_a(x, y, z);
        final int meta = this.field_70170_p.func_72805_g(x, y, z);
        if (block.func_149638_a((Entity)this) < 8.0f && block.func_149712_f(this.field_70170_p, x, y, z) >= 0.0f) {
            int blockColor = 16777215;
            try {
                blockColor = block.func_149720_d((IBlockAccess)this.field_70170_p, x, y, z);
            }
            catch (NoSuchMethodError noSuchMethodError) {}
            if (blockColor == 16777215) {
                blockColor = block.func_149728_f(meta).field_76291_p;
            }
            if (this.shouldTransformGlass(block, x, y, z)) {
                this.field_70170_p.func_147465_d(x, y, z, (Block)Blocks.field_150399_cn, this.getMetaForColor(blockColor), 3);
            }
            else if (this.shouldTransformClay(block, x, y, z)) {
                this.field_70170_p.func_147465_d(x, y, z, Blocks.field_150406_ce, this.getMetaForColor(blockColor), 3);
            }
        }
    }
    
    private boolean shouldTransformClay(final Block block, final int x, final int y, final int z) {
        return block.isNormalCube((IBlockAccess)this.field_70170_p, x, y, z);
    }
    
    private boolean shouldTransformGlass(final Block block, final int x, final int y, final int z) {
        return block != Blocks.field_150350_a && this.isBlockNormalBounds(block, x, y, z) && (!block.func_149688_o().func_76218_k() || block.isLeaves((IBlockAccess)this.field_70170_p, x, y, z) || block == Blocks.field_150432_aD || block == TFBlocks.auroraBlock);
    }
    
    private boolean isBlockNormalBounds(final Block block, final int x, final int y, final int z) {
        return block.func_149753_y() == 1.0 && block.func_149669_A() == 1.0 && block.func_149693_C() == 1.0 && block.func_149704_x() == 0.0 && block.func_149665_z() == 0.0 && block.func_149706_B() == 0.0;
    }
    
    private int getMetaForColor(final int blockColor) {
        final int red = blockColor >> 16 & 0xFF;
        final int green = blockColor >> 8 & 0xFF;
        final int blue = blockColor & 0xFF;
        int bestColor = 0;
        int bestDifference = 1024;
        for (int i = 0; i < 15; ++i) {
            final int iColor = Blocks.field_150325_L.func_149728_f(i).field_76291_p;
            final int iRed = iColor >> 16 & 0xFF;
            final int iGreen = iColor >> 8 & 0xFF;
            final int iBlue = iColor & 0xFF;
            final int difference = Math.abs(red - iRed) + Math.abs(green - iGreen) + Math.abs(blue - iBlue);
            if (difference < bestDifference) {
                bestColor = i;
                bestDifference = difference;
            }
        }
        return bestColor;
    }
    
    public int func_70641_bl() {
        return 8;
    }
}
