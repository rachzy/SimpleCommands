package me.rachzy.simplecommands.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can execute this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("simplecommands.gm")) {
            player.sendMessage("§cYou don't have permission to execute this command!");
            return true;
        }

        if(args.length == 0) {
            player.sendMessage("§cUse: /gm (:gamemode)");
            return true;
        }

        String gamemode = args[0].toLowerCase();
        System.out.println(gamemode);

        if(gamemode.equals("0") || gamemode.equals("survival")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§aYour gamemode has been set to survival.");
            return true;
        }

        if(gamemode.equals("1") || gamemode.equals("creative")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage("§aYour gamemode has been set to creative.");
            return true;
        }

        if(gamemode.equals("2") || gamemode.equals("adventure")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage("§aYour gamemode has been set to adventure.");
            return true;
        }

        if(gamemode.equals("3") || gamemode.equals("spectator")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("§aYour gamemode has been set to spectator.");
            return true;
        }

        player.sendMessage("§cInvalid gamemode!");
        return true;
    }
}
