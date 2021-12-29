// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.start;

import twilightforest.structures.stronghold.ComponentTFStrongholdEntrance;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.World;

public class StructureStartKnightStronghold extends StructureStartTFFeatureAbstract
{
    public StructureStartKnightStronghold() {
    }
    
    public StructureStartKnightStronghold(final World world, final TFFeature feature, final Random rand, final int chunkX, final int chunkZ) {
        super(world, feature, rand, chunkX, chunkZ);
    }
    
    @Override
    protected StructureComponent makeFirstComponent(final World world, final TFFeature feature, final Random rand, final int x, final int y, final int z) {
        return new ComponentTFStrongholdEntrance(TFFeature.KNIGHT_STRONGHOLD, world, rand, 0, x, y, z);
    }
}
