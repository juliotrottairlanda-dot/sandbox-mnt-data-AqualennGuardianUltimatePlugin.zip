
package me.aqualenn.guardian;

import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class AbilityImmunityListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){

        if(!(e.getEntity() instanceof Player)) return;

        Player p = (Player)e.getEntity();
        if(!p.getName().equalsIgnoreCase("Aqualenn")) return;

        if(e.getCause() == EntityDamageEvent.DamageCause.SONIC_BOOM ||
           e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION){

            e.setCancelled(true);

        }
    }
}
