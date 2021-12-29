// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class MoonwormBlock extends CritterBlock
{
    protected MoonwormBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Override
    public float getWidth() {
        return 0.25f;
    }
    
    @Nullable
    @Override
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return ((TileEntityType)TFTileEntities.MOONWORM.get()).func_200968_a();
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack((IItemProvider)Items.field_196116_bh, 1);
    }
}
