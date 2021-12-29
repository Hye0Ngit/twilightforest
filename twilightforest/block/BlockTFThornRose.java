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
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFThornRose extends Block implements ModelRegisterCallback
{
    private static final float RADIUS = 0.4f;
    private static final AxisAlignedBB AABB;
    
    protected BlockTFThornRose() {
        super(Material.field_151585_k);
        this.func_149711_c(10.0f);
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFThornRose.AABB;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        return this.canBlockStay(world, pos);
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFThornRose.field_185506_k;
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        if (!this.canBlockStay(world, pos)) {
            world.func_175655_b(pos, true);
        }
    }
    
    private boolean canBlockStay(final World world, final BlockPos pos) {
        for (final EnumFacing dir : EnumFacing.field_82609_l) {
            final BlockPos pos_ = pos.func_177972_a(dir);
            final IBlockState state = world.func_180495_p(pos_);
            if (state.func_177230_c().canSustainLeaves(state, (IBlockAccess)world, pos_)) {
                return true;
            }
        }
        return false;
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
        AABB = new AxisAlignedBB(0.09999999403953552, 0.09999999403953552, 0.09999999403953552, 0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
}
