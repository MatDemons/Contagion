package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.game.ContagionState;
import fr.MatDemons.Contagion.utile.*;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onInterract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        Block b = e.getClickedBlock();
        ItemStack it = e.getItem();
        Inventory Inv = p.getInventory();
        if (ContagionState.getState() == ContagionState.GAME) {
            if (p.getGameMode().equals(GameMode.SURVIVAL)) {
                if (e.getItem() != null) {
                    switch (e.getItem().getType()) {
                        case GOLD_INGOT:
                            if (it.getAmount() >= 2) {
                                if (!p.hasPotionEffect(PotionEffectType.SPEED)) {
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 1));
                                    it.setAmount(it.getAmount() - 1);
                                } else {
                                    util.sendActionText(p, ChatColor.DARK_AQUA+"Vous être déja en Speed");
                                }
                            } else {
                                util.sendActionText(p, ChatColor.DARK_AQUA+"Vous n'avez pas assez de Potion Speed");
                            }
                            break;
                        case DIAMOND:
                            if (it.getAmount() >= 2) {
                                if (p.getHealth() <= 18) {
                                    p.setHealth(2 + p.getHealth());
                                    it.setAmount(it.getAmount() - 1);
                                } else if (p.getHealth() <= 19) {
                                    p.setHealth(1 + p.getHealth());
                                    it.setAmount(it.getAmount() - 1);
                                } else {
                                    util.sendActionText(p, ChatColor.DARK_AQUA+"Votre vie est au max");
                                }
                            } else {
                                util.sendActionText(p, ChatColor.DARK_AQUA+"Vous n'avez pas assez de Potion Heal");
                            }
                            break;
                    }
                    if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) { // Clic droit
                        BloodyPlayer bp = BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(e.getPlayer());
                        Material mat = e.getMaterial();
                        if (mat != null && WeaponManager.bloodyArmes.containsKey(mat)) { // EST une arme
                            Weapon leWeaponUtilise = WeaponManager.bloodyArmes.get(mat); // get le weapon CUSTOM

                            if (!bp.getAmmos().containsKey(leWeaponUtilise)) {
                                bp.getAmmos().put(leWeaponUtilise, leWeaponUtilise.getAmmo());
                            }
                            if (leWeaponUtilise.getnumberofprojectile() > 0) {
                                if (bp.getAmmos().get(leWeaponUtilise) > 0) {

                                    // assez de mun

                                    // Il a tiré une fois / une rafale
                                    // I. Il n'a jamais tiré avec l'arme
                                    if (!bp.getWeaponsCooldowns().containsKey(leWeaponUtilise)) {
                                        bp.getWeaponsCooldowns().put(leWeaponUtilise, (long) 0);
                                    }

                                    // II. Il a déjà tiré
                                    // Calculer si il PEUT tirer ou non
                                    double cooldown = leWeaponUtilise.getCooldownInMillis();
                                    // Si PRESENT - PASSE > 5000 ==> + de 5 secs sont passé --> Il peut tirer
                                    if (System.currentTimeMillis() - bp.getWeaponsCooldowns().get(leWeaponUtilise) > leWeaponUtilise.getCooldownInMillis()) {
                                        // IL PEUT TIRER, reset du cooldown
                                        bp.getAmmos().put(leWeaponUtilise, bp.getAmmos().get(leWeaponUtilise) - 1);
                                        util.sendActionText(p, ChatColor.DARK_AQUA+" Munition : (" + bp.getAmmos().get(leWeaponUtilise) + "/" + leWeaponUtilise.getAmmo() + ")");
                                        for (int i = 0; i < leWeaponUtilise.getnumberofprojectile(); i++) { // tirer autant de fois
                                            p.launchProjectile(Snowball.class);
                                        }
                                        bp.getWeaponsCooldowns().put(leWeaponUtilise, System.currentTimeMillis());
                                    } else {
                                        e.setCancelled(true);
                                    }
                                } else {
                                    util.sendActionText(p, ChatColor.DARK_AQUA+"=== RECHAGEMENT ===");

                                    if (!bp.getReload().containsKey(leWeaponUtilise)) {
                                        bp.getReload().put(leWeaponUtilise, true);
                                    }

                                    if (bp.getReload().get(leWeaponUtilise)) {
                                        bp.getReload().put(leWeaponUtilise, false);
                                        int reloadTimeInMillis = 3000 / 1000;
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                e.setCancelled(true);
                                                bp.getAmmos().put(leWeaponUtilise, leWeaponUtilise.getAmmo());
                                                bp.getReload().put(leWeaponUtilise, true);
                                            }
                                        }.runTaskLater(Contagion.instance, reloadTimeInMillis * 20);
                                    }
                                }
                            }
                        }
                    }
                }
                if (a == Action.LEFT_CLICK_BLOCK || a == Action.RIGHT_CLICK_BLOCK) {
                    if (b.getType().equals(Material.CHEST)) {
                        b.setType(Material.AIR);
                    } else {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}