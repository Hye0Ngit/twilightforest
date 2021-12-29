// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import twilightforest.TwilightForestMod;
import net.minecraft.world.WorldProviderSurface;

public class WorldProviderTwilightForest extends WorldProviderSurface
{
    public final String saveFolder;
    
    public WorldProviderTwilightForest() {
        this.setDimension(TwilightForestMod.dimensionID);
        this.saveFolder = "DIM" + TwilightForestMod.dimensionID;
    }
    
    public float[] func_76560_a(final float celestialAngle, final float f1) {
        return null;
    }
    
    public Vec3 func_76562_b(final float f, final float f1) {
        float bright = MathHelper.func_76134_b(1.5707965f) * 2.0f + 0.5f;
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
        return this.field_76579_a.func_82732_R().func_72345_a((double)red, (double)green, (double)blue);
    }
    
    public float func_76563_a(final long par1, final float par3) {
        return 0.225f;
    }
    
    public void func_76572_b() {
        this.field_76578_c = new TFWorldChunkManager(this.field_76579_a);
        this.field_76574_g = TwilightForestMod.dimensionID;
    }
    
    public IChunkProvider func_76555_c() {
        return (IChunkProvider)new ChunkProviderTwilightForest(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r());
    }
    
    public boolean func_76561_g() {
        return false;
    }
    
    public int func_76557_i() {
        return 33;
    }
    
    public boolean func_76567_e() {
        return this.field_76579_a.func_72912_H().func_76070_v();
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
    
    public String func_80007_l() {
        return "Twilight Forest";
    }
    
    public boolean isDaytime() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(final Entity cameraEntity, final float partialTicks) {
        return this.field_76579_a.func_82732_R().func_72345_a(0.16796875, 0.1796875, 0.38671875);
    }
    
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(final float par1) {
        return 1.0f;
    }
    
    public double getHorizon() {
        return 32.0;
    }
    
    public BiomeGenBase getBiomeGenForCoords(final int x, final int z) {
        BiomeGenBase biome = super.getBiomeGenForCoords(x, z);
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
    
    public void updateWeather() {
        super.updateWeather();
    }
}
