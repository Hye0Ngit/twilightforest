// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockDirt;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import java.util.Random;
import twilightforest.entity.EntityTFTroll;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import twilightforest.world.feature.TFGenTallGrass;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import twilightforest.world.feature.TFGenTrollRoots;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class TFBiomeHighlands extends TFBiomeBase
{
    private final WorldGenAbstractTree taigaGen1;
    private final WorldGenAbstractTree taigaGen2;
    private final WorldGenAbstractTree megaPineGen1;
    private final WorldGenAbstractTree megaPineGen2;
    private final WorldGenerator genBoulder;
    private final WorldGenerator genTrollRoots;
    private final WorldGenerator worldGenMushgloom;
    
    public TFBiomeHighlands(final Biome.BiomeProperties props) {
        super(props);
        this.taigaGen1 = (WorldGenAbstractTree)new WorldGenTaiga1();
        this.taigaGen2 = (WorldGenAbstractTree)new WorldGenTaiga2(false);
        this.megaPineGen1 = (WorldGenAbstractTree)new WorldGenMegaPineTree(false, false);
        this.megaPineGen2 = (WorldGenAbstractTree)new WorldGenMegaPineTree(false, true);
        this.genBoulder = (WorldGenerator)new WorldGenBlockBlob(Blocks.field_150341_Y, 0);
        this.genTrollRoots = new TFGenTrollRoots();
        this.worldGenMushgloom = new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MUSHGLOOM));
        this.getTFBiomeDecorator().hasCanopy = false;
        this.field_76760_I.field_76803_B = 7;
        this.field_76760_I.field_76804_C = 1;
        this.field_76760_I.field_76808_K = false;
        this.undergroundMonsterList.clear();
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntitySkeleton.class, 10, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntityCreeper.class, 1, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntitySlime.class, 10, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntityTFTroll.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(4) == 0) {
            return this.taigaGen1;
        }
        if (random.nextInt(10) == 0) {
            return this.taigaGen2;
        }
        if (random.nextInt(3) == 0) {
            return this.megaPineGen1;
        }
        if (random.nextInt(13) == 0) {
            return this.megaPineGen2;
        }
        return this.birchGen;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random random) {
        return (WorldGenerator)((random.nextInt(5) > 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS));
    }
    
    @Override
    public void func_180622_a(final World world, final Random rand, final ChunkPrimer primer, final int x, final int z, final double noiseVal) {
        this.field_76752_A = Blocks.field_150349_c.func_176223_P();
        this.field_76753_B = Blocks.field_150346_d.func_176223_P();
        if (noiseVal > 1.75) {
            this.field_76752_A = Blocks.field_150346_d.func_176223_P().func_177226_a((IProperty)BlockDirt.field_176386_a, (Comparable)BlockDirt.DirtType.COARSE_DIRT);
        }
        else if (noiseVal > -0.95) {
            this.field_76752_A = Blocks.field_150346_d.func_176223_P().func_177226_a((IProperty)BlockDirt.field_176386_a, (Comparable)BlockDirt.DirtType.PODZOL);
        }
        this.genTwilightBiomeTerrain(world, rand, primer, x, z, noiseVal);
    }
    
    public void func_180624_a(final World world, final Random rand, final BlockPos pos) {
        for (int maxBoulders = rand.nextInt(2), i = 0; i < maxBoulders; ++i) {
            final int dx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int dz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int dy = world.func_189649_b(dx, dz);
            this.genBoulder.func_180709_b(world, rand, new BlockPos(dx, dy, dz));
        }
        TFBiomeHighlands.field_180280_ag.func_180710_a(BlockDoublePlant.EnumPlantType.FERN);
        for (int i = 0; i < 7; ++i) {
            final int dx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int dz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int dy = rand.nextInt(world.func_189649_b(dx, dz) + 32);
            TFBiomeHighlands.field_180280_ag.func_180709_b(world, rand, new BlockPos(dx, dy, dz));
        }
        for (int i = 0; i < 1; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = rand.nextInt(64);
            this.worldGenMushgloom.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
        for (int i = 0; i < 24; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int ry2 = 64;
            final int rz2 = pos.func_177952_p() + rand.nextInt(16) + 8;
            this.genTrollRoots.func_180709_b(world, rand, new BlockPos(rx, ry2, rz2));
        }
        super.func_180624_a(world, rand, pos);
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_merge") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
            player.func_70097_a(DamageSource.field_76376_m, 0.5f);
            world.func_184148_a((EntityPlayer)null, player.field_70165_t, player.field_70163_u, player.field_70161_v, SoundEvents.field_187541_bC, SoundCategory.PLAYERS, 1.0f, 1.0f);
            this.trySpawnHintMonster(player, world);
        }
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.TROLL_CAVE;
    }
}
