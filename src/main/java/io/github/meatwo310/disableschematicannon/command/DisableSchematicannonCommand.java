package io.github.meatwo310.disableschematicannon.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import io.github.meatwo310.disableschematicannon.config.ServerConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class DisableSchematicannonCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("schematicannon")
                .then(Commands.literal("status")
                        .executes(DisableSchematicannonCommand::status))
                .then(Commands.literal("enable")
                        .requires(commandSource -> commandSource.hasPermission(2))
                        .executes(DisableSchematicannonCommand::enable))
                .then(Commands.literal("disable")
                        .requires(commandSource -> commandSource.hasPermission(2))
                        .executes(DisableSchematicannonCommand::disable))
                .then(Commands.literal("toggle")
                        .requires(commandSource -> commandSource.hasPermission(2))
                        .executes(DisableSchematicannonCommand::toggle))
        );
    }

    private static int status(CommandContext<CommandSourceStack> command) {
        command.getSource().sendSuccess(() -> Component.literal("Schematicannon is ")
                .append(ServerConfig.DISABLE_SCHEMATIC_CANNON.get() ? "§cdisabled" : "§aenabled"), false);
        return Command.SINGLE_SUCCESS;
    }

    private static int enable(CommandContext<CommandSourceStack> command) {
        ServerConfig.DISABLE_SCHEMATIC_CANNON.set(false);
        command.getSource().sendSuccess(() -> Component.literal("Schematicannon is now §aenabled"), false);
        return Command.SINGLE_SUCCESS;
    }

    private static int disable(CommandContext<CommandSourceStack> command) {
        ServerConfig.DISABLE_SCHEMATIC_CANNON.set(true);
        command.getSource().sendSuccess(() -> Component.literal("Schematicannon is now §cdisabled"), false);
        return Command.SINGLE_SUCCESS;
    }

    private static int toggle(CommandContext<CommandSourceStack> command) {
        boolean newValue = !ServerConfig.DISABLE_SCHEMATIC_CANNON.get();
        ServerConfig.DISABLE_SCHEMATIC_CANNON.set(newValue);
        command.getSource().sendSuccess(() -> Component.literal("Schematicannon toggled to ")
                .append(newValue ? "§cdisabled" : "§aenabled"), false);
        return Command.SINGLE_SUCCESS;
    }
}
