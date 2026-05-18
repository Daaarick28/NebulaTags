package dev.nebulatags.listeners;

import dev.nebulatags.NebulaTags;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener
        implements Listener {

    private final NebulaTags plugin;

    public PlayerJoinListener(
            NebulaTags plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(
            PlayerJoinEvent event
    ) {

        Player player =
                event.getPlayer();

        String nick =
                plugin.getPlayerDataManager()
                        .getNick(player);

        String rank =
                plugin.getPlayerDataManager()
                        .getRank(player);

        String skin =
                plugin.getPlayerDataManager()
                        .getSkin(player);

        if (nick != null) {

            plugin.getNickManager()
                    .setNick(player,
                            nick);
        }

        if (rank != null) {

            plugin.getRankManager()
                    .setRank(player,
                            rank);
        }

        if (skin != null) {

            plugin.getSkinManager()
                    .setSkin(player,
                            skin);
        }
    }
}