package kejax.commands;

import kejax.main.Main;
import kejax.utils.ConfigLocationUtil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private Main plugin;

    public SpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ConfigLocationUtil locationUtil = new ConfigLocationUtil(plugin, "locations.spawn");
            Location location = locationUtil.load();
            if(location != null) {
                player.teleport(location);
                player.sendMessage(Main.PREFIX + "§aDu wurdest zum Spawn teleportiert!");
            } else player.sendMessage(Main.PREFIX + "§cEs wurde bisher kein Spawn gesetzt!");
        }
        return true;
    }
}
