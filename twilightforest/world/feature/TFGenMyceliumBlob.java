// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.AbstractSphereReplaceConfig;

public class TFGenMyceliumBlob extends AbstractSphereReplaceConfig
{
    public TFGenMyceliumBlob(final Codec<SphereReplaceConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean func_241855_a(final ISeedReader world, final ChunkGenerator generator, final Random random, final BlockPos pos, final SphereReplaceConfig config) {
        boolean flag = false;
        for (int i = config.field_202432_b.func_242259_a(random), j = pos.func_177958_n() - i; j <= pos.func_177958_n() + i; ++j) {
            for (int k = pos.func_177952_p() - i; k <= pos.func_177952_p() + i; ++k) {
                final int l = j - pos.func_177958_n();
                final int i2 = k - pos.func_177952_p();
                if (l * l + i2 * i2 <= i * i) {
                    for (int j2 = pos.func_177956_o() - config.field_242809_d; j2 <= pos.func_177956_o() + config.field_242809_d; ++j2) {
                        final BlockPos blockpos = new BlockPos(j, j2, k);
                        final Block block = world.func_180495_p(blockpos).func_177230_c();
                        for (final BlockState blockstate : config.field_202434_d) {
                            if (blockstate.func_203425_a(block) && world.func_175623_d(pos.func_177984_a())) {
                                world.func_180501_a(blockpos, config.field_214693_a, 2);
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }
}
