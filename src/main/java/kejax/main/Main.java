package kejax.main;

import kejax.listeners.ListenerManager;
import kejax.managers.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main plugin;

    public static String VERSION = "V0.3";

    public static String PREFIX = "§7[§l§cKejaxUtils§r§7] §r";
    public static String NO_PERMISSION_MSG = PREFIX + "§cDazu hast du keine Berechtigung!";

    public static String PERMISSION = "kejax.utils.";

    public static ConsoleCommandSender console = Bukkit.getConsoleSender();


    @Override
    public void onEnable() {
        plugin = this;

        new CommandManager(this);
        new ListenerManager(this);

        console.sendMessage("§aStarted §6Kejax Utils " + Main.VERSION + " §a!");
        saveDefaultConfig();
    }

    public static Main getPlugin() {return plugin;}

}
