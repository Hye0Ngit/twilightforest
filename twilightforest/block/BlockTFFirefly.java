// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.ForgeHooksClient;
import twilightforest.tileentity.critters.TileEntityTFFireflyTicking;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import twilightforest.client.ModelRegisterCallback;

public class BlockTFFirefly extends BlockTFCritter implements ModelRegisterCallback
{
    protected BlockTFFirefly() {
        this.func_149715_a(1.0f);
    }
    
    @Override
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        return TwilightForestMod.proxy.getNewFireflyTE();
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack(Items.field_151114_aO);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockDirectional.field_176387_N }).func_178441_a());
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
        ForgeHooksClient.registerTESRItemStack(Item.func_150898_a((Block)this), 0, (Class)TileEntityTFFireflyTicking.class);
    }
}
