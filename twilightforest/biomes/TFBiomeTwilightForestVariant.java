// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;

public class TFBiomeTwilightForestVariant extends TFBiomeBase
{
    public TFBiomeTwilightForestVariant(final int i) {
        super(i);
        this.field_76750_F = 0.7f;
        this.field_76751_G = 0.8f;
        this.getTFBiomeDecorator().setTreesPerChunk(25);
        this.getTFBiomeDecorator().setGrassPerChunk(15);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(3, 0);
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)this.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(4) != 0) {
            return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
        }
        if (par1Random.nextBoolean()) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant, 4);
        }
        return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        TFBiomeTwilightForestVariant.field_150610_ae.func_150548_a(3);
        for (int i = 0; i < 7; ++i) {
            final int rx = par3 + par2Random.nextInt(16) + 8;
            final int rz = par4 + par2Random.nextInt(16) + 8;
            final int ry = par2Random.nextInt(par1World.func_72976_f(rx, rz) + 32);
            TFBiomeTwilightForestVariant.field_150610_ae.func_76484_a(par1World, par2Random, rx, ry, rz);
        }
        super.func_76728_a(par1World, par2Random, par3, par4);
    }
}
