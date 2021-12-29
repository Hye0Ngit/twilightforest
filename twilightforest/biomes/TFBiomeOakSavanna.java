// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;
import twilightforest.world.TFGenNoTree;
import twilightforest.world.TFGenCanopyOak;

public class TFBiomeOakSavanna extends TFBiomeTwilightForest
{
    public TFBiomeOakSavanna(final int i) {
        super(i);
        this.getTFBiomeDecorator().canopyTreeGen = new TFGenCanopyOak();
        this.getTFBiomeDecorator().alternateCanopyChance = 0.8f;
        this.getTFBiomeDecorator().alternateCanopyGen = new TFGenNoTree();
        this.field_76750_F = 0.9f;
        this.field_76751_G = 0.0f;
        this.field_76760_I.field_76832_z = 1;
        this.field_76760_I.field_76802_A = 4;
        this.field_76760_I.field_76803_B = 20;
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenBigTree(false);
        }
        return (WorldGenerator)this.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(2) != 0) {
            return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2);
        }
        if (par1Random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 4);
        }
        return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }
}
