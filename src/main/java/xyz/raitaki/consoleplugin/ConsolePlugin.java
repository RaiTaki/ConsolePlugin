package xyz.raitaki.consoleplugin;

import lombok.Getter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.raitaki.consoleplugin.commands.StartCommand;
import xyz.raitaki.consoleplugin.utils.LogAppender;

public final class ConsolePlugin extends JavaPlugin {

    @Getter private static ConsolePlugin instance;
    @Getter private static ConsoleViewer viewer;
    private Logger logger;
    private LogAppender appender;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getCommand("start").setExecutor(new StartCommand());
        viewer = new ConsoleViewer(new Location(Bukkit.getWorld("world"), -52,118,18));

        logger = (Logger) LogManager.getRootLogger();
        appender = new LogAppender();
        logger.addAppender(appender);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.removeAppender(appender);
        viewer.removeDisplays();
    }
}
