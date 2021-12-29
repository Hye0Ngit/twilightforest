// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.command.CommandException;
import net.minecraft.util.text.StringTextComponent;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class CenterCommand
{
    public static LiteralArgumentBuilder<CommandSource> register() {
        return (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)Commands.func_197057_a("center").requires(cs -> cs.func_197034_c(2))).executes(CenterCommand::run);
    }
    
    private static int run(final CommandContext<CommandSource> ctx) {
        throw new CommandException((ITextComponent)new StringTextComponent("This command is not supported!"));
    }
}
