package kejax.listeners;

import kejax.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {

    private Main plugin;

    public ListenerManager(Main plugin) {
        this.plugin = plugin;
    }

    public void addListeners() {

        PluginManager pluginManager = Bukkit.getPluginManager();


        //Add Player Join/Leave Listeners
        pluginManager.registerEvents(new PlayerConnectionListener(plugin), plugin);

    }
}
