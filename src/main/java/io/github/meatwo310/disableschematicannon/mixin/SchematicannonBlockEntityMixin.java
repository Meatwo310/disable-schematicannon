package io.github.meatwo310.disableschematicannon.mixin;

import com.simibubi.create.content.schematics.cannon.SchematicannonBlockEntity;
import io.github.meatwo310.disableschematicannon.config.ServerConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SchematicannonBlockEntity.class,
        remap = false // <- SUPER IMPORTANT
)
public class SchematicannonBlockEntityMixin {
    @Inject(method = "tick()V", at = @At("HEAD"), cancellable = true)
    private void tickMixin(CallbackInfo ci) {
        if (ServerConfig.DISABLE_SCHEMATIC_CANNON.get())
            ci.cancel();
    }
}
