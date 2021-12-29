// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.text.TextFormatting;
import twilightforest.compat.TFCompat;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.ForgeHooksClient;
import twilightforest.tileentity.critters.TileEntityTFCicadaTicking;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import twilightforest.client.ModelRegisterCallback;

public class BlockTFCicada extends BlockTFCritter implements ModelRegisterCallback
{
    @Override
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        return TwilightForestMod.proxy.getNewCicadaTE();
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack(Items.field_151100_aR, 1, EnumDyeColor.GRAY.func_176767_b());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockDirectional.field_176387_N }).func_178441_a());
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
        ForgeHooksClient.registerTESRItemStack(Item.func_150898_a((Block)this), 0, (Class)TileEntityTFCicadaTicking.class);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_190948_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flag) {
        super.func_190948_a(stack, world, (List)tooltip, flag);
        if (TFCompat.IMMERSIVEENGINEERING.isActivated()) {
            tooltip.add(TextFormatting.ITALIC.toString() + TwilightForestMod.getRarity().field_77937_e.toString() + I18n.func_74837_a("tile.twilightforest.Cicada.desc", new Object[0]));
        }
    }
}
