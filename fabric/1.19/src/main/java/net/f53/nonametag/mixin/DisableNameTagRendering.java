package net.f53.nonametag.mixin;

import net.f53.nonametag.config.ModConfig;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public abstract class DisableNameTagRendering {
	@Shadow protected abstract boolean hasLabel(Entity entity);

	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/EntityRenderer;hasLabel(Lnet/minecraft/entity/Entity;)Z"))
	private boolean dontRenderTheTag(EntityRenderer<Entity> instance, Entity entity) {
		if (ModConfig.getInstance().enabled && !(entity instanceof PlayerEntity)){
			return false;
		}
		return this.hasLabel(entity);
	}
}
