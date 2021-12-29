// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockTrapDoor;

public class BlockTFTrapDoor extends BlockTrapDoor implements ModelRegisterCallback
{
    private final MapColor mapColor;
    
    protected BlockTFTrapDoor(final Material material, final MapColor mapColor) {
        super(material);
        this.mapColor = mapColor;
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return this.mapColor;
    }
    
    public PathNodeType getAiPathNodeType(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return PathNodeType.TRAPDOOR;
    }
}
