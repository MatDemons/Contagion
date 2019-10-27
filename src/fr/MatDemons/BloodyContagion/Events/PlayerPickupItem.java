package fr.MatDemons.Contagion.Events;


import fr.MatDemons.Contagion.utile.WeaponManager;
import fr.MatDemons.Contagion.utile.WeaponType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPick(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        ItemStack itemDrop = e.getItem().getItemStack();
        Inventory Inv = p.getInventory();

        WeaponType typeDrop = WeaponManager.getType(itemDrop.getType());

        if (typeDrop != null) {
            for (ItemStack itemInventory : Inv) {
                if (itemInventory != null) {
                    WeaponType itemInventoryType = WeaponManager.getType(itemInventory.getType());
                    if (typeDrop.equals(itemInventoryType)) {

                        double weightDrop = WeaponManager.bloodyArmes.get(itemDrop.getType()).getWeight();
                        double weightInv = WeaponManager.bloodyArmes.get(itemInventory.getType()).getWeight();
                        if (weightDrop > weightInv) {
                            ItemMeta NouveauItem = itemDrop.getItemMeta();
                            NouveauItem.setDisplayName(NouveauItem.getDisplayName());
                            itemInventory.setItemMeta(NouveauItem);
                            itemInventory.setType(itemDrop.getType());
                            e.getItem().remove();
                            e.setCancelled(true);
                        } else if (weightDrop < weightInv) {
                            e.getItem().remove();
                            e.setCancelled(true);
                        }
                        else
                            e.setCancelled(true);
                    }
                }
            }
        }
        else if(itemDrop.getType() == Material.DIAMOND || itemDrop.getType() == Material.GOLD_INGOT){
            //TODO si > 64;
        }
        else{
            e.getItem().remove();
            e.setCancelled(true);
        }
    }
}
