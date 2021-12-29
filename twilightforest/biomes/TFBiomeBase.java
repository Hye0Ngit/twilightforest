// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.world.ColorizerFoliage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.FMLLog;
import twilightforest.TwilightForestMod;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;
import net.minecraft.world.biome.BiomeDecorator;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import net.minecraft.entity.passive.EntityWolf;
import twilightforest.entity.passive.EntityTFDeer;
import net.minecraft.entity.passive.EntityChicken;
import twilightforest.entity.passive.EntityTFBoar;
import net.minecraft.world.biome.SpawnListEntry;
import twilightforest.entity.passive.EntityTFBighorn;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class TFBiomeBase extends BiomeGenBase
{
    public static final BiomeGenBase tfLake;
    public static final BiomeGenBase twilightForest;
    public static final BiomeGenBase twilightForest2;
    public static final BiomeGenBase highlands;
    public static final BiomeGenBase mushrooms;
    public static final BiomeGenBase swamp;
    public static final BiomeGenBase stream;
    public static final BiomeGenBase snow;
    public static final BiomeGenBase glacier;
    public static final BiomeGenBase clearing;
    public static final BiomeGenBase clearingBorder;
    public static final BiomeGenBase lakeBorder;
    public static final BiomeGenBase deepMushrooms;
    public static final BiomeGenBase majorFeature;
    public static final BiomeGenBase minorFeature;
    public static final BiomeGenBase darkForest;
    public static final BiomeGenBase enchantedForest;
    public static final BiomeGenBase fireSwamp;
    protected WorldGenBigMushroom bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.field_76758_O = null;
        this.field_76761_J.clear();
        this.field_76755_L.clear();
        this.field_76762_K.clear();
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFBighorn.class, 12, 4, 4));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFBoar.class, 10, 4, 4));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityChicken.class, 10, 4, 4));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFDeer.class, 15, 4, 5));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityWolf.class, 5, 4, 4));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFBunny.class, 10, 4, 5));
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFRaven.class, 10, 1, 2));
        this.field_82914_M.add(new SpawnListEntry((Class)EntityTFMobileFirefly.class, 10, 8, 8));
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
        return new TFBiomeDecorator(this);
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.field_76760_I;
    }
    
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenerator)this.field_76764_P;
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenerator)new WorldGenBigTree(false);
        }
        return (WorldGenerator)this.field_76757_N;
    }
    
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2);
        }
        return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }
    
    public static boolean isFeature(final int idToCheck) {
        return idToCheck == TFBiomeBase.majorFeature.field_76756_M || idToCheck == TFBiomeBase.minorFeature.field_76756_M;
    }
    
    public static boolean checkForBiomeConflicts() {
        boolean noConflict = true;
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeLake);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeTwilightForest);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeTwilightForestVariant);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeHighlands);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeMushrooms);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeSwamp);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeStream);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeSnowfield);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeGlacier);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeClearing);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeClearingBorder);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeLakeBorder);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeDeepMushrooms);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeMajorFeature);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeMinorFeature);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeDarkForest);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeEnchantedForest);
        noConflict &= checkBiomeIDisClearOrOurs(TwilightForestMod.idBiomeFireSwamp);
        if (!noConflict) {
            FMLLog.warning("[TwilightForest] Biome ID conflict detected.  Edit the Twilight Forest config to give all biomes unique IDs.", new Object[0]);
        }
        return noConflict;
    }
    
    public static boolean checkBiomeIDisClearOrOurs(final int id) {
        final BiomeGenBase biomeAt = BiomeGenBase.field_76773_a[id];
        if (biomeAt == null || biomeAt instanceof TFBiomeBase) {
            return true;
        }
        FMLLog.warning("[TwilightForest] Biome ID conflict.  Biome ID %d contains a biome named %s, but Twilight Forest is set to use that ID.", new Object[] { id, biomeAt.field_76791_y });
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_76737_k() {
        final double d0 = MathHelper.func_76131_a(this.func_76743_j(), 0.0f, 1.0f);
        final double d2 = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ColorizerGrass.func_77480_a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_76726_l() {
        final double d0 = MathHelper.func_76131_a(this.func_76743_j(), 0.0f, 1.0f);
        final double d2 = MathHelper.func_76131_a(this.func_76727_i(), 0.0f, 1.0f);
        return ColorizerFoliage.func_77470_a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int getWaterColorMultiplier() {
        return this.field_76759_H;
    }
    
    static {
        checkForBiomeConflicts();
        tfLake = new TFBiomeTwilightLake(TwilightForestMod.idBiomeLake).setColor(255).func_76735_a("Twilight Lake");
        twilightForest = new TFBiomeTwilightForest(TwilightForestMod.idBiomeTwilightForest).setColor(21760).func_76735_a("Twilight Forest");
        twilightForest2 = new TFBiomeTwilightForestVariant(TwilightForestMod.idBiomeTwilightForestVariant).setColor(21794).func_76735_a("Dense Twilight Forest");
        highlands = new TFBiomeHighlands(TwilightForestMod.idBiomeHighlands).setColor(5596740).func_76735_a("Highlands");
        mushrooms = new TFBiomeMushrooms(TwilightForestMod.idBiomeMushrooms).setColor(4482594).func_76735_a("Mushrooms");
        swamp = new TFBiomeSwamp(TwilightForestMod.idBiomeSwamp).setColor(3359778).func_76735_a("Twilight Swamp");
        stream = new TFBiomeStream(TwilightForestMod.idBiomeStream).setColor(3298231).func_76735_a("Twilight Stream");
        snow = new TFBiomeSnow(TwilightForestMod.idBiomeSnowfield).setColor(13434879).func_76735_a("Snowy Forest");
        glacier = new TFBiomeGlacier(TwilightForestMod.idBiomeGlacier).setColor(7829435).func_76735_a("Glacier");
        clearing = new TFBiomeClearing(TwilightForestMod.idBiomeClearing).setColor(3447604).func_76735_a("Twilight Clearing");
        clearingBorder = new TFBiomeTwilightForest(TwilightForestMod.idBiomeClearingBorder).setColor(26112).func_76735_a("Clearing Border");
        lakeBorder = new TFBiomeTwilightForest(TwilightForestMod.idBiomeLakeBorder).setColor(26163).func_76735_a("Lake Border");
        deepMushrooms = new TFBiomeDeepMushrooms(TwilightForestMod.idBiomeDeepMushrooms).setColor(6697762).func_76735_a("Lots of Mushrooms");
        majorFeature = new TFBiomeCenter(TwilightForestMod.idBiomeMajorFeature).setColor(16711680).func_76735_a("Major Feature");
        minorFeature = new TFBiomeCenter2(TwilightForestMod.idBiomeMinorFeature).setColor(11184640).func_76735_a("Minor Feature");
        darkForest = new TFBiomeDarkForest(TwilightForestMod.idBiomeDarkForest).setColor(13073).func_76735_a("Dark Forest");
        enchantedForest = new TFBiomeEnchantedForest(TwilightForestMod.idBiomeEnchantedForest).setColor(1135974).func_76735_a("Enchanted Forest");
        fireSwamp = new TFBiomeFireSwamp(TwilightForestMod.idBiomeFireSwamp).setColor(4334362).func_76735_a("Fire Swamp");
    }
}
