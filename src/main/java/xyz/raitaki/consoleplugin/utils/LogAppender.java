package xyz.raitaki.consoleplugin.utils;


import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.bukkit.Bukkit;
import xyz.raitaki.consoleplugin.ConsolePlugin;
import xyz.raitaki.consoleplugin.commands.StartCommand;

import java.util.Date;

public class LogAppender extends AbstractAppender {

    // your variables

    public LogAppender() {
        // do your calculations here before starting to capture
        super("MyLogAppender", null, null);
        start();
    }

    @Override
    public void append(LogEvent event) {
        // if you don`t make it immutable, than you may have some unexpected behaviours
        LogEvent log = event.toImmutable();

        // do what you have to do with the log

        // you can get only the log message like this:
        String message = log.getMessage().getFormattedMessage();

        // and you can construct your whole log message like this:
        ConsolePlugin.getViewer().addText(message);
    }

}