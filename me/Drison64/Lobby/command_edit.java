package me.Drison64.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class command_edit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args[0].length() > 0) {
                if (args[1].length() > 1) {
                    if (args[1].equals("true")) {
                        customConfig.get().set(Bukkit.getPlayer(args[0]).getUniqueId() + ".edit", true);
                        customConfig.save();
                    } else if (args[1].equals("false")) {
                        customConfig.get().set(Bukkit.getPlayer(args[0]).getUniqueId() + ".edit", false);
                        customConfig.save();
                    }
                } else {
                    sender.sendMessage("Example: /edit <name> <true/false>");
                }
            } else {
                sender.sendMessage("Example: /edit <name> <true/false>");
            }
        } else {
            sender.sendMessage("This command is only for console");
        }

        return false;
    }

}
