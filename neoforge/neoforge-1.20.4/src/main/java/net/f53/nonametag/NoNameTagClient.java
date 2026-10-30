package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;

@EventBusSubscriber(modid = NoNameTag.MODID, value = Dist.CLIENT)
public class NoNameTagClient {
    @SubscribeEvent
    public static void onRenderNameTag(RenderNameTagEvent event) {
        if (ModConfig.ENABLED.get() && !(event.getEntity() instanceof Player)) {
            event.setResult(Event.Result.DENY);
        }
    }
}
