// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.entity.Entity;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.ArgumentType;
import net.minecraft.command.arguments.EntityArgument;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class ShieldCommand
{
    public static LiteralArgumentBuilder<CommandSource> register() {
        return (LiteralArgumentBuilder<CommandSource>)((LiteralArgumentBuilder)Commands.func_197057_a("shield").requires(cs -> cs.func_197034_c(2))).then(((RequiredArgumentBuilder)Commands.func_197056_a("target", (ArgumentType)EntityArgument.func_197086_a()).then(Commands.func_197057_a("set").then(((RequiredArgumentBuilder)Commands.func_197056_a("amount", (ArgumentType)IntegerArgumentType.integer()).executes(ctx -> set(EntityArgument.func_197088_a(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), true))).then(Commands.func_197056_a("temp", (ArgumentType)BoolArgumentType.bool()).executes(ctx -> set(EntityArgument.func_197088_a(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), BoolArgumentType.getBool(ctx, "temp"))))))).then(Commands.func_197057_a("add").then(((RequiredArgumentBuilder)Commands.func_197056_a("amount", (ArgumentType)IntegerArgumentType.integer()).executes(ctx -> add(EntityArgument.func_197088_a(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), true))).then(Commands.func_197056_a("temp", (ArgumentType)BoolArgumentType.bool()).executes(ctx -> add(EntityArgument.func_197088_a(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), BoolArgumentType.getBool(ctx, "temp")))))));
    }
    
    private static int add(final Entity e, final int num, final boolean temporary) {
        e.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> cap.addShields(num, temporary));
        return 1;
    }
    
    private static int set(final Entity e, final int num, final boolean temporary) {
        e.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> cap.setShields(num, temporary));
        return 1;
    }
}
