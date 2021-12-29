// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TwilightForestMod;
import java.util.Random;
import twilightforest.EntityTFRaven;
import twilightforest.EntityTFBunny;
import twilightforest.EntityTFSquirrel;
import twilightforest.EntityTFTinyBird;
import twilightforest.EntityTFDeer;
import twilightforest.EntityTFBoar;
import twilightforest.EntityTFBighorn;

public abstract class TFBiomeBase extends yr
{
    public static final yr tfLake;
    public static final yr twilightForest;
    public static final yr twilightForest2;
    public static final yr highlands;
    public static final yr mushrooms;
    public static final yr swamp;
    public static final yr stream;
    public static final yr snow;
    public static final yr glacier;
    public static final yr clearing;
    public static final yr clearingBorder;
    public static final yr lakeBorder;
    public static final yr deepMushrooms;
    public static final yr majorFeature;
    public static final yr minorFeature;
    public static final yr darkForest;
    public static final yr enchantedForest;
    public static final yr fireSwamp;
    protected abm bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new abm();
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new ys((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new ys((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new ys((Class)oy.class, 10, 4, 4));
        this.K.add(new ys((Class)EntityTFDeer.class, 15, 4, 5));
        this.K.add(new ys((Class)pk.class, 5, 4, 4));
        this.K.add(new ys((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.K.add(new ys((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.K.add(new ys((Class)EntityTFBunny.class, 10, 4, 5));
        this.K.add(new ys((Class)EntityTFRaven.class, 10, 1, 2));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    public TFBiomeBase setColor(final int par1) {
        return (TFBiomeBase)super.b(par1);
    }
    
    public float f() {
        return 0.12f;
    }
    
    public yv a() {
        return new TFBiomeDecorator(this);
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.I;
    }
    
    public abf a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (abf)this.Q;
        }
        if (random.nextInt(10) == 0) {
            return (abf)this.P;
        }
        return (abf)this.O;
    }
    
    public abf b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (abf)new aca(amj.aa.cm, 2);
        }
        return (abf)new aca(amj.aa.cm, 1);
    }
    
    public static boolean isFeature(final int idToCheck) {
        return idToCheck == TFBiomeBase.majorFeature.N || idToCheck == TFBiomeBase.minorFeature.N;
    }
    
    static {
        tfLake = new TFBiomeTwilightOcean(TwilightForestMod.idBiomeLake).setColor(255).a("Twilight Lake");
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
