package kejax.managers;

import kejax.commands.CountdownCommand;
import kejax.commands.NightVisionCommand;
import kejax.commands.SetSpawnCommand;
import kejax.commands.SpawnCommand;
import kejax.main.Main;

public class CommandManager {

    public CommandManager(Main plugin) {


        //NightVision Command
        plugin.getCommand("nightvision").setExecutor(new NightVisionCommand());

        //SetSpawn Command
        plugin.getCommand("setspawn").setExecutor(new SetSpawnCommand(plugin));

        //Spawn Command
        plugin.getCommand("spawn").setExecutor(new SpawnCommand(plugin));

        //Countdown Command
        plugin.getCommand("countdown").setExecutor(new CountdownCommand());

    }
}
