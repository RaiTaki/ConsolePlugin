package xyz.raitaki.consoleplugin;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class ConsoleText {

    @Getter private String text;
    @Getter private boolean playing;
    private static ConsoleViewer viewer;

    public ConsoleText(String text){
        this.text = text;
        viewer = ConsolePlugin.getViewer();
    }

    public ConsoleText setText(String text){
        this.text = text;
        ConsolePlugin.getViewer().update();
        return this;
    }

    public ConsoleText setTextByTime(String text, int charPerSecond, boolean sound){
        playing = false;
        if(viewer == null){
            this.text = text;
            ConsolePlugin.getViewer().update();
            return this;
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                if(text.length() <= ConsoleText.this.text.length() + charPerSecond){
                    this.cancel();
                    ConsoleText.this.text = text;
                    playing = false;
                    viewer.update();
                    return;
                }
                else {
                    ConsoleText.this.text = text.substring(0, ConsoleText.this.text.length() + charPerSecond);
                }
                if(!isAnyTimerPlays() && sound){
                    viewer.getLocation().getWorld().playSound(viewer.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 0.6f);
                    playing = true;
                }
                viewer.update();
            }
        }.runTaskTimer(ConsolePlugin.getInstance(), 1,1);
        return this;
    }

    private boolean isAnyTimerPlays(){
        for(ConsoleText text : ConsolePlugin.getViewer().getTexts()){
            if(text.isPlaying()){
                if(text != this)
                    return true;
            }
        }
        return false;
    }
}
