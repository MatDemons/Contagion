package fr.MatDemons.Contagion.Events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.Listener;

public class PlayerDropItem implements Listener {

    @EventHandler
    public void onItemDrop (PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.SURVIVAL) {
            e.setCancelled(true);
        }
    }
}