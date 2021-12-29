// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import twilightforest.world.components.structures.start.TFStructureStart;
import java.util.Optional;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import twilightforest.world.registration.TFGenerationSettings;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class ConquerCommand
{
    private static final SimpleCommandExceptionType NOT_IN_STRUCTURE;
    
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        final LiteralArgumentBuilder<CommandSourceStack> conquer = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("conquer").requires(cs -> cs.m_6761_(2))).executes(ctx -> changeStructureActivity((CommandSourceStack)ctx.getSource(), true));
        final LiteralArgumentBuilder<CommandSourceStack> reactivate = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("reactivate").requires(cs -> cs.m_6761_(2))).executes(ctx -> changeStructureActivity((CommandSourceStack)ctx.getSource(), false));
        return (LiteralArgumentBuilder<CommandSourceStack>)conquer.then((ArgumentBuilder)reactivate);
    }
    
    private static int changeStructureActivity(final CommandSourceStack source, final boolean flag) throws CommandSyntaxException {
        if (!TFGenerationSettings.usesTwilightChunkGenerator(source.m_81372_())) {
            throw TFCommand.NOT_IN_TF.create();
        }
        final ChunkGeneratorTwilight chunkGenerator = WorldUtil.getChunkGenerator((LevelAccessor)source.m_81372_());
        final BlockPos pos = new BlockPos(source.m_81371_());
        if (chunkGenerator == null) {
            throw ConquerCommand.NOT_IN_STRUCTURE.create();
        }
        final Optional<TFStructureStart.Start> struct = TFGenerationSettings.locateTFStructureInRange((WorldGenLevel)source.m_81372_(), pos, 0).map(s -> s);
        if (struct.isEmpty()) {
            throw ConquerCommand.NOT_IN_STRUCTURE.create();
        }
        struct.ifPresent(structure -> {
            new TranslatableComponent("commands.tffeature.structure.conquer.update", new Object[] { structure.isConquered(), flag });
            final TranslatableComponent translatableComponent;
            source.m_81354_((Component)translatableComponent, true);
            structure.setConquered(flag);
            return;
        });
        return 1;
    }
    
    static {
        NOT_IN_STRUCTURE = new SimpleCommandExceptionType((Message)new TranslatableComponent("commands.tffeature.structure.required"));
    }
}
