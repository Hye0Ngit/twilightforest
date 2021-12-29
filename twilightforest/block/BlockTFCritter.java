// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.Block;

public abstract class BlockTFCritter extends Block
{
    private final float WIDTH;
    private final AxisAlignedBB DOWN_BB;
    private final AxisAlignedBB UP_BB;
    private final AxisAlignedBB NORTH_BB;
    private final AxisAlignedBB SOUTH_BB;
    private final AxisAlignedBB WEST_BB;
    private final AxisAlignedBB EAST_BB;
    
    protected BlockTFCritter() {
        super(Material.field_151594_q);
        this.WIDTH = this.getWidth();
        this.DOWN_BB = new AxisAlignedBB((double)(0.5f - this.WIDTH), (double)(1.0f - this.WIDTH * 2.0f), 0.20000000298023224, (double)(0.5f + this.WIDTH), 1.0, 0.800000011920929);
        this.UP_BB = new AxisAlignedBB((double)(0.5f - this.WIDTH), 0.0, 0.20000000298023224, (double)(0.5f + this.WIDTH), (double)(this.WIDTH * 2.0f), 0.800000011920929);
        this.NORTH_BB = new AxisAlignedBB((double)(0.5f - this.WIDTH), 0.20000000298023224, (double)(1.0f - this.WIDTH * 2.0f), (double)(0.5f + this.WIDTH), 0.800000011920929, 1.0);
        this.SOUTH_BB = new AxisAlignedBB((double)(0.5f - this.WIDTH), 0.20000000298023224, 0.0, (double)(0.5f + this.WIDTH), 0.800000011920929, (double)(this.WIDTH * 2.0f));
        this.WEST_BB = new AxisAlignedBB((double)(1.0f - this.WIDTH * 2.0f), 0.20000000298023224, (double)(0.5f - this.WIDTH), 1.0, 0.800000011920929, (double)(0.5f + this.WIDTH));
        this.EAST_BB = new AxisAlignedBB(0.0, 0.20000000298023224, (double)(0.5f - this.WIDTH), (double)(this.WIDTH * 2.0f), 0.800000011920929, (double)(0.5f + this.WIDTH));
        this.func_149711_c(0.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149672_a(SoundType.field_185859_l);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.UP));
    }
    
    public float getWidth() {
        return 0.15f;
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockDirectional.field_176387_N });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((EnumFacing)state.func_177229_b((IProperty)BlockDirectional.field_176387_N)).func_176745_a();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.func_82600_a(meta));
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        switch ((EnumFacing)state.func_177229_b((IProperty)BlockDirectional.field_176387_N)) {
            case DOWN: {
                return this.DOWN_BB;
            }
            default: {
                return this.UP_BB;
            }
            case NORTH: {
                return this.NORTH_BB;
            }
            case SOUTH: {
                return this.SOUTH_BB;
            }
            case WEST: {
                return this.WEST_BB;
            }
            case EAST: {
                return this.EAST_BB;
            }
        }
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFCritter.field_185506_k;
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
    
    public boolean func_176198_a(final World world, final BlockPos pos, final EnumFacing side) {
        return this.canPlaceAt((IBlockAccess)world, pos.func_177972_a(side.func_176734_d()), side);
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        for (final EnumFacing side : EnumFacing.values()) {
            if (this.canPlaceAt((IBlockAccess)world, pos.func_177972_a(side.func_176734_d()), side)) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    public IBlockState func_180642_a(final World world, final BlockPos pos, final EnumFacing sideHit, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        IBlockState state = this.func_176223_P();
        if (this.canPlaceAt((IBlockAccess)world, pos.func_177972_a(sideHit.func_176734_d()), sideHit)) {
            state = state.func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)sideHit);
        }
        return state;
    }
    
    public void func_176213_c(final World world, final BlockPos pos, final IBlockState state) {
        world.func_175684_a(pos, (Block)this, 1);
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random rand) {
        this.checkAndDrop(world, pos, state);
    }
    
    protected boolean checkAndDrop(final World world, final BlockPos pos, final IBlockState state) {
        final EnumFacing facing = (EnumFacing)state.func_177229_b((IProperty)BlockDirectional.field_176387_N);
        if (!this.canPlaceAt((IBlockAccess)world, pos.func_177972_a(facing.func_176734_d()), facing)) {
            world.func_175655_b(pos, true);
            return false;
        }
        return true;
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        this.checkAndDrop(world, pos, state);
    }
    
    protected boolean canPlaceAt(final IBlockAccess world, final BlockPos pos, final EnumFacing facing) {
        final IBlockState state = world.func_180495_p(pos);
        return state.func_193401_d(world, pos, facing) == BlockFaceShape.SOLID && (!func_193382_c(state.func_177230_c()) || state.func_185904_a() == Material.field_151584_j || state.func_185904_a() == Material.field_151570_A);
    }
    
    public boolean hasTileEntity(final IBlockState state) {
        return true;
    }
    
    public abstract TileEntity createTileEntity(final World p0, final IBlockState p1);
    
    public abstract ItemStack getSquishResult();
}
