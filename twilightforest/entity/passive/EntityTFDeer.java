// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityAgeable;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
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
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
    }
    
    public boolean func_70085_c(final EntityPlayer entityplayer) {
        final ItemStack itemstack = entityplayer.field_71071_by.func_70448_g();
        return (itemstack == null || itemstack.field_77993_c != Item.field_77788_aw.field_77779_bT) && super.func_70085_c(entityplayer);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.func_70025_b(Item.field_77770_aF.field_77779_bT, 1);
        }
        for (int var3 = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            if (this.func_70027_ad()) {
                this.func_70025_b(TFItems.venisonCooked.field_77779_bT, 1);
            }
            else {
                this.func_70025_b(TFItems.venisonRaw.field_77779_bT, 1);
            }
        }
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return (EntityAnimal)new EntityTFDeer(this.field_70170_p);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
