package wb51182.fluid4321;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import wb51182.fluid4321.commands.Scare;
import wb51182.fluid4321.commands.Trap;
import wb51182.fluid4321.commands.UnTrap;
import wb51182.fluid4321.listeners.LoginLogout;
import wb51182.fluid4321.listeners.OnBreak;

public final class TrapScare extends JavaPlugin {

    private static TrapScare instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("Scare").setExecutor(new Scare());
        getCommand("Trap").setExecutor(new Trap());
        getCommand("UnTrap").setExecutor(new UnTrap());

        getServer().getPluginManager().registerEvents(new LoginLogout(), this);
        getServer().getPluginManager().registerEvents(new OnBreak(), this);
    }
    public TrapScare getInstance() {
        return instance;

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
