package dev.nebulatags.listeners;

import dev.nebulatags.NebulaTags;
import dev.nebulatags.utils.ColorUtil;
import dev.nebulatags.utils.MessageUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class InventoryClickListener
        implements Listener {

    private final NebulaTags plugin;

    public InventoryClickListener(
            NebulaTags plugin
    ) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(
            InventoryClickEvent event
    ) {

        if (event.getView().getTitle()
                .equalsIgnoreCase(
                        ColorUtil.color(
                                "&5&lNebulaTags"
                        )
                )) {

            event.setCancelled(true);

            Player player =
                    (Player) event.getWhoClicked();

            if (event.getCurrentItem() == null) {
                return;
            }

            switch (event.getCurrentItem()
                    .getType()) {

                case NAME_TAG:

                    List<String> nicks =
                            plugin.getConfig()
                                    .getStringList(
                                            "random-nicks"
                                    );

                    String nick = nicks.get(
                            new Random()
                                    .nextInt(
                                            nicks.size()
                                    )
                    );

                    plugin.getNickManager()
                            .setNick(player, nick);

                    MessageUtil.send(player,
                            "&aRandom nick applied!");

                    player.closeInventory();

                    break;

                case BARRIER:

                    plugin.getNickManager()
                            .removeNick(player);

                    MessageUtil.send(player,
                            "&cNickname removed!");

                    player.closeInventory();

                    break;
            }
        }
    }
}