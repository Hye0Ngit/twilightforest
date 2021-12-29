// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenFireJet extends Feature<BlockStateFeatureConfig>
{
    public TFGenFireJet(final Codec<BlockStateFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final BlockStateFeatureConfig config) {
        if (!FeatureUtil.isAreaSuitable((IWorld)world, pos, 5, 2, 5)) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            final BlockPos dPos = pos.func_177982_a(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (world.func_175623_d(dPos) && world.func_175710_j(dPos) && world.func_180495_p(dPos.func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177974_f().func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177976_e().func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177968_d().func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177978_c().func_177977_b()).func_185904_a() == Material.field_151577_b) {
                for (int gx = -2; gx <= 2; ++gx) {
                    for (int gz = -2; gz <= 2; ++gz) {
                        final BlockPos grassPos = dPos.func_177982_a(gx, -1, gz);
                        world.func_180501_a(grassPos, Blocks.field_196658_i.func_176223_P(), 0);
                    }
                }
                world.func_180501_a(dPos.func_177977_b(), config.field_227270_a_, 0);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        final BlockPos dPos2 = dPos.func_177982_a(rx, -2, rz);
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.func_180501_a(dPos2, Blocks.field_150353_l.func_176223_P(), 0);
                        }
                        else if (world.func_180495_p(dPos2).func_185904_a() != Material.field_151587_i) {
                            world.func_180501_a(dPos2, Blocks.field_150348_b.func_176223_P(), 0);
                        }
                        world.func_180501_a(dPos2.func_177977_b(), Blocks.field_150348_b.func_176223_P(), 0);
                    }
                }
            }
        }
        return true;
    }
}
