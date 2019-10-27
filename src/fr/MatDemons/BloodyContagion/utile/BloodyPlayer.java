package fr.MatDemons.Contagion.utile;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class BloodyPlayer {

    private Player playerInstance;
    private boolean alive;
    private int kill;

    private HashMap<Weapon, Long> cooldowns;
    private HashMap<Weapon, Integer> ammos;
    private HashMap<Weapon, Boolean> Reload;

    public BloodyPlayer(Player instance) {
        this.cooldowns = new HashMap<>();
        this.ammos = new HashMap<>();
        this.Reload = new HashMap<>();
        this.playerInstance = instance;
        this.alive = true;
    }

    public int getKill() {
        return this.kill;
    }

    public void addKill(int kill) {
        this.kill += kill;
    }

    public void addKill() {
        this.kill++;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public  Player getPlayer() {
        return this.playerInstance;
    }

    public HashMap<Weapon, Boolean> getReload() {
        return this.Reload;
    }

    public HashMap<Weapon, Long> getWeaponsCooldowns() {
        return this.cooldowns;
    }

    public HashMap<Weapon, Integer> getAmmos() {
        return this.ammos;
    }
   }
