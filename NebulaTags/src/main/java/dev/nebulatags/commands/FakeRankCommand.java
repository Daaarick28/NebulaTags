package dev.nebulatags.commands;

import dev.nebulatags.NebulaTags;
import dev.nebulatags.utils.MessageUtil;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class FakeRankCommand
        implements CommandExecutor {

    private final NebulaTags plugin;

    public FakeRankCommand(
            NebulaTags plugin
    ) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player =
                (Player) sender;

        if (args.length == 0) {

            MessageUtil.send(player,
                    "&c/fakerank <rank>");

            return true;
        }

        String rank = args[0];

        plugin.getRankManager()
                .setRank(player,
                        "&a[" + rank + "]");

        MessageUtil.send(player,
                "&aFake rank updated!");

        return true;
    }
}