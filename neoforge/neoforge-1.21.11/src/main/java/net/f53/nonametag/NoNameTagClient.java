package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.util.TriState;

@Mod(value = NoNameTag.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = NoNameTag.MODID, value = Dist.CLIENT)
public class NoNameTagClient {
    public NoNameTagClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onRenderNameTag(RenderNameTagEvent.CanRender event) {
        if (ModConfig.ENABLED.get() && !(event.getEntity() instanceof Player)) {
            event.setCanRender(TriState.FALSE);
        }
    }
}
