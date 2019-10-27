package fr.MatDemons.Contagion.utile;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BloodyPlayerList {

    private  static BloodyPlayerList instance;
    private  ArrayList<BloodyPlayer> bloodyPlayerListe;

    private BloodyPlayerList(){
       this.bloodyPlayerListe = new ArrayList<BloodyPlayer>();
    }

    public static BloodyPlayerList getBloodyPlayerlist() {
        if (instance == null) {
            instance = new BloodyPlayerList();
        }
        return instance;
    }

    public  void removePlayer(Player p) {
       this.bloodyPlayerListe.removeIf(bloodyPlayer -> bloodyPlayer.getPlayer() == p);
    }

    public  ArrayList<BloodyPlayer> getBloodyPlayers() {
        return  bloodyPlayerListe;
    }

    public BloodyPlayer getBloodyPlayer(Player p) {
        return this.bloodyPlayerListe.stream().filter(bloodyPlayer -> bloodyPlayer.getPlayer() == p).findFirst().get();
    }

    public int getAlivePlayerCount() {
        return (int) this.bloodyPlayerListe.stream().filter(bloodyPlayer -> bloodyPlayer.isAlive()).count();
    }

    public int getPlayerCount() {
        return this.bloodyPlayerListe.size();
    }
}
