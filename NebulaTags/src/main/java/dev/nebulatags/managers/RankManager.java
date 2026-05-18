package dev.nebulatags.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class RankManager {

    private final HashMap<UUID, String> ranks =
            new HashMap<>();

    public void setRank(Player player,
                        String rank) {

        ranks.put(player.getUniqueId(),
                rank);
    }

    public String getRank(Player player) {

        return ranks.getOrDefault(
                player.getUniqueId(),
                "&7[Default]"
        );
    }

    public void removeRank(Player player) {

        ranks.remove(player.getUniqueId());
    }
}