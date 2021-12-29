// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemHoe;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySkeleton;

public class EntityTFSkeletonDruid extends EntitySkeleton
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFSkeletonDruid(final World world) {
        super(world);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackRanged(this, 1.25, 20, 10.0f) {
            public void func_75249_e() {
                super.func_75249_e();
                EntityTFSkeletonDruid.this.func_184724_a(true);
            }
            
            public void func_75251_c() {
                super.func_75251_c();
                EntityTFSkeletonDruid.this.func_184724_a(false);
            }
        });
    }
    
    public void func_85036_m() {
        if (!(this.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() instanceof ItemHoe)) {
            super.func_85036_m();
        }
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151013_M));
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFSkeletonDruid.LOOT_TABLE;
    }
    
    public void func_82196_d(final EntityLivingBase attackTarget, final float extraDamage) {
        if (this.func_184586_b(EnumHand.MAIN_HAND).func_77973_b() instanceof ItemHoe) {
            final EntityTFNatureBolt natureBolt = new EntityTFNatureBolt(this.field_70170_p, (EntityLivingBase)this);
            this.func_184185_a(SoundEvents.field_187557_bK, 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
            final double tx = attackTarget.field_70165_t - this.field_70165_t;
            final double ty = attackTarget.field_70163_u + attackTarget.func_70047_e() - 2.699999988079071 - this.field_70163_u;
            final double tz = attackTarget.field_70161_v - this.field_70161_v;
            final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
            natureBolt.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.field_70170_p.func_72838_d((Entity)natureBolt);
        }
        else {
            super.func_82196_d(attackTarget, extraDamage);
        }
    }
    
    protected boolean func_70814_o() {
        final BlockPos blockpos = new BlockPos(this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v);
        if (this.field_70170_p.func_175642_b(EnumSkyBlock.SKY, blockpos) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        final int i = this.field_70170_p.func_175671_l(blockpos);
        return i <= this.field_70146_Z.nextInt(12);
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/skeleton_druid");
    }
}
