
package me.aqualenn.guardian;

import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class MobProtectionListener implements Listener {

    @EventHandler
    public void onTarget(EntityTargetEvent e) {
        if(!(e.getTarget() instanceof Player)) return;
        Player p = (Player)e.getTarget();
        if(p.getName().equalsIgnoreCase("Aqualenn")) e.setCancelled(true);
    }
}
