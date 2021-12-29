// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.block.Block;
import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.ai.EntityAITFRedcapLightTNT;
import twilightforest.entity.ai.EntityAITFRedcapShy;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFRedcap extends EntityMob
{
    public static ItemStack heldPick;
    public static ItemStack heldTNT;
    public static ItemStack heldFlint;
    private boolean shy;
    private int tntLeft;
    
    public EntityTFRedcap(final World world) {
        super(world);
        this.tntLeft = 0;
        this.field_70750_az = "/mods/twilightforest/textures/model/redcap.png";
        this.field_70697_bw = 0.28f;
        this.func_70105_a(0.9f, 1.4f);
        this.shy = true;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityTNTPrimed.class, 2.0f, 0.28f, 0.5f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFRedcapShy(this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFRedcapLightTNT(this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
        this.func_70062_b(0, EntityTFRedcap.heldPick);
        this.func_70062_b(1, new ItemStack((Item)Item.field_77818_ag));
        this.field_82174_bp[0] = 0.2f;
        this.field_82174_bp[1] = 0.2f;
    }
    
    public EntityTFRedcap(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 20;
    }
    
    protected String func_70639_aQ() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String func_70621_aR() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.tf.redcap.die";
    }
    
    protected int func_70633_aT() {
        return Item.field_77705_m.field_77779_bT;
    }
    
    public boolean isShy() {
        return this.shy && this.field_70718_bc <= 0;
    }
    
    public int getTntLeft() {
        return this.tntLeft;
    }
    
    public void setTntLeft(final int tntLeft) {
        this.tntLeft = tntLeft;
    }
    
    public ItemStack getPick() {
        return EntityTFRedcap.heldPick;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("TNTLeft", this.getTntLeft());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setTntLeft(par1NBTTagCompound.func_74762_e("TNTLeft"));
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hill1) {
                ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    static {
        EntityTFRedcap.heldPick = new ItemStack(Item.field_77696_g, 1);
        EntityTFRedcap.heldTNT = new ItemStack(Block.field_72091_am, 1);
        EntityTFRedcap.heldFlint = new ItemStack(Item.field_77709_i, 1);
    }
}
