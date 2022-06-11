package kejax.utils;

import kejax.main.Main;
import org.bukkit.Bukkit;

public class CountdownCommandCountdown extends Countdown{

    private int taskID;
    private int length;

    public CountdownCommandCountdown(int length) {
        this.length = length;
    }

    @Override
    public void start() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

            @Override
            public void run() {

                switch(length) {
                    default:
                        Bukkit.broadcastMessage("§7[§6§lCountdown§7]§r §6§l" + length);
                    case 0:
                        Bukkit.broadcastMessage("§7[§6§lCountdown§7]§r §c§lDer Countdown ist vorbei!");
                        stop();
                }
                length--;
            }
        },20, 0);
    }

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(taskID);
    }
}
