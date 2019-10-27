package fr.MatDemons.Contagion.game;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.utile.BloodyPlayer;
import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import fr.MatDemons.Contagion.utile.ContagionTeleport;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ContagionATTEND {

    private static int timer;
    public static int getTimer() {
        return timer;
    }

    public static void start(){
        timer = 30;
        ContagionState.setState(ContagionState.ATTEND);

        for (BloodyPlayer p : BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers()){
            Player pl = p.getPlayer();
            p.setAlive(true);
            pl.setGameMode(GameMode.SURVIVAL);
            pl.getInventory().clear();
            pl.setHealth(20);
            pl.setFoodLevel(20);
            BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(pl).setKill(0);

            ContagionTeleport.Teleportation(pl,Contagion.X_spawn,Contagion.Z_spawn,1,Contagion.R_spawn);
        }

        Bukkit.getWorld("world").setTime(18000);
        Bukkit.getWorld( "world").setWeatherDuration(99999);
        for (Entity e : Bukkit.getWorld("world").getEntities()){
            if(!(e instanceof Player))
                e.isDead();
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (timer <= 0) {
                    if (BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers().size() >= 1) {
                        ContagionGAME.start();
                        Bukkit.broadcastMessage("§a§lLa partie commence, bonne chance !");
                        Bukkit.broadcastMessage("§6§lTuez Tout les zombie, les coffres vous donnerons de meilllieurs armes ! ");
                        cancel();
                        return;
                    }
                    else {
                        Bukkit.broadcastMessage("§cPas assez de joueurs pour démarrer.");
                        timer = 30;
                    }
                }
                else {
                    if (Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers()) {
                        if (timer > 15) {
                            Bukkit.broadcastMessage("§aAssez de joueurs, démarrage rapide.");
                            timer = 15;
                        }
                    }
                    if (Bukkit.getOnlinePlayers().size() >= 1) {
                        timer--;
                    }
                    else{
                        timer = 30;
                    }
                }
            }
        }.runTaskTimer(Contagion.instance, 0, 20);
    }

}
