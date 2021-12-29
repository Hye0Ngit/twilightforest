// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArrow;
import net.minecraft.init.Items;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFTripleBow extends ItemTFBowBase
{
    public ItemTFTripleBow() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_77615_a(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving, final int timeLeft) {
        if (entityLiving instanceof EntityPlayer) {
            final EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            final boolean flag = entityplayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantments.field_185312_x, stack) > 0;
            ItemStack itemstack = this.func_185060_a(entityplayer);
            int i = this.func_77626_a(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.func_190926_b() || flag);
            if (i < 0) {
                return;
            }
            if (!itemstack.func_190926_b() || flag) {
                if (itemstack.func_190926_b()) {
                    itemstack = new ItemStack(Items.field_151032_g);
                }
                final float f = func_185059_b(i);
                if (f >= 0.1) {
                    final boolean flag2 = entityplayer.field_71075_bZ.field_75098_d || (itemstack.func_77973_b() instanceof ItemArrow && ((ItemArrow)itemstack.func_77973_b()).isInfinite(itemstack, stack, entityplayer));
                    if (!worldIn.field_72995_K) {
                        final ItemArrow itemarrow = (ItemArrow)((itemstack.func_77973_b() instanceof ItemArrow) ? itemstack.func_77973_b() : Items.field_151032_g);
                        final EntityArrow entityarrow = itemarrow.func_185052_a(worldIn, itemstack, (EntityLivingBase)entityplayer);
                        entityarrow.func_184547_a((Entity)entityplayer, entityplayer.field_70125_A, entityplayer.field_70177_z, 0.0f, f * 3.0f, 1.0f);
                        final EntityArrow entityarrow2 = (EntityArrow)new EntityTippedArrow(worldIn, entityLiving);
                        entityarrow2.func_184547_a((Entity)entityLiving, entityLiving.field_70125_A, entityLiving.field_70177_z, 0.0f, f * 2.0f, 1.0f);
                        final EntityArrow entityArrow = entityarrow2;
                        entityArrow.field_70181_x += 0.14999999664723873;
                        final EntityArrow entityArrow2 = entityarrow2;
                        entityArrow2.field_70163_u += 0.02500000037252903;
                        entityarrow2.field_70251_a = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        final EntityArrow entityarrow3 = (EntityArrow)new EntityTippedArrow(worldIn, entityLiving);
                        entityarrow3.func_184547_a((Entity)entityLiving, entityLiving.field_70125_A, entityLiving.field_70177_z, 0.0f, f * 2.0f, 1.0f);
                        final EntityArrow entityArrow3 = entityarrow3;
                        entityArrow3.field_70181_x -= 0.14999999664723873;
                        final EntityArrow entityArrow4 = entityarrow3;
                        entityArrow4.field_70163_u -= 0.02500000037252903;
                        entityarrow3.field_70251_a = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        if (f == 1.0f) {
                            entityarrow.func_70243_d(true);
                            entityarrow2.func_70243_d(true);
                            entityarrow3.func_70243_d(true);
                        }
                        final int j = EnchantmentHelper.func_77506_a(Enchantments.field_185309_u, stack);
                        if (j > 0) {
                            entityarrow.func_70239_b(entityarrow.func_70242_d() + j * 0.5 + 0.5);
                            entityarrow2.func_70239_b(entityarrow.func_70242_d() + j * 0.5 + 0.5);
                            entityarrow3.func_70239_b(entityarrow.func_70242_d() + j * 0.5 + 0.5);
                        }
                        final int k = EnchantmentHelper.func_77506_a(Enchantments.field_185310_v, stack);
                        if (k > 0) {
                            entityarrow.func_70240_a(k);
                            entityarrow2.func_70240_a(k);
                            entityarrow3.func_70240_a(k);
                        }
                        if (EnchantmentHelper.func_77506_a(Enchantments.field_185311_w, stack) > 0) {
                            entityarrow.func_70015_d(100);
                            entityarrow2.func_70015_d(100);
                            entityarrow3.func_70015_d(100);
                        }
                        stack.func_77972_a(1, (EntityLivingBase)entityplayer);
                        if (flag2 || (entityplayer.field_71075_bZ.field_75098_d && (itemstack.func_77973_b() == Items.field_185166_h || itemstack.func_77973_b() == Items.field_185167_i))) {
                            entityarrow.field_70251_a = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        }
                        worldIn.func_72838_d((Entity)entityarrow);
                        worldIn.func_72838_d((Entity)entityarrow2);
                        worldIn.func_72838_d((Entity)entityarrow3);
                    }
                    worldIn.func_184148_a((EntityPlayer)null, entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, SoundEvents.field_187737_v, SoundCategory.PLAYERS, 1.0f, 1.0f / (ItemTFTripleBow.field_77697_d.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
                    if (!flag2 && !entityplayer.field_71075_bZ.field_75098_d) {
                        itemstack.func_190918_g(1);
                        if (itemstack.func_190926_b()) {
                            entityplayer.field_71071_by.func_184437_d(itemstack);
                        }
                    }
                    entityplayer.func_71029_a(StatList.func_188057_b((Item)this));
                }
            }
        }
    }
}
