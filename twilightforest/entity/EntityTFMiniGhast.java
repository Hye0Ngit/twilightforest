// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFMiniGhast extends EntityTFTowerGhast
{
    public static final ResourceLocation LOOT_TABLE;
    private boolean isMinion;
    
    public EntityTFMiniGhast(final World world) {
        super(world);
        this.isMinion = false;
        this.func_70105_a(1.1f, 1.5f);
        this.wanderFactor = 4.0f;
    }
    
    @Override
    public int func_70641_bl() {
        return 16;
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(this.isMinion ? 6.0 : 10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(16.0);
    }
    
    public float func_70047_e() {
        return 1.2f;
    }
    
    @Override
    protected boolean shouldAttack(final EntityLivingBase living) {
        final ItemStack helmet = living.func_184582_a(EntityEquipmentSlot.HEAD);
        if (!helmet.func_190926_b() && helmet.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) {
            return false;
        }
        if (living.func_70032_d((Entity)this) <= 3.5f) {
            return living.func_70685_l((Entity)this);
        }
        final Vec3d vec3d = living.func_70676_i(1.0f).func_72432_b();
        Vec3d vec3d2 = new Vec3d(this.field_70165_t - living.field_70165_t, this.func_174813_aQ().field_72338_b + this.func_70047_e() - (living.field_70163_u + living.func_70047_e()), this.field_70161_v - living.field_70161_v);
        final double d0 = vec3d2.func_72433_c();
        vec3d2 = vec3d2.func_72432_b();
        final double d2 = vec3d.func_72430_b(vec3d2);
        return d2 > 1.0 - 0.025 / d0 && living.func_70685_l((Entity)this);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        if (this.isMinion) {
            return true;
        }
        final BlockPos blockpos = new BlockPos(this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v);
        if (this.field_70170_p.func_175642_b(EnumSkyBlock.SKY, blockpos) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int i = this.field_70170_p.func_175671_l(blockpos);
        if (this.field_70170_p.func_72911_I()) {
            final int j = this.field_70170_p.func_175657_ab();
            this.field_70170_p.func_175692_b(10);
            i = this.field_70170_p.func_175671_l(blockpos);
            this.field_70170_p.func_175692_b(j);
        }
        return i <= this.field_70146_Z.nextInt(8);
    }
    
    public void makeBossMinion() {
        this.wanderFactor = 0.005f;
        this.isMinion = true;
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6.0);
        this.func_70606_j(6.0f);
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFMiniGhast.LOOT_TABLE;
    }
    
    public boolean isMinion() {
        return this.isMinion;
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        compound.func_74757_a("isMinion", this.isMinion);
        super.func_70014_b(compound);
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        if (compound.func_74767_n("isMinion")) {
            this.makeBossMinion();
        }
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/mini_ghast");
    }
}
