// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.BlockFlower;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import twilightforest.world.TFGenLargeRainboak;
import twilightforest.world.TFGenSmallRainboak;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.util.MathHelper;
import java.util.Random;

public class TFBiomeEnchantedForest extends TFBiomeBase
{
    Random colorRNG;
    
    public TFBiomeEnchantedForest(final int i) {
        super(i);
        this.colorRNG = new Random();
        this.getTFBiomeDecorator().setGrassPerChunk(12);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    public int func_150558_b(final int x, final int y, final int z) {
        return (super.func_150558_b(x, y, z) & 0xFFFF00) + this.getEnchantedColor(x, z);
    }
    
    public int func_150571_c(final int x, final int y, final int z) {
        return (super.func_150571_c(x, y, z) & 0xFFFF00) + this.getEnchantedColor(x, z);
    }
    
    private int getEnchantedColor(final int x, final int z) {
        final int cx = 256 * Math.round((x - 8) / 256.0f) + 8;
        final int cz = 256 * Math.round((z - 8) / 256.0f) + 8;
        final int dist = (int)MathHelper.func_76129_c((float)((cx - x) * (cx - x) + (cz - z) * (cz - z)));
        int color = dist * 64;
        color %= 512;
        if (color > 255) {
            color = 511 - color;
        }
        color = 255 - color;
        final int randomFlicker = this.colorRNG.nextInt(32) - 16;
        if (0 < color + randomFlicker && color + randomFlicker > 255) {
            color += randomFlicker;
        }
        return color;
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(15) == 0) {
            return new TFGenSmallRainboak();
        }
        if (random.nextInt(50) == 0) {
            return new TFGenLargeRainboak();
        }
        if (random.nextInt(5) == 0) {
            return (WorldGenAbstractTree)this.birchGen;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)this.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(3) > 0) {
            return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
        }
        if (par1Random.nextInt(3) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant, 8);
        }
        return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        final WorldGenVines worldgenvines = new WorldGenVines();
        for (int i = 0; i < 20; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.func_76484_a(par1World, par2Random, j, (int)byte0, k);
        }
        TFBiomeEnchantedForest.field_150610_ae.func_150548_a(3);
        for (int i = 0; i < 20; ++i) {
            final int rx = par3 + par2Random.nextInt(16) + 8;
            final int rz = par4 + par2Random.nextInt(16) + 8;
            final int ry = par2Random.nextInt(par1World.func_72976_f(rx, rz) + 32);
            TFBiomeEnchantedForest.field_150610_ae.func_76484_a(par1World, par2Random, rx, ry, rz);
        }
        super.func_76728_a(par1World, par2Random, par3, par4);
    }
    
    public String func_150572_a(final Random p_150572_1_, final int p_150572_2_, final int p_150572_3_, final int p_150572_4_) {
        return (p_150572_1_.nextInt(3) > 0) ? BlockFlower.field_149859_a[1] : (p_150572_1_.nextBoolean() ? BlockFlower.field_149859_a[2] : BlockFlower.field_149859_a[3]);
    }
}
