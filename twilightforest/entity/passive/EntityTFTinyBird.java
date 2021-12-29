// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraftforge.common.ForgeDirection;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFBirdFly;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;

public class EntityTFTinyBird extends EntityTFBird
{
    private static final int DATA_BIRDTYPE = 16;
    private static final int DATA_BIRDFLAGS = 17;
    private ChunkCoordinates currentFlightTarget;
    private int currentFlightTime;
    
    public EntityTFTinyBird(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/tinybirdbrown.png";
        this.func_70105_a(0.5f, 0.9f);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAITFBirdFly(this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.18f, Item.field_77690_S.field_77779_bT, true));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.25f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.setBirdType(this.field_70146_Z.nextInt(4));
        this.setIsBirdLanded(true);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (Object)0);
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    public int func_70667_aM() {
        return 1;
    }
    
    public String func_70073_O() {
        switch (this.getBirdType()) {
            case 0: {
                return "/mods/twilightforest/textures/model/tinybirdbrown.png";
            }
            case 1: {
                return "/mods/twilightforest/textures/model/tinybirdblue.png";
            }
            case 2: {
                return "/mods/twilightforest/textures/model/tinybirdred.png";
            }
            case 3: {
                return "/mods/twilightforest/textures/model/tinybirdgold.png";
            }
            default: {
                return super.func_70073_O();
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("BirdType", this.getBirdType());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setBirdType(par1NBTTagCompound.func_74762_e("BirdType"));
    }
    
    public int getBirdType() {
        return this.field_70180_af.func_75683_a(16);
    }
    
    public void setBirdType(final int par1) {
        this.field_70180_af.func_75692_b(16, (Object)(byte)par1);
    }
    
    protected String func_70639_aQ() {
        return "mob.tf.tinybird.chirp";
    }
    
    protected String func_70621_aR() {
        return "mob.tf.tinybird.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.tf.tinybird.hurt";
    }
    
    public float func_70603_bj() {
        return 0.3f;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public float func_70783_a(final int par1, final int par2, final int par3) {
        final Material underMaterial = this.field_70170_p.func_72803_f(par1, par2 - 1, par3);
        if (underMaterial == Material.field_76257_i) {
            return 200.0f;
        }
        if (underMaterial == Material.field_76245_d) {
            return 15.0f;
        }
        if (underMaterial == Material.field_76247_b) {
            return 9.0f;
        }
        return this.field_70170_p.func_72801_o(par1, par2, par3) - 0.5f;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.isBirdLanded()) {
            this.field_70181_x *= 0.6000000238418579;
        }
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.isBirdLanded()) {
            this.currentFlightTime = 0;
            if (this.field_70146_Z.nextInt(200) == 0 && !this.isLandableBlock(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u - 1.0), MathHelper.func_76128_c(this.field_70161_v))) {
                this.setIsBirdLanded(false);
                this.field_70170_p.func_72889_a((EntityPlayer)null, 1015, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                this.field_70181_x = 0.4;
            }
            else if (this.isSpooked()) {
                this.setIsBirdLanded(false);
                this.field_70181_x = 0.4;
                this.field_70170_p.func_72889_a((EntityPlayer)null, 1015, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            }
        }
        else {
            ++this.currentFlightTime;
            if (this.currentFlightTarget != null && (!this.field_70170_p.func_72799_c(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c) || this.currentFlightTarget.field_71572_b < 1)) {
                this.currentFlightTarget = null;
            }
            if (this.currentFlightTarget == null || this.field_70146_Z.nextInt(30) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.0f) {
                final int yTarget = (this.currentFlightTime < 100) ? 2 : 4;
                this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - yTarget, (int)this.field_70161_v + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
            }
            final double d0 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
            final double d2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
            final double d3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
            this.field_70159_w += (Math.signum(d0) * 0.5 - this.field_70159_w) * 0.10000000149011612;
            this.field_70181_x += (Math.signum(d2) * 0.699999988079071 - this.field_70181_x) * 0.10000000149011612;
            this.field_70179_y += (Math.signum(d3) * 0.5 - this.field_70179_y) * 0.10000000149011612;
            final float f = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
            final float f2 = MathHelper.func_76142_g(f - this.field_70177_z);
            this.field_70701_bs = 0.5f;
            this.field_70177_z += f2;
            if (this.field_70146_Z.nextInt(10) == 0 && this.isLandableBlock(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u - 1.0), MathHelper.func_76128_c(this.field_70161_v))) {
                this.setIsBirdLanded(true);
                this.field_70181_x = 0.0;
            }
        }
    }
    
    public boolean isSpooked() {
        final EntityPlayer closestPlayer = this.field_70170_p.func_72890_a((Entity)this, 4.0);
        return this.field_70737_aN > 0 || (closestPlayer != null && (closestPlayer.field_71071_by.func_70448_g() == null || closestPlayer.field_71071_by.func_70448_g().field_77993_c != Item.field_77690_S.field_77779_bT));
    }
    
    public boolean isLandableBlock(final int x, final int y, final int z) {
        final Block block = Block.field_71973_m[this.field_70170_p.func_72798_a(x, y, z)];
        return block != null && (block.isLeaves(this.field_70170_p, x, y, z) || block.isBlockSolidOnSide(this.field_70170_p, x, y, z, ForgeDirection.UP));
    }
    
    @Override
    public boolean isBirdLanded() {
        return (this.field_70180_af.func_75683_a(17) & 0x1) != 0x0;
    }
    
    public void setIsBirdLanded(final boolean par1) {
        final byte b0 = this.field_70180_af.func_75683_a(17);
        if (par1) {
            this.field_70180_af.func_75692_b(17, (Object)(byte)(b0 | 0x1));
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)(byte)(b0 & 0xFFFFFFFE));
        }
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    protected void func_85033_bc() {
    }
}
