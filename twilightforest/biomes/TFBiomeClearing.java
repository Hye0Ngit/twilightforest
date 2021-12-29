// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;
import net.minecraft.world.biome.Biome;

public class TFBiomeClearing extends TFBiomeBase
{
    public TFBiomeClearing(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
        this.getTFBiomeDecorator().setFlowersPerChunk(4);
        this.getTFBiomeDecorator().setGrassPerChunk(10);
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random random) {
        return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
}
