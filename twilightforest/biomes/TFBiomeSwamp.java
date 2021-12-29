// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenTallGrass;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityCreeper;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.world.feature.TFGenHugeWaterLily;
import twilightforest.world.feature.TFGenHugeLilyPad;
import twilightforest.world.feature.TFGenVines;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;

public class TFBiomeSwamp extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    private final Random monsterRNG;
    private final WorldGenerator vinesGen;
    private final WorldGenerator hugeLilyPadGen;
    private final WorldGenerator hugeWaterLilyGen;
    
    public TFBiomeSwamp(final Biome.BiomeProperties props) {
        super(props);
        this.monsterRNG = new Random(53439L);
        this.vinesGen = new TFGenVines();
        this.hugeLilyPadGen = new TFGenHugeLilyPad();
        this.hugeWaterLilyGen = new TFGenHugeWaterLily();
        this.getTFBiomeDecorator().setDeadBushPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(10);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(2);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(20);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.getTFBiomeDecorator().lakesPerChunk = 2;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFMosquitoSwarm.class, 10, 1, 1));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityCreeper.class, 10, 4, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityZombie.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.JUNGLE), Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.OAK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
        }
        return (WorldGenAbstractTree)TFBiomeSwamp.field_76763_Q;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        }
        if (random.nextInt(4) == 0) {
            return new TFGenTallGrass(TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MAYAPPLE));
        }
        return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public void func_180624_a(final World world, final Random random, final BlockPos pos) {
        super.func_180624_a(world, random, pos);
        for (int i = 0; i < 50; ++i) {
            final int x = pos.func_177958_n() + random.nextInt(16) + 8;
            final int y = 159;
            final int z = pos.func_177952_p() + random.nextInt(16) + 8;
            this.vinesGen.func_180709_b(world, random, new BlockPos(x, y, z));
        }
        for (int i = 0; i < 25; ++i) {
            final int x = pos.func_177958_n() + random.nextInt(15) + 8;
            final int y = 31;
            final int z = pos.func_177952_p() + random.nextInt(15) + 8;
            this.hugeLilyPadGen.func_180709_b(world, random, new BlockPos(x, y, z));
        }
        for (int i = 0; i < 2; ++i) {
            final int x = pos.func_177958_n() + random.nextInt(16) + 8;
            final int y = 31;
            final int z = pos.func_177952_p() + random.nextInt(16) + 8;
            this.hugeWaterLilyGen.func_180709_b(world, random, new BlockPos(x, y, z));
        }
    }
    
    public int func_180627_b(final BlockPos pos) {
        final double temperature = MathHelper.func_76131_a(this.func_180626_a(pos), 0.0f, 1.0f);
        final double humidity = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ((ColorizerGrass.func_77480_a(temperature, humidity) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public int func_180625_c(final BlockPos pos) {
        final double temperature = MathHelper.func_76131_a(this.func_180626_a(pos), 0.0f, 1.0f);
        final double humidity = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ((ColorizerFoliage.func_77470_a(temperature, humidity) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public List<Biome.SpawnListEntry> func_76747_a(final EnumCreatureType creatureType) {
        if (creatureType == EnumCreatureType.MONSTER) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.field_76761_J : new ArrayList<Biome.SpawnListEntry>();
        }
        return super.func_76747_a(creatureType);
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
            final PotionEffect currentHunger = player.func_70660_b(MobEffects.field_76438_s);
            final int hungerLevel = (currentHunger != null) ? (currentHunger.func_76458_c() + 1) : 1;
            player.func_70690_d(new PotionEffect(MobEffects.field_76438_s, 100, hungerLevel));
            this.trySpawnHintMonster(player, world);
        }
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.LABYRINTH;
    }
}
