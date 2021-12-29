// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Blocks;
import twilightforest.world.TFWorld;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFGenThorns;

public class TFBiomeThornlands extends TFBiomeBase
{
    private TFGenThorns tfGenThorns;
    
    public TFBiomeThornlands(final int i) {
        super(i);
        this.field_76752_A = TFBlocks.deadrock;
        this.field_150604_aj = 0;
        this.field_76753_B = TFBlocks.deadrock;
        this.field_76754_C = 1;
        this.field_76750_F = 0.3f;
        this.field_76751_G = 0.2f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
        this.field_76760_I.field_76804_C = 2;
        this.field_76760_I.field_76800_F = -9999;
        this.field_76762_K.clear();
        this.tfGenThorns = new TFGenThorns();
    }
    
    public void func_76728_a(final World world, final Random rand, final int mapX, final int mapZ) {
        super.func_76728_a(world, rand, mapX, mapZ);
        for (int i = 0; i < 128; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = this.getGroundLevel(world, rx, rz);
            this.tfGenThorns.func_76484_a(world, rand, rx, ry, rz);
        }
    }
    
    public int getGroundLevel(final World world, final int x, final int z) {
        final Chunk chunk = world.func_72938_d(x, z);
        int lastDirt = TFWorld.SEALEVEL;
        for (int y = TFWorld.SEALEVEL; y < TFWorld.CHUNKHEIGHT - 1; ++y) {
            final Block blockID = chunk.func_150810_a(x & 0xF, y, z & 0xF);
            if (blockID == Blocks.field_150349_c) {
                return y + 1;
            }
            if (blockID == Blocks.field_150346_d || blockID == Blocks.field_150348_b || blockID == Blocks.field_150351_n || blockID == Blocks.field_150322_A || blockID == Blocks.field_150354_m || blockID == Blocks.field_150435_aG || blockID == TFBlocks.deadrock) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
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
