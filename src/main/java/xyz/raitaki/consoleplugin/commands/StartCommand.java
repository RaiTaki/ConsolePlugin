package xyz.raitaki.consoleplugin.commands;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import xyz.raitaki.consoleplugin.ConsolePlugin;
import xyz.raitaki.consoleplugin.ConsoleViewer;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player p)) return false;
            //p.teleport(ConsolePlugin.getViewer().getLocation());

        new BukkitRunnable(){
            @Override
            public void run() {
                ConsoleViewer viewer = ConsolePlugin.getViewer();
                Location loc = p.getLocation();
                loc.add(loc.getDirection().multiply(2)).add(0, 1+0.06*7, 0);
                loc.setYaw(loc.getYaw()+180);
                loc.setPitch(loc.getPitch());
                if(loc.getPitch() < 0){
                    loc.setPitch(Math.abs(loc.getPitch()));
                }
                else{
                    loc.setPitch(-loc.getPitch());
                }
                viewer.teleport(loc);
            }
        }.runTaskTimer(ConsolePlugin.getInstance(), 0, 1);
        return false;
    }
}
