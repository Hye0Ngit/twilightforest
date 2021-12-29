// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.biomes;

import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.Biome;
import twilightforest.TwilightForestMod;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomeAmbience;
import java.util.Random;

public class BiomeGrassColors
{
    private static final Random COLOR_RNG;
    public static final BiomeAmbience.GrassColorModifier ENCHANTED_FOREST;
    public static final BiomeAmbience.GrassColorModifier SWAMP;
    public static final BiomeAmbience.GrassColorModifier DARK_FOREST;
    public static final BiomeAmbience.GrassColorModifier DARK_FOREST_CENTER;
    
    private static int getEnchantedColor(final int x, final int z) {
        final int cx = 256 * Math.round((x - 8) / 256.0f) + 8;
        final int cz = 256 * Math.round((z - 8) / 256.0f) + 8;
        final int dist = (int)MathHelper.func_76129_c((float)((cx - x) * (cx - x) + (cz - z) * (cz - z)));
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
    
    private static BiomeAmbience.GrassColorModifier make(String name, final BiomeAmbience.GrassColorModifier.ColorModifier delegate) {
        name = TwilightForestMod.prefix(name).toString();
        return BiomeAmbience.GrassColorModifier.create(name, name, delegate);
    }
    
    static {
        COLOR_RNG = new Random();
        ENCHANTED_FOREST = make("enchanted_forest", (x, z, color) -> (color & 0xFFFF00) + getEnchantedColor((int)x, (int)z));
        SWAMP = make("swamp", (x, z, color) -> ((GrassColors.func_77480_a(0.800000011920929, 0.8999999761581421) & 0xFEFEFE) + 5115470) / 2);
        DARK_FOREST = make("dark_forest", (x, z, color) -> ((GrassColors.func_77480_a(0.699999988079071, 0.800000011920929) & 0xFEFEFE) + 1969742) / 2);
        DARK_FOREST_CENTER = make("dark_forest_center", (x, z, color) -> {
            final double d0 = Biome.field_180281_af.func_215464_a(x * 0.0225, z * 0.0225, false);
            return (d0 < -0.2) ? 6714688 : 5587220;
        });
    }
}
