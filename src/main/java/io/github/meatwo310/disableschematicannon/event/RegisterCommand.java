package io.github.meatwo310.disableschematicannon.event;

import io.github.meatwo310.disableschematicannon.DisableSchematicannon;
import io.github.meatwo310.disableschematicannon.command.DisableSchematicannonCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DisableSchematicannon.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterCommand {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        DisableSchematicannonCommand.register(event.getDispatcher());
    }
}
