package io.github.meatwo310.disableschematicannon;

import io.github.meatwo310.disableschematicannon.config.ServerConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DisableSchematicannon.MODID)
public class DisableSchematicannon {
    public static final String MODID = "disableschematicannon";

    public DisableSchematicannon() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }
}
