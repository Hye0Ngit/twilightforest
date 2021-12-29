// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.block.material.Material;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenWebs extends Feature<NoFeatureConfig>
{
    public TFGenWebs(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    private static boolean isValidMaterial(final Material material) {
        return material == Material.field_151584_j || material == Material.field_151575_d;
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random random, BlockPos pos, final NoFeatureConfig config) {
        while (pos.func_177956_o() > generator.func_205470_d() && world.func_175623_d(pos)) {
            pos = pos.func_177977_b();
        }
        if (!isValidMaterial(world.func_180495_p(pos).func_185904_a())) {
            return false;
        }
        while (!world.func_175623_d(pos.func_177977_b())) {
            pos = pos.func_177977_b();
            if (pos.func_177956_o() <= generator.func_205470_d() || !isValidMaterial(world.func_180495_p(pos).func_185904_a())) {
                return false;
            }
        }
        world.func_180501_a(pos.func_177977_b(), Blocks.field_196553_aF.func_176223_P(), 18);
        return true;
    }
}
