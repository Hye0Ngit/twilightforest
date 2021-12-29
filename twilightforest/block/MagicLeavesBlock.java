// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.Direction;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.LeavesBlock;

public class MagicLeavesBlock extends LeavesBlock
{
    protected MagicLeavesBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return (int)TFConfig.COMMON_CONFIG.PERFORMANCE.leavesLightOpacity.get();
    }
    
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random random) {
        if (state.func_177230_c() == TFBlocks.transformation_leaves.get()) {
            for (int i = 0; i < 1; ++i) {
                this.sparkleRunes(world, pos, random);
            }
        }
    }
    
    private void sparkleRunes(final World world, final BlockPos pos, final Random rand) {
        final double offset = 0.0625;
        final Direction side = Direction.func_239631_a_(rand);
        double rx = pos.func_177958_n() + rand.nextFloat();
        double ry = pos.func_177956_o() + rand.nextFloat();
        double rz = pos.func_177952_p() + rand.nextFloat();
        if (side == Direction.DOWN && world.func_175623_d(pos.func_177984_a())) {
            ry = pos.func_177956_o() + 1 + offset;
        }
        if (side == Direction.UP && world.func_175623_d(pos.func_177977_b())) {
            ry = pos.func_177956_o() - offset;
        }
        if (side == Direction.NORTH && world.func_175623_d(pos.func_177968_d())) {
            rz = pos.func_177952_p() + 1 + offset;
        }
        if (side == Direction.SOUTH && world.func_175623_d(pos.func_177978_c())) {
            rz = pos.func_177952_p() - offset;
        }
        if (side == Direction.WEST && world.func_175623_d(pos.func_177974_f())) {
            rx = pos.func_177958_n() + 1 + offset;
        }
        if (side == Direction.EAST && world.func_175623_d(pos.func_177976_e())) {
            rx = pos.func_177958_n() - offset;
        }
        if (rx < pos.func_177958_n() || rx > pos.func_177958_n() + 1 || ry < pos.func_177956_o() || ry > pos.func_177956_o() + 1 || rz < pos.func_177952_p() || rz > pos.func_177952_p() + 1) {
            world.func_195594_a((IParticleData)TFParticleType.LEAF_RUNE.get(), rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
}
