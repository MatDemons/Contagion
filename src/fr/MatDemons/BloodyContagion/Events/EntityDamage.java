package fr.MatDemons.Contagion.Events;


import fr.MatDemons.Contagion.game.ContagionState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void onBreak( EntityDamageEvent e) {
        if((ContagionState.getState() == ContagionState.ATTEND) || (ContagionState.getState() == ContagionState.FIN))
            e.setCancelled(true);
    }
}
