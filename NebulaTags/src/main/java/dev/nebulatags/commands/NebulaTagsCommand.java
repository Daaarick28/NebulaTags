package dev.nebulatags.commands;

import dev.nebulatags.NebulaTags;
import dev.nebulatags.utils.MessageUtil;
import org.bukkit.command.*;

public class NebulaTagsCommand
        implements CommandExecutor {

    private final NebulaTags plugin;

    public NebulaTagsCommand(
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

        if (!sender.hasPermission(
                "nebulatags.admin")) {

            MessageUtil.sendConfig(
                    sender,
                    "no-permission"
            );

            return true;
        }

        if (args.length == 0) {

            MessageUtil.send(sender,
                    "&c/nebulatags reload");

            return true;
        }

        if (args[0].equalsIgnoreCase(
                "reload")) {

            plugin.getConfigManager()
                    .reloadConfigs();

            MessageUtil.send(sender,
                    "&aNebulaTags reloaded.");

            return true;
        }

        return true;
    }
}