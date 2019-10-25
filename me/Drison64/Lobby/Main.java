package me.Drison64.Lobby;

import me.Drison64.SimpleNMS.SimpleNMS;
import net.minecraft.server.v1_8_R3.*;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;

import me.Drison64.SimpleNMS.ClientBound.*;

public class Main extends JavaPlugin implements Listener {

    public static Entity AS1;
    public static Entity AS1status;
    public static Entity AS1maintenance;
    public static Entity AS2;
    public static Entity AS2status;
    public static Entity AS2maintenance;
    public static Entity AS3;
    public static Entity AS3status;
    public static Entity AS3maintenance;
    public static Entity AS4;
    public static Entity AS4status;
    public static Entity AS4maintenance;
    public static Entity AS5;
    public static Entity AS5status;
    public static Entity AS5maintenance;
    public static Entity ASDR;
    public static Entity ASTTT;
    public static HashMap<Player, EntityWither> hashmap;
    static Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
    static Objective objective = board.registerNewObjective("sidebar", "dummy");

    public void onEnable() {
        //Startup
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
        Bukkit.getPluginManager().registerEvents(new ticTacToeNameMenu(), this);
        Bukkit.getPluginManager().registerEvents(new ticTacToeSelectMenu(), this);
        Bukkit.getPluginManager().registerEvents(new ticTacToeQueueMenu(), this);
        Bukkit.getPluginManager().registerEvents(new ASclick(), this);
        Bukkit.getPluginManager().registerEvents(new dailyReward(), this);
        Bukkit.getPluginManager().registerEvents(new serverSelector(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("getuuid").setExecutor(new command_getuuid());
        getCommand("edit").setExecutor(new command_edit());
        getCommand("help").setExecutor(new command_help());
        getCommand("maintenance").setExecutor(new command_maintenance());
        InputStream file = getResource("data.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        customConfig.setup();
        customConfig.get().setDefaults(config);
        customConfig.get().options().copyDefaults(true);
        customConfig.save();

        //Killing AS on start
        for (Entity e : Bukkit.getWorld("world").getEntities()) {
            if (e.getType().equals(EntityType.ARMOR_STAND)) {
                e.remove();
            }
        }

        customConfig.reload();
        //AS1
        Location AS1loc = new Location(Bukkit.getWorld("world"), 672.5, 128, -75.5, 0, 0);
        AS1 = Bukkit.getWorld("world").spawnEntity(AS1loc, EntityType.ARMOR_STAND);
        AS1.setCustomName(ChatColor.BLUE + "1");
        AS1.setCustomNameVisible(true);

        //AS1status
        Location AS1statusloc = new Location(Bukkit.getWorld("world"), 672.5, 128.25, -75.5, 0, 0);
        AS1status = Bukkit.getWorld("world").spawnEntity(AS1statusloc, EntityType.ARMOR_STAND);
        freezeEntity(AS1status);
        AS1status.setCustomName(customConfig.get().getString("lobby.AS.1"));
        AS1status.setCustomNameVisible(true);

        //AS1maintenance
        Location AS1maintenanceloc = new Location(Bukkit.getWorld("world"), 672.5, 128.5, -75.5, 0, 0);
        AS1maintenance = Bukkit.getWorld("world").spawnEntity(AS1maintenanceloc, EntityType.ARMOR_STAND);
        freezeEntity(AS1maintenance);
        AS1maintenance.setCustomName(ChatColor.DARK_RED + "Maintenance");
        AS1maintenance.setCustomNameVisible(customConfig.get().getBoolean("lobby.maintenance.1"));



        //AS2
        Location AS2loc = new Location(Bukkit.getWorld("world"), 675.5, 128, -76.5, 0, 0);
        AS2 = Bukkit.getWorld("world").spawnEntity(AS2loc, EntityType.ARMOR_STAND);
        AS2.setCustomName(ChatColor.BLUE + "2");
        AS2.setCustomNameVisible(true);

        //AS2status
        Location AS2statusloc = new Location(Bukkit.getWorld("world"), 675.5, 128.25, -76.5, 0, 0);
        AS2status = Bukkit.getWorld("world").spawnEntity(AS2statusloc, EntityType.ARMOR_STAND);
        freezeEntity(AS2status);
        AS2status.setCustomName(customConfig.get().getString("lobby.AS.2"));
        AS2status.setCustomNameVisible(true);

        //AS2maintenance
        Location AS2maintenanceloc = new Location(Bukkit.getWorld("world"), 675.5, 128.5, -76.5, 0, 0);
        AS2maintenance = Bukkit.getWorld("world").spawnEntity(AS2maintenanceloc, EntityType.ARMOR_STAND);
        freezeEntity(AS2maintenance);
        AS2maintenance.setCustomName(ChatColor.DARK_RED + "Maintenance");
        AS2maintenance.setCustomNameVisible(customConfig.get().getBoolean("lobby.maintenance.2"));



        //AS3
        Location AS3loc = new Location(Bukkit.getWorld("world"), 678.5, 128, -77.5, 0, 0);
        AS3 = Bukkit.getWorld("world").spawnEntity(AS3loc, EntityType.ARMOR_STAND);
        AS3.setCustomName(ChatColor.BLUE + "3");
        AS3.setCustomNameVisible(true);

        //AS3status
        Location AS3statusloc = new Location(Bukkit.getWorld("world"), 678.5, 128.25, -77.5, 0, 0);
        AS3status = Bukkit.getWorld("world").spawnEntity(AS3statusloc, EntityType.ARMOR_STAND);
        freezeEntity(AS3status);
        AS3status.setCustomName(customConfig.get().getString("lobby.AS.3"));
        AS3status.setCustomNameVisible(true);

        //AS3maintenance
        Location AS3maintenanceloc = new Location(Bukkit.getWorld("world"), 678.5, 128.5, -77.5, 0, 0);
        AS3maintenance = Bukkit.getWorld("world").spawnEntity(AS3maintenanceloc, EntityType.ARMOR_STAND);
        freezeEntity(AS3maintenance);
        AS3maintenance.setCustomName(ChatColor.DARK_RED + "Maintenance");
        AS3maintenance.setCustomNameVisible(customConfig.get().getBoolean("lobby.maintenance.3"));



        //AS4
        Location AS4loc = new Location(Bukkit.getWorld("world"), 681.5, 128, -76.5, 0, 0);
        AS4 = Bukkit.getWorld("world").spawnEntity(AS4loc, EntityType.ARMOR_STAND);
        AS4.setCustomName(ChatColor.BLUE + "4");
        AS4.setCustomNameVisible(true);

        //AS4status
        Location AS4statusloc = new Location(Bukkit.getWorld("world"), 681.5, 128.25, -76.5, 0, 0);
        AS4status = Bukkit.getWorld("world").spawnEntity(AS4statusloc, EntityType.ARMOR_STAND);
        freezeEntity(AS4status);
        AS4status.setCustomName(customConfig.get().getString("lobby.AS.4"));
        AS4status.setCustomNameVisible(true);

        //AS4maintenance
        Location AS4maintenanceloc = new Location(Bukkit.getWorld("world"), 681.5, 128.5, -76.5, 0, 0);
        AS4maintenance = Bukkit.getWorld("world").spawnEntity(AS4maintenanceloc, EntityType.ARMOR_STAND);
        freezeEntity(AS4maintenance);
        AS4maintenance.setCustomName(ChatColor.DARK_RED + "Maintenance");
        AS4maintenance.setCustomNameVisible(customConfig.get().getBoolean("lobby.maintenance.4"));



        //AS5
        Location AS5loc = new Location(Bukkit.getWorld("world"), 684.5, 128, -75.5, 0, 0);
        AS5 = Bukkit.getWorld("world").spawnEntity(AS5loc, EntityType.ARMOR_STAND);
        AS5.setCustomName(ChatColor.BLUE + "5");
        AS5.setCustomNameVisible(true);

        //AS5status
        Location AS5statusloc = new Location(Bukkit.getWorld("world"), 684.5, 128.25, -75.5, 0, 0);
        AS5status = Bukkit.getWorld("world").spawnEntity(AS5statusloc, EntityType.ARMOR_STAND);
        freezeEntity(AS5status);
        AS5status.setCustomName(customConfig.get().getString("lobby.AS.5"));
        AS5status.setCustomNameVisible(true);

        //AS5maintenance
        Location AS5maintenanceloc = new Location(Bukkit.getWorld("world"), 684.5, 128.5, -75.5, 0, 0);
        AS5maintenance = Bukkit.getWorld("world").spawnEntity(AS5maintenanceloc, EntityType.ARMOR_STAND);
        freezeEntity(AS5maintenance);
        AS5maintenance.setCustomName(ChatColor.DARK_RED + "Maintenance");
        AS5maintenance.setCustomNameVisible(customConfig.get().getBoolean("lobby.maintenance.5"));



        //ASDR
        Location ASDRloc = new Location(Bukkit.getWorld("world"), 678.5, 127, -54.5, 180, 0);
        ASDR = Bukkit.getWorld("world").spawnEntity(ASDRloc, EntityType.ARMOR_STAND);
        ASDR.setCustomName(ChatColor.BLUE + "Daily Reward");
        ASDR.setCustomNameVisible(true);

        //ASTTT
        Location ASTTTloc = new Location(Bukkit.getWorld("world"), 670, 127, -69, -90, 0);
        ASTTT = Bukkit.getWorld("world").spawnEntity(ASTTTloc, EntityType.ARMOR_STAND);
        ASTTT.setCustomName(ChatColor.BLUE + "Tic Tac Toe");
        ASTTT.setCustomNameVisible(true);



        //Scoreboard
        customConfig.reload();
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Name");
        Score score = objective.getScore("");
        score.setScore(10);
        Score score2 = objective.getScore("");
        score2.setScore(8);



        //Schedulers
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getOpenInventory().getTopInventory().getTitle().equals(ChatColor.GRAY + "Daily Reward")) {
                        if (customConfig.get().isSet(player.getUniqueId() + ".dr_timestamp")) {
                            customConfig.reload();
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
                            ItemStack item = player.getOpenInventory().getTopInventory().getItem(1);
                            if (item.getType().equals(Material.DIAMOND) || item.getType().equals(Material.COAL)) {
                                if (!((finish - now) < 0)) {
                                    ItemMeta meta = item.getItemMeta();
                                    meta.setLore(Arrays.asList("", "Next in " + shours + ":" + sminutes + ":" + sseconds));
                                    item.setItemMeta(meta);
                                    player.updateInventory();
                                } else {
                                    customConfig.get().set(player.getUniqueId() + ".dr_timestamp", null);
                                    customConfig.save();
                                }
                            }
                        } else {
                            player.getOpenInventory().setItem(1, new ItemStack(mkitem.mkitem(1, Material.DIAMOND, "Daily Reward", Arrays.asList("", "Click to get!"))));
                        }
                    } else if (player.getOpenInventory().getTopInventory().getTitle().equals("Waiting for opponent")) {
                        long start = customConfig.get().getLong(player.getUniqueId().toString() + ".ttt_q_t");
                        long now = Instant.now().getEpochSecond();
                        long seconds = (now - start) % 60;
                        long hours = (now - start) / 60;
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
                        String fynal = shours + ":" + sminutes + ":" + sseconds;
                        player.getOpenInventory().getTopInventory().setItem(13, mkitem.mkitem(0, Material.DIAMOND, fynal, Arrays.asList("")));
                    }
                }
            }
        }, 0L, 2L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                customConfig.reload();
                for (int i = 1; i < 6; i++) {
                    if (!(customConfig.get().getBoolean("lobby.maintenance." + i))) {
                        try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress(customConfig.get().getString("lobby.servers." + i), customConfig.get().getInt("lobby.servers." + i)), 15);
                            socket.close();
                            getAS("AS" + i + "status").setCustomName(ChatColor.BLUE + "ONLINE");
                        } catch (UnknownHostException e) {
                            getAS("AS" + i + "status").setCustomName(ChatColor.BLUE + "OFFLINE");
                        } catch (IOException e) {
                            getAS("AS" + i + "status").setCustomName(ChatColor.BLUE + "OFFLINE");
                        }
                    }
                }
            }
        }, 0L, 2L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (customConfig.get().getBoolean(player.getUniqueId() + ".edit")) {
                        if (!(player.hasPotionEffect(PotionEffectType.NIGHT_VISION))) {
                            player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(1000000, 255), true);
                        }
                    } else {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    }
                }
            }
        }, 0L, 1L);
    }

    @EventHandler
    public void onEntityMove(EntityInteractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        customConfig.reload();
        if (!(customConfig.get().isSet(player.getUniqueId() + ".coins"))) {
            customConfig.get().set(player.getUniqueId() + ".coins", 1000);
            customConfig.save();
        }
        Score score1 = objective.getScore("Coins: " + customConfig.get().get(player.getUniqueId() + ".coins"));
        score1.setScore(9);
        player.setScoreboard(board);
        player.setGameMode(GameMode.ADVENTURE);
        Location spawn = new Location(Bukkit.getWorld("world"), 678.5, 127.5, -61.5, 180, 0);
        player.teleport(spawn);
        player.setCanPickupItems(false);
        player.setWalkSpeed((float) 0.35);
        player.getInventory().setItem(0, mkitem.mkitem(1, Material.COMPASS, ChatColor.GRAY + "Server Selector", Arrays.asList("")));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        customConfig.get().set(e.getPlayer().getUniqueId() + ".edit", false);
        customConfig.save();
    }

    public void freezeEntity(Entity entity) {
        net.minecraft.server.v1_8_R3.Entity nmsen = ((CraftEntity) entity).getHandle();
        NBTTagCompound compound = new NBTTagCompound();
        nmsen.c(compound);
        compound.setByte("NoGravity", (byte) 1);
        compound.setByte("Invisible", (byte) 1);
        nmsen.f(compound);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        customConfig.reload();
        if (!(customConfig.get().getBoolean(e.getPlayer().getUniqueId() + ".edit"))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        customConfig.reload();
        if (!(customConfig.get().getBoolean(e.getPlayer().getUniqueId() + ".edit"))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvInteract(InventoryClickEvent e) {
        customConfig.reload();
        if (!(customConfig.get().getBoolean(e.getWhoClicked().getUniqueId() + ".edit"))) {
            e.setCancelled(true);
        }
    }

    public static Entity getAS(String type) {
        if (type.equals("AS1status")) {
            return AS1status;
        } else if (type.equals("AS2status")) {
            return AS2status;
        } else if (type.equals("AS3status")) {
            return AS3status;
        } else if (type.equals("AS4status")) {
            return AS4status;
        } else if (type.equals("AS5status")) {
            return AS5status;
        }/* else if (type.equals("AS1maintenance")) {

        } else if (type.equals("AS2maintenance")) {

        } else if (type.equals("AS3maintenance")) {

        } else if (type.equals("AS4maintenance")) {

        } else if (type.equals("AS5maintenance")) {

        }*/
        return null;
    }

}
