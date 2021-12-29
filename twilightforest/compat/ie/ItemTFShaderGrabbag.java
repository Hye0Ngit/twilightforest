// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import twilightforest.client.model.item.ShaderGrabbagStackRenderer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.util.EnumActionResult;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.EnumRarity;
import net.minecraft.nbt.NBTTagCompound;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.Item;

public class ItemTFShaderGrabbag extends Item implements ModelRegisterCallback
{
    private static final String TAG_SHADER = "shader_rarity";
    public static final ItemTFShaderGrabbag shader_bag;
    
    public ItemTFShaderGrabbag() {
        this.func_77627_a(true);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> items) {
        if (tab == TFItems.creativeTab) {
            for (int i = ShaderRegistry.sortedRarityMap.size() - 1; i >= 0; --i) {
                final ItemStack stack = new ItemStack((Item)this, 1, 0);
                final NBTTagCompound compound = new NBTTagCompound();
                compound.func_74778_a("shader_rarity", ShaderRegistry.sortedRarityMap.get(i).toString());
                stack.func_77982_d(compound);
                items.add((Object)stack);
            }
        }
    }
    
    public EnumRarity func_77613_e(final ItemStack stack) {
        NBTTagCompound compound = stack.func_77978_p();
        if (compound == null) {
            stack.func_77982_d(new NBTTagCompound());
            compound = stack.func_77978_p();
        }
        final String rarityString = compound.func_74779_i("shader_rarity");
        for (final EnumRarity rarity : EnumRarity.values()) {
            if (rarity.toString().equalsIgnoreCase(rarityString)) {
                return rarity;
            }
        }
        return EnumRarity.COMMON;
    }
    
    public String func_77653_i(final ItemStack stack) {
        final String name = this.func_77613_e(stack).field_77934_f;
        return I18n.func_74837_a(this.func_77667_c(stack), new Object[] { name });
    }
    
    public ActionResult<ItemStack> func_77659_a(final World worldIn, final EntityPlayer playerIn, final EnumHand handIn) {
        final ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            final EnumRarity rarity = stack.func_77953_t();
            if (rarity == TwilightForestMod.getRarity()) {
                final List<ShaderRegistry.ShaderRegistryEntry> list = IEShaderRegister.getAllNonbossShaders();
                return randomShader(list.get(playerIn.func_70681_au().nextInt(list.size())).name, stack, playerIn);
            }
            if (ShaderRegistry.totalWeight.containsKey(rarity)) {
                return randomShader(ShaderRegistry.getRandomShader(playerIn.func_70005_c_(), playerIn.func_70681_au(), rarity, true), stack, playerIn);
            }
        }
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.PASS, (Object)stack);
    }
    
    private static ActionResult<ItemStack> randomShader(@Nullable final String shader, final ItemStack stack, final EntityPlayer playerIn) {
        if (shader == null || shader.isEmpty()) {
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)stack);
        }
        final ItemStack shaderItem = new ItemStack((Item)ItemTFShader.shader);
        NBTTagCompound compound = shaderItem.func_77978_p();
        if (compound == null) {
            shaderItem.func_77982_d(new NBTTagCompound());
            compound = shaderItem.func_77978_p();
        }
        compound.func_74778_a("shader_type", shader);
        stack.func_190918_g(1);
        if (stack.func_190916_E() <= 0) {
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)shaderItem);
        }
        if (!playerIn.field_71071_by.func_70441_a(shaderItem)) {
            playerIn.func_146097_a(shaderItem, false, true);
        }
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.PASS, (Object)stack);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final ModelResourceLocation mrl = new ModelResourceLocation("twilightforest:grabbag_tesr", "inventory");
        ModelLoader.setCustomModelResourceLocation((Item)this, 0, mrl);
        ClientRegistry.bindTileEntitySpecialRenderer((Class)ShaderGrabbagStackRenderer.DummyTile.class, (TileEntitySpecialRenderer)new ShaderGrabbagStackRenderer(mrl));
        ForgeHooksClient.registerTESRItemStack((Item)this, 0, (Class)ShaderGrabbagStackRenderer.DummyTile.class);
    }
    
    static {
        shader_bag = new ItemTFShaderGrabbag();
    }
}
