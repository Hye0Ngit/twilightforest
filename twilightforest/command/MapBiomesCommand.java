// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import java.nio.file.Path;
import java.util.Map;
import java.io.IOException;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.nio.file.Paths;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import twilightforest.item.MagicMapItem;
import java.awt.image.BufferedImage;
import net.minecraftforge.fml.loading.FMLEnvironment;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.awt.Color;
import net.minecraft.world.biome.Biome;
import java.util.HashMap;
import java.text.DecimalFormat;

public class MapBiomesCommand
{
    private static final DecimalFormat numberFormat;
    private static final HashMap<Biome, Color> BIOME2COLOR;
    
    private static void init() {
        if (!MapBiomesCommand.BIOME2COLOR.isEmpty()) {
            return;
        }
    }
    
    public static LiteralArgumentBuilder<CommandSource> register() {
        return (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)Commands.func_197057_a("biomepng").requires(cs -> cs.func_197034_c(2))).executes(MapBiomesCommand::execute);
    }
    
    private static int execute(final CommandContext<CommandSource> source) {
        if (FMLEnvironment.dist.isDedicatedServer()) {
            return -1;
        }
        init();
        final Map<Biome, Integer> biomeCount = new HashMap<Biome, Integer>();
        final BufferedImage img = new BufferedImage(4096, 4096, 1);
        final int progressUpdate = img.getHeight() / 8;
        for (int x = 0; x < img.getHeight(); ++x) {
            for (int z = 0; z < img.getWidth(); ++z) {
                final Biome b = ((CommandSource)source.getSource()).func_197023_e().func_225526_b_(x - 2048, 0, z - 2048);
                Color color = MapBiomesCommand.BIOME2COLOR.get(b);
                if (color == null) {
                    int colorInt = MagicMapItem.getBiomeColor(b);
                    if (colorInt == 0) {
                        colorInt = b.func_225528_a_(0.0, 0.0);
                    }
                    MapBiomesCommand.BIOME2COLOR.put(b, color = new Color(colorInt | 0xFF000000));
                }
                if (!biomeCount.containsKey(b)) {
                    biomeCount.put(b, 0);
                }
                else {
                    biomeCount.put(b, biomeCount.get(b) + 1);
                }
                img.setRGB(x, z, color.getRGB());
            }
            if (x % progressUpdate == 0) {
                ((CommandSource)source.getSource()).func_197030_a((ITextComponent)new TranslationTextComponent(x / (double)img.getHeight() * 100.0 + "% Done mapping"), true);
            }
        }
        ((CommandSource)source.getSource()).func_197030_a((ITextComponent)new StringTextComponent("Approximate biome-block counts within an 2048x2048 region"), true);
        final int totalCount = biomeCount.values().stream().mapToInt(i -> i).sum();
        biomeCount.forEach((biome, integer) -> ((CommandSource)source.getSource()).func_197030_a((ITextComponent)new StringTextComponent(biome.toString()).func_240702_b_(": " + integer + TextFormatting.GRAY + " (" + MapBiomesCommand.numberFormat.format(integer / (double)totalCount * 100.0) + "%)"), true));
        final Path p = Paths.get("biomemap.png", new String[0]);
        try {
            ImageIO.write(img, "png", p.toAbsolutePath().toFile());
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        ((CommandSource)source.getSource()).func_197030_a((ITextComponent)new StringTextComponent("Image saved!"), true);
        return 1;
    }
    
    static {
        numberFormat = new DecimalFormat("#.00");
        BIOME2COLOR = new HashMap<Biome, Color>();
    }
}
