package wb51182.fluid4321.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import wb51182.fluid4321.commands.Trap;

public class OnBreak implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if(Trap.Trapped.containsKey(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
}
