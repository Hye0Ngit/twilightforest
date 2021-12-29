// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen;

import net.minecraft.world.gen.placement.IPlacementConfig;
import java.util.Optional;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.feature.structure.StructureStart;
import twilightforest.world.TFGenerationSettings;
import twilightforest.world.ChunkGeneratorTwilightBase;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class OutOfStructurePlacement extends Placement<NoPlacementConfig>
{
    public OutOfStructurePlacement(final Codec<NoPlacementConfig> p_i232086_1_) {
        super((Codec)p_i232086_1_);
    }
    
    public Stream<BlockPos> getPositions(final WorldDecoratingHelper worldDecoratingHelper, final Random random, final NoPlacementConfig noPlacementConfig, final BlockPos blockPos) {
        if (worldDecoratingHelper.field_242890_b instanceof ChunkGeneratorTwilightBase) {
            final Optional<StructureStart<?>> struct = TFGenerationSettings.locateTFStructureInRange(worldDecoratingHelper.field_242889_a, blockPos, 0);
            if (struct.isPresent()) {
                final StructureStart<?> structure = struct.get();
                if (structure.func_75071_a().func_175898_b((Vector3i)blockPos)) {
                    final TFFeature nearbyFeature = TFFeature.getFeatureAt(blockPos.func_177958_n(), blockPos.func_177952_p(), worldDecoratingHelper.field_242889_a);
                    if (nearbyFeature == TFFeature.KNIGHT_STRONGHOLD && blockPos.func_177956_o() >= 33) {
                        return Stream.of(blockPos);
                    }
                    return Stream.empty();
                }
            }
        }
        return Stream.of(blockPos);
    }
}
