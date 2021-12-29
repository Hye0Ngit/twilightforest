// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.util.Iterator;
import java.util.List;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.world.level.biome.MobSpawnSettings;
import twilightforest.world.components.structures.start.TFStructureStart;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.BlockPos;
import twilightforest.world.registration.TFGenerationSettings;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class InfoCommand
{
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("info").requires(cs -> cs.m_6761_(2))).executes(InfoCommand::run);
    }
    
    private static int run(final CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final CommandSourceStack source = (CommandSourceStack)ctx.getSource();
        if (!TFGenerationSettings.usesTwilightChunkGenerator(source.m_81372_())) {
            throw TFCommand.NOT_IN_TF.create();
        }
        final BlockPos pos = new BlockPos(source.m_81371_());
        final BlockPos cc = TFFeature.getNearestCenterXYZ(pos.m_123341_() >> 4, pos.m_123343_() >> 4);
        final TFFeature closestFeature = TFFeature.getFeatureAt(cc.m_123341_(), cc.m_123343_(), (WorldGenLevel)source.m_81372_());
        source.m_81354_((Component)new TranslatableComponent("This command is still WIP, some things may still be broken.").m_130944_(new ChatFormatting[] { ChatFormatting.RED, ChatFormatting.BOLD }), false);
        final String structurename = new TranslatableComponent("structure." + closestFeature.name).getString();
        source.m_81354_((Component)new TranslatableComponent("commands.tffeature.nearest", new Object[] { structurename }), false);
        final ChunkGeneratorTwilight chunkGenerator = WorldUtil.getChunkGenerator((LevelAccessor)source.m_81372_());
        if (chunkGenerator != null) {
            TFGenerationSettings.locateTFStructureInRange((WorldGenLevel)source.m_81372_(), closestFeature, pos, 0).map(s -> s).ifPresent(structure -> {
                source.m_81354_((Component)new TranslatableComponent("commands.tffeature.structure.inside").m_130944_(new ChatFormatting[] { ChatFormatting.BOLD, ChatFormatting.GREEN }), false);
                new TranslatableComponent("commands.tffeature.structure.conquer.status", new Object[] { structure.isConquered() });
                final TranslatableComponent translatableComponent;
                source.m_81354_((Component)translatableComponent.m_130944_(new ChatFormatting[] { ChatFormatting.BOLD, structure.isConquered() ? ChatFormatting.GREEN : ChatFormatting.RED }), false);
                final List<MobSpawnSettings.SpawnerData> spawnList = TFStructureStart.gatherPotentialSpawns(source.m_81372_().m_8595_(), MobCategory.MONSTER, pos);
                source.m_81354_((Component)new TranslatableComponent("commands.tffeature.structure.spawn_list").m_130940_(ChatFormatting.UNDERLINE), false);
                if (spawnList != null) {
                    spawnList.iterator();
                    final Iterator iterator;
                    while (iterator.hasNext()) {
                        final MobSpawnSettings.SpawnerData entry = iterator.next();
                        new TranslatableComponent("commands.tffeature.structure.spawn_info", new Object[] { entry.f_48404_.m_20676_().getString(), entry.m_142631_().m_146281_() });
                        final TranslatableComponent translatableComponent2;
                        source.m_81354_((Component)translatableComponent2, false);
                    }
                }
                return;
            });
        }
        else {
            source.m_81354_((Component)new TranslatableComponent("commands.tffeature.structure.outside").m_130944_(new ChatFormatting[] { ChatFormatting.BOLD, ChatFormatting.RED }), false);
        }
        return 1;
    }
}
