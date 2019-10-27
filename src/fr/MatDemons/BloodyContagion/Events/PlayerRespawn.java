package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.utile.ContagionTeleport;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn {
    @EventHandler
    public void onPlayerRespawn( PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        ContagionTeleport.Teleportation(p, Contagion.X_arene,Contagion.Z_arene,Contagion.R_arene+2,Contagion.R_arene+5);
        p.teleport(p.getLocation());
    }
}
