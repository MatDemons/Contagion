package fr.MatDemons.Contagion.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class EntityTargetLivingEntity implements Listener {

    @EventHandler
    public void OnTarget( EntityTargetLivingEntityEvent e ){
        if(e.getEntity().getType() == EntityType.ZOMBIE){
            e.setCancelled(true);
        }
    }
}
