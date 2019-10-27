package fr.MatDemons.Contagion.game;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.utile.BloodyPlayer;
import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import fr.MatDemons.Contagion.utile.ContagionCoffre;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ContagionFIN {

    private static int timer;
    public static int getTimer() {
        return timer;
    }

    public static void start() {
        timer = 20;
        ContagionState.setState(ContagionState.FIN);
        ContagionCoffre.reset();

        Bukkit.getWorld("world").setTime(18000);
        Bukkit.getWorld( "world").setWeatherDuration(99999);

        for (BloodyPlayer p : BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers()){
            Player pl = p.getPlayer();
            pl.setGameMode(GameMode.SPECTATOR);
        }

        for (Entity e : Bukkit.getWorld("world").getEntities()){
            if(!(e instanceof Player))
                e.remove();
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (timer <= 0) {
                    ContagionATTEND.start();
                    cancel();
                    return;
                }
                else if(BloodyPlayerList.getBloodyPlayerlist().getPlayerCount() == 0){
                    ContagionATTEND.start();
                    cancel();
                    return;
                }
                else {
                    timer--;
                }
            }
        }.runTaskTimer(Contagion.instance, 0, 20);
    }
}
