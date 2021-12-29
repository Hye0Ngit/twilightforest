// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.item.TFItems;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import twilightforest.entity.ai.EntityTFRavenLookHelper;

public class EntityTFRaven extends EntityTFTinyBird
{
    EntityTFRavenLookHelper ravenLook;
    
    public EntityTFRaven(final World par1World) {
        super(par1World);
        this.ravenLook = new EntityTFRavenLookHelper((EntityLiving)this);
        this.func_70105_a(0.3f, 0.7f);
        this.field_70138_W = 1.0f;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.8500000238418579, Item.field_77690_S.field_77779_bT, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000001192092895);
    }
    
    @Override
    protected void func_70619_bc() {
        super.func_70619_bc();
        this.ravenLook.func_75649_a();
    }
    
    public EntityLookHelper func_70671_ap() {
        return this.ravenLook;
    }
    
    @Override
    protected String func_70639_aQ() {
        return "TwilightForest:mob.raven.caw";
    }
    
    @Override
    protected String func_70621_aR() {
        return "TwilightForest:mob.raven.squawk";
    }
    
    @Override
    protected String func_70673_aS() {
        return "TwilightForest:mob.raven.squawk";
    }
    
    @Override
    protected int func_70633_aT() {
        return TFItems.feather.field_77779_bT;
    }
    
    @Override
    public float func_70603_bj() {
        return 0.3f;
    }
    
    @Override
    public boolean isSpooked() {
        return this.field_70737_aN > 0;
    }
}
