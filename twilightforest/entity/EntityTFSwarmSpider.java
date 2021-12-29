// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySpider;

public class EntityTFSwarmSpider extends EntitySpider
{
    public static final ResourceLocation LOOT_TABLE;
    protected boolean shouldSpawn;
    
    public EntityTFSwarmSpider(final World world) {
        this(world, true);
    }
    
    public EntityTFSwarmSpider(final World world, final boolean spawnMore) {
        super(world);
        this.shouldSpawn = false;
        this.func_70105_a(0.8f, 0.4f);
        this.setSpawnMore(spawnMore);
        this.field_70728_aV = 2;
    }
    
    public EntityTFSwarmSpider(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.field_75782_a.removeIf(t -> t.field_75733_a instanceof EntityAIAttackMelee);
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee(this, 1.0, true) {
            protected double func_179512_a(final EntityLivingBase attackTarget) {
                return 4.0f + attackTarget.field_70130_N;
            }
        });
        this.field_70715_bh.field_75782_a.removeIf(t -> t.field_75731_b == 2 && t.field_75733_a instanceof EntityAINearestAttackableTarget);
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    public float func_70603_bj() {
        return 0.5f;
    }
    
    public float func_70047_e() {
        return 0.3f;
    }
    
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && this.shouldSpawnMore()) {
            for (int more = 1 + this.field_70146_Z.nextInt(2), i = 0; i < more; ++i) {
                if (!this.spawnAnother()) {
                    this.spawnAnother();
                }
            }
            this.setSpawnMore(false);
        }
        super.func_70071_h_();
    }
    
    public boolean func_70652_k(final Entity entity) {
        return this.field_70146_Z.nextInt(4) == 0 && super.func_70652_k(entity);
    }
    
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFSwarmSpider(this.field_70170_p, false);
        final double sx = this.field_70165_t + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.field_70163_u;
        final double sz = this.field_70161_v + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        another.func_70012_b(sx, sy, sz, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
        if (!another.func_70601_bi()) {
            another.func_70106_y();
            return false;
        }
        this.field_70170_p.func_72838_d((Entity)another);
        another.func_70656_aK();
        return true;
    }
    
    protected boolean func_70814_o() {
        final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
        final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.HEDGE_MAZE || super.func_70814_o();
    }
    
    public boolean shouldSpawnMore() {
        return this.shouldSpawn;
    }
    
    public void setSpawnMore(final boolean flag) {
        this.shouldSpawn = flag;
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74757_a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setSpawnMore(compound.func_74767_n("SpawnMore"));
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.5f;
    }
    
    public int func_70641_bl() {
        return 16;
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFSwarmSpider.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/swarm_spider");
    }
}
