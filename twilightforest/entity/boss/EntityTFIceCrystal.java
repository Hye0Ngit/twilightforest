// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

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

public class EntityTFIceCrystal extends EntityMob
{
    private int crystalAge;
    public int maxCrystalAge;
    
    public EntityTFIceCrystal(final World par1World) {
        super(par1World);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70105_a(0.6f, 1.8f);
        this.maxCrystalAge = -1;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected Item func_146068_u() {
        return Items.field_151126_ay;
    }
    
    public int func_70641_bl() {
        return 8;
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
    
    public void setToDieIn30Seconds() {
        this.maxCrystalAge = 600;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        ++this.crystalAge;
        if (this.maxCrystalAge > 0 && this.crystalAge >= this.maxCrystalAge && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}
