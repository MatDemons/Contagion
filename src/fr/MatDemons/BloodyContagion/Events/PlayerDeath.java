package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(p).setAlive(false);
    }
}
