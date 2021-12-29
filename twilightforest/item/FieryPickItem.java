// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraftforge.items.ItemHandlerHelper;
import java.util.function.Function;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.crafting.IRecipeType;
import java.util.ArrayList;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class FieryPickItem extends PickaxeItem
{
    protected FieryPickItem(final IItemTier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 1, -2.8f, props);
    }
    
    public boolean func_77644_a(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        final boolean result = super.func_77644_a(stack, target, attacker);
        if (result && !target.func_230279_az_()) {
            if (!target.field_70170_p.field_72995_K) {
                target.func_70015_d(15);
            }
            else {
                target.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, target.func_226277_ct_(), target.func_226278_cu_() + target.func_213302_cg() * 0.5, target.func_226281_cx_(), target.func_213311_cf() * 0.5, target.func_213302_cg() * 0.5, target.func_213311_cf() * 0.5);
            }
        }
        return result;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
    
    private static class SmeltModifier extends LootModifier
    {
        protected final ILootCondition[] conditions;
        
        public SmeltModifier(final ILootCondition[] conditionsIn) {
            super(conditionsIn);
            this.conditions = conditionsIn;
        }
        
        public List<ItemStack> doApply(final List<ItemStack> originalLoot, final LootContext context) {
            final List<ItemStack> newLoot = new ArrayList<ItemStack>();
            originalLoot.forEach(stack -> {
                context.func_202879_g().func_199532_z();
                final IRecipeType field_222150_b = IRecipeType.field_222150_b;
                new Inventory(new ItemStack[] { stack });
                final Inventory inventory;
                final RecipeManager recipeManager;
                newLoot.add(recipeManager.func_215371_a(field_222150_b, (IInventory)inventory, (World)context.func_202879_g()).map(AbstractCookingRecipe::func_77571_b).filter(itemStack -> !itemStack.func_190926_b()).map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.func_190916_E() * itemStack.func_190916_E())).orElse(stack));
                return;
            });
            return newLoot;
        }
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<SmeltModifier>
    {
        public SmeltModifier read(final ResourceLocation name, final JsonObject json, final ILootCondition[] conditionsIn) {
            return new SmeltModifier(conditionsIn);
        }
        
        public JsonObject write(final SmeltModifier instance) {
            return null;
        }
    }
}
