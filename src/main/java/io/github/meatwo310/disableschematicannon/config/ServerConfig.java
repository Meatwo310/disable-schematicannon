package io.github.meatwo310.disableschematicannon.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue DISABLE_SCHEMATIC_CANNON = BUILDER
            .comment("Whether to disable the Schematicannon ticking.")
            .define("disableSchematicannon", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
