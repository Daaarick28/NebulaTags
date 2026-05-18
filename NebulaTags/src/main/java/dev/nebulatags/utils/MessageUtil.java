package dev.nebulatags.utils;

import dev.nebulatags.NebulaTags;
import org.bukkit.command.CommandSender;

public class MessageUtil {

    public static void send(CommandSender sender,
                            String message) {

        sender.sendMessage(
                ColorUtil.color(message)
        );
    }

    public static void sendConfig(CommandSender sender,
                                  String path) {

        String message = NebulaTags.getInstance()
                .getConfigManager()
                .getMessage(path);

        send(sender, message);
    }

    public static void sendConfig(CommandSender sender,
                                  String path,
                                  String placeholder,
                                  String value) {

        String message = NebulaTags.getInstance()
                .getConfigManager()
                .getMessage(path);

        message = message.replace(
                placeholder,
                value
        );

        send(sender, message);
    }
}