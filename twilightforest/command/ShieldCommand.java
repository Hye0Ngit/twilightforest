// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.world.entity.Entity;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.ArgumentType;
import net.minecraft.commands.arguments.EntityArgument;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class ShieldCommand
{
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return (LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.m_82127_("shield").requires(cs -> cs.m_6761_(2))).then(((RequiredArgumentBuilder)Commands.m_82129_("target", (ArgumentType)EntityArgument.m_91449_()).then(Commands.m_82127_("set").then(((RequiredArgumentBuilder)Commands.m_82129_("amount", (ArgumentType)IntegerArgumentType.integer()).executes(ctx -> set(EntityArgument.m_91452_(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), true))).then(Commands.m_82129_("temp", (ArgumentType)BoolArgumentType.bool()).executes(ctx -> set(EntityArgument.m_91452_(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), BoolArgumentType.getBool(ctx, "temp"))))))).then(Commands.m_82127_("add").then(((RequiredArgumentBuilder)Commands.m_82129_("amount", (ArgumentType)IntegerArgumentType.integer()).executes(ctx -> add(EntityArgument.m_91452_(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), true))).then(Commands.m_82129_("temp", (ArgumentType)BoolArgumentType.bool()).executes(ctx -> add(EntityArgument.m_91452_(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount"), BoolArgumentType.getBool(ctx, "temp")))))));
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
