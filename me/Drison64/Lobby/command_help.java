package me.Drison64.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;

public class command_help implements CommandExecutor, Listener, InventoryHolder {

    public Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GRAY + "Help");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int[] slots = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
            for (int i : slots) {
                ItemStack item = mkitem.mkcitem(1, Material.STAINED_GLASS_PANE, "", Arrays.asList(""), (short) 7);
                inv.setItem(i, item);
            }
            player.openInventory(inv);
        } else {
            sender.sendMessage(ChatColor.RED + "Tento příkaz je pouze pro hráče!");
        }
        return false;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
