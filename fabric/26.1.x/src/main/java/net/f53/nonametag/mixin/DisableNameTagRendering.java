package net.f53.nonametag.mixin;

import net.f53.nonametag.config.ModConfig;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public abstract class DisableNameTagRendering {
	@Shadow protected abstract boolean shouldShowName(Entity entity, double squaredDistanceToCamera);

	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/EntityRenderer;shouldShowName(Lnet/minecraft/world/entity/Entity;D)Z"))
	private boolean dontRenderTheTag(EntityRenderer<?, ?> instance, Entity entity, double squaredDistanceToCamera) {
		if (ModConfig.getInstance().enabled && !(entity instanceof Player)){
			return false;
		}
		return this.shouldShowName(entity, squaredDistanceToCamera);
	}
}
