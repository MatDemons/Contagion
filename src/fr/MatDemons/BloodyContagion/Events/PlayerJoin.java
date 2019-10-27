package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.game.ContagionState;
import fr.MatDemons.Contagion.utile.BloodyPlayer;
import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import fr.MatDemons.Contagion.utile.ContagionTeleport;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e){

        Player p = e.getPlayer();
        BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers().add(new BloodyPlayer(e.getPlayer()));
        p.getInventory().clear();
        p.setHealth(20);
        p.setFoodLevel(20);
        ContagionTeleport.Teleportation(p, Contagion.X_spawn,Contagion.Z_spawn,1,Contagion.R_spawn);
        p.setGameMode(GameMode.SURVIVAL);
        if(ContagionState.isState(ContagionState.ATTEND))
            Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.AQUA + " à rejoind le Contagion (" + BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers().size() + "/" + Bukkit.getServer().getMaxPlayers() + ")");
        else {
            p.setGameMode(GameMode.SPECTATOR);
            BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(p).setAlive(false);
        }
    }
}
