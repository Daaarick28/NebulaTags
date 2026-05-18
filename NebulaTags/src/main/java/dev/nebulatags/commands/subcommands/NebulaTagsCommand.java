package dev.nebulatags.commands;

import org.bukkit.command.*;
import java.util.*;

public class NebulaTabCompleter
        implements TabCompleter {

    @Override
    public List<String> onTabComplete(
            CommandSender sender,
            Command command,
            String alias,
            String[] args
    ) {

        List<String> completions =
                new ArrayList<>();

        if (command.getName()
                .equalsIgnoreCase(
                        "fakerank"
                )) {

            if (args.length == 1) {

                completions.add("VIP");
                completions.add("MVP");
                completions.add("ADMIN");
                completions.add("OWNER");
            }
        }

        if (command.getName()
                .equalsIgnoreCase(
                        "nebulatags"
                )) {

            if (args.length == 1) {

                completions.add("reload");
                completions.add("help");
            }
        }

        return completions;
    }
}