
package me.aqualenn.guardian;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SonicBoomCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)) return true;

        Player player = (Player)sender;
        if(!player.getName().equalsIgnoreCase("Aqualenn")) return true;

        for(Entity e : player.getNearbyEntities(15,15,15)){

            if(e instanceof LivingEntity && e != player){

                ((LivingEntity)e).damage(10,player);
                e.setVelocity(player.getLocation().getDirection().multiply(2));

            }
        }

        player.getWorld().spawnParticle(Particle.SONIC_BOOM, player.getEyeLocation(), 1);

        return true;
    }
}
