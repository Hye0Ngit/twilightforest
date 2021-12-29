// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockPressurePlate;

public class BlockTFPressurePlate extends BlockPressurePlate implements ModelRegisterCallback
{
    private final MapColor mapColor;
    
    public BlockTFPressurePlate(final Material material, final MapColor mapColor, final BlockPressurePlate.Sensitivity sensitivity) {
        super(material, sensitivity);
        this.mapColor = mapColor;
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return this.mapColor;
    }
}
