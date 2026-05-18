package dev.nebulatags.commands;

import dev.nebulatags.NebulaTags;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class UnnickCommand implements CommandExecutor {

    private final NebulaTags plugin;

    public UnnickCommand(NebulaTags plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        plugin.getNickManager().removeNick(player);

        MessageUtil.sendConfig(player,
        "&cNickname removed.");

        return true;
    }
}