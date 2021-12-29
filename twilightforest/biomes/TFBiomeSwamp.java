// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TFAchievementPage;
import net.minecraft.stats.Achievement;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.util.MathHelper;
import twilightforest.world.TFWorld;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityCreeper;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.world.TFGenHugeLilyPad;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.ArrayList;
import java.util.Random;

public class TFBiomeSwamp extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    Random monsterRNG;
    ArrayList<BiomeGenBase.SpawnListEntry> emptyList;
    WorldGenVines worldgenvines;
    WorldGenerator hugeLilyPadGen;
    WorldGenerator hugeWaterLilyGen;
    
    public TFBiomeSwamp(final int i) {
        super(i);
        this.monsterRNG = new Random(53439L);
        this.emptyList = new ArrayList<BiomeGenBase.SpawnListEntry>();
        this.worldgenvines = new WorldGenVines();
        this.hugeLilyPadGen = new TFGenHugeLilyPad();
        this.hugeWaterLilyGen = new TFGenHugeWaterLily();
        this.field_76750_F = 0.8f;
        this.field_76751_G = 0.9f;
        this.getTFBiomeDecorator().setDeadBushPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(10);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(2);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(20);
        this.field_76759_H = 14745518;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().lakesPerChunk = 2;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFMosquitoSwarm.class, 10, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityCreeper.class, 10, 4, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityZombie.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(3, 0);
        }
        return (WorldGenAbstractTree)this.field_76763_Q;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
        }
        if (par1Random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant, 4);
        }
        return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        super.func_76728_a(par1World, par2Random, par3, par4);
        for (int i = 0; i < 50; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            this.worldgenvines.func_76484_a(par1World, par2Random, j, (int)byte0, k);
        }
        for (int i = 0; i < 25; ++i) {
            final int x = par3 + par2Random.nextInt(16) + 8;
            final int y = TFWorld.SEALEVEL;
            final int z = par4 + par2Random.nextInt(16) + 8;
            this.hugeLilyPadGen.func_76484_a(par1World, par2Random, x, y, z);
        }
        for (int i = 0; i < 2; ++i) {
            final int x = par3 + par2Random.nextInt(16) + 8;
            final int y = TFWorld.SEALEVEL;
            final int z = par4 + par2Random.nextInt(16) + 8;
            this.hugeWaterLilyGen.func_76484_a(par1World, par2Random, x, y, z);
        }
    }
    
    public int func_150558_b(final int x, final int y, final int z) {
        final double var1 = MathHelper.func_76131_a(this.func_150564_a(x, y, z), 0.0f, 1.0f);
        final double var2 = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ((ColorizerGrass.func_77480_a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public int func_150571_c(final int x, final int y, final int z) {
        final double var1 = MathHelper.func_76131_a(this.func_150564_a(x, y, z), 0.0f, 1.0f);
        final double var2 = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ((ColorizerFoliage.func_77470_a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public List func_76747_a(final EnumCreatureType par1EnumCreatureType) {
        if (par1EnumCreatureType == EnumCreatureType.monster) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.field_76761_J : this.emptyList;
        }
        return (par1EnumCreatureType == EnumCreatureType.creature) ? this.field_76762_K : ((par1EnumCreatureType == EnumCreatureType.waterCreature) ? this.field_76755_L : ((par1EnumCreatureType == EnumCreatureType.ambient) ? this.field_82914_M : null));
    }
    
    @Override
    protected Achievement getRequiredAchievement() {
        return TFAchievementPage.twilightProgressLich;
    }
    
    @Override
    public void enforceProgession(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && world.func_72820_D() % 60L == 0L) {
            final PotionEffect currentHunger = player.func_70660_b(Potion.field_76438_s);
            final int hungerLevel = (currentHunger != null) ? (currentHunger.func_76458_c() + 1) : 1;
            player.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 100, hungerLevel));
            if (world.field_73012_v.nextInt(4) == 0) {
                TFFeature.labyrinth.trySpawnHintMonster(world, player);
            }
        }
    }
}
