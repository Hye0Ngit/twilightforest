// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.NonNullList;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.client.ModelRegisterCallback;
import net.minecraftforge.common.IShearable;
import net.minecraft.block.Block;

public class BlockTFTrollRoot extends Block implements IShearable, ModelRegisterCallback
{
    protected static final AxisAlignedBB AABB;
    
    protected BlockTFTrollRoot() {
        super(Material.field_151585_k);
        this.func_149675_a(true);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149672_a(SoundType.field_185850_c);
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final BlockPos pos) {
        return true;
    }
    
    public List<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final BlockPos pos, final int fortune) {
        final NonNullList<ItemStack> ret = (NonNullList<ItemStack>)NonNullList.func_191196_a();
        ret.add((Object)new ItemStack((Block)this));
        return (List<ItemStack>)ret;
    }
    
    private boolean canBlockStay(final World world, final BlockPos pos) {
        return canPlaceRootBelow(world, pos.func_177984_a());
    }
    
    public static boolean canPlaceRootBelow(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        final Block blockAbove = state.func_177230_c();
        return state.func_185904_a() == Material.field_151576_e || blockAbove == TFBlocks.trollvidr || blockAbove == TFBlocks.trollber || blockAbove == TFBlocks.unripe_trollber;
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        return super.func_176196_c(world, pos) && this.canBlockStay(world, pos);
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BlockTFTrollRoot.AABB;
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFTrollRoot.field_185506_k;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess world, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random rand) {
        this.checkAndDropBlock(world, pos);
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        this.checkAndDropBlock(world, pos);
    }
    
    private void checkAndDropBlock(final World world, final BlockPos pos) {
        if (!this.canBlockStay(world, pos)) {
            world.func_175655_b(pos, true);
        }
    }
    
    public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
    
    static {
        AABB = new AxisAlignedBB(0.1, 0.0, 0.1, 0.9, 1.0, 0.9);
    }
}
