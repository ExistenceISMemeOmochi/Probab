package com.yourname.probab;

import org.bukkit.plugin.java.JavaPlugin;

public final class Probab extends JavaPlugin {
    
    private int flintDropChance = 10; // Default chance (10% is close to vanilla)

    @Override
    public void onEnable() {
        // Create config file if it doesn't exist
        saveDefaultConfig();
        loadConfigValues();

        // Register Command Executor
        getCommand("probab").setExecutor(new ProbabCommand(this));

        // Register Event Listener
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);

        getLogger().info("Probab Plugin has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Probab Plugin has been successfully disabled.");
    }

    // --- Configuration Logic ---

    private void loadConfigValues() {
        // Load the chance from config.yml, defaulting to 10 if the key is missing
        this.flintDropChance = getConfig().getInt("drop.gravel_to_flint", 10);
    }
    
    // Getter for the chance
    public int getFlintDropChance() {
        return flintDropChance;
    }

    // Setter for the chance, also saves to config.yml
    public void setFlintDropChance(int percentage) {
        this.flintDropChance = percentage;
        getConfig().set("drop.gravel_to_flint", percentage);
        saveConfig();
        getLogger().info("Gravel-to-Flint chance updated to " + percentage + "% and saved to config.");
    }
}
