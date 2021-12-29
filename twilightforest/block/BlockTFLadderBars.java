// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.client.ModelUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLadder;

public class BlockTFLadderBars extends BlockLadder implements ModelRegisterCallback
{
    public static final PropertyBool LEFT;
    public static final PropertyBool RIGHT;
    
    BlockTFLadderBars() {
        this.func_180632_j(this.func_176223_P().func_177226_a((IProperty)BlockTFLadderBars.LEFT, (Comparable)false).func_177226_a((IProperty)BlockTFLadderBars.RIGHT, (Comparable)false));
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockLadder.field_176382_a, (IProperty)BlockTFLadderBars.LEFT, (IProperty)BlockTFLadderBars.RIGHT });
    }
    
    public IBlockState func_176221_a(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
        final EnumFacing facing = (EnumFacing)state.func_177229_b((IProperty)BlockLadder.field_176382_a);
        final IBlockState leftState = worldIn.func_180495_p(pos.func_177972_a(rotateCW(facing)));
        final IBlockState rightState = worldIn.func_180495_p(pos.func_177972_a(rotateCCW(facing)));
        return super.func_176221_a(state, worldIn, pos).func_177226_a((IProperty)BlockTFLadderBars.LEFT, (Comparable)(leftState.func_177230_c() instanceof BlockTFLadderBars && leftState.func_177229_b((IProperty)BlockLadder.field_176382_a) == facing)).func_177226_a((IProperty)BlockTFLadderBars.RIGHT, (Comparable)(rightState.func_177230_c() instanceof BlockTFLadderBars && rightState.func_177229_b((IProperty)BlockLadder.field_176382_a) == facing));
    }
    
    private static EnumFacing rotateCW(final EnumFacing facing) {
        switch (facing) {
            case NORTH: {
                return EnumFacing.WEST;
            }
            case WEST: {
                return EnumFacing.SOUTH;
            }
            case SOUTH: {
                return EnumFacing.EAST;
            }
            case EAST: {
                return EnumFacing.NORTH;
            }
            default: {
                return facing;
            }
        }
    }
    
    private static EnumFacing rotateCCW(final EnumFacing facing) {
        switch (facing) {
            case NORTH: {
                return EnumFacing.EAST;
            }
            case EAST: {
                return EnumFacing.SOUTH;
            }
            case SOUTH: {
                return EnumFacing.WEST;
            }
            case WEST: {
                return EnumFacing.NORTH;
            }
            default: {
                return facing;
            }
        }
    }
    
    public void registerModel() {
        ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty<?>[])new IProperty[0]);
    }
    
    static {
        LEFT = PropertyBool.func_177716_a("left");
        RIGHT = PropertyBool.func_177716_a("right");
    }
}
