package kejax.commands;

import kejax.main.Main;
import kejax.utils.CountdownCommandCountdown;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CountdownCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Main.PERMISSION + "commands.countdown")) {
                try {
                    int length = Integer.valueOf(args[0]);
                    new CountdownCommandCountdown(length).start();
                } catch (Exception e) {
                    player.sendMessage("§7[§6§lCountdown§7]§r §4§l" + args[0] + " §r§cis not a valid number");
                }
            } else {
                player.sendMessage(Main.NO_PERMISSION_MSG);
            }
        }

        return true;
    }
}
