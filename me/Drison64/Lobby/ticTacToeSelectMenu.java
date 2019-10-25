package me.Drison64.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.time.Instant;
import java.util.Arrays;

public class ticTacToeSelectMenu implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Tic tac toe menu")) {
            e.setCancelled(true);
            if (e.getRawSlot() == 11) {
                /*
                customConfig.get().set(e.getWhoClicked().getUniqueId().toString() + ".ttt_look", true);
                customConfig.get().set("ttt.list", customConfig.get().getList("ttt.list"));
                customConfig.get().set(e.getWhoClicked().getUniqueId().toString() + ".ttt_q_t", Instant.now().getEpochSecond());
                customConfig.save();
                e.getWhoClicked().openInventory(Bukkit.createInventory(null, 27, "Waiting for opponent"));
                 */
            } else if (e.getRawSlot() == 15) {
                e.getWhoClicked().openInventory(Bukkit.createInventory(null, InventoryType.ANVIL , "Type a name"));
                e.getWhoClicked().getOpenInventory().setItem(10, mkitem.mkitem(1, Material.DIRT, "", Arrays.asList("")));
            }
        }
    }
}
