package dev.nebulatags.managers;

import dev.nebulatags.NebulaTags;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class StorageManager {

    private final NebulaTags plugin;

    private File file;
    private YamlConfiguration config;

    public StorageManager(NebulaTags plugin) {

        this.plugin = plugin;

        setup();
    }

    private void setup() {

        file = new File(plugin.getDataFolder(),
                "players.yml");

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public void saveNick(Player player, String nick) {

        config.set(player.getUniqueId().toString(), nick);

        save();
    }

    public String getNick(Player player) {

        return config.getString(
                player.getUniqueId().toString()
        );
    }

    private void save() {

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}