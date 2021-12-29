// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenTallGrass extends WorldGenerator
{
    private final IBlockState state;
    private final int amount;
    
    public TFGenTallGrass(final IBlockState state) {
        this(state, 128);
    }
    
    public TFGenTallGrass(final IBlockState state, final int amount) {
        if (!(state.func_177230_c() instanceof BlockBush)) {
            throw new RuntimeException("attempt to use TFGenTallGrass with a blockstate that isn't a BlockBush");
        }
        this.state = state;
        this.amount = amount;
    }
    
    public boolean func_180709_b(final World worldIn, final Random rand, BlockPos position) {
        do {
            final IBlockState state = worldIn.func_180495_p(position);
            if (!state.func_177230_c().isAir(state, (IBlockAccess)worldIn, position) && !state.func_177230_c().isLeaves(state, (IBlockAccess)worldIn, position)) {
                break;
            }
            position = position.func_177977_b();
        } while (position.func_177956_o() > 0);
        for (int i = 0; i < this.amount; ++i) {
            final BlockPos blockpos = position.func_177982_a(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.func_175623_d(blockpos) && ((BlockBush)this.state.func_177230_c()).func_180671_f(worldIn, blockpos, this.state)) {
                worldIn.func_180501_a(blockpos, this.state, 18);
            }
        }
        return true;
    }
}
