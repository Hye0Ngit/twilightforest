// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import twilightforest.world.ChunkGeneratorTwilightBase;
import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import twilightforest.world.TFGenerationSettings;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class InfoCommand
{
    public static LiteralArgumentBuilder<CommandSource> register() {
        return (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)Commands.func_197057_a("info").requires(cs -> cs.func_197034_c(2))).executes(InfoCommand::run);
    }
    
    private static int run(final CommandContext<CommandSource> ctx) throws CommandSyntaxException {
        final CommandSource source = (CommandSource)ctx.getSource();
        if (!TFGenerationSettings.isTwilightChunk(source.func_197023_e())) {
            throw TFCommand.NOT_IN_TF.create();
        }
        final BlockPos pos = new BlockPos(source.func_197036_d());
        final TFFeature nearbyFeature = TFFeature.getFeatureAt(pos.func_177958_n(), pos.func_177952_p(), (ISeedReader)source.func_197023_e());
        source.func_197030_a((ITextComponent)new TranslationTextComponent("commands.tffeature.nearest", new Object[] { nearbyFeature.name }), false);
        final ChunkGeneratorTwilightBase chunkGenerator = TFGenerationSettings.getChunkGenerator((World)source.func_197023_e());
        if (chunkGenerator != null) {
            source.func_197030_a((ITextComponent)new TranslationTextComponent("commands.tffeature.structure.inside"), false);
        }
        else {
            source.func_197030_a((ITextComponent)new TranslationTextComponent("commands.tffeature.structure.outside"), false);
        }
        return 1;
    }
}
