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

public class UnTrap implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getLabel().equalsIgnoreCase("untrap")) {
            if (args.length == 0) {
                ChatUtils.Chat(p, "Not enough args");
            } else if (PermUtils.HasPerm(p, "trapscare.untrap")) {
                // Directions are not going to always be left/right depends on what way you face but makes it easier to understand
                System.out.println("0");
                Player p2 = Bukkit.getPlayer(args[0]);
                if (Trap.Trapped.containsKey(p2.getPlayer().getUniqueId())) {
                    System.out.println("here");
                    if (p2.getPlayer().isOnline()) {
                        System.out.println("1");
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
                        Below.getBlock().setType(Material.AIR);
                        Above.getBlock().setType(Material.AIR);
                        BehindB.getBlock().setType(Material.AIR);
                        InfrontB.getBlock().setType(Material.AIR);
                        BehindT.getBlock().setType(Material.AIR);
                        InfrontT.getBlock().setType(Material.AIR);
                        LeftB.getBlock().setType(Material.AIR);
                        RightB.getBlock().setType(Material.AIR);
                        LeftT.getBlock().setType(Material.AIR);
                        RightT.getBlock().setType(Material.AIR);
                        ChatUtils.Chat(p, "&cUn-Trapped: " + args[0]);
                        Trap.Trapped.remove(p.getPlayer().getUniqueId());
                    } else {
                        ChatUtils.Chat(p, args[0] + " &c is not online.");
                    }
                } else {
                    ChatUtils.Chat(p, args[0] + " &c is not trapped.");
                }
            }
        }
        return false;
    }
}
