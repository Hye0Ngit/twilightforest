// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class TFBiomeClearing extends TFBiomeBase
{
    public TFBiomeClearing(final int i) {
        super(i);
        this.field_76750_F = 0.8f;
        this.field_76751_G = 0.4f;
        this.field_76748_D = 0.01f;
        this.field_76749_E = 0.0f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
        this.getTFBiomeDecorator().setFlowersPerChunk(4);
        this.getTFBiomeDecorator().setGrassPerChunk(10);
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }
}
