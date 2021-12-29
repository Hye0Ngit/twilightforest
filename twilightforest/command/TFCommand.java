// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.Message;
import net.minecraft.util.text.TranslationTextComponent;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.command.Commands;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class TFCommand
{
    public static final SimpleCommandExceptionType NOT_IN_TF;
    
    public static void register(final CommandDispatcher<CommandSource> dispatcher) {
        final LiteralArgumentBuilder<CommandSource> builder = (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.func_197057_a("twilightforest").then((ArgumentBuilder)CenterCommand.register())).then((ArgumentBuilder)ConquerCommand.register())).then((ArgumentBuilder)InfoCommand.register())).then((ArgumentBuilder)ShieldCommand.register());
        final LiteralCommandNode<CommandSource> node = (LiteralCommandNode<CommandSource>)dispatcher.register((LiteralArgumentBuilder)builder);
        dispatcher.register((LiteralArgumentBuilder)Commands.func_197057_a("tf").redirect((CommandNode)node));
        dispatcher.register((LiteralArgumentBuilder)Commands.func_197057_a("tffeature").redirect((CommandNode)node));
        dispatcher.register((LiteralArgumentBuilder)MapBiomesCommand.register());
    }
    
    static {
        NOT_IN_TF = new SimpleCommandExceptionType((Message)new TranslationTextComponent("commands.tffeature.not_in_twilight_forest"));
    }
}
