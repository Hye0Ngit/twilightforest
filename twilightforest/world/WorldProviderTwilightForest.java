// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;

public class WorldProviderTwilightForest extends aej
{
    public final String saveFolder;
    
    public WorldProviderTwilightForest() {
        this.setDimension(TwilightForestMod.dimensionID);
        this.saveFolder = "DIM" + TwilightForestMod.dimensionID;
    }
    
    public float[] a(final float celestialAngle, final float f1) {
        return null;
    }
    
    public asz b(final float f, final float f1) {
        float bright = lr.b(1.5707965f) * 2.0f + 0.5f;
        if (bright < 0.0f) {
            bright = 0.0f;
        }
        if (bright > 1.0f) {
            bright = 1.0f;
        }
        float red = 0.7529412f;
        float green = 1.0f;
        float blue = 0.8470588f;
        red *= bright * 0.94f + 0.06f;
        green *= bright * 0.94f + 0.06f;
        blue *= bright * 0.91f + 0.09f;
        return this.b.V().a((double)red, (double)green, (double)blue);
    }
    
    public float a(final long par1, final float par3) {
        return 0.225f;
    }
    
    public void b() {
        this.e = new TFWorldChunkManager(this.b);
        this.i = TwilightForestMod.dimensionID;
    }
    
    public adn c() {
        return (adn)new ChunkProviderTwilightForest(this.b, this.b.H(), this.b.N().s());
    }
    
    public boolean g() {
        return false;
    }
    
    public int i() {
        return 33;
    }
    
    public boolean e() {
        return this.b.N().w();
    }
    
    public String getSaveFolder() {
        return this.saveFolder;
    }
    
    public String getWelcomeMessage() {
        return "Entering the Twilight Forest";
    }
    
    public String getDepartMessage() {
        return "Leaving the Twilight Forest";
    }
    
    public String l() {
        return "Twilight Forest";
    }
    
    public boolean isDaytime() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public asz getSkyColor(final nm cameraEntity, final float partialTicks) {
        return this.b.V().a(0.16796875, 0.1796875, 0.38671875);
    }
    
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(final float par1) {
        return 1.0f;
    }
    
    public double getHorizon() {
        return 32.0;
    }
    
    public acp getBiomeGenForCoords(final int x, final int z) {
        acp biome = super.getBiomeGenForCoords(x, z);
        if (biome == null) {
            biome = TFBiomeBase.twilightForest;
        }
        return biome;
    }
    
    public long getSeed() {
        if (TwilightForestMod.twilightForestSeed == null || TwilightForestMod.twilightForestSeed.length() == 0) {
            return super.getSeed();
        }
        return TwilightForestMod.twilightForestSeed.hashCode();
    }
}
