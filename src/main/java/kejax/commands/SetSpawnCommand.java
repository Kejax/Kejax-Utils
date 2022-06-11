package kejax.commands;

import kejax.main.Main;
import kejax.utils.ConfigLocationUtil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private Main plugin;

    public SetSpawnCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission(Main.PERMISSION + "commands.setspawn")) {
                if(args.length > 0) player.sendMessage("§cBitte benutze §4/setspawn§c!");
                else if(args.length == 0) {
                    Location location = player.getLocation();
                    new ConfigLocationUtil(plugin, location, "locations.spawn");
                    player.sendMessage(Main.PREFIX + "§aDer Spawn wurde erfolgreich gesetzt");
                }
            } else player.sendMessage(Main.NO_PERMISSION_MSG);
        } else sender.sendMessage(Main.PREFIX + "§cDies ist ein Spielerbefehl!");
        return true;
    }
}
