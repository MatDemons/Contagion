package fr.MatDemons.Contagion.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryMoveItem implements Listener {

    @EventHandler
    public void onInv(InventoryClickEvent e){
            e.setCancelled(true);
    }
}