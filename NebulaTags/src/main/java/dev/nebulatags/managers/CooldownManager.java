package dev.nebulatags.managers;

import java.util.HashMap;
import java.util.UUID;

public class CooldownManager {

    private final HashMap<UUID, Long> cooldowns =
            new HashMap<>();

    public boolean hasCooldown(UUID uuid) {

        if (!cooldowns.containsKey(uuid)) {
            return false;
        }

        long time = cooldowns.get(uuid);

        return System.currentTimeMillis() < time;
    }

    public void setCooldown(UUID uuid,
                            int seconds) {

        cooldowns.put(uuid,
                System.currentTimeMillis()
                        + (seconds * 1000L));
    }

    public long getRemaining(UUID uuid) {

        return (cooldowns.get(uuid)
                - System.currentTimeMillis())
                / 1000;
    }
}