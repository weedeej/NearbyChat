package dev.weedeej.nearbychat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class Utilities {

    public static ArrayList<Player> getNearbyPlayers(Player pl, double range){
        ArrayList<Player> nearby = new ArrayList<Player>();
        for (Entity e : pl.getNearbyEntities(range, range, range)){
            if (e instanceof Player){
                nearby.add((Player) e);
            }
        }
        return nearby;
    }
}
