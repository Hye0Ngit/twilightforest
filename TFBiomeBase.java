import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class TFBiomeBase extends sr
{
    protected acp bigMushroomGen;
    public static final sr tfOcean;
    public static final sr twilightForest;
    public static final sr highlands;
    public static final sr mushrooms;
    public static final sr swamp;
    public static final sr stream;
    public static final sr snow;
    public static final sr glacier;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new acp();
        this.C.clear();
        this.E.clear();
        this.D.clear();
        this.D.add(new yx((Class)EntityTFBighorn.class, 12, 4, 4));
        this.D.add(new yx((Class)EntityTFBoar.class, 10, 4, 4));
        this.D.add(new yx((Class)qh.class, 10, 4, 4));
        this.D.add(new yx((Class)EntityTFDeer.class, 15, 4, 4));
        this.D.add(new yx((Class)aik.class, 5, 4, 4));
        this.B.z = 10;
        this.B.B = 2;
    }
    
    protected ql a() {
        return new TFBiomeDecorator(this);
    }
    
    public ig a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (ig)this.I;
        }
        if (random.nextInt(10) == 0) {
            return (ig)this.H;
        }
        return (ig)this.G;
    }
    
    static {
        tfOcean = new TFBiomeTwilightOcean(70).b(255).a("Twilight Ocean");
        twilightForest = new TFBiomeTwilightForest(71).b(30464).a("Twilight Forest");
        highlands = new TFBiomeHighlands(72).b(6710886).a("Highlands");
        mushrooms = new TFBiomeMushrooms(73).b(10053171).a("Mushrooms");
        swamp = new TFBiomeSwamp(74).b(10066227).a("Twilight Swamp");
        stream = new TFBiomeStream(75).b(255).a("Twilight Stream");
        snow = new TFBiomeSnow(76).b(13434879).a("Snowfield");
        glacier = new TFBiomeGlacier(77).b(15658734).a("Glacier");
    }
}
