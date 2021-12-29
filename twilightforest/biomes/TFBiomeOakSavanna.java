// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.World;
import net.minecraft.block.BlockFlower;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
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
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)this.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
        }
        if (par1Random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant, 4);
        }
        return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
    }
    
    public String func_150572_a(final Random p_150572_1_, final int p_150572_2_, final int p_150572_3_, final int p_150572_4_) {
        final double d0 = TFBiomeOakSavanna.field_150606_ad.func_151601_a(p_150572_2_ / 200.0, p_150572_4_ / 200.0);
        if (d0 < -0.8) {
            final int l = p_150572_1_.nextInt(4);
            return BlockFlower.field_149859_a[4 + l];
        }
        if (p_150572_1_.nextInt(3) > 0) {
            final int l = p_150572_1_.nextInt(3);
            return (l == 0) ? BlockFlower.field_149859_a[0] : ((l == 1) ? BlockFlower.field_149859_a[3] : BlockFlower.field_149859_a[8]);
        }
        return BlockFlower.field_149858_b[0];
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        TFBiomeOakSavanna.field_150610_ae.func_150548_a(2);
        for (int k = 0; k < 7; ++k) {
            final int l = par3 + par2Random.nextInt(16) + 8;
            final int i1 = par4 + par2Random.nextInt(16) + 8;
            final int j1 = par2Random.nextInt(par1World.func_72976_f(l, i1) + 32);
            TFBiomeOakSavanna.field_150610_ae.func_76484_a(par1World, par2Random, l, j1, i1);
        }
        super.func_76728_a(par1World, par2Random, par3, par4);
    }
}
