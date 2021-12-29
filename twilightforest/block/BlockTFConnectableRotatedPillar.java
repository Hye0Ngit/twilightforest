// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.TwilightForestMod;
import net.minecraft.block.properties.PropertyBool;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.BlockFence;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockRotatedPillar;

public abstract class BlockTFConnectableRotatedPillar extends BlockRotatedPillar
{
    final double boundingBoxWidthLower;
    final double boundingBoxWidthUpper;
    private final double boundingBoxHeightLower;
    private final double boundingBoxHeightUpper;
    
    BlockTFConnectableRotatedPillar(final Material material, final double size) {
        this(material, material.func_151565_r(), size, size);
    }
    
    BlockTFConnectableRotatedPillar(final Material material, final double width, final double height) {
        this(material, material.func_151565_r(), width, height);
    }
    
    BlockTFConnectableRotatedPillar(final Material material, final MapColor mapColor, final double size) {
        this(material, mapColor, size, size);
    }
    
    BlockTFConnectableRotatedPillar(final Material material, final MapColor mapColor, final double width, final double height) {
        super(material, mapColor);
        if (width >= 16.0) {
            this.boundingBoxWidthLower = 0.0;
            this.boundingBoxWidthUpper = 16.0;
        }
        else {
            this.boundingBoxWidthLower = 8.0 - width / 2.0;
            this.boundingBoxWidthUpper = 16.0 - this.boundingBoxWidthLower;
        }
        if (height >= 16.0) {
            this.boundingBoxHeightLower = 0.0;
            this.boundingBoxHeightUpper = 16.0;
        }
        else {
            this.boundingBoxHeightLower = 8.0 - height / 2.0;
            this.boundingBoxHeightUpper = 16.0 - this.boundingBoxHeightLower;
        }
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFConnectableRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Y).func_177226_a((IProperty)BlockFence.field_176526_a, (Comparable)false).func_177226_a((IProperty)BlockFence.field_176528_N, (Comparable)false).func_177226_a((IProperty)BlockFence.field_176527_M, (Comparable)false).func_177226_a((IProperty)BlockFence.field_176525_b, (Comparable)false));
    }
    
    protected abstract IProperty[] getAdditionalProperties();
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer.Builder((Block)this).add(new IProperty[] { (IProperty)BlockTFConnectableRotatedPillar.field_176298_M, (IProperty)BlockFence.field_176526_a, (IProperty)BlockFence.field_176525_b, (IProperty)BlockFence.field_176527_M, (IProperty)BlockFence.field_176528_N }).add(this.getAdditionalProperties()).build();
    }
    
    public IBlockState func_176221_a(IBlockState state, final IBlockAccess world, final BlockPos pos) {
        final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFConnectableRotatedPillar.field_176298_M);
        for (final PairHelper pair : PairHelper.values()) {
            final EnumFacing connectTo = PairHelper.getFacingFromPropertyWithAxis(pair.property, axis);
            state = state.func_177226_a((IProperty)pair.property, (Comparable)this.canConnectTo(state, world.func_180495_p(pos.func_177972_a(connectTo)), world, pos, connectTo));
        }
        return state;
    }
    
    protected boolean canConnectTo(final IBlockState state, final IBlockState otherState, final IBlockAccess world, final BlockPos pos, final EnumFacing connectTo) {
        return state.func_177230_c() == otherState.func_177230_c() && state.func_177229_b((IProperty)BlockTFConnectableRotatedPillar.field_176298_M) != connectTo.func_176740_k();
    }
    
    public void func_185477_a(IBlockState state, final World world, final BlockPos pos, final AxisAlignedBB aabb, final List<AxisAlignedBB> list, @Nullable final Entity entity, final boolean useActualState) {
        if (!useActualState) {
            state = this.func_176221_a(state, (IBlockAccess)world, pos);
        }
        final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFConnectableRotatedPillar.field_176298_M);
        func_185492_a(pos, aabb, (List)list, this.makeQuickAABB((axis == EnumFacing.Axis.X) ? 16.0 : this.boundingBoxWidthLower, (axis == EnumFacing.Axis.Y) ? 16.0 : this.boundingBoxWidthLower, (axis == EnumFacing.Axis.Z) ? 16.0 : this.boundingBoxWidthLower, (axis == EnumFacing.Axis.X) ? 0.0 : this.boundingBoxWidthUpper, (axis == EnumFacing.Axis.Y) ? 0.0 : this.boundingBoxWidthUpper, (axis == EnumFacing.Axis.Z) ? 0.0 : this.boundingBoxWidthUpper));
        for (final EnumFacing facing : EnumFacing.field_82609_l) {
            if (facing.func_176740_k() != axis && (boolean)state.func_177229_b((IProperty)PairHelper.getPropertyFromFacingWithAxis(facing, axis))) {
                func_185492_a(pos, aabb, (List)list, this.getSidedAABBStraight(facing, axis));
            }
        }
    }
    
    protected AxisAlignedBB getSidedAABBStraight(final EnumFacing facing, final EnumFacing.Axis axis) {
        return this.makeQuickAABB((facing == EnumFacing.EAST) ? 16.0 : ((axis == EnumFacing.Axis.X) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == EnumFacing.UP) ? 16.0 : ((axis == EnumFacing.Axis.Y) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == EnumFacing.SOUTH) ? 16.0 : ((axis == EnumFacing.Axis.Z) ? this.boundingBoxHeightLower : this.boundingBoxWidthLower), (facing == EnumFacing.WEST) ? 0.0 : ((axis == EnumFacing.Axis.X) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper), (facing == EnumFacing.DOWN) ? 0.0 : ((axis == EnumFacing.Axis.Y) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper), (facing == EnumFacing.NORTH) ? 0.0 : ((axis == EnumFacing.Axis.Z) ? this.boundingBoxHeightUpper : this.boundingBoxWidthUpper));
    }
    
    public AxisAlignedBB func_185496_a(IBlockState state, final IBlockAccess world, final BlockPos pos) {
        state = this.func_176221_a(state, world, pos);
        switch ((EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFConnectableRotatedPillar.field_176298_M)) {
            case X: {
                return this.makeQuickAABB(0.0, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176526_a)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176528_N)) ? 0.0 : this.boundingBoxWidthLower, 16.0, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176527_M)) ? 16.0 : this.boundingBoxWidthUpper, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176525_b)) ? 16.0 : this.boundingBoxWidthUpper);
            }
            case Z: {
                return this.makeQuickAABB(((boolean)state.func_177229_b((IProperty)BlockFence.field_176525_b)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176527_M)) ? 0.0 : this.boundingBoxWidthLower, 0.0, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176528_N)) ? 16.0 : this.boundingBoxWidthUpper, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176526_a)) ? 16.0 : this.boundingBoxWidthUpper, 16.0);
            }
            default: {
                return this.makeQuickAABB(((boolean)state.func_177229_b((IProperty)BlockFence.field_176528_N)) ? 0.0 : this.boundingBoxWidthLower, 0.0, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176526_a)) ? 0.0 : this.boundingBoxWidthLower, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176525_b)) ? 16.0 : this.boundingBoxWidthUpper, 16.0, ((boolean)state.func_177229_b((IProperty)BlockFence.field_176527_M)) ? 16.0 : this.boundingBoxWidthUpper);
            }
        }
    }
    
    protected AxisAlignedBB makeQuickAABB(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return new AxisAlignedBB(x1 / 16.0, y1 / 16.0, z1 / 16.0, x2 / 16.0, y2 / 16.0, z2 / 16.0);
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    enum PairHelper
    {
        NORTH(EnumFacing.NORTH, BlockFence.field_176526_a), 
        EAST(EnumFacing.EAST, BlockFence.field_176525_b), 
        SOUTH(EnumFacing.SOUTH, BlockFence.field_176527_M), 
        WEST(EnumFacing.WEST, BlockFence.field_176528_N);
        
        final EnumFacing facing;
        final PropertyBool property;
        
        private PairHelper(final EnumFacing facing, final PropertyBool property) {
            this.facing = facing;
            this.property = property;
        }
        
        static EnumFacing getFacingFromPropertyWithAxis(final PropertyBool property, final EnumFacing.Axis axis) {
            switch (axis) {
                case X: {
                    if (property == BlockFence.field_176526_a) {
                        return EnumFacing.DOWN;
                    }
                    if (property == BlockFence.field_176527_M) {
                        return EnumFacing.UP;
                    }
                    if (property == BlockFence.field_176528_N) {
                        return EnumFacing.NORTH;
                    }
                    if (property == BlockFence.field_176525_b) {
                        return EnumFacing.SOUTH;
                    }
                    break;
                }
                case Y: {
                    if (property == BlockFence.field_176526_a) {
                        return EnumFacing.NORTH;
                    }
                    if (property == BlockFence.field_176527_M) {
                        return EnumFacing.SOUTH;
                    }
                    if (property == BlockFence.field_176528_N) {
                        return EnumFacing.WEST;
                    }
                    if (property == BlockFence.field_176525_b) {
                        return EnumFacing.EAST;
                    }
                    break;
                }
                case Z: {
                    if (property == BlockFence.field_176526_a) {
                        return EnumFacing.UP;
                    }
                    if (property == BlockFence.field_176527_M) {
                        return EnumFacing.DOWN;
                    }
                    if (property == BlockFence.field_176528_N) {
                        return EnumFacing.EAST;
                    }
                    if (property == BlockFence.field_176525_b) {
                        return EnumFacing.WEST;
                    }
                    break;
                }
            }
            TwilightForestMod.LOGGER.warn("ConnectableRotatedPillar helper (getFacingFromPropertyWithAxis) had a problem? (property '{}' with axis '{}')", (Object)property.func_177701_a(), (Object)axis.func_176610_l());
            return EnumFacing.UP;
        }
        
        static PropertyBool getPropertyFromFacingWithAxis(final EnumFacing facing, final EnumFacing.Axis axis) {
            Label_0212: {
                switch (axis) {
                    case X: {
                        switch (facing) {
                            case DOWN: {
                                return BlockFence.field_176526_a;
                            }
                            case UP: {
                                return BlockFence.field_176527_M;
                            }
                            case NORTH: {
                                return BlockFence.field_176528_N;
                            }
                            case SOUTH: {
                                return BlockFence.field_176525_b;
                            }
                            default: {
                                break Label_0212;
                            }
                        }
                        break;
                    }
                    case Y: {
                        switch (facing) {
                            case NORTH: {
                                return BlockFence.field_176526_a;
                            }
                            case SOUTH: {
                                return BlockFence.field_176527_M;
                            }
                            case WEST: {
                                return BlockFence.field_176528_N;
                            }
                            case EAST: {
                                return BlockFence.field_176525_b;
                            }
                            default: {
                                break Label_0212;
                            }
                        }
                        break;
                    }
                    case Z: {
                        switch (facing) {
                            case DOWN: {
                                return BlockFence.field_176527_M;
                            }
                            case UP: {
                                return BlockFence.field_176526_a;
                            }
                            case WEST: {
                                return BlockFence.field_176525_b;
                            }
                            case EAST: {
                                return BlockFence.field_176528_N;
                            }
                            default: {
                                break Label_0212;
                            }
                        }
                        break;
                    }
                }
            }
            TwilightForestMod.LOGGER.warn("ConnectableRotatedPillar helper (getPropertyFromFacingWithAxis) had a problem? (facing '{}' with axis '{}')", (Object)facing.func_176610_l(), (Object)axis.func_176610_l());
            return BlockFence.field_176526_a;
        }
    }
}
