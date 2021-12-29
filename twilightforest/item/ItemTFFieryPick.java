// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import javax.annotation.Nonnull;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import java.util.List;
import twilightforest.util.ParticleHelper;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.math.MathHelper;
import java.util.Collection;
import twilightforest.util.TFItemStackUtils;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fml.common.Mod;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemPickaxe;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class ItemTFFieryPick extends ItemPickaxe implements ModelRegisterCallback
{
    private static final EnumRarity RARITY;
    
    protected ItemTFFieryPick(final Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SubscribeEvent
    public static void onDrops(final BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() != null && event.getHarvester().func_184614_ca().func_77973_b() == TFItems.fiery_pickaxe && event.getState().func_177230_c().canHarvestBlock((IBlockAccess)event.getWorld(), event.getPos(), event.getHarvester())) {
            final List<ItemStack> removeThese = new ArrayList<ItemStack>();
            final List<ItemStack> addThese = new ArrayList<ItemStack>();
            for (final ItemStack input : event.getDrops()) {
                final ItemStack result = FurnaceRecipes.func_77602_a().func_151395_a(input);
                if (!result.func_190926_b()) {
                    final int combinedCount = input.func_190916_E() * result.func_190916_E();
                    addThese.addAll((Collection<? extends ItemStack>)TFItemStackUtils.splitToSize(new ItemStack(result.func_77973_b(), combinedCount, result.func_77952_i())));
                    removeThese.add(input);
                    int i = combinedCount;
                    final float f = FurnaceRecipes.func_77602_a().func_151398_b(result);
                    if (f == 0.0f) {
                        i = 0;
                    }
                    else if (f < 1.0f) {
                        int j = MathHelper.func_76141_d(i * f);
                        if (j < MathHelper.func_76123_f(i * f) && Math.random() < i * f - j) {
                            ++j;
                        }
                        i = j;
                    }
                    while (i > 0) {
                        final int k = EntityXPOrb.func_70527_a(i);
                        i -= k;
                        event.getHarvester().field_70170_p.func_72838_d((Entity)new EntityXPOrb(event.getWorld(), event.getHarvester().field_70165_t, event.getHarvester().field_70163_u + 0.5, event.getHarvester().field_70161_v, k));
                    }
                    ParticleHelper.spawnParticles(event.getWorld(), event.getPos(), EnumParticleTypes.FLAME, 5, 0.02, new int[0]);
                }
            }
            event.getDrops().removeAll(removeThese);
            event.getDrops().addAll(addThese);
        }
    }
    
    public boolean func_77644_a(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker) {
        final boolean result = super.func_77644_a(stack, target, attacker);
        if (result && !target.field_70170_p.field_72995_K && !target.func_70045_F()) {
            ParticleHelper.spawnParticles((Entity)target, EnumParticleTypes.FLAME, 20, 0.02, new int[0]);
            target.func_70015_d(15);
        }
        return result;
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return stack.func_77948_v() ? ((EnumRarity.RARE.compareTo((Enum)ItemTFFieryPick.RARITY) > 0) ? EnumRarity.RARE : ItemTFFieryPick.RARITY) : ItemTFFieryPick.RARITY;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
    
    static {
        RARITY = EnumRarity.UNCOMMON;
    }
}
