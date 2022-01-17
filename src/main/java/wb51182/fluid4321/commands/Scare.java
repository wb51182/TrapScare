package wb51182.fluid4321.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import wb51182.fluid4321.Utils.ChatUtils;
import wb51182.fluid4321.Utils.PermUtils;

public class Scare implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(command.getLabel().equalsIgnoreCase("Scare")) {
            if(args.length == 0) {
                ChatUtils.Chat(p, "Not enough args");
            } else if (PermUtils.HasPerm(p, "trapscare.scare")) {
                Player p2 = Bukkit.getPlayer(args[0]);
                if (p2.getPlayer().isOnline()) {
                    Location loc = p2.getPlayer().getLocation().getBlock().getRelative(0, 0, 3).getLocation();
                    EntityType mob = EntityType.valueOf(args[1].toUpperCase());
                    try {
                        p2.getWorld().spawnEntity(loc, mob);
                        ChatUtils.Chat(p, "&cSummoning " + mob + " on " + p2.getPlayer().getDisplayName() + "." );
                    } catch (Exception ex) {
                        ChatUtils.Chat(p, "&cInvalid values");
                    }
                } else {
                    ChatUtils.Chat(p,  args[1] + " &c is not online.");
                }
            }
        }
        return false;
    }
}
