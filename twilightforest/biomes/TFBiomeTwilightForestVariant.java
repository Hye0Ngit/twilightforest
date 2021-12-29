// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class TFBiomeTwilightForestVariant extends TFBiomeBase
{
    public TFBiomeTwilightForestVariant(final int i) {
        super(i);
        this.field_76750_F = 0.7f;
        this.field_76751_G = 0.8f;
        this.field_76748_D = 0.15f;
        this.field_76749_E = 0.4f;
        this.getTFBiomeDecorator().setTreesPerChunk(25);
        this.getTFBiomeDecorator().setGrassPerChunk(15);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenerator)new WorldGenShrub(3, 0);
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenBigTree(false);
        }
        return (WorldGenerator)this.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(4) != 0) {
            return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2);
        }
        if (par1Random.nextBoolean()) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 4);
        }
        return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }
}
