package net.f53.nonametag.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue ENABLED;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        ENABLED = builder.define("enabled", true);
        SPEC = builder.build();
    }
}
