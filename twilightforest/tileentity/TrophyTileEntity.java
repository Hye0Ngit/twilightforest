// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TrophyTileEntity extends TileEntity implements ITickableTileEntity
{
    private int animatedTicks;
    private boolean animated;
    
    public TrophyTileEntity() {
        super((TileEntityType)TFTileEntities.TROPHY.get());
    }
    
    public void func_73660_a() {
        final BlockState blockstate = this.func_195044_w();
        if (blockstate.func_203425_a((Block)TFBlocks.ur_ghast_trophy.get()) || blockstate.func_203425_a((Block)TFBlocks.ur_ghast_wall_trophy.get())) {
            this.animated = true;
            ++this.animatedTicks;
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public float getAnimationProgress(final float time) {
        return this.animated ? (this.animatedTicks + time) : ((float)this.animatedTicks);
    }
}
