// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TrophyBlockEntity extends BlockEntity
{
    private int animatedTicks;
    private boolean animated;
    
    public TrophyBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.TROPHY.get(), pos, state);
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final TrophyBlockEntity te) {
        if (state.m_60713_((Block)TFBlocks.UR_GHAST_TROPHY.get()) || state.m_60713_((Block)TFBlocks.UR_GHAST_WALL_TROPHY.get())) {
            te.animated = true;
            ++te.animatedTicks;
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public float getAnimationProgress(final float time) {
        return this.animated ? (this.animatedTicks + time) : ((float)this.animatedTicks);
    }
}
