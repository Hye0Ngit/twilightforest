// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.ItemLike;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import java.util.List;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import twilightforest.TwilightForestMod;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import java.util.Locale;
import twilightforest.item.TFItems;
import javax.annotation.Nonnull;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TFShaderGrabbagItem extends Item
{
    @Nonnull
    private final Rarity rarity;
    
    public TFShaderGrabbagItem(final Rarity r) {
        super(TFItems.defaultBuilder());
        this.setRegistryName("twilightforest", "shader_bag_" + r.name().toLowerCase(Locale.US).replace(':', '_'));
        this.rarity = r;
    }
    
    public Rarity m_41460_(final ItemStack stack) {
        return this.rarity;
    }
    
    public Component m_7626_(final ItemStack stack) {
        return (Component)new TranslatableComponent("item.twilightforest.shader_bag", new Object[] { new TranslatableComponent("desc.immersiveengineering.info.shader.rarity." + this.rarity.name().toLowerCase(Locale.US)) });
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (world.f_46443_) {
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.PASS, (Object)stack);
        }
        if (this.rarity == TwilightForestMod.getRarity()) {
            final List<ShaderRegistry.ShaderRegistryEntry> list = IEShaderRegister.getAllNonbossShaders();
            return randomShader(list.get(player.m_21187_().nextInt(list.size())).name, stack, player);
        }
        return randomShader(ShaderRegistry.getRandomShader(player.m_142081_(), player.m_21187_(), this.rarity, true), stack, player);
    }
    
    private static InteractionResultHolder<ItemStack> randomShader(@Nullable final ResourceLocation shader, final ItemStack stack, final Player playerIn) {
        if (shader == null || shader.m_135815_().isEmpty()) {
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.FAIL, (Object)stack);
        }
        final ItemStack shaderItem = new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(TwilightForestMod.prefix("shader")));
        ItemNBTHelper.putString(shaderItem, "shader_name", shader.toString());
        stack.m_41774_(1);
        if (stack.m_41613_() <= 0) {
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)shaderItem);
        }
        if (!playerIn.m_150109_().m_36054_(shaderItem)) {
            playerIn.m_7197_(shaderItem, false, true);
        }
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.PASS, (Object)stack);
    }
}
