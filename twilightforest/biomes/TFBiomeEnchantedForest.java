// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.world.TFWorld;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import twilightforest.world.TFGenLargeRainboak;
import twilightforest.world.TFGenSmallRainboak;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.ColorizerGrass;
import java.util.Random;

public class TFBiomeEnchantedForest extends TFBiomeBase
{
    Random colorRNG;
    
    public TFBiomeEnchantedForest(final int i) {
        super(i);
        this.colorRNG = new Random();
        this.getTFBiomeDecorator().setGrassPerChunk(15);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    @Override
    public int func_76737_k() {
        return (ColorizerGrass.func_77480_a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    @Override
    public int func_76726_l() {
        return (ColorizerGrass.func_77480_a((double)this.colorRNG.nextFloat(), (double)this.colorRNG.nextFloat()) & 0xFFFF00) + this.colorRNG.nextInt(256);
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(15) == 0) {
            return new TFGenSmallRainboak();
        }
        if (random.nextInt(50) == 0) {
            return new TFGenLargeRainboak();
        }
        if (random.nextInt(5) == 0) {
            return (WorldGenerator)this.field_76764_P;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenBigTree(false);
        }
        return (WorldGenerator)this.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(3) > 0) {
            return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2);
        }
        if (par1Random.nextInt(3) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 8);
        }
        return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        super.func_76728_a(par1World, par2Random, par3, par4);
        final WorldGenVines worldgenvines = new WorldGenVines();
        for (int i = 0; i < 20; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.func_76484_a(par1World, par2Random, j, (int)byte0, k);
        }
    }
}
