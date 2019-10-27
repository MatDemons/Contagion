package fr.MatDemons.Contagion.Events;

import fr.MatDemons.Contagion.game.ContagionState;
import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import fr.MatDemons.Contagion.utile.WeaponManager;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (ContagionState.getState() == ContagionState.GAME) {
            if (e.getDamager() instanceof Snowball) {
                Snowball s = (Snowball) e.getDamager();
                if (s.getShooter() instanceof Player) {
                    Player shooter = (Player) s.getShooter();
                    if(e.getEntity() instanceof Player) {
                        Player victim = (Player) e.getEntity();
                        if (!BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(victim).isAlive()) {
                            Material mat = shooter.getItemInHand().getType();
                            if(WeaponManager.bloodyArmes.containsKey(mat)) {
                                e.setDamage(WeaponManager.getDamage(mat));
                                if(victim.getHealth() - e.getDamage()  <= 0){
                                    BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(shooter).addKill();
                                }
                            }
                        }
                        else{
                            e.setCancelled(true);
                        }
                    }
                    else{
                        Material mat = shooter.getItemInHand().getType();
                        if(WeaponManager.bloodyArmes.containsKey(mat)) {
                            e.setDamage(WeaponManager.getDamage(mat));
                            if (e.getEntity().getType() == EntityType.ZOMBIE) {
                                Zombie z = (Zombie) e.getEntity();
                                if (z.getHealth() - e.getDamage() <= 0) {
                                    BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(shooter).addKill();
                                }
                            }
                        }
                    }
                }
            }
            else if(e.getDamager() instanceof  Player){
                Player shooter = (Player) e.getDamager();
                Material mat = shooter.getItemInHand().getType();
                if(e.getEntity() instanceof  Player){
                    Player victim = (Player) e.getEntity();
                    if (!BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(victim).isAlive()) {
                        if(WeaponManager.bloodyArmes.containsKey(mat)) {
                            e.setDamage(WeaponManager.getDamage(mat));
                            if (victim.getHealth() - e.getDamage() <= 0) {
                                BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(shooter).addKill();
                            }
                        }
                    }else{
                        e.setCancelled(true);
                    }
                }
                else{
                    if(WeaponManager.bloodyArmes.containsKey(mat)) {
                        e.setDamage(WeaponManager.getDamage(mat));
                        if (e.getEntity().getType() == EntityType.ZOMBIE) {
                            Zombie z = (Zombie) e.getEntity();
                            if (z.getHealth() - e.getDamage() <= 0) {
                                BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(shooter).addKill();
                            }
                        }
                    }
                }
            }
        }
        if (ContagionState.getState() == ContagionState.ATTEND){
            e.setCancelled(true);
        }
    }
}
