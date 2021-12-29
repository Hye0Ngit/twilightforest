import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class TFBiomeBase extends km
{
    protected we bigMushroomGen;
    public static final km tfOcean;
    public static final km twilightForest;
    public static final km highlands;
    public static final km mushrooms;
    public static final km swamp;
    public static final km stream;
    public static final km snow;
    public static final km glacier;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new we();
        this.H.clear();
        this.J.clear();
        this.I.clear();
        this.I.add(new bq((Class)EntityTFBighorn.class, 12, 4, 4));
        this.I.add(new bq((Class)EntityTFBoar.class, 10, 4, 4));
        this.I.add(new bq((Class)xh.class, 10, 4, 4));
        this.I.add(new bq((Class)EntityTFDeer.class, 15, 4, 4));
        this.I.add(new bq((Class)hc.class, 5, 4, 4));
        this.G.z = 10;
        this.G.B = 2;
    }
    
    protected gx a() {
        return new TFBiomeDecorator(this);
    }
    
    public pg a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (pg)this.N;
        }
        if (random.nextInt(10) == 0) {
            return (pg)this.M;
        }
        return (pg)this.L;
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
