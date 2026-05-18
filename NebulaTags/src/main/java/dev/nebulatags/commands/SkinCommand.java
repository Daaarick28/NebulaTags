package dev.nebulatags.commands;

import dev.nebulatags.NebulaTags;
import dev.nebulatags.utils.MessageUtil;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SkinCommand
        implements CommandExecutor {

    private final NebulaTags plugin;

    public SkinCommand(
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
                    "&c/skin <player>");

            return true;
        }

        String skin = args[0];

        plugin.getSkinManager()
                .setSkin(player,
                        skin);

        MessageUtil.send(player,
                "&aFake skin set to &f"
                        + skin);

        return true;
    }
}