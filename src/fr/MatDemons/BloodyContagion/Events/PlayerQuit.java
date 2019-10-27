package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void quit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        BloodyPlayerList.getBloodyPlayerlist().removePlayer(p);
    }
}
