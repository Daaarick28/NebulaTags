package dev.nebulatags.managers;

import dev.nebulatags.NebulaTags;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    private final NebulaTags plugin;

    private File messagesFile;
    private FileConfiguration messages;

    public ConfigManager(NebulaTags plugin) {

        this.plugin = plugin;

        loadConfigs();
    }

    public void loadConfigs() {

        plugin.saveDefaultConfig();

        setupMessages();
    }

    private void setupMessages() {

        messagesFile = new File(
                plugin.getDataFolder(),
                "messages.yml"
        );

        if (!messagesFile.exists()) {
            plugin.saveResource("messages.yml", false);
        }

        messages = YamlConfiguration
                .loadConfiguration(messagesFile);
    }

    public void reloadConfigs() {

        plugin.reloadConfig();

        messages = YamlConfiguration
                .loadConfiguration(messagesFile);
    }

    public String getMessage(String path) {

        return messages.getString(path);
    }
}