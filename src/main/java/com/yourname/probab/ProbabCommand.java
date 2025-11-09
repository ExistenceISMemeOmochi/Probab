package com.yourname.probab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ProbabCommand implements CommandExecutor {

    private final Probab plugin;

    public ProbabCommand(Probab plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        // Permission check
        if (!sender.hasPermission("probab.admin")) {
            sender.sendMessage("§c[Probab] You do not have permission to run this command.");
            return true;
        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("GravelToFlint")) {
            
            if (args.length == 2) {
                // --- /probab GravelToFlint <%> handler ---
                try {
                    int percentage = Integer.parseInt(args[1]);
                    if (percentage >= 0 && percentage <= 100) {
                        plugin.setFlintDropChance(percentage);
                        sender.sendMessage("§a[Probab] Gravel-to-Flint drop chance set to §e" + percentage + "%§a.");
                    } else {
                        sender.sendMessage("§c[Probab] Percentage must be a number between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage("§c[Probab] Invalid number. Please specify an integer.");
                }
            } else if (args.length == 1) {
                // --- /probab GravelToFlint (get current chance) handler ---
                int currentChance = plugin.getFlintDropChance();
                sender.sendMessage("§a[Probab] Current Gravel-to-Flint drop chance is §e" + currentChance + "%§a.");
            } else {
                 sender.sendMessage("§c[Probab] Usage: /probab GravelToFlint [0-100]");
            }
            return true;
        }
        
        // Command help
        sender.sendMessage("§6--- Probab Command Help ---");
        sender.sendMessage("§a/probab GravelToFlint [0-100]: Set or view the Flint drop chance.");
        return true;
    }
}
