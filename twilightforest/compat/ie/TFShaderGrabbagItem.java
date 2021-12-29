// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.IItemProvider;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import java.util.List;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import java.util.Locale;
import twilightforest.item.TFItems;
import javax.annotation.Nonnull;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

public class TFShaderGrabbagItem extends Item
{
    @Nonnull
    private final Rarity rarity;
    
    public TFShaderGrabbagItem(final Rarity r) {
        super(TFItems.defaultBuilder());
        this.setRegistryName("twilightforest", "shader_bag_" + r.name().toLowerCase(Locale.US).replace(':', '_'));
        this.rarity = r;
    }
    
    public Rarity func_77613_e(final ItemStack stack) {
        return this.rarity;
    }
    
    public ITextComponent func_200295_i(final ItemStack stack) {
        return (ITextComponent)new TranslationTextComponent("item.twilightforest.shader_bag", new Object[] { new TranslationTextComponent("desc.immersiveengineering.info.shader.rarity." + this.rarity.name().toLowerCase(Locale.US)) });
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (world.field_72995_K) {
            return (ActionResult<ItemStack>)new ActionResult(ActionResultType.PASS, (Object)stack);
        }
        if (this.rarity == TwilightForestMod.getRarity()) {
            final List<ShaderRegistry.ShaderRegistryEntry> list = IEShaderRegister.getAllNonbossShaders();
            return randomShader(list.get(player.func_70681_au().nextInt(list.size())).name, stack, player);
        }
        return randomShader(ShaderRegistry.getRandomShader(player.func_110124_au(), player.func_70681_au(), this.rarity, true), stack, player);
    }
    
    private static ActionResult<ItemStack> randomShader(@Nullable final ResourceLocation shader, final ItemStack stack, final PlayerEntity playerIn) {
        if (shader == null || shader.func_110623_a().isEmpty()) {
            return (ActionResult<ItemStack>)new ActionResult(ActionResultType.FAIL, (Object)stack);
        }
        final ItemStack shaderItem = new ItemStack((IItemProvider)ForgeRegistries.ITEMS.getValue(TwilightForestMod.prefix("shader")));
        ItemNBTHelper.putString(shaderItem, "shader_name", shader.toString());
        stack.func_190918_g(1);
        if (stack.func_190916_E() <= 0) {
            return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)shaderItem);
        }
        if (!playerIn.field_71071_by.func_70441_a(shaderItem)) {
            playerIn.func_146097_a(shaderItem, false, true);
        }
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.PASS, (Object)stack);
    }
}
