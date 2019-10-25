package me.Drison64.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.time.Instant;
import java.util.Arrays;

public class dailyReward implements Listener, InventoryHolder {

    public static Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GRAY + "Daily Reward");

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.GRAY + "Daily Reward")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getRawSlot() == 1) {
                customConfig.get().set(player.getUniqueId() + ".dr_timestamp", Instant.now().getEpochSecond());
                customConfig.save();
                long now = Instant.now().getEpochSecond();
                long finish = customConfig.get().getLong(player.getUniqueId() + ".dr_timestamp") + 10;
                long seconds = (finish - now) % 60;
                long hours = (finish - now) / 60;
                long minutes = hours % 60;
                hours = hours / 60;
                String sseconds = String.valueOf(seconds);
                String sminutes = String.valueOf(minutes);
                String shours = String.valueOf(hours);
                if (sseconds.length() == 1) {
                    sseconds = "0" + sseconds;
                }
                if (sminutes.length() == 1) {
                    sminutes = "0" + sminutes;
                }
                if (shours.length() == 1) {
                    shours = "0" + shours;
                }
                player.getOpenInventory().getTopInventory().setItem(1, mkitem.mkitem(1, Material.COAL, "Daily Reward", Arrays.asList("", "Next in " + shours + ":" + sminutes + ":" + sseconds)));
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

}
