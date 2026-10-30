package net.f53.nonametag;

import net.f53.nonametag.config.ModConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

@Mod(NoNameTag.MODID)
public class NoNameTag {
    public static final String MODID = "nonametag";

    public NoNameTag() {
        ModLoadingContext.get().registerConfig(Type.CLIENT, ModConfig.SPEC);
    }
}

