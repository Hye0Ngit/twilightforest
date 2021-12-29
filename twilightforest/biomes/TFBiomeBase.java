// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TwilightForestMod;
import java.util.Random;
import twilightforest.entity.EntityTFMobileFirefly;
import twilightforest.entity.EntityTFRaven;
import twilightforest.entity.EntityTFBunny;
import twilightforest.entity.EntityTFSquirrel;
import twilightforest.entity.EntityTFTinyBird;
import twilightforest.entity.EntityTFDeer;
import twilightforest.entity.EntityTFBoar;
import twilightforest.entity.EntityTFBighorn;

public abstract class TFBiomeBase extends yy
{
    public static final yy tfLake;
    public static final yy twilightForest;
    public static final yy twilightForest2;
    public static final yy highlands;
    public static final yy mushrooms;
    public static final yy swamp;
    public static final yy stream;
    public static final yy snow;
    public static final yy glacier;
    public static final yy clearing;
    public static final yy clearingBorder;
    public static final yy lakeBorder;
    public static final yy deepMushrooms;
    public static final yy majorFeature;
    public static final yy minorFeature;
    public static final yy darkForest;
    public static final yy enchantedForest;
    public static final yy fireSwamp;
    protected abt bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new abt();
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new yz((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new yz((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new yz((Class)oy.class, 10, 4, 4));
        this.K.add(new yz((Class)EntityTFDeer.class, 15, 4, 5));
        this.K.add(new yz((Class)pk.class, 5, 4, 4));
        this.K.add(new yz((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.K.add(new yz((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.K.add(new yz((Class)EntityTFBunny.class, 10, 4, 5));
        this.K.add(new yz((Class)EntityTFRaven.class, 10, 1, 2));
        this.M.add(new yz((Class)EntityTFMobileFirefly.class, 10, 8, 8));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    public TFBiomeBase setColor(final int par1) {
        return (TFBiomeBase)super.b(par1);
    }
    
    public float f() {
        return 0.12f;
    }
    
    public zc a() {
        return new TFBiomeDecorator(this);
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.I;
    }
    
    public abm a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (abm)this.Q;
        }
        if (random.nextInt(10) == 0) {
            return (abm)this.P;
        }
        return (abm)this.O;
    }
    
    public abm b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (abm)new ach(amq.aa.cm, 2);
        }
        return (abm)new ach(amq.aa.cm, 1);
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
