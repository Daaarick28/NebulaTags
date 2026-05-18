package dev.nebulatags.commands;

import dev.nebulatags.NebulaTags;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import dev.nebulatags.utils.ColorUtil;

public class NickCommand implements CommandExecutor {

    private final NebulaTags plugin;

    public NickCommand(NebulaTags plugin) {
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

        if (!player.hasPermission("nebulatags.nick")) {
            player.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "/nick <name>");
            return true;
        }
        String nick = args[0];
        
        plugin.getNickManager().setNick(player, nick);

        MessageUtil.sendConfig(player,
        "&aYour nickname is now &f" + nick);

        return true;
    }
}