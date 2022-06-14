package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.fabricmc.api.ModInitializer;

public class nonametaginit implements ModInitializer {
	@Override
	public void onInitialize() {
		ModConfig.init();
	}
}
