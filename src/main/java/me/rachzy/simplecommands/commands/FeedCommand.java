package me.rachzy.simplecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("simplecommands.feed")) {
                player.setFoodLevel(20);
                player.sendMessage("§aYour hungry bar has been fully filled!");
            } else {
                player.sendMessage("§cYou're not allowed to do that!");
            }

        } else {
            sender.sendMessage("§cThis command can only be executed by players!");
        }
        return true;
    }
}
