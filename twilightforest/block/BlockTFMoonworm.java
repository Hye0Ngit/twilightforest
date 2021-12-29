// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.ForgeHooksClient;
import twilightforest.tileentity.critters.TileEntityTFMoonwormTicking;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirectional;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import twilightforest.client.ModelRegisterCallback;

public class BlockTFMoonworm extends BlockTFCritter implements ModelRegisterCallback
{
    protected BlockTFMoonworm() {
        this.func_149715_a(0.9375f);
    }
    
    @Override
    public float getWidth() {
        return 0.25f;
    }
    
    @Override
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        return TwilightForestMod.proxy.getNewMoonwormTE();
    }
    
    @Override
    protected boolean checkAndDrop(final World world, final BlockPos pos, final IBlockState state) {
        final EnumFacing facing = (EnumFacing)state.func_177229_b((IProperty)BlockDirectional.field_176387_N);
        if (!this.canPlaceAt((IBlockAccess)world, pos.func_177972_a(facing.func_176734_d()), facing)) {
            world.func_175655_b(pos, false);
            return false;
        }
        return true;
    }
    
    public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
        return 0;
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack(Items.field_151100_aR, 1, EnumDyeColor.LIME.func_176767_b());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockDirectional.field_176387_N }).func_178441_a());
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
        ForgeHooksClient.registerTESRItemStack(Item.func_150898_a((Block)this), 0, (Class)TileEntityTFMoonwormTicking.class);
    }
}
