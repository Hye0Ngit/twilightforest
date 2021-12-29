// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.world.World;
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
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.entity.monster.EntityWitch;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFMistWolf;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.Biome;
import java.util.Random;

public class TFBiomeDarkForest extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    private final Random monsterRNG;
    
    public TFBiomeDarkForest(final Biome.BiomeProperties props) {
        super(props);
        this.monsterRNG = new Random(53439L);
        this.getTFBiomeDecorator().canopyPerChunk = 5.5f;
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(-99);
        this.getTFBiomeDecorator().setFlowersPerChunk(-99);
        this.getTFBiomeDecorator().setMushroomsPerChunk(2);
        this.getTFBiomeDecorator().setDeadBushPerChunk(10);
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityEnderman.class, 1, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityZombie.class, 5, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntitySkeleton.class, 5, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFMistWolf.class, 10, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFSkeletonDruid.class, 10, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFKingSpider.class, 10, 1, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFKobold.class, 10, 4, 8));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityWitch.class, 1, 1, 1));
        this.field_76760_I.field_76808_K = false;
    }
    
    @Override
    public TFBiomeDecorator createBiomeDecorator() {
        return new TFDarkForestBiomeDecorator();
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.JUNGLE), Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.OAK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
        }
        if (random.nextInt(8) == 0) {
            return this.birchGen;
        }
        return (WorldGenAbstractTree)TFBiomeDarkForest.field_76757_N;
    }
    
    public int func_180627_b(final BlockPos pos) {
        final double temperature = MathHelper.func_76131_a(this.func_180626_a(pos), 0.0f, 1.0f);
        final double humidity = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ((ColorizerGrass.func_77480_a(temperature, humidity) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public int func_180625_c(final BlockPos pos) {
        final double temperature = MathHelper.func_76131_a(this.func_180626_a(pos), 0.0f, 1.0f);
        final double humidity = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ((ColorizerFoliage.func_77470_a(temperature, humidity) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public List<Biome.SpawnListEntry> func_76747_a(final EnumCreatureType creatureType) {
        if (creatureType == EnumCreatureType.MONSTER) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.field_76761_J : new ArrayList<Biome.SpawnListEntry>();
        }
        return super.func_76747_a(creatureType);
    }
    
    public boolean func_76736_e() {
        return true;
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
            player.func_70690_d(new PotionEffect(MobEffects.field_76440_q, 100, 0));
            this.trySpawnHintMonster(player, world);
        }
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.KNIGHT_STRONGHOLD;
    }
}
