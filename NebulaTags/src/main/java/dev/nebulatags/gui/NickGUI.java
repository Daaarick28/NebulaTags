package dev.nebulatags.gui;

import dev.nebulatags.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NickGUI {

    public static void open(Player player) {

        Inventory gui = Bukkit.createInventory(
                null,
                27,
                ColorUtil.color("&5&lNebulaTags")
        );

        ItemStack randomNick =
                new ItemStack(Material.NAME_TAG);

        ItemMeta randomMeta =
                randomNick.getItemMeta();

        randomMeta.setDisplayName(
                ColorUtil.color("&aRandom Nick")
        );

        randomNick.setItemMeta(randomMeta);

        gui.setItem(11, randomNick);

        ItemStack removeNick =
                new ItemStack(Material.BARRIER);

        ItemMeta removeMeta =
                removeNick.getItemMeta();

        removeMeta.setDisplayName(
                ColorUtil.color("&cRemove Nick")
        );

        removeNick.setItemMeta(removeMeta);

        gui.setItem(15, removeNick);

        player.openInventory(gui);
    }
}