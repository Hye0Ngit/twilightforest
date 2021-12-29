import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class TFBiomeBase extends lt
{
    public static final lt tfLake;
    public static final lt twilightForest;
    public static final lt twilightForest2;
    public static final lt highlands;
    public static final lt mushrooms;
    public static final lt swamp;
    public static final lt stream;
    public static final lt snow;
    public static final lt glacier;
    public static final lt clearing;
    public static final lt clearingBorder;
    public static final lt lakeBorder;
    public static final lt deepMushrooms;
    public static final lt largeFeature;
    public static final lt minorFeature;
    protected yd bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new yd();
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new bw((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new bw((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new bw((Class)zg.class, 10, 4, 4));
        this.K.add(new bw((Class)EntityTFDeer.class, 15, 4, 5));
        this.K.add(new bw((Class)ib.class, 5, 4, 4));
        this.K.add(new bw((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.K.add(new bw((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.K.add(new bw((Class)EntityTFBunny.class, 10, 4, 5));
        this.K.add(new bw((Class)EntityTFRaven.class, 10, 1, 2));
        this.I.z = 10;
        this.I.B = 2;
    }
    
    public float f() {
        return 0.12f;
    }
    
    protected hs a() {
        return new TFBiomeDecorator(this);
    }
    
    public qt a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (qt)this.P;
        }
        if (random.nextInt(10) == 0) {
            return (qt)this.O;
        }
        return (qt)this.N;
    }
    
    public qt func_48410_b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (qt)new az(vz.X.bO, 2);
        }
        return (qt)new az(vz.X.bO, 1);
    }
    
    public static boolean isFeature(final int idToCheck) {
        return idToCheck == TFBiomeBase.largeFeature.M || idToCheck == TFBiomeBase.minorFeature.M;
    }
    
    static {
        tfLake = new TFBiomeTwilightOcean(mod_TwilightForest.idBiomeLake).b(255).a("Twilight Lake");
        twilightForest = new TFBiomeTwilightForest(mod_TwilightForest.idBiomeTwilightForest).b(21760).a("Twilight Forest");
        twilightForest2 = new TFBiomeTwilightForestVariant(mod_TwilightForest.idBiomeTwilightForestVariant).b(21794).a("Twilight Forest Varient");
        highlands = new TFBiomeHighlands(mod_TwilightForest.idBiomeHighlands).b(5596740).a("Highlands");
        mushrooms = new TFBiomeMushrooms(mod_TwilightForest.idBiomeMushrooms).b(4482594).a("Mushrooms");
        swamp = new TFBiomeSwamp(mod_TwilightForest.idBiomeSwamp).b(3359778).a("Twilight Swamp");
        stream = new TFBiomeStream(mod_TwilightForest.idBiomeStream).b(3298231).a("Twilight Stream");
        snow = new TFBiomeSnow(mod_TwilightForest.idBiomeSnowfield).b(13434879).a("Snowfield");
        glacier = new TFBiomeGlacier(mod_TwilightForest.idBiomeGlacier).b(7829435).a("Glacier");
        clearing = new TFBiomeClearing(mod_TwilightForest.idBiomeClearing).b(3447604).a("Twilight Clearing");
        clearingBorder = new TFBiomeTwilightForest(mod_TwilightForest.idBiomeClearingBorder).b(26112).a("Clearing Border");
        lakeBorder = new TFBiomeTwilightForest(mod_TwilightForest.idBiomeLakeBorder).b(26163).a("Lake Border");
        deepMushrooms = new TFBiomeDeepMushrooms(mod_TwilightForest.idBiomeDeepMushrooms).b(6697762).a("Lots of Mushrooms");
        largeFeature = new TFBiomeCenter(mod_TwilightForest.idBiomeMajorFeature).b(16711680).a("Major Feature");
        minorFeature = new TFBiomeCenter(mod_TwilightForest.idBiomeMinorFeature).b(13369344).a("Minor Feature");
    }
}
