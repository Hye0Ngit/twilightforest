// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.block.TFBlocks;
import twilightforest.TFFeature;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TFAchievementPage;
import net.minecraft.stats.Achievement;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import twilightforest.entity.EntityTFTroll;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import twilightforest.world.TFGenTrollRoots;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTaiga1;

public class TFBiomeHighlands extends TFBiomeBase
{
    private static final WorldGenTaiga1 taigaGen1;
    private static final WorldGenTaiga2 taigaGen2;
    private static final WorldGenMegaPineTree megaPineGen1;
    private static final WorldGenMegaPineTree megaPineGen2;
    private static final WorldGenBlockBlob genBoulder;
    private static final TFGenTrollRoots genTrollRoots;
    private static final WorldGenTallGrass worldGenMushgloom;
    
    public TFBiomeHighlands(final int i) {
        super(i);
        this.field_76750_F = 0.4f;
        this.field_76751_G = 0.7f;
        ((TFBiomeDecorator)this.field_76760_I).canopyPerChunk = -999.0f;
        this.field_76760_I.field_76803_B = 7;
        this.field_76760_I.field_76804_C = 1;
        this.field_76760_I.field_76808_K = false;
        this.undergroundMonsterList.clear();
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySkeleton.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityCreeper.class, 1, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySlime.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFTroll.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenAbstractTree)TFBiomeHighlands.taigaGen1;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)TFBiomeHighlands.taigaGen2;
        }
        if (random.nextInt(3) == 0) {
            return (WorldGenAbstractTree)TFBiomeHighlands.megaPineGen1;
        }
        if (random.nextInt(13) == 0) {
            return (WorldGenAbstractTree)TFBiomeHighlands.megaPineGen2;
        }
        return (WorldGenAbstractTree)this.birchGen;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        return (WorldGenerator)((par1Random.nextInt(5) > 0) ? new WorldGenTallGrass((Block)Blocks.field_150329_H, 2) : new WorldGenTallGrass((Block)Blocks.field_150329_H, 1));
    }
    
    @Override
    public void func_150573_a(final World world, final Random rand, final Block[] blockStorage, final byte[] metaStorage, final int x, final int z, final double noiseVal) {
        this.field_76752_A = (Block)Blocks.field_150349_c;
        this.field_150604_aj = 0;
        this.field_76753_B = Blocks.field_150346_d;
        if (noiseVal > 1.75) {
            this.field_76752_A = Blocks.field_150346_d;
            this.field_150604_aj = 1;
        }
        else if (noiseVal > -0.95) {
            this.field_76752_A = Blocks.field_150346_d;
            this.field_150604_aj = 2;
        }
        this.genTwilightBiomeTerrain(world, rand, blockStorage, metaStorage, x, z, noiseVal);
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int mapX, final int mapZ) {
        for (int maxBoulders = par2Random.nextInt(2), i = 0; i < maxBoulders; ++i) {
            final int dx = mapX + par2Random.nextInt(16) + 8;
            final int dz = mapZ + par2Random.nextInt(16) + 8;
            final int dy = par1World.func_72976_f(dx, dz);
            TFBiomeHighlands.genBoulder.func_76484_a(par1World, par2Random, dx, dy, dz);
        }
        TFBiomeHighlands.field_150610_ae.func_150548_a(3);
        for (int i = 0; i < 7; ++i) {
            final int dx = mapX + par2Random.nextInt(16) + 8;
            final int dz = mapZ + par2Random.nextInt(16) + 8;
            final int dy = par2Random.nextInt(par1World.func_72976_f(dx, dz) + 32);
            TFBiomeHighlands.field_150610_ae.func_76484_a(par1World, par2Random, dx, dy, dz);
        }
        for (int i = 0; i < 1; ++i) {
            final int rx = mapX + par2Random.nextInt(16) + 8;
            final int rz = mapZ + par2Random.nextInt(16) + 8;
            final int ry = par2Random.nextInt(64);
            TFBiomeHighlands.worldGenMushgloom.func_76484_a(par1World, par2Random, rx, ry, rz);
        }
        for (int i = 0; i < 24; ++i) {
            final int rx = mapX + par2Random.nextInt(16) + 8;
            final byte ry2 = 64;
            final int rz2 = mapZ + par2Random.nextInt(16) + 8;
            TFBiomeHighlands.genTrollRoots.func_76484_a(par1World, par2Random, rx, ry2, rz2);
        }
        super.func_76728_a(par1World, par2Random, mapX, mapZ);
    }
    
    public String func_150572_a(final Random rand, final int x, final int y, final int z) {
        return rand.nextBoolean() ? BlockFlower.field_149858_b[0] : BlockFlower.field_149859_a[8];
    }
    
    @Override
    protected Achievement getRequiredAchievement() {
        return TFAchievementPage.twilightProgressGlacier;
    }
    
    @Override
    public void enforceProgession(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && world.func_72820_D() % 5L == 0L) {
            player.func_70097_a(DamageSource.field_76376_m, 0.5f);
            world.func_72956_a((Entity)player, "random.fizz", 1.0f, 1.0f);
            if (world.field_73012_v.nextInt(4) == 0) {
                TFFeature.trollCave.trySpawnHintMonster(world, player);
            }
        }
    }
    
    static {
        taigaGen1 = new WorldGenTaiga1();
        taigaGen2 = new WorldGenTaiga2(false);
        megaPineGen1 = new WorldGenMegaPineTree(false, false);
        megaPineGen2 = new WorldGenMegaPineTree(false, true);
        genBoulder = new WorldGenBlockBlob(Blocks.field_150341_Y, 0);
        genTrollRoots = new TFGenTrollRoots();
        worldGenMushgloom = new WorldGenTallGrass(TFBlocks.plant, 9);
    }
}
