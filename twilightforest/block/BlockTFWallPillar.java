// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.Block;
import twilightforest.client.ModelUtils;
import twilightforest.TwilightForestMod;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import twilightforest.client.ModelRegisterCallbackCTM;

public class BlockTFWallPillar extends BlockTFConnectableRotatedPillar implements ModelRegisterCallbackCTM
{
    protected static final PropertyBool UP;
    protected static final PropertyBool DOWN;
    
    BlockTFWallPillar(final Material material, final double width, final double height) {
        super(material, width, height);
        this.func_180632_j(this.func_176223_P().func_177226_a((IProperty)BlockTFWallPillar.UP, (Comparable)false).func_177226_a((IProperty)BlockTFWallPillar.DOWN, (Comparable)false));
    }
    
    @Override
    protected IProperty[] getAdditionalProperties() {
        return new IProperty[] { (IProperty)BlockTFWallPillar.UP, (IProperty)BlockTFWallPillar.DOWN };
    }
    
    @Override
    protected boolean canConnectTo(final IBlockState state, final IBlockState otherState, final IBlockAccess world, final BlockPos pos, final EnumFacing connectTo) {
        return otherState.func_177230_c() == this && state.func_177229_b((IProperty)BlockTFWallPillar.field_176298_M) == otherState.func_177229_b((IProperty)BlockTFWallPillar.field_176298_M);
    }
    
    @Override
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return super.func_185496_a(state, world, pos);
    }
    
    @Override
    public IBlockState func_176221_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        final EnumFacing.Axis axis = (EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFWallPillar.field_176298_M);
        return super.func_176221_a(state.func_177226_a((IProperty)BlockTFWallPillar.UP, (Comparable)this.canConnectTo(state, world.func_180495_p(pos.func_177972_a(getFacingFromPropertyWithAxis(BlockTFWallPillar.UP, axis))), world, pos, EnumFacing.UP)).func_177226_a((IProperty)BlockTFWallPillar.DOWN, (Comparable)this.canConnectTo(state, world.func_180495_p(pos.func_177972_a(getFacingFromPropertyWithAxis(BlockTFWallPillar.DOWN, axis))), world, pos, EnumFacing.DOWN)), world, pos);
    }
    
    private static EnumFacing getFacingFromPropertyWithAxis(final PropertyBool property, final EnumFacing.Axis axis) {
        switch (axis) {
            case X: {
                if (property == BlockTFWallPillar.DOWN) {
                    return EnumFacing.WEST;
                }
                if (property == BlockTFWallPillar.UP) {
                    return EnumFacing.EAST;
                }
                break;
            }
            case Y: {
                if (property == BlockTFWallPillar.DOWN) {
                    return EnumFacing.DOWN;
                }
                if (property == BlockTFWallPillar.UP) {
                    return EnumFacing.UP;
                }
                break;
            }
            case Z: {
                if (property == BlockTFWallPillar.DOWN) {
                    return EnumFacing.SOUTH;
                }
                if (property == BlockTFWallPillar.UP) {
                    return EnumFacing.NORTH;
                }
                break;
            }
        }
        TwilightForestMod.LOGGER.warn("BlockTFWallPillar helper (getFacingFromPropertyWithAxis) had a problem? (property '{}' with axis '{}')", (Object)property.func_177701_a(), (Object)axis.func_176610_l());
        return PairHelper.getFacingFromPropertyWithAxis(property, axis);
    }
    
    @Override
    public void registerModel() {
        ModelUtils.registerToState((Block)this, 0, this.func_176223_P());
    }
    
    static {
        UP = PropertyBool.func_177716_a("up");
        DOWN = PropertyBool.func_177716_a("down");
    }
}
