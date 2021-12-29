// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.FMLLog;
import twilightforest.TwilightForestMod;
import java.util.Random;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.passive.EntityTFBoar;
import twilightforest.entity.passive.EntityTFBighorn;

public abstract class TFBiomeBase extends acp
{
    public static final acp tfLake;
    public static final acp twilightForest;
    public static final acp twilightForest2;
    public static final acp highlands;
    public static final acp mushrooms;
    public static final acp swamp;
    public static final acp stream;
    public static final acp snow;
    public static final acp glacier;
    public static final acp clearing;
    public static final acp clearingBorder;
    public static final acp lakeBorder;
    public static final acp deepMushrooms;
    public static final acp majorFeature;
    public static final acp minorFeature;
    public static final acp darkForest;
    public static final acp enchantedForest;
    public static final acp fireSwamp;
    protected afk bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new afk();
        this.P = null;
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new acq((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new acq((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new acq((Class)rp.class, 10, 4, 4));
        this.K.add(new acq((Class)EntityTFDeer.class, 15, 4, 5));
        this.K.add(new acq((Class)se.class, 5, 4, 4));
        this.K.add(new acq((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.K.add(new acq((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.K.add(new acq((Class)EntityTFBunny.class, 10, 4, 5));
        this.K.add(new acq((Class)EntityTFRaven.class, 10, 1, 2));
        this.M.add(new acq((Class)EntityTFMobileFirefly.class, 10, 8, 8));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    public TFBiomeBase setColor(final int par1) {
        return (TFBiomeBase)super.b(par1);
    }
    
    public float f() {
        return 0.12f;
    }
    
    public act a() {
        return new TFBiomeDecorator(this);
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.I;
    }
    
    public afd a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (afd)this.Q;
        }
        if (random.nextInt(10) == 0) {
            return (afd)new aev(false);
        }
        return (afd)this.O;
    }
    
    public afd b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (afd)new afy(aqw.ac.cF, 2);
        }
        return (afd)new afy(aqw.ac.cF, 1);
    }
    
    public static boolean isFeature(final int idToCheck) {
        return idToCheck == TFBiomeBase.majorFeature.N || idToCheck == TFBiomeBase.minorFeature.N;
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
        final acp biomeAt = acp.a[id];
        if (biomeAt == null || biomeAt instanceof TFBiomeBase) {
            return true;
        }
        FMLLog.warning("[TwilightForest] Biome ID conflict.  Biome ID %d contains a biome named %s, but Twilight Forest is set to use that ID.", new Object[] { id, biomeAt.y });
        return false;
    }
    
    public static void registerWithBiomeDictionary() {
        BiomeDictionary.registerBiomeType(TFBiomeBase.tfLake, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WATER });
        BiomeDictionary.registerBiomeType(TFBiomeBase.twilightForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.twilightForest2, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.highlands, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MOUNTAIN });
        BiomeDictionary.registerBiomeType(TFBiomeBase.mushrooms, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.registerBiomeType(TFBiomeBase.swamp, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SWAMP });
        BiomeDictionary.registerBiomeType(TFBiomeBase.stream, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WATER });
        BiomeDictionary.registerBiomeType(TFBiomeBase.snow, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.FROZEN });
        BiomeDictionary.registerBiomeType(TFBiomeBase.glacier, new BiomeDictionary.Type[] { BiomeDictionary.Type.FROZEN });
        BiomeDictionary.registerBiomeType(TFBiomeBase.clearing, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
        BiomeDictionary.registerBiomeType(TFBiomeBase.clearingBorder, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.lakeBorder, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.deepMushrooms, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.registerBiomeType(TFBiomeBase.darkForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
        BiomeDictionary.registerBiomeType(TFBiomeBase.enchantedForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL });
        BiomeDictionary.registerBiomeType(TFBiomeBase.fireSwamp, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WASTELAND });
    }
    
    @SideOnly(Side.CLIENT)
    public int k() {
        final double d0 = lr.a(this.j(), 0.0f, 1.0f);
        final double d2 = lr.a(this.i(), 0.0f, 1.0f);
        return abu.a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int l() {
        final double d0 = lr.a(this.j(), 0.0f, 1.0f);
        final double d2 = lr.a(this.i(), 0.0f, 1.0f);
        return abr.a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int getWaterColorMultiplier() {
        return this.H;
    }
    
    static {
        checkForBiomeConflicts();
        tfLake = new TFBiomeTwilightLake(TwilightForestMod.idBiomeLake).setColor(255).a("Twilight Lake");
        twilightForest = new TFBiomeTwilightForest(TwilightForestMod.idBiomeTwilightForest).setColor(21760).a("Twilight Forest");
        twilightForest2 = new TFBiomeTwilightForestVariant(TwilightForestMod.idBiomeTwilightForestVariant).setColor(21794).a("Dense Twilight Forest");
        highlands = new TFBiomeHighlands(TwilightForestMod.idBiomeHighlands).setColor(5596740).a("Highlands");
        mushrooms = new TFBiomeMushrooms(TwilightForestMod.idBiomeMushrooms).setColor(4482594).a("Mushrooms");
        swamp = new TFBiomeSwamp(TwilightForestMod.idBiomeSwamp).setColor(3359778).a("Twilight Swamp");
        stream = new TFBiomeStream(TwilightForestMod.idBiomeStream).setColor(3298231).a("Twilight Stream");
        snow = new TFBiomeSnow(TwilightForestMod.idBiomeSnowfield).setColor(13434879).a("Snowy Forest");
        glacier = new TFBiomeGlacier(TwilightForestMod.idBiomeGlacier).setColor(7829435).a("Glacier");
        clearing = new TFBiomeClearing(TwilightForestMod.idBiomeClearing).setColor(3447604).a("Twilight Clearing");
        clearingBorder = new TFBiomeTwilightForest(TwilightForestMod.idBiomeClearingBorder).setColor(26112).a("Clearing Border");
        lakeBorder = new TFBiomeTwilightForest(TwilightForestMod.idBiomeLakeBorder).setColor(26163).a("Lake Border");
        deepMushrooms = new TFBiomeDeepMushrooms(TwilightForestMod.idBiomeDeepMushrooms).setColor(6697762).a("Lots of Mushrooms");
        majorFeature = new TFBiomeCenter(TwilightForestMod.idBiomeMajorFeature).setColor(16711680).a("Major Feature");
        minorFeature = new TFBiomeCenter2(TwilightForestMod.idBiomeMinorFeature).setColor(11184640).a("Minor Feature");
        darkForest = new TFBiomeDarkForest(TwilightForestMod.idBiomeDarkForest).setColor(13073).a("Dark Forest");
        enchantedForest = new TFBiomeEnchantedForest(TwilightForestMod.idBiomeEnchantedForest).setColor(1135974).a("Enchanted Forest");
        fireSwamp = new TFBiomeFireSwamp(TwilightForestMod.idBiomeFireSwamp).setColor(4334362).a("Fire Swamp");
    }
}
