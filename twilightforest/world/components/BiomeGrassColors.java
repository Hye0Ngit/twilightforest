// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components;

import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.biome.Biome;
import twilightforest.TwilightForestMod;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import java.util.Random;

public class BiomeGrassColors
{
    private static final Random COLOR_RNG;
    public static final BiomeSpecialEffects.GrassColorModifier ENCHANTED_FOREST;
    public static final BiomeSpecialEffects.GrassColorModifier SWAMP;
    public static final BiomeSpecialEffects.GrassColorModifier DARK_FOREST;
    public static final BiomeSpecialEffects.GrassColorModifier DARK_FOREST_CENTER;
    public static final BiomeSpecialEffects.GrassColorModifier SPOOKY_FOREST;
    
    public static int getEnchantedColor(final int x, final int z) {
        final int cx = 256 * Math.round((x - 8) / 256.0f) + 8;
        final int cz = 256 * Math.round((z - 8) / 256.0f) + 8;
        final int dist = (int)Mth.m_14116_((float)((cx - x) * (cx - x) + (cz - z) * (cz - z)));
        int color = dist * 64;
        color %= 512;
        if (color > 255) {
            color = 511 - color;
        }
        color = 255 - color;
        final int randomFlicker = BiomeGrassColors.COLOR_RNG.nextInt(32) - 16;
        if (0 < color + randomFlicker && color + randomFlicker > 255) {
            color += randomFlicker;
        }
        return color;
    }
    
    public static int blendColors(final int a, final int b, final double ratio) {
        final int mask1 = 16711935;
        final int mask2 = -16711936;
        final int f2 = (int)(256.0 * ratio);
        final int f3 = 256 - f2;
        return ((a & mask1) * f3 + (b & mask1) * f2 >> 8 & mask1) | ((a & mask2) * f3 + (b & mask2) * f2 >> 8 & mask2);
    }
    
    private static BiomeSpecialEffects.GrassColorModifier make(String name, final BiomeSpecialEffects.GrassColorModifier.ColorModifier delegate) {
        name = TwilightForestMod.prefix(name).toString();
        return BiomeSpecialEffects.GrassColorModifier.create(name, name, delegate);
    }
    
    static {
        COLOR_RNG = new Random();
        ENCHANTED_FOREST = make("enchanted_forest", (x, z, color) -> (color & 0xFFFF00) + getEnchantedColor((int)x, (int)z));
        SWAMP = make("swamp", (x, z, color) -> ((GrassColor.m_46415_(0.800000011920929, 0.8999999761581421) & 0xFEFEFE) + 5115470) / 2);
        DARK_FOREST = make("dark_forest", (x, z, color) -> ((GrassColor.m_46415_(0.699999988079071, 0.800000011920929) & 0xFEFEFE) + 1969742) / 2);
        DARK_FOREST_CENTER = make("dark_forest_center", (x, z, color) -> {
            final double d0 = Biome.f_47433_.m_75449_(x * 0.0225, z * 0.0225, false);
            return (d0 < -0.2) ? 6714688 : 5587220;
        });
        SPOOKY_FOREST = make("spooky_forest", (x, z, color) -> {
            final double noise = (Biome.f_47433_.m_75449_(x * 0.0225, z * 0.0225, false) + 1.0) / 2.0;
            return blendColors(12865827, 11650083, (noise > 0.6) ? (noise * 0.1) : noise);
        });
    }
}
