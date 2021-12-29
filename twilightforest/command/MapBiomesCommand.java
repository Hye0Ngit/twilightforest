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
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import twilightforest.item.MagicMapItem;
import java.awt.image.BufferedImage;
import net.minecraftforge.fml.loading.FMLEnvironment;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.awt.Color;
import net.minecraft.world.level.biome.Biome;
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
    
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("biomepng").requires(cs -> cs.m_6761_(2))).executes(MapBiomesCommand::execute);
    }
    
    private static int execute(final CommandContext<CommandSourceStack> source) {
        if (FMLEnvironment.dist.isDedicatedServer()) {
            return -1;
        }
        init();
        final Map<Biome, Integer> biomeCount = new HashMap<Biome, Integer>();
        final BufferedImage img = new BufferedImage(4096, 4096, 1);
        final int progressUpdate = img.getHeight() / 8;
        for (int x = 0; x < img.getHeight(); ++x) {
            for (int z = 0; z < img.getWidth(); ++z) {
                final Biome b = ((CommandSourceStack)source.getSource()).m_81372_().m_7158_(x - 2048, 0, z - 2048);
                Color color = MapBiomesCommand.BIOME2COLOR.get(b);
                if (color == null) {
                    int colorInt = MagicMapItem.getBiomeColor(b);
                    if (colorInt == 0) {
                        colorInt = b.m_47464_(0.0, 0.0);
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
                ((CommandSourceStack)source.getSource()).m_81354_((Component)new TranslatableComponent(x / (double)img.getHeight() * 100.0 + "% Done mapping"), true);
            }
        }
        ((CommandSourceStack)source.getSource()).m_81354_((Component)new TextComponent("Approximate biome-block counts within an 2048x2048 region"), true);
        final int totalCount = biomeCount.values().stream().mapToInt(i -> i).sum();
        biomeCount.forEach((biome, integer) -> ((CommandSourceStack)source.getSource()).m_81354_((Component)new TextComponent(biome.toString()).m_130946_(": " + integer + ChatFormatting.GRAY + " (" + MapBiomesCommand.numberFormat.format(integer / (double)totalCount * 100.0) + "%)"), true));
        final Path p = Paths.get("biomemap.png", new String[0]);
        try {
            ImageIO.write(img, "png", p.toAbsolutePath().toFile());
        }
        catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        ((CommandSourceStack)source.getSource()).m_81354_((Component)new TextComponent("Image saved!"), true);
        return 1;
    }
    
    static {
        numberFormat = new DecimalFormat("#.00");
        BIOME2COLOR = new HashMap<Biome, Color>();
    }
}
