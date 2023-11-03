package dev.weedeej.nearbychat;

import dev.weedeej.nearbychat.files.CustomConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public final class NearbyChat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // register events
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

        // Setup config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Custom Config
        CustomConfig.setup();
        CustomConfig.get().addDefault("chatRadius", 10);
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

        Bukkit.getLogger().info(this.getName() + " Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(this.getName() + "Disabled!");
    }

//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        if (cmd.getName().equalsIgnoreCase("shout")) {
//
//        }
//        return true;
//    }
}
