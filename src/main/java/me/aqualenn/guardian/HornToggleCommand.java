
package me.aqualenn.guardian;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class HornToggleCommand implements CommandExecutor {

    private static boolean horns = false;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)) return true;

        Player p = (Player)sender;
        if(!p.getName().equalsIgnoreCase("Aqualenn")) return true;

        horns = !horns;

        if(horns){
            p.getWorld().spawnParticle(Particle.SCULK_SOUL,p.getLocation().add(0,2.2,0),40);
        }

        return true;
    }
}
