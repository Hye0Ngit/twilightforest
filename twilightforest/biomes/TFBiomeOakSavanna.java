// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
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
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import twilightforest.world.feature.TFGenNoTree;
import twilightforest.world.feature.TFGenCanopyOak;
import net.minecraft.world.biome.Biome;

public class TFBiomeOakSavanna extends TFBiomeBase
{
    public TFBiomeOakSavanna(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().canopyTreeGen = (WorldGenerator)new TFGenCanopyOak();
        this.getTFBiomeDecorator().alternateCanopyChance = 0.8f;
        this.getTFBiomeDecorator().alternateCanopyGen = (WorldGenerator)new TFGenNoTree();
        this.field_76760_I.field_76832_z = 1;
        this.field_76760_I.field_76802_A = 4;
        this.field_76760_I.field_76803_B = 20;
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)TFBiomeOakSavanna.field_76757_N;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random random) {
        if (random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        }
        if (random.nextInt(10) == 0) {
            return new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MAYAPPLE));
        }
        return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public void func_180624_a(final World world, final Random random, final BlockPos pos) {
        TFBiomeOakSavanna.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.GRASS);
        for (int i = 0; i < 7; ++i) {
            final int x = pos.func_177958_n() + random.nextInt(16) + 8;
            final int z = pos.func_177952_p() + random.nextInt(16) + 8;
            final int y = random.nextInt(world.func_189649_b(x, z) + 32);
            TFBiomeOakSavanna.field_180280_ag.func_180709_b(world, random, new BlockPos(x, y, z));
        }
        super.func_180624_a(world, random, pos);
    }
}
