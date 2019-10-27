package fr.MatDemons.Contagion.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class Combust implements Listener {

    @EventHandler
    public void onCombust( EntityCombustEvent e) {
        e.setCancelled(true);
    }
}
