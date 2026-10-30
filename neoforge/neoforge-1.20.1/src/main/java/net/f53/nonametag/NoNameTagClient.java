package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NoNameTag.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class NoNameTagClient {
    @SubscribeEvent
    public static void onRenderNameTag(RenderNameTagEvent event) {
        if (ModConfig.ENABLED.get() && !(event.getEntity() instanceof Player)) {
            event.setResult(Event.Result.DENY);
        }
    }
}

