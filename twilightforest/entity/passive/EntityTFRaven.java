// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.item.TFItems;
import net.minecraft.entity.ai.EntityLookHelper;
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
        this.field_70750_az = "/mods/twilightforest/textures/model/raven.png";
        this.func_70105_a(0.3f, 0.7f);
        this.field_70138_W = 1.0f;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.38f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.18f, Item.field_77690_S.field_77779_bT, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.25f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    @Override
    public int func_70667_aM() {
        return 10;
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
        return "mob.tf.raven.caw";
    }
    
    @Override
    protected String func_70621_aR() {
        return "mob.tf.raven.squawk";
    }
    
    @Override
    protected String func_70673_aS() {
        return "mob.tf.raven.squawk";
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
    
    @Override
    public String func_70073_O() {
        return this.field_70750_az;
    }
}
