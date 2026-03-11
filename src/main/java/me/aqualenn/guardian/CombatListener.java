
package me.aqualenn.guardian;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class CombatListener implements Listener {

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e){

        if(!(e.getDamager() instanceof Player)) return;
        Player player = (Player)e.getDamager();

        if(!player.getName().equalsIgnoreCase("Aqualenn")) return;
        if(!(e.getEntity() instanceof Player)) return;

        Player target = (Player)e.getEntity();

        for(Entity ent : player.getNearbyEntities(32,32,32)){
            if(ent instanceof Warden) ((Warden)ent).setTarget(target);
            if(ent instanceof Wither) ((Wither)ent).setTarget(target);
        }
    }
}
