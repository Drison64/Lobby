package me.Drison64.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class command_getuuid implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args[0].length() > 0) {
                if (Bukkit.getPlayer(args[0]).isOnline()) {
                    sender.sendMessage(Bukkit.getPlayer(args[0]).getUniqueId().toString());
                }
            }
        }
        return false;
    }

}
