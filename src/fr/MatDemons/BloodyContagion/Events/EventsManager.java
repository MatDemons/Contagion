package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.Contagion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

    public static void registerEvents(Contagion pl) {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), pl);
        pm.registerEvents(new PlayerQuit(), pl);
        pm.registerEvents(new EntityDamageByEntity(), pl);
        pm.registerEvents(new PlayerInteract(),pl);
        pm.registerEvents(new PlayerDropItem(),pl);
        pm.registerEvents(new PlayerPickupItem(), pl);
        pm.registerEvents(new InventoryMoveItem(),pl);
        pm.registerEvents(new Combust(),pl);
        pm.registerEvents(new BlockBreak(),pl);
        pm.registerEvents(new PlayerDeath(),pl);
        pm.registerEvents(new FoodLevelChang(),pl);
        pm.registerEvents(new EntityDamage(),pl);
        pm.registerEvents(new EntityRegainHealth(),pl);
        pm.registerEvents(new EntityTargetLivingEntity(),pl);
    }
}
