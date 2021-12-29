// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.start;

import twilightforest.TwilightForestMod;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.World;

public class StructureStartNothing extends StructureStartTFAbstract
{
    public StructureStartNothing() {
    }
    
    @Override
    protected StructureComponent makeFirstComponent(final World world, final TFFeature feature, final Random rand, final int x, final int y, final int z) {
        return null;
    }
    
    public StructureStartNothing(final World world, final Random rand, final int chunkX, final int chunkZ) {
        super(world, TFFeature.NOTHING, rand, chunkX, chunkZ);
        TwilightForestMod.LOGGER.warn("Generated nothing at chunk [{}, {}]!", (Object)chunkX, (Object)chunkZ);
    }
}
