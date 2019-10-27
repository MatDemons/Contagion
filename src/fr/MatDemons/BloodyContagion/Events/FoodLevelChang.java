package fr.MatDemons.Contagion.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChang implements Listener{

    @EventHandler
    public void onFood( FoodLevelChangeEvent e) {
        if( e.getEntity() instanceof Player)
            e.setCancelled(true);
        }
}

