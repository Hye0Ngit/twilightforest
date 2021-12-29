// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.util.Mth;
import twilightforest.world.registration.TFGenerationSettings;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class CenterCommand
{
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("center").requires(cs -> cs.m_6761_(2))).executes(CenterCommand::run);
    }
    
    private static int run(final CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final CommandSourceStack source = (CommandSourceStack)ctx.getSource();
        if (!TFGenerationSettings.usesTwilightChunkGenerator(source.m_81372_())) {
            throw TFCommand.NOT_IN_TF.create();
        }
        final int dx = Mth.m_14107_(source.m_81371_().m_7096_());
        final int dz = Mth.m_14107_(source.m_81371_().m_7094_());
        final BlockPos cc = TFFeature.getNearestCenterXYZ(dx >> 4, dz >> 4);
        final TFFeature closestFeature = TFFeature.getFeatureAt(cc.m_123341_(), cc.m_123343_(), (WorldGenLevel)source.m_81372_());
        final boolean fc = TFFeature.isInFeatureChunk(dx, dz);
        if (closestFeature == TFFeature.NOTHING) {
            source.m_81354_((Component)new TranslatableComponent("commands.tffeature.none_nearby").m_130940_(ChatFormatting.RED), false);
        }
        else {
            final String structurename = new TranslatableComponent("structure." + closestFeature.name).m_130940_(ChatFormatting.DARK_GREEN).getString();
            source.m_81354_((Component)new TranslatableComponent("commands.tffeature.nearest", new Object[] { structurename }), false);
            source.m_81354_((Component)new TranslatableComponent("commands.tffeature.center", new Object[] { cc }), false);
            source.m_81354_((Component)new TranslatableComponent("commands.tffeature.chunk", new Object[] { fc }), false);
        }
        return 1;
    }
}
