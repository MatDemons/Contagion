package fr.MatDemons.Contagion;


import fr.MatDemons.Contagion.Events.EventsManager;
import fr.MatDemons.Contagion.Scoreboard.ScoreBoardDisplayer;
import fr.MatDemons.Contagion.game.ContagionATTEND;
import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import fr.MatDemons.Contagion.utile.ContagionCoffre;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class BloodyContagion extends JavaPlugin{

    public static Contagion instance;
    public static int X_spawn = 624;
    public static int Z_spawn = -1508;
    public static int R_spawn = 2;

    public static int X_arene = 595;
    public static int Z_arene = -1562;
    public static int R_arene = 26;
    public ArrayList<UUID> playerInGame = new ArrayList<>();
    public static Contagion getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        System.out.println("[Contagion] --> plugin ON");
        getCommand("contagion").setExecutor(new Commande());
        instance = this;
        BloodyPlayerList.getBloodyPlayerlist();
        EventsManager.registerEvents(this);
        ScoreBoardDisplayer.initialize();
        ContagionATTEND.start();

    }

    @Override
    public void onDisable() {
        ContagionCoffre.reset();
        System.out.println("[Contagion] --> plugin OFF");
    }

}