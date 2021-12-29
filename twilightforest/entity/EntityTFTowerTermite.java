// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerWoodVariant;
import twilightforest.block.BlockTFTowerWood;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.ai.EntityAIWander;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.DamageSource;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFTowerTermite extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    private AISummonSilverfish summonSilverfish;
    
    public EntityTFTowerTermite(final World world) {
        super(world);
        this.func_70105_a(0.3f, 0.7f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)(this.summonSilverfish = new AISummonSilverfish(this)));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new AIHideInStone(this));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.27);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(8.0);
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187793_eY;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187850_fa;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187795_eZ;
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (this.func_180431_b(source)) {
            return false;
        }
        if ((source instanceof EntityDamageSource || source == DamageSource.field_76376_m) && this.summonSilverfish != null) {
            this.summonSilverfish.notifyHurt();
        }
        return super.func_70097_a(source, amount);
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187852_fb, 0.15f, 1.0f);
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFTowerTermite.LOOT_TABLE;
    }
    
    public void func_70071_h_() {
        this.field_70761_aq = this.field_70177_z;
        super.func_70071_h_();
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/tower_termite");
    }
    
    private static class AIHideInStone extends EntityAIWander
    {
        private EnumFacing facing;
        private boolean doMerge;
        
        public AIHideInStone(final EntityTFTowerTermite silverfishIn) {
            super((EntityCreature)silverfishIn, 1.0, 10);
            this.func_75248_a(1);
        }
        
        public boolean func_75250_a() {
            if (this.field_75457_a.func_70638_az() != null) {
                return false;
            }
            if (!this.field_75457_a.func_70661_as().func_75500_f()) {
                return false;
            }
            final Random random = this.field_75457_a.func_70681_au();
            if (random.nextInt(10) == 0 && ForgeEventFactory.getMobGriefingEvent(this.field_75457_a.field_70170_p, (Entity)this.field_75457_a)) {
                this.facing = EnumFacing.func_176741_a(random);
                final BlockPos blockpos = new BlockPos(this.field_75457_a.field_70165_t, this.field_75457_a.field_70163_u + 0.5, this.field_75457_a.field_70161_v).func_177972_a(this.facing);
                final IBlockState iblockstate = this.field_75457_a.field_70170_p.func_180495_p(blockpos);
                if (iblockstate == TFBlocks.tower_wood.func_176223_P()) {
                    return this.doMerge = true;
                }
            }
            this.doMerge = false;
            return super.func_75250_a();
        }
        
        public boolean func_75253_b() {
            return !this.doMerge && super.func_75253_b();
        }
        
        public void func_75249_e() {
            if (!this.doMerge) {
                super.func_75249_e();
            }
            else {
                final World world = this.field_75457_a.field_70170_p;
                final BlockPos blockpos = new BlockPos(this.field_75457_a.field_70165_t, this.field_75457_a.field_70163_u + 0.5, this.field_75457_a.field_70161_v).func_177972_a(this.facing);
                final IBlockState iblockstate = world.func_180495_p(blockpos);
                if (iblockstate == TFBlocks.tower_wood.func_176223_P()) {
                    world.func_180501_a(blockpos, TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.INFESTED), 3);
                    this.field_75457_a.func_70656_aK();
                    this.field_75457_a.func_70106_y();
                }
            }
        }
    }
    
    private static class AISummonSilverfish extends EntityAIBase
    {
        private EntityTFTowerTermite silverfish;
        private int lookForFriends;
        
        public AISummonSilverfish(final EntityTFTowerTermite silverfishIn) {
            this.silverfish = silverfishIn;
        }
        
        public void notifyHurt() {
            if (this.lookForFriends == 0) {
                this.lookForFriends = 20;
            }
        }
        
        public boolean func_75250_a() {
            return this.lookForFriends > 0;
        }
        
        public void func_75246_d() {
            --this.lookForFriends;
            if (this.lookForFriends <= 0) {
                final World world = this.silverfish.field_70170_p;
                final Random random = this.silverfish.func_70681_au();
                final BlockPos blockpos = new BlockPos((Entity)this.silverfish);
                for (int i = 0; i <= 5 && i >= -5; i = ((i <= 0) ? (1 - i) : (0 - i))) {
                    for (int j = 0; j <= 10 && j >= -10; j = ((j <= 0) ? (1 - j) : (0 - j))) {
                        for (int k = 0; k <= 10 && k >= -10; k = ((k <= 0) ? (1 - k) : (0 - k))) {
                            final BlockPos blockpos2 = blockpos.func_177982_a(j, i, k);
                            final IBlockState iblockstate = world.func_180495_p(blockpos2);
                            if (iblockstate == TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.INFESTED)) {
                                if (ForgeEventFactory.getMobGriefingEvent(world, (Entity)this.silverfish)) {
                                    world.func_175655_b(blockpos2, true);
                                }
                                else {
                                    world.func_180501_a(blockpos2, TFBlocks.tower_wood.func_176223_P(), 3);
                                }
                                if (random.nextBoolean()) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
