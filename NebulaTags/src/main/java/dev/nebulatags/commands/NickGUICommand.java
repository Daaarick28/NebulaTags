package dev.nebulatags.commands;

import dev.nebulatags.gui.NickGUI;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class NickGUICommand
        implements CommandExecutor {

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

        Player player = (Player) sender;

        NickGUI.open(player);

        return true;
    }
}