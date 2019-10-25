package me.Drison64.Lobby;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;

public class ticTacToeNameMenu implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Type a name")) {
            e.setCancelled(true);
            e.getWhoClicked().getOpenInventory().getTopInventory().setItem(e.getRawSlot(), mkitem.mkitem(1, Material.DIRT, "", Arrays.asList("")));
        }
    }

}
