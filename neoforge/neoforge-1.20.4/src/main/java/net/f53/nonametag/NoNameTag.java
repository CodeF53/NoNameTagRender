package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;

@Mod(NoNameTag.MODID)
public class NoNameTag {
    public static final String MODID = "nonametag";

    public NoNameTag(IEventBus modEventBus) {
        ModLoadingContext.get().registerConfig(Type.CLIENT, ModConfig.SPEC);
    }
}

