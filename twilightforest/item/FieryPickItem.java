// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.items.ItemHandlerHelper;
import java.util.function.Function;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.RecipeType;
import java.util.ArrayList;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;

public class FieryPickItem extends PickaxeItem
{
    protected FieryPickItem(final Tier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 1, -2.8f, props);
    }
    
    public boolean m_7579_(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        final boolean result = super.m_7579_(stack, target, attacker);
        if (result && !target.m_5825_()) {
            if (!target.f_19853_.f_46443_) {
                target.m_20254_(15);
            }
            else {
                target.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123744_, target.m_20185_(), target.m_20186_() + target.m_20206_() * 0.5, target.m_20189_(), target.m_20205_() * 0.5, target.m_20206_() * 0.5, target.m_20205_() * 0.5);
            }
        }
        return result;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)new TranslatableComponent(this.m_5524_() + ".tooltip").m_130940_(ChatFormatting.GRAY));
    }
    
    private static class SmeltModifier extends LootModifier
    {
        protected final LootItemCondition[] conditions;
        
        public SmeltModifier(final LootItemCondition[] conditionsIn) {
            super(conditionsIn);
            this.conditions = conditionsIn;
        }
        
        public List<ItemStack> doApply(final List<ItemStack> originalLoot, final LootContext context) {
            final List<ItemStack> newLoot = new ArrayList<ItemStack>();
            originalLoot.forEach(stack -> {
                context.m_78952_().m_7465_();
                final RecipeType f_44108_ = RecipeType.f_44108_;
                new SimpleContainer(new ItemStack[] { stack });
                final SimpleContainer simpleContainer;
                final RecipeManager recipeManager;
                newLoot.add(recipeManager.m_44015_(f_44108_, (Container)simpleContainer, (Level)context.m_78952_()).map(AbstractCookingRecipe::m_8043_).filter(itemStack -> !itemStack.m_41619_()).map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.m_41613_() * itemStack.m_41613_())).orElse(stack));
                return;
            });
            return newLoot;
        }
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<SmeltModifier>
    {
        public SmeltModifier read(final ResourceLocation name, final JsonObject json, final LootItemCondition[] conditionsIn) {
            return new SmeltModifier(conditionsIn);
        }
        
        public JsonObject write(final SmeltModifier instance) {
            return null;
        }
    }
}
