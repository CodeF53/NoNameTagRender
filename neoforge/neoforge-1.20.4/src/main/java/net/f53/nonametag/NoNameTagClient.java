package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;

@EventBusSubscriber(modid = NoNameTag.MODID, value = Dist.CLIENT)
public class NoNameTagClient {
    @SubscribeEvent
    public static void onRenderNameTag(RenderNameTagEvent.CanRender event) {
        if (ModConfig.ENABLED.get() && !(event.getEntity() instanceof Player)) {
            event.setCanRender(TriState.FALSE);
        }
    }
}

