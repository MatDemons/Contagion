package fr.MatDemons.Contagion.utile;

import fr.MatDemons.Contagion.Contagion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ContagionZombie {

    public static void randomZombie(int LvL){
        for (int i = 0; i < BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayers().size(); i++) {
            CraftZombie zombie = null;
            Location loc = ContagionTeleport.Teleportation(zombie, Contagion.X_arene,Contagion.Z_arene,Contagion.R_arene+2,Contagion.R_arene+5);
            World world = Bukkit.getWorld("world");
            zombie = (CraftZombie) world.spawnEntity(loc, EntityType.ZOMBIE);
            zombie.setBaby(false);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,9999,   2));
            zombie.setCustomName("§5Zombie Affamé");
            zombie.getEquipment().clear();
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,9999,1));
            zombie.setNoDamageTicks(0);
        }
    }
}
