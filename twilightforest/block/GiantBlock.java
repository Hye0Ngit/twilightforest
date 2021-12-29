// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.material.PushReaction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class GiantBlock extends Block
{
    private boolean isSelfDestructing;
    
    public GiantBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext ctx) {
        for (final BlockPos dPos : getVolume(ctx.func_195995_a())) {
            if (!ctx.func_195991_k().func_180495_p(dPos).func_196953_a(ctx)) {
                return null;
            }
        }
        return this.func_176223_P();
    }
    
    public void func_180633_a(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        if (!world.field_72995_K) {
            for (final BlockPos dPos : getVolume(pos)) {
                world.func_175656_a(dPos, this.func_176223_P());
            }
        }
    }
    
    @Deprecated
    public void func_196243_a(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        super.func_196243_a(state, world, pos, newState, isMoving);
        if (!this.isSelfDestructing && !this.isVolumeFilled(world, pos)) {
            this.setGiantBlockToAir(world, pos);
        }
    }
    
    private void setGiantBlockToAir(final World world, final BlockPos pos) {
        this.isSelfDestructing = true;
        for (final BlockPos iterPos : getVolume(pos)) {
            if (!pos.equals((Object)iterPos) && world.func_180495_p(iterPos).func_177230_c() == this) {
                world.func_175655_b(iterPos, false);
            }
        }
        this.isSelfDestructing = false;
    }
    
    private boolean isVolumeFilled(final World world, final BlockPos pos) {
        for (final BlockPos dPos : getVolume(pos)) {
            if (world.func_180495_p(dPos).func_177230_c() != this) {
                return false;
            }
        }
        return true;
    }
    
    @Deprecated
    public PushReaction func_149656_h(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    public static Iterable<BlockPos> getVolume(final BlockPos pos) {
        return BlockPos.func_191531_b(pos.func_177958_n() & 0xFFFFFFFC, pos.func_177956_o() & 0xFFFFFFFC, pos.func_177952_p() & 0xFFFFFFFC, pos.func_177958_n() | 0x3, pos.func_177956_o() | 0x3, pos.func_177952_p() | 0x3);
    }
}
