package kejax.commands;

import kejax.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionCommand implements CommandExecutor {

    private PotionEffect nightVision = new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 255, true, false);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission(Main.PERMISSION + ".command.nightvision")) {
                if(args.length == 0) {
                    player.addPotionEffect(nightVision);
                    player.sendMessage(Main.PREFIX + "§aDu hast dir Nightvision gegeben.");
                } else if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null) {
                        player.sendMessage(Main.PREFIX + "§c Esgibt keinen Spieler " + args[0] + " der gerade online ist.");
                    } else {
                        target.addPotionEffect(nightVision);
                        target.sendMessage(Main.PREFIX + "§aDir wurde von " + player.getName() + " Nachtsicht gegeben");
                        player.sendMessage(Main.PREFIX + "§aDu hast " + target.getName() + " Nachtsicht gegeben");
                    }
                }
            } else player.sendMessage(Main.NO_PERMISSION_MSG);
        } else sender.sendMessage(Main.PREFIX + "Dies ist ein Spielerbefehl!");
        return true;
    }
}
