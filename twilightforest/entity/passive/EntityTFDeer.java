// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityAgeable;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityCow;

public class EntityTFDeer extends EntityCow
{
    public EntityTFDeer(final World world) {
        super(world);
        this.func_70105_a(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected void func_145780_a(final int par1, final int par2, final int par3, final Block par4) {
    }
    
    public boolean func_70085_c(final EntityPlayer entityplayer) {
        final ItemStack itemstack = entityplayer.field_71071_by.func_70448_g();
        return (itemstack == null || itemstack.func_77973_b() != Items.field_151133_ar) && super.func_70085_c(entityplayer);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151116_aA, 1);
        }
        for (int var3 = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            if (this.func_70027_ad()) {
                this.func_145779_a(TFItems.venisonCooked, 1);
            }
            else {
                this.func_145779_a(TFItems.venisonRaw, 1);
            }
        }
    }
    
    public EntityCow func_90011_a(final EntityAgeable entityanimal) {
        return new EntityTFDeer(this.field_70170_p);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
