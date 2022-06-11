package kejax.listeners;

import kejax.languages.DE_de;
import kejax.main.Main;
import kejax.utils.MessageReplacer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectionListener implements Listener {

    private Main plugin;

    public PlayerConnectionListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

            String joinMessage = new MessageReplacer(DE_de.JOIN_MESSAGE).PSM(player).build();
            event.setJoinMessage(joinMessage);
    }
}
