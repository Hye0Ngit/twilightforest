// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import javax.annotation.Nonnull;
import net.minecraft.item.EnumRarity;
import net.minecraft.entity.Entity;
import twilightforest.util.ParticleHelper;
import net.minecraft.block.Block;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemSword;

public class ItemTFGlassSword extends ItemSword implements ModelRegisterCallback
{
    public ItemTFGlassSword(final Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_77644_a(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker) {
        attacker.field_70170_p.func_184148_a((EntityPlayer)null, attacker.field_70165_t, attacker.field_70163_u, attacker.field_70161_v, Blocks.field_150359_w.func_185467_w().func_185845_c(), attacker.func_184176_by(), 1.0f, 0.5f);
        ParticleHelper.spawnParticles((Entity)target, EnumParticleTypes.BLOCK_CRACK, 20, 0.0, Block.func_176210_f(Blocks.field_150399_cn.func_176223_P()));
        stack.func_77972_a(stack.func_77958_k() + 1, attacker);
        return true;
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return EnumRarity.RARE;
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> items) {
        super.func_150895_a(tab, (NonNullList)items);
        if (this.func_194125_a(tab)) {
            final ItemStack stack = new ItemStack((Item)this);
            final NBTTagCompound tags = new NBTTagCompound();
            tags.func_74757_a("Unbreakable", true);
            stack.func_77982_d(tags);
            items.add((Object)stack);
        }
    }
}
