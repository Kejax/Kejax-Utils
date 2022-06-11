package kejax.utils;

import kejax.languages.BaseLanguage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageReplacer {

    private String message;
    private BaseLanguage language;

    public MessageReplacer(BaseLanguage language) {
        this.language = language;
        this.message = language.get_message();

        //Replacing all "ALL" variables
        this.message.replaceAll("%max_players%", String.valueOf(Bukkit.getMaxPlayers()));
        this.message.replaceAll("%player_count%", String.valueOf(Bukkit.getOnlinePlayers().size()));

    }

    public String build() {
        return this.message;
    }

    //Replaces all PSM Variables
    public MessageReplacer PSM(Player player) {
        this.message.replaceAll("%player%", player.getName());
        return this;
    }
}
