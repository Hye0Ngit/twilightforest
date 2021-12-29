// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public abstract class TFBiomeBase extends abn
{
    public static final abn tfLake;
    public static final abn twilightForest;
    public static final abn twilightForest2;
    public static final abn highlands;
    public static final abn mushrooms;
    public static final abn swamp;
    public static final abn stream;
    public static final abn snow;
    public static final abn glacier;
    public static final abn clearing;
    public static final abn clearingBorder;
    public static final abn lakeBorder;
    public static final abn deepMushrooms;
    public static final abn largeFeature;
    public static final abn minorFeature;
    public static final abn darkForest;
    public static final abn enchantedForest;
    public static final abn ruins;
    protected qm bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new qm();
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new bg((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new bg((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new bg((Class)rd.class, 10, 4, 4));
        this.K.add(new bg((Class)EntityTFDeer.class, 15, 4, 5));
        this.K.add(new bg((Class)yo.class, 5, 4, 4));
        this.K.add(new bg((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.K.add(new bg((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.K.add(new bg((Class)EntityTFBunny.class, 10, 4, 5));
        this.K.add(new bg((Class)EntityTFRaven.class, 10, 1, 2));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    protected TFBiomeBase setColor(final int par1) {
        return (TFBiomeBase)super.b(par1);
    }
    
    public float f() {
        return 0.12f;
    }
    
    protected yg a() {
        return new TFBiomeDecorator(this);
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.I;
    }
    
    public li a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (li)this.P;
        }
        if (random.nextInt(10) == 0) {
            return (li)this.O;
        }
        return (li)this.N;
    }
    
    public li b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (li)new to(pb.X.bO, 2);
        }
        return (li)new to(pb.X.bO, 1);
    }
    
    public static boolean isFeature(final int idToCheck) {
        return idToCheck == TFBiomeBase.largeFeature.M || idToCheck == TFBiomeBase.minorFeature.M;
    }
    
    static {
        tfLake = new TFBiomeTwilightOcean(mod_TwilightForest.idBiomeLake).setColor(255).a("Twilight Lake");
        twilightForest = new TFBiomeTwilightForest(mod_TwilightForest.idBiomeTwilightForest).setColor(21760).a("Twilight Forest");
        twilightForest2 = new TFBiomeTwilightForestVariant(mod_TwilightForest.idBiomeTwilightForestVariant).setColor(21794).a("Dense Twilight Forest");
        highlands = new TFBiomeHighlands(mod_TwilightForest.idBiomeHighlands).setColor(5596740).a("Highlands");
        mushrooms = new TFBiomeMushrooms(mod_TwilightForest.idBiomeMushrooms).setColor(4482594).a("Mushrooms");
        swamp = new TFBiomeSwamp(mod_TwilightForest.idBiomeSwamp).setColor(3359778).a("Twilight Swamp");
        stream = new TFBiomeStream(mod_TwilightForest.idBiomeStream).setColor(3298231).a("Twilight Stream");
        snow = new TFBiomeSnow(mod_TwilightForest.idBiomeSnowfield).setColor(13434879).a("Snowfield");
        glacier = new TFBiomeGlacier(mod_TwilightForest.idBiomeGlacier).setColor(7829435).a("Glacier");
        clearing = new TFBiomeClearing(mod_TwilightForest.idBiomeClearing).setColor(3447604).a("Twilight Clearing");
        clearingBorder = new TFBiomeTwilightForest(mod_TwilightForest.idBiomeClearingBorder).setColor(26112).a("Clearing Border");
        lakeBorder = new TFBiomeTwilightForest(mod_TwilightForest.idBiomeLakeBorder).setColor(26163).a("Lake Border");
        deepMushrooms = new TFBiomeDeepMushrooms(mod_TwilightForest.idBiomeDeepMushrooms).setColor(6697762).a("Lots of Mushrooms");
        largeFeature = new TFBiomeCenter(mod_TwilightForest.idBiomeMajorFeature).setColor(16711680).a("Major Feature");
        minorFeature = new TFBiomeCenter2(mod_TwilightForest.idBiomeMinorFeature).setColor(13369344).a("Minor Feature");
        darkForest = new TFBiomeDarkForest(mod_TwilightForest.idBiomeDarkForest).setColor(13073).a("Dark Forest");
        enchantedForest = new TFBiomeEnchantedForest(mod_TwilightForest.idBiomeEnchantedForest).setColor(1135974).a("Enchanted Forest");
        ruins = new TFBiomeEnchantedForest(mod_TwilightForest.idBiomeRuins).setColor(2241314).a("Ruins");
    }
}
