// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.client.renderer.TFSkyRenderer;
import net.minecraftforge.client.IRenderHandler;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import javax.annotation.Nullable;
import twilightforest.client.TFClientProxy;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.TFConfig;
import net.minecraft.world.WorldProviderSurface;

public class WorldProviderTwilightForest extends WorldProviderSurface
{
    private static final String SEED_KEY = "CustomSeed";
    private static final String SKYLIGHT_KEY = "HasSkylight";
    private static volatile boolean skylightEnabled;
    private long seed;
    
    public static void syncFromConfig() {
        WorldProviderTwilightForest.skylightEnabled = TFConfig.performance.enableSkylight;
    }
    
    public static void setSkylightEnabled(final boolean enabled) {
        WorldProviderTwilightForest.skylightEnabled = enabled;
    }
    
    public static boolean isSkylightEnabled(final NBTTagCompound data) {
        return data.func_150297_b("HasSkylight", 1) ? data.func_74767_n("HasSkylight") : WorldProviderTwilightForest.skylightEnabled;
    }
    
    public WorldProviderTwilightForest() {
        this.setDimension(TFConfig.dimension.dimensionID);
    }
    
    @Nullable
    @SideOnly(Side.CLIENT)
    public MusicTicker.MusicType getMusicType() {
        return TFClientProxy.TFMUSICTYPE;
    }
    
    public float[] func_76560_a(final float celestialAngle, final float f1) {
        return null;
    }
    
    public Vec3d func_76562_b(final float f, final float f1) {
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
        return new Vec3d((double)red, (double)green, (double)blue);
    }
    
    public float func_76563_a(final long worldTime, final float partialTicks) {
        return 0.225f;
    }
    
    public void func_76572_b() {
        final NBTTagCompound data = TFWorld.getDimensionData(this.field_76579_a);
        this.seed = (data.func_150297_b("CustomSeed", 4) ? data.func_74763_f("CustomSeed") : this.loadSeed());
        this.field_191067_f = isSkylightEnabled(data);
        this.field_76578_c = new TFBiomeProvider(this.field_76579_a);
    }
    
    protected void func_76556_a() {
        final float f = this.field_191067_f ? 0.0f : 0.1f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.field_76573_f[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }
    
    public IChunkGenerator func_186060_c() {
        return (IChunkGenerator)(TFConfig.dimension.skylightForest ? new ChunkGeneratorTwilightVoid(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r()) : new ChunkGeneratorTwilightForest(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r()));
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_76561_g() {
        return false;
    }
    
    public int func_76557_i() {
        return 30;
    }
    
    public double func_76565_k() {
        return super.func_76565_k() * 2.0;
    }
    
    public boolean func_76567_e() {
        return this.field_76579_a.func_72912_H().func_76070_v();
    }
    
    public DimensionType func_186058_p() {
        return TwilightForestMod.dimType;
    }
    
    public boolean isDaytime() {
        return false;
    }
    
    public boolean shouldMapSpin(final String entityName, final double x, final double z, final double rotation) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3d getSkyColor(final Entity cameraEntity, final float partialTicks) {
        return new Vec3d(0.125, 0.1328125, 0.2890625);
    }
    
    public void getLightmapColors(final float partialTicks, final float sunBrightness, final float skyLight, final float blockLight, final float[] colors) {
        final float r = 0.2509804f;
        final float g = 0.33333334f;
        final float b = 0.28235295f;
        if (!this.field_191067_f) {
            colors[0] = 0.2509804f + blockLight * 0.7490196f;
            colors[1] = 0.33333334f + blockLight * 0.6666666f;
            colors[2] = 0.28235295f + blockLight * 0.7176471f;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(final float partialTicks) {
        return 1.0f;
    }
    
    public double getHorizon() {
        return 31.0;
    }
    
    public Biome getBiomeForCoords(final BlockPos pos) {
        Biome biome = super.getBiomeForCoords(pos);
        if (biome == null) {
            biome = TFBiomes.twilightForest;
        }
        return biome;
    }
    
    public long getSeed() {
        return (this.seed == 0L) ? super.getSeed() : this.seed;
    }
    
    private long loadSeed() {
        final String seed = TFConfig.dimension.twilightForestSeed;
        if (seed != null && !seed.isEmpty()) {
            try {
                return Long.parseLong(seed);
            }
            catch (NumberFormatException e) {
                return seed.hashCode();
            }
        }
        return 0L;
    }
    
    public void func_186057_q() {
        final NBTTagCompound data = new NBTTagCompound();
        data.func_74772_a("CustomSeed", this.seed);
        TFWorld.setDimensionData(this.field_76579_a, data);
    }
    
    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer() {
        if (super.getSkyRenderer() == null) {
            this.setSkyRenderer((IRenderHandler)new TFSkyRenderer());
        }
        return super.getSkyRenderer();
    }
    
    @SideOnly(Side.CLIENT)
    public IRenderHandler getWeatherRenderer() {
        if (super.getWeatherRenderer() == null) {
            this.setWeatherRenderer((IRenderHandler)new TFWeatherRenderer());
        }
        return super.getWeatherRenderer();
    }
    
    public float func_76571_f() {
        return TFConfig.dimension.skylightForest ? -1.0f : 161.0f;
    }
    
    static {
        WorldProviderTwilightForest.skylightEnabled = true;
    }
}
