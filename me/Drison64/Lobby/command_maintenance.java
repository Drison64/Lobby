package me.Drison64.Lobby;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class command_maintenance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args[0].equals("true")) {
                if (args[1].length() > 0) {
                    if (args[2].length() > 0) {
                        if (args[1].equals("1")) {
                            customConfig.get().set("lobby.maintenance.1", true);
                            customConfig.save();
                            Main.AS1maintenance.setCustomNameVisible(true);
                            String text = "";
                            for (int i = 2; i < args.length; ++i) {
                                text = text + " " + args[i];
                            }
                            text = text.replace("&", "§");
                            Main.AS1status.setCustomName(text.substring(1));
                            Main.AS1status.setCustomNameVisible(true);
                            customConfig.get().set("lobby.AS.1", text);
                            customConfig.save();
                        } else if (args[1].equals("2")) {
                            customConfig.get().set("lobby.maintenance.2", true);
                            customConfig.save();
                            Main.AS2maintenance.setCustomNameVisible(true);
                            String text = "";
                            for (int i = 2; i < args.length; ++i) {
                                text = text + " " + args[i];
                            }
                            text = text.replace("&", "§");
                            Main.AS2status.setCustomName(text.substring(1));
                            Main.AS2status.setCustomNameVisible(true);
                            customConfig.get().set("lobby.AS.2", text);
                            customConfig.save();
                        } else if (args[1].equals("3")) {
                            customConfig.get().set("lobby.maintenance.3", true);
                            customConfig.save();
                            Main.AS3maintenance.setCustomNameVisible(true);
                            String text = "";
                            for (int i = 2; i < args.length; ++i) {
                                text = text + " " + args[i];
                            }
                            text = text.replace("&", "§");
                            Main.AS3status.setCustomName(text.substring(1));
                            Main.AS3status.setCustomNameVisible(true);
                            customConfig.get().set("lobby.AS.3", text);
                            customConfig.save();
                        } else if (args[1].equals("4")) {
                            customConfig.get().set("lobby.maintenance.4", true);
                            customConfig.save();
                            Main.AS4maintenance.setCustomNameVisible(true);
                            String text = "";
                            for (int i = 2; i < args.length; ++i) {
                                text = text + " " + args[i];
                            }
                            text = text.replace("&", "§");
                            Main.AS4status.setCustomName(text.substring(1));
                            Main.AS4status.setCustomNameVisible(true);
                            customConfig.get().set("lobby.AS.4", text);
                            customConfig.save();
                        } else if (args[1].equals("5")) {
                            customConfig.get().set("lobby.maintenance.5", true);
                            customConfig.save();
                            Main.AS5maintenance.setCustomNameVisible(true);
                            String text = "";
                            for (int i = 2; i < args.length; ++i) {
                                text = text + " " + args[i];
                            }
                            text = text.replace("&", "§");
                            Main.AS5status.setCustomName(text.substring(1));
                            Main.AS5status.setCustomNameVisible(true);
                            customConfig.get().set("lobby.AS.5", text);
                            customConfig.save();
                        }
                    }
                } else {
                    sender.sendMessage("/maintenance <on/off> <1/2/3/4/5>");
                }
            } else if (args[0].equals("false")) {
                if (args[1].length() > 0) {
                    if (args[1].equals("1")) {
                        customConfig.get().set("lobby.maintenance.1", false);
                        customConfig.save();
                        Main.AS1maintenance.setCustomNameVisible(false);
                    } else if (args[1].equals("2")) {
                        customConfig.get().set("lobby.maintenance.2", false);
                        customConfig.save();
                        Main.AS2maintenance.setCustomNameVisible(false);
                    } else if (args[1].equals("3")) {
                        customConfig.get().set("lobby.maintenance.3", false);
                        customConfig.save();
                        Main.AS3maintenance.setCustomNameVisible(false);
                    } else if (args[1].equals("4")) {
                        customConfig.get().set("lobby.maintenance.4", false);
                        customConfig.save();
                        Main.AS4maintenance.setCustomNameVisible(false);
                    } else if (args[1].equals("5")) {
                        customConfig.get().set("lobby.maintenance.5", false);
                        customConfig.save();
                        Main.AS5maintenance.setCustomNameVisible(false);
                    }
                } else {
                    sender.sendMessage("/maintenance <on/off> <1/2/3/4/5>");
                }
            }
        }
        return false;
    }
}
