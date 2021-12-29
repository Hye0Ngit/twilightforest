// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraft.util.NonNullList;
import javax.annotation.Nonnull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.util.text.TextFormatting;
import blusunrize.immersiveengineering.api.shader.ShaderCaseItem;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.util.text.translation.I18n;
import java.util.Locale;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraftforge.fml.common.Optional;
import twilightforest.client.ModelRegisterCallback;
import blusunrize.immersiveengineering.api.shader.IShaderItem;
import net.minecraft.item.Item;

@Optional.Interface(modid = "immersiveengineering", iface = "blusunrize.immersiveengineering.api.shader.IShaderItem")
public class ItemTFShader extends Item implements IShaderItem, ModelRegisterCallback
{
    static final String TAG_SHADER = "shader_type";
    public static final ItemTFShader shader;
    
    public ItemTFShader() {
        this.func_77627_a(true);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Optional.Method(modid = "immersiveengineering")
    public ShaderCase getShaderCase(final ItemStack shader, final ItemStack tool, final String shaderType) {
        return ShaderRegistry.getShader(getShaderType(shader), shaderType);
    }
    
    @Optional.Method(modid = "immersiveengineering")
    public String getShaderName(final ItemStack stack) {
        return getShaderType(stack);
    }
    
    public String func_77653_i(final ItemStack stack) {
        final String rawShaderName = this.getShaderName(stack);
        final String unlocalizedShaderName = "twilightforest.shader." + rawShaderName.replace(' ', '_').toLowerCase(Locale.ROOT);
        final String localizedShaderName = I18n.func_74838_a(unlocalizedShaderName);
        if (unlocalizedShaderName.equals(localizedShaderName)) {
            return I18n.func_74837_a(this.func_77667_c(stack), new Object[] { rawShaderName });
        }
        return I18n.func_74837_a(this.func_77667_c(stack), new Object[] { localizedShaderName });
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> list, final ITooltipFlag flag) {
        list.add(I18n.func_74837_a("Level: " + this.func_77613_e(stack).field_77937_e + this.func_77613_e(stack).field_77934_f, new Object[0]));
        if (!GuiScreen.func_146272_n()) {
            list.add(I18n.func_74837_a("desc.immersiveengineering.info.shader.applyTo", new Object[0]) + " " + I18n.func_74837_a("desc.immersiveengineering.info.holdShift", new Object[0]));
        }
        else {
            list.add(I18n.func_74837_a("desc.immersiveengineering.info.shader.applyTo", new Object[0]));
            for (final ShaderCase sCase : ShaderRegistry.shaderRegistry.get(this.getShaderName(stack)).getCases()) {
                if (!(sCase instanceof ShaderCaseItem)) {
                    list.add(TextFormatting.DARK_GRAY + " " + I18n.func_74837_a("desc.immersiveengineering.info.shader." + sCase.getShaderType(), new Object[0]));
                }
            }
        }
    }
    
    public EnumRarity func_77613_e(final ItemStack stack) {
        return ShaderRegistry.shaderRegistry.get(getShaderType(stack)).getRarity();
    }
    
    @Nonnull
    private static String getShaderType(final ItemStack stack) {
        final NBTTagCompound compound = stack.func_77978_p();
        if (compound != null) {
            final String string = stack.func_77978_p().func_74779_i("shader_type");
            if (!string.isEmpty() && ShaderRegistry.shaderRegistry.containsKey(string)) {
                return string;
            }
        }
        return "Twilight";
    }
    
    public static int getShaderColors(final ItemStack stack, final int layer) {
        final ShaderRegistry.ShaderRegistryEntry entry = ShaderRegistry.shaderRegistry.get(getShaderType(stack));
        if (entry != null) {
            final ShaderCase shaderCase = entry.getCase("immersiveengineering:item");
            if (shaderCase != null) {
                final ShaderCase.ShaderLayer[] layers = shaderCase.getLayers();
                return layers[layer % layers.length].getColour();
            }
        }
        return -1;
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> items) {
        if (tab == TFItems.creativeTab) {
            for (final ShaderRegistry.ShaderRegistryEntry entry : IEShaderRegister.getAllTwilightShaders()) {
                final NBTTagCompound compound = new NBTTagCompound();
                final ItemStack stack = new ItemStack((Item)this, 1, 0);
                compound.func_74778_a("shader_type", entry.getName());
                stack.func_77982_d(compound);
                items.add((Object)stack);
            }
        }
    }
    
    static {
        shader = new ItemTFShader();
    }
}
