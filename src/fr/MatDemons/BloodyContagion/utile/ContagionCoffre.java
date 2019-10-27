package fr.MatDemons.Contagion.utile;

import fr.MatDemons.Contagion.Contagion;
import org.bukkit.*;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

    public class ContagionCoffre{

        static ArrayList<Location> coffre = new ArrayList<>();

        public static void reset(){
                for (Location loc : coffre ){
                loc.getBlock().setType(Material.AIR);
            }
        }

        public static ItemStack create(Material material, int amount, ChatColor color, String name)
        {
            ItemStack item = new ItemStack(material, amount);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(color+name);
            item.setItemMeta(itemMeta);
            return item;
        }

    public static void randomCoffre(int val) {
            int y = 0;

        for (float i = 0; i < BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers().size(); i++) {
            Chest coffre = null;
            Location loc = ContagionTeleport.Teleportation((Entity) coffre, Contagion.X_arene, Contagion.Z_arene, 1, Contagion.R_arene);
            loc.add(0,-1,0);
            if (!(loc.getBlock().getType() == Material.GRASS)) {
                i--;y++;
                if ( y > 50)
                    return;
            } else {
                loc.add(0,1,0);
                loc.getBlock().setType(Material.CHEST);
                coffre = (Chest) loc.getBlock().getState();
                Inventory Inv = coffre.getInventory();

                ContagionCoffre.coffre.add(loc);

                Random r = new Random();

                int value = r.nextInt(100) - (val - 120);

                //AXE
                if (value > 99) {
                    Inv.setItem(1, create(Material.DIAMOND_AXE, 1, ChatColor.DARK_AQUA, "Pompe"));
                } else if (value < 99 && value > 95) {
                    Inv.setItem(2, create(Material.GOLD_AXE, 1, ChatColor.GOLD, "Pompe"));
                } else if (value < 95 && value > 85) {
                    Inv.setItem(3, create(Material.IRON_AXE, 1, ChatColor.DARK_PURPLE, "Pompe"));
                } else if (value < 85 && value > 70) {
                    Inv.setItem(4, create(Material.STONE_AXE, 1, ChatColor.GREEN, "Pompe"));
                } else if (value < 70 && value > 40) {
                    Inv.setItem(5, create(Material.WOOD_AXE, 1, ChatColor.DARK_GRAY, "Pompe"));
                }

                value = r.nextInt(100) - (val - 120);

                // sword
                if (value > 99) {
                    Inv.setItem(1, create(Material.DIAMOND_SWORD, 1, ChatColor.DARK_AQUA, "Couteau"));
                } else if (value < 99 && value > 95) {
                    Inv.setItem(2, create(Material.GOLD_SWORD, 1, ChatColor.GOLD, "Couteau"));
                } else if (value < 95 && value > 85) {
                    Inv.setItem(3, create(Material.IRON_SWORD, 1, ChatColor.DARK_PURPLE, "Couteau"));
                } else if (value < 85 && value > 70) {
                    Inv.setItem(4, create(Material.STONE_SWORD, 1, ChatColor.GREEN, "Couteau"));
                } else if (value < 70 && value > 40) {
                    Inv.setItem(5, create(Material.WOOD_SWORD, 1, ChatColor.DARK_GRAY, "Couteau"));
                }


                value = r.nextInt(100) - (val - 120);

                // HOE
                if (value > 99) {
                    Inv.setItem(1, create(Material.DIAMOND_HOE, 1, ChatColor.DARK_AQUA, "Mitraillette"));
                } else if (value < 99 && value > 95) {
                    Inv.setItem(2, create(Material.GOLD_HOE, 1, ChatColor.GOLD, "Mitraillette"));
                } else if (value < 95 && value > 85) {
                    Inv.setItem(3, create(Material.IRON_HOE, 1, ChatColor.DARK_PURPLE, "Mitraillette"));
                } else if (value < 85 && value > 70) {
                    Inv.setItem(4, create(Material.STONE_HOE, 1, ChatColor.GREEN, "Mitraillette"));
                } else if (value < 70 && value > 40) {
                    Inv.setItem(5, create(Material.WOOD_HOE, 1, ChatColor.DARK_GRAY, "Mitraillette"));
                }

                value = r.nextInt(100) - (val - 120);

                // SPADE
                if (value > 99) {
                    Inv.setItem(1, create(Material.DIAMOND_SPADE, 1, ChatColor.DARK_AQUA, "Pistolet"));
                } else if (value < 99 && value > 95) {
                    Inv.setItem(2, create(Material.GOLD_SPADE, 1, ChatColor.GOLD, "Pistolet"));
                } else if (value < 95 && value > 85) {
                    Inv.setItem(3, create(Material.IRON_SPADE, 1, ChatColor.DARK_PURPLE, "Pistolet"));
                } else if (value < 85 && value > 70) {
                    Inv.setItem(4, create(Material.STONE_SPADE, 1, ChatColor.GREEN, "Pistolet"));
                } else if (value < 70 && value > 40) {
                    Inv.setItem(5, create(Material.WOOD_SPADE, 1, ChatColor.DARK_GRAY, "Pistolet"));
                }


                value = r.nextInt(100) - (val - 120);

                // PICKAXE
                if (value > 99) {
                    Inv.setItem(1, create(Material.DIAMOND_PICKAXE, 1, ChatColor.DARK_AQUA, "Sniper"));
                } else if (value < 99 && value > 95) {
                    Inv.setItem(2, create(Material.GOLD_PICKAXE, 1, ChatColor.GOLD, "Sniper"));
                } else if (value < 95 && value > 85) {
                    Inv.setItem(3, create(Material.IRON_PICKAXE, 1, ChatColor.DARK_PURPLE, "Sniper"));
                } else if (value < 85 && value > 70) {
                    Inv.setItem(4, create(Material.STONE_PICKAXE, 1, ChatColor.GREEN, "Sniper"));
                } else if (value < 70 && value > 40) {
                    Inv.setItem(5, create(Material.WOOD_PICKAXE, 1, ChatColor.DARK_GRAY, "Sniper"));
                }

                Inv.setItem(6, create(Material.DIAMOND, 1, ChatColor.DARK_RED, "Potion de Heal"));

                value = r.nextInt(100) - (val - 120);
                if (value > 50) {
                    Inv.setItem(6, create(Material.GOLD_INGOT, 1, ChatColor.DARK_RED, "¨Potion de Speed"));
                }
            }
        }
    }
}
