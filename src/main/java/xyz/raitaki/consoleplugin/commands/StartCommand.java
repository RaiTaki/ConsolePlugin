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


        /*TextDisplay text = p.getWorld().spawn(p.getLocation().add(0,2,0), TextDisplay.class);
        text.text(Component.text("Hello World!aaaaaaaaaaaaaaaa"));
        text.setBillboard(Display.Billboard.FIXED);
        text.setShadowed(true);
        text.setBackgroundColor(Color.AQUA.setAlpha(0));
        text.setDisplayHeight(1f);
        text.setDisplayWidth(1f);
        text.setTransformation(new Transformation(new Vector3f(0, 0, 0), new Quaternionf(0, 0, 0, 1), new Vector3f(0.5f, 0.5f, 4), new Quaternionf(0, 0, 0, 1)));
        new BukkitRunnable(){
            float f = 0;
            public void run() {
                f += 0.5f;
                Bukkit.broadcastMessage(Math.toRadians(f) + " " + f);
                Location loc = text.getLocation();
                loc.setYaw(f);
                loc.setPitch(f);
                text.teleport(loc);
            }
        }.runTaskTimerAsynchronously(ConsolePlugin.getInstance(), 0, 1);*/
        return false;
    }
}
