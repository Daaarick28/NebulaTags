package dev.nebulatags.listeners;

import dev.nebulatags.NebulaTags;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener
        implements Listener {

    private final NebulaTags plugin;

    public PlayerQuitListener(
            NebulaTags plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(
            PlayerQuitEvent event
    ) {

        Player player =
                event.getPlayer();

        String nick = null;
        String rank = null;
        String skin = null;

        if (plugin.getNickManager()
                .hasNick(player)) {

            nick = plugin.getNickManager()
                    .getNick(player);
        }

        rank = plugin.getRankManager()
                .getRank(player);

        if (plugin.getSkinManager()
                .hasSkin(player)) {

            skin = plugin.getSkinManager()
                    .getSkin(player);
        }

        plugin.getPlayerDataManager()
                .savePlayer(
                        player,
                        nick,
                        rank,
                        skin
                );
    }
}