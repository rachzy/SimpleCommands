package me.rachzy.simplecommands.commands;

import me.rachzy.simplecommands.SimpleCommands;
import me.rachzy.simplecommands.models.TeleportRequest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class TpaAcceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cThis command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;
        List<TeleportRequest> TpaRequestList = SimpleCommands.getTpaRequests();
        TeleportRequest getPlayerTpaRequest =
                TpaRequestList
                .stream()
                .filter(request -> request.getTargetUsername().equals(player.getDisplayName()))
                .findFirst()
                .orElse(null);

        if(getPlayerTpaRequest == null) {
            player.sendMessage("§cThere are no TPA requests for you!");
            return true;
        }

        Player tpaSender = player
                .getServer()
                .getOnlinePlayers()
                .stream()
                .filter(onlinePlayer -> onlinePlayer.getDisplayName().equals(getPlayerTpaRequest.getSenderUsername()))
                .findFirst()
                .orElse(null);

        System.out.println(getPlayerTpaRequest.checkIfRequestIsStillValid());

      if(!getPlayerTpaRequest.checkIfRequestIsStillValid()) {
            player.sendMessage("§cThe TPA request has expired...");
            return true;
      }

        if(tpaSender == null) {
            player.sendMessage("§cThis player is no longer online...");
            return true;
        }

        tpaSender.teleport(player.getLocation());
        tpaSender.sendMessage(String.format("§e%s has accepted your TPA request.", player.getDisplayName()));
        player.sendMessage(String.format("§eYou've accepted the TPA request from §a%s.", tpaSender.getDisplayName()));
        return true;
    }
}
