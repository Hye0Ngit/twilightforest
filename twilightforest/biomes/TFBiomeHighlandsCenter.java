// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFBiomeHighlandsCenter extends TFBiomeBase
{
    public TFBiomeHighlandsCenter(final int i) {
        super(i);
        this.field_76752_A = TFBlocks.deadrock;
        this.field_150604_aj = 1;
        this.field_76753_B = TFBlocks.deadrock;
        this.field_76754_C = 1;
        this.field_76750_F = 0.3f;
        this.field_76751_G = 0.2f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenTaiga2(true);
        }
        return (WorldGenAbstractTree)this.birchGen;
    }
    
    @Override
    public Block getStoneReplacementBlock() {
        return TFBlocks.deadrock;
    }
    
    @Override
    public byte getStoneReplacementMeta() {
        return 2;
    }
}
