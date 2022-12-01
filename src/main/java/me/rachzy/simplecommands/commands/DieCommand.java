package me.rachzy.simplecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.setHealth(0);
            player.sendMessage(String.format("§cRest in peace, %s...", player.getName()));
        } else {
            sender.sendMessage("§cOnly players can execute this command!");
        }

        return true;
    }
}
