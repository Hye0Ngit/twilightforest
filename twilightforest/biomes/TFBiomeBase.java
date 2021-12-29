// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.ColorizerFoliage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.FMLLog;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.entity.EntityTFKobold;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySpider;
import java.util.ArrayList;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import net.minecraft.entity.passive.EntityWolf;
import twilightforest.entity.passive.EntityTFDeer;
import net.minecraft.entity.passive.EntityChicken;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.entity.passive.EntityTFBighorn;
import java.util.List;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class TFBiomeBase extends BiomeGenBase
{
    public static final BiomeGenBase tfLake;
    public static final BiomeGenBase twilightForest;
    public static final BiomeGenBase twilightForest2;
    public static final BiomeGenBase highlands;
    public static final BiomeGenBase mushrooms;
    public static final BiomeGenBase tfSwamp;
    public static final BiomeGenBase stream;
    public static final BiomeGenBase tfSnow;
    public static final BiomeGenBase glacier;
    public static final BiomeGenBase clearing;
    public static final BiomeGenBase oakSavanna;
    public static final BiomeGenBase lightedForest;
    public static final BiomeGenBase deepMushrooms;
    public static final BiomeGenBase darkForest;
    public static final BiomeGenBase enchantedForest;
    public static final BiomeGenBase fireSwamp;
    public static final BiomeGenBase darkForestCenter;
    public static final BiomeGenBase highlandsCenter;
    public static final BiomeGenBase thornlands;
    protected WorldGenBigMushroom bigMushroomGen;
    protected WorldGenForest birchGen;
    protected List<BiomeGenBase.SpawnListEntry> undergroundMonsterList;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.birchGen = new WorldGenForest(false, false);
        this.field_76758_O = null;
        this.field_76761_J.clear();
        this.field_76755_L.clear();
        this.field_76762_K.clear();
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFBighorn.class, 12, 4, 4));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFBoar.class, 10, 4, 4));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityChicken.class, 10, 4, 4));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFDeer.class, 15, 4, 5));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityWolf.class, 5, 4, 4));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFBunny.class, 10, 4, 5));
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFRaven.class, 10, 1, 2));
        (this.undergroundMonsterList = new ArrayList<BiomeGenBase.SpawnListEntry>()).add(new BiomeGenBase.SpawnListEntry((Class)EntitySpider.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityZombie.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySkeleton.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityCreeper.class, 1, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySlime.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityEnderman.class, 1, 1, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFKobold.class, 10, 4, 8));
        this.field_82914_M.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFMobileFirefly.class, 10, 8, 8));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    public TFBiomeBase setColor(final int par1) {
        return (TFBiomeBase)super.func_76739_b(par1);
    }
    
    public float func_76741_f() {
        return 0.12f;
    }
    
    public BiomeDecorator func_76729_a() {
        return new TFBiomeDecorator();
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.field_76760_I;
    }
    
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenAbstractTree)this.birchGen;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        return (WorldGenAbstractTree)this.field_76757_N;
    }
    
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
        }
        return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
    }
    
    public static boolean assignBlankBiomeIds() {
        final boolean assigned = false;
        final boolean[] usedIDs = new boolean[BiomeGenBase.func_150565_n().length];
        checkUsedIDs(usedIDs);
        TwilightForestMod.idBiomeLake = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeLake);
        TwilightForestMod.idBiomeTwilightForest = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeTwilightForest);
        TwilightForestMod.idBiomeTwilightForestVariant = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeTwilightForestVariant);
        TwilightForestMod.idBiomeHighlands = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeHighlands);
        TwilightForestMod.idBiomeMushrooms = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeMushrooms);
        TwilightForestMod.idBiomeSwamp = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeSwamp);
        TwilightForestMod.idBiomeStream = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeStream);
        TwilightForestMod.idBiomeSnowfield = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeSnowfield);
        TwilightForestMod.idBiomeGlacier = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeGlacier);
        TwilightForestMod.idBiomeClearing = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeClearing);
        TwilightForestMod.idBiomeOakSavanna = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeOakSavanna);
        TwilightForestMod.idBiomeLightedForest = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeLightedForest);
        TwilightForestMod.idBiomeDeepMushrooms = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeDeepMushrooms);
        TwilightForestMod.idBiomeDarkForestCenter = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeDarkForestCenter);
        TwilightForestMod.idBiomeHighlandsCenter = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeHighlandsCenter);
        TwilightForestMod.idBiomeDarkForest = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeDarkForest);
        TwilightForestMod.idBiomeEnchantedForest = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeEnchantedForest);
        TwilightForestMod.idBiomeFireSwamp = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeFireSwamp);
        TwilightForestMod.idBiomeThornlands = assignIdIfNeeded(usedIDs, TwilightForestMod.idBiomeThornlands);
        return assigned;
    }
    
    private static void checkUsedIDs(final boolean[] usedIDs) {
        for (int i = 0; i < usedIDs.length; ++i) {
            usedIDs[i] = (BiomeGenBase.func_150565_n()[i] != null);
        }
    }
    
    private static int assignIdIfNeeded(final boolean[] usedIDs, int biomeID) {
        if (biomeID == -1) {
            biomeID = findNextOpenBiomeId(usedIDs);
            TwilightForestMod.hasAssignedBiomeID = true;
        }
        return biomeID;
    }
    
    private static int findNextOpenBiomeId(final boolean[] usedIDs) {
        for (int i = 0; i < 256; ++i) {
            if (!usedIDs[i]) {
                usedIDs[i] = true;
                return i;
            }
        }
        FMLLog.warning("[TwilightForest] Could not find open biome ID.  Edit the Twilight Forest config to give all biomes unique IDs.", new Object[0]);
        return -1;
    }
    
    public static boolean areThereBiomeIdConflicts() {
        boolean conflict = TwilightForestMod.hasBiomeIdConflicts;
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeLake);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeTwilightForest);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeTwilightForestVariant);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeHighlands);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeMushrooms);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeSwamp);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeStream);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeSnowfield);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeGlacier);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeClearing);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeOakSavanna);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeLightedForest);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeDeepMushrooms);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeDarkForestCenter);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeHighlandsCenter);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeDarkForest);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeEnchantedForest);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeFireSwamp);
        conflict |= isConflictAtBiomeID(TwilightForestMod.idBiomeThornlands);
        if (conflict) {
            FMLLog.warning("[TwilightForest] Biome ID conflict detected.  Edit the Twilight Forest config to give all biomes unique IDs.", new Object[0]);
        }
        TwilightForestMod.hasBiomeIdConflicts |= conflict;
        return conflict;
    }
    
    public static boolean isConflictAtBiomeID(final int id) {
        final BiomeGenBase biomeAt = BiomeGenBase.func_150568_d(id);
        if (biomeAt == null || biomeAt instanceof TFBiomeBase) {
            return false;
        }
        FMLLog.warning("[TwilightForest] Biome ID conflict.  Biome ID %d contains a biome named %s, but Twilight Forest is set to use that ID.", new Object[] { id, biomeAt.field_76791_y });
        return true;
    }
    
    public static void registerWithBiomeDictionary() {
        BiomeDictionary.registerBiomeType(TFBiomeBase.tfLake, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WATER });
        BiomeDictionary.registerBiomeType(TFBiomeBase.twilightForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.twilightForest2, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.highlands, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MOUNTAIN });
        BiomeDictionary.registerBiomeType(TFBiomeBase.mushrooms, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.registerBiomeType(TFBiomeBase.tfSwamp, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SWAMP });
        BiomeDictionary.registerBiomeType(TFBiomeBase.stream, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WATER });
        BiomeDictionary.registerBiomeType(TFBiomeBase.tfSnow, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.FROZEN });
        BiomeDictionary.registerBiomeType(TFBiomeBase.glacier, new BiomeDictionary.Type[] { BiomeDictionary.Type.FROZEN });
        BiomeDictionary.registerBiomeType(TFBiomeBase.clearing, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
        BiomeDictionary.registerBiomeType(TFBiomeBase.oakSavanna, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.lightedForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.deepMushrooms, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.registerBiomeType(TFBiomeBase.darkForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.enchantedForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL });
        BiomeDictionary.registerBiomeType(TFBiomeBase.fireSwamp, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WASTELAND });
    }
    
    @SideOnly(Side.CLIENT)
    public int func_150558_b(final int x, final int y, final int z) {
        final double d0 = MathHelper.func_76131_a(this.func_150564_a(x, y, z), 0.0f, 1.0f);
        final double d2 = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ColorizerGrass.func_77480_a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_150571_c(final int x, final int y, final int z) {
        final double d0 = MathHelper.func_76131_a(this.func_150564_a(x, y, z), 0.0f, 1.0f);
        final double d2 = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ColorizerFoliage.func_77470_a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int getWaterColorMultiplier() {
        return this.field_76759_H;
    }
    
    public void func_150573_a(final World world, final Random rand, final Block[] blockStorage, final byte[] metaStorage, final int x, final int z, final double stoneNoise) {
        this.genTwilightBiomeTerrain(world, rand, blockStorage, metaStorage, x, z, stoneNoise);
    }
    
    public void genTwilightBiomeTerrain(final World world, final Random rand, final Block[] blockStorage, final byte[] metaStorage, final int x, final int z, final double stoneNoise) {
        Block topBlock = this.field_76752_A;
        byte topMeta = (byte)(this.field_150604_aj & 0xFF);
        Block fillerBlock = this.field_76753_B;
        byte fillerMeta = (byte)(this.field_76754_C & 0xFF);
        int currentFillerDepth = -1;
        final int maxFillerDepth = (int)(stoneNoise / 3.0 + 3.0 + rand.nextDouble() * 0.25);
        final int maskX = x & 0xF;
        final int maskZ = z & 0xF;
        final int worldHeight = blockStorage.length / 256;
        final int seaLevel = 32;
        for (int y = 255; y >= 0; --y) {
            final int index = (maskZ * 16 + maskX) * worldHeight + y;
            if (y <= 0 + rand.nextInt(5)) {
                blockStorage[index] = Blocks.field_150357_h;
            }
            else {
                final Block currentBlock = blockStorage[index];
                if (currentBlock != null && currentBlock.func_149688_o() != Material.field_151579_a && currentBlock == Blocks.field_150348_b) {
                    if (this.getStoneReplacementBlock() != null) {
                        blockStorage[index] = this.getStoneReplacementBlock();
                        metaStorage[index] = this.getStoneReplacementMeta();
                    }
                    if (currentFillerDepth == -1) {
                        if (maxFillerDepth <= 0) {
                            topBlock = null;
                            topMeta = 0;
                            fillerBlock = Blocks.field_150348_b;
                            fillerMeta = 0;
                        }
                        else if (y >= seaLevel - 5 && y <= seaLevel) {
                            topBlock = this.field_76752_A;
                            topMeta = (byte)(this.field_150604_aj & 0xFF);
                            fillerBlock = this.field_76753_B;
                            fillerMeta = (byte)(this.field_76754_C & 0xFF);
                        }
                        if (y < seaLevel - 1 && (topBlock == null || topBlock.func_149688_o() == Material.field_151579_a)) {
                            if (this.func_150564_a(x, y, z) < 0.15f) {
                                topBlock = Blocks.field_150432_aD;
                                topMeta = 0;
                            }
                            else {
                                topBlock = Blocks.field_150355_j;
                                topMeta = 0;
                            }
                        }
                        currentFillerDepth = maxFillerDepth;
                        if (y >= seaLevel - 2) {
                            blockStorage[index] = topBlock;
                            metaStorage[index] = topMeta;
                        }
                        else if (y < seaLevel - 8 - maxFillerDepth) {
                            topBlock = null;
                            fillerBlock = Blocks.field_150348_b;
                            fillerMeta = 0;
                            blockStorage[index] = Blocks.field_150351_n;
                        }
                        else {
                            blockStorage[index] = fillerBlock;
                            metaStorage[index] = fillerMeta;
                        }
                    }
                    else if (currentFillerDepth > 0) {
                        --currentFillerDepth;
                        blockStorage[index] = fillerBlock;
                        metaStorage[index] = fillerMeta;
                        if (currentFillerDepth == 0 && fillerBlock == Blocks.field_150354_m) {
                            currentFillerDepth = rand.nextInt(4) + Math.max(0, y - (seaLevel - 1));
                            fillerBlock = Blocks.field_150322_A;
                            fillerMeta = 0;
                        }
                    }
                }
            }
        }
    }
    
    public Block getStoneReplacementBlock() {
        return null;
    }
    
    public byte getStoneReplacementMeta() {
        return 0;
    }
    
    public boolean doesPlayerHaveRequiredAchievement(final EntityPlayer player) {
        if (this.getRequiredAchievement() != null && player instanceof EntityPlayerMP && ((EntityPlayerMP)player).func_147099_x() != null) {
            final StatisticsFile stats = ((EntityPlayerMP)player).func_147099_x();
            return stats.func_77443_a(this.getRequiredAchievement());
        }
        return true;
    }
    
    protected Achievement getRequiredAchievement() {
        return null;
    }
    
    public void enforceProgession(final EntityPlayer player, final World world) {
    }
    
    public List<BiomeGenBase.SpawnListEntry> getUndergroundSpawnableList() {
        return this.undergroundMonsterList;
    }
    
    static {
        assignBlankBiomeIds();
        areThereBiomeIdConflicts();
        tfLake = new TFBiomeTwilightLake(TwilightForestMod.idBiomeLake).setColor(255).func_76735_a("Twilight Lake").func_150570_a(TFBiomeBase.field_150592_d);
        twilightForest = new TFBiomeTwilightForest(TwilightForestMod.idBiomeTwilightForest).setColor(21760).func_76735_a("Twilight Forest");
        twilightForest2 = new TFBiomeTwilightForestVariant(TwilightForestMod.idBiomeTwilightForestVariant).setColor(21794).func_76735_a("Dense Twilight Forest").func_150570_a(TFBiomeBase.field_150590_f);
        highlands = new TFBiomeHighlands(TwilightForestMod.idBiomeHighlands).setColor(5596740).func_76735_a("Highlands").func_150570_a(new BiomeGenBase.Height(3.5f, 0.05f));
        mushrooms = new TFBiomeMushrooms(TwilightForestMod.idBiomeMushrooms).setColor(2254370).func_76735_a("Mushroom Forest");
        tfSwamp = new TFBiomeSwamp(TwilightForestMod.idBiomeSwamp).setColor(3359778).func_76735_a("Twilight Swamp").func_150570_a(new BiomeGenBase.Height(-0.125f, 0.125f));
        stream = new TFBiomeStream(TwilightForestMod.idBiomeStream).setColor(3298231).func_76735_a("Twilight Stream").func_150570_a(TFBiomeBase.field_150594_b);
        tfSnow = new TFBiomeSnow(TwilightForestMod.idBiomeSnowfield).setColor(13434879).func_76735_a("Snowy Forest").func_150570_a(TFBiomeBase.field_150590_f);
        glacier = new TFBiomeGlacier(TwilightForestMod.idBiomeGlacier).setColor(7829435).func_76735_a("Twilight Glacier");
        clearing = new TFBiomeClearing(TwilightForestMod.idBiomeClearing).setColor(3447604).func_76735_a("Twilight Clearing").func_150570_a(TFBiomeBase.field_150593_e);
        oakSavanna = new TFBiomeOakSavanna(TwilightForestMod.idBiomeOakSavanna).setColor(4482594).func_76735_a("Oak Savanna").func_150570_a(TFBiomeBase.field_150590_f);
        lightedForest = new TFBiomeLightedForest(TwilightForestMod.idBiomeLightedForest).setColor(26163).func_76735_a("Lighted Forest").func_150570_a(TFBiomeBase.field_150593_e);
        deepMushrooms = new TFBiomeDeepMushrooms(TwilightForestMod.idBiomeDeepMushrooms).setColor(6697762).func_76735_a("Deep Mushroom Forest").func_150570_a(TFBiomeBase.field_150593_e);
        darkForest = new TFBiomeDarkForest(TwilightForestMod.idBiomeDarkForest).setColor(13073).func_76735_a("Dark Forest").func_150570_a(TFBiomeBase.field_150593_e);
        enchantedForest = new TFBiomeEnchantedForest(TwilightForestMod.idBiomeEnchantedForest).setColor(1135974).func_76735_a("Enchanted Forest");
        fireSwamp = new TFBiomeFireSwamp(TwilightForestMod.idBiomeFireSwamp).setColor(4334362).func_76735_a("Fire Swamp").func_150570_a(TFBiomeBase.field_150596_a);
        darkForestCenter = new TFBiomeDarkForestCenter(TwilightForestMod.idBiomeDarkForestCenter).setColor(8704).func_76735_a("Dark Forest Center").func_150570_a(TFBiomeBase.field_150593_e);
        highlandsCenter = new TFBiomeHighlandsCenter(TwilightForestMod.idBiomeHighlandsCenter).setColor(3359778).func_76735_a("Highlands Center").func_150570_a(new BiomeGenBase.Height(10.5f, 0.025f));
        thornlands = new TFBiomeThornlands(TwilightForestMod.idBiomeThornlands).setColor(2241314).func_76735_a("Thornlands").func_150570_a(new BiomeGenBase.Height(6.0f, 0.1f));
    }
}
