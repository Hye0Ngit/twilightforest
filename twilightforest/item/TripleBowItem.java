// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArrowItem;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BowItem;

public class TripleBowItem extends BowItem
{
    public TripleBowItem(final Item.Properties props) {
        super(props);
    }
    
    public void func_77615_a(final ItemStack stack, final World worldIn, final LivingEntity entityLiving, final int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            final PlayerEntity entityplayer = (PlayerEntity)entityLiving;
            final boolean flag = entityplayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantments.field_185312_x, stack) > 0;
            ItemStack itemstack = entityplayer.func_213356_f(stack);
            int i = this.func_77626_a(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.func_190926_b() || flag);
            if (i < 0) {
                return;
            }
            if (!itemstack.func_190926_b() || flag) {
                if (itemstack.func_190926_b()) {
                    itemstack = new ItemStack((IItemProvider)Items.field_151032_g);
                }
                final float f = func_185059_b(i);
                if (f >= 0.1) {
                    final boolean flag2 = entityplayer.field_71075_bZ.field_75098_d || (itemstack.func_77973_b() instanceof ArrowItem && ((ArrowItem)itemstack.func_77973_b()).isInfinite(itemstack, stack, entityplayer));
                    if (!worldIn.field_72995_K) {
                        final ArrowItem arrowitem = (ArrowItem)((itemstack.func_77973_b() instanceof ArrowItem) ? itemstack.func_77973_b() : Items.field_151032_g);
                        final AbstractArrowEntity entityarrow = arrowitem.func_200887_a(worldIn, itemstack, (LivingEntity)entityplayer);
                        entityarrow.func_234612_a_((Entity)entityplayer, entityplayer.field_70125_A, entityplayer.field_70177_z, 0.0f, f * 3.0f, 1.0f);
                        final AbstractArrowEntity entityarrow2 = arrowitem.func_200887_a(worldIn, itemstack, (LivingEntity)entityplayer);
                        entityarrow2.func_234612_a_((Entity)entityLiving, entityLiving.field_70125_A, entityLiving.field_70177_z, 0.0f, f * 2.0f, 1.0f);
                        entityarrow2.func_213317_d(entityarrow2.func_213322_ci().func_72441_c(0.0, 0.15, 0.0));
                        entityarrow2.func_70107_b(entityarrow2.func_226277_ct_(), entityarrow2.func_226278_cu_() + 0.02500000037252903, entityarrow2.func_226281_cx_());
                        entityarrow2.field_70251_a = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        final AbstractArrowEntity entityarrow3 = arrowitem.func_200887_a(worldIn, itemstack, (LivingEntity)entityplayer);
                        entityarrow3.func_234612_a_((Entity)entityLiving, entityLiving.field_70125_A, entityLiving.field_70177_z, 0.0f, f * 2.0f, 1.0f);
                        entityarrow3.func_213317_d(entityarrow3.func_213322_ci().func_178786_a(0.0, 0.15, 0.0));
                        entityarrow3.func_70107_b(entityarrow3.func_226277_ct_(), entityarrow3.func_226278_cu_() + 0.02500000037252903, entityarrow3.func_226281_cx_());
                        entityarrow3.field_70251_a = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
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
                        stack.func_222118_a(1, (LivingEntity)entityplayer, user -> user.func_213334_d(entityplayer.func_184600_cs()));
                        if (flag2 || (entityplayer.field_71075_bZ.field_75098_d && (itemstack.func_77973_b() == Items.field_185166_h || itemstack.func_77973_b() == Items.field_185167_i))) {
                            entityarrow.field_70251_a = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }
                        worldIn.func_217376_c((Entity)entityarrow);
                        worldIn.func_217376_c((Entity)entityarrow2);
                        worldIn.func_217376_c((Entity)entityarrow3);
                    }
                    worldIn.func_184148_a((PlayerEntity)null, entityplayer.func_226277_ct_(), entityplayer.func_226278_cu_(), entityplayer.func_226281_cx_(), SoundEvents.field_187737_v, SoundCategory.PLAYERS, 1.0f, 1.0f / (TripleBowItem.field_77697_d.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
                    if (!flag2 && !entityplayer.field_71075_bZ.field_75098_d) {
                        itemstack.func_190918_g(1);
                        if (itemstack.func_190926_b()) {
                            entityplayer.field_71071_by.func_184437_d(itemstack);
                        }
                    }
                    entityplayer.func_71029_a(Stats.field_75929_E.func_199076_b((Object)this));
                }
            }
        }
    }
}
