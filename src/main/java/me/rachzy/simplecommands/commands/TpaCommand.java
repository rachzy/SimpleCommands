package me.rachzy.simplecommands.commands;

import me.rachzy.simplecommands.SimpleCommands;
import me.rachzy.simplecommands.models.TeleportRequest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can execute this command!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§cUse: /tpa (:player_nick)");
            return true;
        }

        Player playerSender = (Player) sender;

        if(playerSender.getDisplayName().equals(args[0])) {
            sender.sendMessage("§cYou can't send a TPA request to yourself!");
            return true;
        }

        Player playerTarget = playerSender
                .getServer()
                .getOnlinePlayers()
                .stream()
                .filter(player -> player.getDisplayName().equals(args[0]))
                .findFirst()
                .orElse(null);

        if (playerTarget == null) {
            playerSender.sendMessage("§cWe couldn't find a player with that nickname...");
            return true;
        }

        SimpleCommands.addTpaRequest(new TeleportRequest(playerSender.getDisplayName(), playerTarget.getDisplayName()));

        playerTarget.sendMessage(String.format("§a%s §esent yah a TPA Request!", playerSender.getDisplayName()));
        playerSender.sendMessage(String.format("§7Your TPA request was sent to §a%s.", playerTarget.getDisplayName()));

        return true;
    }
}
