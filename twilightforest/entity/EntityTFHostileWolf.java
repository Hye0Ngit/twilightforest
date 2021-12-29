// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import twilightforest.TFSounds;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWolf;

public class EntityTFHostileWolf extends EntityWolf implements IMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFHostileWolf(final World world) {
        super(world);
        this.func_70916_h(true);
        this.func_175547_a(EnumDyeColor.BLACK);
        this.setAttributes();
    }
    
    protected void setAttributes() {
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
    }
    
    protected final void func_110147_ax() {
        super.func_110147_ax();
        this.setAttributes();
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70715_bh.func_75776_a(4, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
        }
    }
    
    public boolean func_70601_bi() {
        final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
        final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
        return (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.HEDGE_MAZE || this.isValidLightLevel()) && this.field_70170_p.func_72855_b(this.func_174813_aQ()) && this.field_70170_p.func_184144_a((Entity)this, this.func_174813_aQ()).size() == 0 && !this.field_70170_p.func_72953_d(this.func_174813_aQ());
    }
    
    protected boolean isValidLightLevel() {
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
    
    public void func_70624_b(@Nullable final EntityLivingBase entity) {
        if (entity != null && entity != this.func_70638_az()) {
            this.func_184185_a(TFSounds.MISTWOLF_TARGET, 4.0f, this.func_70647_i());
        }
        super.func_70624_b(entity);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.MISTWOLF_IDLE;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.MISTWOLF_HURT;
    }
    
    public boolean func_70877_b(final ItemStack stack) {
        return false;
    }
    
    public boolean func_184645_a(final EntityPlayer player, final EnumHand hand) {
        return false;
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFHostileWolf.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/hostile_wolf");
    }
}
