package dev.nebulatags.managers;

import dev.nebulatags.NebulaTags;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class NickManager {

    private final NebulaTags plugin;

    private final HashMap<UUID, String> nicknames;

    public NickManager(NebulaTags plugin) {
        this.plugin = plugin;
        this.nicknames = new HashMap<>();
    }

    public void setNick(Player player, String nick) {

        nicknames.put(player.getUniqueId(), nick);

        player.setDisplayName(nick);
        plugin.getNametagManager()
        .updateNametag(player, nick);
        setNick()
        player.setPlayerListName(nick);
    }

    public void removeNick(Player player) {

        nicknames.remove(player.getUniqueId());

        plugin.getNametagManager()
        .resetNametag(player);

    public boolean hasNick(Player player) {
        return nicknames.containsKey(player.getUniqueId());
    }

    public String getNick(Player player) {
        return nicknames.get(player.getUniqueId());
    }
}