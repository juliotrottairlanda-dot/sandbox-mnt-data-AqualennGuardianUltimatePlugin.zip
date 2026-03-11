
package me.aqualenn.guardian;

import org.bukkit.plugin.java.JavaPlugin;

public class AqualennGuardian extends JavaPlugin {

    private static AqualennGuardian instance;

    public static AqualennGuardian getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        getServer().getPluginManager().registerEvents(new MobProtectionListener(), this);
        getServer().getPluginManager().registerEvents(new CombatListener(), this);
        getServer().getPluginManager().registerEvents(new AbilityImmunityListener(), this);

        getCommand("sculkdash").setExecutor(new SculkDashCommand());
        getCommand("guardianrage").setExecutor(new GuardianRageCommand());
        getCommand("sonicboom").setExecutor(new SonicBoomCommand());
        getCommand("horns").setExecutor(new HornToggleCommand());

        getLogger().info("Aqualenn Guardian enabled.");
    }
}
