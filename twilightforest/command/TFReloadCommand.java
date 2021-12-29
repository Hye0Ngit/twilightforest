// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class TFReloadCommand
{
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return (LiteralArgumentBuilder<CommandSourceStack>)Commands.m_82127_("tfreload").executes(TFReloadCommand::reload);
    }
    
    private static int reload(final CommandContext<CommandSourceStack> ctx) {
        return 1;
    }
}
