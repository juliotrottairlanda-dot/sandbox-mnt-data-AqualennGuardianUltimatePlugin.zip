
package me.aqualenn.guardian;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SculkDashCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)) return true;

        Player player = (Player)sender;
        if(!player.getName().equalsIgnoreCase("Aqualenn")) return true;

        Vector dash = player.getLocation().getDirection().multiply(3);
        player.setVelocity(dash);

        new BukkitRunnable(){

            int ticks = 0;

            public void run(){

                if(ticks > 20){
                    cancel();
                    return;
                }

                Location loc = player.getLocation();

                for(double t=-1.5;t<=1.5;t+=0.2){

                    double y = Math.pow(t,2)*0.4;

                    Location l = loc.clone().add(-t,y,0);
                    Location r = loc.clone().add(t,y,0);

                    player.getWorld().spawnParticle(Particle.SCULK_SOUL,l,3);
                    player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME,r,3);

                }

                ticks++;

            }

        }.runTaskTimer(AqualennGuardian.getInstance(),0,1);

        return true;
    }
}
