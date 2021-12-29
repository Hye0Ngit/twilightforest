import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class TFBiomeBase extends abi
{
    public static final abi tfLake;
    public static final abi twilightForest;
    public static final abi twilightForest2;
    public static final abi highlands;
    public static final abi mushrooms;
    public static final abi swamp;
    public static final abi stream;
    public static final abi snow;
    public static final abi glacier;
    public static final abi clearing;
    public static final abi clearingBorder;
    public static final abi lakeBorder;
    public static final abi deepMushrooms;
    public static final abi largeFeature;
    protected qi bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new qi();
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new be((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new be((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new be((Class)qz.class, 10, 4, 4));
        this.K.add(new be((Class)EntityTFDeer.class, 15, 4, 4));
        this.K.add(new be((Class)yj.class, 5, 4, 4));
        this.I.z = 10;
        this.I.B = 2;
    }
    
    protected yc a() {
        return new TFBiomeDecorator(this);
    }
    
    public lf a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (lf)this.P;
        }
        if (random.nextInt(10) == 0) {
            return (lf)this.O;
        }
        return (lf)this.N;
    }
    
    public lf b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (lf)new tk(ox.X.bO, 2);
        }
        return (lf)new tk(ox.X.bO, 1);
    }
    
    static {
        tfLake = new TFBiomeTwilightOcean(70).b(255).a("Twilight Lake");
        twilightForest = new TFBiomeTwilightForest(71).b(30464).a("Twilight Forest");
        twilightForest2 = new TFBiomeTwilightForestVariant(72).b(1144638).a("Twilight Forest Varient");
        highlands = new TFBiomeHighlands(73).b(6715238).a("Highlands");
        mushrooms = new TFBiomeMushrooms(74).b(10053171).a("Mushrooms");
        swamp = new TFBiomeSwamp(75).b(10066227).a("Twilight Swamp");
        stream = new TFBiomeStream(76).b(43263).a("Twilight Stream");
        snow = new TFBiomeSnow(77).b(13434879).a("Snowfield");
        glacier = new TFBiomeGlacier(78).b(15658734).a("Glacier");
        clearing = new TFBiomeClearing(79).b(10875813).a("Twilight Clearing");
        clearingBorder = new TFBiomeTwilightForest(80).b(3447604).a("Clearing Border");
        lakeBorder = new TFBiomeTwilightForest(81).b(1144676).a("Lake Border");
        deepMushrooms = new TFBiomeDeepMushrooms(82).b(5841432).a("Lots of Mushrooms");
        largeFeature = new TFBiomeCenter(83).b(16773120).a("Major Feature");
    }
}
