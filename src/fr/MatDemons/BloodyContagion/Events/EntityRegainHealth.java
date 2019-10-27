package fr.MatDemons.Contagion.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityRegainHealth implements Listener {

    @EventHandler
    public void onHeal(EntityRegainHealthEvent e){
        if(e.getEntity() instanceof Player)
            e.setCancelled(true);
    }
}
