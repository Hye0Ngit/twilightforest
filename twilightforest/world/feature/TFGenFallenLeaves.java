// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.IWorldReader;
import net.minecraft.block.BushBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenFallenLeaves extends Feature<NoFeatureConfig>
{
    private final BlockState state;
    
    public TFGenFallenLeaves(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
        this.state = ((Block)TFBlocks.fallen_leaves.get()).func_176223_P();
    }
    
    public boolean generate(final ISeedReader worldIn, final ChunkGenerator generator, final Random rand, BlockPos position, final NoFeatureConfig config) {
        do {
            final BlockState state = worldIn.func_180495_p(position.func_177977_b());
            if (worldIn.func_175623_d(position)) {
                if (state.func_185904_a() == Material.field_151577_b) {
                    break;
                }
                if (state.func_185904_a() == Material.field_151578_c) {
                    break;
                }
            }
            position = position.func_177977_b();
        } while (position.func_177956_o() > generator.func_205470_d());
        for (int x = 0; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(3) == 0) {
                    boolean flag = false;
                    int y = 2;
                    do {
                        final BlockState state2 = worldIn.func_180495_p(position.func_177982_a(x, y, z).func_177977_b());
                        if (worldIn.func_175623_d(position.func_177982_a(x, y, z)) && (state2.func_185904_a() == Material.field_151577_b || state2.func_185904_a() == Material.field_151578_c)) {
                            flag = true;
                            break;
                        }
                    } while (--y >= -2);
                    if (flag) {
                        final BlockPos pos = position.func_177982_a(x, y, z);
                        if (((BushBlock)this.state.func_177230_c()).func_196260_a(this.state, (IWorldReader)worldIn, pos)) {
                            worldIn.func_180501_a(pos, this.state, 18);
                        }
                    }
                }
            }
        }
        return true;
    }
}
