// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import twilightforest.compat.ie.IEShaderRegister;
import net.minecraftforge.fml.ModList;
import net.minecraft.client.Minecraft;
import twilightforest.client.shader.ShaderManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class TFReloadCommand
{
    public static LiteralArgumentBuilder<CommandSource> register() {
        return (LiteralArgumentBuilder<CommandSource>)Commands.func_197057_a("tfreload").executes(TFReloadCommand::reload);
    }
    
    private static int reload(final CommandContext<CommandSource> ctx) {
        ((CommandSource)ctx.getSource()).func_197030_a((ITextComponent)new TranslationTextComponent("commands.tfreload.reload"), true);
        ShaderManager.getShaderReloadListener().func_195410_a(Minecraft.func_71410_x().func_195551_G());
        if (ModList.get().isLoaded("immersiveengineering")) {
            IEShaderRegister.initShaders();
        }
        return 1;
    }
}
