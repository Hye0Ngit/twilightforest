// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFGiantAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFGiantMiner extends EntityMob
{
    public EntityTFGiantMiner(final World par1World) {
        super(par1World);
        this.func_70105_a(this.field_70130_N * 4.0f, this.field_70131_O * 4.0f);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFGiantAttackOnCollide((EntityCreature)this, (Class<? extends EntityLivingBase>)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70062_b(0, new ItemStack(Items.field_151050_s));
        for (int i = 0; i < this.field_82174_bp.length; ++i) {
            this.field_82174_bp[i] = 0.0f;
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected Item func_146068_u() {
        return TFItems.giantPick;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        final Item item = this.func_146068_u();
        if (item != null && par1) {
            this.func_145779_a(item, 1);
        }
    }
    
    public void makeNonDespawning() {
        this.func_110163_bv();
    }
}
