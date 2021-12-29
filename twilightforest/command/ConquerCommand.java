// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.Message;
import net.minecraft.util.text.TranslationTextComponent;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import twilightforest.world.ChunkGeneratorTwilightBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.world.TFGenerationSettings;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class ConquerCommand
{
    private static final SimpleCommandExceptionType NOT_IN_STRUCTURE;
    
    public static LiteralArgumentBuilder<CommandSource> register() {
        final LiteralArgumentBuilder<CommandSource> conquer = (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)Commands.func_197057_a("conquer").requires(cs -> cs.func_197034_c(2))).executes(ctx -> changeStructureActivity((CommandSource)ctx.getSource(), true));
        final LiteralArgumentBuilder<CommandSource> reactivate = (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)Commands.func_197057_a("reactivate").requires(cs -> cs.func_197034_c(2))).executes(ctx -> changeStructureActivity((CommandSource)ctx.getSource(), false));
        return (LiteralArgumentBuilder<CommandSource>)conquer.then((ArgumentBuilder)reactivate);
    }
    
    private static int changeStructureActivity(final CommandSource source, final boolean flag) throws CommandSyntaxException {
        if (!TFGenerationSettings.isTwilightChunk(source.func_197023_e())) {
            throw TFCommand.NOT_IN_TF.create();
        }
        final ChunkGeneratorTwilightBase chunkGenerator = TFGenerationSettings.getChunkGenerator((World)source.func_197023_e());
        final BlockPos pos = new BlockPos(source.func_197036_d());
        if (chunkGenerator != null) {
            return 1;
        }
        throw ConquerCommand.NOT_IN_STRUCTURE.create();
    }
    
    static {
        NOT_IN_STRUCTURE = new SimpleCommandExceptionType((Message)new TranslationTextComponent("commands.tffeature.structure.required"));
    }
}
