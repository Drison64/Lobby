package me.Drison64.Lobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ticTacToeQueueMenu implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (e.getPlayer().getOpenInventory().getTopInventory().getTitle().equals("Waiting for opponent")) {
            customConfig.get().getList("tictactoe.queue").remove(e.getPlayer().getUniqueId().toString());
            customConfig.get().set(e.getPlayer().getUniqueId() + ".ttt_look", false);
            customConfig.save();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (e.getInventory().getTitle().equals("Waiting for opponent")) {
            customConfig.get().getList("tictactoe.queue").remove(e.getPlayer().getUniqueId().toString());
            customConfig.get().set(e.getPlayer().getUniqueId() + ".ttt_look", false);
            customConfig.save();
        }
    }

}
