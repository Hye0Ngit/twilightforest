// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.world.TFWorld;
import twilightforest.world.feature.TFGenCanopyTree;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.entity.EntityTFSkeletonDruid;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import twilightforest.features.TFGenGraveyard;
import twilightforest.world.feature.TFGenTallGrass;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import twilightforest.world.feature.TFGenLampposts;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenFallenLeaves;
import twilightforest.world.feature.TFGenWebs;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFBiomeSpookyForest extends TFBiomeBase
{
    private final WorldGenerator tfGenWebs;
    private final WorldGenerator tfGenLeaf;
    private final WorldGenerator tfGenLampposts;
    private final WorldGenerator worldGenMushgloom;
    private final WorldGenerator worldGenDeadBush;
    private final WorldGenerator graveyardGen;
    private final WorldGenerator worldGenPumpkin;
    
    public TFBiomeSpookyForest(final Biome.BiomeProperties props) {
        super(props);
        this.tfGenWebs = new TFGenWebs();
        this.tfGenLeaf = new TFGenFallenLeaves();
        this.tfGenLampposts = new TFGenLampposts(Blocks.field_150428_aP.func_176223_P());
        this.worldGenMushgloom = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MUSHGLOOM));
        this.worldGenDeadBush = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.DEADBUSH), 8);
        this.graveyardGen = new TFGenGraveyard();
        this.worldGenPumpkin = (WorldGenerator)new WorldGenPumpkin();
        this.getTFBiomeDecorator().setFlowersPerChunk(1);
        this.getTFBiomeDecorator().setGrassPerChunk(4);
        this.getTFBiomeDecorator().setTreesPerChunk(2);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityBat.class, 20, 8, 8));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntitySpider.class, 50, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntitySkeleton.class, 20, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFSkeletonDruid.class, 5, 1, 1));
    }
    
    public void func_180624_a(final World world, final Random rand, final BlockPos pos) {
        super.func_180624_a(world, rand, pos);
        final float canopyPerChunk = 1.7f;
        for (int nc = (int)canopyPerChunk + ((rand.nextFloat() < canopyPerChunk - (int)canopyPerChunk) ? 1 : 0), i = 0; i < nc; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final BlockPos genPos = new BlockPos(rx, world.func_189649_b(rx, rz), rz);
            ((TFGenCanopyTree)this.getTFBiomeDecorator().canopyTreeGen).generate(world, rand, genPos, false);
        }
        if (rand.nextInt(24) == 0) {
            final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = TFWorld.getGroundLevel(world, rx2, rz2);
            this.worldGenMushgloom.func_180709_b(world, rand, new BlockPos(rx2, ry, rz2));
        }
        for (int i = 0; i < 36; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(30) + 2;
            final int rz = pos.func_177952_p() + rand.nextInt(30) + 2;
            final int ry2 = 31 + rand.nextInt(225);
            this.tfGenWebs.func_180709_b(world, rand, new BlockPos(rx, ry2, rz));
        }
        if (rand.nextInt(2) == 0) {
            final int rx2 = pos.func_177958_n() + rand.nextInt(30) + 2;
            final int rz2 = pos.func_177952_p() + rand.nextInt(30) + 2;
            final int ry = TFWorld.getGroundLevel(world, rx2, rz2);
            this.tfGenLampposts.func_180709_b(world, rand, new BlockPos(rx2, ry, rz2));
        }
        if (rand.nextInt(16) == 0) {
            final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = TFWorld.getGroundLevel(world, rx2, rz2);
            this.worldGenPumpkin.func_180709_b(world, rand, new BlockPos(rx2, ry, rz2));
        }
        for (int i = 0; i < 6; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            this.worldGenDeadBush.func_180709_b(world, rand, new BlockPos(rx, world.func_189649_b(rx, rz), rz));
        }
        for (int i = 0; i < 6; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(25) + 2;
            final int rz = pos.func_177952_p() + rand.nextInt(25) + 2;
            this.tfGenLeaf.func_180709_b(world, rand, new BlockPos(rx, world.func_189649_b(rx, rz), rz));
        }
        if (rand.nextFloat() < 0.05f) {
            final int rx2 = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
            this.graveyardGen.func_180709_b(world, rand, new BlockPos(rx2, world.func_189649_b(rx2, rz2), rz2));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int func_180627_b(final BlockPos pos) {
        return 12865827;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_180625_c(final BlockPos pos) {
        return 16745729;
    }
}
