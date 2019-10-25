package me.Drison64.Lobby;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.time.Instant;
import java.util.Arrays;

public class serverSelector implements Listener, InventoryHolder {

    public Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GRAY + "Server Selector");

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player player = e.getPlayer();
            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                int[] slots = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53};
                for (int i : slots) {
                    ItemStack item = mkitem.mkcitem(1, Material.STAINED_GLASS_PANE, "", Arrays.asList(""), (short) 7);
                    inv.setItem(i, item);
                }
                player.openInventory(inv);
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
