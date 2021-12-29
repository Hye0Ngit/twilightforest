// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFRedcapPlantTNT;
import net.minecraft.world.World;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public EntityTFRedcapSapper(final World world) {
        super(world);
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFRedcapPlantTNT(this));
        this.setTntLeft(3);
        this.func_70062_b(1, new ItemStack(TFItems.ironwoodBoots));
        this.func_70062_b(0, new ItemStack(TFItems.ironwoodPick, 1));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
    }
    
    public int func_70658_aO() {
        int var1 = super.func_70658_aO() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    @Override
    public ItemStack getPick() {
        return new ItemStack(TFItems.ironwoodPick);
    }
    
    @Override
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hill2) {
                ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHill2);
            }
        }
    }
}
