package me.Drison64.Lobby;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class mkitem {

    public static ItemStack mkitem(int count, Material material, String name, List<String> desc) {
        ItemStack item = new ItemStack(material, count);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if (!(desc.toString().length() < 1)) {
            meta.setLore(desc);
        }
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack mkcitem(int count, Material material, String name, List<String> desc, short color) {
        ItemStack item = new ItemStack(material, count, color);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if (!(desc.toString().length() < 1)) {
            meta.setLore(desc);
        }
        item.setItemMeta(meta);
        return item;
    }

}
