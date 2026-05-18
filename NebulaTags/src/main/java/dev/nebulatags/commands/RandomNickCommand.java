package dev.nebulatags.commands;

import dev.nebulatags.NebulaTags;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class RandomNickCommand implements CommandExecutor {

    private final NebulaTags plugin;

    public RandomNickCommand(NebulaTags plugin) {
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

        List<String> nicks =
                plugin.getConfig().getStringList("random-nicks");

        if (nicks.isEmpty()) {
            player.sendMessage(ChatColor.RED +
                    "No random nicknames configured.");
            return true;
        }

        String nick = nicks.get(
                new Random().nextInt(nicks.size())
        );

        plugin.getNickManager().setNick(player, nick);

        MessageUtil.sendConfig(ChatColor.GREEN +
                "Your random nick is now " + nick);

        return true;
    }
}