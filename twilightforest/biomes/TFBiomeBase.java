// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.entity.EnumCreatureType;
import twilightforest.util.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import twilightforest.world.ChunkGeneratorTFBase;
import twilightforest.world.TFWorld;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockSand;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import java.util.Random;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import net.minecraft.entity.passive.EntityBat;
import twilightforest.entity.EntityTFKobold;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySpider;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import net.minecraft.entity.passive.EntityWolf;
import twilightforest.entity.passive.EntityTFDeer;
import net.minecraft.entity.passive.EntityChicken;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.entity.passive.EntityTFBighorn;
import java.util.ArrayList;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import twilightforest.TFFeature;
import net.minecraft.util.ResourceLocation;
import java.util.List;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;

public class TFBiomeBase extends Biome
{
    protected final WorldGenAbstractTree birchGen;
    protected final List<Biome.SpawnListEntry> undergroundMonsterList;
    protected final ResourceLocation[] requiredAdvancements;
    public final TFFeature containedFeature;
    
    public TFBiomeBase(final Biome.BiomeProperties props) {
        super(props);
        this.birchGen = (WorldGenAbstractTree)new WorldGenBirchTree(false, false);
        this.undergroundMonsterList = new ArrayList<Biome.SpawnListEntry>();
        this.requiredAdvancements = this.getRequiredAdvancements();
        this.containedFeature = this.getContainedFeature();
        this.field_76761_J.clear();
        this.field_76755_L.clear();
        this.field_76762_K.clear();
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFBighorn.class, 12, 4, 4));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFBoar.class, 10, 4, 4));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityChicken.class, 10, 4, 4));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFDeer.class, 15, 4, 5));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityWolf.class, 5, 4, 4));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFBunny.class, 10, 4, 5));
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFRaven.class, 10, 1, 2));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntitySpider.class, 10, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntityZombie.class, 10, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntitySkeleton.class, 10, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntityCreeper.class, 1, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntitySlime.class, 10, 4, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntityEnderman.class, 1, 1, 4));
        this.undergroundMonsterList.add(new Biome.SpawnListEntry((Class)EntityTFKobold.class, 10, 4, 8));
        this.field_82914_M.clear();
        this.field_82914_M.add(new Biome.SpawnListEntry((Class)EntityBat.class, 10, 8, 8));
        this.field_82914_M.add(new Biome.SpawnListEntry((Class)EntityTFMobileFirefly.class, 10, 8, 8));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    public float func_76741_f() {
        return 0.12f;
    }
    
    public TFBiomeDecorator createBiomeDecorator() {
        return new TFBiomeDecorator();
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.field_76760_I;
    }
    
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return this.birchGen;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)TFBiomeBase.field_76757_N;
    }
    
    public WorldGenerator func_76730_b(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        }
        return (WorldGenerator)new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public void func_180622_a(final World world, final Random rand, final ChunkPrimer primer, final int x, final int z, final double noiseVal) {
        this.genTwilightBiomeTerrain(world, rand, primer, x, z, noiseVal);
    }
    
    protected void genTwilightBiomeTerrain(final World world, final Random rand, final ChunkPrimer primer, final int x, final int z, final double noiseVal) {
        final int i = 31;
        IBlockState iblockstate = this.field_76752_A;
        IBlockState iblockstate2 = this.field_76753_B;
        final IBlockState stoneReplacement = this.getStoneReplacementState();
        int j = -1;
        final int k = (int)(noiseVal / 3.0 + 3.0 + rand.nextDouble() * 0.25);
        final int l = x & 0xF;
        final int i2 = z & 0xF;
        final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        final boolean generateBedrock = shouldGenerateBedrock(world);
        for (int j2 = 255; j2 >= 0; --j2) {
            if (generateBedrock && j2 <= rand.nextInt(5)) {
                primer.func_177855_a(i2, j2, l, TFBiomeBase.field_185367_c);
            }
            else {
                final IBlockState iblockstate3 = primer.func_177856_a(i2, j2, l);
                if (iblockstate3.func_177230_c() != Blocks.field_150350_a) {
                    if (iblockstate3.func_177230_c() == Blocks.field_150348_b) {
                        if (j == -1) {
                            if (k <= 0) {
                                iblockstate = TFBiomeBase.field_185366_b;
                                iblockstate2 = TFBiomeBase.field_185365_a;
                            }
                            else if (j2 >= i - 4 && j2 <= i + 1) {
                                iblockstate = this.field_76752_A;
                                iblockstate2 = this.field_76753_B;
                            }
                            if (j2 < i && (iblockstate == null || iblockstate.func_177230_c() == Blocks.field_150350_a)) {
                                if (this.func_180626_a((BlockPos)blockpos$mutableblockpos.func_181079_c(x, j2, z)) < 0.15f) {
                                    iblockstate = TFBiomeBase.field_185371_g;
                                }
                                else {
                                    iblockstate = TFBiomeBase.field_185372_h;
                                }
                            }
                            j = k;
                            if (j2 >= i - 1) {
                                primer.func_177855_a(i2, j2, l, iblockstate);
                            }
                            else if (j2 < i - 7 - k) {
                                iblockstate = TFBiomeBase.field_185366_b;
                                iblockstate2 = TFBiomeBase.field_185365_a;
                                primer.func_177855_a(i2, j2, l, TFBiomeBase.field_185368_d);
                            }
                            else {
                                primer.func_177855_a(i2, j2, l, iblockstate2);
                            }
                        }
                        else if (j > 0) {
                            --j;
                            primer.func_177855_a(i2, j2, l, iblockstate2);
                            if (j == 0 && iblockstate2.func_177230_c() == Blocks.field_150354_m) {
                                j = rand.nextInt(4) + Math.max(0, j2 - 63);
                                iblockstate2 = ((iblockstate2.func_177229_b((IProperty)BlockSand.field_176504_a) == BlockSand.EnumType.RED_SAND) ? TFBiomeBase.field_185369_e : TFBiomeBase.field_185370_f);
                            }
                        }
                        else if (stoneReplacement != null) {
                            primer.func_177855_a(i2, j2, l, stoneReplacement);
                        }
                    }
                }
            }
        }
    }
    
    private static boolean shouldGenerateBedrock(final World world) {
        final ChunkGeneratorTFBase generator = TFWorld.getChunkGenerator(world);
        return generator == null || generator.shouldGenerateBedrock();
    }
    
    @Nullable
    public IBlockState getStoneReplacementState() {
        return null;
    }
    
    public boolean doesPlayerHaveRequiredAdvancements(final EntityPlayer player) {
        return PlayerHelper.doesPlayerHaveRequiredAdvancements(player, this.requiredAdvancements);
    }
    
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[0];
    }
    
    public void enforceProgression(final EntityPlayer player, final World world) {
    }
    
    protected void trySpawnHintMonster(final EntityPlayer player, final World world) {
        if (world.field_73012_v.nextInt(4) == 0) {
            this.containedFeature.trySpawnHintMonster(world, player);
        }
    }
    
    protected TFFeature getContainedFeature() {
        return TFFeature.NOTHING;
    }
    
    public List<Biome.SpawnListEntry> getUndergroundSpawnableList(final EnumCreatureType type) {
        return (type == EnumCreatureType.MONSTER) ? this.undergroundMonsterList : this.func_76747_a(type);
    }
}
