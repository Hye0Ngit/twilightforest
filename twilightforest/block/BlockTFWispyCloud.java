// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockBreakable;

public class BlockTFWispyCloud extends BlockBreakable implements ModelRegisterCallback
{
    protected BlockTFWispyCloud() {
        super(new Material(MapColor.field_151666_j), false);
        this.func_149672_a(SoundType.field_185854_g);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(0.3f);
    }
    
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return true;
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
}
