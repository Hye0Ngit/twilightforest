// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.item.TFItems;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import twilightforest.entity.ai.EntityAITFFindLoose;
import twilightforest.entity.ai.EntityAITFEatLoose;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class EntityTFQuestRam extends EntityAnimal
{
    private int randomTickDivider;
    
    public EntityTFQuestRam(final World par1World) {
        super(par1World);
        this.func_70105_a(1.25f, 2.9f);
        this.randomTickDivider = 0;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.3799999952316284));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.0, Block.field_72101_ab.field_71990_ca, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFEatLoose(this, Block.field_72101_ab.field_71990_ca));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFFindLoose(this, 1.0f, Block.field_72101_ab.field_71990_ca));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return null;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(70.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.10000001192092896);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (Object)0);
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70629_bd() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.field_70146_Z.nextInt(50);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) / 16;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p);
            if (nearFeature != TFFeature.questGrove) {
                this.func_110177_bN();
            }
            else {
                final ChunkCoordinates cc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v), this.field_70170_p);
                this.func_110171_b(cc.field_71574_a, cc.field_71572_b, cc.field_71573_c, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.func_70629_bd();
    }
    
    private void rewardQuest() {
        this.func_70054_a(Block.field_72071_ax.field_71990_ca, 1, 1.0f);
        this.func_70054_a(Block.field_72083_ai.field_71990_ca, 1, 1.0f);
        this.func_70054_a(Block.field_72076_bV.field_71990_ca, 1, 1.0f);
        this.func_70054_a(Block.field_72105_ah.field_71990_ca, 1, 1.0f);
        this.func_70054_a(Block.field_71948_O.field_71990_ca, 1, 1.0f);
        this.func_70054_a(TFItems.crumbleHorn.field_77779_bT, 1, 1.0f);
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        final ItemStack currentItem = par1EntityPlayer.field_71071_by.func_70448_g();
        if (currentItem != null && currentItem.field_77993_c == Block.field_72101_ab.field_71990_ca && !this.isColorPresent(currentItem.func_77960_j())) {
            this.setColorPresent(currentItem.func_77960_j());
            this.animateAddColor(currentItem.func_77960_j(), 50);
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack = currentItem;
                --itemStack.field_77994_a;
                if (currentItem.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        return super.func_70085_c(par1EntityPlayer);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        this.checkAndAnimateColors();
    }
    
    public void checkAndAnimateColors() {
        if (this.countColorsSet() > 15 && !this.getRewarded()) {
            this.animateAddColor(this.field_70146_Z.nextInt(16), 5);
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("ColorFlags", this.getColorFlags());
        par1NBTTagCompound.func_74757_a("Rewarded", this.getRewarded());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setColorFlags(par1NBTTagCompound.func_74762_e("ColorFlags"));
        this.setRewarded(par1NBTTagCompound.func_74767_n("Rewarded"));
    }
    
    public int getColorFlags() {
        return this.field_70180_af.func_75679_c(16);
    }
    
    public void setColorFlags(final int par1) {
        this.field_70180_af.func_75692_b(16, (Object)par1);
    }
    
    public boolean isColorPresent(final int color) {
        final int flags = this.getColorFlags();
        return (flags & (int)Math.pow(2.0, color)) > 0;
    }
    
    public void setColorPresent(final int color) {
        final int flags = this.getColorFlags();
        this.setColorFlags(flags | (int)Math.pow(2.0, color));
    }
    
    public boolean getRewarded() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setRewarded(final boolean par1) {
        this.field_70180_af.func_75692_b(17, (Object)(par1 ? 1 : ((Byte)0)));
    }
    
    public void animateAddColor(final int color, final int iterations) {
        for (int i = 0; i < iterations; ++i) {
            this.field_70170_p.func_72869_a("mobSpell", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 1.5, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O * 1.5, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 1.5, (double)EntitySheep.field_70898_d[color][0], (double)EntitySheep.field_70898_d[color][1], (double)EntitySheep.field_70898_d[color][2]);
        }
        this.func_70642_aH();
    }
    
    public int countColorsSet() {
        int count = 0;
        for (int i = 0; i < 16; ++i) {
            if (this.isColorPresent(i)) {
                ++count;
            }
        }
        return count;
    }
    
    public void func_70642_aH() {
        this.field_70170_p.func_72956_a((Entity)this, "mob.sheep", this.func_70599_aP(), this.func_70647_i());
    }
    
    protected float func_70599_aP() {
        return 5.0f;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected String func_70639_aQ() {
        return "mob.sheep.say";
    }
    
    protected String func_70621_aR() {
        return "mob.sheep.say";
    }
    
    protected String func_70673_aS() {
        return "mob.sheep.say";
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.func_85030_a("mob.sheep.step", 0.15f, 1.0f);
    }
    
    public float getMaximumHomeDistance() {
        return this.func_110174_bM();
    }
}
