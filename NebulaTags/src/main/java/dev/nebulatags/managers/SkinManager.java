package dev.nebulatags.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class SkinManager {

    private final HashMap<UUID, String> skins =
            new HashMap<>();

    public void setSkin(Player player,
                        String skin) {

        skins.put(
                player.getUniqueId(),
                skin
        );
    }

    public String getSkin(Player player) {

        return skins.get(
                player.getUniqueId()
        );
    }

    public boolean hasSkin(Player player) {

        return skins.containsKey(
                player.getUniqueId()
        );
    }

    public void removeSkin(Player player) {

        skins.remove(
                player.getUniqueId()
        );
    }
}