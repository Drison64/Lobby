package me.Drison64.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class ASclick implements Listener {

    public void clicked(Entity entity, Player player) {
        if (entity.getType().equals(EntityType.ARMOR_STAND)) {
            if (entity.getCustomName().equals(ChatColor.BLUE + "Daily Reward")) {
                customConfig.reload();
                /*
                if (customConfig.get().isSet("dailyreward." + player.getName() + ".timestamp")) {
                    long now = Instant.now().getEpochSecond();
                    long finish = customConfig.get().getLong("dailyreward." + player.getName() + ".timestamp") + 86400;
                    player.openInventory(dailyReward.inv);
                    long seconds = (finish - now) % 60;
                    long hours = (finish - now) / 60;
                    long minutes = hours % 60;
                    hours = hours / 60;
                    if (!((finish - now) == 0)) {
                        dailyReward.inv.setItem(1, new ItemStack(mkitem.mkitem(1, Material.COAL, "Daily Reward", Arrays.asList("", "Next in " + hours + ":" + minutes + ":" + seconds))));
                    } else {
                        customConfig.get().set("dailyreward." + player.getName() + ".timestamp", null);
                    }
                } else {
                    dailyReward.inv.setItem(1, new ItemStack(mkitem.mkitem(1, Material.DIAMOND, "Daily Reward", Arrays.asList("", "Click to get!"))));
                }
                */
                player.openInventory(dailyReward.inv);
            } else if (entity.getCustomName().equals(ChatColor.BLUE + "Tic Tac Toe")) {
                player.openInventory(Bukkit.createInventory(null, 27, "Tic tac toe menu"));
                customConfig.save();
                player.getOpenInventory().getTopInventory().setItem(11, mkitem.mkitem(1, Material.DIRT, "Random", Arrays.asList("")));
                player.getOpenInventory().getTopInventory().setItem(15, mkitem.mkitem(1, Material.DIAMOND_BLOCK, "Enter name", Arrays.asList("")));
            }
        }
    }

    @EventHandler
    public void onEntityClick(PlayerInteractAtEntityEvent e) {
        e.setCancelled(true);
        clicked(e.getRightClicked(), e.getPlayer());
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
        if (e.getDamager() instanceof Player) {
            clicked(e.getEntity(), (Player) e.getDamager());
        }
    }

}
