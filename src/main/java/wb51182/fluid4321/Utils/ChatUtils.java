package wb51182.fluid4321.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static void Chat(Player player, String message) {
        player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
