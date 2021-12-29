// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.Message;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.Commands;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class TFCommand
{
    public static final SimpleCommandExceptionType NOT_IN_TF;
    
    public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
        final LiteralArgumentBuilder<CommandSourceStack> builder = (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.m_82127_("twilightforest").then((ArgumentBuilder)CenterCommand.register())).then((ArgumentBuilder)ConquerCommand.register())).then((ArgumentBuilder)InfoCommand.register())).then((ArgumentBuilder)ShieldCommand.register());
        final LiteralCommandNode<CommandSourceStack> node = (LiteralCommandNode<CommandSourceStack>)dispatcher.register((LiteralArgumentBuilder)builder);
        dispatcher.register((LiteralArgumentBuilder)Commands.m_82127_("tf").redirect((CommandNode)node));
        dispatcher.register((LiteralArgumentBuilder)Commands.m_82127_("tffeature").redirect((CommandNode)node));
        dispatcher.register((LiteralArgumentBuilder)MapBiomesCommand.register());
    }
    
    static {
        NOT_IN_TF = new SimpleCommandExceptionType((Message)new TranslatableComponent("commands.tffeature.not_in_twilight_forest").m_130940_(ChatFormatting.RED));
    }
}
