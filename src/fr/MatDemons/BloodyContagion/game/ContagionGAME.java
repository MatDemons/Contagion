package fr.MatDemons.Contagion.game;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.utile.*;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ContagionGAME {

    private static int timer;
    public static int getTimer() {
        return timer;
    }

    public static ItemStack create(Material material, int amount)
    {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        item.setItemMeta(itemMeta);
        return item;
    }

    public static void start(){
        timer = 120;
        ContagionState.setState(ContagionState.GAME);

        Bukkit.getWorld("world").setTime(18000);
        Bukkit.getWorld( "world").setWeatherDuration(99999);
        for (Entity e : Bukkit.getWorld("world").getEntities()){
            if(!(e instanceof Player))
                e.isDead();
        }

        for (BloodyPlayer p : BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers()){
            Player pl = p.getPlayer();
            Inventory Inv = pl.getInventory();
            pl.setHealth(20);
            pl.setFoodLevel(20);

            if(BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(pl).isAlive()) {
                Inv.setItem(0, ContagionCoffre.create(Material.WOOD_SWORD, 1,ChatColor.DARK_GRAY,"Couteau"));
                Inv.setItem(1, ContagionCoffre.create(Material.WOOD_SPADE, 1,ChatColor.DARK_GRAY,"Pistolet"));
                Inv.setItem(7, ContagionCoffre.create(Material.DIAMOND, 1,ChatColor.DARK_RED,"Potion de Heal"));
                Inv.setItem(8, ContagionCoffre.create(Material.GOLD_INGOT, 1,ChatColor.DARK_RED,"¨Potion de Speed"));
            }
            ContagionTeleport.Teleportation(pl,595,-1562,0,26);
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if(timer%5 == 0) {
                    ContagionCoffre.randomCoffre(timer);
                    ContagionZombie.randomZombie(timer);
                }
                if (timer <= 0) {
                    Bukkit.broadcastMessage("§c§lLa partie est fini !");
                    Bukkit.broadcastMessage("§d§lQuelque survivant on réussi cet Enfer! ");
                    ContagionFIN.start();
                    cancel();
                    return;
                }
                if(BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers().size() == 0 || BloodyPlayerList.getBloodyPlayerlist().getAlivePlayerCount() == 0){
                    Bukkit.broadcastMessage("§c§lLa partie est fini !");
                    Bukkit.broadcastMessage("§d§lAucune survivant on réussi cet Enfer . . . ");
                    ContagionFIN.start();
                    timer = 120;
                    cancel();
                }
                else {
                    timer--;
                }
            }
        }.runTaskTimer(Contagion.instance, 0, 20);
    }
}
