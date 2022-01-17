package wb51182.fluid4321.Utils;

import org.bukkit.entity.Player;

public class PermUtils {
    public static boolean HasPerm(Player player, String permission) {
        if (player.getPlayer().hasPermission(permission)) {
            return true;
        } else {
            ChatUtils.Chat(player, "&cNo permission.");
            return false;
        }
    }
}
