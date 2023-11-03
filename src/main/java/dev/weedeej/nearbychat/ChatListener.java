package dev.weedeej.nearbychat;

import dev.weedeej.nearbychat.files.CustomConfig;
import io.papermc.paper.event.player.ChatEvent;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.RGBLike;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getServer;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(ChatEvent event) {
        event.setCancelled(true);
        TextComponent component = (TextComponent) event.message();
        Player sender = event.getPlayer();
        String senderName = sender.getName();
        String message = component.content();
        if (message.startsWith("$")) {
            TextComponent textComponent = Component.text()
                .content("[SHOUT] "+senderName+": "+message.substring(1))
                .color(TextColor.color(255, 132, 0))
                .build();
            Bukkit.getServer().sendMessage(textComponent.asComponent());
            return;
        }
        double range = CustomConfig.get().getDouble("chatRange");
        sender.sendMessage("[GENERAL] "+senderName+": "+message);
        for (Entity e : sender.getNearbyEntities(range, range, range)){
            if (e instanceof Player){
                e.sendMessage("[GENERAL] "+senderName+": "+message);
            }
        }
    }
}
