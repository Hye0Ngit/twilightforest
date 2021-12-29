// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;
import net.minecraft.tags.ITag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenDarkForestFeature extends Feature<BlockClusterFeatureConfig>
{
    public TFGenDarkForestFeature(final Codec<BlockClusterFeatureConfig> codec) {
        super((Codec)codec);
    }
    
    public boolean generate(final ISeedReader reader, final ChunkGenerator generator, final Random rand, BlockPos pos, final BlockClusterFeatureConfig config) {
        boolean foundDirt = false;
        if (pos.func_177956_o() <= 40) {
            for (int dy = pos.func_177956_o(); dy >= 31; --dy) {
                final Material materialUnder = reader.func_180495_p(new BlockPos(pos.func_177958_n(), dy - 1, pos.func_177952_p())).func_185904_a();
                if ((materialUnder == Material.field_151577_b || materialUnder == Material.field_151578_c) && reader.func_180495_p(pos) == Blocks.field_150350_a.func_176223_P()) {
                    foundDirt = true;
                    pos = new BlockPos(pos.func_177958_n(), dy, pos.func_177952_p());
                    break;
                }
                if (materialUnder == Material.field_151576_e) {
                    break;
                }
                if (materialUnder == Material.field_151595_p) {
                    break;
                }
            }
        }
        if (!foundDirt) {
            return false;
        }
        final BlockState blockstate = config.field_227289_a_.func_225574_a_(rand, pos);
        int i = 0;
        final BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        for (int j = 0; j < config.field_227293_f_; ++j) {
            blockpos$mutable.func_239621_a_((Vector3i)pos, rand.nextInt(config.field_227294_g_ + 1) - rand.nextInt(config.field_227294_g_ + 1), rand.nextInt(config.field_227295_h_ + 1) - rand.nextInt(config.field_227295_h_ + 1), rand.nextInt(config.field_227296_i_ + 1) - rand.nextInt(config.field_227296_i_ + 1));
            final BlockPos blockpos1 = blockpos$mutable.func_177977_b();
            final BlockState blockstate2 = reader.func_180495_p(blockpos1);
            if ((reader.func_175623_d((BlockPos)blockpos$mutable) || (config.field_227297_j_ && reader.func_180495_p((BlockPos)blockpos$mutable).func_185904_a().func_76222_j())) && blockstate.func_196955_c((IWorldReader)reader, (BlockPos)blockpos$mutable) && (config.field_227291_c_.isEmpty() || config.field_227291_c_.contains(blockstate2.func_177230_c())) && !config.field_227292_d_.contains(blockstate2) && (!config.field_227299_l_ || reader.func_204610_c(blockpos1.func_177976_e()).func_206884_a((ITag)FluidTags.field_206959_a) || reader.func_204610_c(blockpos1.func_177974_f()).func_206884_a((ITag)FluidTags.field_206959_a) || reader.func_204610_c(blockpos1.func_177978_c()).func_206884_a((ITag)FluidTags.field_206959_a) || reader.func_204610_c(blockpos1.func_177968_d()).func_206884_a((ITag)FluidTags.field_206959_a))) {
                config.field_227290_b_.func_225567_a_((IWorld)reader, (BlockPos)blockpos$mutable, blockstate, rand);
                ++i;
            }
        }
        return i > 0;
    }
}
