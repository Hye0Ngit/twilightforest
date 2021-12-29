// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import cpw.mods.fml.common.FMLLog;
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

public abstract class TFBiomeBase extends aap
{
    public static final aap tfLake;
    public static final aap twilightForest;
    public static final aap twilightForest2;
    public static final aap highlands;
    public static final aap mushrooms;
    public static final aap swamp;
    public static final aap stream;
    public static final aap snow;
    public static final aap glacier;
    public static final aap clearing;
    public static final aap clearingBorder;
    public static final aap lakeBorder;
    public static final aap deepMushrooms;
    public static final aap majorFeature;
    public static final aap minorFeature;
    public static final aap darkForest;
    public static final aap enchantedForest;
    public static final aap fireSwamp;
    protected adk bigMushroomGen;
    
    public TFBiomeBase(final int i) {
        super(i);
        this.bigMushroomGen = new adk();
        this.P = null;
        this.J.clear();
        this.L.clear();
        this.K.clear();
        this.K.add(new aaq((Class)EntityTFBighorn.class, 12, 4, 4));
        this.K.add(new aaq((Class)EntityTFBoar.class, 10, 4, 4));
        this.K.add(new aaq((Class)qc.class, 10, 4, 4));
        this.K.add(new aaq((Class)EntityTFDeer.class, 15, 4, 5));
        this.K.add(new aaq((Class)qo.class, 5, 4, 4));
        this.K.add(new aaq((Class)EntityTFTinyBird.class, 15, 4, 8));
        this.K.add(new aaq((Class)EntityTFSquirrel.class, 10, 2, 4));
        this.K.add(new aaq((Class)EntityTFBunny.class, 10, 4, 5));
        this.K.add(new aaq((Class)EntityTFRaven.class, 10, 1, 2));
        this.M.add(new aaq((Class)EntityTFMobileFirefly.class, 10, 8, 8));
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(2);
    }
    
    public TFBiomeBase setColor(final int par1) {
        return (TFBiomeBase)super.b(par1);
    }
    
    public float f() {
        return 0.12f;
    }
    
    public aat a() {
        return new TFBiomeDecorator(this);
    }
    
    protected TFBiomeDecorator getTFBiomeDecorator() {
        return (TFBiomeDecorator)this.I;
    }
    
    public add a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (add)this.Q;
        }
        if (random.nextInt(10) == 0) {
            return (add)new acv(false);
        }
        return (add)this.O;
    }
    
    public add b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (add)new ady(aou.ab.cz, 2);
        }
        return (add)new ady(aou.ab.cz, 1);
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
        final aap biomeAt = aap.a[id];
        if (biomeAt == null || biomeAt instanceof TFBiomeBase) {
            return true;
        }
        FMLLog.warning("[TwilightForest] Biome ID conflict.  Biome ID %d contains a biome named %s, but Twilight Forest is set to use that ID.", new Object[] { id, biomeAt.y });
        return false;
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
