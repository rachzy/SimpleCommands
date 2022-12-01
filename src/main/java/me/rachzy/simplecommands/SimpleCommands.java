package me.rachzy.simplecommands;

import me.rachzy.simplecommands.commands.*;
import me.rachzy.simplecommands.models.TeleportRequest;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public final class SimpleCommands extends JavaPlugin {

    private static List<TeleportRequest> TpaRequests;

    @Override
    public void onEnable() {
        // Plugin start logic

        TpaRequests = new ArrayList<TeleportRequest>();

        System.out.println("§aEnabling rachzy SimpleCommands plugin...");

        getCommand("die").setExecutor(new DieCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("unfeed").setExecutor(new UnfeedCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpaccept").setExecutor(new TpaAcceptCommand());
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("§cDisabling rachzy SimpleCommands plugin...");
    }

    public static List<TeleportRequest> getTpaRequests() {
        return TpaRequests;
    }

    public static void addTpaRequest(TeleportRequest newTeleportRequest) {
        TpaRequests.add(newTeleportRequest);
    }
}
