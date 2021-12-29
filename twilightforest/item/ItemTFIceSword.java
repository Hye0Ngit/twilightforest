// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.Entity;
import twilightforest.util.ParticleHelper;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.potion.PotionEffect;
import twilightforest.potions.TFPotions;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemSword;

public class ItemTFIceSword extends ItemSword implements ModelRegisterCallback
{
    public ItemTFIceSword(final Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_77644_a(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker) {
        final boolean result = super.func_77644_a(stack, target, attacker);
        if (result && !target.field_70170_p.field_72995_K) {
            target.func_70690_d(new PotionEffect(TFPotions.frosty, 200, 2));
            ParticleHelper.spawnParticles((Entity)target, TFParticleType.SNOW, 20);
        }
        return result;
    }
}
