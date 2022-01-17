package wb51182.fluid4321.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import wb51182.fluid4321.commands.Trap;

public class LoginLogout implements Listener {

    @EventHandler
    public void OnLogout(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if(Trap.Trapped.containsValue(e.getPlayer().getUniqueId())) {
            Trap.Trapped.remove(e.getPlayer().getUniqueId());
        } else {
            return;
        }
    }
}
