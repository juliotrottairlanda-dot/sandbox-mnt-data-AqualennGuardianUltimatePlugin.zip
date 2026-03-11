
package me.aqualenn.guardian;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class GuardianRageCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)) return true;

        Player player = (Player)sender;
        if(!player.getName().equalsIgnoreCase("Aqualenn")) return true;

        player.getWorld().spawnParticle(Particle.SCULK_CHARGE, player.getLocation(), 80);

        for(Entity e : player.getNearbyEntities(32,32,32)){
            if(e instanceof Warden) ((Warden)e).setTarget(null);
        }

        return true;
    }
}
