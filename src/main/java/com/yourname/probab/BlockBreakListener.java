package com.yourname.probab;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    private final Probab plugin;
    private final java.util.Random random = new java.util.Random();

    public BlockBreakListener(Probab plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Check if the broken block is Gravel
        if (event.getBlock().getType() == Material.GRAVEL) {
            
            // Clear existing drops (Vanilla drops are handled manually)
            event.setDropItems(false);

            // Get the configured chance
            int chance = plugin.getFlintDropChance();

            // Probability check (random number 0-99 is less than the chance)
            if (random.nextInt(100) < chance) {
                // Success: Drop Flint
                event.getBlock().getWorld().dropItemNaturally(
                    event.getBlock().getLocation(), 
                    new ItemStack(Material.FLINT, 1)
                );
            } else {
                // Failure: Drop Gravel (Vanilla behavior)
                event.getBlock().getWorld().dropItemNaturally(
                    event.getBlock().getLocation(), 
                    new ItemStack(Material.GRAVEL, 1)
                );
            }
        }
    }
}
