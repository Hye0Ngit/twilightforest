// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import java.util.Iterator;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockDoublePlant;
import twilightforest.world.feature.TFGenVines;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenTallGrass;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import twilightforest.world.feature.TFGenLargeRainboak;
import twilightforest.world.feature.TFGenSmallRainboak;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import java.util.Random;

public class TFBiomeEnchantedForest extends TFBiomeBase
{
    private final Random colorRNG;
    
    public TFBiomeEnchantedForest(final Biome.BiomeProperties props) {
        super(props);
        this.colorRNG = new Random();
        this.getTFBiomeDecorator().setGrassPerChunk(12);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    public int func_180627_b(final BlockPos pos) {
        return (super.func_180627_b(pos) & 0xFFFF00) + this.getEnchantedColor(pos.func_177958_n(), pos.func_177952_p());
    }
    
    public int func_180625_c(final BlockPos pos) {
        return (super.func_180625_c(pos) & 0xFFFF00) + this.getEnchantedColor(pos.func_177958_n(), pos.func_177952_p());
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
            return (WorldGenAbstractTree)new TFGenSmallRainboak();
        }
        if (random.nextInt(50) == 0) {
            return new TFGenLargeRainboak();
        }
        if (random.nextInt(5) == 0) {
            return this.birchGen;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)TFBiomeEnchantedForest.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random random) {
        if (random.nextInt(3) > 0) {
            return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        }
        if (random.nextInt(3) == 0) {
            return new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.FIDDLEHEAD));
        }
        return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public void func_180624_a(final World world, final Random rand, final BlockPos pos) {
        final BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos();
        final WorldGenerator vines = new TFGenVines();
        for (int i = 0; i < 20; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int ry = 159;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            vines.func_180709_b(world, rand, (BlockPos)mutPos.func_181079_c(rx, ry, rz));
        }
        TFBiomeEnchantedForest.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.FERN);
        for (int i = 0; i < 20; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry2 = rand.nextInt(world.func_189649_b(rx, rz2) + 32);
            TFBiomeEnchantedForest.field_180280_ag.func_180709_b(world, rand, (BlockPos)mutPos.func_181079_c(rx, ry2, rz2));
        }
        super.func_180624_a(world, rand, pos);
    }
    
    public BlockFlower.EnumFlowerType func_180623_a(final Random rand, final BlockPos pos) {
        final double d0 = MathHelper.func_151237_a((1.0 + TFBiomeEnchantedForest.field_180281_af.func_151601_a(pos.func_177958_n() / 48.0, pos.func_177952_p() / 48.0)) / 2.0, 0.0, 0.9999);
        final BlockFlower.EnumFlowerType blockflower$enumflowertype = BlockFlower.EnumFlowerType.values()[(int)(d0 * BlockFlower.EnumFlowerType.values().length)];
        return (blockflower$enumflowertype == BlockFlower.EnumFlowerType.BLUE_ORCHID) ? BlockFlower.EnumFlowerType.POPPY : blockflower$enumflowertype;
    }
    
    public void addDefaultFlowers() {
        for (final BlockFlower.EnumFlowerType flowerType : Blocks.field_150327_N.func_176494_l().func_177700_c()) {
            this.addFlower(Blocks.field_150327_N.func_176223_P().func_177226_a(Blocks.field_150327_N.func_176494_l(), (Comparable)flowerType), 10);
        }
        for (final BlockFlower.EnumFlowerType flowerType : Blocks.field_150328_O.func_176494_l().func_177700_c()) {
            this.addFlower(Blocks.field_150328_O.func_176223_P().func_177226_a(Blocks.field_150328_O.func_176494_l(), (Comparable)flowerType), 10);
        }
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.QUEST_GROVE;
    }
}
