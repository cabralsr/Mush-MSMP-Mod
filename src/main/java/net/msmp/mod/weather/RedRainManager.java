package net.msmp.mod.weather;

import net.minecraft.world.level.Level;

public class RedRainManager {
    private static boolean isActive = false;

    public static boolean isActive() {
        return isActive;
    }

    public static void toggle(Level level) {
        isActive = !isActive;

        if (isActive && !level.isRaining()) {
            level.getLevelData().setRaining(true);
        }
    }
}