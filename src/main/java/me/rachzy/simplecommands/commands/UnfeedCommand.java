package me.rachzy.simplecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnfeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("simplecommands.unfeed")) {
                player.setFoodLevel(0);
                player.sendMessage("§eYou better eat something now, buddy");
            } else {
                player.sendMessage("§cYou're not allowed to do that!");
            }

        } else {
            sender.sendMessage("§cOnly players can execute this command!");
        }
        return true;
    }
}
