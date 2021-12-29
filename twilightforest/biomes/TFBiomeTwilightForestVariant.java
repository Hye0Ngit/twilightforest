// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenTallGrass;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.block.BlockLeaves;
import twilightforest.enums.LeavesVariant;
import twilightforest.block.BlockTFLeaves;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraft.world.biome.Biome;

public class TFBiomeTwilightForestVariant extends TFBiomeBase
{
    public TFBiomeTwilightForestVariant(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().setTreesPerChunk(25);
        this.getTFBiomeDecorator().setGrassPerChunk(15);
        this.getTFBiomeDecorator().setFlowersPerChunk(8);
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.OAK), TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockTFLeaves.VARIANT, (Comparable)LeavesVariant.OAK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)TFBiomeTwilightForestVariant.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random random) {
        if (random.nextInt(4) != 0) {
            return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        }
        if (random.nextBoolean()) {
            return new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MAYAPPLE));
        }
        return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public void func_180624_a(final World world, final Random random, final BlockPos pos) {
        TFBiomeTwilightForestVariant.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.FERN);
        for (int i = 0; i < 7; ++i) {
            final int rx = pos.func_177958_n() + random.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + random.nextInt(16) + 8;
            final int ry = random.nextInt(world.func_189649_b(rx, rz) + 32);
            TFBiomeTwilightForestVariant.field_180280_ag.func_180709_b(world, random, new BlockPos(rx, ry, rz));
        }
        super.func_180624_a(world, random, pos);
    }
}
