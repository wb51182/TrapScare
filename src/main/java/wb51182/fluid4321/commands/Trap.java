package wb51182.fluid4321.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wb51182.fluid4321.Utils.ChatUtils;
import wb51182.fluid4321.Utils.PermUtils;

import java.util.HashMap;
import java.util.UUID;

public class Trap implements CommandExecutor {

    public static HashMap<UUID, Boolean> Trapped = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getLabel().equalsIgnoreCase("Trap")) {
            if (args.length == 0) {
                ChatUtils.Chat(p, "Not enough args");
            } else if (PermUtils.HasPerm(p, "trapscare.trap")) {
                // Directions are not going to always be left/right depends on what way you face but makes it easier to understand
                Player p2 = Bukkit.getPlayer(args[0]);
                if (p2.getPlayer().isOnline()) {
                    // More efficient ways to do this but this command will hardly ever be run so no point optimizing
                    Location Below = p2.getPlayer().getLocation().getBlock().getRelative(0, -1, 0).getLocation();
                    Location Above = p2.getPlayer().getLocation().getBlock().getRelative(0, 2, 0).getLocation();
                    Location BehindB = p2.getPlayer().getLocation().getBlock().getRelative(-1, 0, 0).getLocation();
                    Location InfrontB = p2.getPlayer().getLocation().getBlock().getRelative(1, 0, 0).getLocation();
                    Location BehindT = p2.getPlayer().getLocation().getBlock().getRelative(-1, 1, 0).getLocation();
                    Location InfrontT = p2.getPlayer().getLocation().getBlock().getRelative(1, 1, 0).getLocation();
                    Location LeftB = p2.getPlayer().getLocation().getBlock().getRelative(0, 0, -1).getLocation();
                    Location RightB = p2.getPlayer().getLocation().getBlock().getRelative(0, 0, 1).getLocation();
                    Location LeftT = p2.getPlayer().getLocation().getBlock().getRelative(0, 1, -1).getLocation();
                    Location RightT = p2.getPlayer().getLocation().getBlock().getRelative(0, 1, 1).getLocation();
                    Below.getBlock().setType(Material.GLASS);
                    Above.getBlock().setType(Material.GLASS);
                    BehindB.getBlock().setType(Material.GLASS);
                    InfrontB.getBlock().setType(Material.GLASS);
                    BehindT.getBlock().setType(Material.GLASS);
                    InfrontT.getBlock().setType(Material.GLASS);
                    LeftB.getBlock().setType(Material.GLASS);
                    RightB.getBlock().setType(Material.GLASS);
                    LeftT.getBlock().setType(Material.GLASS);
                    RightT.getBlock().setType(Material.GLASS);
                    Location TpLoc = Below.getBlock().getRelative(0,1, 0).getLocation();
                    TpLoc.setX(Below.getBlockX()+0.5);
                    TpLoc.setZ(Below.getBlockZ()+0.5);
                    p.teleport(TpLoc);
                    ChatUtils.Chat(p, "&cTrapped: " + args[0]);
                    Trapped.put(p.getPlayer().getUniqueId(), Boolean.TRUE);
                    System.out.println(Trapped);
                } else {
                    ChatUtils.Chat(p,  args[0] + " &c is not online.");
                }

            }
        }
        return false;
    }
}
